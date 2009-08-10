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
public class CharConstant extends ConstantNode{
    public char value = '\0';

    public CharConstant(Token t){
        super(t);
        value = t.text.charAt(0);
    }
}
