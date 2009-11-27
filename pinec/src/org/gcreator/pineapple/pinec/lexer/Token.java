/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.lexer;

/**
 *
 * @author luis
 */
public final class Token {
    private final TokenType type;
    private final int subtype;
    private final int line;
    private final int col;
    private final String content;
    
    public Token(TokenType type, int subtype, int line, int col, String content){
        this.type = type;
        this.subtype = subtype;
        this.line = line;
        this.col = col;
        this.content = content;
    }
    public Token(TokenType type, int line, int col, String content){
        this(type, 0, line, col, content);
    }


    public Token(Operator operator, int line, int col, String content){
        this(TokenType.OPERATOR, operator.ordinal(), line, col, content);
    }

    public Token(Keyword keyword, int line, int col, String content){
        this(TokenType.KEYWORD, keyword.ordinal(), line, col, content);
    }

    public Operator getOperator(){
        return Operator.values()[subtype];
    }

    public Keyword getKeyword(){
        return Keyword.values()[subtype];
    }
    
    public TokenType getType(){
        return type;
    }

    public int getLine(){
        return line;
    }

    public int getCol(){
        return col;
    }

    public String getContent(){
        return content;
    }

    public boolean is(Operator op){
        return getType()==TokenType.OPERATOR && getOperator()==op;
    }

    public boolean is(Keyword kw){
        return getType()==TokenType.KEYWORD && getKeyword()==kw;
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(getLine());
        b.append(':');
        b.append(getCol());
        b.append(":\t");
        b.append(getContent());
        b.append(" (");
        final TokenType t = getType();
        b.append(t);
        if(t==TokenType.KEYWORD){
            b.append(" - ");
            b.append(getKeyword());
        }
        else if(t==TokenType.OPERATOR){
            b.append(" - ");
            b.append(getOperator());
        }
        b.append(')');
        return b.toString();
    }
}
