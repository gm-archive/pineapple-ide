/*
 * To change this template("template"), choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.lexer;

/**
 *
 * @author luis
 */
public enum Keyword{
    ARRAY("array"),
    BOOL("bool"),
    BREAK("break"),
    CALLEE("callee"),
    CASE("case"),
    CHAR("char"),
    CLASS("class"),
    CONST("const"),
    CONTINUE("continue"),
    DEFAULT("default"),
    DO("do"),
    ELSE("else"),
    EXTENDS("extends"),
    FALSE("false"),
    FINAL("final"),
    FOR("for"),
    FUNCTION("function"),
    IF("if"),
    IS("is"),
    NEW("new"),
    NULL("null"),
    NUMBER("number"),
    PRIVATE("private"),
    PROTECTED("protected"),
    PUBLIC("public"),
    RANGE("range"),
    REFERENCED("referenced"),
    RETURN("return"),
    STATIC("static"),
    STRING("string"),
    SUPER("super"),
    SWITCH("switch"),
    THIS("this"),
    TRUE("true"),
    TYPE("type"),
    VAR("var"),
    VIRTUAL("virtual"),
    WHILE("while");

    private final String keywordStr;

    Keyword(String str){
        keywordStr = str;
    }

    public String getKeyword(){
        return keywordStr;
    }

    public static Keyword findKeyword(String keyword){
        for(Keyword k : values()){
            if(k.getKeyword().equals(keyword)){
                return k;
            }
        }
        return null;
    }
}
