/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public abstract class Statement extends Leaf{
    /**
     * Whether it can be removed without any effects
     * on the behavior of the script.
     * @return
     */
    public boolean hasSideEffects(){
        return true;
    }
}
