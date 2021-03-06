/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<serge@bobtheblueberry.com>

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
import javax.swing.JColorChooser;
import org.gcreator.pineapple.editors.SceneEditor;

/**
 *
 * The panel for the scene'scene properties.
 * 
 * @author Luís Reis
 */
public class SceneProperties extends javax.swing.JPanel {

    private static final long serialVersionUID = 5613L;
    private SceneEditor editor;
    private boolean nochange = false;

    /**
     * Creates new form SceneProperties
     * 
     * @param editor The editor to set the properties for.
     */
    public SceneProperties(SceneEditor editor) {
        this.editor = editor;
        initComponents();
        synchronized (this) {
            nochange = true;
            sceneWidthSpinner.setValue(new Integer(editor.scene.getWidth()));
            sceneHeightSpinner.setValue(new Integer(editor.scene.getHeight()));
            drawBackgroundCheckBox.setSelected(editor.scene.isBackgroundColorDrawn());
            backgroundColorPanel.setBackground(editor.scene.getBackgroundColor());
            nochange = false;
        }
    }

    /**
     * Creates new form SceneProperties
     * 
     * @deprecated Only use for instantating in NetBeans Editor.
     */
    @Deprecated
    public SceneProperties() {
        System.err.println("\n\nFATAL ERROR: SceneProperties empty constructor\n\n");
        System.exit(1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sceneWidthSpinner = new javax.swing.JSpinner();
        sceneHeightSpinner = new javax.swing.JSpinner();
        drawBackgroundCheckBox = new javax.swing.JCheckBox();
        backgroundColorPanel = new javax.swing.JPanel();

        jLabel1.setText("Width:");

        jLabel2.setText("Height:");

        sceneWidthSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(640), Integer.valueOf(1), null, Integer.valueOf(10)));
        sceneWidthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sceneWidthSpinnerStateChanged(evt);
            }
        });

        sceneHeightSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(480), Integer.valueOf(1), null, Integer.valueOf(10)));
        sceneHeightSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sceneHeightSpinnerStateChanged(evt);
            }
        });

        drawBackgroundCheckBox.setSelected(true);
        drawBackgroundCheckBox.setText("<html>Draw Background<br/>Color</html>");
        drawBackgroundCheckBox.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        drawBackgroundCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawBackgroundCheckBoxActionPerformed(evt);
            }
        });

        backgroundColorPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundColorPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        backgroundColorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundColorPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backgroundColorPanelLayout = new javax.swing.GroupLayout(backgroundColorPanel);
        backgroundColorPanel.setLayout(backgroundColorPanelLayout);
        backgroundColorPanelLayout.setHorizontalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        backgroundColorPanelLayout.setVerticalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(drawBackgroundCheckBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sceneHeightSpinner)
                            .addComponent(sceneWidthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sceneWidthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sceneHeightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawBackgroundCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void sceneWidthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sceneWidthSpinnerStateChanged
    if (!nochange) {
        editor.scene.setWidth((Integer) sceneWidthSpinner.getValue());
        editor.sea.update();
        editor.sea.paint();
        editor.setModified(true);
    }
}//GEN-LAST:event_sceneWidthSpinnerStateChanged

private void sceneHeightSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sceneHeightSpinnerStateChanged
    if (!nochange) {
        editor.scene.setHeight((Integer) sceneHeightSpinner.getValue());
        editor.sea.update();
        editor.sea.paint();
        editor.setModified(true);
    }
}//GEN-LAST:event_sceneHeightSpinnerStateChanged

private void backgroundColorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundColorPanelMouseClicked
    Color c = JColorChooser.showDialog(this, "Select color", editor.scene.getBackgroundColor());
    if (c != null) {
        editor.scene.setBackgroundColor(c);
        backgroundColorPanel.setBackground(c);
        editor.sea.forceUpdate();
        editor.sea.paint();
        editor.setModified(true);
    }
}//GEN-LAST:event_backgroundColorPanelMouseClicked

private void drawBackgroundCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawBackgroundCheckBoxActionPerformed
    if (!nochange) {
        editor.scene.setDrawBackgroundColor(drawBackgroundCheckBox.isSelected());
        editor.sea.forceUpdate();
        editor.sea.paint();
        editor.setModified(true);
    }
}//GEN-LAST:event_drawBackgroundCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundColorPanel;
    private javax.swing.JCheckBox drawBackgroundCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner sceneHeightSpinner;
    private javax.swing.JSpinner sceneWidthSpinner;
    // End of variables declaration//GEN-END:variables
}
