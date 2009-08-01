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
public class ConstructorNode extends Node{
    public Token accessModifier;
    public ArgumentListNode arguments;
    public StatementNode content;

    public ConstructorNode(Token token){
        super(token);
    }
}
