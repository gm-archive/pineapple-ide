/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import java.util.List;
import java.util.Vector;
import org.gcreator.pineapple.pinec.lexer.Token;

/**
 *
 * @author luis
 */
public final class BlockStatement extends Statement{
    public List<Statement> stmts = new Vector<Statement>();

    public BlockStatement(final Token t){
        line = t.getLine();
        col = t.getCol();
    }

    @Override
    public boolean hasSideEffects(){
        for(Statement stmt : stmts){
            if(stmt.hasSideEffects()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        final StringBuilder strBuild = new StringBuilder("{");
        for(Statement stmt : stmts){
            strBuild.append("\n\t");
            strBuild.append(stmt.toString().replaceAll("\n", "\n\t"));
        }
        strBuild.append("\n}");
        return strBuild.toString();
    }
}
