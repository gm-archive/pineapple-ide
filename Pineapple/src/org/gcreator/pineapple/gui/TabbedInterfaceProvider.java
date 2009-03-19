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

import java.util.HashMap;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventHandler;
import org.noos.xing.mydoggy.Content;
import org.noos.xing.mydoggy.ContentManagerListener;
import org.noos.xing.mydoggy.event.ContentManagerEvent;
import org.noos.xing.mydoggy.plaf.MyDoggyContentManager;
import org.noos.xing.mydoggy.plaf.ui.content.MyDoggyTabbedContentManagerUI;

/**
 * Provides a tabbed document interface provider.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class TabbedInterfaceProvider implements DocumentInterfaceProvider, ContentManagerListener {

    private static final long serialVersionUID = 1L;
    protected MyDoggyContentManager content;
    protected HashMap<DocumentPane, Content> contentMap;

    /**
     * Creates a new TabbedInterfaceProvider.
     */
    public TabbedInterfaceProvider() {
        contentMap = new HashMap<DocumentPane, Content>();
        content = (MyDoggyContentManager) PineappleGUI.manager.getContentManager();
        content.setContentManagerUI(new MyDoggyTabbedContentManagerUI());
        ((MyDoggyTabbedContentManagerUI)content.getContentManagerUI()).setShowAlwaysTab(true);
        content.addContentManagerListener(this);
        EventManager.addEventHandler(new EventHandler() {

            @Override
            public void handleEvent(Event event) {
                updateUI();
            }
        }, PineappleGUI.FILE_RENAMED);
    }

    @Override
    public int getDocumentCount() {
        return contentMap.size();
    }

    @Override
    public DocumentPane getDocumentAt(int index) {
        try {
            return (DocumentPane) content.getContent(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public void add(final String title, final DocumentPane pane) {
        DocumentPaneContent c = new DocumentPaneContent(content, pane);
        content._addContent(c);
        contentMap.put(pane, c);
        this.setSelectedIndex(this.getDocumentIndex(pane));
    }

    /**
     * Gets the selected document.
     */
    @Override
    public DocumentPane getSelectedDocument() {
        if (content.getSelectedContent() == null) {
            return null;
        }
        for (DocumentPane d : contentMap.keySet()) {
            if (contentMap.get(d) == content.getSelectedContent()) {
                return d;
            }
        }
        return null;
    }

    @Override
    public void removeDocumentAt(int index) {
        Content c = content.getContent(index);
        if (c == null) {
            return;
        }
        for (DocumentPane d : contentMap.keySet()) {
            if (contentMap.get(d) == c) {
                contentMap.remove(d);
                break;
            }
        }
        content.removeContent(index);
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(DocumentPane pane) {
        if (pane == null) {
            return;
        }
        Content c = contentMap.get(pane);
        if (c == null) {
            return;
        }
        contentMap.remove(pane);
        content.removeContent(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDocumentIndex(DocumentPane pane) {
        Content c = contentMap.get(pane);
        for (int i = 0; i < content.getContentCount(); i++) {
            if (c == content.getContents()[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public DocumentPane[] getDocuments() {
        DocumentPane[] panes = new DocumentPane[this.getDocumentCount()];
        int i = 0;
        for (DocumentPane p : contentMap.keySet()) {
            panes[i++] = p;
        }
        return panes;
    }

    @Override
    public int getSelectedIndex() {
        int i = 0;
        for (Content c : contentMap.values()) {
            if (c == content.getSelectedContent()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public void setSelectedIndex(int index) {
        MyDoggyTabbedContentManagerUI ui = ((MyDoggyTabbedContentManagerUI) content.getContentManagerUI());
        ui.setSelected(content.getContent(index), true);
    }

    @Override
    public String getTitleAt(int index) {
        return content.getContent(index).getTitle();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void setTitleAt(int index, String title) {
        Content c = content.getContent(index);
        if (c == null) {
            return;
        }
        c.setTitle(title);
    }

    
    @Override
    public void updateUI() {
        ((MyDoggyTabbedContentManagerUI)content.getContentManagerUI()).updateUI();
    }

    @Override
    public void contentAdded(ContentManagerEvent event) {
    }

    @Override
    public void contentRemoved(ContentManagerEvent event) {
        Content c = event.getContent();
        if (contentMap.containsValue(c)) {
            for (DocumentPane d : contentMap.keySet()) {
                if (contentMap.get(d) == c) {
                    contentMap.remove(d);
                    break;
                }
            }
        }
    }

    @Override
    public void contentSelected(ContentManagerEvent event) {
    }
}
