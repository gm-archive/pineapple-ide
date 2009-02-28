
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
package org.gcreator.pineapple.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.project.io.ProjectManager;
import org.gcreator.pineapple.project.standard.DefaultProject;
import org.gcreator.pineapple.tree.ProjectTreeNode;

/**
 * A basic foundation for projects.
 * 
 * @author Serge Humphrey
 */
public abstract class Project {

    protected File projectFolder;

    /**
     * Adds a file to the project.
     * 
     * @param e The file to add.
     */
    public abstract void add(ProjectElement e);

    /**
     * Removes a file from the project.
     * 
     * @param e The file to remove.
     * @return <tt>true</tt> if the element was in the list.
     */
    public abstract boolean remove(ProjectElement e);

    /**
     * Removes all of the files from the project.
     */
    public abstract void clear();
    
    /**
     * Gets the index of the first occurance of an object
     * in the project. Not that this does not look inside
     * folders inside the project, just the base elements.
     * 
     * @param o The element to find.
     * @return The index of the first occurance of a given
     * object in the project.
     */
    public abstract int indexOf(Object o);
    
    /**
     * Returns the {@link ProjectElement} at index <tt>index</tt>.
     * Same as getFiles().get(index).
     * 
     * @param index The index to fetch.
     * @return Returns the {@link ProjectElement} at index <tt>index</tt>.
     * 
     * @throws java.lang.IndexOutOfBoundsException If <tt>index</tt> was smaller 
     * than zero or greater than or equal to {@link #getFileCount()}.
     */
    public abstract ProjectElement getFileAt(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the number of elements belonging to this project.
     * Same as getFiles().size()
     * 
     * @return The number of elements belonging to this project.
     */
    public abstract int getFileCount();

    /**
     * Gets a {@link java.util.Hashtable} containing various settings for this
     * project.
     * 
     * @return A {@link java.util.Hashtable} containing various settings for this
     * project.
     */
    public abstract Hashtable<String, String> getSettings();

    /**
     * Creates an element, either a {@link ProjectFile} or {@link ProjectFolder}, depending on
     * whether the given file is a directory or not.
     * 
     * @param f The {@link java.io.File} which the element must exist.
     * @return An element that represents the given file.
     * 
     * @throws java.io.FileNotFoundException If the given file does not exist.
     */
    public ProjectElement createElement(BasicFile f) throws FileNotFoundException {
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + f.getPath() + "' does not exist.");
        }
        ProjectElement e;
        if (f.isDirectory()) {
            e = new ProjectFolder(f, this);
        } else {
            e = new ProjectFile(f, this);
        }
        return e;
    }

    /**
     * Gets the manager for this project.
     * @return The {@link ProjectManager} for this project.
     */
    public abstract ProjectManager getManager();

    /**
     * Gets the {@link ProjectType} class for this project.
     * 
     * @return The {@link ProjectType} class for this project.
     */
    public abstract ProjectType getProjectType();

    /**
     * Gets the folder that this project stores all
     * of its junk in. This may return <tt>null</tt> if
     * this has not been set.
     * 
     * @return This projects folder for storing stuff in.
     * 
     * @see #setProjectFolder(java.io.File) 
     */
    public File getProjectFolder() {
        return projectFolder;
    }

    /**
     * Gets the project's file that it stores project information in.
     * This may be something like a project manifest file, or perhaps
     * even an archive.
     * 
     * @return The project file that stores information about
     * the project on the filesystem.
     */
    public abstract File getProjectFile();

    /**
     * Sets the folder that this project can use for
     * storing data in.
     * 
     * @param f The new folder for storing data in.
     * 
     * @see #getProjectFolder() 
     */
    public void setProjectFolder(File f) {
        this.projectFolder = f;
    }

    /**
     * This allows you to set wether the the user
     * can save their project.
     * For example, the user would not need to save
     * their project if it were something like {@link DefaultProject}
     * and it updated the project manifest when something was changed.
     * 
     * @return Whether the user is allowed to save the project.
     */
    public abstract boolean allowsSave();

    /**
     * Renames a child file
     * 
     * @param f The file to rename
     * @param newName The new file name
     * 
     * @throws java.io.IOException If there is an error with
     *  {@link BasicFile#rename(java.lang.String) }
     */
    public void rename(BasicFile f, String newName) throws IOException {
        f.rename(newName);
    }
    
    /**
     * @return The {@link ProjectTreeNode} for the project.
     */
    public abstract ProjectTreeNode getTreeNode();
    
    /**
     * @return An {@link Iterable} for iterating the project's elements.
     */
    public abstract Iterable<ProjectElement> getFiles();
    
    /**
     * @return The name of the project.
     */
    public String getName() {
        return getSettings().get("name");
    }
    
    /**
     * Sets the name of the project.
     * 
     * @param s The new name for the project.
     */
    public void setName(String s) {
        String old = getSettings().get("name");
        getSettings().put("name", s);
        EventManager.fireEvent(this, PineappleCore.PROJECT_RENAMED, old, s);
    }
}
