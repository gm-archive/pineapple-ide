/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import org.gcreator.pineapple.pinec.lexer.Keyword;
import org.gcreator.pineapple.pinec.lexer.Token;

/**
 *
 * @author luis
 */
public class BooleanConstant extends Constant{
    public final boolean value;

    public BooleanConstant(final Token token){
        this(token.getKeyword()==Keyword.TRUE);

        line = token.getLine();
        col = token.getCol();
    }

    public BooleanConstant(final boolean value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value?"true":"false";
    }
}
