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
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.managers.PluginManager;
import org.gcreator.pineapple.managers.SettingsManager;

/**
 * Allows you to change IDE optinos.
 * 
 * @author Serge Humphrey
 */
public final class OptionsDialog extends javax.swing.JDialog {
    private static final long serialVersionUID = -1254363563L;
    
    /**
     * Called when a new options dialog is created.
     * 
     * @param arg0 The {@link JTabbedPane} the options dialog
     * puts all the options tabs in. You can put your plugin's 
     * own tab in here, too.
     */
    public static final String OPTIONS_DIALOG_CREATED = "options-dialog-created";

    /** Creates and shows new form OptionsDialog */
    public OptionsDialog() {
        super(Core.getStaticContext().getMainFrame(), true);
        initComponents();

        EventManager.fireEvent(this, OPTIONS_DIALOG_CREATED, tabs);

        // Dislay dialog
        setVisible(true);
    }

    private class LAFListModel extends AbstractListModel implements ComboBoxModel {
        private static final long serialVersionUID = 2423543637L;

        @Override
        public int getSize() {
            return UIManager.getInstalledLookAndFeels().length;
        }

        @Override
        public Object getElementAt(int index) {
            return UIManager.getInstalledLookAndFeels()[index].getName();
        }

        @Override
        public void setSelectedItem(Object anItem) {
            for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()) {
                if (i.getName().equals(anItem)) {
                    try {
                        // Try to load it from a plugin first.

                        try {
                            UIManager.setLookAndFeel(i.getClassName());
                        } catch (ClassNotFoundException ex) {
                            try {
                                // Bother. It didn't work. Perhaps it's a plugin look and feel.
                                Class c = PluginManager.getClassLoader().loadClass(i.getClassName());
                                LookAndFeel f = (LookAndFeel) c.newInstance();
                                
                                UIManager.setLookAndFeel(f);
                            } catch (ClassNotFoundException ex1) {
                                // Crap.
                                Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE, "Bother.", ex1);
                            }
                        }

                        for (Window w : Window.getWindows()) {
                            for (Component c : w.getComponents()) {
                                SwingUtilities.updateComponentTreeUI(c);
                            }
                        }
                        SettingsManager.set(PineappleGUI.LOOK_AND_FEEL_KEY, i.getClassName());
                    } catch (InstantiationException ex) {
                        Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return;
                }
            }
        }

        @Override
        public Object getSelectedItem() {
            return UIManager.getLookAndFeel().getName();
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

        tabs = new javax.swing.JTabbedPane();
        generalTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lafChooser = new javax.swing.JComboBox();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("IDE Options");
        setMinimumSize(new java.awt.Dimension(310, 180));

        tabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel1.setText("Look&Feel:");

        lafChooser.setModel(new LAFListModel());

        javax.swing.GroupLayout generalTabLayout = new javax.swing.GroupLayout(generalTab);
        generalTab.setLayout(generalTabLayout);
        generalTabLayout.setHorizontalGroup(
            generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(lafChooser, 0, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        generalTabLayout.setVerticalGroup(
            generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lafChooser, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        tabs.addTab("General", null, generalTab, "General Options");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton))
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel generalTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox lafChooser;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables

}
