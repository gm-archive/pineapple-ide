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
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.gcreator.gui.ActionRenderer;
import org.gcreator.gui.EmbedActionRenderer;

/**
 * An Action Type representing code
 * @author Luís Reis
 */
public class IfActionType extends ActionType{
    /**
     * The If Action type, provided as a static variable to make
     * sure it is only initialized once.
     */
    public static final IfActionType ACTIONTYPE_IF = new IfActionType();
    
    protected IfActionType(){
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public JPanel render(Action action, Color bgColor, int colorIndex, ActionRenderer actRender){
        if(action==null||action.getType()!=this){
            return null;
        }
        
        CodePanel p = new CodePanel(action, bgColor, colorIndex, actRender);
        p.setBackground(bgColor);
        
        return p;
    }
    
    private class CodePanel extends JPanel{
        private static final long serialVersionUID = 1594450534973488561L;
        public JLabel label;
        public Action action;
        public EmbedActionRenderer ear;
        
        public CodePanel(Action action, Color bgColor, int colorIndex, final ActionRenderer actRender){
            setLayout(null);
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e){
                    label.setSize(getWidth(), 15);
                    if(CodePanel.this.action.expanded){
                        ear.setSize(getWidth()-10, ear.getPreferredSize().height);
                    }
                }
            });
            this.action = action;
            label = new JLabel("["+(action.expanded?"-":"+")+"] If");
            label.setVisible(true);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt){
                    CodePanel.this.action.expanded = !CodePanel.this.action.expanded;
                    label.setText("["+(CodePanel.this.action.expanded?"-":"+")+"] If");
                    actRender.updateUI();
                }
            });
            add(label);
            label.setLocation(0, 10);
            label.setSize(getWidth(), 15);
            label.setVisible(true);
            add(label);
            if(action.expanded){
                ear = new EmbedActionRenderer(action, actRender, colorIndex);
                ear.setVisible(true);
                add(ear);
                ear.setLocation(10, 40);
                ear.setSize(getWidth()-10, ear.getPreferredSize().height);
                ear.updateUI();
            }
        }
        
        @Override
        public Dimension getPreferredSize(){
            Dimension d = new Dimension(label.getPreferredSize());
            d.height += 20;
            if(action.expanded){
                d.height += ear.getPreferredSize().height + 10;
            }
            d.width = getWidth();
            return d;
        }
    }
    
    @Override
    public String getName(){
        return "If";
    }
}
