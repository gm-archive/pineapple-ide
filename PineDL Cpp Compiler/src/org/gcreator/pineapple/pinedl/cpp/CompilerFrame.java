/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
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
package org.gcreator.pineapple.pinedl.cpp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Frame for compiler output
 * 
 * @author Luís Reis
 */
public class CompilerFrame extends javax.swing.JFrame {

    public class PineDLOutputStream extends OutputStream {

        public void write(int c) {
            if (c == '\n') {
                output.setText(output.getText() + "<br>\n");
            } else {
                output.setText(output.getText() + ((char) c));
            }
        }
    }

    public void writeLine(String s) {
        String txt = output.getText();
        output.setText(txt.substring(0, txt.indexOf("</body>")) + s.replaceAll("\n", "<br>\n") + "<br>\n");
    }
    GameCompiler c;

    /** Creates new form CompilerFrame */
    public CompilerFrame(GameCompiler c) {
        this.c = c;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        openFolderButton = new javax.swing.JButton();
        runGameButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 200));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        openFolderButton.setText("Open Folder");
        openFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderButtonActionPerformed(evt);
            }
        });
        jPanel1.add(openFolderButton);

        runGameButton.setText("Run Game");
        runGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runGameButtonActionPerformed(evt);
            }
        });
        jPanel1.add(runGameButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        output.setBackground(java.awt.Color.white);
        output.setContentType("text/html");
        output.setEditable(false);
        output.setText("<html><b>Compiling... </b><br/>");
        jScrollPane1.setViewportView(output);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderButtonActionPerformed
        String ap = c.binFolder.getAbsolutePath();
        if (tryRun("explorer", ap)) { // Windows
            return;
        }
        if (tryRun("nautilus", ap)) { //GNOME
            return;
        }
        if (tryRun("dolphin", ap)) { //KDE
            return;
        }
        if (tryRun("thunar", ap)) { // Xfce
            return;
        }
        if (tryRun("open", ap)) { // Mac OS X
            return;
        }
        JOptionPane.showMessageDialog(this,
                "No  file browser command to open " + ap);
}//GEN-LAST:event_openFolderButtonActionPerformed

    public boolean tryRun(String cmd1, String cmd2) {
        try {
            Runtime.getRuntime().exec(new String[]{cmd1, cmd2});
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void runGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runGameButtonActionPerformed
        if (c.profile == CompilationProfile.UNIX_TO_UNIX) {
            ProcessBuilder b = new ProcessBuilder("/bin/sh", "rungame.sh");
            b.directory(c.binFolder);
            try {
                b.start();
            } catch (IOException ex) {
                Logger.getLogger(CompilerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (c.profile == CompilationProfile.WINDOWS_TO_WINDOWS) {
            ProcessBuilder b = new ProcessBuilder("game.exe");
            b.directory(c.binFolder);
            try {
                b.start();
            } catch (IOException ex) {
                Logger.getLogger(CompilerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Unknown Profile: " + c.profile);
        }
}//GEN-LAST:event_runGameButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openFolderButton;
    private javax.swing.JEditorPane output;
    private javax.swing.JButton runGameButton;
    // End of variables declaration//GEN-END:variables
}
