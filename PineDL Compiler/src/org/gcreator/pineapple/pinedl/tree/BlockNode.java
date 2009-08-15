/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import java.util.List;
import java.util.Vector;
import org.gcreator.pineapple.pinedl.Token;

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
    
    @Override
    public String toString(){
        String s = "{\n";
        
        for(StatementNode node : statements){
            s += node.toString() + ";\n";
        }
        
        return s + "}\n";
    }
}
