/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bobtheblueberry@gmail.com>

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

/**
 * Provides a way to display documents, such as a tabbed pane or MDI view.
 * 
 * @author Luís Reis
 */
public interface DocumentInterfaceProvider {

    /**
     * Adds a new DocumentPane
     * @param title The title to be used
     * @param doc The DocumentPane to be added
     */
    public void add(String title, DocumentPane doc);

    /**
     * Gets the DocumentPane at a given index
     * 
     * @param i The index to be retrieved.
     * @return The DocumentPane at a given index.
     */
    public DocumentPane getDocumentAt(int i);

    /**
     * Gets the number of documents.
     * 
     * @return The number of documents.
     */
    public int getDocumentCount();

    /**
     * Gets the index of the selected document.
     * 
     * @return The index of the selected document.
     */
    public int getSelectedIndex();

    /**
     * Gets the selected document.
     * 
     * @return The selected document, or <tt>null</tt>
     * if not document is selected.
     */
    public DocumentPane getSelectedDocument();

    /**
     * Sets the selected index. If that index has no equivalent
     * DocumentPane, then either none will be selected, or this method will
     * be ignored.
     * @param index The index to select
     * 
     * @see DefaultEventTypes#FILE_CHANGED
     */
    public void setSelectedIndex(int index);

    /**
     * Gets the title of the document at the given index.
     * 
     * @param index The index.
     * 
     * @return Gets the title of the document at the given index.
     */
    public String getTitleAt(int index);

    /**
     * Gets the index of a document.
     * 
     * @param pane The document.
     * @return The index of the given index.
     */
    public int getDocumentIndex(DocumentPane pane);

    /**
     * Sets the title of the document at the given index
     * @param index The index
     * @param title The new document title
     */
    public abstract void setTitleAt(int index, String title);

    /**
     * Removes the document at the given index.
     * 
     * @param index The index.
     */
    public void removeDocumentAt(int index);

    /**
     * Remove a given {@link DocumentPane}.
     * 
     * @param pane The {@link DocumentPane}.
     */
    public void remove(DocumentPane pane);

    /**
     * Gets the documents that this provider has open.
     * 
     * @return An array of the documents.
     */
    public DocumentPane[] getDocuments();
    
    /**
     * Updates the providers UI, assuming that it is
     * a Swing component.
     */
    public void updateUI();
}
