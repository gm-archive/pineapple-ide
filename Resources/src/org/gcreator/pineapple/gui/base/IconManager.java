package org.gcreator.pineapple.gui.base;

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


import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.gcreator.pineapple.managers.PluginManager;

/**
 * Loads icons and stuff.
 *
 * @author Serge Humphrey
 */
public final class IconManager {

    private IconManager() {
    }
    private static HashMap<String, Icon> icons;

    public static void load() {
        icons = new HashMap<String, Icon>();
        try {
            File res = null;
            for (File f : PluginManager.modules) {
                if (f.getName().equals("Resources.jar")) {
                    res = f;
                    break;
                }
            }
            if (res == null) {
                System.err.println("Could not find Resources.jar");
                return;
            }
            ZipFile zip = new ZipFile(res);
            Enumeration<? extends ZipEntry> entries = zip.entries();
            loopdedoop:
            while (entries.hasMoreElements()) {
                ZipEntry e = entries.nextElement();
                if (e.isDirectory()) {
                    continue;
                }
                String s = e.getName();
                for (String ext : ImageIO.getReaderFileSuffixes()) {
                    if (s.endsWith("." + ext.toLowerCase())) {
                        ImageIcon i = new ImageIcon(ImageIO.read(zip.getInputStream(e)));
                        icons.put(s.substring(0, s.indexOf('.')), i);
                        continue loopdedoop;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(IconManager.class.getName()).log(Level.SEVERE, "PISS!", ex);
        }
    }

    public static Icon getIcon(String s) {
        if (s == null || icons == null) {
            return null;
        }
        return icons.get(s);
    }
}
