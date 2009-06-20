/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pineapple.pinedl.cpp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.gcreator.pineapple.pinedl.Argument;
import org.gcreator.pineapple.pinedl.Constructor;
import org.gcreator.pineapple.pinedl.Function;
import org.gcreator.pineapple.pinedl.PineDLLexer;
import org.gcreator.pineapple.pinedl.PineDLParser;
import org.gcreator.pineapple.pinedl.Type;
import org.gcreator.pineapple.pinedl.Variable;

/**
 * Creates a H file from a PineDL context.
 * 
 * @author Luís Reis
 */
public class HGenerator extends BaseGenerator {

    public HGenerator(InputStream in, OutputStream out, GameCompiler cmp, String fname) {
        try {
            if (in.available() == 0) {
                System.out.println("Empty file! skipping");
                return;
            }
            this.in = in;
            this.out = out;
            this.cmp = cmp;
            parse();
            this.fname = cls.clsName;
            if (!this.fname.equals(fname)) {
                throw new Exception("Invalid class name: " + fname + "  (should be '" + this.fname + "')");
            }
            write();
        } catch (Exception e) {
            e.printStackTrace();
            throwError("Parsing exception: " + e.getMessage());
        }
    }

    public boolean wasSuccessful() {
        return successful;
    }

    private void parse() throws Exception {
        PineDLLexer lexer = new PineDLLexer(new ANTLRInputStream(in));
        CommonTokenStream ts = new CommonTokenStream(lexer);
        PineDLParser parser = new PineDLParser(ts);
        cls = parser.doc();
    }

    private void write() throws Exception {
        String htitle = getHeaderTitle(fname);
        writeLine("#ifndef " + htitle);
        writeLine("#define " + htitle);

        writeLine("#include \"header.h\"");
        writeImports();

        for (String pkg : cls.packageName) {
            writeLine("namespace " + detokenize(pkg) + "{");
        }

        writeClass();

        for (String pkg : cls.packageName) {
            writeLine("}");
        }

        writeLine("#endif");
        writeLine();
    }

    private void writeImports() throws Exception {
        Vector<String> s = new Vector<String>();
        for (Type t : cls.importStmt) {
            if (s.contains(t.type[t.type.length - 1])) {
                throwError("Found two import statements referencing same class name.");
                return;
            }
            //if (context.contains(t.type[t.type.length - 1])) {
            //    throwWarning("Found import statement reference class name of same package");
            //    return;
            //}
            s.add(t.type[t.type.length - 1]);
            writeLine("#include \"" + t.type[t.type.length - 1] + '"');
        }
    }

    GlobalLibrary.ClassDefinition superDefinition;
    
    private void writeClass() throws Exception {
        String s = "class ";
        s += detokenize(cls.clsName);
        if (cls.superClass != null) {
            s += " : public " + retrieveType(cls.superClass, false);
            superDefinition = classFromName(cls.superClass.type);
        }
        s += "{";
        writeLine(s);

        writeFields();
        writeMethods();
        writeConstructors();

        writeLine("};");
    }

    private void writeFields() throws Exception {
        for (Variable field : cls.variables) {
            writeLine(accessToString(field.access) +
                    (field.isStatic ? ": static " : ": ") +
                    (field.isFinal ? "const " : "") +
                    retrieveType(field.type, true) + " " +
                    detokenize(field.name) + ";");
        }
    }

    

    private void writeMethods() throws Exception {
        for (Function method : cls.functions) {
            String s = accessToString(method.access) +
                    (method.isStatic ? ": static " : ": ") +
                    retrieveType(method.returnType, true) + ' ' +
                    detokenize(method.name) + '(';

            boolean isFirst = true;
            for (Argument a : method.arguments) {
                if (!isFirst) {
                    s += ", ";
                }
                s += retrieveType(a.type, true);
                s += ' ';
                s += detokenize(a.name);
                isFirst = false;
            }

            s += ");";
            writeLine(s);
        }
    }

    private void writeConstructors() throws Exception {
        for (Constructor method : cls.constructors) {
            String s = accessToString(method.access) + ": " +
                    detokenize(cls.clsName) + '(';

            boolean isFirst = true;
            for (Argument a : method.arguments) {
                if (!isFirst) {
                    s += ", ";
                }
                s += retrieveType(a.type, true);
                s += ' ';
                s += detokenize(a.name);
                isFirst = false;
            }

            s += ");";
            writeLine(s);
        }
    }
}
