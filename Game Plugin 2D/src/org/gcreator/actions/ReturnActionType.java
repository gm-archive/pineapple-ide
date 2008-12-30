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

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.gcreator.actions.panels.ExpressionPanel;

/**
 * An Action Type representing a return statement
 * @author Luís Reis
 */
public class ReturnActionType extends ActionType{
    /**
     * The Return Action type, provided as a static variable to make
     * sure it is only initialized once.
     */
    public static final ReturnActionType ACTIONTYPE_RETURN = new ReturnActionType();
    
    protected ReturnActionType(){
        
    }
    
    @Override
    public void makeActionPanel(final Action a, JPanel panel){
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        ExpressionPanel p = new ExpressionPanel(a);
        p.setVisible(true);
        panel.add(p, BorderLayout.CENTER);
    }
    
    @Override
    public String getName(){
        return "Return";
    }
    
    @Override
    public String toPineDL(Action a){
        return "return " + (a.args==null?"":a.args.toString()) + ";";
    }
}
