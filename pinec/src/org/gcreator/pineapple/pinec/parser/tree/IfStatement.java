package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author Luís Reis
 */
public class IfStatement extends Statement{
    public Expression condition;
    public Statement ifCase;
    public Statement elseCase;

    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder("if(");
        builder.append(condition.toString());
        builder.append(")\n");
        builder.append(ifCase.toString());
        if(elseCase!=null){
            builder.append("\nelse\n");
            builder.append(elseCase.toString());
        }
        return builder.toString();
    }
}
