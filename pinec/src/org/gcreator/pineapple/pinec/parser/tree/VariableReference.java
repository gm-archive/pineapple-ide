/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import org.gcreator.pineapple.pinec.lexer.Token;

/**
 *
 * @author luis
 */
public class VariableReference extends Reference{

    public final String name;

    public VariableReference(Token token){
        line = token.getLine();
        col = token.getCol();
        name = token.getContent();
    }

    @Override
    public boolean hasSideEffects(){
        return false;
    }

    @Override
    public String toString(){
        return name;
    }
}
