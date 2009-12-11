/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.api;

import java.util.List;

/**
 *
 * @author Luís Reis
 */
public interface Library {
    void addClass(APIClass cls);
    void addVariable(APIVariable var);
    List<APIVariable> getVariables();
    List<APIClass> getClasses();
}
