/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.gcreator.pineapple.events.Event;
import org.gcreator.pineapple.formats.ClassResource;
import org.gcreator.pineapple.formats.ClassResource.Field;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.project.io.Register;
import org.gcreator.pineapple.syntax.PineDLEditor;
import org.gcreator.pineapple.validators.ActorValidator;
import org.gcreator.pineapple.validators.Glob;

/**
 * Panel with all the events, fields, and stuff.
 * 
 * @author  Luís Reis
 * @author  Serge Humphrey
 */
public class BehaviourPanel extends JPanel implements Event.EventChangeListener {

    private static final long serialVersionUID = 1;
    public ClassResource res;
    public DocumentPane pane;
    protected TableRowSorter<TableModel> sorter;

    /** 
     * Creates new form BehaviourPanel
     * 
     * @param obj The {@link ClassResource}.
     * @param pane The {@link DocumentPane} that this panel should belong to.
     */
    public BehaviourPanel(ClassResource obj, DocumentPane pane) {
        initComponents();
        res = obj;
        this.pane = pane;
        for (Event e : res.events) {
            this.addTabForEvent(e);
            e.addChangeListener(this);
        }
        eventList.setCellRenderer(new EventCellRenderer());

        fieldsTable.setModel(new StupidTableModel());
        TableColumn t;
        sorter = new TableRowSorter<TableModel>(new StupidTableModel(6));
        fieldsTable.setRowSorter(sorter);
        int i = 0;

        JComboBox accessBox = new JComboBox(new String[] {
            "public", "private", "protected",
        });
        t = new TableColumn(i++, 12, null, new DefaultCellEditor(accessBox));
        t.setHeaderValue("Access");
        fieldsTable.addColumn(t);

        t = new TableColumn(i++, 20);
        t.setHeaderValue("Name");
        fieldsTable.addColumn(t);

        JComboBox typeBox = new JComboBox();
        String[] types = new String[] {
            "int",
            "string",
            "double",
            "float",
            "long",
            "byte",
            "short",
        };
        for (String s : types) {
            typeBox.addItem(s);
        }
        for (BasicFile f : Glob.glob(new ActorValidator(), true)) {
            String name = f.getName().substring(0, f.getName().lastIndexOf('.'));
            typeBox.addItem(name);
        }
        t = new TableColumn(i++, 14, null, new DefaultCellEditor(typeBox));
        t.setHeaderValue("Type");
        fieldsTable.addColumn(t);


        t = new TableColumn(i++, 2);
        t.setHeaderValue("Static");
        fieldsTable.addColumn(t);

        t = new TableColumn(i++, 2);
        t.setHeaderValue("Final");
        fieldsTable.addColumn(t);

        t = new TableColumn(i++, 20);
        t.setHeaderValue("Default Value");
        fieldsTable.addColumn(t);

    }

    public void setModified(boolean b) {
        pane.setModified(b);
    }

    public void save() {
        for (Component c : tabPane.getComponents()) {
            if (c instanceof PineDLEditor) {
                PineDLEditor e = (PineDLEditor) c;
                e.save();
            }
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

        setLayout(new java.awt.BorderLayout());

        tabPane.setMinimumSize(new java.awt.Dimension(136, 183));
        tabPane.setPreferredSize(new java.awt.Dimension(136, 183));

        eventsTab.setLayout(new java.awt.BorderLayout());

        eventList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Create Event", "Update Event", "Draw Event", "Destroy Event", "Key Press Event", "Key Release Event", "Key Pressed Event" };
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

        fieldsTabelScrollPane.setViewportView(fieldsTable);

        fieldsTab.add(fieldsTabelScrollPane, java.awt.BorderLayout.CENTER);

        tabPane.addTab("Fields", fieldsTab);

        add(tabPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private Vector<TableModelListener> listeners = new Vector<TableModelListener>();

    private class StupidTableModel implements TableModel {

        int columns = 0;

        public StupidTableModel() {
        }

        // Must have this because the table row sorter is so stupid.
        public StupidTableModel(int stupidColumns) {
            this.columns = stupidColumns;
        }

        public int getRowCount() {
            return res.fields.size();
        }

        public int getColumnCount() {
            return columns;
        }

        public String getColumnName(int columnIndex) {
            return null;
        }

        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Boolean.class;
                case 4:
                    return Boolean.class;
                case 5:
                    return String.class;
            }
            return null;
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            ClassResource.Field f = res.fields.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return f.getAccess().toString();
                case 1:
                    return f.getName();
                case 2:
                    return f.getType();
                case 3:
                    return f.isStatic();
                case 4:
                    return f.isFinal();
                case 5:
                    return f.getDefaultValue();
                default:
                    return null;
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            ClassResource.Field f = res.fields.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    f.setAccess(Field.Access.valueOf(aValue.toString().toUpperCase()));
                    break;
                case 1:
                    f.setName(aValue.toString());
                    break;
                case 2:
                    f.setType(aValue.toString());
                    break;
                case 3:
                    f.setStatic((Boolean) aValue);
                    break;
                case 4:
                    f.setFinal((Boolean) aValue);
                    break;
                case 5:
                    f.setDefaultValue(aValue.toString());
                    break;
            }
            TableModelEvent e = new TableModelEvent(this, rowIndex, rowIndex, columnIndex, TableModelEvent.UPDATE);
            for (TableModelListener l : listeners) {
                l.tableChanged(e);
            }
        }

        public void addTableModelListener(TableModelListener l) {
            listeners.add(l);
        }

        public void removeTableModelListener(TableModelListener l) {
            listeners.remove(l);
        }
    }
private void eventListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_eventListValueChanged
    if (res != null && eventList.getSelectedIndex() != -1) {
        for (Event e : res.events) {
            if (e.getType().equalsIgnoreCase(eventList.getSelectedValue().toString())) {
                newEventButton.setEnabled(false);
                deleteEventButton.setEnabled(true);
                return;
            }
        }
        newEventButton.setEnabled(true);
        deleteEventButton.setEnabled(false);
    }
}//GEN-LAST:event_eventListValueChanged

private void newEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEventButtonActionPerformed
    Event e = new Event(eventList.getSelectedValue().toString());
    res.events.add(e);
    addTabForEvent(e);
    e.addChangeListener(this);
    eventList.setSelectedIndex(-1);
    newEventButton.setEnabled(false);
    deleteEventButton.setEnabled(true);
    this.setModified(true);
}//GEN-LAST:event_newEventButtonActionPerformed

private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventButtonActionPerformed
    if (eventList.getSelectedIndex() < 0) {
        return;
    }

    Component[] cs = tabPane.getComponents();
    @SuppressWarnings("unchecked")
    Vector<Event> evec = (Vector<Event>) res.events.clone();
    Object val = eventList.getSelectedValue();

    for (Event e : evec) {
        if (e.getType().equals(val)) {
            res.events.remove(e);
            int compCount = tabPane.getTabCount();
            tabLoop:
            for(int i = 0; i < compCount; i++){
                Component obj = tabPane.getComponentAt(i);
                if(obj instanceof PineDLEditor&&tabPane.getTitleAt(i).equals(val)){
                    tabPane.remove(i);
                    break tabLoop;
                }
            }
            break;
        }
    }
    eventList.updateUI();
    this.setModified(true);
    deleteEventButton.setEnabled(false);
    newEventButton.setEnabled(true);
}//GEN-LAST:event_deleteEventButtonActionPerformed

private void addFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFieldButtonActionPerformed
    String name = "newField";
    int i = 1;
    boolean exists = true;
    while (exists) {
        boolean b = false;
        for (ClassResource.Field f : res.fields) {
            if (f.getName().equals(name)) {
                name = "newField" + i++;
                exists = true;
                b = true;
                break;
            }
        }
        exists = b;
    }
    exists = false;
    res.fields.add(new ClassResource.Field(name, "int"));
    sorter.rowsInserted(res.fields.size() - 1, res.fields.size() - 1);
    fieldsTable.updateUI();
    this.setModified(true);
}//GEN-LAST:event_addFieldButtonActionPerformed

private void removeFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFieldButtonActionPerformed
    int[] rows = fieldsTable.getSelectedRows();
    for (int i = rows.length - 1; i >= 0; i--) {
        int row = rows[i];
        res.fields.remove(row);
        sorter.rowsDeleted(row, row);
        fieldsTable.getSelectionModel().removeSelectionInterval(row, row);
    }
    fieldsTable.updateUI();
    this.setModified(true);
}//GEN-LAST:event_removeFieldButtonActionPerformed

    private void addTabForEvent(final Event e) {
        Register r = new Register() {

            public InputStream getReader() throws IOException {
                return new InputStream() {

                    String buffer = e.getPineDL();
                    int pos = 0;

                    @Override
                    public int read() throws IOException {
                        if (buffer == null || pos >= buffer.length()) {
                            return -1;
                        }
                        return buffer.charAt(pos++);
                    }

                    @Override
                    public int available() {
                        if (buffer == null) {
                            return 0;
                        }
                        return buffer.length() - pos;
                    }
                };
            }

            public OutputStream getWriter() throws IOException {
                return new OutputStream() {

                    StringBuffer buffer = new StringBuffer();


                    {
                        e.setPineDL("");
                    }

                    @Override
                    public void write(int b) throws IOException {
                        buffer.append((char) b);
                    }

                    @Override
                    public void flush() {
                        e.setPineDL(e.getPineDL() + buffer);
                        buffer.delete(0, buffer.length());
                    }

                    @Override
                    public void close() {
                        flush();
                    }
                };
            }
        };
        final PineDLEditor p = new PineDLEditor(r);
        p.editor.getDocument().addDocumentListener(new DocumentListener() {

            public void change(DocumentEvent ev) {
                setModified(true);
            }

            public void insertUpdate(DocumentEvent e) {
                change(e);
            }

            public void removeUpdate(DocumentEvent e) {
                change(e);
            }

            public void changedUpdate(DocumentEvent e) {
                change(e);
            }
        });
        int i = tabPane.getComponentCount() - 2;
        tabPane.insertTab(e.getType(), null, p, e.getType(), i);
        tabPane.setTabComponentAt(i, new EventTabRenderer(tabPane));
    }

    public void eventChanged(Event e) {
        setModified(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFieldButton;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JPanel eventButtonsPanel;
    private javax.swing.JList eventList;
    private javax.swing.JScrollPane eventListScrollPane;
    private javax.swing.JPanel eventsTab;
    private javax.swing.JPanel fieldButtonsPanel;
    private javax.swing.JPanel fieldsTab;
    private javax.swing.JScrollPane fieldsTabelScrollPane;
    public javax.swing.JTable fieldsTable;
    private javax.swing.JButton newEventButton;
    private javax.swing.JButton removeFieldButton;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
