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
package org.gcreator.pineapple.project.standard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * A implementation of {@link BasicFile} for using
 * {@link java.io.File java.io.File}.
 * 
 * @author Serge Humphrey
 */
public class DefaultFile implements BasicFile {

    protected File file;
    protected Project project;
    protected ProjectElement element;
    
    /**
     * Creates a new {@link DefaultFile} with a given {@link java.io.File}.
     * 
     * @param file The {@link java.io.File} to use.
     * @param e The {@link ProjectElement} that this file belongs to.
     * @param p The {@link Project} which this file should belong to.
     */
    public DefaultFile(File file, ProjectElement e, Project p) {
        this.file = file;
        this.project = p;
        this.element = e;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return file.getName();
    }

    /**
     * {@inheritDoc}
     * 
     * <br/><br/>
     * 
     * <strong>Note:</strong><br/>
     * This may return 0L on some filesystems.
     * 
     * @see java.io.File#length() 
     */
    @Override
    public long getLength() {
        return file.length();
    }

    /**
     * {@inheritDoc }
     * @see java.io.File#delete() 
     */
    @Override
    public boolean delete() {
        return recursiveDelete(file);
    }

    private boolean recursiveDelete(File f) {
        if (!f.exists()) {
            return false;
        }
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                recursiveDelete(sub);
            }
        }
        
        return f.delete();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream getReader() throws IOException {
        return new FileInputStream(file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream getWriter() throws IOException {
        return new FileOutputStream(file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDirectory() {
        return file.isDirectory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BasicFile[] list() {
        File[] ffiles = file.listFiles();
        if (ffiles == null) {
            return null;
        }

        DefaultFile[] files = new DefaultFile[ffiles.length];
        int i = 0;
        for (File f : ffiles) {
            files[i++] = new DefaultFile(f, element, project);
        }
        return files;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exists() {
        return file.exists();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rename(String newName) throws IOException {
        String oldPath = getPath();
        File dest = new File(file.getParentFile(), newName);
        if (dest.exists()) {
            throw new IOException("File "+dest.getName()+" already exists.");
        }
        if (!file.renameTo(dest)) {
            throw new IOException("Renaming failed for " + this.file+"\n Cannot rename to "+newName);
        }
        this.file = dest;
        EventManager.fireEvent(this, PineappleCore.FILE_RENAMED, oldPath, this);
        if (PineappleCore.getProject() != null && PineappleCore.getProject().getManager() instanceof DefaultProjectManager) {
            ((DefaultProjectManager) PineappleCore.getProject().getManager()).saveToManifest();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPath() {
        return file.getPath().replaceAll("\\" + File.separator, "/").
                substring(project.getProjectFolder().getPath().length());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long lastModified() {
        return file.lastModified();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean allowsDelete() {
        return file.canWrite();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectElement getElement() {
        return element;
    }
        
    /**
     * {@inheritDoc}
     */
    @Override
    public void setElement(ProjectElement newElement) {
        this.element = newElement;
    }

    /**
     * Gets the string value of this file.
     *
     * @return {@link #getPath()}
     */
    @Override
    public String toString() {
        return getPath();
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 0;
        }
        if (o == this) {
            return 0;
        }
        if (o instanceof BasicFile) {
            BasicFile f = (BasicFile)o;
            // Directories go first
            if (this.isDirectory() == f.isDirectory()) {
                /* Different sort modes */
                if (PineappleCore.sortMode == PineappleCore.TreeSortMode.FILE_TYPE) {
                    // Find file extension
                    int tindex = this.getName().lastIndexOf('.');
                    int findex = f.getName().lastIndexOf('.');
                    if (tindex < 0 && findex >= 0) {
                        /* Since we have no extension and the other
                         * file does, we'll put this file above the other one.
                         */
                        return -1;
                    } else if (tindex >= 0 && findex < 0) {
                        /* Since we have an extension, adn the other
                         * file does not, we will put this file below
                         * the other one.
                         */
                        return 1;
                    } else if (tindex < 0 && findex < 0) {
                        /* Since no files have an extension,
                         * we will just sort them aphabetically.
                         */
                        return getName().compareTo(f.getName());
                    }
                    /* We now know that both files have an extension. */
                    String text = this.getName().substring(tindex);
                    String fext = f.getName().substring(findex);
                    if (text.equalsIgnoreCase(fext)) {
                        /* Both files are of the same type.
                             Sort alphabetically.
                         */
                        String tsname = this.getName().substring(0, tindex);
                        String fsname = f.getName().substring(0, findex);
                        return tsname.compareTo(fsname);
                    } else {
                        /* Files are not the same type.
                         * Sort by type alphabetically.
                         */
                        return text.compareTo(fext);
                    }
                } else {
                    // Must be TreeSortMode.FILE_NAME
                    return getName().compareTo(f.getName());
                }
            } else if (this.isDirectory()) {
                return -1; // Directories >> above files
            } else {
                return 1; // Files >> below directories
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof DefaultFile)) {
            return false;
        }
        DefaultFile f = (DefaultFile)o;
        return (f.project == this.project && f.getPath().equals(this.getPath()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean create() throws IOException {
        return file.createNewFile();
    }
}
