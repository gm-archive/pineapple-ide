/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

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
import java.awt.Dialog.ModalityType;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFolder;

/**
 * A {@link JTree} for selecting a folder.
 * 
 * @author Serge Humphrey
 */
public final class SelectFolderTree extends JTree {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new {@link SelectFolderTree}
     * 
     * @param p The {@link Project} to display folders for.
     */
    public SelectFolderTree(Project p) {
        super(new ProjectTreeNode(p));
        this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }

    /**
     * Gets the selected folder, <tt>null</tt> if there
     * is no folder selected or the user has selected the
     * base project node.
     * 
     * @return The selected folder, or <tt>null</tt> if there
     * is no folder selected or the user has selected the
     * base project node.
     */
    public ProjectFolder getSelectedFolder() {
        if (this.getSelectionModel().isSelectionEmpty()) {
            return null;
        }
        Object o = this.getSelectionModel().getSelectionPath().getLastPathComponent();
        if (o == null || o instanceof ProjectTreeNode) {
            return null;
        }
        if (o instanceof FolderTreeNode)  {
            return ((FolderTreeNode) o).folder;
        }
        return null;
    }
    
    /**
     * Creates a new dialog with a {@link SelectFolderTree}
     * and some buttons so the user can choose a folder.
     * 
     * @param p The project to use for the folders in the tree.
     * @param owner The parent for the dialog.
     * @param title The title for the dialog.
     * 
     * @return The selected folder, or <tt>null</tt> if the user
     * canceled the action or the root project folder was selected.
     */
    public static ProjectFolder showFolderDialog(Project p, Window owner, String title) {
        final JDialog d = new JDialog(owner, title, ModalityType.APPLICATION_MODAL);
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setLayout(new BorderLayout(4, 4));
        final DataStore r = new DataStore();
        final SelectFolderTree tree = new SelectFolderTree(p);
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                if (r.label != null) {
                    r.folder = tree.getSelectedFolder();
                    r.label.setText((r.folder != null) ? r.folder.getFile().getPath() : "/");
                }
            }
        });
        Box vbox = Box.createVerticalBox();
        vbox.add(new JScrollPane(tree));
        r.label = new JLabel("/");
        r.label.setHorizontalAlignment(SwingConstants.LEFT);
        vbox.add(r.label);
        d.add(vbox, BorderLayout.CENTER);
        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                r.folder = tree.getSelectedFolder();
                d.dispose();
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                r.folder = null;
                d.dispose();
            }
        });
        box.add(cancel);
        box.add(Box.createHorizontalStrut(6));
        box.add(ok);
        box.add(Box.createHorizontalStrut(8));
        d.add(box, BorderLayout.SOUTH);
        d.pack();
        d.setVisible(true);
        return r.folder;
    }
    
    private static class DataStore {
        public ProjectFolder folder;
        public JLabel label;
    }
    
    /* Classes */
    private static class FolderTreeNode implements TreeNode {

        private TreeNode parent;
        private ProjectFolder folder;
        private Vector<FolderTreeNode> nodeCache;
        
        public FolderTreeNode(TreeNode parent, ProjectFolder folder) {
            this.parent = parent;
            this.folder = folder;
        }

        public TreeNode getChildAt(int childIndex) {
            if (nodeCache == null) {
                reloadCache();
            }
            return nodeCache.elementAt(childIndex);
        }

        public int getChildCount() {
            reloadCache();
            return nodeCache.size();
        }

        public TreeNode getParent() {
            return parent;
        }

        public int getIndex(TreeNode node) {
            if (nodeCache == null) {
                reloadCache();
            }
            return nodeCache.indexOf(node);
        }

        public boolean getAllowsChildren() {
            return true;
        }

        public boolean isLeaf() {
            return false;
        }

        public Enumeration children() {
            reloadCache();
            return nodeCache.elements();
        }
        
        private void reloadCache() {
            Vector<FolderTreeNode> elements = new Vector<FolderTreeNode>();
            for (ProjectElement e : folder.getChildren()) {
                if (e instanceof ProjectFolder) {
                    elements.add(new FolderTreeNode(parent,(ProjectFolder) e));
                }
            }
            this.nodeCache = elements;
        }
        
        @Override
        public String toString() {
            return folder.getName();
        }
    }

    private static class ProjectTreeNode implements TreeNode {

        private Vector<TreeNode> nodeCache;
        private Project project;
        
        public ProjectTreeNode(Project p) {
            this.project = p;
        }
            
        public TreeNode getChildAt(int childIndex) {
            if (nodeCache == null) {
                reloadCache();
            }
            return nodeCache.elementAt(childIndex);
        }

        public int getChildCount() {
            reloadCache();
            return nodeCache.size();
        }

        public TreeNode getParent() {
            return null;
        }

        public int getIndex(TreeNode node) {
            if (nodeCache == null) {
                reloadCache();
            }
            return nodeCache.indexOf(node);
        }

        public boolean getAllowsChildren() {
            return true;
        }

        public boolean isLeaf() {
            return false;
        }

        public Enumeration children() {
            reloadCache();
            return nodeCache.elements();
        }
        
        private void reloadCache() {
            Vector<TreeNode> elements = new Vector<TreeNode>();
            for (ProjectElement e : project.getFiles()) {
                if (!e.getTreeNode().isLeaf()) {
                    elements.add(new FolderTreeNode(this, (ProjectFolder) e));
                }
            }
            this.nodeCache = elements;
        }
        
        @Override
        public String toString() {
            return project.getName();
        }
    }
}
