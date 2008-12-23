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
import org.gcreator.gui.validators.ImageValidator;
import org.gcreator.project.io.BasicFile;
import org.noos.xing.mydoggy.ToolWindow;

/**
 * A very nice editor for an actor.
 * 
 * @author Luís Reis
 */
public final class ActorEditor extends DocumentPane implements PaletteUser {

    private static final long serialVersionUID = 1L;
    private Actor actor = null;

    /**
     * Creates a new ActorEditor
     * @param f The actor file
     */
    public ActorEditor(BasicFile f) {
        super(f);
        try {
            actor = new Actor(f);
        } catch (Exception e) {
            actor = new Actor();
        }

        initComponents();
        for (Event e : actor.events) {
            this.addTabForEvent(e);
        }
        this.setModified(true);
        resourcePicker1.setResourceValidator(new ImageValidator());
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
        tabPane.insertTab(e.type, null, p, "", tabPane.getComponentCount() - 2);
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

        splitter = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        tabPane = new javax.swing.JTabbedPane();
        eventsTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventList = new javax.swing.JList();
        newEventButton = new javax.swing.JButton();
        deleteEventButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionTextPane = new javax.swing.JTextPane();
        fieldsTab = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        addFieldButton = new javax.swing.JButton();
        removeFieldButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldsTable = new javax.swing.JTable();
        resourcePicker1 = new org.gcreator.gui.ResourcePicker();

        splitter.setDividerLocation(0);
        splitter.setDividerSize(8);
        splitter.setResizeWeight(0.4);
        splitter.setName("Divider"); // NOI18N
        splitter.setOneTouchExpandable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        splitter.setLeftComponent(jPanel1);

        eventList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Create Event", "Update Event", "Draw Event" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        eventList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        eventList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                eventListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(eventList);

        newEventButton.setText("New...");
        newEventButton.setEnabled(false);
        newEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEventButtonActionPerformed(evt);
            }
        });

        deleteEventButton.setText("Delete");
        deleteEventButton.setEnabled(false);
        deleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel1.setText("Description:");

        descriptionTextPane.setContentType("text/html");
        descriptionTextPane.setEditable(false);
        descriptionTextPane.setText("<html>\n  <head>\n\n  </head>\n  <body>\n\n  </body>\n</html>\n");
        jScrollPane3.setViewportView(descriptionTextPane);

        javax.swing.GroupLayout eventsTabLayout = new javax.swing.GroupLayout(eventsTab);
        eventsTab.setLayout(eventsTabLayout);
        eventsTabLayout.setHorizontalGroup(
            eventsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsTabLayout.createSequentialGroup()
                .addGroup(eventsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(eventsTabLayout.createSequentialGroup()
                        .addComponent(newEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteEventButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addContainerGap())
        );
        eventsTabLayout.setVerticalGroup(
            eventsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsTabLayout.createSequentialGroup()
                .addGroup(eventsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eventsTabLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteEventButton)
                    .addComponent(newEventButton))
                .addContainerGap())
        );

        tabPane.addTab("Events", eventsTab);

        fieldsTab.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(100, 32));

        addFieldButton.setText("Add");
        addFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFieldButtonActionPerformed(evt);
            }
        });

        removeFieldButton.setText("Remove");
        removeFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFieldButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(addFieldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeFieldButton))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeFieldButton)
                    .addComponent(addFieldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fieldsTab.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        fieldsTable.setModel(new ActorEditor.FieldsTableModel());
        jScrollPane1.setViewportView(fieldsTable);

        fieldsTab.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabPane.addTab("Fields", fieldsTab);

        splitter.setRightComponent(tabPane);
        splitter.setLeftComponent(resourcePicker1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitter, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitter, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void addFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFieldButtonActionPerformed
    actor.fields.add(new Actor.Field("newField", "int"));
    fieldsTable.updateUI();
    this.setModified(true);
}//GEN-LAST:event_addFieldButtonActionPerformed

private void removeFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFieldButtonActionPerformed
    for (int row : fieldsTable.getSelectedRows()) {
        actor.fields.remove(row);
    }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFieldButton;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JTextPane descriptionTextPane;
    private javax.swing.JList eventList;
    private javax.swing.JPanel eventsTab;
    private javax.swing.JPanel fieldsTab;
    private javax.swing.JTable fieldsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton newEventButton;
    private javax.swing.JButton removeFieldButton;
    private org.gcreator.gui.ResourcePicker resourcePicker1;
    private javax.swing.JSplitPane splitter;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
