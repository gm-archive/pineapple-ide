/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 BobSerge<serge_1994@hotmail.com>

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

package org.gcreator.pinedl.test;

import java.io.FileOutputStream;
import java.io.IOException;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.gcreator.pinedl.Constructor;
import org.gcreator.pinedl.Function;
import org.gcreator.pinedl.PineClass;
import org.gcreator.pinedl.PineDLLexer;
import org.gcreator.pinedl.PineDLParser;
import org.gcreator.pinedl.Type;
import org.gcreator.pinedl.Variable;

/**
 * Used only for testing purposes
 * @author Luís Reis
 */
public class Test {
    private static String join(String[] str, String unification){
        if(str==null){
            System.out.println("got here");
            return null;
        }
        if(str.length==0){
            System.out.println("length is 0");
            return "";
        }
        
        String s = str[0];
        System.out.println("First is: " + s);
        
        for(int i = 1; i < str.length; i++){
            s += unification;
            s += str[i];
        }
        
        return s;
    }
    
    public static void main(String[] args){
        try{
            PineDLLexer lexer = new PineDLLexer(new ANTLRInputStream(
                Test.class.getResourceAsStream("/org/gcreator/pinedl/test/test.pdl")));
            CommonTokenStream ts = new CommonTokenStream(lexer);
            PineDLParser parser = new PineDLParser(ts);
            PineClass cls = parser.doc();
            System.out.println("Package: " + join(cls.packageName, "."));
            for(Type t : cls.importStmt){
                System.out.println("Import: " + t.toString());
            }
            for(Variable v : cls.variables){
                System.out.println("Variable: " + v.toString());
            }
            for(Function f : cls.functions){
                System.out.println("Function: " + f.optimize().toString());
            }
            for(Constructor c : cls.constructors){
                System.out.println("Constructor: " + c.optimize().toString());
            }
        }
        catch(IOException e){
            System.out.println("IOException: " + e);
        }
        catch(RecognitionException e){
            System.out.println("RecognitionException: " + e);
        }
    }

    private Test() {
    }
}
