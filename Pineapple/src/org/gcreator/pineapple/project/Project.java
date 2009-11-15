
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
package org.gcreator.pineapple.project;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    protected ProjectFolder files;
    
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
     * whether the given file is a directory or not.<br/>
     * This also sets the given file's element to the newly crated one.
     * 
     * @param f The {@link java.io.File} which the element must exist.
     * @return An element that represents the given file.
     * 
     */
    public ProjectElement createElement(BasicFile f) {
        if (!f.exists()) {
            System.err.println("Warning: File " + f + " does not exist. Attempting to create it...");
            try {
                f.create();
            } catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ProjectElement e;
        if (f.isDirectory()) {
            e = new ProjectFolder(f, this);
        } else {
            e = new ProjectFile(f, this);
        }
        f.setElement(e);
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
     * Renames a child file which fires a
     * {@link PineappleGUI#FILE_RENAMED} event.
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

    /**
     * The project's resource files (images, scripts, etc.)
     * are stored in a folder within the project's folder.
     *
     * @return A folder with all the project's resource files.
     */
    public ProjectFolder getFiles() {
        return files;
    }
}
