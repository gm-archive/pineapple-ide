/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public class AssignOperation extends BinaryOperation{
    public AssignOperation(final Expression left, final Expression right){
        super(left, right);
    }

    @Override
    public boolean hasSideEffects(){
        return true;
    }
}
