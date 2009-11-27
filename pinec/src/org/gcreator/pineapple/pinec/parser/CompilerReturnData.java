/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser;

import org.gcreator.pineapple.pinec.parser.tree.Leaf;

/**
 *
 * @author luis
 */
public final class CompilerReturnData<T extends Leaf> {
    public int i;
    public T leaf;

    public CompilerReturnData(int i, T leaf){
        this.i = i;
        this.leaf = leaf;
    }
}
