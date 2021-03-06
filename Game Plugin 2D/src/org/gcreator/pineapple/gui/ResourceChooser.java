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

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import org.gcreator.pineapple.validators.ResourceValidator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.gcreator.pineapple.validators.UniversalValidator;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFile;
import org.gcreator.pineapple.project.ProjectFolder;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Allows the user to choose a specific resource
 * using a filter.
 * 
 * @author Luís Reis
 */
public class ResourceChooser extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private BasicFile selectedFile = null;
    private Vector<ActionListener> listeners = new Vector<ActionListener>();
    private static int curId = 1;
    private ResourceValidator validator = new UniversalValidator();

    public ResourceChooser() {
        super(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label = new JLabel();
        label.setText("<none>");
        label.setVisible(true);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                if (!isEnabled()) {
                    return;
                }
                JPopupMenu menu = new JPopupMenu();
                JMenuItem none = new JMenuItem("<none>");
                none.setVisible(true);
                none.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        setSelectedFile(null, true);
                    }
                });
                menu.add(none);
                popupMenu(menu, PineappleCore.getProject().getFiles().getChildren());
                menu.show(label, evt.getX(), evt.getY());
            }
        });

        GridBagConstraints c = new  GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.weightx = 100.0;
        c.weighty = 100.0;
        add(label, c);
    }

    public void setResourceValidator(ResourceValidator validator) {
        if (validator == null) {
            throw new NullPointerException("Argument mustn't be null");
        }
        this.validator = validator;
    }

    public ResourceValidator getResourceValidator(ResourceValidator validator) {
        return validator;
    }

    public BasicFile getSelectedFile() {
        return selectedFile;
    }

    /**
     * Sets the selected item (file) in the menu.
     * May be <tt>null</tt>.
     * 
     * @param file The file to select.
     */
    public void setSelectedFile(BasicFile file) {
        setSelectedFile(file, false);
    }

    protected void setSelectedFile(BasicFile file, boolean fireEvent) {
        BasicFile oldFile = selectedFile;
        selectedFile = file;
        if (file == null) {
            label.setText("<none>");
        } else {
            label.setText(file.getName());
        }
        if (fireEvent && oldFile != file) {
            ActionEvent e = new ActionEvent(this, curId++, "change-selected-file");
            for (ActionListener listener : listeners) {
                listener.actionPerformed(e);
            }
        }
    }

    /**
     * Adds an action listener
     * @param listener The action listener to add
     */
    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }

    public boolean popupMenu(JPopupMenu menu, Iterable<ProjectElement> files) {

        boolean isThisEmpty = true;
        for (ProjectElement elem : files) {
            if (elem instanceof ProjectFile) {
                if (validator.isValid((ProjectFile) elem)) {
                    JMenuItem i = new FileMenuItem((ProjectFile) elem);
                    i.setVisible(true);
                    menu.add(i);
                    isThisEmpty = false;
                }
            } else if (elem instanceof ProjectFolder) {
                ProjectFolder f = (ProjectFolder) elem;
                JMenu subMenu = new JMenu(f.getName());
                boolean isEmpty = popupMenu(subMenu, f.getChildren());

                if (!isEmpty) {
                    subMenu.setVisible(true);
                    menu.add(subMenu);
                    isThisEmpty = false;
                }
            }
        }
        return isThisEmpty;
    }

    public boolean popupMenu(JMenu menu, Iterable<ProjectElement> files) {

        boolean isThisEmpty = true;
        for (ProjectElement elem : files) {
            if (elem instanceof ProjectFile) {
                if (validator.isValid((ProjectFile) elem)) {
                    JMenuItem i = new FileMenuItem((ProjectFile) elem);
                    i.setVisible(true);
                    menu.add(i);
                    isThisEmpty = false;
                }
            } else if (elem instanceof ProjectFolder) {
                ProjectFolder f = (ProjectFolder) elem;
                JMenu subMenu = new JMenu(f.getName());
                boolean isEmpty = popupMenu(subMenu, f.getChildren());

                if (!isEmpty) {
                    subMenu.setVisible(true);
                    menu.add(subMenu);
                    isThisEmpty = false;
                }
            }
        }


        return isThisEmpty;
    }

    private class FileMenuItem extends JMenuItem implements ActionListener {

        private static final long serialVersionUID = 8261761643433638835L;
        private ProjectFile elem;

        public FileMenuItem(ProjectFile elem) {
            this.elem = elem;
            addActionListener(this);
            setText(elem.getName());
        }

        public void actionPerformed(ActionEvent evt) {
            setSelectedFile(elem.getFile(), true);
        }
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        label.setEnabled(b);
    }
}
