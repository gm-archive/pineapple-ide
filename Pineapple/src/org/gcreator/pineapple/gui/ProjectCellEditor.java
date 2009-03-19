/*
Copyright (C) 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pineapple.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.tree.FileTreeNode;

/**
 * Editor for project tree cells.
 * 
 * @author Serge Humphrey
 */
public class ProjectCellEditor extends DefaultCellEditor {

    private static final long serialVersionUID = 242653645;
    protected DefaultTreeCellRenderer renderer;
    protected DefaultTreeCellEditor editor;

    public ProjectCellEditor(DefaultTreeCellRenderer renderer, DefaultTreeCellEditor editor) {
        super(new ProjectTextField(UIManager.getBorder("Tree.editorBorder")));
        this.renderer = renderer;
        this.editor = editor;
        ProjectTextField field = (ProjectTextField) getComponent();
        field.pce = this;
        this.delegate = new ProjectEditorDelegate();
    }

    protected class ProjectEditorDelegate extends EditorDelegate {

        private static final long serialVersionUID = -428992788;

        @Override
        public void setValue(Object value) {
            JTextComponent c = (JTextComponent) getComponent();
            c.setText((value == null) ? null : value.toString());
            super.setValue(value);
        }

        @Override
        public boolean stopCellEditing() {
            String newn = getCellEditorValue().toString();
            if (newn == null || newn == "") {
                 fireEditingCanceled();
                 return false;
            }
            Object o = PineappleGUI.tree.getSelectionPath().getLastPathComponent();
            // Check for file name extension change.
            if (o instanceof FileTreeNode) {
                FileTreeNode n = (FileTreeNode) o;
                ProjectElement e = n.getElement();
                String old = e.getName();
                int iOld = old.lastIndexOf('.');
                if (iOld >= 0) {
                    String oldExt = old.substring(iOld);
                    int iNew = newn.lastIndexOf('.');
                    if (iOld >= 0 && iNew < 0) {
                        JOptionPane p = new JOptionPane("<html>Do you really want to remove this file's extension?<br/>" +
                                "If you do, it may become unusable.</html>", JOptionPane.QUESTION_MESSAGE);
                        p.setOptions(new Object[]{
                                    "Cancel",
                                    "I meant " + newn + oldExt,
                                    "I don't want an extension",});
                        JDialog d = p.createDialog(Core.getStaticContext().getMainFrame(), "Rename file?");
                        d.setLocationRelativeTo(Core.getStaticContext().getMainFrame());
                        d.setVisible(true);
                        if (p.getValue() == p.getOptions()[0]) {
                            fireEditingCanceled();
                            return false;
                        } else if (p.getValue() == p.getOptions()[1]) {
                            setValue(newn + oldExt);
                            return super.stopCellEditing();
                        } else if (p.getValue() == p.getOptions()[2]) {
                            super.setValue(newn);
                            return super.stopCellEditing();
                        }
                    } else {
                        String newExt = newn.substring(iNew);
                        String newnsx = newn.substring(0, iNew);
                        if (!oldExt.equalsIgnoreCase(newExt)) {
                            JOptionPane p = new JOptionPane(
                                    "<html>Are you sure you want to change this file's extension?<br/>" +
                                    "If you do, it may become unusable.</html>", JOptionPane.QUESTION_MESSAGE);
                            p.setOptions(new Object[]{
                                        "Cancel",
                                        "Use new extension",
                                        "Use old extension",});
                            JDialog d = p.createDialog(Core.getStaticContext().getMainFrame(), "Rename file?");
                            d.setLocationRelativeTo(Core.getStaticContext().getMainFrame());
                            d.setVisible(true);
                            if (p.getValue() == p.getOptions()[0]) {
                                fireEditingCanceled();
                                return false;
                            } else if (p.getValue() == p.getOptions()[1]) {
                                setValue(newnsx + newExt);
                                return super.stopCellEditing();
                            } else if (p.getValue() == p.getOptions()[2]) {
                                super.setValue(newnsx + oldExt);
                                return super.stopCellEditing();
                            }
                        }
                    }
                }
            }
            if (JOptionPane.showConfirmDialog(null, "Do you want to rename this file to " +
                    getCellEditorValue() + "?") == JOptionPane.OK_OPTION) {
                return super.stopCellEditing();
            }
            fireEditingCanceled();
            return false;
        }

        @Override
        public Object getCellEditorValue() {
            return ((JTextComponent) getComponent()).getText();
        }
    }

    protected static class ProjectTextField extends JTextField implements ActionListener {

        private static final long serialVersionUID = 989435436;
        protected Border border;
        protected ProjectCellEditor pce;

        public ProjectTextField(Border border) {
            setBorder(border);
            this.addActionListener(this);
        }

        @Override
        public Font getFont() {
            Font font = super.getFont();
            // Prefer the parent containers font if our font is a
            // FontUIResource
            if (font instanceof FontUIResource) {
                Container parent = getParent();

                if (parent != null && parent.getFont() != null) {
                    font = parent.getFont();
                }
            }
            return font;
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            // If not font has been set, prefer the renderers height.
            if (pce.renderer != null && pce.editor.getFont() == null) {
                Dimension rSize = pce.renderer.getPreferredSize();

                size.height = rSize.height;
            }
            return size;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pce.getComponent() != null) {
                pce.delegate.setValue(this.getText());
            }
        }
    }
}
