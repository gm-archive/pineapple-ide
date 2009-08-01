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
public class MethodNode extends Node{
    public Token accessModifier;
    public String name;
    public ArgumentListNode arguments;
    public StatementNode content;

    public MethodNode(Token token){
        super(token);
    }
}
