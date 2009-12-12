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
public class BytecodeFunction {
    public List<Character> charConstants;
    public List<Float> floatConstants;
    public List<String> stringConstants;

    public int varNumber = 0;
    public List<BytecodeInstruction> instructions;
}
