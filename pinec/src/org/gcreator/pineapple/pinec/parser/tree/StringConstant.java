/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import org.gcreator.pineapple.pinec.lexer.Token;

/**
 *
 * @author luis
 */
public final class StringConstant extends Constant{
    public final String value;

    public StringConstant(final Token token){
        this.value = token.getContent();
        this.line = token.getLine();
        this.col = token.getCol();
    }

    @Override
    public String toString(){
        final StringBuilder b = new StringBuilder("\"");
        b.append(value.replaceAll("\\\\", "\\\\\\\\")
                .replaceAll("\\n", "\\\\n")
                .replaceAll("\\t", "\\\\t")
                .replaceAll("\\r", "\\\\r"));
        b.append("\"");
        return b.toString();
    }
}
