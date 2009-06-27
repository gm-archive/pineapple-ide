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

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import org.gcreator.pineapple.pinedl.Argument;
import org.gcreator.pineapple.pinedl.Constructor;
import org.gcreator.pineapple.pinedl.Function;
import org.gcreator.pineapple.pinedl.PineClass;
import org.gcreator.pineapple.pinedl.Type;
import org.gcreator.pineapple.pinedl.Variable;
import org.gcreator.pineapple.pinedl.context.PineDLContext;
import org.gcreator.pineapple.pinedl.statements.Expression;
import org.gcreator.pineapple.pinedl.statements.Reference;
import org.gcreator.pineapple.pinedl.statements.RetrieverExpression;
import org.gcreator.pineapple.pinedl.statements.VariableReference;

/**
 * Creates a C++ file from a PineDL context.
 * 
 * @author Luís Reis
 */
public class CppGenerator extends BaseGenerator {
    
    public CppGenerator(OutputStream out, GameCompiler cmp, String fname,
            PineClass cls) {
        try {
            this.out = out;
            this.cmp = cmp;
            this.cls = cls;
            this.fname = cls.clsName;
            if (!this.fname.equals(fname)) {
                throw new Exception("Invalid class name!");
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

    private void write() throws Exception {

        writeImports();
        writeStaticFields();
        writeClass();

        writeLine();
    }

    private void writeImports() throws Exception {

        writeLine("#include \"header.h\"");
        writeLine("using namespace Pineapple;");
        writeLine("using namespace Game;");

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
            writeLine("using " + typeToString(t, false) + ';');
        }
    }

    private void writeClass() throws Exception {


        writeConstructors();
        writeMethods();

    }

    private void writeInitFields() throws IOException {
        writeLine("/* Initialize variables */");
        for (Variable v : cls.variables) {
            if (v.isStatic) {
                continue;
            }
            /*Expression e = v.defaultValue;
            if (e != null) {
            writeLine( v.name + " = " + e.toString() + ";");
            } else {*/
            writeLine("/* Note: no default value for field " + v.name + "*/");
        //}
        }
    }

    private String merge(String[] x, char c) {
        String res = x[0];
        for (int i = 1; i < x.length; i++) {
            res += c;
            res += x[i];
        }
        return res;
    }

    public boolean isType(Reference e) {
        if (e instanceof VariableReference) {
            if (isType(((VariableReference) e).name)) {
                return true;
            }
        } else if (e instanceof RetrieverExpression) {
            if (isType(e.toString())) {
                return true;
            }
        }
        return false;
    }

    private void writeConstructors() throws Exception {
        for (Constructor c : cls.constructors) {
            String s = detokenize(cls.clsName) + "::" + detokenize(cls.clsName) + '(';

            boolean isFirst = true;
            PineDLContext vars = new PineDLContext(c);
            vars.contentClass = cls;
            for (Argument a : c.arguments) {
                if (!isFirst) {
                    s += ", ";
                }
                if (vars.isVariableDeclared(a.name)) {
                    throw new Exception("In constructor: " + "Argument name " + a.name + " is used twice.");
                }
                s += retrieveType(a.type, true);
                s += ' ';
                s += detokenize(a.name);
                isFirst = false;
                vars.declareVariable(a.name, a.type);
            }

            s += ")";

            if (c.superArguments != null) {
                s += ": " + retrieveType(cls.superClass, false);
                s += '(';
                isFirst = true;
                for (Expression exp : c.superArguments) {
                    if (!isFirst) {
                        s += ", ";
                    }

                    TranslatedLeaf translation = translateLeaf(exp, vars, false);
                    for(TranslationError error : translation.errors){
                        if(error.isFatal){
                            throwError(error.generateFullErrorMessage());
                        }
                        else{
                            throwWarning(error.generateFullErrorMessage());
                        }
                    }
                    
                    s += translation.stringEquivalent;

                    isFirst = false;
                }
                s += ')';
            }

            writeLine(s);
            
            TranslatedLeaf translation = translateLeaf(c.content, vars, true);
            for(TranslationError error : translation.errors){
                if(error.isFatal){
                    throwError(error.generateFullErrorMessage());
                }
                else{
                    throwWarning(error.generateFullErrorMessage());
                }
            }
            String content = translation.stringEquivalent;
            
            int index = content.indexOf('{');
            writeLine(content.substring(0, index + 1));
            writeInitFields();
            writeLine(content.substring(index + 1));

            writeLine();
        }
    }

    private void writeMethods() throws Exception {
        for (Function method : cls.functions) {
            String s = (method.isStatic ? " static " : " ") +
                    retrieveType(method.returnType, true) + ' ' +
                    detokenize(cls.clsName) + "::" + detokenize(method.name) + '(';

            boolean isFirst = true;
            PineDLContext vars = new PineDLContext(method);
            vars.contentClass = cls;
            for (Argument a : method.arguments) {
                if (!isFirst) {
                    s += ", ";
                }
                if (vars.isVariableDeclared(a.name)) {
                    throw new Exception("In function " + vars.getFunctionName() + ": " + "Argument name " + a.name + " is used twice.");
                }
                s += retrieveType(a.type, true);
                s += ' ';
                s += detokenize(a.name);
                System.out.println("Declaring variable(argument) " + a.name);
                vars.declareVariable(a.name, a.type);
                isFirst = false;
            }

            s += ")";

            writeLine(s);

            TranslatedLeaf translation = translateLeaf(method.content, vars, true);

            for (TranslationError error : translation.errors) {
                if (error.isFatal) {
                    throwError(error.generateFullErrorMessage());
                } else {
                    throwWarning(error.generateFullErrorMessage());
                }
            }
            
            if(!translation.assuresReturn&&!method.returnType.equals(Type.VOID)){
                TranslationError error = new TranslationError(true, null, vars,
                        "All code paths MUST return.");
                throwError(error.generateFullErrorMessage());
            }

            writeLine(translation.stringEquivalent);

            writeLine();
        }
    }

    private void writeStaticFields() throws Exception {
        for (Variable v : cls.variables) {
            if (!v.isStatic) {
                continue;
            }

            String s = retrieveType(v.type, true) + " " + detokenize(cls.clsName) + "::" + detokenize(v.name);
            if (v.defaultValue != null) {
                PineDLContext context2 = new PineDLContext((Function) null);
                s += " = ";
                TranslatedLeaf translation = translateLeaf(v.defaultValue, context2, false);
                for (TranslationError error : translation.errors) {
                    if (error.isFatal) {
                        throwError(error.generateFullErrorMessage());
                    } else {
                        throwWarning(error.generateFullErrorMessage());
                    }
                }
                s += translation.stringEquivalent;
            }
            /*ClassResource r = cmp.clsres.get(cls.clsName);
            if (r != null) {
            for (ClassResource.Field f : r.fields) {
            if (f.getName().equals(v.name)) {
            if (f.getDefaultValue() != null && !f.getDefaultValue().isEmpty()) {
            s += " = " + f.getDefaultValue();
            }
            break;
            }
            }
            }*/
            writeLine(s + ";");
        }
    }
}
