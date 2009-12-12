/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.generation;

import java.util.List;

/**
 *
 * @author Luís Reis
 */
public class BytecodeClass {
    public List<Integer> fields;
    public List<Integer> base;

    public int creatorFunction;
    public int constructorFunction;
}
