/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<serge_1994@hotmail.com>

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

package org.gcreator.pineapple.pinedl.cpp;

import java.util.Vector;
import org.gcreator.pineapple.pinedl.Leaf;
import org.gcreator.pineapple.pinedl.Type;

/**
 * A parsed leaf
 * @author Luís Reis
 */
public class TranslatedLeaf {
    /**
     * The leaf that was translated
     */
    public Leaf equivalentLeaf;
    
    /**
     * The equivalent C++ code
     */
    public String stringEquivalent;
    
    /**
     * The type (WARNING: May be null for both NullConstant and typeless statements)
     */
    public Type inspectedType;
    
    /**
     * Contains errors and warnings
     */
    public Vector<TranslationError> errors;
    
    {
        errors = new Vector<TranslationError>();
    }
    
    public boolean hasErrors(){
        return !errors.isEmpty();
    }
    
    public boolean hasFatalErrors(){
        for(TranslationError error : errors){
            if(error.isFatal){
                return true;
            }
        }
        return false;
    }
}
