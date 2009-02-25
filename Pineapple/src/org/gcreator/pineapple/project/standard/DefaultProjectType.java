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


package org.gcreator.pineapple.project.standard;

import java.io.File;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectType;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * The {@link ProjectType} for {@link DefaultProject}.
 * 
 * @author Serge Humphrey
 */
public class DefaultProjectType implements ProjectType {
    
    protected final String FILE_TYPE;
    
    public DefaultProjectType() {
        FILE_TYPE = "pmf";
    }
    
    public DefaultProjectType(String fileType) {
        FILE_TYPE = fileType;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Project create(String name, File folder) {
        return new DefaultProject(name, folder, this, null);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Default";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "This project type uses the file system for storage.";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Project load(File f, File folder) {
        return new DefaultProjectManager(f, folder, this, null).getProject();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getProjectFileTypes() {
        return new String[]{FILE_TYPE};
    }
        
    /**
     * {@inheritDoc}
     */
    @Override
    public BasicFile createBasicFile(File f, Project p) {
        return new FileFile(f, null, p);
    }
}
