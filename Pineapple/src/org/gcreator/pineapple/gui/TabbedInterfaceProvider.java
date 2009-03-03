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
package org.gcreator.pineapple.gui;

import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 * Provides a tabbed document interface provider.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class TabbedInterfaceProvider extends JTabbedPane implements DocumentInterfaceProvider {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new TabbedInterfaceProvider.
     */
    public TabbedInterfaceProvider() {
        PineappleGUI.manager.setMainContent(this);
    }

    @Override
    public int getDocumentCount() {
        return this.getTabCount();
    }

    @Override
    public DocumentPane getDocumentAt(int index) {
        try {
            return (DocumentPane) super.getComponentAt(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public void add(final String title, final DocumentPane pane) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                addTab(title, pane);
                int index = indexOfComponent(pane);
                setTabComponentAt(index, new TabRenderer(TabbedInterfaceProvider.this));
                setSelectedIndex(index);
            }
        });
    }

    /**
     * Gets the selected document.
     */
    @Override
    public DocumentPane getSelectedDocument() {
        return (DocumentPane) super.getSelectedComponent();
    }

    @Override
    public void removeDocumentAt(int index) {
        super.remove(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(DocumentPane pane) {
        super.remove(pane);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDocumentIndex(DocumentPane pane) {
        return super.indexOfComponent(pane);
    }

    @Override
    public DocumentPane[] getDocuments() {
        DocumentPane[] p = new DocumentPane[this.getDocumentCount()];
        for (int i = 0; i < p.length; i++) {
            p[i] = getDocumentAt(i);
        }
        return p;
    }
}
