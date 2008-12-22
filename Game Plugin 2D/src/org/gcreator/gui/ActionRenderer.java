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
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;
import javax.swing.JPanel;
import org.gcreator.actions.Action;

/**
 * Renders actions
 * @author Luís Reis
 */
public abstract class ActionRenderer extends JPanel{
    public ActionRenderer(){
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt){
                updateSizes();
            }
        });
        setDoubleBuffered(true);
    }
    
    public abstract Vector<Action> getActions();
    
    public ActionRenderer getParentRenderer(){
        return null;
    }
    
    public void updateSizes(){
        super.updateUI();
        int w = getWidth();
        for(Component c : getComponents()){
            c.setSize(w, c.getHeight());
            if(c instanceof ActionRenderer){
                ((ActionRenderer) c).updateSizes();
            }
        }
    }
    
    /**
     * Gets the used action color, so that it won't be repeated
     * @return A Color that won't be used as background of inner actions
     */
    public abstract Color getUsedColor();
    
    public static final Color LIGHT_ORANGE = new Color(255, 170, 40);
    public static final Color LIGHT_BLUE = new Color(170, 220, 255);
    public static final Color LIGHT_GREEN = new Color(170, 255, 170);
    
    public int lh = 35;
    
    @Override
    public void updateUI(){
        super.updateUI();
        removeAll();
        Vector<Action> actions = getActions();
        if(actions==null){ return; }
        setLayout(null);
        int currenty = 0;
        boolean bColor = false;
        Color usedColor = getUsedColor();
        ActionRenderer render = getParentRenderer();
        for(Action action : actions){
            JPanel p = action.render(
                    bColor?
                        (usedColor==LIGHT_ORANGE?LIGHT_GREEN:LIGHT_ORANGE)
                        :(usedColor==LIGHT_BLUE?LIGHT_GREEN:LIGHT_BLUE),
                        render==null?this:render);
            p.setVisible(true);
            int h = p.getPreferredSize().height;
            add(p);
            p.setSize(getWidth(), h);
            p.setLocation(0, currenty);
            currenty+=h;
            bColor = !bColor;
        }
        DropActionArea daa = new DropActionArea(this);
        daa.setVisible(true);
        add(daa);
        int h = daa.getPreferredSize().height;
        daa.setSize(getWidth(), h);
        daa.setLocation(0, currenty);
        currenty+=h;
        lh = currenty;
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(1, lh);
    }
}
