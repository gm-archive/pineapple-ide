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
import org.gcreator.actions.panels.VariableDeclarationPanel;

/**
 * An Action Type representing a catch statement
 * @author Luís Reis
 */
public class CatchActionType extends ActionType{
    /**
     * The Catch Action type, provided as a static variable to make
     * sure it is only initialized once.
     */
    public static final CatchActionType ACTIONTYPE_CATCH = new CatchActionType();
    
    protected CatchActionType(){
        
    }
    
    @Override
    public void makeActionPanel(final Action a, JPanel panel){
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        VariableDeclarationPanel p = new VariableDeclarationPanel(a);
        p.setVisible(true);
        panel.add(p, BorderLayout.CENTER);
    }
    
    @Override
    public String getName(){
        return "Catch";
    }
    
    @Override
    public String toPineDL(Action a){
        return "catch(" + (a.args==null?"":a.args.toString()) + ")";
    }
}
