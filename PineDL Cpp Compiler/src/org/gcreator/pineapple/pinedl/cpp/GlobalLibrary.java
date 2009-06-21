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

    public static ClassDefinition getCoreClassFromName(String name){
        for(ClassDefinition coreClass : coreClasses){
            if(coreClass.name.equals(name)){
                return coreClass;
            }
        }
        return null;
    }
    
    public static ClassDefinition getUserDefinedClassFromName(String name, String[] packageName){
        for(ClassDefinition definition : userDefinedClasses){
            if(!definition.name.equals(name)){
                continue;
            }
            if(Arrays.equals(definition.packageName, packageName)){
                return definition;
            }
        }
        return null;
    }
    
    public static ClassDefinition getClassFromName(String name, String[] packageName){
        ClassDefinition definition = getUserDefinedClassFromName(name, packageName);
        if(definition!=null){
            return definition;
        }
        if(packageName.length==1&&packageName[0].equals("Pineapple")){
            return getCoreClassFromName(name);
        }
        return null;
    }
    
    public static ClassDefinition addUserClass(PineClass userClass){
        ClassDefinition clsDefinition = new ClassDefinition(userClass.clsName,
                userClass.packageName);
        for(Variable v : userClass.variables){
            clsDefinition.fields.add(
                    new FieldDefinition(v.name, v.type, v.isStatic, v.isFinal, v.access));
        }
        for(Function f : userClass.functions){
            MethodDefinition m = new MethodDefinition(f.name, f.returnType, f.isStatic, f.isFinal);
            m.access = f.access;
            for(Argument arg : f.arguments){
                VariableDefinition v = new VariableDefinition(arg.name, arg.type, arg.defaultValue);
            }
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

        m = new MethodDefinition("drawColor", new Type("Pineapple.Color"));
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
        
        m = new MethodDefinition("drawCircle", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.INT));
        m.arguments.add(new VariableDefinition("y1", Type.INT));
        m.arguments.add(new VariableDefinition("x2", Type.INT));
        m.arguments.add(new VariableDefinition("y2", Type.INT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawLine", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.INT));
        m.arguments.add(new VariableDefinition("y1", Type.INT));
        m.arguments.add(new VariableDefinition("x2", Type.INT));
        m.arguments.add(new VariableDefinition("y2", Type.INT));
        c.methods.add(m);

        m = new MethodDefinition("drawRectangle", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.INT));
        m.arguments.add(new VariableDefinition("y1", Type.INT));
        m.arguments.add(new VariableDefinition("x2", Type.INT));
        m.arguments.add(new VariableDefinition("y2", Type.INT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawRoundRect", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.INT));
        m.arguments.add(new VariableDefinition("y1", Type.INT));
        m.arguments.add(new VariableDefinition("x2", Type.INT));
        m.arguments.add(new VariableDefinition("y2", Type.INT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawEllipse", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.INT));
        m.arguments.add(new VariableDefinition("y1", Type.INT));
        m.arguments.add(new VariableDefinition("x2", Type.INT));
        m.arguments.add(new VariableDefinition("y2", Type.INT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawTriangle", Type.VOID);
        m.arguments.add(new VariableDefinition("x1", Type.INT));
        m.arguments.add(new VariableDefinition("y1", Type.INT));
        m.arguments.add(new VariableDefinition("x2", Type.INT));
        m.arguments.add(new VariableDefinition("y2", Type.INT));
        m.arguments.add(new VariableDefinition("x3", Type.INT));
        m.arguments.add(new VariableDefinition("y3", Type.INT));
        m.arguments.add(new VariableDefinition("filled", Type.BOOL, BooleanConstant.TRUE));
        c.methods.add(m);

        m = new MethodDefinition("drawPoint", Type.VOID);
        m.arguments.add(new VariableDefinition("x", Type.INT));
        m.arguments.add(new VariableDefinition("y", Type.INT));
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
        c.fields.add(new FieldDefinition("autoDraw", Type.BOOL, AccessControlKeyword.PROTECTED));
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
        m.arguments.add(new VariableDefinition("Key", new Type("Key")));
        c.methods.add(m);
        m = new MethodDefinition("onKeyDown", Type.VOID);
        m.arguments.add(new VariableDefinition("Key", new Type("Key")));
        c.methods.add(m);
        m = new MethodDefinition("onKeyDown", Type.VOID);
        m.arguments.add(new VariableDefinition("Key", new Type("Key")));
        c.methods.add(m);
        c.methods.add(new MethodDefinition("isAutoDrawn", Type.BOOL));
        m = new MethodDefinition("setAutoDrawn", Type.VOID);
        m.arguments.add(new VariableDefinition("autoDraw", Type.BOOL));
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
        m.arguments.add(new VariableDefinition("key", new Type("Key")));
        c.methods.add(m);
        m = new MethodDefinition("onKeyDown", Type.VOID);
        m.arguments.add(new VariableDefinition("key", new Type("Key")));
        c.methods.add(m);
        m = new MethodDefinition("onKeyPressed", Type.VOID);
        m.arguments.add(new VariableDefinition("key", new Type("Key")));
        c.methods.add(m);
        c.methods.add(new MethodDefinition("getWidth", Type.INT));
        c.methods.add(new MethodDefinition("getHeight", Type.INT));
        
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
        
        public ClassDefinition(String name, String[] packageName){
            this(name);
            this.packageName = packageName;
        }
        
        public Vector<MethodDefinition> getMethods(String fname){
            Vector<MethodDefinition> md = new Vector<MethodDefinition>();
            for(MethodDefinition method : methods){
                if(method.name.equals(fname)){
                    md.add(method);
                }
            }
            if(parent!=null){
                md.addAll(parent.getMethods(fname));
            }
            return md;
        }
        
        public FieldDefinition getField(String fname){
            System.out.println("Looking for field " + fname + " in class " + name);
            for(FieldDefinition field : fields){
                if(field.name.equals(fname)){
                    System.out.println("FOUND!");
                    return field;
                }
            }
            if(parent!=null){
                System.out.println("Seeking in base class");
                return parent.getInheritedField(fname);
            }
            System.out.println("No base class");
            return null;
        }
        
        public FieldDefinition getInheritedField(String fname){
            System.out.println("Looking for field " + fname + " in class " + name);
            for(FieldDefinition field : fields){
                if(field.name.equals(fname)&&field.access!=AccessControlKeyword.PRIVATE){
                    System.out.println("FOUND");
                    return field;
                }
            }
            if(parent!=null){
                System.out.println("Seeking in base class");
                return parent.getInheritedField(fname);
            }
            System.out.println("No base class");
            return null;
        }
        
        public boolean inheritsFrom(ClassDefinition possibleParent){
            if(parent==possibleParent){
                return true;
            }
            return parent!=null&&parent.inheritsFrom(possibleParent);
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

    public static class VariableDefinition  {
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

    