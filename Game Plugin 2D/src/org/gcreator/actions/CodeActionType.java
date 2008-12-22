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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.gcreator.gui.ActionRenderer;

/**
 * An Action Type representing code
 * @author Luís Reis
 */
public class CodeActionType extends ActionType {

    /**
     * The Code Action type, provided as a static variable to make
     * sure it is only initialized once.
     */
    public static final CodeActionType ACTIONTYPE_CODE = new CodeActionType();

    protected CodeActionType() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JPanel render(Action action, Color bgColor, ActionRenderer actRender) {
        if (action == null || action.getType() != this) {
            return null;
        }

        CodePanel p = new CodePanel(action, actRender);
        p.setBackground(bgColor);

        return p;
    }

    private class CodePanel extends JPanel {

        private static final long serialVersionUID = 1594450534973488561L;
        public JLabel label;
        public Action action;
        RSyntaxTextArea editor = null;
        RTextScrollPane scroll = null;

        public CodePanel(Action action, final ActionRenderer actRender) {
            setLayout(new BorderLayout());
            this.action = action;
            //label = new JLabel(action.args.toString());
            //label.setVisible(true);
            //label.addMouseListener(new MouseAdapter() {

            //    @Override
            //    public void mouseClicked(MouseEvent e) {
            editor = new RSyntaxTextArea();
            editor.restoreDefaultSyntaxHighlightingColorScheme();
            editor.setSyntaxEditingStyle(RSyntaxTextArea.PINEDL_SYNTAX_STYLE);
            scroll =
                    new RTextScrollPane(getWidth(),
                    getHeight(), editor, false);
            scroll.setVisible(true);
            editor.setVisible(true);
            editor.setFocusable(true);
            editor.setText(CodePanel.this.action.args == null ? "" : CodePanel.this.action.args.toString());
            scroll.setFocusable(false);
            add(scroll, BorderLayout.CENTER);
            editor.getDocument().addDocumentListener(new DocumentListener() {

                public void insertUpdate(DocumentEvent e) {
                    update(e);
                }

                public void removeUpdate(DocumentEvent e) {
                    update(e);
                }

                public void changedUpdate(DocumentEvent e) {
                    update(e);
                }

                public void update(DocumentEvent e) {
                    CodePanel.this.action.args = editor.getText();
                }
            });
        //        label.setVisible(false);
                    /*editor.addKeyListener(new KeyAdapter() {
        
        @Override
        public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='\n'){
        CodePanel.this.action.args = editor.getText();
        label.setText(CodePanel.this.action.args.toString());
        CodePanel.this.remove(scroll);
        label.setVisible(true);
        }
        }
        });*/
        //    }
        //});
        //add(label, BorderLayout.CENTER);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension d = new Dimension();
            d.height = 60;
            d.width = getWidth();
            return d;
        }
    }

    @Override
    public String getName() {
        return "Code";
    }
}
