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

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * DocumentPane is the most basic unit of file editing.
 * 
 * @author Luís Reis
 */
public abstract class DocumentPane extends JPanel {

    private static final long serialVersionUID = 1L;
    protected BasicFile file;
    protected boolean modified;
    protected Project project;
    
    /**
     * Creates a DocumentPane for a specific file
     * and sets the project to the currently opened project.
     * 
     * @param file The file.
     */
    public DocumentPane(BasicFile file) {
        this(file, (file.getElement() == null) ? null : PineappleCore.getProject());
    }

    /**
     * Creates a DocumentPane for a specific file
     * and sets project for this document.
     * 
     * @param file The file.
     * @param p The {@link Project} to which this document
     * is part of. May be <tt>null</tt>.
     */
    public DocumentPane(BasicFile file, Project p) {
        this.file = file;
        this.project = p;
    }
    
    /**
     * @return The file that this pane edits.
     */
    public BasicFile getFile() {
        return file;
    }

    /**
     * Saves the file using any necessary
     * graphical user interface requests.
     * <br/><br/>
     * <strong>NOTE:</strong><br/>
     * You can not override this method, you must override {@link #saveBackend()}.
     *
     * @return Whether or not the file was saved.
     */
    public final boolean save() {
        if (file == null) {
            if (!saveas()) {
                return false;
            }
            setModified(false);
            updateUI();
        }
        if (saveBackend()) {
            setModified(false);
            updateUI();
            return true;
        }
        return false;
    }

    /**
     * Saves the backend with no interface requests.
     * @return Wheather the save was successful.
     */
    public boolean saveBackend() {
        return false;
    }

    /**
     * Saves the file with a new location.
     * @return Whether save was sucessful or not.
     */
    public boolean saveas() {
        return false;
    }

    /**
     * Sets the content of the 'edit' menu.
     * @param editMenu The 'edit' menu
     * @return Whether or not the edit menu should be disabled.
     */
    public boolean setupEditMenu(JMenu editMenu) {
        return false;
    }

    /**
     * @return Whether or not the file was modified.
     */
    public final boolean isModified() {
        return modified;
    }

    /**
     * Sets whether or not the file was modified.
     * @param modified Whether or not the file was modified.
     */
    public void setModified(boolean modified) {
        this.modified = modified;
        if (PineappleGUI.dip.getSelectedDocument() == this) {
            PineappleGUI.fileSave.setEnabled(canSave());
        }
        PineappleGUI.dip.updateUI();
    }

    /**
     * @return whether or not the file can be saved.
     */
    public boolean canSave() {
        return isModified();
    }

    /**
     * @return The title of the document.
     */
    public String getTitle() {
        String title = "";
        BasicFile f = null;
        f = getFile();
        if (f == null) {
            title = "untitled";
        } else {
            title = f.getName();
        }
        if (isModified()) {
            title += "*";
        }
        return title;
    }

    /**
     * Destroys, but asks whether or not to save the document first.
     * @return whether or not is was disposed.
     */
    public boolean dispose() {
        if (canSave()) {
            String title = getTitle();
            int res = JOptionPane.showConfirmDialog(Core.getStaticContext().getMainFrame(),
                    "Do you wish to save document " + "\"" + title.substring(0, title.length() - 1) + "\" before closing?");
            if (res == JOptionPane.CANCEL_OPTION) {
                return false;
            }
            if (res == JOptionPane.YES_OPTION) {
                if (!save()) {
                    return false; //If can not save, then do not close
                }
            }
        }
        PineappleGUI.dip.remove(this);
        return true;
    }

    /**
     * Gets the {@link Project} which this {@link DocumentPane} belongs to,
     * or <tt>null</tt> if it does not belong to any project.
     *
     * @return The {@link Project} that this document belongs to,
     * or null if it is belongs to no project.
     */
    public Project getProject() {
        return project;
    }
}
