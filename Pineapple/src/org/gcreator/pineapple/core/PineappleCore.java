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
package org.gcreator.pineapple.core;

import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.managers.SettingsManager;
import org.gcreator.pineapple.plugins.DefaultEventTypes;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventHandler;
import org.gcreator.pineapple.plugins.EventPriority;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectType;

/**
 * Preforms core-related pineapple tasks.
 * 
 * @author Serge Humphrey
 */
public final class PineappleCore {

    public static ProjectType projectType;
    /**
     * The current project
     */
    private static Project project = null;

    public static final String REGISTER_PROJECT_TYPE = "register-projecttype";
    /**
     * Event called when the project is changed.
     *
     * @param arg0 The old project.
     * @param arg1 the new project.
     */
    public static final String PROJECT_CHANGED = "project-changed";
    /**
     * Event called when the project is renamed.
     */
    public static final String PROJECT_RENAMED = "project-renamed";
    /**
     * Event called when the GUI has been intialized.
     */
    public static final String GUI_INITIALIZED = "gui-intialized";
    /**
     * Event called when the project file hierarchy has been changed.
     */
    public static final String TREE_CHANGED = "tree-changed";
    /**
     * Event when a file is deleted from the filesystem.
     */
    public static final String FILE_DELETED = "file-deleted";
    /**
     * Event when a file is removed from the PineappleCore.getProject().
     */
    public static final String FILE_REMOVED = "file-removed";
    /**
     * Event when a file is renamed.<br/>
     * Note: automatically called by {@link BasicFile#rename(java.lang.String)}.
     *
     * @param arg0 The relative old file path.
     * @param arg1 The new file.
     */
    public static final String FILE_RENAMED = "file-renamed";
    
    /**
     * Called when the tree sort mode has been changed.
     * @see  #sortMode
     * @see TreeSortMode
     */
    public static final String TREE_SORT_MODE_CHANGED = "tree-sort-mode-changed";

    public static enum TreeSortMode {

        FILE_NAME, FILE_TYPE,
    };
    private static final String TREE_SORT_MODE_KEY = "pineapple.tree.sort_mode";
    /**
     * The way to sort files in the tree.
     *
     * @see TreeSortMode
     */
    public static TreeSortMode sortMode = TreeSortMode.FILE_NAME;

    /**
     * Initializes Pineapple's core:
     * - Registers event handlers
     */
    public static void intialize() {
        CoreEventHandler c = new CoreEventHandler();
        EventManager.addEventHandler(c, REGISTER_PROJECT_TYPE, EventPriority.MEDIUM);
        EventManager.addEventHandler(c, GUI_INITIALIZED);
        EventManager.addEventHandler(c, DefaultEventTypes.PLUGINS_LOADED);
        EventManager.addEventHandler(c, DefaultEventTypes.APPLICATION_INITIALIZED);
    }

    private static class CoreEventHandler implements EventHandler {

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(Event event) {
            if (event.getEventType().equals(DefaultEventTypes.PLUGINS_LOADED)) {
                EventManager.fireEvent(this, REGISTER_PROJECT_TYPE);
            } else if (event.getEventType().equals(GUI_INITIALIZED)) {
                /* Fire PROJECT_CHANGED events if the project hasn't been set already. */
                if (project == null) {
                    setProject(null);
                }
            } else if (event.getEventType().equals(DefaultEventTypes.APPLICATION_INITIALIZED)) {
                // try to load the tree sort mode
                if (SettingsManager.exists(TREE_SORT_MODE_KEY)) {
                    try {
                        sortMode = TreeSortMode.valueOf(SettingsManager.get(TREE_SORT_MODE_KEY));
                    } catch (Exception exc) {
                    }
                }
            } else if (event.getEventType().equals(TREE_SORT_MODE_CHANGED)) {
                SettingsManager.set(TREE_SORT_MODE_KEY, sortMode.name());
            }
        }
    }

    /*
     * Don't allow instantation */
    private PineappleCore() {
    }

    /**
     * @return The project.
     */
    public static Project getProject() {
        return project;
    }

    /**
     * Sets the project.
     * 
     * @param p The new vale for the project.
     */
    public static void setProject(Project p) {
        Project oldp = project;
        project = p;
        EventManager.fireEvent(null, PROJECT_CHANGED, oldp, p);
    }
}
