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
package org.gcreator.pineapple.gui.base;

import javax.swing.ImageIcon;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.gui.ProjectTreeRenderer;
import org.gcreator.pineapple.gui.formats.ImageSupporter;
import org.gcreator.pineapple.gui.formats.PlainTextSupporter;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.plugins.DefaultEventTypes;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventHandler;
import org.gcreator.pineapple.plugins.Plugin;

/**
 * The Plugin class for Pineapple.
 *
 * @author Luís Reis
 */
public final class GUIPlugin extends Plugin implements EventHandler {

    /**
     * Gives static access to the plugin's name.
     */
    public static final String PLUGIN_NAME = "Apple Pie";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return PLUGIN_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Apple Pie is a basic GUI for Pineapple.";
    }

    /**
     * Initializes the plugin and registers the event handlers.
     */
    @Override
    public void initialize() {
        GUIBase.initialize();
        EventManager.addEventHandler(this, DefaultEventTypes.PLUGINS_LOADED);
        EventManager.addEventHandler(this, GUIBase.REGISTER_FORMATS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthor() {
        return "Serge Humphrey, Luís Reis";
    }

    @Override
    public void handleEvent(Event event) {
        if (event.getEventType().equals(DefaultEventTypes.PLUGINS_LOADED)) {
            try {
                ProjectTreeRenderer.icons.put(".*\\.actor",
                        new ImageIcon(this.getClass().getResource("/org/gcreator/pineapple/resources/tree/actor.png")));
                ProjectTreeRenderer.icons.put(".*\\.scene",
                        new ImageIcon(this.getClass().getResource("/org/gcreator/pineapple/resources/tree/scene.png")));
                ProjectTreeRenderer.icons.put(".*\\.pdl",
                        new ImageIcon(this.getClass().getResource("/org/gcreator/pineapple/resources/tree/script.png")));
                ProjectTreeRenderer.icons.put(".*\\.txt",
                        new ImageIcon(this.getClass().getResource("/org/gcreator/pineapple/resources/tree/text.png")));
                ProjectTreeRenderer.icons.put(".*\\.java",
                        new ImageIcon(this.getClass().getResource("/org/gcreator/pineapple/resources/tree/java.png")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getEventType().equals(GUIBase.REGISTER_FORMATS)) {
            /* Supporters */
            GUIBase.addFormatSupporter(new PlainTextSupporter());
            GUIBase.addFormatSupporter(new ImageSupporter());
        }
    }
}
