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
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.gcreator.pineapple.formats.Scene;
import org.gcreator.pineapple.gui.ActorProperties;
import org.gcreator.pineapple.gui.BehaviourPanel;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.gui.SceneBackgroundProperties;
import org.gcreator.pineapple.gui.SceneEditorArea;
import org.gcreator.pineapple.gui.SceneProperties;
import org.gcreator.pineapple.validators.ActorValidator;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.util.ListeningVector;
import org.gcreator.pineapple.util.VectorChangeListener;

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
    public SceneEditorArea sea;
    public ActorProperties actorPanel;
    private JFrame fullScreenWindow;
    private SceneProperties sp;
    private SceneBackgroundProperties sbp;

    /** 
     * Creates new form SceneEditor
     * 
     * @param f The file to edit
     */
    public SceneEditor(BasicFile f) {
        super(f);
        scene = new Scene(f);
        initComponents();
        panel = new BehaviourPanel(scene, this);
        panel.setVisible(true);
        tabs.add(panel, "Behavior");
        actorChooser.setResourceValidator(new ActorValidator());
        actorChooser.setVisible(true);

        JScrollBar v = seaScrollPane.getVerticalScrollBar();
        v.setUnitIncrement(16);
        v.setBlockIncrement(64);
        JScrollBar h = seaScrollPane.getHorizontalScrollBar();
        h.setUnitIncrement(16);
        h.setBlockIncrement(64);

        sea = new SceneEditorArea(this);
        seaScrollPane.setViewportView(sea);

        sp = new SceneProperties(this);
        settingsTabs.add("Scene Properties", new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        sbp = new SceneBackgroundProperties(this);
        settingsTabs.add("Background Properties", new JScrollPane(sbp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        actorPanel = new ActorProperties(sea);
        settingsTabs.add("Actor Properties", new JScrollPane(actorPanel));
        settingsTabs.setEnabledAt(2, false);

        leftSplitPane.setDividerLocation(0.6D);
        topToolBar.add(Box.createHorizontalGlue());
    }

    private final class ActorListModel implements ListModel {

        private Vector<ListDataListener> listeners = new Vector<ListDataListener>();
        
        {
            scene.actors.addListener(new VectorChangeListener() {

                public void vectorChanged(ListeningVector v) {
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
                l.setText(s.actor.getName() + " (" + s.x + ", " + s.y + "), Z: " + s.actor.getZ());
            }

            return l;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean saveBackend() {
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
        if (success) {
            this.setModified(true);
        }
        return success;
    }

    /**
     * Sets whether the Actor Properties tab should be enabled.
     *
     * @param b  whether the Actor Properties tab should be enabled or not.
     */
    public void setActorTabEnabled(boolean b) {
        if (settingsTabs != null) {
            settingsTabs.setEnabledAt(2, b);
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

        toolButtonGroup = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        environmentTab = new javax.swing.JPanel();
        topToolBar = new javax.swing.JToolBar();
        actorChooser = new org.gcreator.pineapple.gui.ResourceChooser();
        addActorButton = new javax.swing.JToggleButton();
        editActorButton = new javax.swing.JToggleButton();
        deleteActorButton = new javax.swing.JToggleButton();
        fullscreenButton = new javax.swing.JToggleButton();
        seaScrollPane = new javax.swing.JScrollPane();
        leftSplitPane = new javax.swing.JSplitPane();
        actorListScrollPane = new javax.swing.JScrollPane();
        actorList = new javax.swing.JList();
        settingsTabs = new javax.swing.JTabbedPane();

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

        fullscreenButton.setText("Fullscreen");
        fullscreenButton.setFocusable(false);
        fullscreenButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fullscreenButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fullscreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullscreenButtonActionPerformed(evt);
            }
        });
        topToolBar.add(fullscreenButton);

        seaScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        seaScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        leftSplitPane.setDividerLocation(80);
        leftSplitPane.setDividerSize(8);
        leftSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        leftSplitPane.setResizeWeight(0.64);
        leftSplitPane.setContinuousLayout(true);
        leftSplitPane.setOneTouchExpandable(true);

        actorList.setModel(new ActorListModel());
        actorList.setCellRenderer(new ActorListCellRenderer());
        actorList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                actorListValueChanged(evt);
            }
        });
        actorListScrollPane.setViewportView(actorList);

        leftSplitPane.setRightComponent(actorListScrollPane);
        leftSplitPane.setLeftComponent(settingsTabs);

        javax.swing.GroupLayout environmentTabLayout = new javax.swing.GroupLayout(environmentTab);
        environmentTab.setLayout(environmentTabLayout);
        environmentTabLayout.setHorizontalGroup(
            environmentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, environmentTabLayout.createSequentialGroup()
                .addComponent(topToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(environmentTabLayout.createSequentialGroup()
                .addComponent(leftSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
        );
        environmentTabLayout.setVerticalGroup(
            environmentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, environmentTabLayout.createSequentialGroup()
                .addComponent(topToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(environmentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(seaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
        );

        tabs.addTab("Scene", environmentTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void addActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_ADD;
}//GEN-LAST:event_addActorButtonActionPerformed

private void editActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_EDIT;
}//GEN-LAST:event_editActorButtonActionPerformed

private void deleteActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_DELETE;
}//GEN-LAST:event_deleteActorButtonActionPerformed

private void fullscreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullscreenButtonActionPerformed

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    if (!gd.isFullScreenSupported()) {
        return;
    }
    if (fullscreenButton.isSelected()) {
        fullScreenWindow = new JFrame("Scene Editor");
        fullScreenWindow.setUndecorated(true);
        fullScreenWindow.setContentPane(environmentTab);
        gd.setFullScreenWindow(fullScreenWindow);
    } else {
        gd.setFullScreenWindow(null);
        if (fullScreenWindow != null) {
            tabs.insertTab("Scene", null, fullScreenWindow.getContentPane(),"Scene Editor", 0);
            tabs.setSelectedIndex(0);
            fullScreenWindow.dispose();
        }
    }
}//GEN-LAST:event_fullscreenButtonActionPerformed

private void actorListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_actorListValueChanged
    int i = actorList.getSelectedIndex();
    if (i >= 0 && i < scene.actors.size()) {
        sea.setSelection(scene.actors.get(i));
        sea.renderActorCache();
        sea.renderCache();
        sea.paint();
    }
}//GEN-LAST:event_actorListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.gcreator.pineapple.gui.ResourceChooser actorChooser;
    public javax.swing.JList actorList;
    public javax.swing.JScrollPane actorListScrollPane;
    private javax.swing.JToggleButton addActorButton;
    private javax.swing.JToggleButton deleteActorButton;
    private javax.swing.JToggleButton editActorButton;
    private javax.swing.JPanel environmentTab;
    private javax.swing.JToggleButton fullscreenButton;
    private javax.swing.JSplitPane leftSplitPane;
    public javax.swing.JScrollPane seaScrollPane;
    private javax.swing.JTabbedPane settingsTabs;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.ButtonGroup toolButtonGroup;
    private javax.swing.JToolBar topToolBar;
    // End of variables declaration//GEN-END:variables
}
