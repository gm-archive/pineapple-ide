/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
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
package org.gcreator.pineapple.editors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
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
    private BufferedImage image;

    /**
     * Creates an ImagePreviewer from a {@link File}.
     *
     * @param file The image file
     */
    public ImagePreviewer(BasicFile file) {
        super(file);
        this.setLayout(new BorderLayout());
        try {
            BufferedInputStream s = new BufferedInputStream(file.getReader());
            image = ImageIO.read(s);
            s.close();
            if (image == null) {
                PineappleGUI.dip.remove(this);
                return;
            }
        } catch (Exception e) {
            System.err.println("Exception while reading image " + file.getPath() + " : " + e);
        }
        JScrollPane p = new JScrollPane(new ImageComponent());
        this.add(p);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canSave() {
        return false;
    }

    private class ImageComponent extends JComponent {

        private static final long serialVersionUID = 244363643;

        public ImageComponent() {
            Dimension d = new Dimension(image.getWidth(), image.getHeight());
            setPreferredSize(d);
        }

        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }
}
