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

import java.io.File;
import javax.swing.SwingUtilities;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFolder;
import org.gcreator.project.io.BasicFile;

/**
 * This dialog allows the user to copy a {@link  java.io.File}
 * to a folder in the project.
 * 
 * @author  Serge Humphrey
 */
public final class CopyFileDialog extends javax.swing.JDialog {
    
    private static final long serialVersionUID = 1L;
    private ProjectFolder folder;
    private Project project;
    private File file;
    private String type;
    private BasicFile result;
    
    /** 
     * Creates and shows a new CopyFileDialog.
     * 
     * @param parent The parent window for the dialog.
     * @param p Thhe project the copy the file to.
     * @param file The file to copy.
     * @param title The title for the dialog.
     * @param folder The {@link ProjectFolder} to be set as the default folder.
     * May be <tt>null</tt>.
     * @param allowChange Whether to allow the user to change the project folder.
     */
    public CopyFileDialog(java.awt.Window parent, Project p, File file, String title, ProjectFolder folder, boolean allowChange) {
        super(parent, title, ModalityType.APPLICATION_MODAL);
        this.folder = folder;
        this.project = p;
        this.file = file;
        initComponents();
        browseButton.setEnabled(allowChange);
        locationTextField.setText((folder == null) ? "/" : folder.getFile().getPath());
        String name = file.getName();
        
        int i = name.lastIndexOf('.');
        String fname;
        if (i < 0) {
            type = null;
            fname = name;
            fileTypeLabel.setText(null);
        } else if (i == name.length()) {
            type = "";
            fname = name;
            fileTypeLabel.setText(".");
        } else {
            type = name.substring(i+1);
            fname = name.substring(0, i);
            fileTypeLabel.setText("." + type);
        }
        fileNameTextField.setText(fname);
        this.setVisible(true);
    }
    
    /**
     * @return The file that was created when the file was copied,
     * or <tt>null</tt> if the user canceled the action.
     */
    public BasicFile getCreatedFile() {
        return result;
    }
    
    private void checkFinish() {
        
        String text = fileNameTextField.getText();
        if (text.contains(".")) {
            if (text.equals(".")) {
                text = "";
            } else {
                text = text.substring(0, text.indexOf('.') - 1);
            }

            final String fText = text;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    fileNameTextField.setText(fText);
                }
            });
        }
        if (text.equals("") || text.contains("\\") || text.contains("/")) {
            finishButton.setEnabled(false);
            setError("Invalid File Name");
            return;
        }
        String rfname;
        if (type != null) {
            rfname = text + "." + type;
        } else {
            rfname = text;
        }
        if (folder == null) {
            for (ProjectElement e : project.getFiles()) {
                if (e.getName().equals(rfname)) {
                    finishButton.setEnabled(false);
                    setError("File already exists.");
                    return;
                }
            }
        } else {
            for (ProjectElement e : folder.getChildren()) {
                if (e.getName().equals(rfname)) {
                    finishButton.setEnabled(false);
                    setError("File already exists.");
                    return;
                }
            }
        }
        setError("");
        finishButton.setEnabled(true);
    }
    
    private void setError(String msg) {
        errorLabel.setText("<html><span style=\"color: red; font-weight: bold;\">" + msg +
                "</span></html>");
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
        jLabel3 = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        locationTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        finishButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        fileTypeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><strong>Copy File to Project</strong></html>");

        jLabel2.setText("New File Name:");

        jLabel3.setText("Project Folder:");

        fileNameTextField.setText("Bob");
        fileNameTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fileNameTextFieldCaretUpdate(evt);
            }
        });
        fileNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNameTextFieldActionPerformed(evt);
            }
        });

        locationTextField.setEditable(false);
        locationTextField.setText("/");

        browseButton.setText("Browse...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        errorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        finishButton.setText("Finish");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        fileTypeLabel.setText(".bob");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(locationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(browseButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(fileTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileTypeLabel))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(browseButton)
                    .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    dispose();
}//GEN-LAST:event_cancelButtonActionPerformed

private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
    folder = SelectFolderTree.showFolderDialog(project, this, "Select Folder");
    locationTextField.setText((folder == null) ? "/" : folder.getFile().getPath());
}//GEN-LAST:event_browseButtonActionPerformed

private void fileNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameTextFieldActionPerformed
    checkFinish();
}//GEN-LAST:event_fileNameTextFieldActionPerformed

private void fileNameTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fileNameTextFieldCaretUpdate
    checkFinish();
}//GEN-LAST:event_fileNameTextFieldCaretUpdate

private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        result = project.getManager().moveFileToProject(file, folder, fileNameTextField.getText() + ((type != null) ? "." + type : ""));
        dispose();
}//GEN-LAST:event_finishButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JLabel fileTypeLabel;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField locationTextField;
    // End of variables declaration//GEN-END:variables

}
