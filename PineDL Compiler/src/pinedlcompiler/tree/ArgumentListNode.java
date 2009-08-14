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
public class ArgumentListNode extends Node{
    public static class Argument{
        public String name;
        public boolean varargs;
        
        @Override
        public String toString(){
            return name + (varargs?"...":"");
        }
    }

    public List<Argument> arguments;

    public ArgumentListNode(Token t){
        super(t);

        arguments = new Vector<Argument>();
    }
    
    @Override
    public String toString(){
        String s = "(";
        
        boolean isFirst = true;
        
        for(Argument a : arguments){
            if(isFirst){
                isFirst = false;
            }
            else{
                s += ", ";
            }
            
            s += a.toString();
        }
        
        return s + ')';
    }
}
