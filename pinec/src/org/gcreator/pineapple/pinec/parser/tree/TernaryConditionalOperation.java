/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author Luís Reis
 */
public class TernaryConditionalOperation extends Expression{
    public final Expression condition, thenCase, elseCase;

    public TernaryConditionalOperation(final Expression condition,
            final Expression thenCase, final Expression elseCase){

        this.condition = condition;
        this.thenCase = thenCase;
        this.elseCase = elseCase;
    }

    @Override
    public String toString(){
        final StringBuilder str = new StringBuilder("(");
        str.append(condition.toString());
        str.append(") ^ (");
        str.append(thenCase.toString());
        str.append(") : (");
        str.append(elseCase.toString());
        str.append(")");
        return str.toString();
    }
}
