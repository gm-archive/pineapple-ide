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
public class TernaryConditionalOperator extends ExpressionNode{
    public ExpressionNode condition;
    public ExpressionNode trueValue;
    public ExpressionNode falseValue;
    
    public TernaryConditionalOperator(){
        
    }
    
    public TernaryConditionalOperator(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        return "((" + condition + ") ? (" + trueValue + ") : (" + falseValue + ')';
    }
}
