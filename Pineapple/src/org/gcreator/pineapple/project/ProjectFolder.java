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
package org.gcreator.pineapple.project;

import java.util.Collections;
import java.util.Vector;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.tree.BaseTreeNode;
import org.gcreator.pineapple.tree.FolderTreeNode;

/**
 * Represents a folder and holds files belonging to the folder.
 * 
 * @author Serge Humphrey
 */
public class ProjectFolder extends ProjectElement {

    protected Vector<ProjectElement> children;
    protected BasicFile folder;
    protected FolderTreeNode treeNode;
    protected Project project;
    protected long modified = -1L;

    /**
     * Creates a new {@link ProjectFolder} and scans for files and adds them to its children.
     * 
     * @param folder The folder that this {@link ProjectFolder} should represent.
     * @param p The {@link Project} that this folder should belong to.
     * 
     * @throws java.lang.IllegalArgumentException If {@link java.io.File#isDirectory() folder.isDirecotry()} returns <tt>false</tt>.
     */
    public ProjectFolder(BasicFile folder, Project p) throws IllegalArgumentException {
        if (!folder.exists()) {
            folder.mkdirs();
        }
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Illegal Folder: " + folder);
        }

        this.folder = folder;
        this.children = new Vector<ProjectElement>(folder.list().length);
        this.project = p;
        this.treeNode = new FolderTreeNode(this);
    }

    /**
     * Reloads all of the files inside the folder.
     */
    @SuppressWarnings("unchecked")
    public void reload() {
        if (folder == null || folder.list() == null) {
            return;
        }
        children.clear();
        for (BasicFile f : folder.list()) {
            ProjectElement e = project.createElement(f);
            e.setParent(this);
            children.add(e);
        }
        Collections.sort(children);
        modified = folder.lastModified();
        EventManager.fireEvent(this, PineappleCore.TREE_CHANGED);
    }

    /**
     * Returns the child at the given index.
     * 
     * @param index The index the child is at.
     * @return The child at hte given index.
     * 
     * @throws java.lang.ArrayIndexOutOfBoundsException If the index if smaller
     * than zero or greater than or equal to the number of children.
     * 
     * @see #getChildrenCount()
     */
    public ProjectElement getChildAt(int index) throws ArrayIndexOutOfBoundsException {
        if (folder.lastModified() != modified) {
            reload();
        }
        if (index >= children.size()) {
            return null;
        }
        return children.get(index);
    }

    /**
     * Return the nmber of children.
     * 
     * @return The number of children this folder has.
     */
    public int getChildrenCount() {
        if (folder.lastModified() != modified) {
            reload();
        }
        return children.size();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public BasicFile getFile() {
        return folder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseTreeNode getTreeNode() {
        return treeNode;
    }

    /**
     * Returns the same as the folder's {@link java.io.File#getName()} method 
     * or the {@link java.lang.String} literal 'null' if the file is <tt>null</tt>.
     * 
     * @return The file's name or 'null'.
     */
    @Override
    public String toString() {
        return ((folder != null) ? folder.getName() : "null");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getProject() {
        return project;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return folder.getName();
    }

    /** 
     * @return An {@link Iterable} for cycling through 
     * the folder's children.
     */
    public Iterable<ProjectElement> getChildren() {
        if (folder.lastModified() != modified) {
            reload();
        }
        return children;
    }

    /**
     * Returns the index of the given element, or -1
     * if it is not a child of this folder.
     * 
     * @param e The {@link ProjectElement} to look for.
     * @return The
     */
    public int indexOf(ProjectElement e) {
        return children.indexOf(e);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(Object o) {
        if (folder == null || !(o instanceof ProjectElement)) {
            return 0;
        }
        return folder.compareTo(((ProjectElement) o).getFile());
    }

    /**
     * Outdates this folder and forces it to reload next time
     * its children are requested.
     */
    public void outdate() {
        this.modified = -1L;
    }
}
