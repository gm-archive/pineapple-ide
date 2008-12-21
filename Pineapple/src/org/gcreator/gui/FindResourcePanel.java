/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

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
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.gcreator.pineapple.PineappleCore;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFile;
import org.gcreator.project.ProjectFolder;



/**
 * Panel thats searches for resources.
 * 
 * @author Serge Humphrey
 */
public final class FindResourcePanel extends JPanel implements ActionListener, MouseListener {
    
    private static final long serialVersionUID = 1L;
    
    private Box top;
    private JTextField search;
    private JButton go;
    private JList list;
    
    private Vector<ProjectElement> results;
    
    public FindResourcePanel() {
        super(new BorderLayout(5, 5));
        
        results = new Vector<ProjectElement>();
        
        top = Box.createHorizontalBox();
        top.add(Box.createHorizontalGlue());
        search = new JTextField();
        search.addActionListener(this);
        top.add(search);
        top.add(Box.createHorizontalStrut(4));
        go = new JButton("Go");
        go.addActionListener(this);
        top.add(go);
        top.add(Box.createHorizontalStrut(12));
        this.add(top, BorderLayout.NORTH);
        
        list = new JList(new FindListModel());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setCellRenderer(new FindListCellRender());
        list.addMouseListener(this);
        this.add(new JScrollPane(list), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == go || e.getSource() == search) {
            search(search.getText());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() >= 2) {
            Object o = list.getSelectedValue();
            if (o != null && o instanceof ProjectElement) {
                ProjectElement el = (ProjectElement)o;
                /* Tree Path */
                if (el.getTreeNode() instanceof DefaultMutableTreeNode) {
                    DefaultMutableTreeNode n = (DefaultMutableTreeNode) el.getTreeNode();
                    for (TreeNode node : n.getPath()) {
                        System.out.print(((JLabel)list.getCellRenderer().getListCellRendererComponent(list, node, 0, false, false)).getText() + "/");
                    }
                    System.out.println();
                    PineappleGUI.tree.setSelectionPath(new TreePath(n.getPath()));
                }
                
                if (o instanceof ProjectFile) {
                    PineappleCore.getGUI().openFile((el).getFile());
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private void search(String s) {
        s = s.toLowerCase();
        results.clear();
        go.setEnabled(false);
        try {
            for (ProjectElement e : PineappleCore.getProject().getFiles()) {
                search(s, e);
            }
            list.updateUI();
        } catch (Throwable r) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), r);
        } finally {
            go.setEnabled(true);
        }
    }
    
    private void search(String s, ProjectElement e) {
        if (e.getName().toLowerCase().contains(s)) {
            results.add(e);
        }
        
        if (e instanceof ProjectFolder) {
            for (ProjectElement p : ((ProjectFolder)e).getChildren()) {
                search(s, p);
            }
        }
    }
    
    private class FindListModel extends AbstractListModel {
        
        private static final long serialVersionUID = 1L;

        @Override
        public int getSize() {
            return results.size();
        }

        @Override
        public Object getElementAt(int index) {
            return results.get(index);
        }
    }
    
    private class FindListCellRender extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof ProjectElement) {
                ProjectElement e = (ProjectElement) value;
                this.setText(e.getFile().getName());
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
}
