/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 BobSerge<serge_1994@hotmail.com>

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
package org.gcreator.editors;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.gcreator.actions.ActionType;
import org.gcreator.dnd.PaletteAction;
import org.gcreator.events.Event;
import org.gcreator.events.EventPanel;
import org.gcreator.formats.Actor;
import org.gcreator.game2d.PaletteUser;
import org.gcreator.gui.DocumentPane;
import org.gcreator.gui.EventCellRenderer;
import org.gcreator.gui.EventTabRenderer;
import org.gcreator.gui.validators.ImageValidator;
import org.gcreator.project.io.BasicFile;
import org.noos.xing.mydoggy.ToolWindow;

/**
 * A very nice editor for an actor.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public final class ActorEditor extends DocumentPane implements PaletteUser {

    private static final long serialVersionUID = 1L;
    private Actor actor = null;
    private boolean toggled;
    
    /**
     * Creates a new ActorEditor
     * @param f The actor file
     */
    public ActorEditor(BasicFile f) {
        super(f);
        try {
            actor = new Actor(f);
        } catch (Exception e) {
            System.out.println(e.toString());
            actor = new Actor();
        }

        initComponents();
        for (Event e : actor.events) {
            this.addTabForEvent(e);
        }
        this.setModified(true);
        spriteChooser.setResourceValidator(new ImageValidator());
        depthSpinner.setValue(actor.z);
        depthSpinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                actor.z = (Integer) depthSpinner.getValue();
            }
        });
        eventList.setCellRenderer(new EventCellRenderer());
        hackAsplit.setDividerLocation(1.0D);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean save() {
        boolean saved = false;
        try {
            actor.save(file);
            saved = true;
        } catch (IOException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saved;
    }
    
    /**
     * Saves the file
     */
    @Override
    public boolean saveBackend() {
        return save();
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean doPalette(ToolWindow palette, JPanel palettePanel) {
        palettePanel.removeAll();
        GridLayout gb = new GridLayout(0, 1);
        palettePanel.setLayout(gb);

        JLabel l = new JLabel("<html><b>Actions:</b></html>");
        l.setVisible(true);
        palettePanel.add(l);
        
        for (ActionType type : ActionType.actionTypes) {
            PaletteAction act = new PaletteAction(type);
            palettePanel.add(act);
            act.setVisible(true);
        }

        return true;
    }

    private void addTabForEvent(Event e) {
        EventPanel p = new EventPanel(e);
        int i = tabPane.getComponentCount() - 2;
        tabPane.insertTab(e.type, null, p, "", i);
        tabPane.setTabComponentAt(i, new EventTabRenderer(tabPane));
    }

    //<editor-fold defaultstate="collapsed" desc="class FieldsTableModel">
    private class FieldsTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1;

        public int getRowCount() {
            return actor.fields.size();
        }

        public int getColumnCount() {
            /* Name | Type | Static | Final | Defualt Value*/
            return 5;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Name";
                case 1:
                    return "Type";
                case 2:
                    return "Static";
                case 3:
                    return "Final";
                case 4:
                    return "Default Value";
                default:
                    return "Column " + columnIndex;
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return Boolean.class;
                case 3:
                    return Boolean.class;
                case 4:
                    return String.class;
                default:
                    return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return actor.fields.get(rowIndex).getName();
                case 1:
                    return actor.fields.get(rowIndex).getType();
                case 2:
                    return actor.fields.get(rowIndex).isStatic();
                case 3:
                    return actor.fields.get(rowIndex).isFinal();
                case 4:
                    return actor.fields.get(rowIndex).getDefaultValue();
                default:
                    return String.class;
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    actor.fields.get(rowIndex).setName((String) aValue);
                    return;
                case 1:
                    actor.fields.get(rowIndex).setType((String) aValue);
                    return;
                case 2:
                    actor.fields.get(rowIndex).setStatic((Boolean) aValue);
                    return;
                case 3:
                    actor.fields.get(rowIndex).setFinal((Boolean) aValue);
                    return;
                case 4:
                    actor.fields.get(rowIndex).setDefaultValue((String) aValue);
                    return;
            }
        }
    }
    //</editor-fold>

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggles = new javax.swing.ButtonGroup();
        toolBar = new javax.swing.JToolBar();
        propertiesToggle = new javax.swing.JToggleButton();
        membersToggle = new javax.swing.JToggleButton();
        hackAsplit = new javax.swing.JSplitPane();
        propertiesPanel = new javax.swing.JPanel();
        inGameRenderingPanel = new javax.swing.JPanel();
        depthSpinner = new javax.swing.JSpinner();
        depthLabel = new javax.swing.JLabel();
        renderSpriteCheckBox = new javax.swing.JCheckBox();
        spriteChooser = new org.gcreator.gui.ResourceChooser();
        spriteLabel = new javax.swing.JLabel();
        polymorhpismPanel = new javax.swing.JPanel();
        parentChooser = new org.gcreator.gui.ResourceChooser();
        parentLabel = new javax.swing.JLabel();
        isClassFinalCheckBox = new javax.swing.JCheckBox();
        tabPane = new javax.swing.JTabbedPane();
        eventsTab = new javax.swing.JPanel();
        eventListScrollPane = new javax.swing.JScrollPane();
        eventList = new javax.swing.JList();
        eventButtonsPanel = new javax.swing.JPanel();
        newEventButton = new javax.swing.JButton();
        deleteEventButton = new javax.swing.JButton();
        fieldsTab = new javax.swing.JPanel();
        fieldButtonsPanel = new javax.swing.JPanel();
        addFieldButton = new javax.swing.JButton();
        removeFieldButton = new javax.swing.JButton();
        fieldsTabelScrollPane = new javax.swing.JScrollPane();
        fieldsTable = new javax.swing.JTable();

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        toggles.add(propertiesToggle);
        propertiesToggle.setSelected(true);
        propertiesToggle.setText("Properties");
        propertiesToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesToggleActionPerformed(evt);
            }
        });
        toolBar.add(propertiesToggle);

        toggles.add(membersToggle);
        membersToggle.setText("Members");
        membersToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersToggleActionPerformed(evt);
            }
        });
        toolBar.add(membersToggle);

        hackAsplit.setDividerLocation(90);
        hackAsplit.setEnabled(false);

        inGameRenderingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("In-Game Rendering"));

        depthSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(5)));

        depthLabel.setText("Depth (z):");

        renderSpriteCheckBox.setSelected(true);
        renderSpriteCheckBox.setText("Render sprite automatically");

        spriteLabel.setText("Sprite:");

        javax.swing.GroupLayout inGameRenderingPanelLayout = new javax.swing.GroupLayout(inGameRenderingPanel);
        inGameRenderingPanel.setLayout(inGameRenderingPanelLayout);
        inGameRenderingPanelLayout.setHorizontalGroup(
            inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addComponent(spriteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spriteChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addComponent(depthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(renderSpriteCheckBox))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        inGameRenderingPanelLayout.setVerticalGroup(
            inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                .addGroup(inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(spriteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spriteChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(renderSpriteCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        polymorhpismPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Polymorhpism"));

        parentLabel.setText("Parent:");

        isClassFinalCheckBox.setText("Disable inhertance of this class");

        javax.swing.GroupLayout polymorhpismPanelLayout = new javax.swing.GroupLayout(polymorhpismPanel);
        polymorhpismPanel.setLayout(polymorhpismPanelLayout);
        polymorhpismPanelLayout.setHorizontalGroup(
            polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                .addGroup(polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isClassFinalCheckBox)
                    .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                        .addComponent(parentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parentChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        polymorhpismPanelLayout.setVerticalGroup(
            polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                .addGroup(polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(parentLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parentChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isClassFinalCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout propertiesPanelLayout = new javax.swing.GroupLayout(propertiesPanel);
        propertiesPanel.setLayout(propertiesPanelLayout);
        propertiesPanelLayout.setHorizontalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(polymorhpismPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inGameRenderingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        propertiesPanelLayout.setVerticalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesPanelLayout.createSequentialGroup()
                .addComponent(inGameRenderingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(polymorhpismPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        hackAsplit.setLeftComponent(propertiesPanel);

        eventsTab.setLayout(new java.awt.BorderLayout());

        eventList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Create Event", "Update Event", "Draw Event", "Destroy Event" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        eventList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        eventList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                eventListValueChanged(evt);
            }
        });
        eventListScrollPane.setViewportView(eventList);

        eventsTab.add(eventListScrollPane, java.awt.BorderLayout.CENTER);

        eventButtonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        newEventButton.setText("New...");
        newEventButton.setEnabled(false);
        newEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEventButtonActionPerformed(evt);
            }
        });
        eventButtonsPanel.add(newEventButton);

        deleteEventButton.setText("Delete");
        deleteEventButton.setEnabled(false);
        deleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventButtonActionPerformed(evt);
            }
        });
        eventButtonsPanel.add(deleteEventButton);

        eventsTab.add(eventButtonsPanel, java.awt.BorderLayout.SOUTH);

        tabPane.addTab("Events", eventsTab);

        fieldsTab.setLayout(new java.awt.BorderLayout());

        fieldButtonsPanel.setPreferredSize(new java.awt.Dimension(100, 32));
        fieldButtonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        addFieldButton.setText("Add");
        addFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFieldButtonActionPerformed(evt);
            }
        });
        fieldButtonsPanel.add(addFieldButton);

        removeFieldButton.setText("Remove");
        removeFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFieldButtonActionPerformed(evt);
            }
        });
        fieldButtonsPanel.add(removeFieldButton);

        fieldsTab.add(fieldButtonsPanel, java.awt.BorderLayout.SOUTH);

        fieldsTable.setModel(new ActorEditor.FieldsTableModel());
        fieldsTabelScrollPane.setViewportView(fieldsTable);

        fieldsTab.add(fieldsTabelScrollPane, java.awt.BorderLayout.CENTER);

        tabPane.addTab("Fields", fieldsTab);

        hackAsplit.setRightComponent(tabPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hackAsplit, 0, 0, Short.MAX_VALUE)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hackAsplit, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void addFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFieldButtonActionPerformed
    actor.fields.add(new Actor.Field("newField", "int"));
    fieldsTable.updateUI();
    this.setModified(true);
}//GEN-LAST:event_addFieldButtonActionPerformed

private void removeFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFieldButtonActionPerformed
    int[] rows = fieldsTable.getSelectedRows();
    for (int row = rows.length-1; row >= 0; row--) {
        actor.fields.remove(row);
    }
    fieldsTable.getSelectionModel().setSelectionInterval(-1, -1);
    fieldsTable.updateUI();
    this.setModified(true);
}//GEN-LAST:event_removeFieldButtonActionPerformed

private void newEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEventButtonActionPerformed
    Event e = new Event();
    e.type = eventList.getSelectedValue().toString();
    actor.events.add(e);
    addTabForEvent(e);
    eventList.setSelectedIndex(-1);
    newEventButton.setEnabled(false);
    this.setModified(true);
}//GEN-LAST:event_newEventButtonActionPerformed

private void eventListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_eventListValueChanged
if (actor != null && eventList.getSelectedIndex() != -1) {
        for (Event e : actor.events) {
            if (e.type.equals(eventList.getSelectedValue().toString())) {
                newEventButton.setEnabled(false);
                return;
            }
        }
        newEventButton.setEnabled(true);
    }
}//GEN-LAST:event_eventListValueChanged

private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventButtonActionPerformed
    if (eventList.getSelectedIndex() < 0) {
        return;
    }
    actor.events.remove(eventList.getSelectedIndex());
    if (eventList.getSelectedIndex() > actor.events.size()) {
        eventList.setSelectedIndex(actor.events.size()-1);
    }
    eventList.updateUI();
    this.setModified(true);
}//GEN-LAST:event_deleteEventButtonActionPerformed

private void propertiesToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesToggleActionPerformed
    hackAsplit.setDividerLocation(1.0D);
}//GEN-LAST:event_propertiesToggleActionPerformed

private void membersToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersToggleActionPerformed
    hackAsplit.setDividerLocation(0.0D);
}//GEN-LAST:event_membersToggleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFieldButton;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JLabel depthLabel;
    private javax.swing.JSpinner depthSpinner;
    private javax.swing.JPanel eventButtonsPanel;
    private javax.swing.JList eventList;
    private javax.swing.JScrollPane eventListScrollPane;
    private javax.swing.JPanel eventsTab;
    private javax.swing.JPanel fieldButtonsPanel;
    private javax.swing.JPanel fieldsTab;
    private javax.swing.JScrollPane fieldsTabelScrollPane;
    private javax.swing.JTable fieldsTable;
    private javax.swing.JSplitPane hackAsplit;
    private javax.swing.JPanel inGameRenderingPanel;
    private javax.swing.JCheckBox isClassFinalCheckBox;
    private javax.swing.JToggleButton membersToggle;
    private javax.swing.JButton newEventButton;
    private org.gcreator.gui.ResourceChooser parentChooser;
    private javax.swing.JLabel parentLabel;
    private javax.swing.JPanel polymorhpismPanel;
    private javax.swing.JPanel propertiesPanel;
    private javax.swing.JToggleButton propertiesToggle;
    private javax.swing.JButton removeFieldButton;
    private javax.swing.JCheckBox renderSpriteCheckBox;
    private org.gcreator.gui.ResourceChooser spriteChooser;
    private javax.swing.JLabel spriteLabel;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.ButtonGroup toggles;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
