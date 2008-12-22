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
import java.awt.Component;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.gcreator.actions.Action;

/**
 * A panel that renders the actions
 * @author Luís Reis
 */
public abstract class ActionRenderer extends JPanel{
    private static final long serialVersionUID = -3361547867564590437L;
    private DropActionArea area;
    
    public static final Color[] colors = new Color[]{
        new Color(100, 255, 100),
        new Color(100, 100, 255),
        new Color(255, 200, 50)
    };

    public ActionRenderer(){
        setDoubleBuffered(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        area = new DropActionArea(this);
    }
    
    /*@Override
    public void updateUI(){
        render();
        super.updateUI();
    }*/
    
    public void render(){
        System.out.println("Rendering " + getClass().getCanonicalName());
        removeAll();
        Component[] cl = getComponentList();
        for(Component c : cl){
            if(c!=null){
                System.out.println("Rendering panel " + c.getClass().getCanonicalName());
                c.setVisible(true);
                add(c);
            }
        }
        updateUI();
    }
    
    public Component retrieveComponent(int n){
        int cc = getActionCount()+1;
        if(n>=cc){
            throw new IndexOutOfBoundsException();
        }
        if(n==cc-1){
            return area;
        }
        int ci = getColorFor(n);
        return getActions().get(n).render(colors[ci], ci, this);
    }
    
    public int getColorFor(int n){
        int u = getUsedColor();
        return n%2==0?(u==0?2:0):(u==1?2:1);
    }
    
    public int getUsedColor(){
        return 0; 
    }
    
    public Component[] getComponentList(){
        Component[] c = new Component[getActionCount()+1];
        
        for(int i = 0; i < c.length; i++){
            c[i] = retrieveComponent(i);
        }
        
        return c;
    }
    
    public int getActionCount(){
        Vector<Action> a = getActions();
        if(a==null){
            return 0;
        }
        return a.size();
    }
    
    public abstract Vector<Action> getActions();
    
    public abstract void addAction(Action a);
    
    public Action getContainerAction(){
        return null;
    }
}
