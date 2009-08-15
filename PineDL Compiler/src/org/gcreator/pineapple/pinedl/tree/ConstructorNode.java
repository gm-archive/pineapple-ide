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
public class ConstructorNode extends Node{
    public Token accessModifier;
    public ArgumentListNode arguments;
    public StatementNode content;

    public ConstructorNode(Token token){
        super(token);
    }
    
    @Override
    public String toString(){
        return accessModifier.toString() + " this" + arguments.toString()
                + content.toString();
    }
}
