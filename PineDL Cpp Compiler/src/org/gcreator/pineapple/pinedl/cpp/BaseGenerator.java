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
import java.io.OutputStream;
import java.util.Arrays;
import javax.swing.SwingUtilities;
import org.gcreator.pineapple.pinedl.AccessControlKeyword;
import org.gcreator.pineapple.pinedl.Leaf;
import org.gcreator.pineapple.pinedl.context.PineDLContext;
import org.gcreator.pineapple.pinedl.statements.ArrayReference;
import org.gcreator.pineapple.pinedl.statements.BinaryOperation;
import org.gcreator.pineapple.pinedl.statements.BitwiseAndOperation;
import org.gcreator.pineapple.pinedl.statements.BitwiseBinaryOperation;
import org.gcreator.pineapple.pinedl.statements.BitwiseOrOperation;
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
import org.gcreator.pineapple.pinedl.statements.LogicalAndOperation;
import org.gcreator.pineapple.pinedl.statements.LogicalBinaryOperation;
import org.gcreator.pineapple.pinedl.statements.LogicalOrOperation;
import org.gcreator.pineapple.pinedl.statements.ModOperation;
import org.gcreator.pineapple.pinedl.statements.MoreEqualOperation;
import org.gcreator.pineapple.pinedl.statements.MoreOperation;
import org.gcreator.pineapple.pinedl.statements.MultiplyOperation;
import org.gcreator.pineapple.pinedl.statements.NegationOperation;
import org.gcreator.pineapple.pinedl.statements.NequalOperation;
import org.gcreator.pineapple.pinedl.statements.NewArray;
import org.gcreator.pineapple.pinedl.statements.NewCall;
import org.gcreator.pineapple.pinedl.statements.PrePostFixOperator;
import org.gcreator.pineapple.pinedl.statements.RetrieverExpression;
import org.gcreator.pineapple.pinedl.statements.ReturnStatement;
import org.gcreator.pineapple.pinedl.statements.StringConstant;
import org.gcreator.pineapple.pinedl.statements.SubtractionOperation;
import org.gcreator.pineapple.pinedl.statements.SumOperation;
import org.gcreator.pineapple.pinedl.statements.TypeCast;
import org.gcreator.pineapple.pinedl.statements.VariableReference;
import org.gcreator.pineapple.pinedl.statements.WhileStatement;

/**
 * This base class provides methods for generating C++ code
 * from PineDL tokens from the parser and was created
 * to avoid having duplicate code in the {@link HGenerator}
 * and the {@link CppGenerator}.
 *
 * @author Luís Reis
 * @author Serge Humphrey
 */
public abstract class BaseGenerator {

    protected GameCompiler cmp = null;
    public PineClass cls = null;
    protected String fname = "";
    protected OutputStream out = null;
    public boolean successful = true;

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
            return "::Pineapple::Array<" + retrieveType(t.arrayType, reference) + ">" + (reference ? "*" : "");
        }
        if (t.type.length != 1) {
            return typeToString(t, reference);
        }

        GlobalLibrary.ClassDefinition definition = classFromName(t.type);
        if (definition != null) {
            String[] fullName = new String[definition.packageName.length + 1];
            for (int i = 0; i < definition.packageName.length; i++) {
                fullName[i] = definition.packageName[i];
            }
            fullName[fullName.length - 1] = definition.name;
            Type type = new Type();
            type.typeCategory = TypeCategory.CLASS;
            type.type = fullName;
            return definition.exportCppType() + (reference ? "*" : "");
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
        final String msg = message;
        System.out.println(msg);
        GameCompiler.compFrame.writeLine(msg);
    }

    protected String detokenize(String id) {
        if (id.startsWith("_")) {
            return "_U_" + id;
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

    public TranslatedLeaf translateLeaf(Leaf leaf, PineDLContext context, boolean isStatement) {
        return translateLeaf(leaf, context, isStatement, false);
    }

    public TranslatedLeaf translateLeaf(Leaf leaf, PineDLContext context, boolean isStatement,
            boolean inRetrieverExpression) {
        TranslatedLeaf translation = new TranslatedLeaf();
        translation.equivalentLeaf = leaf;
        if (leaf == null) {
            translation.errors.add(
                    new TranslationError(true, leaf, context, "Found null leaf\n" +
                    "Please report this error to the development team."));
            translation.stringEquivalent = "/* FAILURE */";
            return translation;
        }
        if (leaf instanceof NegationOperation) {
            NegationOperation op = (NegationOperation) leaf;
            TranslatedLeaf child = translateLeaf(op.exp, context, false);
            translation.errors.addAll(child.errors);
            Type childType = child.inspectedType;
            if (childType.typeCategory == TypeCategory.CLASS) {
                translation.errors.add(
                        new TranslationError(true, leaf, context,
                        "Attempting to find additive inverse of class."));
            } //we split class from arrays for more relevant error messages.
            else if (childType.typeCategory == TypeCategory.ARRAY) {
                translation.errors.add(
                        new TranslationError(true, leaf, context,
                        "Attempting to find additive inverse of array."));
            } else {
                if (childType.primitiveType == PrimitiveType.STRING) {
                    translation.errors.add(
                            new TranslationError(true, leaf, context,
                            "Attempting to find additive inverse of string."));
                } else if (childType.primitiveType == PrimitiveType.BOOL) {
                    translation.errors.add(
                            new TranslationError(true, leaf, context,
                            "Attempting to find additive inverse of boolean."));
                } else if (childType.primitiveType == PrimitiveType.CHAR) {
                    translation.errors.add(
                            new TranslationError(true, leaf, context,
                            "Attempting to find additive inverse of boolean."));
                } else {
                    translation.inspectedType = childType;
                }
            }

            translation.stringEquivalent = "-" + child.stringEquivalent;
        } else if (leaf instanceof BooleanConstant) {
            translation.inspectedType = Type.BOOL;
            translation.stringEquivalent = String.valueOf(((BooleanConstant) leaf).value);
        } else if (leaf instanceof IntConstant) {
            translation.inspectedType = Type.INT;
            translation.stringEquivalent = String.valueOf(((IntConstant) leaf).value);
        } else if (leaf instanceof DoubleConstant) {
            translation.inspectedType = Type.FLOAT;
            translation.stringEquivalent = String.valueOf(((DoubleConstant) leaf).value);
        } else if (leaf instanceof StringConstant) {
            translation.inspectedType = Type.STRING;
            translation.stringEquivalent = leaf.toString();
        } else if (leaf instanceof Block) {
            Block block = (Block) leaf;
            PineDLContext newContext = new PineDLContext(context);
            newContext.declareVariable("this", new Type(fname));
            translation.stringEquivalent = "{\n";

            childLoop:
            for (Leaf childLeaf : block.content) {
                TranslatedLeaf child = translateLeaf(childLeaf, newContext, true);
                translation.errors.addAll(child.errors);
                translation.stringEquivalent += child.stringEquivalent;
                if (child.assuresReturn) {
                    translation.assuresReturn = true;
                    if (childLeaf != block.content.lastElement()) {
                        translation.errors.add(new TranslationError(
                                false, leaf, context, "Unreachable statements"));
                    }
                    break childLoop;
                }
            }

            translation.inspectedType = null; //Not an expression
            translation.stringEquivalent += "}\n";
        } else if (leaf instanceof DeclAssign) {
            DeclAssign declaration = (DeclAssign) leaf;
            if (context.isVariableDeclared(declaration.name)) {
                translation.errors.add(new TranslationError(
                        true, leaf, context, "Redeclaring variable " + declaration.name));
            }
            Type type = declaration.type;
            //Although there is a type involved, the statement itself is not an expression
            translation.inspectedType = null;
            translation.stringEquivalent = retrieveType(type, true);
            translation.stringEquivalent += " " + detokenize(declaration.name);
            if (declaration.value != null) {
                TranslatedLeaf value = translateLeaf(
                        declaration.value, context, false);
                Type valueType = value.inspectedType;
                translation.errors.addAll(value.errors);

                try {
                    if (!typeMatches(type, valueType)) {
                        //Maybe later we'll want to add some more
                        //checks for primitive types
                        translation.errors.add(new TranslationError(true,
                                declaration,
                                context,
                                "Implicitly converting " + valueType + " to " + type));
                    }
                } catch (PineClassNotFoundException e) {
                    translation.errors.add(new TranslationError(true,
                            declaration,
                            context,
                            "Class not found exception"));
                }
                translation.stringEquivalent += " = " + value.stringEquivalent;
            }
            context.declareVariable(declaration.name, declaration.type);
        } else if (leaf instanceof EqualOperation) {
            EqualOperation operation = (EqualOperation) leaf;
            System.out.println("operation.left=" + operation.left.toString());
            System.out.println("operation.right=" + operation.right.toString());
            TranslatedLeaf left = translateLeaf(operation.left, context, false);
            TranslatedLeaf right = translateLeaf(operation.right, context, false);
            translation.errors.addAll(left.errors);
            translation.errors.addAll(right.errors);
            System.out.println("Method=" + cls.clsName + "." + context.getFunctionName());
            Type leftType = left.inspectedType;
            System.out.println("leftType=" + leftType);
            Type rightType = right.inspectedType;
            System.out.println("rightType=" + rightType);
            if (leftType == null) {
                translation.stringEquivalent = "/*INVALID*/";
            } else if (leftType.equals(Type.FLOAT) && rightType.equals(Type.INT)) {
                translation.stringEquivalent = left.stringEquivalent + " = (float) " + right.stringEquivalent;
            } else {
                try {
                    if (!typeMatches(leftType, rightType)) {
                        translation.errors.add(new TranslationError(true,
                                operation,
                                context,
                                "Implicitly converting " + rightType + " to " + leftType));
                    }
                } catch (PineClassNotFoundException e) {
                    translation.errors.add(new TranslationError(true,
                            operation,
                            context,
                            "Class not found exception"));
                }
                translation.stringEquivalent = left.stringEquivalent + " = " + right.stringEquivalent;
            }
            translation.inspectedType = leftType;
        } else if (leaf instanceof SumOperation) {
            SumOperation operation = (SumOperation) leaf;
            TranslatedLeaf leftLeaf = translateLeaf(operation.left, context, false);
            TranslatedLeaf rightLeaf = translateLeaf(operation.right, context, false);
            translation.errors.addAll(leftLeaf.errors);
            translation.errors.addAll(rightLeaf.errors);
            Type leftType = leftLeaf.inspectedType;
            Type rightType = rightLeaf.inspectedType;
            if (leftType.typeCategory != TypeCategory.PRIMITIVE) {
                translation.errors.add(new TranslationError(true,
                        operation,
                        context,
                        "Attempting to use type " + leftType + " in a sum"));
            }
            if (rightType.typeCategory != TypeCategory.PRIMITIVE) {
                translation.errors.add(new TranslationError(true,
                        operation,
                        context,
                        "Attempting to use type " + rightType + " in a sum"));
            //If, in the future, a toString()
            //function gets defined, then this may become possible
            }
            if (leftType.primitiveType == PrimitiveType.STRING) {
                translation.inspectedType = Type.STRING;
            } //Right-sided strings are only acceptable
            //If left side is a string as well.
            else {
                if (rightType.primitiveType == PrimitiveType.STRING) {
                    translation.errors.add(new TranslationError(true,
                            operation,
                            context,
                            "Attempting to use non-string + string"));
                }
                if (leftType.primitiveType == PrimitiveType.BOOL) {
                    translation.errors.add(new TranslationError(true,
                            operation,
                            context,
                            "Attempting to use a boolean on the left side of a sum"));
                }
                //Bool on the right is only acceptable
                //If left side is a string
                if (rightType.primitiveType == PrimitiveType.BOOL) {
                    translation.errors.add(new TranslationError(true,
                            operation,
                            context,
                            "Booleans can only be on the right side of a sum if the left side is a string."));
                }
                if (leftType.primitiveType == PrimitiveType.FLOAT || rightType.primitiveType == PrimitiveType.FLOAT) {
                    translation.inspectedType = Type.FLOAT;
                } else if (leftType.primitiveType == PrimitiveType.INT ||
                        rightType.primitiveType == PrimitiveType.INT) {
                    translation.inspectedType = Type.INT;
                } else {
                    translation.inspectedType = Type.CHAR;
                }
            }
            translation.stringEquivalent = "(" + leftLeaf.stringEquivalent + ") + (" + rightLeaf.stringEquivalent + ')';
        } else if (leaf instanceof PrePostFixOperator) {
            PrePostFixOperator operator = (PrePostFixOperator) leaf;
            TranslatedLeaf content = translateLeaf(
                    operator.content, context, false);
            Type contentType = content.inspectedType;
            translation.errors.addAll(content.errors);
            if (contentType.typeCategory != TypeCategory.PRIMITIVE) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Using ++ or -- operator on non-primitive type."));
            } else if (contentType.primitiveType != PrimitiveType.INT) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Using ++ or -- operator on non-integer type."));
            }
            translation.inspectedType = Type.INT;
            translation.stringEquivalent = "(";
            if (operator.pre) {
                translation.stringEquivalent = (operator.sum ? "++" : "--");
            }

            translation.stringEquivalent += content.stringEquivalent;

            if (!operator.pre) {
                translation.stringEquivalent += (operator.sum ? "++)" : "--)");
            } else {
                translation.stringEquivalent += ')';
            }

        } else if (leaf instanceof SubtractionOperation || leaf instanceof MultiplyOperation || leaf instanceof DivisionOperation) {
            BinaryOperation operation = (BinaryOperation) leaf;
            TranslatedLeaf leftLeaf = translateLeaf(operation.left, context, false);
            TranslatedLeaf rightLeaf = translateLeaf(operation.right, context, false);
            translation.errors.addAll(leftLeaf.errors);
            translation.errors.addAll(rightLeaf.errors);
            Type leftType = leftLeaf.inspectedType;
            Type rightType = rightLeaf.inspectedType;
            if (leftType.typeCategory != TypeCategory.PRIMITIVE || rightType.typeCategory != TypeCategory.PRIMITIVE) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Only primitive types can be used in -, * and / operations"));
            }
            PrimitiveType leftPrimitive = leftType.primitiveType;
            PrimitiveType rightPrimitive = rightType.primitiveType;
            if (leftPrimitive == PrimitiveType.STRING || rightPrimitive == PrimitiveType.STRING) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Using string on -, * or / operation"));
            }
            if (leftPrimitive == PrimitiveType.BOOL || rightPrimitive == PrimitiveType.BOOL) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Using boolean on -, * or / operation"));
            }
            translation.inspectedType = Type.FLOAT;
            if (leftPrimitive != PrimitiveType.FLOAT && rightPrimitive != PrimitiveType.FLOAT) {
                translation.inspectedType = leftPrimitive == PrimitiveType.INT ||//
                        rightPrimitive == PrimitiveType.INT ? Type.INT : Type.CHAR;
            }
            translation.stringEquivalent = "(" + leftLeaf.stringEquivalent;
            translation.stringEquivalent += ") ";
            if (leaf instanceof SubtractionOperation) {
                translation.stringEquivalent += '-';
            } else if (leaf instanceof MultiplyOperation) {
                translation.stringEquivalent += '*';
            } else if (leaf instanceof DivisionOperation) {
                translation.stringEquivalent += '/';
            }
            translation.stringEquivalent += " (" + rightLeaf.stringEquivalent;
            translation.stringEquivalent += ')';
        //some comments are just there
        //to make sure NetBeans'
        //"Format" feature does not
        //suppress the line breaks
        } else if (leaf instanceof ModOperation) {
            ModOperation mod = (ModOperation) leaf;
            TranslatedLeaf left = translateLeaf(mod.left, context, false);
            translation.errors.addAll(left.errors);
            TranslatedLeaf right = translateLeaf(mod.right, context, false);
            translation.errors.addAll(right.errors);
            Type leftType = left.inspectedType;
            Type rightType = right.inspectedType;
            if (leftType.typeCategory != TypeCategory.PRIMITIVE //
                    || leftType.primitiveType != PrimitiveType.INT //
                    || rightType.typeCategory != TypeCategory.PRIMITIVE //
                    || rightType.primitiveType != PrimitiveType.INT) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Only integers can be used in % operations."));
            }
            translation.stringEquivalent = "(" + left.stringEquivalent;
            translation.stringEquivalent += ")%(";
            translation.stringEquivalent += right.stringEquivalent;
            translation.stringEquivalent += ')';
        } else if (leaf instanceof LessOperation || leaf instanceof MoreOperation || //
                leaf instanceof LessEqualOperation || leaf instanceof MoreEqualOperation) {
            BinaryOperation operation = (BinaryOperation) leaf;
            TranslatedLeaf leftLeaf = translateLeaf(operation.left, context, false);
            TranslatedLeaf rightLeaf = translateLeaf(operation.right, context, false);
            translation.errors.addAll(leftLeaf.errors);
            translation.errors.addAll(rightLeaf.errors);
            Type leftType = leftLeaf.inspectedType;
            Type rightType = rightLeaf.inspectedType;
            if (leftType.typeCategory != TypeCategory.PRIMITIVE || rightType.typeCategory != TypeCategory.PRIMITIVE) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Only primitive types can be used in comparison operations"));
            } else {
                PrimitiveType leftPrimitive = leftType.primitiveType;
                PrimitiveType rightPrimitive = rightType.primitiveType;
                //Turns out strings can have <, >, <= and >= operators :)
                if (leftPrimitive == PrimitiveType.BOOL || rightPrimitive == PrimitiveType.BOOL) {
                    translation.errors.add(new TranslationError(true,
                            leaf,
                            context,
                            "Attempting to use >, <, >= or <= operator on boolean"));
                }
            }
            translation.stringEquivalent = "(" + leftLeaf.stringEquivalent;
            translation.stringEquivalent += ")";
            if (leaf instanceof LessOperation) {
                translation.stringEquivalent += "<";
            } else if (leaf instanceof MoreOperation) {
                translation.stringEquivalent += ">";
            } else if (leaf instanceof LessEqualOperation) {
                translation.stringEquivalent += "<=";
            } else if (leaf instanceof MoreEqualOperation) {
                translation.stringEquivalent += ">=";
            }
            translation.stringEquivalent += "(";
            translation.stringEquivalent += rightLeaf.stringEquivalent;
            translation.stringEquivalent += ")";
            translation.inspectedType = Type.BOOL;
        } else if (leaf instanceof IfStatement) {
            IfStatement ifStatement = (IfStatement) leaf;
            TranslatedLeaf condition = translateLeaf(ifStatement.condition, context, false);
            translation.errors.addAll(condition.errors);
            if (condition.inspectedType.typeCategory != TypeCategory.PRIMITIVE ||//
                    condition.inspectedType.primitiveType != PrimitiveType.BOOL) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "If statement conditions MUST be booleans"));
            }
            translation.inspectedType = null;
            translation.stringEquivalent = "if(";
            translation.stringEquivalent += condition.stringEquivalent;
            translation.stringEquivalent += ")\n";
            TranslatedLeaf then = translateLeaf(ifStatement.then, context, true);
            translation.errors.addAll(then.errors);
            translation.stringEquivalent += then.stringEquivalent;
            if (ifStatement.elseCase != null) {
                translation.stringEquivalent += "else\n";
                TranslatedLeaf elseCase = translateLeaf(ifStatement.elseCase, context, true);
                translation.errors.addAll(elseCase.errors);
                translation.stringEquivalent += elseCase.stringEquivalent;
                if (then.assuresReturn && elseCase.assuresReturn) {
                    translation.assuresReturn = true;
                }
            }
        } else if (leaf instanceof WhileStatement) {
            WhileStatement statement = (WhileStatement) leaf;
            TranslatedLeaf condition = translateLeaf(statement.condition, context, false);
            translation.errors.addAll(condition.errors);
            if (condition.inspectedType.typeCategory != TypeCategory.PRIMITIVE ||//
                    condition.inspectedType.primitiveType != PrimitiveType.BOOL) {
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "If statement conditions MUST be booleans"));
            }
            translation.inspectedType = null;
            translation.stringEquivalent = "if(";
            translation.stringEquivalent += condition.stringEquivalent;
            translation.stringEquivalent += ")\n";
            TranslatedLeaf then = translateLeaf(statement.then, context, true);
            translation.errors.addAll(then.errors);
            translation.stringEquivalent += then.stringEquivalent;
        } else if (leaf instanceof VariableReference) {
            //Should ONLY track the left side of a retriever sequence
            //So, in a.b.c.d, although a, b, c and d are all instances
            //of VariableReference, only a is interpreted here.
            //The others should be intercepted in RetrieverExpression parsing
            VariableReference varRef = (VariableReference) leaf;
            Type t = getTypeOfVariable(varRef, context);
            if (t == null && !varRef.name.equals("super")) {
                if (inRetrieverExpression) {
                    return null;
                }
                translation.errors.add(new TranslationError(true,
                        leaf,
                        context,
                        "Variable " + varRef.name + " not found."));
            }
            if (varRef.name.equals("super")) {
                translation.inspectedType = cls.superClass;
                translation.stringEquivalent = classFromName(cls.superClass.type).exportCppType() + "::";
            } else {
                translation.inspectedType = t;
                String detokenizedName = detokenize(varRef.name);
                translation.stringEquivalent = detokenize(detokenizedName);
            }
        } else if (leaf instanceof FunctionReference) {
            //Should ONLY track the left side of a retriever sequence
            //So, in a().b().c().d(), although a(), b(), c() and d() are all instances
            //of FunctionReference, only a() is interpreted here.
            //The others should be intercepted in RetrieverExpression parsing
            FunctionReference function = (FunctionReference) leaf;
            String functionName = function.name;
            translation.stringEquivalent = detokenize(functionName) + '(';
            Vector<Type> argumentVector = new Vector<Type>();
            boolean isFirst = true;
            for (Expression e : function.arguments) {
                if (!isFirst) {
                    translation.stringEquivalent += ", ";
                }
                TranslatedLeaf parsedArgument = translateLeaf(e, context, false);
                translation.errors.addAll(parsedArgument.errors);
                translation.stringEquivalent += parsedArgument.stringEquivalent;
                argumentVector.add(parsedArgument.inspectedType);
                isFirst = false;
            }
            boolean matched = false;
            Vector<GlobalLibrary.MethodDefinition> methods = getCurrentClass().getMethods(functionName);
            System.out.println("methods.size=" + methods.size());
            functionLoop:
            for (GlobalLibrary.MethodDefinition method : methods) {
                int size = method.arguments.size();
                if (size != argumentVector.size()) {
                    //does not match
                    continue functionLoop;
                }
                System.out.println("method has " + size + " arguments.");
                for (int i = 0; i < size; i++) {
                    try {
                        Type type1 = method.arguments.get(i).type; //Intended
                        Type type2 = argumentVector.get(i); //Used
                        if (!typeMatches(type1, type2)) {
                            continue functionLoop;
                        }
                    } catch (PineClassNotFoundException e) {
                        e.printStackTrace();
                    //We're not interested in this particular
                    //type of exception
                    }
                }
                matched = true;
                translation.inspectedType = method.returnType;
            }

            if (!matched) {
                String funame = functionName + " (";
                int i = 0;
                for (Type t : argumentVector) {
                    funame += t.toString();
                    if (i++ + 1 < argumentVector.size()) {
                        funame += ", ";
                    }
                }
                funame += ")";

                translation.errors.add(new TranslationError(true, leaf, context,
                        "Could not find a method " + funame));
            }

            translation.stringEquivalent += ')';
        } else if (leaf instanceof NewArray) {
            NewArray newArray = (NewArray) leaf;
            Type arrayType = newArray.type;
            translation.inspectedType = new Type();
            translation.inspectedType.typeCategory = TypeCategory.ARRAY;
            translation.inspectedType.arrayType = arrayType;
            translation.stringEquivalent = "new ::Pineapple::Array<";
            translation.stringEquivalent += typeToString(arrayType, true);
            translation.stringEquivalent += ">(";

            TranslatedLeaf size = translateLeaf(newArray.size, context, false);
            translation.errors.addAll(size.errors);
            Type sizeType = size.inspectedType;
            if (sizeType.typeCategory != TypeCategory.PRIMITIVE ||//
                    sizeType.primitiveType != PrimitiveType.INT) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Creating new array with size of non-integer type."));
            }
            translation.stringEquivalent += size.stringEquivalent;

            translation.stringEquivalent += ')';
        } else if (leaf instanceof NewCall) {
            NewCall newCall = (NewCall) leaf;
            translation.stringEquivalent = "new ";
            translation.stringEquivalent += typeToString(newCall.type, false);
            translation.stringEquivalent += '(';

            boolean first = true;
            for (Expression e : newCall.arguments) {
                if (!first) {
                    translation.stringEquivalent += ", ";
                }
                TranslatedLeaf expression = translateLeaf(e, context, false);
                translation.errors.addAll(expression.errors);
                translation.stringEquivalent += expression.stringEquivalent;

                first = false;
            }

            translation.stringEquivalent += ')';
            translation.inspectedType = newCall.type;
        } else if (leaf instanceof RetrieverExpression) {
            System.out.println("Reached RetrieverExpression");
            RetrieverExpression ret = (RetrieverExpression) leaf;
            TranslatedLeaf leftLeaf = translateLeaf(ret.left, //
                    context, false, true);
            if (leftLeaf == null) {
                String retLeft = ret.left.toString();
                //It is, perhaps, a type?
                GlobalLibrary.ClassDefinition referencedType//
                        = classFromName(retLeft.split("\\."));
                if (referencedType != null) {
                    //Only CLASS types have static fields and methods
                    Leaf rightLeaf = ret.right;
                    translation.stringEquivalent = referencedType.exportCppType();
                    translation.stringEquivalent += "::";
                    if (rightLeaf instanceof VariableReference) {
                        VariableReference varRef = (VariableReference) rightLeaf;
                        //Note that only CLASS types have fields
                        GlobalLibrary.FieldDefinition field = //
                                referencedType.getField(varRef.name);
                        if (field == null) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Could not find field " + varRef.name));
                        } else {
                            if (!field.isStatic) {
                                translation.errors.add(new TranslationError(true, leaf, context, //
                                        "Attempting to use non-static field as static."));
                            }
                            translation.inspectedType = field.type;
                            translation.stringEquivalent += detokenize(varRef.name);
                        }
                    } else if (rightLeaf instanceof FunctionReference) {
                        FunctionReference funRef = (FunctionReference) rightLeaf;
                        Vector<GlobalLibrary.MethodDefinition> methods = // \\
                                referencedType.getMethods(funRef.name);
                        Vector<TranslatedLeaf> argumentVector = new Vector<TranslatedLeaf>();
                        translation.stringEquivalent += detokenize(funRef.name);
                        translation.stringEquivalent += '(';
                        boolean isFirst = true;
                        for (Expression e : funRef.arguments) {
                            if (!isFirst) {
                                translation.stringEquivalent += ", ";
                            }
                            TranslatedLeaf tLeaf = translateLeaf(e, context, false, false);
                            translation.errors.addAll(tLeaf.errors);
                            argumentVector.add(tLeaf);
                            translation.stringEquivalent += tLeaf.stringEquivalent;
                            isFirst = false;
                        }

                        functionLoop:
                        for (GlobalLibrary.MethodDefinition method : methods) {
                            int size = method.arguments.size();
                            System.out.println("if(" + size + "!=" + argumentVector.size());
                            if (size != argumentVector.size()) {
                                //does not match
                                continue functionLoop;
                            }
                            System.out.println("Proceeding");
                            for (int i = 0; i < size; i++) {
                                try {
                                    Type type1 = method.arguments.get(i).type; //Intended
                                    Type type2 = argumentVector.get(i).inspectedType; //Used
                                    System.out.println("Comparing types " + type1 + " and " + type2);
                                    if (!typeMatches(type1, type2)) {
                                        System.out.println("Not matched");
                                        continue functionLoop;
                                    }
                                    System.out.println("Matched");
                                } catch (PineClassNotFoundException e) {
                                    System.out.println("PineClassNotFound");
                                //We're not interested in this particular
                                //type of exceptions
                                }
                                if (!method.isStatic) {
                                    translation.errors.add(new TranslationError(true, leaf, context, //
                                            "Cannot reference non-static method ``" + funRef.name +
                                            "'' from static context"));
                                }
                            }
                            translation.inspectedType = method.returnType;
                        }
                        if (translation.inspectedType == null) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Could not find method " + funRef.name));
                        }

                        translation.stringEquivalent += ')';
                    }
                } else {
                    if (inRetrieverExpression) {
                        return null;
                    } else {
                        translation.inspectedType = null;
                        translation.stringEquivalent = "/* FAILURE */";
                        translation.errors.add(new TranslationError(true, leaf, context, //
                                "Expression \"" + retLeft + "\" does not name a variable, a function nor a type."));
                    }
                }
            } else {
                System.out.println("Not a type");
                System.out.println("Dealing with type " + leftLeaf.inspectedType);
                //OK. It worked. Not a type. Let's proceed
                Type leftType = leftLeaf.inspectedType;
                translation.errors.addAll(leftLeaf.errors);
                translation.stringEquivalent = leftLeaf.stringEquivalent;
                if (!(ret.left instanceof VariableReference)) {
                    translation.stringEquivalent += "->";
                } else if (!((VariableReference) ret.left).name.equals("super")) {
                    translation.stringEquivalent += "->";
                }
                if (leftType.typeCategory == TypeCategory.PRIMITIVE) {
                    if (leftType.primitiveType == PrimitiveType.STRING) {
                        if (ret.right instanceof VariableReference) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Attempting to retrieve field of string."));
                        } else if (ret.right instanceof FunctionReference) {
                            FunctionReference funRef = (FunctionReference) ret.right;
                            if (!funRef.name.equals("getLength")) {
                                translation.errors.add(new TranslationError(true, leaf, context, //
                                        "Could not find method " + funRef.name + " in string.\n" //
                                        + "Did you mean 'getLength()'?"));
                            }
                        }
                    } else {
                        translation.errors.add(new TranslationError(true, leaf, context, //
                                "Attempting to retrieve field or method from non-string primitive type."));
                    }
                    translation.stringEquivalent += ".length()"; //getLength()
                    translation.inspectedType = Type.INT;       //is the only valid type
                } else if (leftType.typeCategory == TypeCategory.ARRAY) {
                    if (ret.right instanceof VariableReference) {
                        translation.errors.add(new TranslationError(true, leaf, context, //
                                "Attempting to retrieve field of array."));
                    } else if (ret.right instanceof FunctionReference) {
                        FunctionReference funRef = (FunctionReference) ret.right;
                        if (!funRef.name.equals("getLength")) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Could not find method " + funRef.name + " in array.\n" //
                                    + "Did you mean 'getLength()'?"));
                        }
                    } else if (ret.right instanceof ArrayReference) {
                        System.out.println("In ret.right instanceof ArrayReference");
                        ArrayReference ar = (ArrayReference) ret.right;
                        TranslatedLeaf base = translateLeaf(ar.base, context, false, false);
                        TranslatedLeaf exp = translateLeaf(ar.exp, context, false, false);
                        translation.errors.addAll(base.errors);
                        translation.errors.addAll(exp.errors);
                        translation.stringEquivalent = base.stringEquivalent;
                        //Although getElementAt() is uglier than []
                        //It actually saves us trouble
                        //(as long as getElementAt() returns T& and not T)
                        translation.stringEquivalent += "->getElementAt(" + exp.stringEquivalent + ")";
                        if (base.inspectedType.typeCategory == TypeCategory.ARRAY) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Attempting to retrieve array element from non-array variable."));
                        } else {
                            translation.inspectedType = base.inspectedType.arrayType;
                        }

                        if (exp.inspectedType.typeCategory != TypeCategory.PRIMITIVE //
                                || exp.inspectedType.primitiveType != PrimitiveType.INT) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Only integers can be used as array keys."));
                        }
                    }
                    translation.stringEquivalent += "->getLength()";
                    translation.inspectedType = Type.INT;
                } else if (leftType.typeCategory == TypeCategory.CLASS) {
                    System.out.println("Left is a class");
                    GlobalLibrary.ClassDefinition clsDef = classFromName(leftType.type);
                    if (ret.right instanceof VariableReference) {
                        VariableReference varRef = (VariableReference) ret.right;
                        GlobalLibrary.FieldDefinition field = clsDef.getField(varRef.name);
                        if (field == null) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Could not find field " + varRef.name + " in " + leftType));
                        } else {
                            System.out.println("Assigning type to " + field.type);
                            translation.inspectedType = field.type;
                        }
                        translation.stringEquivalent += "->" + varRef.name;
                    } else if (ret.right instanceof FunctionReference) {
                        FunctionReference funRef = (FunctionReference) ret.right;
                        Vector<GlobalLibrary.MethodDefinition> methods = clsDef.getMethods(funRef.name);
                        Vector<TranslatedLeaf> argumentVector = new Vector<TranslatedLeaf>();
                        translation.stringEquivalent += detokenize(funRef.name);
                        translation.stringEquivalent += '(';
                        boolean isFirst = true;
                        for (Expression e : funRef.arguments) {
                            if (!isFirst) {
                                translation.stringEquivalent += ", ";
                            }
                            TranslatedLeaf tLeaf = translateLeaf(e, context, false, false);
                            translation.errors.addAll(tLeaf.errors);
                            argumentVector.add(tLeaf);
                            translation.stringEquivalent += tLeaf.stringEquivalent;
                            isFirst = false;
                        }
                        functionLoop:
                        for (GlobalLibrary.MethodDefinition method : methods) {
                            if (argumentVector.size() > method.arguments.size()) {
                                continue functionLoop;
                            }
                            for (int i = 0; i < method.arguments.size(); i++) {
                                GlobalLibrary.VariableDefinition varDef = method.arguments.get(i);
                                if (i >= argumentVector.size()) {
                                    if (varDef.defaultValue == null) {
                                        continue functionLoop;
                                    }
                                } else {
                                    try {
                                        Type type2 = argumentVector.get(i).inspectedType; //Used
                                        Type type1 = varDef.type; //Intended
                                        if (!typeMatches(type1, type2)) {
                                            continue functionLoop;
                                        }
                                    } catch (PineClassNotFoundException e) {
                                        //We're not interested in this particular
                                        //type of exceptions
                                    }
                                }
                                translation.inspectedType = method.returnType;
                            }
                            if (method.isStatic) {
                                translation.errors.add(new TranslationError(true, leaf, context, //
                                        "Using static method " + funRef.name + " as non-static"));
                            }
                            translation.stringEquivalent += ')';
                            if (translation.inspectedType == null) {
                                translation.errors.add(new TranslationError(true, leaf, context, //
                                        "Could not find method " + funRef.name));
                            }
                        }
                    }
                }
            }
        } else if (leaf instanceof ArrayReference) {
            System.out.println("Reached ArrayReference");
            ArrayReference ar = (ArrayReference) leaf;
            System.out.println("ar.base=" + ar.base.toString());
            TranslatedLeaf base = translateLeaf(ar.base, context, false, false);
            TranslatedLeaf exp = translateLeaf(ar.exp, context, false, false);
            translation.errors.addAll(base.errors);
            translation.errors.addAll(exp.errors);

            translation.stringEquivalent = "(*" + base.stringEquivalent;
            //getElementAt is uglier than 
            translation.stringEquivalent += ")[" + exp.stringEquivalent + "]";
            if (base.inspectedType.typeCategory != TypeCategory.ARRAY) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Attempting to retrieve array element from non-array variable."));
            } else {
                translation.inspectedType = base.inspectedType.arrayType;
            }

            if (exp.inspectedType.typeCategory != TypeCategory.PRIMITIVE //
                    || exp.inspectedType.primitiveType != PrimitiveType.INT) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Only integers can be used as array keys."));
            }
        } else if (leaf instanceof EqualsOperation) {
            EqualsOperation operation = (EqualsOperation) leaf;
            TranslatedLeaf left = translateLeaf(operation.left, context, false);
            TranslatedLeaf right = translateLeaf(operation.right, context, false);
            translation.errors.addAll(left.errors);
            translation.errors.addAll(right.errors);
            translation.stringEquivalent = "(" + left.stringEquivalent;
            translation.stringEquivalent += ") == (" + right.stringEquivalent;
            translation.stringEquivalent += ')';
            translation.inspectedType = Type.BOOL;
        } else if (leaf instanceof NequalOperation) {
            EqualsOperation operation = (EqualsOperation) leaf;
            TranslatedLeaf left = translateLeaf(operation.left, context, false);
            TranslatedLeaf right = translateLeaf(operation.right, context, false);
            translation.errors.addAll(left.errors);
            translation.errors.addAll(right.errors);
            translation.stringEquivalent = "(" + left.stringEquivalent;
            translation.stringEquivalent += ") != (" + right.stringEquivalent;
            translation.stringEquivalent += ')';
            translation.inspectedType = Type.BOOL;
        } else if (leaf instanceof LogicalBinaryOperation) {
            System.out.println("Reaching LogicalBinaryOperation");
            LogicalBinaryOperation operation = (LogicalBinaryOperation) leaf;
            TranslatedLeaf left = translateLeaf(operation.left, context, false);
            TranslatedLeaf right = translateLeaf(operation.right, context, false);
            translation.errors.addAll(left.errors);
            translation.errors.addAll(right.errors);
            System.out.println("left.inspectedType=" + left.inspectedType);
            if (!left.inspectedType.equals(Type.BOOL)) {
                System.out.println("left is not BOOL");
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Attempting to use non-boolean on left side of logical operation"));
            }
            if (!right.inspectedType.equals(Type.BOOL)) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Attempting to use non-boolean on right side of logical operation"));
            }
            translation.stringEquivalent = "(" + left.stringEquivalent;
            translation.stringEquivalent += ')';
            if (leaf instanceof LogicalAndOperation) {
                translation.stringEquivalent += "&&";
            } else if (leaf instanceof LogicalOrOperation) {
                translation.stringEquivalent += "||";
            }
            translation.stringEquivalent += "(" + right.stringEquivalent;
            translation.stringEquivalent += ')';
            translation.inspectedType = Type.BOOL;
        } else if (leaf instanceof BitwiseBinaryOperation) {
            BitwiseBinaryOperation op = (BitwiseBinaryOperation) leaf;
            TranslatedLeaf left = translateLeaf(op.left, context, false);
            TranslatedLeaf right = translateLeaf(op.right, context, false);
            translation.errors.addAll(left.errors);
            translation.errors.addAll(right.errors);
            Type leftType = left.inspectedType;
            Type rightType = right.inspectedType;
            if (leftType.typeCategory != TypeCategory.PRIMITIVE || //
                    rightType.typeCategory != TypeCategory.PRIMITIVE) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Only primitive types can be used in bitwise operations"));
            } else if (leftType.primitiveType != rightType.primitiveType) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Left side and right side of bitwise operation do not have the same types."));
            } else if (leftType.primitiveType == PrimitiveType.BOOL) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Attempting to use boolean in bitwise operation.\n" //
                        + "You should use logical operations instead."));
            } else if (leftType.primitiveType != PrimitiveType.INT && //
                    leftType.primitiveType != PrimitiveType.CHAR) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Only integers and characters can be used in bitwise operations."));
            }
            translation.inspectedType = leftType;
            translation.stringEquivalent = "(" + left.stringEquivalent + ") ";
            if (leaf instanceof BitwiseAndOperation) {
                translation.stringEquivalent += '&';
            } else if (leaf instanceof BitwiseOrOperation) {
                translation.stringEquivalent += '|';
            } else {
                translation.stringEquivalent += '^';
            }
            translation.stringEquivalent += ' ';
            translation.stringEquivalent += right.stringEquivalent + ')';
        } else if (leaf instanceof ReturnStatement) {
            ReturnStatement ret = (ReturnStatement) leaf;
            translation.stringEquivalent = "return ";
            translation.assuresReturn = true;
            Type type = context.getFunctionReturnType();
            if (ret.value == null) {
                if (type != null && !type.equals(Type.VOID)) {
                    translation.errors.add(new TranslationError(true, leaf, context, //
                            "Void return statements can only be used in constructors and void methods."));
                }
            } else {
                TranslatedLeaf value = translateLeaf(ret.value, context, false);
                translation.errors.addAll(value.errors);
                if (type == null || type.equals(Type.VOID)) {
                    translation.errors.add(new TranslationError(true, leaf, context, //
                            "Void methodset and constructors can only have void return statements."));
                } else {
                    try {
                        if (!typeMatches(type, value.inspectedType)) {
                            translation.errors.add(new TranslationError(true, leaf, context, //
                                    "Method return type and type of return statement must match."));
                        }
                    } catch (PineClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                translation.stringEquivalent += value.stringEquivalent;
            }
        } else if (leaf instanceof TypeCast) {
            TypeCast cast = (TypeCast) leaf;
            TranslatedLeaf exp = translateLeaf(cast.exp, context, false);
            translation.errors.addAll(exp.errors);
            translation.stringEquivalent = "((";
            if (exp.inspectedType.typeCategory != cast.type.typeCategory) {
                translation.errors.add(new TranslationError(true, leaf, context, //
                        "Invalid cast"));
            }
            translation.stringEquivalent += retrieveType(cast.type, true);
            translation.stringEquivalent += ") ";
            translation.stringEquivalent += exp.stringEquivalent;
            translation.stringEquivalent += ')';
            translation.inspectedType = cast.type;
        }
        //TODO:  <<, >>, for, try/catch, throw, etc.

        if (!(leaf instanceof Block) && isStatement) {
            translation.stringEquivalent += ";\n";
        }
        return translation;
    }

    public Type getTypeOfVariable(VariableReference var, PineDLContext context) {
        if (context.isVariableDeclared(var.name)) {
            return context.getVariableType(var.name);
        }

        GlobalLibrary.ClassDefinition definition = getCurrentClass();

        GlobalLibrary.FieldDefinition field = definition.getField(var.name);
        return field == null ? null : field.type;
    }

    public GlobalLibrary.ClassDefinition getCurrentClass() {
        return GlobalLibrary.getUserDefinedClassFromName(cls.clsName, cls.packageName);
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
        if (definition == null) {
            throw new Exception("Invalid class");
        }
        return ClassTypeFunction(definition, fname, arguments);
    }

    public boolean isType(String t) {
        return classFromName(new String[]{t}) != null;
    }

    public GlobalLibrary.ClassDefinition classFromName(String[] clsName) {
        if (clsName.length == 1) {
            //Try same package(including the class itself)
            GlobalLibrary.ClassDefinition def =
                    GlobalLibrary.getUserDefinedClassFromName(clsName[0], cls.packageName);
            if (def != null) {
                return def;
            }

            //Try import statements:
            importLoop:
            for (Type t : cls.importStmt) {
                if (!t.type[t.type.length - 1].equals(clsName[0])) {
                    //Matched!
                    String[] pkg = new String[t.type.length - 1];



                    for (int i = 0; i < pkg.length; i++) {
                        pkg[i] = t.type[i];

                    }

                    return GlobalLibrary.getUserDefinedClassFromName(clsName[0], pkg);
                }
            }

            def = GlobalLibrary.getCoreClassFromName(clsName[0]);
            if (def != null) {
                return def;
            }
        }
        GlobalLibrary.ClassDefinition def;
        //Try Pineapple classes:


        if (clsName.length == 2 && clsName[0].equals("Pineapple")) {

            def = GlobalLibrary.getCoreClassFromName(clsName[1]);
            if (def != null) {
                return def;
            }
        }
        String[] pkg = new String[clsName.length - 1];
        for (int i = 0; i < pkg.length; i++) {
            pkg[i] = clsName[i];
        }
        return GlobalLibrary.getClassFromName(clsName[clsName.length - 1], pkg);

    }

    private Type ClassTypeFunction(
            GlobalLibrary.ClassDefinition definition, String fname, Type... arguments)
            throws Exception {

        Vector<GlobalLibrary.MethodDefinition> methods = definition.getMethods(fname);

        if (methods.size() == 0) {
            throw new Exception("Function not found");
        }

        methodLoop:
        for (GlobalLibrary.MethodDefinition method : methods) {

            int index = 0;
            for (GlobalLibrary.VariableDefinition arg : method.arguments) {
                if (index >= arguments.length) {
                    if (arg.defaultValue == null) {
                        return method.returnType;
                    }
                    continue methodLoop;
                }
                Type argType = arg.type;
                if (!typeMatches(argType, arg.type)) {
                    continue methodLoop;
                }
            }
        }

        throw new Exception("Invalid arguments");
    }
    //Note that if t2 extends t1, then true

    public boolean typeMatches(Type t1, Type t2)
            throws PineClassNotFoundException {
        if (t2 == null) {
            return (t1.typeCategory != TypeCategory.PRIMITIVE) || t1.primitiveType == PrimitiveType.STRING;
        }
        if (t1.typeCategory != t2.typeCategory) {
            return false;
        }
        if (t1.typeCategory == TypeCategory.PRIMITIVE) {
            return t1.primitiveType == t2.primitiveType;
        }
        if (t1.typeCategory == TypeCategory.ARRAY) {
            return typeMatches(t1.arrayType, t2.arrayType);
        }
        String[] type1 = t1.type;
        String[] type2 = t2.type;
        GlobalLibrary.ClassDefinition cls1 = classFromName(type1);
        GlobalLibrary.ClassDefinition cls2 = classFromName(type2);
        if (cls1 == null || cls2 == null) {
            System.out.println("1:" + Arrays.toString(type1) + ":" + cls1);
            System.out.println("2:" + Arrays.toString(type2) + ":" + cls2);
            throw new PineClassNotFoundException();
        }
        if (Arrays.equals(cls1.packageName, cls2.packageName)) {
            if (cls1.name.equals(cls2.name)) {
                return true;
            }
        //If not, may happen and may not happen. We don't know yet.
        }
        return cls2.inheritsFrom(cls1);
    }

    protected void writeLine()
            throws IOException {
        out.write('\n');
    }

    protected void writeLine(String line)
            throws IOException {
        out.write(line.getBytes());
        out.write('\n');
    }

    /**
     * Unlike errors, warnings do not stop the compilation
     * @param warning The warning to display
     */
    protected void throwWarning(String warning) {
        String message = "<font color='#ff7700'>WARNING: ";
        message += warning;
        final String msg = message + "</font>";
        System.out.println(msg);

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GameCompiler.compFrame.writeLine(msg);
            }
        });
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

    public static class PineClassNotFoundException extends Exception {

        public PineClassNotFoundException() {
            super("OMG class not found");
        }

        public PineClassNotFoundException(String msg) {
            super(msg);
        }
    }
}
