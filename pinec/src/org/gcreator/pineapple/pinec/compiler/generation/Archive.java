/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.generation;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class Archive {
    public List<BytecodeClass> classes = new Vector<BytecodeClass>();
    public List<BytecodeFunction> functions = new Vector<BytecodeFunction>();
}
