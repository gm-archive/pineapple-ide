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

package org.gcreator.formats;

import java.util.Vector;
import org.gcreator.events.Event;

/**
 * Represents an object with events and fields
 * @author luis
 */
public class BehaviorObject {
    /**
     * The events(functions)
     */
    public Vector<Event> events = new Vector<Event>();
    /**
     * The fields(variables)
     */
    public Vector<Field> fields = new Vector<Field>();
    
    //<editor-fold defaultstate="collapsed" desc="class Field">
    /**
     * A simplex class that stores all of the data for a field.
     */
    public static class Field {

        protected String type;
        protected String name;
        protected String defaultValue;
        protected boolean isStatic;
        protected boolean isFinal;

        /**
         * Creates a new {@link Field} that is not static and has
         * no default value.
         * 
         * @param name The field's name.
         * @param type The field's type.
         */
        public Field(String name, String type) {
            this(name, type, false, null);
        }

        /**
         * Creates a new {@link Field} that has no default value.
         * 
         * @param name The field's name.
         * @param type The field's type.
         * @param isStatic Whether the field is static or not.
         */
        public Field(String name, String type, boolean isStatic) {
            this(name, type, isStatic, null);
        }

        /**
         * Creates a new {@link Field}.
         * 
         * @param name The field's name.
         * @param type The field's type.
         * @param isStatic Whether the field is static or not.
         * @param defaultValue The default value for the field.
         */
        public Field(String name, String type, boolean isStatic, String defaultValue) {
            this(name, type, isStatic, false, defaultValue);
        }

        /**
         * Creates a new {@link Field}.
         * 
         * @param name The field's name.
         * @param type The field's type.
         * @param isStatic Whether the field is static or not.
         * @param isFinal Whether the field is final or not.
         * @param defaultValue The default value for the field.
         */
        public Field(String name, String type, boolean isStatic, boolean isFinal, String defaultValue) {
            this.name = name;
            this.type = type;
            this.isStatic = isStatic;
            this.isFinal = isFinal;
            this.defaultValue = defaultValue;
        }
        
        protected Field() {
        }

        /**
         * Gets the type of this field, e.g. <tt>int</tt>.
         * 
         * @return The type of this field.
         */
        public String getType() {
            return type;
        }

        /**
         * Gets the name of this field, e.g. <tt>x</tt>.
         * 
         * @return The name of this variable.
         */
        public String getName() {
            return name;
        }

        /**
         * Gets whether the field is <tt>static</tt> or not.
         * 
         * @return <tt>true</tt> if this field is <tt>static</tt>, else <tt>false</tt>.
         */
        public boolean isStatic() {
            return isStatic;
        }

        /**
         * Gets the default value of this field.
         * 
         * @return This field's default value.
         */
        public String getDefaultValue() {
            return defaultValue;
        }

        /**
         * Gets whether this fields is <tt>final</tt> or not.
         * 
         * @return <tt>true</tt> if this field is <tt>final</tt>, else <tt>false</tt>.
         */
        public boolean isFinal() {
            return isFinal;
        }
        
        /**
         * Sets the type of the field.
         * 
         * @param type The new type for this field.
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * Sets the name of this field.
         * 
         * @param name The new name for the field.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets whether this field is </tt>static<tt> or not.
         * 
         * @param isStatic Whether this field should be static
         * or not.
         */
        public void setStatic(boolean isStatic) {
            this.isStatic = isStatic;
        }

        /**
         * Sets the default value for this field.
         * 
         * @param defaultValue The new default value for this
         * field.
         */
        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }
        
        /**
         * Sets whether this field is <tt>final</tt> or not.
         * 
         * @param isFinal Whether this field hsould be <tt>final</tt> or not.
         */
        public void setFinal(boolean isFinal) {
            this.isFinal = isFinal;
        }
        
    }
    //</editor-fold>
}
