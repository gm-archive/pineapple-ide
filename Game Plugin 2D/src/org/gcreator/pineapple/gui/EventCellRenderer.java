/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge_1994@hotmail.com>

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
package org.gcreator.pineapple.gui;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 * Renders an action in a {@link JList}
 * @author Luís Reis
 */
public class EventCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 4882722181342781430L;
    public static ImageIcon CREATE_IMAGE = new ImageIcon(EventCellRenderer.class.getResource("/org/gcreator/pineapple/events/images/create.png"));
    public static ImageIcon DESTROY_IMAGE = new ImageIcon(EventCellRenderer.class.getResource("/org/gcreator/pineapple/events/images/destroy.png"));
    public static ImageIcon DRAW_IMAGE = new ImageIcon(EventCellRenderer.class.getResource("/org/gcreator/pineapple/events/images/draw.png"));
    public static ImageIcon UPDATE_IMAGE = new ImageIcon(EventCellRenderer.class.getResource("/org/gcreator/pineapple/events/images/update.png"));
    public static ImageIcon KEY_IMAGE = new ImageIcon(EventCellRenderer.class.getResource("/org/gcreator/pineapple/events/images/key.png"));

    @Override
    public Component getListCellRendererComponent(JList list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value.toString().equals("Create Event")) {
            this.setIcon(CREATE_IMAGE);
        } else if (value.toString().equals("Destroy Event")) {
            this.setIcon(DESTROY_IMAGE);
        } else if (value.toString().equals("Draw Event")) {
            this.setIcon(DRAW_IMAGE);
        } else if (value.toString().equals("Update Event")) {
            this.setIcon(UPDATE_IMAGE);
        } else if (value.toString().equals("Key Press Event")) {
            this.setIcon(KEY_IMAGE);
        } else if (value.toString().equals("Key Release Event")) {
            this.setIcon(KEY_IMAGE);
        } else {
            this.setIcon(null);
        }

        return this;
    }
}
