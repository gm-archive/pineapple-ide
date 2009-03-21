/*
Copyright (C) 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.game2d.GamePlugin;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFile;
import org.gcreator.pineapple.project.ProjectFolder;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.validators.Glob;
import org.gcreator.pineapple.validators.UniversalValidator;

/**
 * Panel that checks resource names.
 * 
 * @author Serge Humphrey
 */
public final class CheckResourceNamesPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 328345656;
    private Vector<ProjectElement> results = new Vector<ProjectElement>();
    private HashMap<ProjectElement, Integer> errorCodes = new HashMap<ProjectElement, Integer>();
    private static final Integer FILENAME_INVALID = new Integer(0);
    private static final Integer FILENAME_DUPLICATE = new Integer(1);
    private static final String congrats = "Congrats! All resource names are valid";

    /** Creates new form CheckResourceNamesPanel */
    public CheckResourceNamesPanel() {
        initComponents();
        search();
    }

    public void search() {
        statusmsg.setText("Checking...");
        results.clear();
        errorCodes.clear();
        boolean invalid_filenames = false;
        for (BasicFile f : Glob.glob(new UniversalValidator(), true)) {
            // Check invalid filenames
            if (!f.getName().matches(GamePlugin.FNAME_REGEX)) {
                results.add(f.getElement().getFile().getElement());
                errorCodes.put(f.getElement(), FILENAME_INVALID);
                invalid_filenames = true;
            } // check duplicate filenames
            else if (!GamePlugin.checkDuplicate(f)) {
                results.add(f.getElement().getFile().getElement());
                errorCodes.put(f.getElement(), FILENAME_DUPLICATE);
            }
        }
        if (results.size() == 0) {
            statusmsg.setText(congrats);
        } else {
            statusmsg.setText(results.size() + " invalid filenames found.");
        }
        resList.setSelectedIndex(-1);
        resList.updateUI();
        fixAllButton.setEnabled(results.size() > 0 && invalid_filenames);
    }

    private class ResourceListModel extends AbstractListModel {

        private static final long serialVersionUID = 5L;

        @Override
        public int getSize() {
            return results.size();
        }

        @Override
        public Object getElementAt(int index) {
            return results.get(index);
        }
    }

    private void rename() {
        ProjectElement e;
        try {
            e = (ProjectElement) resList.getSelectedValue();
        } catch (Exception exc) {
            e = null;
        }
        if (e == null) {
            return;
        }
        String recName = getRecommenededName(e.getName());
        String s = JOptionPane.showInputDialog(
                Core.getStaticContext().getMainFrame(),
                "New name for " + e.getName() + ":",
                recName);
        if (s != null && s != "") {
            try {
                PineappleCore.getProject().rename(e.getFile(), s);

                if (s.matches(GamePlugin.FNAME_REGEX)) {
                    results.remove(e);
                }
                resList.updateUI();
            } catch (Exception ex) {
            }
        }
    }

    private String getRecommenededName(String name) {
        int dot = name.lastIndexOf('.');
        String recName = name.replaceAll("\\W", "_");
        if (dot > 0) {
            recName = recName.substring(0, dot) + "." +
                    ((dot + 1 < recName.length()) ? recName.substring(dot + 1) : "");
        }
        if (!recName.matches(GamePlugin.FNAME_REGEX)) {
            recName = "_" + recName;
        }
        return recName;
    }

    private class FileNameListCellRenderer extends DefaultListCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof ProjectElement) {
                ProjectElement e = (ProjectElement) value;
                Integer code = errorCodes.get(value);
                String s = "??? ";
                if (code == FILENAME_INVALID) {
                    s = "Invalid filename: ";
                } else if (code == FILENAME_DUPLICATE) {
                    s = "Duplicate filename: ";
                }
                s += e.getFile().getPath();
                this.setText(s);
                if (e.getIcon() != null) {
                    this.setIcon(e.getIcon());
                } else {
                    if (value instanceof ProjectFile) {
                        this.setIcon((Icon) UIManager.get("Tree.leafIcon"));
                    } else if (value instanceof ProjectFolder) {
                        this.setIcon((Icon) UIManager.get("Tree.closedIcon"));
                    }
                }
            }
            return this;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusmsg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resList = new javax.swing.JList();
        refreshButton = new javax.swing.JButton();
        renameButton = new javax.swing.JButton();
        fixAllButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 300));

        statusmsg.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        statusmsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusmsg.setText("Bob! Bob! Bob! Bob! Bob! Bob! Bob! Bob!");
        statusmsg.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        resList.setModel(new ResourceListModel());
        resList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resList.setCellRenderer(new FileNameListCellRenderer());
        resList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resListMousePressed(evt);
            }
        });
        resList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                resListValueChanged(evt);
            }
        });
        resList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(resList);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        renameButton.setText("Rename...");
        renameButton.setEnabled(false);
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        fixAllButton.setText("Fix all (replace illegal chars with _ )");
        fixAllButton.setEnabled(false);
        fixAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fixAllButton)
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(statusmsg, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(statusmsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(renameButton)
                    .addComponent(fixAllButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        search();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void resListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_resListValueChanged
        renameButton.setEnabled(resList.getSelectedIndex() >= 0);
    }//GEN-LAST:event_resListValueChanged

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        rename();
    }//GEN-LAST:event_renameButtonActionPerformed

    private void resListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resListMousePressed
        if (evt.getClickCount() >= 2 && evt.getButton() == MouseEvent.BUTTON1) {
            rename();
        }
    }//GEN-LAST:event_resListMousePressed

    private void resListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resListKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            rename();
        }
    }//GEN-LAST:event_resListKeyPressed

    private void fixAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixAllButtonActionPerformed
        for (ProjectElement e : results) {
            try {
                String rec = getRecommenededName(e.getName());
                e.getFile().rename(rec);
            } catch (IOException ex) {
                String msg = ex.getLocalizedMessage();
                        if (msg == null) {
                            msg = "<Unknown reason>";
                        }
                        JOptionPane.showMessageDialog(Core.getStaticContext().getMainFrame(),
                                "Error renaming file: " + msg, "File Renaming Error",
                                JOptionPane.ERROR_MESSAGE);
            }
        }
        search();
    }//GEN-LAST:event_fixAllButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fixAllButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton renameButton;
    private javax.swing.JList resList;
    private javax.swing.JLabel statusmsg;
    // End of variables declaration//GEN-END:variables
}
