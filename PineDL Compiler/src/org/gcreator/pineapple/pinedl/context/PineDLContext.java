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

package org.gcreator.pineapple.pinedl.context;

import java.util.Hashtable;
import org.gcreator.pineapple.pinedl.Type;

/**
 * The context for PineDL parsing
 * @author Luís Reis
 */
public class PineDLContext {
    public PineDLContext root = null;
    private String functionName = null;
    private Hashtable<String, Type> vars = new Hashtable<String, Type>();
    
    public PineDLContext(String function){
        this.root = null;
        functionName = function;
    }
    
    public PineDLContext(PineDLContext root){
        this.root = root;
        if(root!=null){
            functionName = root.functionName;
        }
    }
    
    /**
     * Finds out whether a variable is declared in the function or constructor.
     * Does not take class fields into account.
     * @param var The variable name
     * @return Whether the variable is declared
     */
    public boolean isVariableDeclared(String var){
        if(vars.containsKey(var)){
            return true;
        }
        return root!=null && root.isVariableDeclared(var);
    }
    
    public Type getVariableType(String var){
        if(vars.containsKey(var)){
            return vars.get(var);
        }
        if(root==null){
            return null;
        }
        return root.getVariableType(var);
    }
    
    public void declareVariable(String var, Type type){
        vars.put(var, type);
    }
    
    public String getFunctionName(){
        return functionName;
    }
}
