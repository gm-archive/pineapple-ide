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
package org.gcreator.pineapple.gui;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Renders a BasicFile instance on a JList
 * @author Luís Reis
 */
public class BasicFileRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 6041354836252183100L;

    @Override
    public Component getListCellRendererComponent(JList list,
            Object value, int index, boolean isSelected, boolean hasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);

        if (value == null) {
            setText("INVALID SCENE");
            return this;
        }

        String path = ((BasicFile) value).getPath();
        int indexofdot = path.lastIndexOf('.');
        int indexofslash = path.lastIndexOf('/');
        String beforeSlash;
        if (indexofslash >= 0) {
            beforeSlash = path.substring(0, indexofslash);
        } else {
            beforeSlash = "";
        }
        String text = "<html><div>" + beforeSlash + "/" + path.substring(indexofslash + 1, indexofdot) + "<font color='gray'>." + path.substring(indexofdot + 1) + "</font></div>";
        this.setText(text);

        return this;
    }
}
