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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Collections;
import javax.swing.JPanel;
import org.gcreator.pineapple.editors.SceneEditor;
import org.gcreator.pineapple.formats.Scene;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.util.ListeningVector;
import org.gcreator.pineapple.util.VectorChangeListener;

/**
 * Draws the components of scene.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class SceneEditorArea extends JPanel implements VectorChangeListener {

    private static final long serialVersionUID = -5905569070386863865L;
    public static final int MODE_ADD = 0;
    public static final int MODE_EDIT = 1;
    public static final int MODE_DELETE = 2;
    public int mode = MODE_ADD;
    public SceneEditor editor = null;
    private Scene.ActorInScene selection = null;
    protected BufferedImage actorCache = null;
    protected BufferedImage backgroundCache = null;
    private BufferedImage cache = null;
    private BufferedImage buffer;
    private Scene.ActorInScene notRendered;
    private volatile long lastRenderC = -1L;
    private volatile long lastRenderO = -1L;
    private volatile long lastRenderP = -1L;
    private volatile long lastRenderU = -1L;
    ActorProperties ap;
    private Point dragOffset;
    private boolean sorting = false;

    /**
     * Creates a new {@link SceneEditorArea}
     * and initializes it.
     *
     * @param e The {@link SceneEditor} which 
     * this scene area should belong to.
     *
     */
    public SceneEditorArea(SceneEditor e) {
        super(false);
        this.editor = e;
        this.actorCache = newCache();
        this.backgroundCache = newCache();
        this.buffer = newCache();
        this.cache = newCache();
        /* Sort actors by depth */
        vectorChanged(editor.scene.actors);
        editor.scene.actors.addListener(this);

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                SceneEditorArea.this.mousePressed(evt);
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                SceneEditorArea.this.mouseDragged(e);
            }
        });

        update();
    }

    @Override
    public void paint(Graphics pg) {
        if (backgroundCache == null || actorCache == null) {
            return;
        }
        if (lastRenderO >= lastRenderC) {
            renderCache();
        }
        Scene s = editor.scene;
        if (buffer == null) {
            buffer = newCache();
            lastRenderP = -1L;
        }
        if (lastRenderC >= lastRenderP || lastRenderU >= lastRenderP) {
            Graphics2D g = buffer.createGraphics();
            g.setColor(this.getBackground());
            if (s.isBackgroundColorDrawn()) {
                g.setColor(s.getBackgroundColor());
                g.fillRect(0, 0, s.getWidth(), s.getHeight());
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, s.getWidth(), s.getHeight());
            }
            g.drawImage(cache, 0, 0, null);

            /* Draw selected actor. */
            if (selection != null) {
                BufferedImage i = selection.getImage();
                g.drawImage(i, selection.x, selection.y, null);
                g.setColor(Color.YELLOW);
                g.drawRect(selection.x, selection.y, i.getWidth(), i.getHeight());
            }

            g.dispose();
            lastRenderP = System.currentTimeMillis();
        }
        if (pg != null) {
            pg.drawImage(buffer, 0, 0, null);
        }
    }

    public void paint() {
        paint(this.getGraphics());
    }

    private void drawBackgrounds(Graphics g) {
        Scene s = editor.scene;
        for (Scene.Background b : s.backgrounds) {
            if (!b.drawImage) {
                continue;
            }
            if (b.image == null) {
                continue;
            }
            BufferedImage img = b.getImage();
            if (img == null) {
                continue;
            }
            for (int yy = 0; b.y + (img.getHeight() * yy) < s.getHeight(); yy++) {
                for (int xx = 0; b.x + (img.getWidth() * xx) < s.getWidth(); xx++) {
                    g.drawImage(img, b.x + (img.getWidth() * xx), b.y + (img.getHeight() * yy), null);
                    if (!b.hrepeat) {
                        break;
                    }
                }
                if (!b.vrepeat) {
                    break;
                }
            }
        }
    }

    private BufferedImage newCache() {
        return new BufferedImage(editor.scene.getWidth(), editor.scene.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }

    public void renderActorCache() {
        Graphics2D g = actorCache.createGraphics();
        /* Clear Image */
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setComposite(AlphaComposite.SrcOver);


        notRendered = selection;
        /* Draw backwards because biggest depth ones are at the end of the vector. */
        for (int i = editor.scene.actors.size() - 1; i >= 0; i--) {
            Scene.ActorInScene actor = editor.scene.actors.get(i);
            /* Don't draw selected actor because it moves too much */
            if (actor == selection) {
                continue;
            }
            BufferedImage img = actor.getImage();
            g.drawImage(img, actor.x, actor.y, null);
        }
        g.dispose();

        lastRenderO = System.currentTimeMillis();
    }

    public void renderBackgroundCache() {
        if (editor == null || editor.scene == null) {
            return;
        }
        Graphics2D g = backgroundCache.createGraphics();
        /* Clear Image */
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setComposite(AlphaComposite.SrcOver);

        drawBackgrounds(g);

        g.dispose();

        lastRenderO = System.currentTimeMillis();
    }

    public void renderCache() {
        Graphics2D g = cache.createGraphics();
        /* Clear Cache */
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setComposite(AlphaComposite.SrcOver);

        g.drawImage(backgroundCache, 0, 0, null);
        g.drawImage(actorCache, 0, 0, null);
        g.dispose();
        lastRenderC = System.currentTimeMillis();
    }

    /**
     * Re-renders caches and syncs the size of the
     * scene editor area with the actual scene object.
     */
    public void update() {
        if (editor == null || editor.scene == null) {
            return;
        }
        Dimension size = new Dimension(editor.scene.getWidth(), editor.scene.getHeight());
        this.setSize(size);
        this.setPreferredSize(size);
        this.setMinimumSize(size);

        if (actorCache == null || getWidth() != actorCache.getWidth() || getHeight() != actorCache.getHeight()) {
            actorCache = newCache();
        }
        if (backgroundCache == null || getWidth() != backgroundCache.getWidth() || getHeight() != backgroundCache.getHeight()) {
            backgroundCache = newCache();
        }
        if (cache == null || getWidth() != cache.getWidth() || getHeight() != cache.getHeight()) {
            cache = newCache();
        }
        if (buffer == null || getWidth() != buffer.getWidth() || getHeight() != buffer.getHeight()) {
            buffer = newCache();
        }
        renderActorCache();
        renderBackgroundCache();
        renderCache();
    }

    public void mousePressed(MouseEvent evt) {
        if (evt.getButton() != MouseEvent.BUTTON1) {
            return;//TODO: right-clicking
        }

        if (mode == MODE_ADD) {
            BasicFile f = editor.actorChooser.getSelectedFile();
            if (f != null) {
                Scene s = editor.scene;
                Scene.ActorInScene a = new Scene.ActorInScene(f);
                a.x = evt.getX();
                a.y = evt.getY();
                s.actors.add(a);
                setSelection(a);
                //need to re-render actors now.
                renderActorCache();
                paint();
                editor.setModified(true);
            }
        } else if (mode == MODE_EDIT) {
            if (editor == null || editor.scene == null) {
                return;
            }
            Scene s = editor.scene;
            /* Select Actor */
            Scene.ActorInScene oldSelection = selection;
            setSelection(null);
            int x = evt.getX();
            int y = evt.getY();
            for (Scene.ActorInScene actor : s.actors) {
                BufferedImage i = actor.getImage();
                if (i == null) {
                    continue;
                }
                if (x < actor.x) {
                    continue;
                }
                if (y < actor.y) {
                    continue;
                }
                if (x < actor.x + i.getWidth() && y < actor.y + i.getHeight()) {
                    setSelection(actor);
                    dragOffset = new Point(actor.x - x, actor.y - y);
                    break;
                }
            }
            if (oldSelection != selection) {
                //Might not need to re-render actors
                if (notRendered != null) {
                    renderActorCache();
                    renderCache();
                }
                lastRenderU = System.currentTimeMillis();
                paint();
            }
        } else if (mode == MODE_DELETE) {
            if (editor == null || editor.scene == null) {
                return;
            }
            Scene s = editor.scene;
            Scene.ActorInScene chosen = null;
            for (Scene.ActorInScene actor : s.actors) {
                BufferedImage i = actor.getImage();
                if (i == null) {
                    continue;
                }
                int x = evt.getX();
                int y = evt.getY();
                if (x < actor.x) {
                    continue;
                }
                if (y < actor.y) {
                    continue;
                }
                if (x < actor.x + i.getWidth() && y < actor.y + i.getHeight()) {
                    chosen = actor;
                    break;
                }
            }
            s.actors.remove(chosen);
            editor.setModified(true);
            if (selection == chosen) {
                setSelection(null);
                if (ap != null) {
                    ap.update();
                }
            }
            //Need to render actors again
            renderActorCache();
            paint();
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (selection != null) {
            selection.x = e.getX() + dragOffset.x;
            selection.y = e.getY() + dragOffset.y;
            editor.setModified(true);
            // may need to render actors 
            if (selection != notRendered) {
                renderActorCache();
                renderCache();
            }
            lastRenderU = System.currentTimeMillis();
            paint();
        }
    }

    /**
     * Forces buffer to be re-drawn next time this
     * scene editor area is painted.
     */
    public void forceUpdate() {
        lastRenderU = System.currentTimeMillis();
    }

    /**
     * Gets the selected actor, or <tt>null</tt> if
     * no actor is currently selected.
     *
     * @return The selected actor.
     */
    public Scene.ActorInScene getSelection() {
        return selection;
    }

    /**
     * Sets the selected actor. Not that this <strong>does not</strong>
     * repaint the scene or update any buffers.
     *
     * @param actor The new actor to be selected. May be <tt>null</tt>.
     */
    public void setSelection(Scene.ActorInScene actor) {
        this.selection = actor;
        int index = (actor != null) ? editor.scene.actors.indexOf(actor) : -1;
        editor.actorList.setSelectedIndex(index);
        if (index >= 0) {
            editor.actorList.ensureIndexIsVisible(index);
        }
        editor.setActorTabEnabled(actor != null);
        if (actor == null) {
            editor.actorPanel.setVisible(false);
        } else {
            editor.actorPanel.setActor(actor);
            editor.actorPanel.setVisible(true);
        }
    }

    public void vectorChanged(ListeningVector v) {
        if (sorting) {
            return;
        }
        synchronized (v) {
            sorting = true;
            Collections.sort(v);
            sorting = false;
        }
    }
}
