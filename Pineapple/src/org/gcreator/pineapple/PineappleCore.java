/*
Copyright (C) 2008-2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008-2009 Serge Humphrey <bob@bobtheblueberry.com>

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
package org.gcreator.pineapple;

import java.util.Hashtable;
import java.util.Vector;
import org.gcreator.gui.PineappleGUI;
import org.gcreator.managers.EventManager;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.Event;
import org.gcreator.plugins.EventHandler;
import org.gcreator.plugins.EventPriority;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectType;
import org.gcreator.project.io.FormatSupporter;
import org.gcreator.project.standard.DefaultProjectType;
import org.gcreator.project.standard.ImageSupporter;
import org.gcreator.project.standard.PlainTextSupporter;

/**
 * Preforms core-related pineapple tasks.
 * 
 * @author Serge Humphrey
 */
public final class PineappleCore {

    /**
     * The {@link PineappleGUI} object.
     */
    private static PineappleGUI gui;
    
    /**
     * The format supporters.
     */
    private static Vector<FormatSupporter> formats;
    
    /**
     * The project types.
     */
    private static Vector<ProjectType> projectTypes;
        
    /**
     * The current project
     */
    private static Project project = null;

    /**
     * The file type names
     */
    public static Hashtable<String, String> fileTypeNames =
            new Hashtable<String, String>();
    
    /**
     * The file type descriptions
     */
    public static Hashtable<String, String> fileTypeDescriptions =
            new Hashtable<String, String>();
    
    static {
        fileTypeNames.put("txt", "Text File");
        fileTypeDescriptions.put("txt", "A plain text file");
    }
    
    /**
     * Event called to add format supporters to
     * the PineapplePlugin's list.
     * 
     * @see #addFormatSupporter(FormatSupporter) 
     */
    public static final String REGISTER_FORMATS = "register-formats";
    
    /**
     * Event called to add project types to
     * the PineapplePlugin's list.
     * 
     * @see #addProjectType(ProjectType) 
     */
    public static final String REGISTER_PROJECT_TYPES = "register-managers";

    /**
     * Event called when the project is changed.
     */
    public static final String PROJECT_CHANGED = "project-changed";
    
    /**
     * Event called when the project is renamed.
     */
    public static final String PROJECT_RENAMED = "project-renamed";
    
    public static void intialize() {
        CoreEventHandler c = new CoreEventHandler();
        EventManager.addEventHandler(c, REGISTER_FORMATS, EventPriority.MEDIUM);
        EventManager.addEventHandler(c, REGISTER_PROJECT_TYPES, EventPriority.MEDIUM);
        EventManager.addEventHandler(c, DefaultEventTypes.PLUGINS_LOADED);
        EventManager.addEventHandler(c, PineappleGUI.PINEAPPLE_GUI_INITIALIZED);
        
        gui = new PineappleGUI();
    }

    /**
     * Adds a {@link FormatSupporter} to the list of available
     * format supporters.
     * 
     * @param s The {@link FormatSupporter} to add.
     */
    public static void addFormatSupporter(FormatSupporter s) {
        formats.add(s);
    }

    /**
     * Adds a {@link ProjectType} to the list of available
     * project types.
     * 
     * @param t The {@link ProjectType} to add.
     */
    public static void addProjectType(ProjectType t) {
        projectTypes.add(t);
    }
    
    /**
     * Removes the given {@link FormatSupporter} from the list of 
     * format supporters.
     * 
     * @param s The {@link FormatSupporter} to remove.
     * @return Whether the list of formats did contain
     * the given supporter.
     */
    public static boolean removeFormatSupporter(FormatSupporter s) {
        return formats.remove(s);
    }

    /**
     * Removes the given {@link ProjectType} to the list of
     * project types.
     * 
     * @param t The {@link ProjectType} to remove.
     * @return Whether the list of formats did contain the
     * given project type.
     */
    public static boolean removeProjectType(ProjectType t) {
        return projectTypes.remove(t);
    }

    /**
     * @return The {@link PineappleGUI} instance.
     */
    public static PineappleGUI getGUI() {
        return gui;
    }

    /**
     * @return A list of the available project types.
     */
    @SuppressWarnings("unchecked")
    public static Vector<ProjectType> getProjectTypes() {
        return (Vector<ProjectType>) projectTypes.clone();
    }

    /**
     * @return A list of the available format supporters.
     */
    @SuppressWarnings("unchecked")
    public static Vector<FormatSupporter> getFormatSupporters() {
        return (Vector<FormatSupporter>) formats.clone();
    }

    private static class CoreEventHandler implements EventHandler {

        /**
         * {@inheritDoc}
         */
        public void handleEvent(Event event) {
            if (event.getEventType().equals(DefaultEventTypes.PLUGINS_LOADED)) {

                formats = new Vector<FormatSupporter>(4);
                EventManager.fireEvent(this, REGISTER_FORMATS);
                projectTypes = new Vector<ProjectType>(2);
                EventManager.fireEvent(this, REGISTER_PROJECT_TYPES);
                
            } else if (event.getEventType().equals(REGISTER_FORMATS)) {

                addFormatSupporter(new PlainTextSupporter());
                addFormatSupporter(new ImageSupporter());

            } else if (event.getEventType().equals(REGISTER_PROJECT_TYPES)) {

                addProjectType(new DefaultProjectType());

            } else if (event.getEventType().equals(REGISTER_PROJECT_TYPES)) {

                PineappleCore.addProjectType(new DefaultProjectType());

            } else if (event.getEventType().equals(PineappleGUI.PINEAPPLE_GUI_INITIALIZED)) {
                setProject(null);// Fire PROJECT_CHANGED events
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
