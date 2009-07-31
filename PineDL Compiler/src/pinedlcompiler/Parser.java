/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler;

import java.util.List;
import pinedlcompiler.tree.ClassContentNode;
import pinedlcompiler.tree.ClassNode;
import pinedlcompiler.tree.DocumentNode;
import pinedlcompiler.tree.Node;

/**
 *
 * @author Luís Reis
 */
public class Parser {
    private Library library;
    private List<Token> tokens;
    private DocumentNode document;

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
            t = demandToken(i+1);
            if(t.type==Token.Type.EXTENDS){
                t = demandToken(++i, Token.Type.WORD);
                n.base = t.text;
                t = demandToken(i+1);
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
        demandToken(i++, Token.Type.BLKBEG);
        Token t;
        ClassContentNode node = new ClassContentNode();
        while(true){
            t = demandToken(i++);
            if(t.type==Token.Type.BLKEND){
                return new Return<ClassContentNode>(i, node);
            }

            throw todo("parseClassContent");
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

    public void demandType(Token token, Token.Type type) throws ParserException{
        Token.Type ttype = token.type;
        if(ttype!=type){
            throw buildException(token, "Expected token of type " + type +
                    ". Instead, got " + token);
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
