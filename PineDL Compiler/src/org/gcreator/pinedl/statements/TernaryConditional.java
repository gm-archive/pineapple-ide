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

import java.util.Vector;
import org.gcreator.pinedl.Leaf;

/**
 * Represents an if statement
 * @author Luís Reis
 */
public class TernaryConditional extends Expression{
    public Expression condition = null;
    public Expression then = null;
    public Expression elseCase = null;
    
    public TernaryConditional(){}
    public TernaryConditional(Expression condition, Expression then,
            Expression elseCase){
        this.condition = condition;
        this.then = then;
        this.elseCase = elseCase;
    }
    
    @Override
    public Leaf optimize(){
        condition = (Expression) condition.optimize();
        if(condition instanceof BooleanConstant){
            if(((BooleanConstant) condition).value){
                return then.optimize();
            }
            else{
                return elseCase.optimize();
            }
        }
        then.optimize();
        elseCase.optimize();
        return this;
    }
    
    @Override
    public String toString(){
        String s = "?:[" + condition.toString() + ", ";
        
        s += then.toString();
        
        s += ", ";
        
        s += elseCase.toString();
        
        return s + "]";
    }
}
