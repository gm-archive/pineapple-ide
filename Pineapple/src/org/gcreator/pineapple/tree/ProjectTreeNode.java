/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <serge@bobtheblueberry.com>

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
import javax.swing.tree.TreeNode;
import org.gcreator.pineapple.project.Project;

/**
 * The tree node for the project.
 * 
 * @author Serge Humphrey
 */
public final class ProjectTreeNode extends DefaultMutableTreeNode implements TreeNode {

    private static final long serialVersionUID = 1;
    private Project project;

    /**
     * Creates a new {@link ProjectTreeNode}.
     * 
     * @param project The project this node belongs to.
     */
    public ProjectTreeNode(Project project) {
        super();
        this.project = project;
        this.setUserObject(project);
    }

    /**
     * Returns a child at a specific index.
     * 
     * @param childIndex The index the child is at.
     * @return The TreeNode at the given index.
     */
    @Override
    public BaseTreeNode getChildAt(int childIndex) {
        return project.getFiles().getChildAt(childIndex).getTreeNode();
    }

    /**
     * Gets the number of children.
     * 
     * @return The number of children.
     */
    @Override
    public int getChildCount() {
        return project.getFiles().getChildrenCount();
    }

    /**
     * Returns <tt>null</tt>.
     * 
     * @return <tt>null</tt>.
     */
    @Override
    public TreeNode getParent() {
        return null;
    }

    /**
     * Returns the index of the given node, or -1 if it is not in the tree.
     *  
     * @param node The node.
     * @return The index of the given node, or -1 if it is not in the tree.
     */
    @Override
    public int getIndex(TreeNode node) {
        return project.getFiles().indexOf(((BaseTreeNode) node).getElement());
    }

    /**
     * Returns <tt>true</tt>.
     * @return <tt>true</tt>
     */
    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    /**
     * Returns <tt>false</tt>.
     * @return <tt>flase</tt>.
     */
    @Override
    public boolean isLeaf() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return An Enumeration for the node's children.
     */
    @Override
    public Enumeration children() {
        return new Enumeration() {

            private int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < project.getFiles().getChildrenCount();
            }

            @Override
            public Object nextElement() {
                return project.getFiles().getChildAt(index++).getTreeNode();
            }
        };
    }

    /**
     * Gets the {@link Project} that this node belongs to.
     * 
     * @return  The {@link Project} that this node belongs to.
     */
    public Project getProject() {
        return project;
    }
    
    /**
     * Gets the name of the project.
     * 
     * @return The name of the project.
     */
    @Override
    public String toString() {
        return project.getName();
    }
}
