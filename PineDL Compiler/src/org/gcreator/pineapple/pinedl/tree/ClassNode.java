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
public class ClassNode extends Node{
    public String name = null;
    public String base = null;
    public ClassContentNode content = null;

    public ClassNode(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        String s = "class ";
        s += name;
        if(base!=null){
            s += " : ";
            s += base;
        }
        return s + content.toString();
    }
}
