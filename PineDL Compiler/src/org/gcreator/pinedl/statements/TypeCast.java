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

package org.gcreator.pinedl.statements;

import org.gcreator.pinedl.Leaf;
import org.gcreator.pinedl.NativeType;
import org.gcreator.pinedl.Type;
import org.gcreator.pinedl.TypeCategory;

/**
 * Represents a type change statement
 * @author Luís Reis
 */
public class TypeCast extends Operation{
    public Type type = null;
    public Expression exp = null;
    
    public TypeCast(){}
    public TypeCast(Type type, Expression exp){
        this.type = type;
        this.exp = exp;
    }
    
    @Override
    public Leaf optimize(){
        exp = (Expression) exp.optimize();
        if(type.typeCategory==TypeCategory.NATIVE
                &&exp instanceof Constant){
            if(type.nativeType==NativeType.STRING){
                if(exp instanceof StringConstant){
                    return exp;
                }
                else{
                    return new StringConstant(exp.toString());
                }
            }
        }
        return this;
    }
}
