/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public abstract class Leaf {
    public int line;
    public int col;

    public Leaf optimize(){
        return this;
    }
}
