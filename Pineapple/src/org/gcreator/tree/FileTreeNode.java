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
package org.gcreator.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import org.gcreator.managers.EventManager;
import org.gcreator.plugins.Event;
import org.gcreator.plugins.EventHandler;
import org.gcreator.plugins.EventPriority;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFile;

/**
 * A {@link javax.swing.tree.TreeNode} implementation 
 * for a {@link org.gcreator.project.ProjectFile}.
 * 
 * @author Serge Humphrey
 */
public class FileTreeNode extends DefaultMutableTreeNode implements BaseTreeNode, EventHandler {

    private static final long serialVersionUID = 1;
    private ProjectFile file;

    /**
     * Creates a new file tree node.
     * 
     * @param e The {@link ProjectFile} that this node belongs to.
     */
    public FileTreeNode(ProjectFile e) {
        this.setAllowsChildren(false);
        this.setUserObject(e);
        this.file = e;
        EventManager.addEventHandler(this, ProjectElement.PARENT_CHANGED, EventPriority.LOW);
    }

    /**
     * Gets the {@link ProjectFile} that this node belongs to.
     * 
     * @return The {@link ProjectFile} that this node belongs to.
     */
    @Override
    public ProjectElement getElement() {
        return file;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(Event event) {
        if (event.getEventType().equalsIgnoreCase(ProjectElement.PARENT_CHANGED)) {
            if (event.getArguments()[0] != file) {
                return;
            }
            if (file.getParent() == null) {
                this.setParent(file.getProject().getTreeNode());
            } else {
                try {
                    this.setParent((MutableTreeNode) file.getParent().getTreeNode());
                } catch (Exception exc) {
                    System.err.println("Exception: " + exc.getLocalizedMessage());
                }
            }
        }
    }
}
