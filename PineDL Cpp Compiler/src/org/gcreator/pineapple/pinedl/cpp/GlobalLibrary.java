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

import java.util.Arrays;
import java.util.Vector;
import org.gcreator.pineapple.pinedl.AccessControlKeyword;
import org.gcreator.pineapple.pinedl.Argument;
import org.gcreator.pineapple.pinedl.Function;
import org.gcreator.pineapple.pinedl.PineClass;
import org.gcreator.pineapple.pinedl.Type;
import org.gcreator.pineapple.pinedl.Variable;
import org.gcreator.pineapple.pinedl.statements.BooleanConstant;
import org.gcreator.pineapple.pinedl.statements.Constant;
import org.gcreator.pineapple.pinedl.statements.IntConstant;

/**
 * 
 * Defines all the classes defined in the Pineapple core library
 * and scripts.
 *
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class GlobalLibrary {

    public static Vector<ClassDefinition> coreClasses = new Vector<ClassDefinition>();
    public static Vector<ClassDefinition> userDefinedClasses = new Vector<ClassDefinition>();

    public static ClassDefinition getCoreClassFromName(String name) {
        for (ClassDefinition coreClass : coreClasses) {
            if (coreClass.name.equals(name)) {
                return coreClass;
            }
        }
        return null;
    }

    public static ClassDefinition getUserDefinedClassFromName(String name, String[] packageName) {
        for (ClassDefinition definition : userDefinedClasses) {
            if (!definition.name.equals(name)) {
                continue;
            }
            if (Arrays.equals(definition.packageName, packageName)) {
                return definition;
            }
        }
        return null;
    }

    public static ClassDefinition getClassFromName(String name, String[] packageName) {
        ClassDefinition definition = getUserDefinedClassFromName(name, packageName);
        if (definition != null) {
            return definition;
        }
        if (packageName.length == 1 && packageName[0].equals("Pineapple")) {
            return getCoreClassFromName(name);
        }
        return null;
    }

    public static ClassDefinition addUserClass(PineClass userClass) {
        ClassDefinition clsDefinition = new ClassDefinition(userClass.clsName,
                userClass.packageName);
        for (Variable v : userClass.variables) {
            clsDefinition.fields.add(
                    new FieldDefinition(v.name, v.type, v.isStatic, v.isFinal, v.access));
        }
        for (Function f : userClass.functions) {
            MethodDefinition m = new MethodDefinition(f.name, f.returnType, f.isStatic, f.isFinal);
            m.access = f.access;
            for (Argument arg : f.arguments) {
                VariableDefinition v = new VariableDefinition(arg.name, arg.type, arg.defaultValue);
            }
            clsDefinition.methods.add(m);
        }
        userDefinedClasses.add(clsDefinition);
        return clsDefinition;
    }


    static {
        /* Functions provided by libPineapple.a, the OpenGL Backend */

        /* Drawing functions */
        ClassDefinition c = new ClassDefinition("Drawing");
        MethodDefinition m;
        m = new MethodDefinition("drawBegin", Type.VOID);
        m.arguments.add(new VariableDefinition("mode", Type.INT));
        c.methods.add(m);

        m = new MethodDefinition("drawEnd", Type.VOID);
        c.methods.add(m);

        m = new MethodDefinition("drawVertex", Type.VOID);
        m.arguments.add(new VariableDefinition("x", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y", Type.FLOAT));
        m.arguments.add(new VariableDefinition("z", Type.FLOAT, new IntConstant(0)));
        m.arguments.add(new VariableDefinition("w", Type.FLOAT, new IntConstant(1)));
        c.methods.add(m);

        m = new MethodDefinition("drawTranslate", Type.VOID);
        m.arguments.add(new VariableDefinition("x", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y", Type.FLOAT));
        m.arguments.add(new VariableDefinition("z", Type.FLOAT, new IntConstant(0)));
        c.methods.add(m);

        m = new MethodDefinition("drawPop", Type.VOID);
        c.methods.add(m);

        m = new MethodDefinition("drawPush", Type.VOID);
        c.methods.add(m);

        m = new MethodDefinition("drawColor", new Type("Pineapple.Color"), true, true);
        c.methods.add(m);

        m = new MethodDefinition("drawColor", Type.VOID);
        m.arguments.add(new VariableDefinition("c", new Type("Pineapple.Color")));
        c.methods.add(m);

        m = new MethodDefinition("drawColor", Type.VOID);
        m.arguments.add(new VariableDefinition("c", new Type("Pineapple.Color")));
        m.arguments.add(new VariableDefinition("a", Type.FLOAT));
        c.methods.add(m);

        m = new MethodDefinition("drawColor", Type.VOID);
        m.arguments.add(new VariableDefinition("r", Type.FLOAT));
        m.arguments.add(new VariableDefinition("g", Type.FLOAT));
        m.arguments.add(new VariableDefinition("b", Type.FLOAT));
        c.methods.add(m);

        m = new MethodDefinition("drawColor", Type.VOID);
        m.arguments.add(new VariableDefinition("r", Type.FLOAT));
        m.arguments.add(new VariableDefinition("g", Type.FLOAT));
        m.arguments.add(new VariableDefinition("b", Type.FLOAT));
        m.arguments.add(new VariableDefinition("a", Type.FLOAT));
        c.methods.add(m);

        m = new MethodDefinition("drawLine", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("x2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y2", Type.FLOAT));
        c.methods.add(m);

        m = new MethodDefinition("drawCircle", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("x2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawRectangle", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("x2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);
        
        m = new MethodDefinition("drawRectangle", Type.VOID);
        m.arguments.add(new VariableDefinition("r", new Type("Pineapple.Rectangle")));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawRoundRect", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("x2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawEllipse", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("x2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawTriangle", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y1", Type.FLOAT));
        m.arguments.add(new VariableDefinition("x2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y2", Type.FLOAT));
        m.arguments.add(new VariableDefinition("x3", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y3", Type.FLOAT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawPoint", Type.VOID);
        m.arguments.add(new VariableDefinition("x", Type.FLOAT));
        m.arguments.add(new VariableDefinition("y", Type.FLOAT));
        c.methods.add(m);
        
        m = new MethodDefinition("drawPoint", Type.VOID);
        m.arguments.add(new VariableDefinition("p", new Type("Pineapple.Point")));
        c.methods.add(m);

        coreClasses.add(c);
        
        c = new ClassDefinition("Point");
        c.constructors.add(new ConstructorDefinition());
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("x", Type.FLOAT),
                new VariableDefinition("y", Type.FLOAT)));
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("p", new Type("Pineapple.Point"))));
        c.methods.add(new MethodDefinition("getX", Type.FLOAT));
        c.methods.add(new MethodDefinition("getY", Type.FLOAT));
        coreClasses.add(c);
        
        c = new ClassDefinition("Rectangle");
        c.constructors.add(new ConstructorDefinition());
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("p1", new Type("Pineapple.Point")),
                new VariableDefinition("p2", new Type("Pineapple.Point"))));
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("p", new Type("Pineapple.Rectangle"))));
        c.methods.add(new MethodDefinition("getTopLeftPoint", new Type("Pineapple.Point")));
        c.methods.add(new MethodDefinition("getBottomRightPoint", new Type("Pineapple.Point")));
        c.methods.add(new MethodDefinition("getWidth", Type.FLOAT));
        c.methods.add(new MethodDefinition("getHeight", Type.FLOAT));
        coreClasses.add(c);
        
        c = new ClassDefinition("CollisionManager");
        m = new MethodDefinition("rectangleIntersects", Type.BOOL);
        m.arguments.add(new VariableDefinition("r1", new Type("Pineapple.Rectangle")));
        m.arguments.add(new VariableDefinition("r2", new Type("Pineapple.Rectangle")));
        c.methods.add(m);
        coreClasses.add(c);

        c = new ClassDefinition("Actor");
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("x", Type.FLOAT, new IntConstant(0)),
                new VariableDefinition("y", Type.FLOAT, new IntConstant(0)),
                new VariableDefinition("depth", Type.FLOAT, new IntConstant(0))));
        c.fields.add(new FieldDefinition("motion", new Type("Vector"), AccessControlKeyword.PRIVATE));
        c.fields.add(new FieldDefinition("gravity", new Type("Vector"), AccessControlKeyword.PRIVATE));
        c.fields.add(new FieldDefinition("friction", Type.FLOAT, AccessControlKeyword.PRIVATE));
        c.fields.add(new FieldDefinition("texture", Type.INT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("angle", Type.FLOAT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("width", Type.FLOAT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("height", Type.FLOAT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("x", Type.FLOAT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("y", Type.FLOAT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("depth", Type.FLOAT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("visible", Type.BOOL, AccessControlKeyword.PROTECTED));
        c.methods.add(new MethodDefinition("getX", Type.FLOAT));
        c.methods.add(new MethodDefinition("getY", Type.FLOAT));
        c.methods.add(new MethodDefinition("getHSpeed", Type.FLOAT));
        c.methods.add(new MethodDefinition("getVSpeed", Type.FLOAT));
        c.methods.add(new MethodDefinition("getSpeed", Type.FLOAT));
        c.methods.add(new MethodDefinition("getDirection", Type.FLOAT));
        c.methods.add(new MethodDefinition("getFriction", Type.FLOAT));
        c.methods.add(new MethodDefinition("getGravity", Type.FLOAT));
        c.methods.add(new MethodDefinition("getGravityDirection", Type.FLOAT));
        c.methods.add(new MethodDefinition("getDepth", Type.FLOAT));
        m = new MethodDefinition("setX", Type.VOID);
        m.arguments.add(new VariableDefinition("x", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setY", Type.VOID);
        m.arguments.add(new VariableDefinition("y", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setHSpeed", Type.VOID);
        m.arguments.add(new VariableDefinition("x", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setVSpeed", Type.VOID);
        m.arguments.add(new VariableDefinition("y", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setSpeed", Type.VOID);
        m.arguments.add(new VariableDefinition("s", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setDirection", Type.VOID);
        m.arguments.add(new VariableDefinition("d", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setGravity", Type.VOID);
        m.arguments.add(new VariableDefinition("g", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setGravity", Type.VOID);
        m.arguments.add(new VariableDefinition("g", Type.FLOAT));
        m.arguments.add(new VariableDefinition("d", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setGravityDirection", Type.VOID);
        m.arguments.add(new VariableDefinition("d", Type.FLOAT));
        c.methods.add(m);
        m = new MethodDefinition("setDepth", Type.VOID);
        m.arguments.add(new VariableDefinition("depth", Type.FLOAT));
        c.methods.add(m);
        c.enums.add(new EnumDefinition("Motion", "MotionXY", "MotionRV"));
        m = new MethodDefinition("setMotionMode", Type.VOID);
        m.arguments.add(new VariableDefinition("m", new Type("Pineapple.Actor.Motion")));
        c.methods.add(m);
        c.methods.add(new MethodDefinition("update", Type.VOID));
        c.methods.add(new MethodDefinition("move", Type.VOID));
        m = new MethodDefinition("draw", Type.VOID);
        m.arguments.add(new VariableDefinition("d", new Type("Pineapple.Drawing")));
        c.methods.add(m);
        m = new MethodDefinition("onKeyDown", Type.VOID);
        m.arguments.add(new VariableDefinition("Key", Type.INT));
        c.methods.add(m);
        m = new MethodDefinition("onKeyDown", Type.VOID);
        m.arguments.add(new VariableDefinition("Key", Type.INT));
        c.methods.add(m);
        m = new MethodDefinition("onKeyDown", Type.VOID);
        m.arguments.add(new VariableDefinition("Key", Type.INT));
        c.methods.add(m);
        c.methods.add(new MethodDefinition("isVisible", Type.BOOL));
        m = new MethodDefinition("setVisible", Type.VOID);
        m.arguments.add(new VariableDefinition("visible", Type.BOOL));
        c.methods.add(m);
        c.methods.add(new MethodDefinition("getTexture", new Type("Texture")));

        coreClasses.add(c);

        c = new ClassDefinition("Scene");
        c.fields.add(new FieldDefinition("bgColor", new Type("Color"), AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("width", Type.INT, AccessControlKeyword.PROTECTED));
        c.fields.add(new FieldDefinition("height", Type.INT, AccessControlKeyword.PROTECTED));
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("width", Type.INT),
                new VariableDefinition("height", Type.INT)));
        c.methods.add(new MethodDefinition("getBackground", new Type("Color")));
        m = new MethodDefinition("setBackground", Type.VOID);
        m.arguments.add(new VariableDefinition("bgColor", new Type("Color")));
        c.methods.add(m);
        c.methods.add(new MethodDefinition("update", Type.VOID));
        c.methods.add(new MethodDefinition("draw", Type.VOID));
        m = new MethodDefinition("draw", Type.VOID);
        m.arguments.add(new VariableDefinition("d", new Type("Drawing")));
        c.methods.add(m);
        m = new MethodDefinition("addActor", Type.VOID);
        m.arguments.add(new VariableDefinition("actor", new Type("Actor")));
        c.methods.add(m);
        m = new MethodDefinition("addView", Type.VOID);
        m.arguments.add(new VariableDefinition("view", new Type("View")));
        c.methods.add(m);
        m = new MethodDefinition("addBackground", Type.VOID);
        m.arguments.add(new VariableDefinition("bg", new Type("Background")));
        c.methods.add(m);
        m = new MethodDefinition("onKeyUp", Type.VOID);
        m.arguments.add(new VariableDefinition("key", Type.INT));
        c.methods.add(m);
        m = new MethodDefinition("onKeyDown", Type.VOID);
        m.arguments.add(new VariableDefinition("key", Type.INT));
        c.methods.add(m);
        m = new MethodDefinition("onKeyPressed", Type.VOID);
        m.arguments.add(new VariableDefinition("key", Type.INT));
        c.methods.add(m);
        c.methods.add(new MethodDefinition("getWidth", Type.INT));
        c.methods.add(new MethodDefinition("getHeight", Type.INT));

        coreClasses.add(c);

        c = new ClassDefinition("Background");
        coreClasses.add(c);
        
        c = new ClassDefinition("Color");
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("r", Type.FLOAT),
                new VariableDefinition("g", Type.FLOAT),
                new VariableDefinition("b", Type.FLOAT)));
        c.constructors.add(new ConstructorDefinition(
                new VariableDefinition("r", Type.FLOAT),
                new VariableDefinition("g", Type.FLOAT),
                new VariableDefinition("b", Type.FLOAT),
                new VariableDefinition("a", Type.FLOAT)));
        c.methods.add(new MethodDefinition("getRed", Type.FLOAT));
        c.methods.add(new MethodDefinition("getGreen", Type.FLOAT));
        c.methods.add(new MethodDefinition("getBlue", Type.FLOAT));
        c.methods.add(new MethodDefinition("getAlpha", Type.FLOAT));

        c.fields.add(new FieldDefinition("TRANSPARENT_WHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("SNOW", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("GHOST_WHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("GHOSTWHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("WHITE_SMOKE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("WHITESMOKE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("GAINSBORO", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("FLORAL_WHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("FLORALWHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("OLD_LACE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("OLDLACE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("LINEN", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("ANTIQUE_WHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("ANTIQUEWHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("PAPAYA_WHIP", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("PAPAYAWHIP", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("BLANCHED_ALMOND", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("BLANCHEDALMOND", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("BISQUE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("PEACH_PUFF", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("PEACHPUFF", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("NAVAJO_WHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("NAVAJOWHITE", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("MOCCASIN", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("CORNSILK", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("IVORY", new Type("Color"), true, true));
        
        c.fields.add(new FieldDefinition("RED", new Type("Color"), true, true));
        c.fields.add(new FieldDefinition("BLUE", new Type("Color"), true, true));

        coreClasses.add(c);

        c = new ClassDefinition("Key");
        c.fields.add(new FieldDefinition("Unknown", Type.INT, true, true));
        c.fields.add(new FieldDefinition("First", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Backspace", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Tab", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Clear", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Return", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Pause", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Escape", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Space", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Exclaim", Type.INT, true, true));
        c.fields.add(new FieldDefinition("QuotedBL", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Hash", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Dollar", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Ampersand", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Quote", Type.INT, true, true));
        c.fields.add(new FieldDefinition("LeftParen", Type.INT, true, true));
        c.fields.add(new FieldDefinition("RightParen", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Asterisk", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Plus", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Comma", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Minus", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Period", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Slash", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number0", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number1", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number2", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number3", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number4", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number5", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number6", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number7", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number8", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Number9", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Colon", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Semicolon", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Less", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Equals", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Greater", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Question", Type.INT, true, true));
        c.fields.add(new FieldDefinition("At", Type.INT, true, true));

        c.fields.add(new FieldDefinition("LeftBracket", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Backslash", Type.INT, true, true));
        c.fields.add(new FieldDefinition("RightBracket", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Caret", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Underscore", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Backquote", Type.INT, true, true));
        c.fields.add(new FieldDefinition("A", Type.INT, true, true));
        c.fields.add(new FieldDefinition("B", Type.INT, true, true));
        c.fields.add(new FieldDefinition("C", Type.INT, true, true));
        c.fields.add(new FieldDefinition("D", Type.INT, true, true));
        c.fields.add(new FieldDefinition("E", Type.INT, true, true));
        c.fields.add(new FieldDefinition("F", Type.INT, true, true));
        c.fields.add(new FieldDefinition("G", Type.INT, true, true));
        c.fields.add(new FieldDefinition("H", Type.INT, true, true));
        c.fields.add(new FieldDefinition("I", Type.INT, true, true));
        c.fields.add(new FieldDefinition("J", Type.INT, true, true));
        c.fields.add(new FieldDefinition("K", Type.INT, true, true));
        c.fields.add(new FieldDefinition("L", Type.INT, true, true));
        c.fields.add(new FieldDefinition("M", Type.INT, true, true));
        c.fields.add(new FieldDefinition("N", Type.INT, true, true));
        c.fields.add(new FieldDefinition("O", Type.INT, true, true));
        c.fields.add(new FieldDefinition("P", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Q", Type.INT, true, true));
        c.fields.add(new FieldDefinition("R", Type.INT, true, true));
        c.fields.add(new FieldDefinition("S", Type.INT, true, true));
        c.fields.add(new FieldDefinition("T", Type.INT, true, true));
        c.fields.add(new FieldDefinition("U", Type.INT, true, true));
        c.fields.add(new FieldDefinition("V", Type.INT, true, true));
        c.fields.add(new FieldDefinition("W", Type.INT, true, true));
        c.fields.add(new FieldDefinition("X", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Y", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Z", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Delete", Type.INT, true, true));

        for (int i = 0; i <= 95; i++) {
            c.fields.add(new FieldDefinition("World" + i, Type.INT, true, true));
        }

        c.fields.add(new FieldDefinition("KP0", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP1", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP2", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP3", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP4", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP5", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP6", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP7", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP8", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KP9", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KPPeriod", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KPDivide", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KPMultiply", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KPMinus", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KPPlus", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KPEnter", Type.INT, true, true));
        c.fields.add(new FieldDefinition("KPEquals", Type.INT, true, true));

        c.fields.add(new FieldDefinition("Up", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Down", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Right", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Left", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Insert", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Home", Type.INT, true, true));
        c.fields.add(new FieldDefinition("End", Type.INT, true, true));
        c.fields.add(new FieldDefinition("PageUp", Type.INT, true, true));
        c.fields.add(new FieldDefinition("PageDown", Type.INT, true, true));

        for (int i = 1; i <= 15; i++) {
            c.fields.add(new FieldDefinition("F" + i, Type.INT, true, true));
        }

        c.fields.add(new FieldDefinition("NumLock", Type.INT, true, true));
        c.fields.add(new FieldDefinition("CapsLock", Type.INT, true, true));
        c.fields.add(new FieldDefinition("ScrollLock", Type.INT, true, true));
        c.fields.add(new FieldDefinition("RShift", Type.INT, true, true));
        c.fields.add(new FieldDefinition("LShift", Type.INT, true, true));
        c.fields.add(new FieldDefinition("RCtrl", Type.INT, true, true));
        c.fields.add(new FieldDefinition("LCtrl", Type.INT, true, true));
        c.fields.add(new FieldDefinition("RAlt", Type.INT, true, true));
        c.fields.add(new FieldDefinition("LAlt", Type.INT, true, true));
        c.fields.add(new FieldDefinition("RMeta", Type.INT, true, true));
        c.fields.add(new FieldDefinition("LMeta", Type.INT, true, true));
        c.fields.add(new FieldDefinition("LSuper", Type.INT, true, true));
        c.fields.add(new FieldDefinition("RSuper", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Mode", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Compose", Type.INT, true, true));

        c.fields.add(new FieldDefinition("Help", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Print", Type.INT, true, true));
        c.fields.add(new FieldDefinition("SysReq", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Break", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Menu", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Power", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Euro", Type.INT, true, true));
        c.fields.add(new FieldDefinition("Undo", Type.INT, true, true));
        coreClasses.add(c);
    }

    private GlobalLibrary() {
    }

    public static class ClassDefinition {

        public String name;
        public String[] packageName;
        public AccessControlKeyword access;
        public ClassDefinition parent = null;
        public Vector<ClassDefinition> classes;
        public Vector<MethodDefinition> methods;
        public Vector<FieldDefinition> fields;
        public Vector<ConstructorDefinition> constructors;
        public Vector<EnumDefinition> enums;

        protected ClassDefinition(String name) {
            this.name = name;
            this.access = AccessControlKeyword.PUBLIC;
            this.classes = new Vector<ClassDefinition>();
            this.methods = new Vector<MethodDefinition>();
            this.fields = new Vector<FieldDefinition>();
            this.constructors = new Vector<ConstructorDefinition>();
            this.enums = new Vector<EnumDefinition>();
            this.packageName = new String[]{"Pineapple"};
        }

        public ClassDefinition(String name, String[] packageName) {
            this(name);
            this.packageName = packageName;
        }

        public Vector<MethodDefinition> getMethods(String fname) {
            Vector<MethodDefinition> md = new Vector<MethodDefinition>();
            for (MethodDefinition method : methods) {
                if (method.name.equals(fname)) {
                    md.add(method);
                }
            }
            if (parent != null) {
                md.addAll(parent.getMethods(fname));
            }
            return md;
        }

        public FieldDefinition getField(String fname) {
            System.out.println("Looking for field " + fname + " in class " + name);
            for (FieldDefinition field : fields) {
                if (field.name.equals(fname)) {
                    System.out.println("FOUND!");
                    return field;
                }
            }
            if (parent != null) {
                System.out.println("Seeking in base class");
                return parent.getInheritedField(fname);
            }
            System.out.println("No base class");
            return null;
        }

        public FieldDefinition getInheritedField(String fname) {
            System.out.println("Looking for field " + fname + " in class " + name);
            for (FieldDefinition field : fields) {
                if (field.name.equals(fname) && field.access != AccessControlKeyword.PRIVATE) {
                    System.out.println("FOUND");
                    return field;
                }
            }
            if (parent != null) {
                System.out.println("Seeking in base class");
                return parent.getInheritedField(fname);
            }
            System.out.println("No base class");
            return null;
        }

        public boolean inheritsFrom(ClassDefinition possibleParent) {
            if (parent == possibleParent) {
                return true;
            }
            return parent != null && parent.inheritsFrom(possibleParent);
        }

        public String exportCppType() {
            String result = "";
            for (String s : packageName) {
                result += "::" + s;
            }
            return result + "::" + name;
        }
    }

    public static class FieldDefinition {

        public String name;
        public AccessControlKeyword access;
        public boolean isStatic;
        public boolean isFinal;
        public Type type;

        public FieldDefinition(String name, Type type) {
            this.access = AccessControlKeyword.PUBLIC;
            this.name = name;
            this.type = type;
        }

        public FieldDefinition(String name, Type type, AccessControlKeyword access) {
            this(name, type);
            this.access = access;
        }

        public FieldDefinition(String name, Type type, boolean isStatic, boolean isFinal) {
            this(name, type);
            this.isStatic = isStatic;
            this.isFinal = isFinal;
        }

        public FieldDefinition(String name, Type type, boolean isStatic, boolean isFinal, AccessControlKeyword access) {
            this(name, type);
            this.isStatic = isStatic;
            this.isFinal = isFinal;
            this.access = access;
        }
    }

    public static class MethodDefinition {

        public String name;
        public AccessControlKeyword access;
        public Vector<VariableDefinition> arguments;
        public boolean isFinal;
        public boolean isStatic;
        public Type returnType;

        public MethodDefinition(String name, Type returnType) {
            this.name = name;
            this.access = AccessControlKeyword.PUBLIC;
            this.returnType = returnType;
            this.arguments = new Vector<VariableDefinition>();
        }

        public MethodDefinition(String name, Type returnType, boolean isStatic, boolean isFinal) {
            this(name, returnType);
            this.isStatic = isStatic;
            this.isFinal = isFinal;
        }
    }

    public static class VariableDefinition {

        public String name;
        public Type type;
        public AccessControlKeyword access;
        public Constant defaultValue = null;

        public VariableDefinition(String name, Type type) {
            this.name = name;
            this.type = type;
            this.access = AccessControlKeyword.PUBLIC;
        }

        public VariableDefinition(String name, Type type, Constant defaultValue) {
            this(name, type);
            this.defaultValue = defaultValue;
        }
    }

    public static class ConstructorDefinition {

        public AccessControlKeyword access;
        public Vector<VariableDefinition> arguments;

        public ConstructorDefinition(VariableDefinition... args) {
            this.access = AccessControlKeyword.PUBLIC;
            this.arguments = new Vector<VariableDefinition>();
            this.arguments.copyInto(args);
        }
    }

    public static class EnumDefinition {

        String name;
        public AccessControlKeyword access;
        public Vector<String> values;

        public EnumDefinition(String name, String... values) {
            this.name = name;
            this.values = new Vector<String>();
            this.values.copyInto(values);
        }

        public EnumDefinition(String name, AccessControlKeyword access, String... values) {
            this(name, values);
            this.access = access;
        }
    }
}

    