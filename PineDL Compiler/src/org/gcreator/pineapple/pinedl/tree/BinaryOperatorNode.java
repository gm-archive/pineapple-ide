/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author HP530
 */
public class BinaryOperatorNode extends ExpressionNode{
    public ExpressionNode left;
    public ExpressionNode right;
    
    public BinaryOperatorNode(){
        
    }
    
    public BinaryOperatorNode(Token t){
        super(t);
    }
}
