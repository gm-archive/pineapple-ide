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
public class SumNode extends ExpressionNode{
    public ExpressionNode left;
    public ExpressionNode right;
    /**
     * true for +, false for -
     */
    public boolean add = true;
    
    public SumNode(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        return '(' + left.toString() + ") " + (add?'+':'-') + " (" + right.toString() + ')';
    }
}
