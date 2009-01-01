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

package org.gcreator.pinedl.cpp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.gcreator.pinedl.NativeType;
import org.gcreator.pinedl.PineClass;
import org.gcreator.pinedl.PineDLLexer;
import org.gcreator.pinedl.PineDLParser;
import org.gcreator.pinedl.Type;
import org.gcreator.pinedl.TypeCategory;

/**
 * Creates a H file from a PineDL context
 * @author Luís Reis
 */
public class HGenerator {
    OutputStream out = null;
    InputStream in = null;
    OutputStream err = null;
    String fname = "";
    PineClass cls = null;
    boolean sucessful = true;
    
    public HGenerator(InputStream in, String fname, OutputStream out, OutputStream err){
        try{
            this.in = in;
            this.out = out;
            this.fname = fname;
            this.err = err;
            parse();
            write();
        }
        catch(Exception e){
            throwError("Parsing exception: " + e.getMessage());
        }
    }
    
    private void parse() throws Exception{
        PineDLLexer lexer = new PineDLLexer(new ANTLRInputStream(in));
        CommonTokenStream ts = new CommonTokenStream(lexer);
        PineDLParser parser = new PineDLParser(ts);
        cls = parser.doc();
    }
    
    private void write() throws Exception{
        String htitle = getHeaderTitle();
        writeLine("#ifndef " + htitle);
        writeLine("#define " + htitle);
        
        for(String pkg : cls.packageName){
            writeLine("package " + detokenize(pkg) + "{");
        }
        
        writeImports();
        
        for(String pkg : cls.packageName){
            writeLine("}");
        }
        
        writeLine("#endif");
        writeLine();
    }
    
    private void writeImports() throws Exception{
        Vector<String> iclass = new Vector<String>();
        
        for(Type t : cls.importStmt){
            writeLine("using " + typeToString(t));
        }
    }
    
    private String typeToString(Type t){
        if(t.typeCategory==TypeCategory.ARRAY){
            return typeToString(t.arrayType) + "*";
        }
        if(t.typeCategory==TypeCategory.NATIVE){
            if(t.nativeType==NativeType.BOOL){
                return "bool";
            }
            if(t.nativeType==NativeType.CHAR){
                return "signed char";
            }
            if(t.nativeType==NativeType.DOUBLE){
                return "double";
            }
            if(t.nativeType==NativeType.FLOAT){
                return "float";
            }
            if(t.nativeType==NativeType.INT){
                return "int";
            }
            if(t.nativeType==NativeType.STRING){
                return "std::string";
            }
            if(t.nativeType==NativeType.UCHAR){
                return "unsigned char";
            }
            if(t.nativeType==NativeType.UDOUBLE){
                return "unsigned double";
            }
            if(t.nativeType==NativeType.UFLOAT){
                return "unsigned float";
            }
            if(t.nativeType==NativeType.UINT){
                return "unsigned int";
            }
        }
        String x = t.type[0];
        for(int i = 0; i < t.type.length; i++){
            x += "::";
            x += t.type[i];
        }
        x += '*';
        return x;
    }
    
    private String detokenize(String id){
        if(id.startsWith("_")){
            return "_P_" + id;
        }
        /*
         * The following aren't PineDL keywords, so the user
         * has the right to use them
         */
        if(id.equals("do")){
            throwWarning("'do' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_do";
        }
        if(id.equals("unsigned")){
            return "_K_unsigned";
        }
        if(id.equals("signed")){
            return "_K_signed";
        }
        if(id.equals("switch")){
            throwWarning("'switch' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_switch";
        }
        if(id.equals("case")){
            throwWarning("'case' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_case";
        }
        if(id.equals("default")){
            throwWarning("'default' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_default";
        }
        if(id.equals("NULL")){
            return "_K_NULL";
        }
        if(id.equals("FILE")){
            return "_K_FILE";
        }
        if(id.startsWith("SDL")){
            return "_K_" + id;
        }
        if(id.equals("default")){
            return "_K_default";
        }
        if(id.startsWith("GL")||id.startsWith("gl")){
            return "_K_" + id;
        }
        if(id.equals("lambda")){
            throwWarning("'lambda' is not a PineDL keyword, but may become in the future. Avoid using it");
            return id;
        }
        if(id.equals("repeat")){
            throwWarning("'repeat' is not a PineDL keyword, but may become in the future. Avoid using it");
            return id;
        }
        if(id.equals("std")){
            return "_K_" + id;
        }
        if(id.equals("virtual")){
            return "_K_" + id;
        }
        if(id.equals("using")){
            return "_K_" + id;
        }
        if(id.equals("namespace")){
            return "_K_" + id;
        }
        
        return id;
    }
    
    private String getHeaderTitle(){
        String s = "__";
        
        s += fname.toUpperCase();
        
        s += "_H__";
        return s;
    }
    
    private void writeLine() throws IOException{
        out.write('\n');
    }
    
    private void writeLine(String line) throws IOException{
        out.write(line.getBytes());
        out.write('\n');
    }
    
    private void throwWarning(String warning){
        try{
        String message = "[WARNING] ";
        message += warning;
        message += '\n';
        
        err.write(message.getBytes());
        }catch(IOException e){}
    }
    
    private void throwError(String error){
        try{
        String message = "[ERROR] ";
        message += error;
        message += '\n';
        sucessful = false;
        
        err.write(message.getBytes());
        }catch(IOException e){}
    }
}
