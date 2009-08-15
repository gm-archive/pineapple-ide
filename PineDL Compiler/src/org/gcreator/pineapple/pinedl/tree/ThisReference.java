/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import org.gcreator.pineapple.pinedl.Token;

/**
 * Keyword 'this'
 * @author luis
 */
public class ThisReference extends Reference{
    public ThisReference(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        return "this";
    }
}
