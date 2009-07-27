/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler;

import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class Library {
    public static class Class{
        public Hashtable<String, Field> fields = new Hashtable<String, Field>();
        public Hashtable<String, Method> methods = new Hashtable<String, Method>();
        public Vector<Constructor> constructors = new Vector<Constructor>();
        public Vector<String> inheritsFrom = new Vector<String>();
        public boolean isFinal = false;
        
        public void addMethod(String name){
            methods.put(name, new Method());
        }
        
        public void addMethod(String name, Method m){
            methods.put(name, m);
        }
    }
    public static class Field{
        public boolean isStatic = false;
        public boolean isConst = false;
    }
    public static class Method{
        public boolean isStatic = false;
        public boolean isAbstract = false;
        public Hashtable<String, Argument> arguments = new Hashtable<String, Argument>();
        
        public void addArgument(String name, Argument a){
            arguments.put(name, a);
        }
        
        public void addArgument(String name, boolean isConst, boolean isOptional, boolean isVarargs){
            arguments.put(name, new Argument(isConst, isOptional, isVarargs));
        }
    }
    public static class Constructor{
        public Hashtable<String, Argument> arguments = new Hashtable<String, Argument>();
    }
    public static class Argument{
        public boolean isConst = false;
        public boolean isOptional = false; //Default values
        public boolean isVarargs = false;
        
        public Argument(boolean isConst, boolean isOptional, boolean isVarargs){
            this.isConst = isConst;
            this.isOptional = isOptional;
            this.isVarargs = isVarargs;
        }
    }
    
    public Hashtable<String, Class> classes = new Hashtable<String, Class>();
    public Hashtable<String, Method> methods = new Hashtable<String, Method>();
    
    final Class ARRAY_TYPE;
    
    public void addClass(String name, Class cls){
        classes.put(name, cls);
    }
    
    {
        Class cls;
        Method m;
        
        //[]
        cls = ARRAY_TYPE = new Class();
        cls.isFinal = true;
        m = new Method();
        m.addArgument("method", true, true, false);
        cls.addMethod("sort", m);
        cls.addMethod("length");
        m = new Method();
        m.addArgument("method", true, false, false);
        cls.addMethod("each", m);
        m = new Method();
        m.addArgument("method", true, false, false);
        cls.addMethod("where", m);
        m = new Method();
        m.addArgument("method", true, false, false);
        cls.addMethod("transform", m);
        cls.addMethod("keys");
        cls.addMethod("flip");
        cls.addMethod("pop");
        m = new Method();
        m.addArgument("value", true, false, false);
        cls.addMethod("find", m);
        cls.addMethod("last");
        m = new Method();
        m.addArgument("times", true, false, false);
        cls.addMethod("repeat", m);
        addClass("[]", cls);
    }
}
