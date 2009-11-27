/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public class Constant extends Reference{
    public Constant(){

    }

    @Override
    public boolean hasSideEffects(){
        return false;
    }
}
