/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler.tree;

import pinedlcompiler.Token;

/**
 *
 * @author luis
 */
public class StringConstant extends ConstantNode{
    public String value = "";

    public StringConstant(Token t){
        super(t);
        value = t.text;
    }
}
