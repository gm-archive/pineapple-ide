/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author Luís Reis
 */
public class BitwiseShiftOperation extends BinaryOperation{
    public final boolean leftShift; //true for <<, false for >>

    public BitwiseShiftOperation(final Expression left, final Expression right,
            final boolean isLeft){

        super(left, right);
        leftShift = isLeft;
    }

    @Override
    public String toString(){
        final StringBuilder str = new StringBuilder("(");
        str.append(getLeftExpression().toString());
        str.append(") ");
        if(leftShift){
            str.append("<<");
        }
        else{
            str.append(">>");
        }
        str.append(" (");
        str.append(getRightExpression().toString());
        str.append(")");
        return str.toString();
    }
}
