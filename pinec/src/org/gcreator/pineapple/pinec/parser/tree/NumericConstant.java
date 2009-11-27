/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import org.gcreator.pineapple.pinec.lexer.Token;

/**
 *
 * @author Luís Reis
 */
public final class NumericConstant extends Constant{
    public final float value;

    public NumericConstant(final Token token){
        this.value = Float.parseFloat(token.getContent());
        this.line = token.getLine();
        this.col = token.getCol();
    }

    @Override
    public String toString(){
        return Float.toString(value);
    }
}
