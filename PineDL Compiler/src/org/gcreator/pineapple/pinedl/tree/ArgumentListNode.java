/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>

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

package org.gcreator.pineapple.pinedl.tree;

import java.util.List;
import java.util.Vector;
import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author luis
 */
public class ArgumentListNode extends Node{
    public static class Argument{
        public String name;
        public boolean varargs;
        
        @Override
        public String toString(){
            return name + (varargs?"...":"");
        }
    }

    public List<Argument> arguments;

    public ArgumentListNode(Token t){
        super(t);

        arguments = new Vector<Argument>();
    }
    
    @Override
    public String toString(){
        String s = "(";
        
        boolean isFirst = true;
        
        for(Argument a : arguments){
            if(isFirst){
                isFirst = false;
            }
            else{
                s += ", ";
            }
            
            s += a.toString();
        }
        
        return s + ')';
    }
}
