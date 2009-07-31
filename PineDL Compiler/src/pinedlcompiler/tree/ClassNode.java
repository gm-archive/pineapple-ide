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
public class ClassNode extends Node{
    public String name = null;
    public String base = null;
    public ClassContentNode content = null;

    public ClassNode(Token t){
        super(t);
    }
}
