/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.lexer;

/**
 *
 * @author luis
 */
public enum Operator {

    /**
     * Operator .
    */
    DOT("."),
    /**
     * Operator :
    */
    COLON(":"),
    /**
     * Operator ,
    */
    COMMA(","),
    /**
     * Operator ;
    */
    SEMICOLON(";"),
    /**
     * Operator {
    */
    CBO("{"),
    /**
     * Operator }
    */
    CBC("}"),
    /**
     * Operator [
    */
    SBO("["),
    /**
     * Operator ]
    */
    SBC("]"),
    /**
     * Operator (
    */
    NBO("("),
    /**
     * Operator )
    */
    NBC(")"),
    /**
     * Operator +
    */
    PLUS("+"),
    /**
     * Operator -
    */
    MINUS("-"),
    /**
     * Operator *
    */
    MULT("*"),
    /**
     * Operator /
    */
    DIV("/"),
    /**
     * Operator %
    */
    MOD("%"),
    /**
     * Operator &
    */
    BITAND("&"),
    /**
     * Operator |
    */
    BITOR("|"),
    /**
     * Operator ^
    */
    BITXOR("^"),
    /**
     * Operator ~
    */
    BITNOT("~"),
    /**
     * Operator &&
    */
    LOGAND("&&"),
    /**
     * Operator ||
    */
    LOGOR("||"),
    /**
     * Operator !
    */
    LOGNOT("!"),
    /**
     * Operator =
    */
    ASSIGN("="),
    /**
     * Operator ==
    */
    EQUALS("=="),
    /**
     * Operator !=
    */
    NOTEQUAL("!="),
    /**
     * Operator &gt;
    */
    GREATER(">"),
    /**
     * Operator &gt;=
    */
    GTE(">="),
    /**
     * Operator &lt;
    */
    SMALLER("<"),
    /**
     * Operator &lt;=
    */
    SME("<="),
    /**
     * Operator ++
    */
    INCREMENT("++"),
    /**
     * Operator --
    */
    DECREMENT("--"),
    /**
     * Operator +=
    */
    PLUSASSIGN("+="),
    /**
     * Operator -=
    */
    MINUSASSIGN("-="),
    /**
     * Operator *=
    */
    MULTASSIGN("*="),
    /**
     * Operator /=
    */
    DIVASSIGN("/="),
    /**
     * Operator %=
    */
    MODASSIGN("%="),
    /**
     * Operator &=
    */
    BITANDASSIGN("&="),
    /**
     * Operator |=
    */
    BITORASSIGN("|="),
    /**
     * Operator ^=
    */
    BITXORASSIGN("^="),
    /**
     * Operator &&=
    */
    LOGANDASSIGN("&&="),
    /**
     * Operator ||=
    */
    LOGORASSIGN("||="),
    /**
     * Operator ..
    */
    RANGE(".."),
    /**
     * Operator ?
    */
    QMARK("?"),
    /**
     * Operator &lt;&lt;
    */
    RSHIFT("<<"),
    /**
     * Operator &gt;&gt;
    */
    LSHIFT(">>"),
    /**
     * Operator &lt;&lt;=
    */
    RSEQ("<<="),
    /**
     * Operator &gt;&gt;=
    */
    LSEQ(">>="),
    /**
     * Operator ...
     */
    VARARGS("...");

    private final String str;

    Operator(final String str){
       this.str = str;
    }

    public String getStringRepresentation(){
       return str;
    }
}
