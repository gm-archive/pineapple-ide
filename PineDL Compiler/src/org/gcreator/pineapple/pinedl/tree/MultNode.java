/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author Luís Reis
 */
public class MultNode extends BinaryOperatorNode{
    public MultNode(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        return "(" + left + ") * (" + right + ')';
    }
}
