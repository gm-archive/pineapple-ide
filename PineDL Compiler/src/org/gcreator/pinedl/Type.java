/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge_1994@hotmail.com>

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

/**
 * Represents a PineDL type, such as "int" or "className"
 * @author Luís Reis
 */
public class Type {
    public TypeCategory typeCategory = TypeCategory.NATIVE;
    
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
    public NativeType nativeType = NativeType.INT;
    
    @Override
    public String toString(){
        if(typeCategory==TypeCategory.NATIVE){
            if(nativeType==NativeType.INT){ return "int"; }
            if(nativeType==NativeType.UINT){ return "uint"; }
            if(nativeType==NativeType.FLOAT){ return "float"; }
            if(nativeType==NativeType.UFLOAT){ return "ufloat"; }
            if(nativeType==NativeType.DOUBLE){ return "double"; }
            if(nativeType==NativeType.UDOUBLE){ return "udouble"; }
            if(nativeType==NativeType.CHAR){ return "char"; }
            if(nativeType==NativeType.UCHAR){ return "uchar"; }
            if(nativeType==NativeType.BOOL){ return "bool"; }
            if(nativeType==NativeType.STRING){ return "string"; }
            return "~INVALID~";
        }
        if(typeCategory==TypeCategory.ARRAY){
            return arrayType.toString() + "[]";
        }
        if(typeCategory==TypeCategory.CLASS){
            if(type==null||type.length==0){
                return "~INVALID~";
            }
            String s = type[0];
            for(int i = 1; i < type.length; i++){
                s += "." + type[i];
            }
            return s;
        }
        return "~INVALID~";
    }
}
