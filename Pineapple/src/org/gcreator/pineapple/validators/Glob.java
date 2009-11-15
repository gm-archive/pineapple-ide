/*
Copyright (C) 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2009 Serge Humphrey<serge@bobtheblueberry.com>

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


package org.gcreator.pineapple.validators;

import java.util.Vector;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFile;
import org.gcreator.pineapple.project.ProjectFolder;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Uses a {@link ResourceValidator} to produce a glob of files.
 * 
 * @author Serge Humphrey
 */
public final class Glob {

    /* Don't allow instantation */
    private Glob() {
    }

    /**
     * Produces a glob of files using the given {@link ResourceValidor}.
     * 
     * @param validator The {@link ResourceValidor} to use.
     * @param rescursive Whether to scan inside directories
     *
     * @return A {@link Vector} of the files in the root folder
     * that match the given {@link ResourceValidator}.
     */
    public static Vector<BasicFile> glob(ResourceValidator validator, boolean rescursive) {
        return glob(validator, null, rescursive);
    }

    /**
     * Produces a glob of files using the given {@link ResourceValidor}.
     * 
     * @param validator The {@link ResourceValidor} to use.
     * @param root The folder to scan. If this is <tt>null</tt>,
     * the root project folder is searched.
     * @param rescursive Whether to scan inside directories
     *
     * @return A {@link Vector} of the files in the given folder
     * that match the given {@link ResourceValidator}.
     */
    public static Vector<BasicFile> glob(ResourceValidator validator, ProjectFolder root, boolean rescursive) {
        Vector<BasicFile> glob = new Vector<BasicFile>();
        Iterable<ProjectElement> children;
        if (root != null) {
            children = root.getChildren();
        } else {
            children = PineappleCore.getProject().getFiles().getChildren();
        }
        synchronized (children) {
            for (ProjectElement e : children) {
                if (e instanceof ProjectFolder) {
                    if (rescursive) {
                        for (BasicFile f : glob(validator, (ProjectFolder) e, true)) {
                            glob.add(f);
                        }
                    }
                } else {
                    if (validator.isValid((ProjectFile)e)) {
                        glob.add(e.getFile());
                    }
                }
            }
            return glob;
        }
    }
}
