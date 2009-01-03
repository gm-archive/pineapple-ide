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
package org.gcreator.editors;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.gcreator.actions.ActionType;
import org.gcreator.dnd.PaletteAction;
import org.gcreator.formats.Actor;
import org.gcreator.game2d.PaletteUser;
import org.gcreator.gui.BehaviorPanel;
import org.gcreator.gui.DocumentPane;
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
    private BehaviorPanel behavior;
    private CardLayout clayout = new CardLayout();
    
    /**
     * Creates a new ActorEditor
     * 
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
        behavior = new BehaviorPanel(actor, this);
        behavior.setVisible(true);
        this.setModified(true);
        spriteChooser.setResourceValidator(new ImageValidator());
        depthSpinner.setValue(actor.z);
        depthSpinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                actor.z = (Integer) depthSpinner.getValue();
            }
        });
        view.add(behavior, "behavior");
        spriteChooser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Changed image");
                actor.image = spriteChooser.getSelectedFile();
            }
        });
        spriteChooser.setSelectedFile(actor.image);
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
        view = new javax.swing.JPanel();
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

        view.setLayout(clayout = new java.awt.CardLayout());
        /*
        view.setLayout(new java.awt.CardLayout());
        */

        propertiesPanel.setMaximumSize(new java.awt.Dimension(100, 218));
        propertiesPanel.setMinimumSize(new java.awt.Dimension(100, 218));
        propertiesPanel.setPreferredSize(new java.awt.Dimension(100, 218));

        inGameRenderingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("In-Game Rendering"));

        depthSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(5)));

        depthLabel.setText("Depth (z):");

        renderSpriteCheckBox.setSelected(true);
        renderSpriteCheckBox.setText("Render sprite automatically");
        renderSpriteCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        renderSpriteCheckBox.setOpaque(true);

        spriteLabel.setText("Sprite:");

        javax.swing.GroupLayout inGameRenderingPanelLayout = new javax.swing.GroupLayout(inGameRenderingPanel);
        inGameRenderingPanel.setLayout(inGameRenderingPanelLayout);
        inGameRenderingPanelLayout.setHorizontalGroup(
            inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addComponent(spriteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spriteChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addComponent(depthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(renderSpriteCheckBox)))
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

        isClassFinalCheckBox.setText("Barren");
        isClassFinalCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        isClassFinalCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout polymorhpismPanelLayout = new javax.swing.GroupLayout(polymorhpismPanel);
        polymorhpismPanel.setLayout(polymorhpismPanelLayout);
        polymorhpismPanelLayout.setHorizontalGroup(
            polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                .addGroup(polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                        .addComponent(parentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parentChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(isClassFinalCheckBox))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        polymorhpismPanelLayout.setVerticalGroup(
            polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                .addGroup(polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(parentLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parentChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isClassFinalCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout propertiesPanelLayout = new javax.swing.GroupLayout(propertiesPanel);
        propertiesPanel.setLayout(propertiesPanelLayout);
        propertiesPanelLayout.setHorizontalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesPanelLayout.createSequentialGroup()
                .addGroup(propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(polymorhpismPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inGameRenderingPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        propertiesPanelLayout.setVerticalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesPanelLayout.createSequentialGroup()
                .addComponent(inGameRenderingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(polymorhpismPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        view.add(propertiesPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void propertiesToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesToggleActionPerformed
    clayout.first(view);
}//GEN-LAST:event_propertiesToggleActionPerformed

private void membersToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersToggleActionPerformed
    clayout.last(view);
}//GEN-LAST:event_membersToggleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel depthLabel;
    private javax.swing.JSpinner depthSpinner;
    private javax.swing.JPanel inGameRenderingPanel;
    private javax.swing.JCheckBox isClassFinalCheckBox;
    private javax.swing.JToggleButton membersToggle;
    private org.gcreator.gui.ResourceChooser parentChooser;
    private javax.swing.JLabel parentLabel;
    private javax.swing.JPanel polymorhpismPanel;
    private javax.swing.JPanel propertiesPanel;
    private javax.swing.JToggleButton propertiesToggle;
    private javax.swing.JCheckBox renderSpriteCheckBox;
    private org.gcreator.gui.ResourceChooser spriteChooser;
    private javax.swing.JLabel spriteLabel;
    private javax.swing.ButtonGroup toggles;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel view;
    // End of variables declaration//GEN-END:variables

}
