/*
Copyright (C) 2008-2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008-2009 Serge Humphrey<serge_1994@hotmail.com>

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
import org.gcreator.pineapple.pinedl.AccessControlKeyword;
import org.gcreator.pineapple.pinedl.Argument;
import org.gcreator.pineapple.pinedl.Function;
import org.gcreator.pineapple.pinedl.PineClass;
import org.gcreator.pineapple.pinedl.Type;
import org.gcreator.pineapple.pinedl.Variable;

/**
 * Defines all the classes defined in the Pineapple core library
 * and scripts.
 * Good for context.
 * @author Luís Reis
 */
public class GlobalLibrary {
    public Vector<PineClass> userDefinedClasses = new Vector<PineClass>();
    public Vector<PineClass> coreClasses = new Vector<PineClass>();
    
    public static final Type SCENE = new Type("Pineapple.Scene");
    
    public GlobalLibrary(){
        PineClass Application = new PineClass(){{
            packageName = new String[]{"Pineapple"};
            clsName = "Application";
            variables.add(new Variable(
                    AccessControlKeyword.PRIVATE, true, Type.INT, "speed"));
            variables.add(new Variable(
                    AccessControlKeyword.PRIVATE, true, Type.BOOL, "running"));
            variables.add(new Variable(
                    AccessControlKeyword.PRIVATE, true, SCENE, "currentScene"));
            
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.VOID, "init"));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.VOID, "exit"));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.BOOL, "isRunning"));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.INT, "getSpeed"));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.STRING, "getCurrentDirectory"));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.STRING, "getExecutablePath"));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.STRING, "getExecutableDirectory"));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, Type.VOID, "setScene", new Argument(SCENE, "scene")));
            functions.add(new Function(
                    AccessControlKeyword.PUBLIC, true, SCENE, "getScene"));
            
        }};
        coreClasses.add(Application);
        
        PineClass Texture = new PineClass(){{
            packageName = new String[]{"Pineapple"};
            clsName = "Texture";
        }};
    }
}
