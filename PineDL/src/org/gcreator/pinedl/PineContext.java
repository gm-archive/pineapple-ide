/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 BobSerge<serge_1994@hotmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package org.gcreator.pinedl;

import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class PineContext {
    private Vector<PDI> pdiFiles = new Vector<PDI>();
    
    /**
     * Adds a PDI to the context
     * @param pdi The PDI to add
     */
    public void addPDIFile(PDI pdi){
        pdiFiles.add(pdi);
    }
    
    /**
     * Generates the full class name of something
     * @param pdi The PDI that needs the class
     * @param name The class short name
     * @return The full class name, including package('.' used for separation)
     */
    public String generateFullClassName(PDI pdi, String name){
        String pkg = pdi.pkg;
        
        //If the name refers to the PDI itself
        if(pdi.clsname.equals(name))
            return (pkg.equals("")? (pkg + ".") : "") + name;
        
        PDI currentMatch = null;
        for(PDI pdiFile : pdiFiles){
            if(pdiFile.pkg.equals(pdi.pkg)&&pdiFile.clsname.equals(name)){
                currentMatch = pdiFile;
                break; //Perfect match
            }
            if(pdi.imports.contains(pdiFile.pkg)&&pdiFile.clsname.equals(name)){
                currentMatch = pdiFile;
                //Non-perfect match
            }
        }
        
        return (currentMatch==null?name:pdi.getFullClassName());
    }
}
