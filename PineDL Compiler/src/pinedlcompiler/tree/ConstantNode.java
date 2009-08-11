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
public class ConstantNode extends Reference{
    public ConstantNode(){}
    public ConstantNode(Token t){
        super(t);
    }
}
