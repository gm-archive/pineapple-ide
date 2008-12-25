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
package org.gcreator.gui;

import java.awt.FlowLayout;
import java.lang.ref.WeakReference;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * An event tab renderer. Puts the image on the left of the tab.
 * @author Luís Reis
 */
public class EventTabRenderer extends JPanel {

    private static final long serialVersionUID = 721764836069516400L;
    private WeakReference<JTabbedPane> tabs;

    public EventTabRenderer(JTabbedPane tabs) {
        this.tabs = new WeakReference<JTabbedPane>(tabs);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setOpaque(false);
        IconFace i = new IconFace();
        i.setVisible(true);
        add(i);
        TabFace t = new TabFace();
        t.setVisible(true);
        add(t);
    }

    private class IconFace extends JLabel {

        private static final long serialVersionUID = 2550458438833011687L;

        @Override
        public Icon getIcon() {
            JTabbedPane t = tabs.get();
            String s = t.getTitleAt(t.indexOfTabComponent(EventTabRenderer.this));
            if (s.equals("Create Event")) {
                return EventCellRenderer.CREATE_IMAGE;
            } else if (s.equals("Destroy Event")) {
                return EventCellRenderer.DESTROY_IMAGE;
            } else if (s.equals("Draw Event")) {
                return EventCellRenderer.DRAW_IMAGE;
            } else if (s.equals("Update Event")) {
                return EventCellRenderer.UPDATE_IMAGE;
            }
            return null;
        }
    }

    private class TabFace extends JLabel {

        private static final long serialVersionUID = 2550458438833011687L;

        @Override
        public String getText() {
            try{
                JTabbedPane t = tabs.get();
                return t.getTitleAt(t.indexOfTabComponent(EventTabRenderer.this));
            }
            catch(Exception e){
                return "";
            }
        }
    }
}
