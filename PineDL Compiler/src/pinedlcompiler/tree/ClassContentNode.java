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
    public List<MethodNode> methods;
    //TODO: Fields

    public ClassContentNode(Token t){
        super(t);
        constructors = new Vector<ConstructorNode>();
        methods = new Vector<MethodNode>();
    }

    public void addConstructor(ConstructorNode constructor){
        constructors.add(constructor);
    }

    public void addMethod(MethodNode method){
        methods.add(method);
    }
    
    @Override
    public String toString(){
        String s = "{\n";
        
        s += "Constructors:";
        for(ConstructorNode node : constructors){
            s += "\n\t" + node.toString();
        }
        
        s += "\nMethods:";
        for(MethodNode node : methods){
            s += "\n\t" + node.toString();
        }
        
        return s + '}';
    }
}
