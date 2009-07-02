/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.statements;

import org.gcreator.pineapple.pinedl.Type;

/**
 * Represents an "is" operation, as in
 * "x is int"
 * @author Luís Reis
 */
public class IsOperation extends Operation{
    public Expression exp;
    public Type type;
    
    public IsOperation(Expression exp, Type type){
        this.exp = exp;
        this.type = type;
    }
    
    @Override
    public String toString(){
        return "is["+exp.toString()+", "+type.toString()+"]";
    }
}
