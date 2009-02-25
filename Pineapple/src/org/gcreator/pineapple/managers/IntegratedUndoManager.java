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
package org.gcreator.pineapple.managers;

import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.gui.PineappleGUI;

/**
 *
 * @author Luís Reis
 */
public class IntegratedUndoManager extends UndoManager {

    public static final long serialVersionUID = 1;

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        super.undoableEditHappened(e);
        updateMenus();
    }

    @Override
    public void undo() {
        super.undo();
        updateMenus();
    }

    @Override
    public void redo() {
        super.redo();
        updateMenus();
    }

    public void updateMenus() {
        DocumentPane pane = PineappleGUI.dip.getSelectedDocument();
        PineappleGUI.editMenu.removeAll();
        if (pane != null) {
            PineappleGUI.editMenu.setEnabled(
                    pane.setupEditMenu(PineappleGUI.editMenu));
            PineappleGUI.fileSave.setEnabled(pane.canSave());
        } else {
            PineappleGUI.editMenu.setEnabled(false);
            PineappleGUI.fileSave.setEnabled(false);
        }
    }
}
