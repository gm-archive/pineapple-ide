/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import org.gcreator.pineapple.pinec.parser.support.Argument;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class ArgumentList extends Leaf{
    public final List<Argument> arguments = new Vector<Argument>();

    @Override
    public String toString(){
        final StringBuilder b = new StringBuilder(arguments.size());

        boolean first = true;
        for(Argument arg : arguments){
            if(first){
                first = false;
            }
            else{
                b.append(", ");
            }

            b.append(arg.toString());
        }

        return b.toString();
    }
}
