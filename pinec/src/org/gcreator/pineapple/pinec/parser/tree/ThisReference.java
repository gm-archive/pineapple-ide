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
public class ThisReference extends Reference{

    public ThisReference(Token token){
        line = token.getLine();
        col = token.getCol();
    }

    @Override
    public boolean hasSideEffects(){
        return false;
    }
}
