/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.tree;

import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author HP530
 */
public class NumericConstant extends ConstantNode{
    public double number = .0;
    
    public NumericConstant(Token t){
        super(t);
        number = Double.valueOf(t.text);
    }
}
