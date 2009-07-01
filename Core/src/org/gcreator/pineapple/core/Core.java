/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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

import java.util.Timer;
import java.util.TimerTask;
import org.gcreator.pineapple.gui.MainFrame;
import org.gcreator.pineapple.managers.DefaultUncaughtExceptionHandler;
import org.gcreator.pineapple.managers.SettingsManager;
import org.gcreator.pineapple.plugins.DefaultEventTypes;
import org.gcreator.pineapple.plugins.EventHandler;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.plugins.EventPriority;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.managers.PluginManager;

/**
 * The Core class contains all of the core functions, loading, etc.
 * 
 * @author Serge Humphrey
 */
public final class Core {

    /* 0.97... -> Alpha
     * ...007 -> 6       */
    private static final double version = 0.97007;
    private static final StaticContext staticContext = new StaticContext();
    
    /**
     * Whether to print debuging information.
     */
    public static final boolean DEBUG = false;

    private static Timer timer;

    static {
        timer = new Timer("Core Timer", false);
    }

    /**
     * Don't allow instantation */
    private Core() {
    }

    /**
     * Loads the G-Creator core, modules, and settings.
     * 
     * @see #unload()
     */
    protected static void load() {
        
        /* Logging code for testing releases */
        //try {
        //    java.text.DateFormat d = java.text.DateFormat.getDateInstance();
        //    System.setErr(new java.io.PrintStream(("error-log-" + d.format(java.util.Calendar.getInstance().getTime()) + ".log").replaceAll("/", "-")));
        //    System.setOut(new java.io.PrintStream(("output-log-" + d.format(java.util.Calendar.getInstance().getTime()) + ".log").replaceAll("/", "-")));
        //} catch (java.io.IOException e) {
        //    e.printStackTrace();
        //}
        
        /* End of logging code */

        Thread.setDefaultUncaughtExceptionHandler(new DefaultUncaughtExceptionHandler());

        SettingsManager.load();
        PluginManager.loadPlugins();

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

        EventManager.addEventHandler(new CoreEventHandler(), DefaultEventTypes.HALT);

        EventManager.fireEvent(null, DefaultEventTypes.APPLICATION_INITIALIZED);
    }

    /**
     * Unloads the G-Creator core, modules, and saves the settings.
     * @see #load(boolean)
     */
    protected static void unload() {

        SettingsManager.unload();

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
        //TODO: Redo and make this system a lot better.
        if (args.length == 0) {
        } else if (args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-help") || args[0].equalsIgnoreCase("-h")) {
            System.out.println("G-Creator version " + Core.version());
            System.out.println("Usage: gcreator [options] [file]");
            System.out.println("-h --help          Displays this help message");
            System.out.println("-v --version       Displays the G-Creator version");
            System.out.println("-l --license       Displays the Pineapple Core license");
            System.exit(0);
        } else if (args[0].equalsIgnoreCase("--version") || args[0].equalsIgnoreCase("-version") || args[0].equalsIgnoreCase("-v")) {
            System.out.println("G-Creator version " + Core.version());
            System.out.println("Copyright © 2005-2009 The G-Creator Project");
            System.out.println("http://www.g-creator.org");
            System.exit(0);
        } else if (args[0].equalsIgnoreCase("--license") || args[0].equalsIgnoreCase("-l")) {
            System.out.println(
                    "Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>\n" +
                    "Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>\n" +
                    "\n" +
                    "Permission is hereby granted, free of charge, to any person obtaining a copy\n" +
                    "of this software and associated documentation files (the \"Software\"), to deal\n" +
                    "in the Software without restriction, including without limitation the rights\n" +
                    "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
                    "copies of the Software, and to permit persons to whom the Software is\n" +
                    "furnished to do so, subject to the following conditions:\n" +
                    "\n" +
                    "The above copyright notice and this permission notice shall be included in\n" +
                    "all copies or substantial portions of the Software.\n" +
                    "\n" +
                    "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n" +
                    "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n" +
                    "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n" +
                    "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n" +
                    "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n" +
                    "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\n" +
                    "THE SOFTWARE.");
            System.exit(0);
        }
        load();
    }

    private static class CoreEventHandler extends TimerTask implements EventHandler {

        @Override
        public void handleEvent(Event event) {
            if (event.getEventType().equals(DefaultEventTypes.HALT)) {
                timer.schedule(this, 800);
            }
        }

        @Override
        public void run() {
            System.exit(0);
        }

    }
}
