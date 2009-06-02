/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pineapple.pinedl;


import java.util.Arrays;


/**
 * Represents a PineDL type, such as "int" or "className"
 * @author Luís Reis
 */
public class Type {

    public static final Type INT = new Type(PrimitiveType.INT);
    public static final Type DOUBLE = new Type(PrimitiveType.DOUBLE);
    public static final Type FLOAT = new Type(PrimitiveType.FLOAT);
    public static final Type BOOL = new Type(PrimitiveType.BOOL);
    public static final Type VOID = new Type(PrimitiveType.VOID);
    public static final Type STRING = new Type(PrimitiveType.STRING);

    public Type() {
    }

    public Type(PrimitiveType type) {
        primitiveType = type;
    }

    public Type(String type) {
        String[] t = type.split("\\.");
        if (t.length == 0) {
            throw new IllegalArgumentException("Invalid Type");
        }
        // Must begin with ``Pineapple.''
        if (!t[0].equals("Pineapple")) {
            t = Arrays.copyOf(t, t.length+1);
            t[0] = "Pineapple";
        }
        this.type = t;
    }
    public TypeCategory typeCategory = TypeCategory.PRIMITIVE;
    /**
     * Represents the type name.
     * Only used if typeCategory is TypeCategory.CLASS
     */
    public String[] type = null;
    /**
     * Provides the array type (type[])
     * Note that type may be another array
     * Only used if typeCategory is TypeCategory.ARRAY
     */
    public Type arrayType = null;
    /**
     * Provides the native type
     * Only used if typeCategory is TypeCategory.NATIVE
     */
    public PrimitiveType primitiveType = PrimitiveType.INT;

    @Override
    public String toString() {
        if (typeCategory == TypeCategory.PRIMITIVE) {
            if (primitiveType == PrimitiveType.INT) {
                return "int";
            }
            if (primitiveType == PrimitiveType.UINT) {
                return "uint";
            }
            if (primitiveType == PrimitiveType.FLOAT) {
                return "float";
            }
            if (primitiveType == PrimitiveType.UFLOAT) {
                return "ufloat";
            }
            if (primitiveType == PrimitiveType.DOUBLE) {
                return "double";
            }
            if (primitiveType == PrimitiveType.UDOUBLE) {
                return "udouble";
            }
            if (primitiveType == PrimitiveType.CHAR) {
                return "char";
            }
            if (primitiveType == PrimitiveType.UCHAR) {
                return "uchar";
            }
            if (primitiveType == PrimitiveType.BOOL) {
                return "bool";
            }
            if (primitiveType == PrimitiveType.STRING) {
                return "string";
            }
            return "~INVALID~";
        }
        if (typeCategory == TypeCategory.ARRAY) {
            return arrayType.toString() + "[]";
        }
        if (typeCategory == TypeCategory.CLASS) {
            if (type == null || type.length == 0) {
                return "~INVALID~";
            }
            String s = type[0];
            for (int i = 1; i < type.length; i++) {
                s += "." + type[i];
            }
            return s;
        }
        return "~INVALID~";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Type)) {
            return false;
        }
        Type t = (Type)o;
        if (this.typeCategory != t.typeCategory) {
            return false;
        }
        if (typeCategory == TypeCategory.PRIMITIVE) {
            return t.primitiveType == this.primitiveType;
        } else if (typeCategory == TypeCategory.ARRAY) {
            return this.arrayType.equals(t.arrayType);
        } else if  (typeCategory == TypeCategory.CLASS) {
            for (int i = 0; i < type.length; i++) {
                if (!this.type[i].equals(t.type[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
