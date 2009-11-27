/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public class PrePostFixExpression extends Expression{
    public Expression base;

    public boolean prefix; //false for postfix
    public boolean increment; //false for decrement

    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder();

        if(prefix){
            builder.append(increment?"++":"--");
        }

        builder.append('(');
        builder.append(base.toString());
        builder.append(')');

        if(!prefix){
            builder.append(increment?"++":"--");
        }

        return builder.toString();
    }
}
