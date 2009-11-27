/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author Luís Reis
 */
public class EqualsOperator extends BinaryOperation{
    public final boolean negated; //true for !=, false for ==

    public EqualsOperator(final Expression left, final Expression right,
            final boolean negated){

        super(left, right);
        this.negated = negated;
    }

    @Override
    public String toString(){
        final StringBuilder str = new StringBuilder("(");
        str.append(getLeftExpression().toString());
        str.append(") ");
        if(negated){
            str.append("!=");
        }
        else{
            str.append("==");
        }
        str.append(" (");
        str.append(getRightExpression().toString());
        str.append(")");
        return str.toString();
    }
}
