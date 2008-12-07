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

/**
 *
 * @author Luís Reis
 */
public class EmbedActionRenderer extends ActionRenderer{
    private static final long serialVersionUID = -2837866695562559862L;
    private Action arg;
    private Color usedColor;
    private ActionRenderer actRender;

    public EmbedActionRenderer(Action arg, Color usedColor, ActionRenderer actRender){
        this.arg = arg;
        this.usedColor = usedColor;
        this.actRender = actRender;
        updateUI();
    }
    
    @Override
    public ActionRenderer getParentRenderer(){
        return actRender;
    }
    
    public Color getUsedColor(){
        return usedColor;
    }
    
    public Vector<Action> getActions(){
        if(arg==null){ return null; }
        return arg.children;
    }
}
