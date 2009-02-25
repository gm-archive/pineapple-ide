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
package org.gcreator.pineapple.editors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.gui.PineappleGUI;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Previews an image using ImageIO.
 * 
 * @author Luís Reis
 */
public final class ImagePreviewer extends DocumentPane {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private ImageIcon image;

    /**
     * Creates an ImagePreviewer from a File
     * @param file The image file
     */
    public ImagePreviewer(BasicFile file) {
        super(file);
        try {
            BufferedInputStream s = new BufferedInputStream(file.getInputStream());
            BufferedImage img = ImageIO.read(s);
            s.close();
            if (img == null) {
                PineappleGUI.dip.remove(this);
                return;
            }
            image = new ImageIcon(img);
        } catch (Exception e) {
            System.out.println("Exception while reading image " + file.getPath() + ": " + e);
        }
        this.setLayout(new BorderLayout());
        label = new JLabel(image);
        this.add(new JScrollPane(label), BorderLayout.CENTER);
    }

    /**
     * Gets the display image.
     * 
     * @return The {@link java.awt.ImageIcon} that stores the diaply image data.
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canSave() {
        return false;
    }
}
