/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.api;

/**
 *
 * @author Luís Reis
 */
public class APIField {
    public APIAccessModifier access = APIAccessModifier.PUBLIC;
    public String name = null;
    public boolean variable = true;
    public boolean isStatic = false;

    @Override
    public String toString(){
        return access.toString() + (isStatic ? " static" : "") +
                (variable ? " var " : " const ") + name + ';';
    }
}
