/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler;

import java.util.List;
import java.util.Vector;
import pinedlcompiler.tree.ArgumentListNode;
import pinedlcompiler.tree.BlockNode;
import pinedlcompiler.tree.ClassContentNode;
import pinedlcompiler.tree.ClassNode;
import pinedlcompiler.tree.ConstructorNode;
import pinedlcompiler.tree.DocumentNode;
import pinedlcompiler.tree.Node;
import pinedlcompiler.tree.StatementNode;

/**
 *
 * @author Luís Reis
 */
public final class Parser {
    private Library library;
    private List<Token> tokens;
    private DocumentNode document;

    public static List<Token.Type> accessModifier = new Vector<Token.Type>();
    static{
        accessModifier.add(Token.Type.PUBLIC);
        accessModifier.add(Token.Type.PROTECTED);
        accessModifier.add(Token.Type.PRIVATE);
    }

    public class Return<T extends Node>{
        public int i = 0;
        public T node = null;

        public Return(){

        }

        public Return(int i, T node){
            this.i = i;
            this.node = node;
        }
    }

    public Parser(List<Token> tokens, Library library){
        this.library = library;
        this.tokens = tokens;
        document = null;
    }
    
    public void parse() throws ParserException{
        document = new DocumentNode();
        if(tokens.isEmpty()){
            return;
        }
        int i = 0;
        int tokensLength = tokens.size();
        while(i < tokensLength){

            Return r;
            r = parseClass(i);
            if(r!=null){
                i += r.i;
                document.content.add(r.node);
                continue;
            }

            r = parseFunction(i);
            if(r!=null){
                i += r.i;
                document.content.add(r.node);
                continue;
            }

            throw buildException(tokens.get(i), "Unexpected token.");
        }
    }

    public Return parseClass(int i) throws ParserException{
        Token t = tokens.get(i);
        if(t.type==Token.Type.CLASS){
            i++;
            ClassNode n = new ClassNode(t);
            t = demandToken(i++, Token.Type.WORD);
            n.name = t.text;
            t = demandToken(i);
            if(t.type==Token.Type.EXTENDS){
                t = demandToken(++i, Token.Type.WORD);
                n.base = t.text;
                t = demandToken(i++);
            }
            Return<ClassContentNode> content = parseClassContent(i);
            i += content.i;
            n.content = content.node;
            return new Return(i, n);
        }
        return null;
    }

    /**
     * @param i
     * @return the result. Never null.
     * @throws ParserException If matching failed
     */
    public Return<ClassContentNode> parseClassContent(int i) throws ParserException{
        ClassContentNode node = new ClassContentNode(demandToken(i++, Token.Type.BLKBEG));
        Token t;
        while(true){
            t = demandToken(i++);
            if(t.type==Token.Type.BLKEND){
                return new Return<ClassContentNode>(i, node);
            }
            Return<ConstructorNode> c = parseConstructor(i);
            if(c!=null){
                i = c.i;
                node.addConstructor(c.node);
                continue;
            }
            throw todo("parseClassContent");
        }
    }

    public Return<ConstructorNode> parseConstructor(int i) throws ParserException{
        Token accessToken = demandToken(i++);
        Token t = accessToken;
        Token.Type access = Token.Type.PUBLIC;
        if(accessModifier.contains(accessToken.type)){
            access = accessToken.type;
            t = demandToken(i++);
        }
        if(t.type!=Token.Type.THIS){
            return null;
        }
        ConstructorNode constr = new ConstructorNode(t);
        constr.accessModifier = accessToken;
        ArgumentListNode arglist = new ArgumentListNode(demandToken(i++, Token.Type.LPAREN));
        constr.arguments = arglist;

        boolean isFirst = true;

        t = demandToken(i++);
        while(true){
            if(t.type==Token.Type.RPAREN){
                break;
            }
            if(!isFirst){
                demandType(t, Token.Type.COMMA);
                t = demandToken(i++, Token.Type.WORD);
            }
            isFirst = false;
            ArgumentListNode.Argument arg = new ArgumentListNode.Argument();
            arg.name = t.text;
            arglist.arguments.add(arg);
            t = demandToken(i++);
            if(t.type==Token.Type.EQUAL){
                throw todo("Default arguments not yet implemented");
            }
            if(t.type==Token.Type.VARARGS){
                arg.varargs = true;
                t = demandToken(i++);
            }
        }

        Return<StatementNode> r = parseStatement(i, true);
        if(r==null){
            throw buildException(t, "Invalid constructor content");
        }
        i = r.i;
        constr.content = r.node;
        return new Return<ConstructorNode>(i, constr);
    }

    public Return<StatementNode> parseStatement(int i, boolean firstInConstructor) throws ParserException{
        Return<BlockNode> r = parseBlockStatement(i, firstInConstructor);
        if(r!=null){
            return new Return<StatementNode>(r.i, r.node);
        }
        throw todo("parseStatement");
    }

    public Return<BlockNode> parseBlockStatement(int i, boolean firstInConstructor) throws ParserException{
        Token t = demandToken(i++);
        if(t.type!=Token.Type.BLKBEG){
            return null;
        }
        BlockNode blk = new BlockNode(t);
        while(true){
            t = demandToken(i);
            if(t.type==Token.Type.BLKEND){
                return new Return<BlockNode>(i, blk);
            }
            Return<StatementNode> r = parseStatement(i, firstInConstructor);
            if(r==null){
                throw buildException(t, "Invalid expression.");
            }
            i = r.i;
            blk.statements.add(r.node);
            firstInConstructor = false;
        }
    }

    public Return parseFunction(int i) throws ParserException{
        throw todo("parseFunction");
    }

    public ParserException todo(String function){
        return new ParserException("[TODO] " + function);
    }

    public Token demandToken(int i) throws ParserException{
        if(i>=tokens.size()){
            throw new ParserException("Unexpected end of file");
        }
        return tokens.get(i);
    }

    public Token demandToken(int i, Token.Type type) throws ParserException{
        if(i>=tokens.size()){
            throw new ParserException("Unexpected end of file");
        }
        Token t = tokens.get(i);
        demandType(t, type);
        return t;
    }

    public Token demandToken(int i, List<Token.Type> types) throws ParserException{
        if(i>=tokens.size()){
            throw new ParserException("Unexpected end of file");
        }
        Token t = tokens.get(i);
        demandType(t, types);
        return t;
    }

    public void demandType(Token token, Token.Type type) throws ParserException{
        Token.Type ttype = token.type;
        if(ttype!=type){
            throw buildException(token, "Expected token of type " + type +
                    ". Instead, got " + token);
        }
    }

    public void demandType(Token token, List<Token.Type> types) throws ParserException{
        Token.Type ttype = token.type;
        if(!types.contains(ttype)){
            throw buildException(token, "Wrong token type " + token);
        }
    }

    public ParserException buildException(Token token, String message){
        return new ParserException("In line " + token.line + ":\n\t"
                + message);
    }

    public DocumentNode getDocumentNode(){
        return document;
    }
}
