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
package org.gcreator.pineapple.tree;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventHandler;
import org.gcreator.pineapple.plugins.EventPriority;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFolder;

/**
 * A {@link javax.swing.tree.TreeNode} implementation 
 * for a {@link org.gcreator.project.ProjectFolder}.
 * 
 * @author Serge Humphrey
 */
public class FolderTreeNode extends DefaultMutableTreeNode implements BaseTreeNode, EventHandler {

    private static final long serialVersionUID = 1;
    private ProjectFolder folder;

    public FolderTreeNode(ProjectFolder e) {
        this.setAllowsChildren(true);
        this.setUserObject(e);
        this.folder = e;
        EventManager.addEventHandler(this, ProjectElement.PARENT_CHANGED, EventPriority.LOW);
    }

    /**
     * Returns <tt>false</tt>.
     * @return <tt>false</tt>.
     */
    @Override
    public boolean isLeaf() {
        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * @return An Enumeration that enumerates the child nodes.
     */
    @Override
    public Enumeration children() {
        return new Enumeration() {

            private int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < folder.getChildrenCount();
            }

            @Override
            public Object nextElement() {
                return folder.getChildAt(index++);
            }
        };
    }

    /**
     * {@inheritDoc}
     * 
     * @param node The node. Should be a {@link BaseTreeNodde}.
     * @return The index of the given node, or -1 if it is not a child
     * of this node.
     */
    @Override
    public int getIndex(TreeNode node) {
        if (node instanceof BaseTreeNode) {
            return folder.indexOf(((BaseTreeNode) node).getElement());
        }
        return -1;
    }

    /**
     * Returns a child at a specific index.
     * 
     * @param childIndex The index the child is at.
     * @return The TreeNode at the given index.
     */
    @Override
    public TreeNode getChildAt(int childIndex) {
        return folder.getChildAt(childIndex).getTreeNode();
    }

    /**
     * Gets the number of children.
     * 
     * @return The number of children.
     */
    @Override
    public int getChildCount() {
        return folder.getChildrenCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectElement getElement() {
        return folder;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(Event event) {
        if (event.getEventType().equalsIgnoreCase(ProjectElement.PARENT_CHANGED)) {
            if (event.getArguments()[0] != folder) {
                return;
            }
            if (folder.getParent() == null) {
                this.setParent(folder.getProject().getTreeNode());
            } else {
                try {
                    this.setParent((MutableTreeNode) folder.getParent().getTreeNode());
                } catch (Exception exc) {
                }
            }
        }
    }
}
