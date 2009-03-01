/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

This file is part of Syntax Highlighter.

Syntax Highlighter is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Syntax Highlighter is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU General Public License
along with Syntax Highlighter.  If not, see <http://www.gnu.org/licenses/>.

 */
package org.gcreator.pineapple.syntax;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.gcreator.pineapple.editors.TextEditor;
import org.gcreator.pineapple.project.io.Register;

/**
 * Editor for PineDL, and a bunch of other langauges.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class PineDLEditor extends JPanel {

    private static final long serialVersionUID = 1L;
    private RTextScrollPane scroll;
    public RSyntaxTextArea editor;
    protected Register data;

    public PineDLEditor(Register data) {
        this.setLayout(new BorderLayout());
        this.editor = new RSyntaxTextArea();
        this.data = data;

        editor.restoreDefaultSyntaxHighlightingColorScheme();

        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(data.getReader());
            StringBuilder b = new StringBuilder(in.available());
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

        scroll = new RTextScrollPane(getWidth(), getHeight(), editor, true);
        editor.setBracketMatchingEnabled(true);
        editor.setSyntaxEditingStyle(RSyntaxTextArea.PINEDL_SYNTAX_STYLE);
        
        this.add(scroll, BorderLayout.CENTER);
    }

    protected boolean setupEditMenu(JMenu editMenu) {
        JMenuItem cut = new JMenuItem("Cut");
        cut.setMnemonic('t');
        cut.setVisible(true);
        cut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.cut();
            }
        });
        editMenu.add(cut);
        JMenuItem copy = new JMenuItem("Copy");
        copy.setMnemonic('y');
        copy.setVisible(true);
        copy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.copy();
            }
        });
        editMenu.add(copy);
        JMenuItem paste = new JMenuItem("Paste");
        paste.setMnemonic('P');
        paste.setVisible(true);
        paste.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.paste();
            }
        });
        editMenu.add(paste);
        JMenuItem selall = new JMenuItem("Select All");
        selall.setMnemonic('A');
        selall.setVisible(true);
        selall.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.selectAll();
            }
        });
        editMenu.add(selall);

        editMenu.addSeparator();
        editMenu.add(PineDLEditor.createStyleMenu(editor));


        return true;
    }

    /**
     * Creates a new style menu for choosing the syntax style.
     * 
     * @param r The {@link RSyntaxTextArea} to apply any changes to.
     * @return A menu contianing all of the syntax styles.
     */
    public static JMenu createStyleMenu(final RSyntaxTextArea r) {
        JMenu stylingMenu = new JMenu("Style");

        Vector<Integer> vi = new Vector<Integer>();
        vi.add(RSyntaxTextArea.NO_SYNTAX_STYLE);
        for (int value : PineDLPlugin.styles.values()) {
            if (!vi.contains(value)) {
                vi.add(value);
            }
        }

        ButtonGroup menus = new ButtonGroup();
        for (final int value : vi) {
            JRadioButtonMenuItem menuItem;
            menuItem = new JRadioButtonMenuItem(PineDLPlugin.names.get(value));
            menuItem.setSelected(r.getSyntaxEditingStyle() == value);
            menuItem.setAccelerator(null);
            menuItem.setToolTipText(PineDLPlugin.names.get(value));
            menuItem.setSelected(value == r.getSyntaxEditingStyle());
            menuItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    r.setSyntaxEditingStyle(value);
                }
            });
            menus.add(menuItem);
            stylingMenu.add(menuItem);
        }
        return stylingMenu;
    }

    public boolean save() {
        try {
            BufferedOutputStream out = new BufferedOutputStream(data.getWriter());
            out.write(editor.getText().getBytes());
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
