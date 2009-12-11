/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.api;

import java.util.List;
import java.util.Vector;

/**
 * Names can not be modified. They must all be defined on Library on construction time.
 * @author Luís Reis
 */
public class NameLibrary {
    private final List<String> internalNames = new Vector<String>();
    private final List<String> userNames = new Vector<String>();

    private void allocateInternalName(final String name){
        if(internalNames.contains(name)){
            return;
        }

        if(userNames.contains(name)){
            userNames.remove(name);
        }

        internalNames.add(name);
    }

    private void allocateUserName(final String name){
        if(internalNames.contains(name)){
            return;
        }

        if(!userNames.contains(name)){
            userNames.add(name);
        }
    }

    public List<String> getInternalNames(){
        return new Vector<String>(internalNames);
    }

    public List<String> getUserNames(){
        return new Vector<String>(userNames);
    }

    public int fetchName(final String name){
         if(internalNames.contains(name)){
            return internalNames.indexOf(name);
        }

        if(!userNames.contains(name)){
            return -1;
        }

        return internalNames.size() + userNames.indexOf(name);
    }

    public NameLibrary(){}
    public NameLibrary(final Library library){
        allocateInternalName("toString"); //This is shared by all classes

        for(final APIClass cls : library.getClasses()){
            if(cls.internal){
                allocateInternalName(cls.name);

                for(final APIField field : cls.fields){
                    allocateInternalName(field.name);
                }
            }
            else{
                allocateUserName(cls.name);

                for(final APIField field : cls.fields){
                    allocateUserName(field.name);
                }
            }
        }
    }
}
