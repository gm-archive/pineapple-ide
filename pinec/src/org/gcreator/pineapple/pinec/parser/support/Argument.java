/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.parser.support;

/**
 *
 * @author luis
 */
public class Argument {
    public boolean var; //false for const
    public String idLoc;
    public String name;
    //No default values yet

    @Override
    public String toString(){
        final StringBuilder b = new StringBuilder(var?"var ":"const ");
        b.append(idLoc);
        b.append(':');
        b.append(name);
        return b.toString();
    }
}
