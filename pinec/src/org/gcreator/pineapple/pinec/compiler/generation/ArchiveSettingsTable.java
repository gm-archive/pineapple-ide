/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.generation;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luís Reis
 */
public class ArchiveSettingsTable {
    public Map<String, Integer> intValues = new Hashtable<String, Integer>();
    public Map<String, String> stringValues = new Hashtable<String, String>();
    public Map<String, List<String>> listedValues = new Hashtable<String, List<String>>();

    /**
     * Enable only on debug builds.
     * Improves the quality of debugging info(and decompilation becomes easier)
     */
    public boolean outputUserNames = false;
}
