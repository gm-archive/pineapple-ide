/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler.tree;

import pinedlcompiler.Token;

/**
 *
 * @author luis
 */
public class VariableReference extends Reference{
    public String varname = "";

    public VariableReference(Token t){
        super(t);
        varname = t.text;
    }
}
