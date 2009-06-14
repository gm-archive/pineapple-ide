/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pineapple.editors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.managers.IntegratedUndoManager;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Simple plain text editor.
 * 
 * @author Luís Reis
 */
public class TextEditor extends DocumentPane {

    private static final long serialVersionUID = 1L;
    private JScrollPane scroll;
    private JTextPane editor;
    
    /**
     * Deals with undo and redo operations
     */
    public IntegratedUndoManager undo = new IntegratedUndoManager();

    /**
     * Creates a text editor from a file.
     * 
     * @param e The file to read the data from.
     */
    public TextEditor(BasicFile e) {
        super(e);
        this.file = e;

        setBackground(Color.white);
        setLayout(new BorderLayout());
        this.scroll = new JScrollPane();
        this.editor = new JTextPane();
        this.editor.setVisible(true);
        this.scroll.setVisible(true);
        this.scroll.setViewportView(editor);
        this.add(scroll, BorderLayout.CENTER);

        if (e != null && e.exists()) {
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(e.getReader());
                StringBuilder b = new StringBuilder((int) e.getLength());
                int r;
                while ((r = in.read()) != -1) {
                    b.append((char) r);
                }
                editor.setText(b.toString());
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
        editor.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent evt) {
                setModified(true);
            }

            @Override
            public void removeUpdate(DocumentEvent evt) {
                setModified(true);
            }

            @Override
            public void changedUpdate(DocumentEvent evt) {
                setModified(true);
            }
        });
        editor.getDocument().addUndoableEditListener(undo);
    }

    /**
     * Saves the file
     */
    @Override
    public boolean saveBackend() {
        try {
            BufferedOutputStream out = new BufferedOutputStream(file.getWriter());
            out.write(editor.getText().getBytes());
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setupEditMenu(JMenu editMenu) {
        JMenuItem undoItem = new JMenuItem("Undo");
        undoItem.setMnemonic('u');
        undoItem.setVisible(true);
        undoItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                undo.undo();
            }
        });
        undoItem.setEnabled(undo.canUndo());
        editMenu.add(undoItem);

        JMenuItem redoItem = new JMenuItem("Redo");
        redoItem.setMnemonic('r');
        redoItem.setVisible(true);
        redoItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                undo.redo();
            }
        });
        redoItem.setEnabled(undo.canRedo());
        editMenu.add(redoItem);

        editMenu.addSeparator();

        JMenuItem cut = new JMenuItem("Cut");
        cut.setMnemonic('t');
        cut.setVisible(true);
        cut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                editor.cut();
            }
        });
        editMenu.add(cut);
        JMenuItem copy = new JMenuItem("Copy");
        copy.setMnemonic('y');
        copy.setVisible(true);
        copy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                editor.copy();
            }
        });
        editMenu.add(copy);
        JMenuItem paste = new JMenuItem("Paste");
        paste.setMnemonic('P');
        paste.setVisible(true);
        paste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                editor.paste();
            }
        });
        editMenu.add(paste);
        JMenuItem selall = new JMenuItem("Select All");
        selall.setMnemonic('A');
        selall.setVisible(true);
        selall.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                editor.selectAll();
            }
        });
        editMenu.add(selall);

        return true;
    }
}
