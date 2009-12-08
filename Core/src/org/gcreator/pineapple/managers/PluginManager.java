/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge@bobtheblueberry.com>
 * 
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
package org.gcreator.pineapple.managers;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.plugins.DefaultEventTypes;
import org.gcreator.pineapple.plugins.Plugin;

/**
 * This class handles the importing of plugins, usually at startup.
 * 
 * @author Luís Reis
 */
public final class PluginManager {

    private static Vector<File> modules = new Vector<File>();
    private static URLClassLoader clsloader;

    /** Don't allow instantation
     */
    private PluginManager() {
    }

    /**
     * Loads the plugins.
     * This function should only be called once
     */
    public static void loadPlugins() {
        importAppDataPlugins();
        importAppExePlugins();
        URL[] urls = new URL[modules.size()];
        int i = 0;

        for (File file : modules) {
            try {
                if (Core.DEBUG) {
                    System.out.println("Adding " + file);
                }
                urls[i++] = file.toURI().toURL();
            } catch (Exception e) {
            }

        }
        clsloader = new URLClassLoader(urls);
        if (Core.DEBUG) {
            for (URL l : clsloader.getURLs()) {
                System.out.println("Loaded " + l);
            }
        }
        for (File file : modules) {
            String key = "plugins.enabled." + file.getPath();
            boolean enabled;
            if (!SettingsManager.exists(key)) {
                enabled = true;
            } else {
                enabled = !SettingsManager.get(key).equals(Boolean.FALSE.toString());
            }
            importPlugin(file, clsloader, enabled);
        }
        EventManager.fireEvent(null, DefaultEventTypes.PLUGINS_LOADED);
    }

    /**
     * Imports the Application Data Plug-ins.
     */
    public static void importAppDataPlugins() {
        File f = new File(Core.getStaticContext().getApplicationDataFolder().toString() + "/Plugins/");
        if (!f.exists()) {
            System.out.println("Creating " + f);
            f.mkdir();
        }
        if (!f.isDirectory()) {
            System.out.println(f + " is not a directory");
            return;
        }
        File[] fs = f.listFiles();
        for (File file : fs) {
            if (file.isFile() && file.getName().matches(".*\\.jar")) {
                modules.add(file);
            }
        }
    }

    /**
     * Imports the Application Executable Plug-ins.
     */
    public static void importAppExePlugins() {
        File f = new File(Core.getStaticContext().getApplicationExecutableFolder().toString() + "/Plugins/");
        if (!f.exists()) {
            System.out.println("Creating " + f);
            f.mkdir();
    /*****        return; *///
        }
        if (!f.isDirectory()) {
            System.out.println(f + " is Not a directory");
      ///****      return;*///
        }
        File[] fs = f.listFiles();
        for (File file : fs) {
            if (file.isFile() && file.getName().matches(".*\\.jar")) {
                modules.add(file);
            }
        }
        /*************
         *************
         * **********
         */
                /* TODO: REMOVE this code for release */
        f = new File(Core.getStaticContext().getApplicationExecutableFolder().toString() + "/../Plugins/");
        if (!f.exists()) {
            System.out.println("(Pineapple Developer Version) Creating " + f);
            f.mkdir();
            return;
        }
        if (!f.isDirectory()) {
            System.out.println(f + " is Not a directory (Pineapple Developer Version)");
            return;
        }
        fs = f.listFiles();
        for (File file : fs) {
            if (file.isFile() && file.getName().matches(".*\\.jar")) {
                modules.add(file);
            }
        }
                /* ***************
                 *****************
                 *****************
                 * * * * * * * * *
                 end TODO: REMOVE*/
    }

    /**
     * Imports a plug-in from a {@link File}.
     * 
     * @param f The File to import the plug-in from.
     * @param loader The {@link URLClassLoader} to load the class.
     * @param enabled Wheather the plugin is enabled.
     */
    public static void importPlugin(File f, URLClassLoader loader, boolean enabled) {
        try {
            JarInputStream jaris = new JarInputStream(new FileInputStream(f));
            Manifest m = jaris.getManifest();
            if (m == null) {
                return;
            }
            jaris.close();
            Attributes a = m.getMainAttributes();
            String className = a.getValue("Pineapple-EntryPoint");
            if (className == null) {
                return;
            }
            load(f, className, loader, enabled);
        } catch (Exception e) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
    }

    /**
     * Loads a class from a JAR {@link java.io.File}, and attempts to initilize a given class from the JAR.
     * 
     * @param f The Jar {@link java.io.File}.
     * @param className The {@link java.lang.Class} to load and initilize from the JAR.
     * 
     * @param loader loader The {@link URLClassLoader} to load the class.
     * @param enabled Wheather the plugin should be enabled or not.
     * 
     * @throws java.lang.ClassNotFoundException  If the given class was not found in the JAR.
     * @throws java.lang.InstantiationException If the class failed to initilize
     * @throws java.lang.reflect.InvocationTargetException If an error occurs while initilizing the class.
     */
    @SuppressWarnings("unchecked")
    public static void load(File f, String className, URLClassLoader loader, boolean enabled) throws
            ClassNotFoundException, InstantiationException, InvocationTargetException {

        if (className == null) {
            return;
        }
        try {
            if (Core.DEBUG) {
                System.out.println("Loading Plugin Class " + className + " in " + f.getName());
            }
            Class c = loader.loadClass(className);
            Object o = c.getConstructor().newInstance();
            if (!(o instanceof Plugin)) {
                return;
            }
            Plugin p = (Plugin) o;
            if (Core.DEBUG) {
                System.out.println("Installed Plugin '" + p.getName() + "'");
            }
            p.setJar(f);
            p.setEnabled(enabled);
            Core.getStaticContext().addPlugin(p);
            if (enabled) {
                if (Core.DEBUG) {
                    System.out.println("Initializing '" + p.getName() + "'");
                }
                Method d = c.getMethod("initialize");
                d.invoke(o);
            }
        } catch (IllegalAccessException ex) {
            /* Should not happen */
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            /* Should not happen */
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            /* Should not happen */
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gets the {@link URLClassLoader} that is used to load the plugins.
     * This will be <tt>null</tt> if {@link #loadPlugins()} has not yet been called.
     * 
     * @return The {@link URLClassLoader} that is used to load the plugins.
     */
    public static URLClassLoader getClassLoader() {
        return clsloader;
    }
}
