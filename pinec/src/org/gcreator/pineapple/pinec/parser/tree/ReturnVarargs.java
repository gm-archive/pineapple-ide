/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author Luís Reis
 */
public class ReturnVarargs extends Statement{
    public final Expression e;

    public ReturnVarargs(final Expression e){
        this.e = e;
    }

    @Override
    public String toString(){
        final StringBuilder str = new StringBuilder("return... ");
        str.append(e.toString());
        str.append(';');
        return str.toString();
    }
}
