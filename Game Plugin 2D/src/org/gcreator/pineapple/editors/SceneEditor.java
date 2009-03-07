/*
Copyright (C) 2008-2009 Luís Reis<luiscubal@gmail.com>
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

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListDataListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.gcreator.pineapple.formats.Scene;
import org.gcreator.pineapple.gui.BehaviourPanel;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.gui.SceneBackgroundProperties;
import org.gcreator.pineapple.gui.SceneEditorArea;
import org.gcreator.pineapple.gui.SceneProperties;
import org.gcreator.pineapple.validators.ActorValidator;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.util.ListeningVector.VectorChangeListener;

/**
 * The editor of game scenes.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class SceneEditor extends DocumentPane {

    private static final long serialVersionUID = 1L;
    public Scene scene;
    private BehaviourPanel panel;
    public SceneProperties sp;
    public SceneBackgroundProperties sbp;
    public SceneEditorArea sea;
    public JPanel settingsPanel;
    public JDialog actorDialog, settingsDialog;
    public JTabbedPane settingsTabs;

    /** 
     * Creates new form SceneEditor
     * 
     * @param f The file to edit
     */
    public SceneEditor(BasicFile f) {
        super(f);
        initComponents();
        scene = new Scene(f);
        panel = new BehaviourPanel(scene, this);
        panel.setVisible(true);
        tabs.add(panel, "Behavior");
        actorChooser.setResourceValidator(new ActorValidator());
        actorChooser.setVisible(true);

        actorDialog = new JDialog();
        actorDialog.setUndecorated(true);
        actorDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        actorDialog.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                actorDialog.dispose();
            }
        });
        settingsPanel = new JPanel();
        settingsPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        actorDialog.add(settingsPanel);


        settingsDialog = new JDialog();
        settingsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        settingsDialog.setUndecorated(true);
        settingsDialog.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                settingsDialog.dispose();
                scenePropertiesButton.setSelected(false);
            }
        });
        settingsTabs = new JTabbedPane(JTabbedPane.BOTTOM);
        settingsTabs.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        sp = new SceneProperties(this);
        settingsTabs.add("Scene Properties", sp);
        sbp = new SceneBackgroundProperties(this);
        settingsTabs.add("Background Properties", sbp);
        settingsDialog.add(settingsTabs);
        settingsDialog.pack();
        
        seaScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        seaScrollPane.getVerticalScrollBar().setBlockIncrement(64);
        seaScrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        seaScrollPane.getHorizontalScrollBar().setBlockIncrement(64);
        sea = new SceneEditorArea(this);
        seaScrollPane.setViewportView(sea);
        
        actorList.setModel(new ActorListModel());
        actorList.setCellRenderer(new ActorListCellRenderer());
    }

    private final class ActorListModel implements ListModel {

        private Vector<ListDataListener> listeners = new Vector<ListDataListener>();
        
        {
            scene.actors.addListener(new VectorChangeListener() {

                public void vectorChanged() {
                    for (ListDataListener l : listeners) {
                        l.contentsChanged(null);
                    }
                }
            });
        }
        public int getSize() {
            return scene.actors.size();
        }

        public Object getElementAt(int index) {
            return scene.actors.get(index);
        }

        public void addListDataListener(ListDataListener l) {
            listeners.add(l);
        }

        public void removeListDataListener(ListDataListener l) {
            listeners.remove(l);  
        }
    }

    private static class ActorListCellRenderer extends DefaultListCellRenderer {

        private static final long serialVersionUID = 2997455648L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Scene.ActorInScene) {
                Scene.ActorInScene s = (Scene.ActorInScene)value;
                l.setText(s.actor.getName() + " (" + s.x + ", " + s.y + ")");
            }

            return l;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean save() {
        boolean success = false;
        try {
            scene.save(file);
            success = true;
        } catch (IOException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    /**
     * Saves the file
     */
    @Override
    public boolean saveBackend() {
        return save();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolButtonGroup = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        environmentTab = new javax.swing.JPanel();
        topToolBar = new javax.swing.JToolBar();
        actorChooser = new org.gcreator.pineapple.gui.ResourceChooser();
        addActorButton = new javax.swing.JToggleButton();
        editActorButton = new javax.swing.JToggleButton();
        deleteActorButton = new javax.swing.JToggleButton();
        scenePropertiesButton = new javax.swing.JToggleButton();
        seaScrollPane = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        actorList = new javax.swing.JList();

        topToolBar.setFloatable(false);
        topToolBar.setRollover(true);
        topToolBar.add(actorChooser);

        toolButtonGroup.add(addActorButton);
        addActorButton.setSelected(true);
        addActorButton.setText("Add");
        addActorButton.setFocusable(false);
        addActorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addActorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addActorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActorButtonActionPerformed(evt);
            }
        });
        topToolBar.add(addActorButton);

        toolButtonGroup.add(editActorButton);
        editActorButton.setText("Edit");
        editActorButton.setFocusable(false);
        editActorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editActorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editActorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActorButtonActionPerformed(evt);
            }
        });
        topToolBar.add(editActorButton);

        toolButtonGroup.add(deleteActorButton);
        deleteActorButton.setText("Delete");
        deleteActorButton.setFocusable(false);
        deleteActorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteActorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteActorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActorButtonActionPerformed(evt);
            }
        });
        topToolBar.add(deleteActorButton);

        scenePropertiesButton.setText("Scene Properties");
        scenePropertiesButton.setFocusable(false);
        scenePropertiesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        scenePropertiesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        scenePropertiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scenePropertiesButtonActionPerformed(evt);
            }
        });
        topToolBar.add(scenePropertiesButton);

        seaScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        seaScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        actorList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        actorList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                actorListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(actorList);

        javax.swing.GroupLayout environmentTabLayout = new javax.swing.GroupLayout(environmentTab);
        environmentTab.setLayout(environmentTabLayout);
        environmentTabLayout.setHorizontalGroup(
            environmentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, environmentTabLayout.createSequentialGroup()
                .addComponent(topToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(seaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );
        environmentTabLayout.setVerticalGroup(
            environmentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, environmentTabLayout.createSequentialGroup()
                .addComponent(topToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabs.addTab("Scene", environmentTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void addActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_ADD;
    sea.repaint();
}//GEN-LAST:event_addActorButtonActionPerformed

private void editActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_EDIT;
    sea.repaint();
}//GEN-LAST:event_editActorButtonActionPerformed

private void deleteActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_DELETE;
    sea.repaint();
}//GEN-LAST:event_deleteActorButtonActionPerformed

private void actorListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_actorListValueChanged
    int i = actorList.getSelectedIndex();
    if (i >= 0 && i < scene.actors.size()) {
        sea.selection = scene.actors.get(i);
        sea.repaint();
    }
}//GEN-LAST:event_actorListValueChanged

private void scenePropertiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scenePropertiesButtonActionPerformed
    if (scenePropertiesButton.isSelected()) {
        settingsDialog.setLocation(scenePropertiesButton.getLocationOnScreen().x,
                scenePropertiesButton.getLocationOnScreen().y + scenePropertiesButton.getHeight());
        settingsDialog.setVisible(true);
    } else {
        settingsDialog.dispose();
    }
}//GEN-LAST:event_scenePropertiesButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.gcreator.pineapple.gui.ResourceChooser actorChooser;
    private javax.swing.JList actorList;
    private javax.swing.JToggleButton addActorButton;
    private javax.swing.JToggleButton deleteActorButton;
    private javax.swing.JToggleButton editActorButton;
    private javax.swing.JPanel environmentTab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton scenePropertiesButton;
    public javax.swing.JScrollPane seaScrollPane;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.ButtonGroup toolButtonGroup;
    private javax.swing.JToolBar topToolBar;
    // End of variables declaration//GEN-END:variables
}
