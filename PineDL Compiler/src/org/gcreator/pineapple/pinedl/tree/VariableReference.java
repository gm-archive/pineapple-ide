/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import org.gcreator.pineapple.pinedl.Token;

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
    
    @Override
    public String toString(){
        return varname;
    }
}
