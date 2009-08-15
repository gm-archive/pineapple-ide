/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class DocumentNode extends Node{
    public List<Node> content = new Vector<Node>();
    
    @Override
    public String toString(){
        String s = "";
        
        boolean isFirst = true;
        
        for(Node node : content){
            if(isFirst){
                isFirst = false;
            }
            else{
                s += "\n\n";
            }
            s += node.toString();
        }
        
        return s;
    }
}
