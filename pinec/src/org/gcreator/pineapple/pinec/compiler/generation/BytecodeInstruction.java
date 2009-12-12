/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.generation;

/**
 *
 * @author Luís Reis
 */
public interface BytecodeInstruction {
    public void storeToBytes(byte[] b, int pos);
}
