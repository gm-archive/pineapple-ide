/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author luis
 */
public class Node {
    /**
     * Token is the equivalent lexer output
     */
    public Token token = null;

    public Node(){

    }

    public Node(Token token){
        this.token = token;
    }

    public final int getLine(){
        return token.line;
    }

    public final Token.Type getTokenType(){
        if(token==null){
            return null;
        }
        return token.type;
    }
}
