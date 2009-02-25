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
package org.gcreator.pineapple.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ref.WeakReference;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * Provides a way for {@link TabbedInterfaceProvider} to have close buttons
 * on tabs
 * 
 * @author Luís Reis
 */
public class TabRenderer extends JPanel {
    
    private static final long serialVersionUID = 1;

    private volatile WeakReference<TabbedInterfaceProvider> tabs;

    /**
     * Creates a new TabRenderer.
     * 
     * @param tabs The TabbedInterfaceProvider.
     */
    public TabRenderer(TabbedInterfaceProvider tabs) {
        this.tabs = new WeakReference<TabbedInterfaceProvider>(tabs);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setOpaque(false);
        JLabel label = new JLabel() {

            private static final long serialVersionUID = 1;
            
            @Override
            public String getText() {
                try {
                    TabbedInterfaceProvider pane = TabRenderer.this.tabs.get();
                    return pane.getDocumentAt(pane.indexOfTabComponent(TabRenderer.this)).getTitle();
                } catch (Exception e) {
                    return null;
                }
            }
        };
        label.setVisible(true);
        add(label);
        final JButton b = new JButton() {

            private static final long serialVersionUID = 1;
            
            /* Old Aurora Code */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                if (getModel().isPressed()) {
                    g2.translate(1, 1);
                }
                if (getModel().isRollover()) {
                    setBorder(BorderFactory.createEtchedBorder());
                } else {
                    setBorder(null);
                }
                g2.setStroke(new BasicStroke(2));
                g2.setColor(Color.BLACK);
                int delta = 6;
                g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
                g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);

                g2.dispose();
            }
        };
        b.setPreferredSize(new Dimension(17, 17));
        /* Make the button looks the same for all L&F's */
        b.setUI(new BasicButtonUI());
        b.setContentAreaFilled(false);
        b.setFocusable(false);
        b.setRolloverEnabled(true);
        b.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent evt) {
                b.repaint();
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                b.repaint();
            }
        });
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                TabbedInterfaceProvider pane = TabRenderer.this.tabs.get();
                DocumentPane doc = pane.getDocumentAt(pane.indexOfTabComponent(
                        TabRenderer.this));
                doc.dispose();
            }
        });
        this.add(b);
    }
}
