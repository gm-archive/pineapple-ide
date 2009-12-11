/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
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
import org.gcreator.pineapple.project.io.ProjectManager;
import java.util.Hashtable;
import java.util.Map;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectFolder;
import org.gcreator.pineapple.project.ProjectType;
import org.gcreator.pineapple.tree.ProjectTreeNode;

/**
 * The default implementation of {@link Project}.
 * 
 * @author Serge Humphrey
 */
public class DefaultProject extends Project {

    protected Hashtable<String, String> settings;
    protected DefaultProjectManager manager;
    protected ProjectType type;
    protected ProjectTreeNode treeNode;
    protected boolean managing = false;

    /**
     * Creates a new {@link DefaultProject}.
     * 
     * @param name The name of the project. May be <tt>null</tt>.
     * @param folder The folder to use as the project folder. May be <strong>not</strong> <tt>null</tt>.
     * @param type The project type class.
     * @param manager The manager for this project. May be <tt>null</tt>.
     * @param save Whether to save the project manifest first.
     */
    protected DefaultProject(String name, File folder, ProjectType type, DefaultProjectManager manager, boolean save) {
        this.projectFolder = folder;
        File f = new File(folder, "files");
        F_files = f;
        DefaultFile df = new DefaultFile(f, null, this);
        this.files = new ProjectFolder(df, this);
        df.element = this.files;
        this.settings = new ProjectSettings<String, String>();
        this.manager = ((manager != null) ? manager : new DefaultProjectManager(this));
        this.type = type;
        this.treeNode = new ProjectTreeNode(this);
        this.settings.put("name", ((name != null) ? name : "Project"));
        if (save) {
            saveLater();
        }
    }

    /**
     * Creates a new {@link DefaultProject}.
     * 
     * @param name The name of the project. May be <tt>null</tt>.
     * @param folder The folder to use as the project folder. May be <strong>not</strong> <tt>null</tt>.
     * @param type The project type class.
     * @param manager The manager for this project. May be <tt>null</tt>.
     */
    protected DefaultProject(String name, File folder, ProjectType type, DefaultProjectManager manager) {
        this(name, folder, type, manager, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Hashtable<String, String> getSettings() {
        return settings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectManager getManager() {
        return manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectType getProjectType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectTreeNode getTreeNode() {
        return treeNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return settings.get("name");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String s) {
        super.setName(s);
        saveLater();
    }

    private void saveLater() {
        if (managing) {
            return;
        }
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                if (manager != null && !managing) {
                    manager.saveToManifest();
                }
            }
        });
        t.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File getProjectFile() {
        return new File(getProjectFolder().getPath() + File.separator + "project." + getProjectType().getProjectFileTypes()[0]);
    }

    private class ProjectSettings<K, V> extends Hashtable<K, V> {

        private static final long serialVersionUID = 1L;

        /**
         * {@inheritDoc}
         */
        @Override
        public V put(K key, V value) {
            V l = super.put(key, value);
            saveLater();
            return l;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            super.clear();
            saveLater();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V remove(Object key) {
            V l = super.remove(key);
            saveLater();
            return l;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void putAll(Map<? extends K, ? extends V> t) {
            super.putAll(t);
            saveLater();
        }
    }
}
