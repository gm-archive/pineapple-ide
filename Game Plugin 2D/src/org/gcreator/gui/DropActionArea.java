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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import org.gcreator.actions.Action;

/**
 *
 * @author Luís Reis
 */
public class DropActionArea extends JPanel {

    private static final long serialVersionUID = -4072377202027738156L;
    public JLabel label;
    public ActionRenderer renderer;

    public DropActionArea(ActionRenderer renderer) {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        label = new JLabel("(Drop here)");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVisible(true);
        add(label, BorderLayout.CENTER);
        this.renderer = renderer;
        new ActionDropTargetListener();
    }

    @Override
    public Dimension getMinimumSize() {
        Dimension d = label.getPreferredSize();
        
        d.width += 10;
        d.height *= 2;
        
        return d;
    }

    class ActionDropTargetListener extends DropTargetAdapter {

        private DropTarget dropTarget;

        public ActionDropTargetListener() {
            dropTarget = new DropTarget(DropActionArea.this, this);
        }

        public void drop(DropTargetDropEvent event) {
            try {
                Transferable tr = event.getTransferable();
                Action action = (Action) tr.getTransferData(new DataFlavor(Action.class, "Action"));
                if(event.getDropAction()==TransferHandler.COPY){
                    action = (Action) action.clone();
                }
                if (event.isDataFlavorSupported(new DataFlavor(Action.class, "Action"))) {
                    event.acceptDrop(event.getDropAction());
                    action.parent = renderer.getContainerAction();
                    renderer.addAction(action);
                    event.dropComplete(true);
                    renderer.render();
                    return;
                }
                event.rejectDrop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
