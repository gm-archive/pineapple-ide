/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

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

/**
 * Defines some default event types.
 * Use these to avoid the use of string literals.
 * 
 * @author Serge Humphrey
 */
public final class DefaultEventTypes {
    
    /**
     * Don't allow instantation
     */
    private DefaultEventTypes() {}
    
    /**
     * Used when the event type is not specified
     */
    public static final String UNDEFINED = "undefined";
    
    /**
     * Called when the application(not the main window) is initialized
     */
    public static final String APPLICATION_INITIALIZED = "application-initialized";
    
    /**
     * Called when the main application window is created
     */
    public static final String WINDOW_CREATED = "window-created";
    
    /**
     * Called when the main application window is closed, asking for disposal
     */
    public static final String WINDOW_DISPOSED = "window-disposed";
    
    /**
     * Used to detect every single event
     */
    public static final String ALL = "all";
    
    /**
     * Called when the application plugins are loaded
     */
    public static final String PLUGINS_LOADED = "plugins-loaded";
    
    /**
     * Called when Pineapple is about to terminate.
     */
    public static final String HALT = "halt";
}
