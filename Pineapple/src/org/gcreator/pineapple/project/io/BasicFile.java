/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey <bob@bobtheblueberry.com>

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

import java.io.IOException;
import org.gcreator.pineapple.gui.PineappleGUI;
import org.gcreator.pineapple.project.ProjectElement;

/**
 * This interface provides a dynamic way to deal with
 * the loading and saving of files, rather than using
 * {@link java.io.File java.io.File}.
 * 
 * @author Serge Humphrey
 */
public interface BasicFile extends Register, Comparable {
    
    /**
     * Gets the file's name.
     * 
     * @return The file's name.
     */
    public String getName();
    
    /**
     * Retrieves an estimate of the length of the file's content,
     * or -1 if the length is unknown.
     * 
     * @return An estimate of the size of the file's data.
     */
    public long getLength();
    
    /**
     * Deletes the file.
     * 
     * @return Wheather the file deletion was successful.
     */
    public boolean delete();
    
    /**
     * @return Wheather the file exists or not.
     */
    public boolean exists();
    
    /**
     * @return <tt>true</tt>, if this file is a directory.
     * Otherwise <tt>false</tt>.
     */
    public boolean isDirectory();
    
    /**
     * Returns an array of BaiscFiles denoting the files in the
     * directory denoted by this abstract pathname.
     *
     * <p> If this abstract pathname does not denote a directory, then this
     * method returns <code>null</code>.  Otherwise an array of
     * <code>File</code> objects is returned, one for each file or directory in
     * the directory.
     *
     * <p> There is no guarantee that the name strings in the resulting array
     * will appear in any specific order; they are not, in particular,
     * guaranteed to appear in alphabetical order.
     *
     * @return  An array of abstract pathnames denoting the files and
     *          directories in the directory denoted by this abstract
     *          pathname.  The array will be empty if the directory is
     *          empty.  Returns <code>null</code> if this abstract pathname
     *          does not denote a directory, or if an I/O error occurs.
     *
     */
    public BasicFile[] list();
    
    /**
     * Renames the file and fires a {@link PineappleGUI#FILE_RENAMED} event.
     * 
     * @param newName The new name for the file
     * @throws java.io.IOException If an errors occurs while renaming the file
     */
    public void rename(String newName) throws IOException;
    
    /**
     * Gets the relative path to the file.
     * If the file is at the base of the project,
     * it should always return '/'.
     * 
     * @return The relative path to the file.
     */
    public String getPath();
    
    /**
     * Returns the time that the file last modified.
     *
     * @return  A <code>long</code> value representing the time the file was
     *          last modified, measured in milliseconds since the epoch
     *          (00:00:00 GMT, January 1, 1970), or <code>0L</code> if the
     *          file does not exist or if an I/O error occurs.
     *
     */
    public long lastModified();
    
    /**
     * @return Whether the file is allowed to be deleted.
     */
    public boolean allowsDelete();
    
    /**
     * Gets the {@link ProjectElement} that this {@link BasicFile} belongs to.
     * @return The {@link ProjectElement} that this {@link BasicFile} belongs to,
     * or <tt>null</tt> if it does not belong to any element.
     */
    public ProjectElement getElement();

    /**
     * Sets the {@link ProjectElement} for this file. You should
     * strictly avoid using this.
     *
     * @param newElement The new {@link ProjectElement} for this file.
     */
    public void setElement(ProjectElement newElement);
}
