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

package org.gcreator.pineapple.pinedl.statements;

import java.util.Vector;
import org.gcreator.pineapple.pinedl.Leaf;

/**
 * Represents an if statement
 * @author Luís Reis
 */
public class IfStatement extends Leaf{
    public Expression condition = null;
    public Leaf then = null;
    public Leaf elseCase = null;
    
    @Override
    public Leaf optimize(){
        if(then!=null){
            then.optimize();
        }
        if(elseCase!=null){
            elseCase.optimize();
        }
        if(then==null&&elseCase==null){ return condition; }
        condition = (Expression) condition.optimize();
        if(condition instanceof BooleanConstant){
            if(((BooleanConstant) condition).value){
                Block b = new Block();
                b.content.add(then);
                return b;
            }
            else{
                Block b = new Block();
                b.content.add(elseCase);
                return b;
            }
        }
        return this;
    }
    
    @Override
    public String toString(){
        String s = "if[" + condition.toString() + ", ";
        
        s += then;
        
        s += ", ";
        
        s += elseCase;
        
        return s + "]";
    }
}
