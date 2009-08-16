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
public class AssignNode extends ExpressionNode{
    public ExpressionNode lvalue;
    public ExpressionNode rvalue;
    
    public AssignNode(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        return lvalue.toString() + " = (" + rvalue.toString() + ')';
    }
}
