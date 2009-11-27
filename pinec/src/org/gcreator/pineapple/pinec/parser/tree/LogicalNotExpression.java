package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author Luís Reis
 */
public class LogicalNotExpression extends Expression{
    final Expression other;
    public LogicalNotExpression(final Expression other){
        this.other = other;
    }

    @Override
    public boolean hasSideEffects(){
        return other.hasSideEffects();
    }

    @Override
    public String toString(){
        return "!(" + other.toString() + ")";
    }
}
