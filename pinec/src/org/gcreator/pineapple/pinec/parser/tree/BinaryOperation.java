/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public class BinaryOperation extends Expression{
    private final Expression left, right;
    public BinaryOperation(final Expression left, final Expression right){
        this.left = left;
        this.right = right;
    }

    public Expression getLeftExpression(){
        return left;
    }

    public Expression getRightExpression(){
        return right;
    }

    @Override
    public boolean hasSideEffects(){
        return getLeftExpression().hasSideEffects() || getRightExpression().hasSideEffects();
    }
}
