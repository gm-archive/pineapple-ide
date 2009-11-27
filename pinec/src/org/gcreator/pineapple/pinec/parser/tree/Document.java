/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.tree;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author luis
 */
public class Document {
    public final List<ClassConstant> classes;

    public Document(){
        this.classes = new Vector<ClassConstant>();
    }
}
