/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler.tree;

import pinedlcompiler.Token;

/**
 * Keyword 'this'
 * @author luis
 */
public class ThisReference extends Reference{
    public ThisReference(Token t){
        super(t);
    }
}
