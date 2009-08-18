/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author Luís Reis
 */
public class IfStatement extends StatementNode{
    public ExpressionNode condition;
    public StatementNode then;
    public StatementNode elseCase;
    
    public IfStatement(){
        
    }
    public IfStatement(Token t){
        super(t);
    }
    
    @Override
    public String toString(){
        return "if("+condition+')' + (elseCase==null?then:then+"\nelse "+elseCase);
    }
}
