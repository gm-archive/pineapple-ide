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

package org.gcreator.actions;

import java.util.Vector;
import javax.swing.JPanel;

/**
 * 
 * @author Luís Reis
 */
public class ActionType {
    
    public static Vector<ActionType> actionTypes = new Vector<ActionType>();
    static{
        actionTypes.add(IfActionType.ACTIONTYPE_IF);
        actionTypes.add(ElseActionType.ACTIONTYPE_ELSE);
        actionTypes.add(CodeActionType.ACTIONTYPE_CODE);
        actionTypes.add(WhileActionType.ACTIONTYPE_WHILE);
        actionTypes.add(BeginBlockActionType.ACTIONTYPE_BEGINBLOCK);
        actionTypes.add(EndBlockActionType.ACTIONTYPE_ENDBLOCK);
        actionTypes.add(ReturnActionType.ACTIONTYPE_RETURN);
        actionTypes.add(ThrowActionType.ACTIONTYPE_THROW);
    }
    
    protected ActionType(){
        
    }
    
    /**
     * Renders the action
     * @param action The action to render
     * @return The text to 
     */
    public String getText(Action action){
        if(action.getType()!=this){
            return null;
        }
        return getName();
    }
    
    /**
     * Renders the action's properties
     * @param action The action to render
     * @param panel The panel to output to
     */
    public void makeActionPanel(Action action, JPanel panel){
        panel.removeAll();
    }
    
    /**
     * Saves the arguments
     * @param action The action to save
     * @return The string version of the file
     */
    public String save(Action action){
        return action.args==null?null:action.args.toString();
    }
    
    /**
     * Loads the arguments from a string
     * @param action The action to use as storage
     * @param args The arguments to load
     */
    public void load(Action action, String args){
        action.args = args;
    }
    
    /**
     * Gets the name of the action, as displayed in the palette
     * @return
     */
    public String getName(){
        return "[UNDEFINED: "+getClass().getName()+"]";
    }
    
    /**
     * Generates PineDL code
     * @param a The action to generate code from
     * @return The PineDL code
     */
    public String toPineDL(Action a){
        return "";
    }
}
