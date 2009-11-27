/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author Luís Reis
 */
public class GreaterThanOperator extends BinaryOperation{
    public final boolean orEqual; //true for >=, false for >

    public GreaterThanOperator(final Expression left, final Expression right,
            final boolean orEqual){

        super(left, right);
        this.orEqual = orEqual;
    }

    @Override
    public String toString(){
        final StringBuilder str = new StringBuilder("(");
        str.append(getLeftExpression().toString());
        str.append(") ");
        if(orEqual){
            str.append(">=");
        }
        else{
            str.append(">");
        }
        str.append(" (");
        str.append(getRightExpression().toString());
        str.append(")");
        return str.toString();
    }
}
