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

import java.awt.Color;
import java.util.Vector;
import javax.swing.JPanel;

/**
 * The behavior unit of actors.
 * Actions can not be extended nor implemented. Instead, create a new ActionType.
 * @author Luís Reis
 */
public final class Action {
    private ActionType type = null;
    public Object args = null;
    public boolean expanded = true;
    
    /**
     * Creates an action with a given type
     * @param type The action type
     */
    public Action(ActionType type){
        this.type = type;
    }
    
    /**
     * Gets the type of the action
     * @return The Action type
     */
    public ActionType getType(){
        return type;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Object clone(){
        Action a = new Action(type);
        a.args = args;
        a.expanded = expanded;
        return a;
    }
}
