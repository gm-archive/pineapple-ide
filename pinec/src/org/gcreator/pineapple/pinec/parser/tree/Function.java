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
public final class Function extends Leaf{
    private final Keyword t;
    private final String name;
    public ArgumentList args;
    public Statement stmt;
    public final boolean isStatic;

    public Function(final Token token, final String name, final boolean isStatic){
        line = token.getLine();
        col = token.getCol();
        t = token.getKeyword();
        this.name = name;
        this.isStatic = isStatic;
    }

    public String getName(){
        return name;
    }

    public Keyword getKeyword(){
        return t;
    }

    @Override
    public String toString(){
        final StringBuilder b = new StringBuilder(t.getKeyword());
        if(isStatic){
            b.append(" static");
        }
        b.append(" function ");
        b.append(name);
        b.append('(');
        b.append(args.toString());
        b.append(")\n");
        b.append(stmt.toString());
        return b.toString();
    }
}
