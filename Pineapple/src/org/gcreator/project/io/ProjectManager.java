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


package org.gcreator.project.io;

import java.io.File;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectFolder;

/**
 *
 * This interface provides basic project management,
 * and handles I/O things like loading, saving, and
 * exporting.
 * 
 * @author Serge Humphrey
 */
public interface ProjectManager {
    
    /**
     * Saves the project to a given file.
     * 
     * @param f The {@link java.io.File} to save to.
     * This should be one the strings from {@see #getProjectFileTypes()}.
     * 
     */
    public void save(File f);
    
    /**
     * @return This manager's project.
     */
    public Project getProject();
    
    /**
     * Creates a new file and adds it the the given folder.
     * 
     * @param folder The folder to add the file to. If this is
     * <tt>null</tt>, the file will be added to the base of the project.
     * @param name The name of the file. This should <strong>not</strong>
     * include the extension.
     * @param type The file type.
     * 
     * @return The created file.
     */
    public BasicFile createFile(ProjectFolder folder, String name, String type);
    
    /**
     * Creates a new folder and adds it the the given folder.
     * 
     * @param folder The folder to add the file to. If this is
     * <tt>null</tt>, the file will be added to the base of the project.
     * @param name The name of the folder.
     * 
     * @return The created folder.
     */
    public BasicFile createFolder(ProjectFolder folder, String name);
    
    /**
     * Imports some file (such as a ZIP) to the project.
     * Note that this isn't just called 'import' because
     * that is a Java keyword.
     * 
     * @param f The file to import.
     * 
     * @see #getImportFileTypes() 
     */
    public void importFile(File f);
    
    /**
     * Exports the project to a {@link java.io.File}.
     * 
     * @param f The file to export to.
     * 
     * @see #getExportFileTypes() 
     */
    public void exportFile(File f);
    
    /**
     * Returns the file types that the manager can import.
     * This is similar to {@link #getProjectFileTypes()}, however, importing
     * projects may be done in a different way.
     * 
     * @return An array containing all of the file types that this
     * manager can import.
     */
    public String[] getImportFileTypes();
    
    /**
     * Returns a list of file types that the manager can export projects to.
     * @return An array containing all of the file types that this
     * manager can export.
     */
    public String[] getExportFileTypes();
}
