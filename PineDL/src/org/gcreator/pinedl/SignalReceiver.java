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
 * A SignalReceiver gets information from the PineDL compiler
 * @author Luís Reis
 */
public class SignalReceiver {
    /**
     * A signal provided by the Antlr parser.
     * Gives the SignalReceiver a package statement signal
     * @param pkg The package
     */
    public void sendPackageSignal(String pkg){}
    
    /**
     * Imports a class from a given package.class location.
     * @param cls The class to import
     */
    public void sendImportSignal(String cls){}
    
    /**
     * Begins the class declaration
     * @param cls The class name
     * @param bcls The base class name. May be null and may contain dots('.')
     */
    public void sendClassDeclaration(String cls, String bcls){}
    
    /**
     * Deals with a constructor
     * @param privacy The constructor privacy: public, private or protected
     * @param args The arguments of the constructor
     */
    public void sendConstructorSignal(String privacy, Vector<Argument> args){}
    
    /**
     * A field(class variable)
     * @param privacy The field privacy: public, private or protected
     * @param isStatic Whether the field is static
     * @param isConst Whether the field is constant
     * @param type The field type
     * @param name The field name
     */
    public void sendFieldSignal(String privacy, boolean isStatic, boolean isConst,
            String type, String name){}
    
    /**
     * A method(class function)
     * @param privacy The method privacy: public, private or protected
     * @param isStatic Whether the method is static
     * @param type The return type
     * @param name The method name
     * @param args The arguments
     */
    public void sendMethodSignal(String privacy, boolean isStatic, String type,
            String name, Vector<Argument> args){}
    
    /**
     * Closes the parsing started by 
     */
    public void endClass(){}
}
