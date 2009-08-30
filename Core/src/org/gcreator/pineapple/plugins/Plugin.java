/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge@bobtheblueberry.com>

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
package org.gcreator.pineapple.plugins;

import java.io.File;
import org.gcreator.pineapple.managers.SettingsManager;

/**
 * This is the base class that all plugins must extend.
 * 
 * @author Luís Reis
 */
public abstract class Plugin implements EventHandler {

    protected boolean enabled = true;
    protected File jar;
    
    /**
     * Gets the plugin name.
     * Defaults to "untitled"
     * 
     * @return The plugin's name
     */
    public abstract String getName();

    /**
     * Gets the plugin author(s)
     * Defaults to "anonymous"
     * 
     * @return The author of the plug-in.
     */
    public abstract String getAuthor();

    /**
     * Gets the plugin description.
     * 
     * @return This plugin's description.
     */
    public abstract String getDescription();

    /**
     * The initialize() event.
     * <br/><br/>
     * For logic on application's initialization, just handle
     * "application-initialized" events.
     * 
     * @see EventManager
     */
    public void initialize() {
    }
    
    /**
     * Handles an an event.
     * 
     * @param event The event that was received
     */
    @Override
    public void handleEvent(Event event) {
    }
    
    /**
     * @return Wheather this plugin is enabled or not.
     */
    public boolean isEnabled() {
        return this.enabled;
    }
    
    /**
     * Sets wheather the plugin should be loaded or not.
     * The jar file must be set for this to work.
     * 
     * @param b Wheather the plugin is enabled or not.
     */
    public void setEnabled(boolean b) {
        this.enabled = b;
        SettingsManager.set("plugins.enabled." + getJar().getPath(), Boolean.toString(b));
    }
    
    /**
     * Sets the jar file that this plugin belongs to.
     * 
     * @param f The {@link java.io.File} that this plugin 
     * was loaded from.
     */
    public void setJar(File f) {
        this.jar = f;
    }
    
    /**
     * @return The jar file that this plugin was loaded from.
     */
    public File getJar() {
        return this.jar;
    }
}
