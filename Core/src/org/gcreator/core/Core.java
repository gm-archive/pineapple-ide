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
package org.gcreator.core;

import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Calendar;
import org.gcreator.gui.MainFrame;
import org.gcreator.managers.DefaultUncaughtExceptionHandler;
import org.gcreator.managers.SettingsManager;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.EventHandler;
import org.gcreator.managers.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.Event;
import org.gcreator.managers.PluginManager;

/**
 * The Core class contains all of the core functions, loading, etc.
 * 
 * @author Serge Humphrey
 */
public class Core {

    /* 0.97... -> Alpha
     * ...004 -> 4       */
    private static final double version = 0.97004;
    private static boolean safe;
    private static final StaticContext staticContext = new StaticContext();

    /**
     * Don't allow instantation */
    private Core() {
    }

    /**
     * Loads the G-Creator core, modules, and settings.
     * @param safe If <tt>true</tt>, don't load plugins and settings.
     * @see #unload()
     */
    protected static void load(boolean safe) {
        /* Logging code for Alpha testing releases */
        try {
            DateFormat d = DateFormat.getDateInstance();
            System.setErr(new PrintStream(("error-log-" + d.format(Calendar.getInstance().getTime()) + ".log").replaceAll("/", "-")));
            System.setOut(new PrintStream(("output-log-" + d.format(Calendar.getInstance().getTime()) + ".log").replaceAll("/", "-")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* End of logging code */
        
        Core.safe = safe;

        Thread.setDefaultUncaughtExceptionHandler(new DefaultUncaughtExceptionHandler());

        if (!Core.safe) {
            SettingsManager.load();
            PluginManager.loadPlugins();
        }

        /* Initilize the main window */
        EventManager.addEventHandler(new EventHandler() {

            @Override
            public void handleEvent(Event evt) {
                MainFrame frame = new MainFrame();
                staticContext.setMainFrame(frame);
                frame.initialize();
                EventManager.fireEvent(this, DefaultEventTypes.WINDOW_CREATED, frame);
                frame.setVisible(true);
            }
        }, DefaultEventTypes.APPLICATION_INITIALIZED, EventPriority.LOW);

        EventManager.addEventHandler(new EventHandler() {

            @Override
            public void handleEvent(Event evt) {
                SettingsManager.unload();
            }
        }, DefaultEventTypes.WINDOW_DISPOSED, EventPriority.HIGH);

        EventManager.fireEvent(null, DefaultEventTypes.APPLICATION_INITIALIZED);
    }

    /**
     * Unloads the G-Creator core, modules, and saves the settings.
     * @see #load(boolean)
     */
    protected static void unload() {
        if (!Core.safe) {
            SettingsManager.unload();
        }
    }

    /**
     * The G-Creator Core version.
     * 
     * @return The G-Creator core version.
     */
    public static double version() {
        return version;
    }

    /**
     * Returns wheter or not safe mode is on.
     * @return <tt>true</tt> if safe mode is on. Otherwise <tt>false</tt>.
     */
    public boolean isSafeMode() {
        return safe;
    }

    /**
     * Retrieves the Core's StaticContext
     * @return The Core's StaticContext
     */
    public static StaticContext getStaticContext() {
        return staticContext;
    }

    /**
     * Called by the JVM when the application is started.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean safe = false;

        if (args.length == 0) {
            safe = false;
        } else if (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-help") || args[0].equalsIgnoreCase("-h")) {
            System.out.println("G-Creator version " + Core.version());
            System.out.println("Usage: gcreator [options] [file]");
            System.out.println("-h --help          Displays this help message");
            System.out.println("-v --version       Displays the G-Creator version");
            System.out.println("-s --safe          Doesn't load plug-ins and settings (Safe mode)");
            System.exit(0);
        } else if (args[0].equalsIgnoreCase("--version") || args[0].equalsIgnoreCase("-version") || args[0].equalsIgnoreCase("-v")) {
            System.out.println("G-Creator version " + Core.version());
            System.out.println("Copyright © 2005-2008 The G-Creator Project");
            System.out.println("http://www.g-creator.org");
            System.exit(0);
        } else if (args[0].equalsIgnoreCase("--safe") || args[0].equalsIgnoreCase("-s") || args[0].equalsIgnoreCase("-safe")) {
            safe = true;
        } else {
            safe = false;
        }
        load(safe);
    }
}
