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
public class DeclarationNode extends StatementNode{
    public boolean isConst = false;
    public String name = "";
    public ExpressionNode defaultValue = null;
    
    public DeclarationNode(Token t){
        super(t);
        if(t.type==Token.Type.CONST){
            //const x = 2;
            isConst = true;
        }
    }
    
    @Override
    public String toString(){
        return (isConst?"const ":"var ") + name + " = " + defaultValue;
    }
}
