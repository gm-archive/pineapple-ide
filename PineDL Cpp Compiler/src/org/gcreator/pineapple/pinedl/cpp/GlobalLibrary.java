/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
import org.gcreator.pineapple.pinedl.Type;

/**
 * 
 * Defines all the classes defined in the Pineapple core library
 * and scripts.
 *
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class GlobalLibrary {

    public static Vector<ClassDefinition> coreClasses = new Vector<ClassDefinition>();
    public static Vector<ClassDefinition> userDefinedClasses = new Vector<ClassDefinition>();

    static {
        /* Add the functions provided by libPineapple.a, the OpenGL Backend */
    }

    private GlobalLibrary() {
    }

    public static class ClassDefinition {

        public String name;
        public Vector<ClassDefinition> classes;
        public Vector<MethodDefinition> methods;
        public Vector<FieldDefinition> fields;

        public ClassDefinition(String name) {
            this.name = name;
            this.classes = new Vector<ClassDefinition>();
            this.methods = new Vector<MethodDefinition>();
            this.fields = new Vector<FieldDefinition>();
        }
    }

    public static class FieldDefinition {
        public String name;
        public boolean isStatic;
        public boolean isFinal;
        public Type type;

        public FieldDefinition(String name, Type type) {
            this.name = name;
            this.type = type;
        }

        public FieldDefinition(String name, Type type, boolean isStatic, boolean isFinal) {
            this(name, type);
            this.isStatic = isStatic;
            this.isFinal = isFinal;
        }
    }

    public static class MethodDefinition {
        public String name;
        public Vector<Variable> arguments;
        public boolean isFinal;
        public boolean isStatic;
        public Type returnType;

        public MethodDefinition(String name, Type returnType) {
            this.name = name;
            this.returnType = returnType;
            this.arguments = new Vector<Variable>();
        }

        public MethodDefinition(String name, Type returnType, boolean isStatic, boolean isFinal) {
            this(name, returnType);
            this.isStatic = isStatic;
            this.isFinal = isFinal;
        }
    }

    public static class Variable {
        String name;
        Type type;
        public Variable(String name, Type type) {
            this.name = name;
            this.type = type;
        }
    }
}

    