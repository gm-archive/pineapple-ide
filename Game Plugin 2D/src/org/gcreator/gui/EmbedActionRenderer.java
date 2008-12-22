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

package org.gcreator.gui;

import java.awt.Color;
import java.util.Vector;
import org.gcreator.actions.Action;
import org.gcreator.events.Event;

/**
 * An embedded action renderer
 * @author Luís Reis
 */
public class EmbedActionRenderer extends ActionRenderer{
    private static final long serialVersionUID = 3663775814144928683L;
    public Action a = null;
    private ActionRenderer renderer = null;
    private int c = 0;
    
    public EmbedActionRenderer(Action a, ActionRenderer parent, int usedColor){
        this.a = a;
        renderer = parent;
        c = usedColor;
        setOpaque(false);
        render();
    }
    
    @Override
    public int getUsedColor(){
        return c;
    }
    
    public Vector<Action> getActions(){
        if(a==null){
            return null;
        }
        return a.getChildren();
    }
    
    @Override
    public Action getContainerAction(){
        return a;
    }
    
    public void addAction(Action act){
        if(a!=null){
            a.addAction(act);
        }
    }
}
