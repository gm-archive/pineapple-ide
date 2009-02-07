/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008-2009 Serge Humphrey<bob@bobtheblueberry.com>

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

import org.gcreator.plugins.Plugin;

/**
 * The Plugin class for Pineapple.
 * 
 * @author Luís Reis
 */
public final class PineapplePlugin extends Plugin {

    /**
     * Gives static access to the plugin's name.
     */
    public static final String PLUGIN_NAME = "Pineapple Default Plug-In";

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
        return "Provides essential Pineapple interface behaviors " +
                "including menus, docking and file handling.";
    }

    /**
     * Initializes the plugin and registers the event handlers.
     */
    @Override
    public void initialize() {
        try {
            PineappleCore.intialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getAuthor() {
        return "Serge Humphrey, Luís Reis";
    }
}