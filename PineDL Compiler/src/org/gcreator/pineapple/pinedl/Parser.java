/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl;

import java.util.List;
import java.util.Vector;
import org.gcreator.pineapple.pinedl.tree.ArgumentListNode;
import org.gcreator.pineapple.pinedl.tree.BlockNode;
import org.gcreator.pineapple.pinedl.tree.BooleanConstant;
import org.gcreator.pineapple.pinedl.tree.CharConstant;
import org.gcreator.pineapple.pinedl.tree.ClassContentNode;
import org.gcreator.pineapple.pinedl.tree.ClassNode;
import org.gcreator.pineapple.pinedl.tree.ConstantNode;
import org.gcreator.pineapple.pinedl.tree.ConstructorNode;
import org.gcreator.pineapple.pinedl.tree.DeclarationNode;
import org.gcreator.pineapple.pinedl.tree.DocumentNode;
import org.gcreator.pineapple.pinedl.tree.ExpressionNode;
import org.gcreator.pineapple.pinedl.tree.MethodNode;
import org.gcreator.pineapple.pinedl.tree.Node;
import org.gcreator.pineapple.pinedl.tree.Reference;
import org.gcreator.pineapple.pinedl.tree.StatementNode;
import org.gcreator.pineapple.pinedl.tree.StringConstant;
import org.gcreator.pineapple.pinedl.tree.VariableReference;

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

    public class StatementContext{
        public boolean firstInConstructor = false;

        public StatementContext(){

        }

        public StatementContext(StatementContext other){
            if(other==null) throw new NullPointerException("Argument mustn't be null");
            this.firstInConstructor = other.firstInConstructor;
        }

        public StatementContext notFirst(){
            StatementContext c = new StatementContext(this);
            c.firstInConstructor = false;
            return c;
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

    public Return<ClassNode> parseClass(int i) throws ParserException{
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
            i = content.i;
            n.content = content.node;
            return new Return<ClassNode>(i, n);
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
            Return<MethodNode> m = parseMethod(i);
            if(m!=null){
                i = m.i;
                node.addMethod(m.node);
                continue;
            }
            throw todo("parseClassContent: Fields and nested classes");
        }
    }

    public Return<ConstructorNode> parseConstructor(int i) throws ParserException{
        //TODO: Fix access modifier token
        Token accessToken = demandToken(i++);
        Token t = accessToken;
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
            else{
                demandType(t, Token.Type.WORD);
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
                t = demandToken(i++, Token.Type.RPAREN);
                break;
            }
        }

        StatementContext c = new StatementContext();
        c.firstInConstructor = true;
        Return<StatementNode> r = parseStatement(i, c);
        if(r==null){
            throw buildException(t, "Invalid constructor content");
        }
        i = r.i+1;
        constr.content = r.node;
        return new Return<ConstructorNode>(i, constr);
    }

    public Return<ConstantNode> parseConstant(int i) throws ParserException{
        Token constToken = demandToken(i++);
        if(constToken.type==Token.Type.TRUE||constToken.type==Token.Type.FALSE){
            return new Return<ConstantNode>(i, new BooleanConstant(constToken));
        }
        if(constToken.type==Token.Type.CHARCONST){
            return new Return<ConstantNode>(i, new CharConstant(constToken));
        }
        if(constToken.type==Token.Type.STRINGCONST){
            return new Return<ConstantNode>(i, new StringConstant(constToken));
        }
        return null;
        //The following todo error is commented to allow progress
        //in other areas
        //throw todo("null constant, this constant, super constant?,
        //type constants and numeric constants");
    }

    public Return<Reference> parseReference(int i) throws ParserException{
        Token ref = demandToken(i++);
        if(ref.type!=Token.Type.WORD){
            return null;
        }
        String name = ref.text;
        if(!hasTokensLeft(i)){
            return new Return<Reference>(i, new VariableReference(ref));
        }
        Token t = demandToken(i++);
        if(t.type==Token.Type.LPAREN){
            throw todo("parseReference: function");
        }
        return new Return<Reference>(i-1, new VariableReference(ref));
        //Composed references like a.b are handled elsewhere.
    }

    public Return<Reference> parseComposedReference(int i) throws ParserException{
        //todo: super() statements
        //todo: new X() and [1, 2, 3] statements
        Return<ConstantNode> c = parseConstant(i);
        Reference r = null;
        if(c==null){
            Return<Reference> ref = parseReference(i);
            if(ref==null){
                return null;
            }
            i = ref.i;
            r = ref.node;
        }
        else{
            r = c.node;
            i = c.i;
        }
        while(true){
            if(!hasTokensLeft(i)){
                return new Return<Reference>(i, r);
            }

            Token t = demandToken(i++);
            if(t.type!=Token.Type.DOT){
                return new Return<Reference>(i, r);
            }

            //Call parseReference again
            //Then create composed reference
            //And proceed with the loop again
            throw todo("parseComposedReference");
        }
    }

    public Return<ExpressionNode> parsePrimitive(int i) throws ParserException{
        Token t = demandToken(i);
        if(t.type==Token.Type.PLUS){
            i++;
        }
        else if(t.type==Token.Type.MINUS){
            throw todo("negation"); //Implement stuff like '-x'
        }
        else if(t.type==Token.Type.LPAREN){
            i++;
            Return<ExpressionNode> exp = parseExpression(i);
            if(exp==null){
                return null;
            }
            demandToken(i++, Token.Type.RPAREN);
            return new Return<ExpressionNode>(i, exp.node);
        }
        Return<ConstantNode> con = parseConstant(i);
        if(con!=null){
            return (Return) con; //I believe that, in this case
                                //this operation is safe
        }
        Return<Reference> ref = parseComposedReference(i);
        if(ref!=null){
            return (Return) ref;
        }
        return null;
    }

    public Return<ExpressionNode> parsePrePostOperator(int i) throws ParserException{
        Token t = demandToken(i++);
        if(t.type==Token.Type.INCREMENT){
            throw todo("++x operator");
        }
        else if(t.type==Token.Type.DECREMENT){
            throw todo("--x operator");
        }
        i--;
        Return<ExpressionNode> primitive = parsePrimitive(i);
        if(primitive==null){
            return null;
        }
        i = primitive.i;
        t = demandToken(i++);
        if(t.type==Token.Type.INCREMENT){
            throw todo("x++ operator");
        }
        else if(t.type==Token.Type.DECREMENT){
            throw todo("x-- operator");
        }
        i--;
        return primitive;
    }
    
    public Return<ExpressionNode> parseNotCast(int i) throws ParserException{
        Token t = demandToken(i++);
        if(t.type==Token.Type.LOGICAL_NOT){
            throw todo("Logical not operator");
        }
        else if(t.type==Token.Type.LPAREN){
            //Eventually try to handle casts here
        }
        i--;
        return parsePrePostOperator(i);
    }
    
    public Return<ExpressionNode> parseExpression(int i) throws ParserException{
        //TODO
        return parsePrePostOperator(i);
    }

    public Return<MethodNode> parseMethod(int i) throws ParserException{
        Token accessToken = demandToken(i++);
        Token t = accessToken;
        Token.Type access = Token.Type.PUBLIC;
        if(accessModifier.contains(accessToken.type)){
            access = accessToken.type;
            t = demandToken(i++);
        }
        if(t.type!=Token.Type.FUNCTION){
            return null;
        }

        t = demandToken(i++, Token.Type.WORD);
        MethodNode method = new MethodNode(t);
        method.name = t.text;
        method.accessModifier = accessToken;
        ArgumentListNode arglist = new ArgumentListNode(demandToken(i++, Token.Type.LPAREN));
        method.arguments = arglist;

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
            else{
                demandType(t, Token.Type.WORD);
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
                t = demandToken(i++, Token.Type.RPAREN);
                break;
            }
        }

        StatementContext c = new StatementContext();
        c.firstInConstructor = true;
        Return<StatementNode> r = parseStatement(i, c);
        if(r==null){
            throw buildException(t, "Invalid constructor content");
        }
        i = r.i+1;
        method.content = r.node;
        return new Return<MethodNode>(i, method);
    }

    public Return<StatementNode> parseStatement(int i, StatementContext context) throws ParserException{
        Return<BlockNode> r = parseBlockStatement(i, context);
        if(r!=null){
            return (Return) r;
        }
        Return<DeclarationNode> decl = parseDeclaration(i);
        if(decl!=null){
            return (Return) decl;
        }
        throw todo("parseStatement");
    }
    
    public Return<DeclarationNode> parseDeclaration(int i) throws ParserException{
        Token t = demandToken(i++);
        if(t.type!=Token.Type.VAR&&t.type!=Token.Type.CONST){
            return null;
        }
        DeclarationNode decl = new DeclarationNode(t);
        Token name = demandToken(i++, Token.Type.WORD);
        decl.name = name.text;
        Token next = demandToken(i++);
        if(next.type==Token.Type.SEMICOLON){
            if(t.type==Token.Type.CONST){
                //"var x;" is valid
                //but "const x;" is not
                throw buildException(next, "Constant declarations must have an associated value");
            }
            return new Return<DeclarationNode>(i, decl);
        }
        demandType(next, Token.Type.EQUAL); //var x ! 2; is invalid, for example
        Return<ExpressionNode> e = parseExpression(i);
        if(e==null){
            throw buildException(next, "Invalid expression");
        }
        i = e.i;
        decl.defaultValue = e.node;
        demandToken(i++, Token.Type.SEMICOLON);
        return new Return<DeclarationNode>(i, decl);
    }

    public Return<BlockNode> parseBlockStatement(int i, StatementContext context) throws ParserException{
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
            Return<StatementNode> r = parseStatement(i, context);
            if(r==null){
                throw buildException(t, "Invalid expression.");
            }
            i = r.i;
            blk.statements.add(r.node);
            context = context.notFirst();
        }
    }

    public Return parseFunction(int i) throws ParserException{
        throw todo("parseFunction");
    }

    public ParserException todo(String message){
        return new ParserException("[TODO] " + message);
    }

    public boolean hasTokensLeft(int i){
        return i<tokens.size();
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
