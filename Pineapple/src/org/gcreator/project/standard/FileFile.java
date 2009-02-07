/*
Copyright (C) 2008-2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008-2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.project.standard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.gcreator.pineapple.PineappleCore;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.io.BasicFile;

/**
 * A implementation of {@link BasicFile} for using
 * {@link java.io.File java.io.File}.
 * 
 * @author Serge Humphrey
 */
public class FileFile implements BasicFile {

    protected File file;
    protected Project project;
    protected ProjectElement element;
    
    /**
     * Creates a new {@link FileFile} with a given {@link java.io.File}.
     * 
     * @param file The {@link java.io.File} to use.
     * @param e The {@link ProjectElement} that this file belongs to.
     * @param p The {@link Project} which this file should belong to.
     */
    public FileFile(File file, ProjectElement e, Project p) {
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
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream getOutputStream() throws IOException {
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

        FileFile[] files = new FileFile[ffiles.length];
        int i = 0;
        for (File f : ffiles) {
            files[i++] = new FileFile(f, element, project);
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
        File dest = new File(file.getParentFile(), newName);
        if (!file.renameTo(dest)) {
            throw new IOException("Renaming failed for " + this.file);
        }
        this.file = dest;
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
}
