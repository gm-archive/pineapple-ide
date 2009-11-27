/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import java.util.List;
import java.util.Vector;
import org.gcreator.pineapple.pinec.lexer.Token;
import org.gcreator.pineapple.pinec.lexer.TokenType;

/**
 *
 * @author luis
 */
public final class ClassConstant extends Constant{
    public final boolean behaviorFlag;
    public String name = null; //Is anonymous, perhaps?
    public final List<String> base = new Vector<String>();
    public final List<Constructor> constructors = new Vector<Constructor>();
    public final List<Function> functions = new Vector<Function>();

    public ClassConstant(final Token t){
        this.behaviorFlag = t.getType()==TokenType.WORD;
        this.line = t.getLine();
        this.col = t.getCol();
    }

    @Override
    public boolean hasSideEffects(){
        //Anonymous classes do not have side effects
        //Named classes have(the declaration of a class)
        return name!=null;
    }

    @Override
    public String toString(){
        final StringBuilder b = new StringBuilder();
        b.append("class ");
        b.append(name);
        if(!base.isEmpty()){
            b.append(" : ");
            boolean first = true;
            for(String cls : base){
                if(first){
                    first = false;
                }
                else{
                    b.append(", ");
                }
                b.append(cls);
            }
        }
        b.append("{");

        for(Constructor c : constructors){
            b.append("\n\t");
            b.append(c.toString().replaceAll("\n", "\n\t"));
            b.append("\n");
        }

        for(Function f : functions){
            b.append("\n\t");
            b.append(f.toString().replaceAll("\n", "\n\t"));
            b.append("\n");
        }

        b.append("}");
        return b.toString();
    }
}
