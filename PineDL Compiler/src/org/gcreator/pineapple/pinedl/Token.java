/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl;

/**
 *
 * @author luis
 */
public final class Token{
    public Type type = Type.UNDEFINED;
    public String text = "";
    public int line = -1;
    
    public Token(int line){
        this.line = line;
    }
    
    public enum Type{
        UNDEFINED,
        
        //Keywords
        IF,
        ELSE,
        WHILE,
        FOR,
        CLASS,
        FUNCTION,
        VAR,
        CONST,
        PUBLIC,
        PROTECTED,
        PRIVATE,
        NUMBER,
        CHAR,
        BOOL,
        STRING,
        VOID,
        TYPE,
        RANGE,
        TRY,
        CATCH,
        THROW,
        RETURN,
        BREAK,
        CONTINUE,
        TRUE,
        FALSE,
        NULL,
        EXTENDS,
        IS,
        NEW,
        THIS,
        SUPER,
        
        //Constants
        INTCONST,
        FLOATCONST,
        CHARCONST,
        STRINGCONST,
        
        //Ordinary words
        WORD,
        
        //Comments and whitespaces
        //WHITESPACE,
        //LINEBREAK,
        //SLCOMMENT,
        //MLCOMMENT,
        //NESTEDCOMMENT,
        
        //Signs
        EQUAL, //=
        PLUS, //+
        INCREMENT, //++
        PLUSEQUAL, //+=
        MINUS,
        DECREMENT,
        MINUSEQUAL,
        MULT,
        MULTEQUAL,
        DIV,
        DIVEQUAL,
        MOD,
        MODEQUAL,
        BITWISE_AND,
        BITWISE_ANDEQUAL,
        BITWISE_OR,
        BITWISE_OREQUAL,
        BITWISE_XOR,
        BITWISE_XOREQUAL,
        LSHIFT,
        LSHIFT_EQUAL, //<<=
        RSHIFT,
        RSHIFT_EQUAL, //>>=
        LOGICAL_AND,
        LOGICAL_ANDEQUAL,
        LOGICAL_OR,
        LOGICAL_OREQUAL,
        LOGICAL_XOR,
        QUESTIONMARK, //?
        /**
         * :
         */
        COLON,
        /**
         * ,
         */
        COMMA,
        /**
         * .
         */
        DOT,
        /**
         * ...
         */
        VARARGS,
        /**
         * ;
         */
        SEMICOLON,
        LOWER, //<
        LOWEREQUAL, //<=
        EQUALS, //==
        GREATER,
        GREATEREQUAL,
        NOTEQUAL, //!=
        BITWISE_NOT, //~
        LOGICAL_NOT, //!
        KEYASSIGN, //=>
        
        //Parenthesis, etc
        LPAREN, //(
        RPAREN, //)
        LARRAY, //[
        RARRAY, //]
        BLKBEG, //{
        BLKEND, //}
    }
    
    @Override
    public String toString(){
        return "" + line + ": Token <" + text + ">(" + type + ")";
    }
}
