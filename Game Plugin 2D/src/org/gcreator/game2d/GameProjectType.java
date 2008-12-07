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


package org.gcreator.game2d;

import java.io.File;
import org.gcreator.project.io.BasicFile;
import org.gcreator.project.standard.DefaultProject;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectType;
import org.gcreator.project.standard.DefaultProjectManager;
import org.gcreator.project.standard.DefaultProjectType;
import org.gcreator.project.standard.FileFile;

/**
 * The {@link ProjectType} for {@link DefaultProject}.
 * 
 * @author Serge Humphrey
 */
public final class GameProjectType implements ProjectType {
    
    /**
     * {@inheritDoc}
     */
    public Project create(String name, File folder) {
        return new GameProject(name, folder, null, null);
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName() {
        return "Game2D";
    }
    
    /**
     * {@inheritDoc}
     */
    public String getDescription() {
        return "Based on the default project, this project " +
                "allows you to create very nice 2D games";
    }
    
    /**
     * {@inheritDoc}
     */
    public Project load(File f, File folder) {
        return new DefaultProjectManager(f, folder, new DefaultProjectType(),
                new GameProject(null, folder, this, null, false)).getProject();
    }
    
    /**
     * {@inheritDoc}
     */
    public String[] getProjectFileTypes() {
        return DefaultProjectManager.getProjectFileTypes();
    }
    
    /**
     * {@inheritDoc}
     */
    public BasicFile createBasicFile(File f) {
        return new FileFile(f);
    }
}
