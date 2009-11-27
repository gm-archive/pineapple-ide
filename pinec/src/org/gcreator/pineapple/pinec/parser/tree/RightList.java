/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Luís Reis
 */
public class RightList extends Expression{
    public Map<String, Expression> expressionMap = new HashMap<String, Expression>();

    public RightList(){

    }
}
