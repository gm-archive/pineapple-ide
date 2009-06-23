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
import org.gcreator.pineapple.pinedl.Leaf;
import org.gcreator.pineapple.pinedl.PineClass;
import org.gcreator.pineapple.pinedl.Type;
import org.gcreator.pineapple.pinedl.Variable;
import org.gcreator.pineapple.pinedl.context.PineDLContext;
import org.gcreator.pineapple.pinedl.statements.ArrayReference;
import org.gcreator.pineapple.pinedl.statements.Block;
import org.gcreator.pineapple.pinedl.statements.BooleanConstant;
import org.gcreator.pineapple.pinedl.statements.DeclAssign;
import org.gcreator.pineapple.pinedl.statements.DivisionOperation;
import org.gcreator.pineapple.pinedl.statements.DoubleConstant;
import org.gcreator.pineapple.pinedl.statements.EqualOperation;
import org.gcreator.pineapple.pinedl.statements.EqualsOperation;
import org.gcreator.pineapple.pinedl.statements.Expression;
import org.gcreator.pineapple.pinedl.statements.FunctionReference;
import org.gcreator.pineapple.pinedl.statements.IfStatement;
import org.gcreator.pineapple.pinedl.statements.IntConstant;
import org.gcreator.pineapple.pinedl.statements.LessEqualOperation;
import org.gcreator.pineapple.pinedl.statements.LessOperation;
import org.gcreator.pineapple.pinedl.statements.ModOperation;
import org.gcreator.pineapple.pinedl.statements.MoreEqualOperation;
import org.gcreator.pineapple.pinedl.statements.MoreOperation;
import org.gcreator.pineapple.pinedl.statements.MultiplyOperation;
import org.gcreator.pineapple.pinedl.statements.NegationOperation;
import org.gcreator.pineapple.pinedl.statements.NewArray;
import org.gcreator.pineapple.pinedl.statements.NewCall;
import org.gcreator.pineapple.pinedl.statements.PrePostFixOperator;
import org.gcreator.pineapple.pinedl.statements.Reference;
import org.gcreator.pineapple.pinedl.statements.RetrieverExpression;
import org.gcreator.pineapple.pinedl.statements.StringConstant;
import org.gcreator.pineapple.pinedl.statements.SubtractionOperation;
import org.gcreator.pineapple.pinedl.statements.SumOperation;
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

    public boolean isType(String t) {
        return classFromName(new String[]{t})!=null;
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
            PineDLContext vars = new PineDLContext("<constructor>");
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

                    s += leafToString(exp, vars);

                    isFirst = false;
                }
                s += ')';
            }

            writeLine(s);
            String content = leafToString(c.content, vars);
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
            PineDLContext vars = new PineDLContext(method.name);
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
                vars.declareVariable(a.name, a.type);
                isFirst = false;
            }

            s += ")";

            writeLine(s);

            writeLine(leafToString(method.content, vars));

            writeLine();
        }
    }

    private void writeStaticFields() throws Exception {
        for (Variable v : cls.variables) {
            if (!v.isStatic) {
                continue;
            }
            
            String s = retrieveType(v.type, true) + " "
                    + detokenize(cls.clsName) + "::" + detokenize(v.name);
            if(v.defaultValue!=null){
                PineDLContext context2 = new PineDLContext("<none>");
                s += " = ";
                s += leafToString(v.defaultValue, context2);
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

    private String leafToString(Leaf l, PineDLContext vars) throws Exception {
        return leafToString(l, false, vars);
    }

    private String leafToString(Leaf l, boolean statement, PineDLContext vars) throws Exception {
        return leafToString(l, statement, vars, true);
    }

   private String leafToString(Leaf l, boolean statement, PineDLContext vars, boolean isLeft) throws Exception {
        String s = _leafToString(l, statement, vars, isLeft);
        //System.out.print("\t{ ");
        //System.out.println("In: " + l + ((l != null) ? " (" + l.getClass().getName() + ")" : ""));
        //System.out.println("\tstatement: "+ statement +", vars: " + vars + ", left: " + isLeft+((l instanceof Reference) ? ", is type: "+isType((Reference)l) : ""));
        //System.out.println("Out: " + s);
        //System.out.println("}");
        return s;
    }

    private String _leafToString(Leaf l, boolean statement, PineDLContext vars, boolean isLeft) throws Exception {
        if (l == null) {
            //throw new NullPointerException("AHHHH! Null leaf!");
            return "roflcopter";
        }
        if (l instanceof NegationOperation) {
            return "-"+leafToString(((NegationOperation)l).exp, vars);
        }
        if (l instanceof BooleanConstant) {
            return String.valueOf(((BooleanConstant) l).value);
        }
        if (l instanceof Block) {
            PineDLContext c = new PineDLContext(vars);
            c.declareVariable("this", new Type(fname));
            String s = "{\n";

            for (Leaf leaf : ((Block) l).content) {
                s += leafToString(leaf, true, c) + "\n";
            }

            return s + "}";
        }
        if (l instanceof DeclAssign) {
            DeclAssign da = (DeclAssign) l;
            System.out.println("Reached DeclAssign with" + typeToString(da.type, false));
            if (vars.isVariableDeclared(da.name)) {
                throw new Exception("In function " + vars.getFunctionName() + ": " + "Redeclaring variable '" + da.name + "'");
            }
            Type t1 = da.type;
            
            vars.declareVariable(da.name, t1);
            String s = retrieveType(t1, true);
            s += " " + detokenize(da.name);
            if (da.value != null) {
                Type t2 = inspectLeafType(da.value, vars);
                if(!typeMatches(da.type, inspectLeafType(da.value, vars))){
                    throw new Exception("In function "+ vars.getFunctionName() + ": "
                            + "Attempting to assign type " + t2 +
                            " to variable of type " + t1);
                }
                s += " = " + leafToString(da.value, vars);
            }
            if (statement) {
                s += ';';
            }
            return s;
        }
        if (l instanceof EqualOperation) {
            EqualOperation e = (EqualOperation) l;
            Type t1 = inspectLeafType(e.left, vars);
            System.out.println("Left is " + e.left);
            System.out.println("Right is " + e.right);
            Type t2 = inspectLeafType(e.right, vars);
            System.out.println("t1="+t1);
            System.out.println("t2="+t2);
            if(!typeMatches(t1, t2)){
                throw new Exception("In function "+ vars.getFunctionName() + ": "
                            + "Attempting to assign type " + t2 +
                            " to variable or field of type " + t1);
            }
            String s = leafToString(e.left, vars) + " = " + leafToString(e.right, vars);
            if (statement) {
                s += ';';
            }
            return s;
        }
        if (l instanceof SumOperation) {
            SumOperation s = (SumOperation) l;
            return leafToString(s.left, vars) + " + " + leafToString(s.right, vars);
        }
        if (l instanceof PrePostFixOperator) {
            PrePostFixOperator s = (PrePostFixOperator) l;
            if (s.pre) {
                return (s.sum ? "++" : "--") + leafToString(s.content, vars) + (statement ? ";" : "");
            }
            return leafToString(s.content, vars) + (s.sum ? "++" : "--") + (statement ? ";" : "");
        }
        if (l instanceof SubtractionOperation) {
            SubtractionOperation s = (SubtractionOperation) l;
            return "(" + leafToString(s.left, vars) + " - " + leafToString(s.right, vars) + ")";
        }
        if (l instanceof MultiplyOperation) {
            MultiplyOperation s = (MultiplyOperation) l;
            return leafToString(s.left, vars) + " * " + leafToString(s.right, vars);
        }
        if (l instanceof DivisionOperation) {
            DivisionOperation s = (DivisionOperation) l;
            return leafToString(s.left, vars) + " / " + leafToString(s.right, vars);
        }
        //!
        if (l instanceof LessOperation) {
            LessOperation s = (LessOperation) l;
            return leafToString(s.left, vars) + " < " + leafToString(s.right, vars);
        }
        if (l instanceof MoreOperation) {
            MoreOperation s = (MoreOperation) l;
            return leafToString(s.left, vars) + " > " + leafToString(s.right, vars);
        }
        if (l instanceof LessEqualOperation) {
            LessEqualOperation s = (LessEqualOperation) l;
            return leafToString(s.left, vars) + " <= " + leafToString(s.right, vars);
        }
        if (l instanceof MoreEqualOperation) {
            MoreEqualOperation s = (MoreEqualOperation) l;
            return leafToString(s.left, vars) + " >= " + leafToString(s.right, vars);
        }
        if (l instanceof IntConstant) {
            return l.toString();
        }
        if (l instanceof DoubleConstant) {
            return l.toString();
        }
        if (l instanceof StringConstant) {
            return l.toString();
        }
        if (l instanceof FunctionReference) {
            FunctionReference e = (FunctionReference) l;
            String x = e.name;
            x += '(';
            boolean isFirst = true;
            for (Expression exp : e.arguments) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    x += ", ";
                }

                x += leafToString(exp, false, vars);
            }
            x += ')';
            if (statement) {
                x += ';';
            }
            return x;
        }
        if (l instanceof NewCall) {
            NewCall n = (NewCall) l;
            String s = "new ";
            s += typeToString(n.type, false);
            s += '(';

            boolean first = true;
            for (Expression e : n.arguments) {
                if (!first) {
                    s += ", ";
                }
                s += leafToString(e, vars);
                first = false;
            }

            s += ')';
            if (statement) {
                s += ';';
            }
            return s;
        }
        if (l instanceof IfStatement) {
            IfStatement i = (IfStatement) l;
            String s = "if (";
            String le = leafToString(i.condition, vars);
            s += le;
            s += ")\n{";
            PineDLContext cvars = new PineDLContext(vars);
            s += leafToString(i.then, true, cvars);
            s += "}\n";
            if (i.elseCase != null) {
                s += "else\n{";
                PineDLContext cvars2 = new PineDLContext(vars);
                s += leafToString(i.elseCase, true, cvars2);
                s += "}";
            }
            return s;
        }
        if (l instanceof VariableReference) {
            if (isType((VariableReference) l) && isLeft) {
                String name = ((VariableReference) l).name;
                return name.replaceAll("\\.", "::");
            }
            return ((VariableReference) l).name;
        }
        if (l instanceof RetrieverExpression) {
            RetrieverExpression e = (RetrieverExpression) l;
            if (isType(e) && isLeft) {
                return e.toString().replaceAll("\\.", "::");
            } else if (e.left instanceof RetrieverExpression) {
                boolean istype = isType(e.left) && isLeft;
                String s = leafToString(e.left, false, vars);
                String t = leafToString(e.right, false, vars, false);
                return s + (istype ? "::" : "->") + t;
            } else if (e.left instanceof VariableReference) {
                boolean istype = isType(e.left) && isLeft;
                boolean declared = vars.isVariableDeclared(e.left.toString());
                if (!declared && isLeft) {
                    if (istype) {
                        String tname = e.left.toString();
                    } else {
                        String tname = e.left.toString();
                        if (!vars.isVariableDeclared(tname) && !cls.variables.contains(tname)) {
                            throwError("In class " + cls.clsName + ", " + "function " + vars.getFunctionName() + ":\n'" + tname + "' does not name a" + " type or a variable.");
                        }
                    }
                }
                PineDLContext newContext = new PineDLContext(vars);
                return (declared ? "" : "::") + leafToString(e.left, false, vars) + (istype ? "::" : "->") +
                        leafToString(e.right, false, newContext, false) + (statement ? ";" : "");
            }
            return leafToString(e.left, false, vars) + "->" + leafToString(e.right, false, vars, false);
        }
        if (l instanceof ModOperation) {
            ModOperation m = (ModOperation) l;
            return leafToString(m.left, false, vars) + " % " + leafToString(m.right, false, vars);
        }
        if (l instanceof EqualsOperation) {
            EqualsOperation e = (EqualsOperation) l;
            return leafToString(e.left, false, vars) + " == " + leafToString(e.right, false, vars);
        }
        if (l instanceof NewArray) {
            NewArray e = (NewArray) l;
            return "new Array<" + typeToString(e.type, true) + ">(" +
                    leafToString(e.size, false, vars) + ")" +
                    (statement ? ";" : "");
        }
        if (l instanceof ArrayReference) {
            ArrayReference ar = (ArrayReference) l;
            return "(*" +leafToString(ar.base, false, vars) + ")[" + leafToString(ar.exp, false, vars)
                    + "]";
        }

        System.out.println("Oh NOES! No stuffles for " + l + " of class " + l.getClass().getName());
        System.out.println("\t oh well just returning " + l.toString());
        return l.toString();
    }
}
