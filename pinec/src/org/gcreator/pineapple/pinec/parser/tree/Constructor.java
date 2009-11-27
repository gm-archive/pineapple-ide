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
public final class Constructor extends Leaf{
    private final Keyword t;
    public ArgumentList args;
    public Statement stmt;

    public Constructor(final Token token){
        line = token.getLine();
        col = token.getCol();
        t = token.getKeyword();
    }

    public Keyword getKeyword(){
        return t;
    }

    @Override
    public String toString(){
        final StringBuilder b = new StringBuilder(t.getKeyword());
        b.append(" new(");
        b.append(args.toString());
        b.append(")\n");
        b.append(stmt.toString());
        return b.toString();
    }
}
