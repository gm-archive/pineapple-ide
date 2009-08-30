/*
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
package org.gcreator.pineapple.gui.base;

import java.util.Hashtable;
import java.util.Vector;
import org.gcreator.pineapple.gui.PineappleGUI;
import org.gcreator.pineapple.gui.formats.FormatSupporter;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.plugins.DefaultEventTypes;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventHandler;

/**
 * The non-gui base component of the GUI.
 * 
 * @author Serge Humphrey
 */
public final class GUIBase {

    /**
     * The format supporters.
     */
    private static Vector<FormatSupporter> formats;
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
    /** The {@link PineappleGUI} instance. */
    private static PineappleGUI gui;
    /**
     * Event called to add format supporters to
     * the PineapplePlugin's list.
     *
     * @see #addFormatSupporter(FormatSupporter)
     */
    public static final String REGISTER_FORMATS = "register-formats";

    private GUIBase() {
    }

    public static void initialize() {
        gui = new PineappleGUI();
        EventManager.addEventHandler(new GUIEventHandler(), DefaultEventTypes.PLUGINS_LOADED);
    }

    /**
     * @return The {@link PineappleGUI} instance.
     */
    public static PineappleGUI getGUI() {
        return gui;
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
     * @return A list of the available format supporters.
     */
    @SuppressWarnings("unchecked")
    public static Vector<FormatSupporter> getFormatSupporters() {
        return (Vector<FormatSupporter>) formats.clone();
    }

    private static class GUIEventHandler implements EventHandler {

        public void handleEvent(Event event) {

            if (event.getEventType().equals(DefaultEventTypes.PLUGINS_LOADED)) {
                formats = new Vector<FormatSupporter>();
                EventManager.fireEvent(this, REGISTER_FORMATS);
            }
        }
    }
}
