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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.gcreator.pineapple.editors.SceneEditor;
import org.gcreator.pineapple.formats.Scene;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Draws the components of scene.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class SceneEditorArea extends JPanel {

    private static final long serialVersionUID = -5905569070386863865L;
    public static final int MODE_ADD = 0;
    public static final int MODE_EDIT = 1;
    public static final int MODE_DELETE = 2;
    public int mode = MODE_ADD;
    public SceneEditor editor = null;
    public Scene.ActorInScene selection = null;
    protected HashMap<BasicFile, BufferedImage> imageCache;
    
    ActorProperties ap;
    private Point dragOffset;

    public SceneEditorArea(SceneEditor e) {
        this.editor = e;
        this.imageCache = new HashMap<BasicFile, BufferedImage>(2);

        this.addMouseListener(new MouseAdapter() {

            @Override
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
                        selection = a;
                        repaint();
                        editor.setModified(true);
                    }
                } else if (mode == MODE_EDIT) {
                    if (editor == null || editor.scene == null) {
                        return;
                    }
                    Scene s = editor.scene;
                    /* Select Actor */
                    Scene.ActorInScene oldSelection = selection;
                    selection = null;
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
                            selection = actor;
                            dragOffset = new Point(actor.x - x, actor.y - y);
                            break;
                        }
                    }
                    if (oldSelection != selection) {
                        editor.settingsPanel.removeAll();
                        if (selection != null) {
                            ap = new ActorProperties(selection, SceneEditorArea.this);
                            editor.settingsPanel.add(ap, BorderLayout.CENTER);
                        }
                        repaint();
                        editor.settingsPanel.updateUI();
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
                        selection = null;
                        editor.settingsPanel.removeAll();
                        editor.settingsPanel.repaint();
                        if (ap != null) {
                            ap.update();
                        }
                    }
                    repaint();
                }
            }
        });
        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (selection != null) {
                    selection.x = e.getX() + dragOffset.x;
                    selection.y = e.getY() + dragOffset.y;
                    editor.setModified(true);
                    repaint();
                }
            }
        });
    }

    @Override
    public int getWidth() {
        return editor.scene.getWidth();
    }

    @Override
    public int getHeight() {
        return editor.scene.getHeight();
    }

    @Override
    public Dimension getSize() {
        return new Dimension(getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return getSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return getSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getSize();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (editor == null || editor.scene == null) {
            return;
        }
        Scene s = editor.scene;
        if (s.isBackgroundColorDrawn()) {
            g.setColor(s.getBackgroundColor());
            g.fillRect(0, 0, s.getWidth(), s.getHeight());
        }
        drawBackgrounds(g);
        Collections.sort(s.actors);
        for (Scene.ActorInScene actor : s.actors) {
            BufferedImage i = actor.getImage();
            g.drawImage(i, actor.x, actor.y, null);
            if (actor == selection) {
                g.setColor(Color.YELLOW);
                g.drawRect(actor.x, actor.y, i.getWidth(), i.getHeight());
            }

        }
    }

    private void drawBackgrounds(Graphics g) {
        Scene s = editor.scene;
        for (Scene.Background b : s.backgrounds) {
            if (b.image == null) {
                continue;
            }
            BufferedImage img = getImage(b.image);
            if (img == null) {
                continue;
            }
            for (int yy = 0; b.y + (img.getHeight()*yy) < s.getHeight(); yy++) {
                for (int xx = 0; b.x + (img.getWidth()*xx) < s.getWidth(); xx++) {
                    g.drawImage(img, b.x + (img.getWidth()*xx), b.y + (img.getHeight()*yy), null);
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

    private BufferedImage getImage(BasicFile f) {
        if (!imageCache.containsKey(f)) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(f.getReader());
            } catch (IOException ex) {
                Logger.getLogger(SceneEditorArea.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (img != null) {
                imageCache.put(f, img);
            }
        }
        return imageCache.get(f);
    }
}
