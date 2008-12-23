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

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.gcreator.gui.validators.UniversalValidator;
import org.gcreator.pineapple.PineappleCore;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFile;
import org.gcreator.project.ProjectFolder;
import org.gcreator.project.io.BasicFile;

/**
 * Allows the user to pick a specific resource
 * @author Luís Reis
 */
public class ResourcePicker extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private BasicFile selectedFile = null;
    private Vector<ActionListener> listeners = new Vector<ActionListener>();
    private static int curId = 1;
    private ResourceValidator validator = new UniversalValidator();

    public ResourcePicker() {
        label = new JLabel();

        label.setText("<none>");
        label.setVisible(true);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                JPopupMenu menu = new JPopupMenu();
                JMenuItem none = new JMenuItem("<none>");
                none.setVisible(true);
                none.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        setSelectedFile(null);
                    }
                });
                menu.add(none);
                popupMenu(menu, PineappleCore.getProject().getFiles());
                menu.show(label, evt.getX(), evt.getY());
            }
        });

        add(label);
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

    public void setSelectedFile(BasicFile file) {
        if (file != selectedFile) {
            ActionEvent e = new ActionEvent(this, curId++, "change-selected-file");
            for (ActionListener listener : listeners) {
                listener.actionPerformed(e);
            }
        }
        if(file==null){
            label.setText("<none>");
        }
        else{
            label.setText(file.getName());
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
                JPopupMenu subMenu = new JPopupMenu(f.getName());
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
            setSelectedFile(elem.getFile());
        }
    }
}
