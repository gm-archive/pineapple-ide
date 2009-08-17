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
public class MethodNode extends Node{
    public Token accessModifier;
    public String name;
    public ArgumentListNode arguments;
    public StatementNode content;

    public MethodNode(Token token){
        super(token);
    }
    
    @Override
    public String toString(){
        String s = accessModifier.toString() + " " + name;
        return s + arguments.toString() + content.toString();
    }
}