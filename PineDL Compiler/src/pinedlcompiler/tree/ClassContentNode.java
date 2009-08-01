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
public class ClassContentNode extends Node{
    public List<ConstructorNode> constructors;

    public ClassContentNode(Token t){
        super(t);
        constructors = new Vector<ConstructorNode>();
    }

    public void addConstructor(ConstructorNode constructor){
        constructors.add(constructor);
    }
}
