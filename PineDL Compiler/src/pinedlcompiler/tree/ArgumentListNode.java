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
    }

    public List<Argument> arguments;

    public ArgumentListNode(Token t){
        super(t);

        arguments = new Vector<Argument>();
    }
}
