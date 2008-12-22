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

package org.gcreator.dnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import org.gcreator.actions.ActionType;

/**
 * A palette action to drag
 * @author Luís Reis
 */
public class PaletteAction extends JLabel{
    private static final long serialVersionUID = -3838618778031658987L;
    public ActionType type;
    
    public PaletteAction(ActionType type){
        this.type = type;
        this.setText(type.getName());
        setTransferHandler(new ActionTransferHandler());
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt){
                getTransferHandler().exportAsDrag(
                        PaletteAction.this, evt, TransferHandler.COPY);
            }
        });
        setOpaque(true);
        setBackground(Color.WHITE);
    }
    
    @Override
    public Dimension getMaximumSize(){
        Dimension d = new Dimension(getParent().getWidth(), super.getPreferredSize().height);
        System.out.println("pa w:" + d);
        return d;
    }
}
