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
public class LogicalNotNode extends UnaryOperatorNode{
    public LogicalNotNode(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        return "!(" + exp + ")";
    }
}
