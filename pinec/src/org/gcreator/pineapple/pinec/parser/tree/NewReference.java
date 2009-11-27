/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

/**
 *
 * @author luis
 */
public class NewReference extends Reference{
    public Expression expr;

    @Override
    public boolean hasSideEffects(){
        return true;
    }
}
