/*
    Copyright (C) 2009 Luís Reis<luiscubal@gmail.com>
    Copyright (C) 2009 Serge Humphrey<bob@bobtheblueberry.com>

    This file is part of Syntax Highlighter.

    PineDL Integration is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PineDL Integration is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with PineDL Integration.  If not, see <http://www.gnu.org/licenses/>.

 */


package org.gcreator.pineapple.syntax;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.gcreator.pineapple.editors.TextEditor;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * A {@link DocumentPane} for editing PineDL.
 *
 * @author Serge Humphrey
 */
public class PineDLPane extends DocumentPane {
    
    private static final long serialVersionUID = 12665874653L;
    protected PineDLEditor editor;

    /**
     * Creates a new {@link PineDLPane}.
     * 
     * @param file The file to open.
     */
    public PineDLPane(BasicFile file) {
        super(file);
        this.setLayout(new BorderLayout());
        this.editor = new PineDLEditor(file);

        editor.editor.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
                    save();
                }
            }
        });
        String x;
        int i = file.getName().lastIndexOf('.');
        if (i < 0 || i >= file.getName().length()) {
            x = null;
        } else {
            x = file.getName().substring(i + 1);
        }

        if (x == null) {
            editor.editor.setSyntaxEditingStyle(RSyntaxTextArea.NO_SYNTAX_STYLE);
        } else {
            if (PineDLPlugin.styles.containsKey(x.toLowerCase())) {
                editor.editor.setSyntaxEditingStyle(PineDLPlugin.styles.get(x.toLowerCase()));
            } else {
                editor.editor.setSyntaxEditingStyle(RSyntaxTextArea.NO_SYNTAX_STYLE);
            }
        }

        if (file.exists()) {
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(file.getReader());
                StringBuilder b = new StringBuilder((int) file.getLength());
                int r;
                while ((r = in.read()) != -1) {
                    b.append((char) r);
                }
                editor.editor.setText(b.toString());
            } catch (IOException ex) {
                Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        editor.editor.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent evt) {
                setModified(true);
            }

            public void removeUpdate(DocumentEvent evt) {
                setModified(true);
            }

            public void changedUpdate(DocumentEvent evt) {
            }
        });
        this.add(editor, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean saveBackend() {
        try {
            BufferedOutputStream out = new BufferedOutputStream(file.getWriter());
            out.write(editor.editor.getText().getBytes());
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
