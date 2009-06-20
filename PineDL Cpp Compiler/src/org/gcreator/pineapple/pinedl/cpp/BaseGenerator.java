/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
import org.gcreator.pineapple.pinedl.PrimitiveType;
import org.gcreator.pineapple.pinedl.PineClass;
import org.gcreator.pineapple.pinedl.Type;
import org.gcreator.pineapple.pinedl.TypeCategory;
import java.util.Vector;
import java.io.InputStream;
import java.io.OutputStream;
import org.gcreator.pineapple.pinedl.AccessControlKeyword;
import org.gcreator.pineapple.pinedl.Leaf;
import org.gcreator.pineapple.pinedl.context.PineDLContext;
import org.gcreator.pineapple.pinedl.statements.BooleanConstant;
import org.gcreator.pineapple.pinedl.statements.DivisionOperation;
import org.gcreator.pineapple.pinedl.statements.DoubleConstant;
import org.gcreator.pineapple.pinedl.statements.IntConstant;
import org.gcreator.pineapple.pinedl.statements.LogicalAndOperation;
import org.gcreator.pineapple.pinedl.statements.LogicalOrOperation;
import org.gcreator.pineapple.pinedl.statements.MultiplyOperation;
import org.gcreator.pineapple.pinedl.statements.NewArray;
import org.gcreator.pineapple.pinedl.statements.NotOperation;
import org.gcreator.pineapple.pinedl.statements.NullConstant;
import org.gcreator.pineapple.pinedl.statements.StringConstant;
import org.gcreator.pineapple.pinedl.statements.SubtractionOperation;
import org.gcreator.pineapple.pinedl.statements.SumOperation;
import org.gcreator.pineapple.pinedl.statements.TypeCast;

/**
 * This base class provides methods for generating C++ code
 * from PineDL tokens from the parser and was created
 * to avoid having duplicate code in the {@link HGenerator}
 * and the {@link CppGenerator}.
 * 
 * @author Serge Humphrey
 */
public abstract class BaseGenerator {

    protected GameCompiler cmp = null;
    public PineClass cls = null;
    protected String fname = "";
    protected Vector<String> context = null;
    protected boolean successful = true;
    protected OutputStream out = null;
    protected InputStream in = null;

    /**
     * Creates a new {@link BaseGenerator}.
     */
    public BaseGenerator() {
    }

    protected String retrieveType(Type t, boolean reference) {
        if (t.typeCategory == TypeCategory.PRIMITIVE) {
            return typeToString(t, reference);
        }
        if (t.typeCategory == TypeCategory.ARRAY) {
            return "::Pineapple::Array<" + retrieveType(t.arrayType, reference) + ">*";
        }
        if (t.type.length != 1) {
            return typeToString(t, reference);
        }
        for (String s : context) {
            if (s.equals(t.type[t.type.length - 1])) {
                return s;
            }
        }
        for (Type type : cls.importStmt) {
            if (type.type[type.type.length - 1].equals(t.type[0])) {
                return typeToString(type, reference);
            }
        }
        if (t.type.length == 1) {
            if (t.type[0].equals("Texture")) {
                return "::Pineapple::Texture" + (reference ? "*" : "");
            } else if (t.type[0].equals("Actor")) {
                return "::Pineapple::Actor" + (reference ? "*" : "");
            } else if (t.type[0].equals("Scene")) {
                return "::Pineapple::Scene" + (reference ? "*" : "");
            } else if (t.type[0].equals("Math")) {
                return "::Pineapple::Math" + (reference ? "*" : "");
            } else if (t.type[0].equals("Key")) {
                return "::Pineapple::Key";// + (reference ? "*" : "");
            } else if (t.type[0].equals("Keyboard")) {
                return "::Pineapple::Keyboard" + (reference ? "*" : "");
            } else if (t.type[0].equals("Color")) {
                return "::Pineapple::Color";// + (reference ? "*" : "");
            } else if (t.type[0].equals("Drawing")) {
                return "::Pineapple::Drawing" + (reference ? "*" : "");
            }
        }
        throwError("In file " + fname + ": Unknown type " + t.toString());
        return "---";
    }

    protected String typeToString(Type t, boolean reference) {
        if (t.typeCategory == TypeCategory.ARRAY) {
            return "new ::Pineapple::Array<" + typeToString(t.arrayType, true) + ">*";
        }
        if (t.typeCategory == TypeCategory.PRIMITIVE) {
            if (t.primitiveType == PrimitiveType.BOOL) {
                return "bool";
            }
            if (t.primitiveType == PrimitiveType.CHAR) {
                return "char";
            }
            if (t.primitiveType == PrimitiveType.FLOAT) {
                return "double"; //This is intended (PineDL float = C double)
            }
            if (t.primitiveType == PrimitiveType.INT) {
                return "int";
            }
            if (t.primitiveType == PrimitiveType.VOID) {
                return "void";
            }
            if (t.primitiveType == PrimitiveType.STRING) {
                return "std::string";
            }
        }
        String x = t.type[0];
        for (int i = 1; i < t.type.length; i++) {
            x += "::";
            x += t.type[i];
        }
        if (reference) {
            x += '*';
        }
        return x;
    }

    protected void throwError(String error) {
        String message = "<font color='red'>";
        message += error;
        message += "</font>";
        successful = false;

        cmp.compFrame.writeLine(message);
    }

    protected String detokenize(String id) {
        if (id.startsWith("_")) {
            return id;
        }
        /*
         * The following aren't PineDL keywords, so the user
         * has the right to use them
         */
        if (id.equals("do")) {
            throwWarning("'do' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_do";
        }
        if (id.equals("unsigned")) {
            return "_K_unsigned";
        }
        if (id.equals("signed")) {
            return "_K_signed";
        }
        if (id.equals("switch")) {
            throwWarning("'switch' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_switch";
        }
        if (id.equals("case")) {
            throwWarning("'case' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_case";
        }
        if (id.equals("default")) {
            throwWarning("'default' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_default";
        }
        if (id.equals("NULL")) {
            return "_K_NULL";
        }
        if (id.equals("FILE")) {
            return "_K_FILE";
        }
        if (id.startsWith("SDL")) {
            return "_K_" + id;
        }
        if (id.equals("default")) {
            return "_K_default";
        }
        if (id.startsWith("GL") || id.startsWith("gl")) {
            return "_K_" + id;
        }
        if (id.equals("lambda")) {
            throwWarning("'lambda' is not a PineDL keyword, but may become in the future. Avoid using it");
            return id;
        }
        if (id.equals("repeat")) {
            throwWarning("'repeat' is not a PineDL keyword, but may become in the future. Avoid using it");
            return id;
        }
        if (id.equals("std")) {
            return "_K_" + id;
        }
        if (id.equals("virtual")) {
            return "_K_" + id;
        }
        if (id.equals("using")) {
            return "_K_" + id;
        }
        if (id.equals("namespace")) {
            return "_K_" + id;
        }

        return id;
    }

    protected String getHeaderTitle(String name) {
        String s = "__";

        s += name.toUpperCase();

        s += "_H__";
        return s;
    }

    public Type inspectLeafType(Leaf leaf, PineDLContext context) throws Exception {
        if (leaf instanceof StringConstant) {
            return Type.STRING;
        }
        if (leaf instanceof IntConstant) {
            return Type.INT;
        }
        if (leaf instanceof DoubleConstant) {
            return Type.FLOAT;
        }
        if (leaf instanceof BooleanConstant) {
            return Type.BOOL;
        }
        if (leaf instanceof NullConstant) {
            return null;
        }
        if (leaf instanceof NewArray) {
            Type t = new Type();
            t.typeCategory = TypeCategory.ARRAY;
            t.arrayType = ((NewArray) leaf).type;
            return t;
        }
        if (leaf instanceof SumOperation) {
            SumOperation sum = (SumOperation) leaf;
            Type leftType = inspectLeafType(sum.left, context);
            Type rightType = inspectLeafType(sum.right, context);
            if (leftType.typeCategory != TypeCategory.PRIMITIVE) {
                throw new Exception("Invalid type");
            }
            if (rightType.typeCategory != TypeCategory.PRIMITIVE) {
                throw new Exception("Invalid type"); //If, in the future, a toString()
            //function gets defined, then this may become possible
            }
            if (leftType.primitiveType == PrimitiveType.STRING) {
                return leftType;
            }
            //Right-sided strings are only acceptable
            //If left side is a string as well.
            if (rightType.primitiveType == PrimitiveType.STRING) {
                throw new Exception("Invalid type");
            }
            if (leftType.primitiveType == PrimitiveType.BOOL) {
                throw new Exception("Invalid type");
            }
            //Bool on the right is only acceptable
            //If left side is a string
            if (rightType.primitiveType == PrimitiveType.BOOL) {
                throw new Exception("Invalid type");
            }
            if (leftType.primitiveType == PrimitiveType.FLOAT || rightType.primitiveType == PrimitiveType.FLOAT) {
                return Type.FLOAT;
            }
            if (leftType.primitiveType == PrimitiveType.INT ||
                    rightType.primitiveType == PrimitiveType.INT) {
                return Type.INT;
            }
            /////CHAR SUPPORT!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            return null; //The only thing left, I suppose
        }
        if (leaf instanceof SubtractionOperation) {
            SubtractionOperation op = (SubtractionOperation) leaf;
            Type leftType = inspectLeafType(op.left, context);
            Type rightType = inspectLeafType(op.right, context);
            return multLikeOperationHandler(leftType, rightType);
        }
        if (leaf instanceof MultiplyOperation) {
            MultiplyOperation op = (MultiplyOperation) leaf;
            Type leftType = inspectLeafType(op.left, context);
            Type rightType = inspectLeafType(op.right, context);
            return multLikeOperationHandler(leftType, rightType);
        }
        if (leaf instanceof DivisionOperation) {
            DivisionOperation op = (DivisionOperation) leaf;
            Type leftType = inspectLeafType(op.left, context);
            Type rightType = inspectLeafType(op.right, context);
            return multLikeOperationHandler(leftType, rightType);
        }
        if (leaf instanceof TypeCast) {
            return ((TypeCast) leaf).type;
        }
        if (leaf instanceof LogicalAndOperation) {
            LogicalAndOperation op = (LogicalAndOperation) leaf;
            Leaf left = op.left;
            Leaf right = op.right;
            return logicOperationHandler(
                    inspectLeafType(left, context),
                    inspectLeafType(right, context));
        }
        if (leaf instanceof LogicalOrOperation) {
            LogicalOrOperation op = (LogicalOrOperation) leaf;
            Leaf left = op.left;
            Leaf right = op.right;
            return logicOperationHandler(
                    inspectLeafType(left, context),
                    inspectLeafType(right, context));
        }
        if (leaf instanceof NotOperation) {
            NotOperation op = (NotOperation) leaf;
            Type type = inspectLeafType(op.exp, context);
            if (type.typeCategory != TypeCategory.PRIMITIVE) {
                throw new Exception("Invalid type");
            }
            if (type.primitiveType != PrimitiveType.BOOL) {
                throw new Exception("Invalid type");
            }
            return Type.BOOL;
        }
        throw new Exception("Unrecognized type");
    }

    public Type TypeFunction(Type type, String fname, Type... arguments)
            throws Exception {
        if (type.typeCategory == TypeCategory.PRIMITIVE) {
            if (type.primitiveType == PrimitiveType.STRING && fname.equals("getLength")) {
                return Type.INT; //getLength() returns int
            }
            throw new Exception("No such function");
        }
        if (type.typeCategory == TypeCategory.ARRAY) {
            if (fname.equals("getLength")) {
                return Type.INT;
            }
            throw new Exception("No such function");
        }
        String[] clsName = type.type;
        
        GlobalLibrary.ClassDefinition definition = classFromName(clsName);
        
        if(definition==null){
            throw new Exception("Invalid class");
        }
        
        return ClassTypeFunction(definition, fname, arguments);
    }

    public GlobalLibrary.ClassDefinition classFromName(String[] clsName){
        return null;
    }
    
    private Type ClassTypeFunction
            (GlobalLibrary.ClassDefinition definition, String fname, Type... arguments)
            throws Exception {

        Vector<GlobalLibrary.MethodDefinition> methods = definition.getMethods(fname);
        
        if(methods.size()==0){
            throw new Exception("Function not found");
        }
        
        methodLoop:
        for(GlobalLibrary.MethodDefinition method : methods){
            int index = 0;
            for(GlobalLibrary.VariableDefinition arg : method.arguments){
                if(index>=arguments.length){
                    if(arg.defaultValue==null){
                        return method.returnType;
                    }
                    continue methodLoop;
                }
                Type argType = arg.type;
                if(!typeMatches(argType, arg.type)){
                    continue methodLoop;
                }
            }
        }

        throw new Exception("Invalid arguments");
    }
    
    //Note that if t2 extends t1, then true
    public boolean typeMatches(Type t1, Type t2)
    throws Exception{
        if(t1.typeCategory!=t2.typeCategory){
            return false;
        }
        if(t1.typeCategory==TypeCategory.PRIMITIVE){
            return t1.primitiveType==t2.primitiveType;
        }
        if(t1.typeCategory==TypeCategory.ARRAY){
            return typeMatches(t1.arrayType, t2.arrayType);
        }
        String[] type1 = t1.type;
        String[] type2 = t2.type;
        GlobalLibrary.ClassDefinition cls1 = classFromName(type1);
        GlobalLibrary.ClassDefinition cls2 = classFromName(type2);
        if(cls1==null||cls2==null){
            throw new Exception("Unrecognized class");
        }
        return cls2.inheritsFrom(cls1);
    }

    private Type logicOperationHandler(Type left, Type right) throws Exception {
        if (left.typeCategory != TypeCategory.PRIMITIVE) {
            throw new Exception("Invalid type");
        }
        if (right.typeCategory != TypeCategory.PRIMITIVE) {
            throw new Exception("Invalid type");
        }
        if (left.primitiveType != PrimitiveType.BOOL) {
            throw new Exception("Invalid type");
        }
        if (right.primitiveType != PrimitiveType.BOOL) {
            throw new Exception("Invalid type");
        }
        return Type.BOOL;
    }

    private Type multLikeOperationHandler(Type left, Type right) throws Exception {
        if (left.typeCategory != TypeCategory.PRIMITIVE) {
            throw new Exception("Invalid type");
        }
        if (right.typeCategory != TypeCategory.PRIMITIVE) {
            throw new Exception("Invalid type");
        }
        PrimitiveType leftType = left.primitiveType;
        PrimitiveType rightType = right.primitiveType;
        if (leftType == PrimitiveType.STRING || rightType == PrimitiveType.STRING) {
            throw new Exception("Invalid type");
        }
        if (leftType == PrimitiveType.BOOL || rightType == PrimitiveType.BOOL) {
            throw new Exception("Invalid type");
        }
        if (leftType == PrimitiveType.FLOAT || rightType == PrimitiveType.FLOAT) {
            return Type.FLOAT;
        }
        if (leftType == PrimitiveType.INT || rightType == PrimitiveType.INT) {
            return Type.INT;
        }
        //DEAL WITH CHAR SOME TIME!!!
        return null;
    }

    protected void writeLine() throws IOException {
        out.write('\n');
    }

    protected void writeLine(String line) throws IOException {
        out.write(line.getBytes());
        out.write('\n');
    }

    protected void throwWarning(String warning) {
        String message = "[WARNING] ";
        message += warning;

        cmp.compFrame.writeLine(message);
    }

    protected String accessToString(AccessControlKeyword k) {
        if (k == AccessControlKeyword.PRIVATE) {
            return "private";
        }
        if (k == AccessControlKeyword.PROTECTED) {
            return "protected";
        }
        return "public";
    }
}
