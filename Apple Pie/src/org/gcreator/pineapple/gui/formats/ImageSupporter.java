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

import javax.imageio.ImageIO;
import org.gcreator.pineapple.gui.editors.ImagePreviewer;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.managers.SettingsManager;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Allows you to load images in Pineapple
 * using {@link javax.imageio.ImageIO}.
 * 
 * @author Serge Humphrey
 */
public class ImageSupporter implements FormatSupporter {

    public ImageSupporter() {
        String base = "files.formats.formatsupporter.remember.";
        for (String s : ImageIO.getReaderFileSuffixes()) {
            String k = base + s;
            if (!SettingsManager.exists(k)) {
                SettingsManager.set(k, this.getClass().getCanonicalName());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentPane load(BasicFile f) {
        return new ImagePreviewer(f);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Java ImageIO Image Loader";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription(String type) {
        String s = "Displays an image.";
        return s;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean accept(String format) {
        /* Don't load images */
        for (String s : ImageIO.getReaderFileSuffixes()) {
            if (s.equalsIgnoreCase(format)) {
                return true;
            }
        }
        return false;
    }

}
