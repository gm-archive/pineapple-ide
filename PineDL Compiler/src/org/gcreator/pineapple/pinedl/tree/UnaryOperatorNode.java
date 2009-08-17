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
public class UnaryOperatorNode extends ExpressionNode{
    public ExpressionNode exp;
    
    public UnaryOperatorNode(){
        
    }
    
    public UnaryOperatorNode(Token t){
        super(t);
    }
}
