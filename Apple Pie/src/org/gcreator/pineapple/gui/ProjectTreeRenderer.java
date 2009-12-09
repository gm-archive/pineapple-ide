/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge@bobtheblueberry.com>

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

import java.awt.Component;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.gcreator.pineapple.tree.ProjectTreeNode;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.tree.BaseTreeNode;
import org.gcreator.pineapple.tree.FileTreeNode;

/**
 * A FolderProject tree cell renderer
 * 
 * @author Luís Reis
 * @see javax.swing.tree.DefaultTreeCellRenderer
 */
public class ProjectTreeRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = 1;

    /**
     * HashMap for icons in the tree. The Sting must be a regular expression.
     * Will only work if a file does not have it's icon set in the FileTreeNode class.
     */
    public static HashMap<String, Icon> icons = new HashMap<String, Icon>();

    public ProjectTreeRenderer() {
        setOpaque(false);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object val,
            boolean isSelected, boolean isExpanded, boolean isLeaf, int row,
            boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, val, isSelected, isExpanded, isLeaf, row, hasFocus);

        if (val instanceof ProjectTreeNode) {
            try {
                ProjectTreeNode n = (ProjectTreeNode) val;

                Project p = n.getProject();
                String name = p.getSettings().get("name");
                if (name != null) {
                    this.setText(name);
                } else {
                    this.setText("[null]");
                }
            } catch (Exception exc) {
                this.setText(exc.getLocalizedMessage());
            }
        } else if (val instanceof BaseTreeNode) {
            String s = this.getText();
            BaseTreeNode node = (BaseTreeNode) val;
            this.setText(node.getElement().getName());
            ProjectElement el = node.getElement();
            if (el.getIcon() != null) {
                this.setIcon(el.getIcon());
            } else if (val instanceof FileTreeNode) {
                for (String exp : icons.keySet()) {
                    if (s.matches(exp)) {
                        this.setIcon(icons.get(exp));
                    }
                }
            }
            int index = s.lastIndexOf('.');
            if (index != -1 && !isSelected) {
                String name = s.substring(0, index);
                String format = s.substring(index);
                name = name.replaceAll("&", "&amp");
                name = name.replaceAll("<", "&lt;");
                name = name.replaceAll(">", "&gt;");
                format = format.replaceAll("&", "&amp");
                format = format.replaceAll("<", "&lt;");
                format = format.replaceAll(">", "&gt;");
                setText("<html>" + name + "<font color='gray'>" + format);
            }
        }

        return this;
    }
}
