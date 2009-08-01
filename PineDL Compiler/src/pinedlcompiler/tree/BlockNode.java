/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler.tree;

import java.util.List;
import java.util.Vector;
import pinedlcompiler.Token;

/**
 *
 * @author luis
 */
public class BlockNode extends StatementNode{
    public List<StatementNode> statements;

    public BlockNode(){
        statements = new Vector<StatementNode>();
    }

    public BlockNode(Token t){
        super(t);
        statements = new Vector<StatementNode>();
    }
}
