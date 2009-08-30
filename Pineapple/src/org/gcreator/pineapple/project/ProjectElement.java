/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<serge@bobtheblueberry.com>

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
package org.gcreator.pineapple.project;

import javax.swing.Icon;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.tree.BaseTreeNode;

/**
 * A base class for {@link FileElement} and {@link FolderElement}.
 *  
 * @author Serge Humphrey
 */
public abstract class ProjectElement implements Comparable {

    /**
     * This file's parent.
     */
    protected ProjectFolder parent;

    /**
     * Gets the element's file.
     * 
     * @return The File.
     */
    public abstract BasicFile getFile();

    /**
     * Gets the {@link org.gcreator.tree.BaseTreeNode} to be used for the tree.
     * 
     * @return A {@link org.gcreator.tree.BaseTreeNode} to be used for the tree.
     */
    public abstract BaseTreeNode getTreeNode();

    /**
     * This returns the parent or null if it has not been set.
     * 
     * @return This file's parent. This may be <tt>null</tt> and is not exactly reliable.
     * @see setParent(ProjectFolder e)
     */
    public ProjectFolder getParent() {
        return parent;
    }

    /**
     * Called when the parent of this {@link ProjectElement} is changed.
     * 
     * @param arg0: The {@link ProjectElement} that's parent has been changed.
     * @param arg1: The old parent.
     * @param arg2: The new parent.
     * 
     * @see #getParent()
     * @see #setParent(org.gcreator.project.ProjectFolder) 
     */
    public static final String PARENT_CHANGED = "project-element-parent-changed";
    
    /**
     * Sets the parent of this file.
     * 
     * @param e The new parent for this file.
     * 
     * @see getParent()
     */
    public void setParent(ProjectFolder e) {
        ProjectFolder old = this.parent;
        this.parent = e;
        EventManager.fireEvent(this, PARENT_CHANGED, this, old, e);
    }

    /**
     * @return The {@link Project} that this element belongs to.
     */
    public abstract Project getProject();

    /**
     * @return Whether this elemetn can be deleted.
     */
    public boolean allowsDelete() {
        return true;
    }

    /**
     * @return A special icon for the element, or <tt>null</tt>
     * if there isn't any.
     */
    public Icon getIcon() {
        return null;
    }

    /**
     * @return The name of this element.
     */
    public abstract String getName();
}
