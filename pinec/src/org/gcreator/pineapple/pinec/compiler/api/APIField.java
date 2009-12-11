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

    @Override
    public String toString(){
        return access.toString() + " var " + name + ';';
    }
}
