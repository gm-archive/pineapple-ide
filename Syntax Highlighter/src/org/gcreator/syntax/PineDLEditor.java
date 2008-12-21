/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.syntax;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.gcreator.editors.TextEditor;
import org.gcreator.gui.DocumentPane;
import org.gcreator.project.io.BasicFile;

/**
 * Editor for PineDL, and a bunch of other langauges.
 * 
 * @author Luís Reis
 */
public class PineDLEditor extends DocumentPane {

    private static final long serialVersionUID = 1L;
    private RTextScrollPane scroll;
    private RSyntaxTextArea editor;
    public static Hashtable<String, Integer> styles = new Hashtable<String, Integer>();
    public static Hashtable<Integer, String> names = new Hashtable<Integer, String>();
    

    static {
        names.put(RSyntaxTextArea.NO_SYNTAX_STYLE, "No style");
        styles.put("asm", RSyntaxTextArea.ASSEMBLER_X86_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.ASSEMBLER_X86_SYNTAX_STYLE, "Assembly");
        styles.put("c", RSyntaxTextArea.C_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.C_SYNTAX_STYLE, "C");
        styles.put("cpp", RSyntaxTextArea.CPLUSPLUS_SYNTAX_STYLE);
        styles.put("h", RSyntaxTextArea.CPLUSPLUS_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.CPLUSPLUS_SYNTAX_STYLE, "C++");
        styles.put("cs", RSyntaxTextArea.CSHARP_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.CSHARP_SYNTAX_STYLE, "C#");
        styles.put("f", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("f77", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("for", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("f90", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("pyf", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.FORTRAN_SYNTAX_STYLE, "Fortran");
        styles.put("groovy", RSyntaxTextArea.GROOVY_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.GROOVY_SYNTAX_STYLE, "Groovy");
        styles.put("htm", RSyntaxTextArea.HTML_SYNTAX_STYLE);
        styles.put("html", RSyntaxTextArea.HTML_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.HTML_SYNTAX_STYLE, "HTML");
        styles.put("java", RSyntaxTextArea.JAVA_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.JAVA_SYNTAX_STYLE, "Java");
        styles.put("js", RSyntaxTextArea.JAVASCRIPT_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.JAVASCRIPT_SYNTAX_STYLE, "JavaScript");
        styles.put("jsp", RSyntaxTextArea.JSP_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.JSP_SYNTAX_STYLE, "JSP");
        styles.put("lua", RSyntaxTextArea.LUA_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.LUA_SYNTAX_STYLE, "Lua");
        styles.put("pl", RSyntaxTextArea.PERL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.PERL_SYNTAX_STYLE, "Perl");
        styles.put("pdl", RSyntaxTextArea.PINEDL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.PINEDL_SYNTAX_STYLE, "PineDL");
        styles.put("rb", RSyntaxTextArea.RUBY_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.RUBY_SYNTAX_STYLE, "Ruby");
        styles.put("sas", RSyntaxTextArea.SAS_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.SAS_SYNTAX_STYLE, "SAS");
        styles.put("sql", RSyntaxTextArea.SQL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.SAS_SYNTAX_STYLE, "SQL");
        styles.put("tcl", RSyntaxTextArea.TCL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.TCL_SYNTAX_STYLE, "TCL");
        styles.put("sh", RSyntaxTextArea.UNIX_SHELL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.UNIX_SHELL_SYNTAX_STYLE, "Bourne [UNIX] Shell Script");
        styles.put("bat", RSyntaxTextArea.WINDOWS_BATCH_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.WINDOWS_BATCH_SYNTAX_STYLE, "BAT (Windows Batch)");
        styles.put("xml", RSyntaxTextArea.XML_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.XML_SYNTAX_STYLE, "XML");
    }

    public PineDLEditor(BasicFile file) {
        super(file);
        this.setLayout(new BorderLayout());
        this.editor = new RSyntaxTextArea();
        this.file = file;

        editor.restoreDefaultSyntaxHighlightingColorScheme();
        editor.addKeyListener(new KeyAdapter() {
            
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
            editor.setSyntaxEditingStyle(RSyntaxTextArea.NO_SYNTAX_STYLE);
        } else {
            if (styles.containsKey(x.toLowerCase())) {
                System.out.println("Found");
                editor.setSyntaxEditingStyle(styles.get(x.toLowerCase()));
            } else {
                System.out.println("Not found: " + x.toLowerCase());
                editor.setSyntaxEditingStyle(RSyntaxTextArea.NO_SYNTAX_STYLE);
            }
        }

        if (file.exists()) {
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(file.getInputStream());
                StringBuilder b = new StringBuilder((int) file.getLength());
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

            public void insertUpdate(DocumentEvent evt) {
                setModified(true);
            }

            public void removeUpdate(DocumentEvent evt) {
                setModified(true);
            }

            public void changedUpdate(DocumentEvent evt) {
                setModified(true);
            }
        });

        scroll = new RTextScrollPane(getWidth(), getHeight(), editor, true);
        this.add(scroll, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean saveBackend() {
        try {
            BufferedOutputStream out = new BufferedOutputStream(file.getOutputStream());
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
        for (int value : PineDLEditor.styles.values()) {
            if (!vi.contains(value)) {
                vi.add(value);
            }
        }
        
        ButtonGroup menus = new ButtonGroup();
        for (final int value : vi) {
            JRadioButtonMenuItem menuItem;
            menuItem = new JRadioButtonMenuItem(PineDLEditor.names.get(value));
            menuItem.setSelected(r.getSyntaxEditingStyle() == value);
            menuItem.setAccelerator(null);
            menuItem.setToolTipText(names.get(value));
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
}
