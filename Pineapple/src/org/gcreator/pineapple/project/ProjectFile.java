/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <serge@bobtheblueberry.com>

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
package org.gcreator.pineapple.project;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.tree.BaseTreeNode;
import org.gcreator.pineapple.tree.FileTreeNode;

/**
 * Stores a File and some information about it.
 * 
 * @author Serge Humphrey
 */
public class ProjectFile extends ProjectElement {

    protected BasicFile file;
    protected Icon icon;
    protected FileTreeNode treeNode;
    protected Project project;
    private static ImageIcon IMG;

    static {
        try {
            IMG = new ImageIcon(FileTreeNode.class.getResource("/org/gcreator/pineapple/resources/tree/img.png"));
        } catch (Exception e) { /*  ...  */ }
    }

    /**
     * Creates a new {@link ProjectFile} object and sets the format automatically.
     * 
     * @param file The {@link java.io.File} object.
     * @param p The {@link Project} that this file should belong to.
     */
    public ProjectFile(BasicFile file, Project p) {
        this(file, null, p);
    }

    /**
     * Creates a new {@link ProjectFile} object with an icon.
     * 
     * @param file file The {@link java.io.File} object.
     * @param icon The {@link javax.swing.Icon} to be drawn in the {@link javax.swing.JTree}.
     * @param p The {@link Project} that this file should belong to.
     */
    public ProjectFile(BasicFile file, Icon icon, Project p) {
        this.file = file;
        this.project = p;
        this.treeNode = new FileTreeNode(this);
        this.icon = icon;
        icon();
    }

    private void icon()
    {
        if (icon == null) {

            // Check for an image file and if so fix icon.
            for (String s : ImageIO.getReaderFileSuffixes()) {
                if (file.getName().toLowerCase().endsWith("." + s.toLowerCase())) {
                    icon = IMG;
                }
            }
        }
    }

    /**
     * Gets this file's format.
     * 
     * @return The file's format, or <tt>null</tt> if the file has no format.
     */
    public String getFormat() {
        return getFormat(this.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BasicFile getFile() {
        return file;
    }

    /**
     * Gets the icon.
     * 
     * @return The icon.
     */
    @Override
    public Icon getIcon() {
        return icon;
    }

    /**
     * Sets the file.
     * 
     * @param file The new File.
     */
    public void setFile(BasicFile file) {
        this.file = file;
    }

    /**
     * Sets the icon.
     * 
     * @param icon The new {@link javax.swing.Icon}.
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * Returns the same as the file's {@link java.io.File#getName()} method 
     * or the {@link java.lang.String} literal 'null' if the file is <tt>null</tt>.
     * 
     * @return The file's name or 'null'.
     */
    @Override
    public String toString() {
        return ((file != null) ? file.getName() : "null");
    }

    private static String getFormat(String file) {
        int i = file.lastIndexOf(".");
        if (i < 0 || i >= file.length()) {
            return null;
        }
        return file.substring(i + 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseTreeNode getTreeNode() {
        return treeNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getProject() {
        return project;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(Object o) {
        if (file == null || !(o instanceof ProjectElement)) {
            return 0;
        }
        return file.compareTo(((ProjectElement) o).getFile());
    }
}
