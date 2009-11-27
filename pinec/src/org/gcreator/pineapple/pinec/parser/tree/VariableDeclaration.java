/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import org.gcreator.pineapple.pinec.parser.support.Variable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class VariableDeclaration extends Statement{
    public final List<Variable> arguments = new Vector<Variable>();

    @Override
    public String toString(){
        final StringBuilder b = new StringBuilder(arguments.size());

        boolean first = true;
        for(Variable var : arguments){
            if(first){
                first = false;
            }
            else{
                b.append(", ");
            }

            b.append(var.toString());
        }
        b.append(";");
        return b.toString();
    }
}
