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

/**
 * Represents a string constant
 * @author Luís Reis
 */
public class StringConstant extends Constant{
    public String value;
    
    public StringConstant(String value){
        this.value = value;
    }
    
    public static StringConstant parse(String value){
        StringConstant s = new StringConstant("");
        boolean escaping = false;
        for(int i = 1; i < value.length()-1; i++){ //Automatically crop the ""
            char c = value.charAt(i);
            if(escaping){
                if(c=='n'){
                    s.value+="\n";
                    escaping = false;
                    continue;
                }
                if(c=='t'){
                    s.value+="\t";
                    escaping = false;
                    continue;
                }
                if(c=='\\'||c=='"'){
                    s.value += c;
                    escaping = false;
                    continue;
                }
            }
            if(c=='\\'){
                escaping = true;
                continue;
            }
            s.value += c;
        }
        return s;
    }
    
    @Override
    public String toString(){
        return ""+value;
    }
}
