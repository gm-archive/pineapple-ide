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


package org.gcreator.pineapple.project.io;

import java.io.File;
import java.io.FileNotFoundException;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectFolder;

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
     * Adds a new file to the project from an existing  {@link java.io.File}
     * from the user's filesystem to the project. This copies the contents of
     * the source file to the new file.
     * 
     * @param file The file to copy. This may be a file or a folder.
     * @param folder The {@link ProjectFolder} to copy the new file to,
     * or <tt>null</tt> if you just want to copy the file to the base 
     * of the project.
     * @param newName The new name of the file.
     * 
     * @return A new {@link BasicFile} to represent the newly copied file.
     */
    public BasicFile copyFileToProject(File file, ProjectFolder folder, String newName);
    
    /**
     * Copies a file in the project to a new location.
     * 
     * @param file The existing {@link BasicFile} to copy
     * @param folder The {@link ProjectFolder} to copy the file to, or <tt>null</tt>
     * to copy the file to the project root.
     * @param newName The new name of the file.
     * 
     * @return The new {@link BasicFile} that was created.
     */
    public BasicFile copyFile(BasicFile file, ProjectFolder folder, String newName);

    /**
     * Creates a {@link BasicFile} from the given path
     * like such as that from {@link BasicFile#getPath()}.
     *
     * @param path The relative path to the file.
     * @return A new {@link BasicFile} as located in the given path.
     *
     * @throws java.io.FileNotFoundException If no file
     * was found at the given path.
     */
    public BasicFile getFile(String path) throws FileNotFoundException;
}
