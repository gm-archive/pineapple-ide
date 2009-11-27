/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public class EmptyStatement extends Statement{
    @Override
    public boolean hasSideEffects(){
        return false;
    }

    @Override
    public String toString(){
        return ";";
    }
}
