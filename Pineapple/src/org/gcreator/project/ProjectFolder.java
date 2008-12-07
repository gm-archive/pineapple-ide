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


package org.gcreator.project;

import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gcreator.project.io.BasicFile;
import org.gcreator.tree.BaseTreeNode;
import org.gcreator.tree.FolderTreeNode;

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
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Illegal Folder: " + folder);
        }
        
        this.folder = folder;
        this.children = new Vector<ProjectElement>(folder.list().length);
        this.treeNode = new FolderTreeNode(this);
        this.project = p;
    }
    
    /**
     * Reloads all of the files inside the folder.
     */
    public void reload() {
        children.clear();
        for (BasicFile f : folder.list()) {
            try {
                ProjectElement e = project.createElement(f);
                e.setParent(this);
                children.add(e);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProjectFolder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        modified = folder.lastModified();
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
}
