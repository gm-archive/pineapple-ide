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

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.plugins.Plugin;

/**
 * Allows the user to uninstall plugins
 * In the future, plugin installation and updating would also
 * be nice
 * 
 * @author Luís Reis
 */
public final class PluginDialog extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    public static String PLUGINDIALOG_OPEN = "plugindialog-open";
    private JSplitPane splitPane;
    private JScrollPane scrollPane;
    private JEditorPane editorPane;
    private JTable table;

    public PluginDialog(Frame f) {
        super(f);
        Box center = Box.createVerticalBox();

        this.setTitle("Plugins");
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setSize(320, 240);

        table = new JTable(new PluginTableModel());
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getFirstIndex() < 0) {
                    return;
                }
                Plugin p = Core.getStaticContext().getPlugins().get(table.getSelectedRow());
                if (p != null) {
                    editorPane.setText(p.getDescription());
                }
            }
        });

        editorPane = new JEditorPane("text/html", null);
        editorPane.setEditable(false);
        editorPane.setVisible(true);

        scrollPane = new JScrollPane(editorPane);
        scrollPane.setVisible(true);

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(table), scrollPane);
        splitPane.setVisible(true);
        splitPane.setDividerLocation(80);

        center.add(splitPane);

        JButton close = new JButton("Close");
        close.addActionListener(this);
        JLabel notice = new JLabel("<html><em>Restart Pineapple for changes to take effect.</em></html>");
        center.add(notice);
        Box box1 = Box.createHorizontalBox();
        box1.add(Box.createHorizontalGlue());
        box1.add(close);

        this.add(center, "Center");
        this.add(box1, "South");

        EventManager.fireEvent(this, PLUGINDIALOG_OPEN, this);
    }

    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
