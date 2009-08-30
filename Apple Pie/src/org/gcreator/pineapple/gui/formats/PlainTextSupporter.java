/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <serge@bobtheblueberry.com>

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


package org.gcreator.pineapple.gui.formats;

import org.gcreator.pineapple.gui.editors.*;
import javax.imageio.ImageIO;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.gui.base.GUIBase;
import org.gcreator.pineapple.plugins.EventHandler;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * This class adds support for plain text documents in Pineapple.
 * 
 * @author Serge Humphrey
 */
public class PlainTextSupporter implements FormatSupporter, EventHandler {
    
    /**
     * {@inheritDoc}
     */
    public DocumentPane load(BasicFile f) {
        return new TextEditor(f);
    }
    
    /**
     * {@inheritDoc}
     */
    public void handleEvent(Event event) {
        if (event.getEventType().equals(GUIBase.REGISTER_FORMATS)) {
            GUIBase.addFormatSupporter(this);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName() {
        return "Plain Text Editor";
    }
    
    /**
     * {@inheritDoc}
     */
    public String getDescription(String type) {
        return "Supports simple plain-text documents";
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean accept(String format) {
        /* Don't load images */
        for (String s : ImageIO.getReaderFileSuffixes()) {
            if (s.equalsIgnoreCase(format)) {
                return false;
            }
        }
        return true;
    }
}
