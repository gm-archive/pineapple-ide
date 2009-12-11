/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.api;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class CommonLibrary implements Library{
    private List<APIVariable> vars = new Vector<APIVariable>();
    private List<APIClass> clsList = new Vector<APIClass>();

    public void addVariable(APIVariable var){
        vars.add(var);
    }

    public void addClass(APIClass cls){
        clsList.add(cls);
    }

    public List<APIVariable> getVariables(){
        return vars;
    }

    public List<APIClass> getClasses(){
        return clsList;
    }
}
