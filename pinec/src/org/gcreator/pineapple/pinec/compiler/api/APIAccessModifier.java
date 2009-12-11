/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.api;

/**
 *
 * @author Luís Reis
 */
public enum APIAccessModifier {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override
    public String toString(){
        if(this==PUBLIC){
            return "public";
        }
        else if(this==PROTECTED){
            return "protected";
        }
        return "private";
    }
}
