/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge_1994@hotmail.com>

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Collections;
import javax.swing.JPanel;
import org.gcreator.editors.SceneEditor;
import org.gcreator.formats.Scene;
import org.gcreator.project.io.BasicFile;

/**
 * Draws the actors(and tiles, in the future)
 * @author Luís Reis
 */
public class SceneEditorArea extends JPanel {

    private static final long serialVersionUID = -5905569070386863865L;
    public static final int MODE_ADD = 0;
    public static final int MODE_EDIT = 1;
    public static final int MODE_DELETE = 2;
    public int mode = MODE_ADD;
    public SceneEditor sceneEditor = null;
    public Scene.ActorInScene selection = null;

    public SceneEditorArea() {
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                if (mode == MODE_ADD) {
                    BasicFile f = sceneEditor.actorChooser.getSelectedFile();
                    if (f != null) {
                        Scene s = sceneEditor.s;
                        Scene.ActorInScene a = new Scene.ActorInScene();
                        a.bf = f;
                        a.x = evt.getX();
                        a.y = evt.getY();
                        s.actors.add(a);
                        selection = a;
                        repaint();
                    }
                }
                else if (mode == MODE_EDIT) {
                    if (sceneEditor == null || sceneEditor.s == null) {
                        return;
                    }
                    Scene s = sceneEditor.s;
                    Scene.ActorInScene oldSelection = selection;
                    selection = null;
                    for (Scene.ActorInScene actor : s.actors) {
                        BufferedImage i = actor.getImage();
                        if(i==null){ continue; }
                        int x = evt.getX();
                        int y = evt.getY();
                        if(x<actor.x){ continue; }
                        if(y<actor.y){ continue; }
                        if(x<actor.x+i.getWidth()&&y<actor.y+i.getHeight()){
                            selection = actor;
                        }
                    }
                    if(oldSelection!=selection){
                        sceneEditor.jPanel1.removeAll();
                        if(selection==null){
                            sceneEditor.jPanel1.add(sceneEditor.sp, BorderLayout.CENTER);
                        }
                        else{
                            ActorProperties ap = new ActorProperties(selection, SceneEditorArea.this);
                            sceneEditor.jPanel1.add(ap, BorderLayout.CENTER);
                        }
                        repaint();
                        sceneEditor.jPanel1.updateUI();
                    }
                }
                else if(mode==MODE_DELETE){
                    if (sceneEditor == null || sceneEditor.s == null) {
                        return;
                    }
                    Scene s = sceneEditor.s;
                    Scene.ActorInScene chosen = null;
                    for (Scene.ActorInScene actor : s.actors) {
                        BufferedImage i = actor.getImage();
                        if(i==null){ continue; }
                        int x = evt.getX();
                        int y = evt.getY();
                        if(x<actor.x){ continue; }
                        if(y<actor.y){ continue; }
                        if(x<actor.x+i.getWidth()&&y<actor.y+i.getHeight()){
                            chosen = actor;
                        }
                    }
                    s.actors.remove(chosen);
                    if(selection==chosen){
                        selection = null;
                        sceneEditor.jPanel1.removeAll();
                        sceneEditor.jPanel1.add(sceneEditor.sp, BorderLayout.CENTER);
                        sceneEditor.jPanel1.repaint();
                    }
                    repaint();
                }
            }
        });
        addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(selection!=null){
                    selection.x = e.getX();
                    selection.y = e.getY();
                    repaint();
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        if (sceneEditor == null) {
            return new Dimension(1, 1);
        }
        Scene scene = sceneEditor.s;
        return new Dimension(scene.width, scene.height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (sceneEditor == null || sceneEditor.s == null) {
            return;
        }
        Scene s = sceneEditor.s;
        g.setColor(s.bgColor);
        g.fillRect(0, 0, s.width, s.height);
        Collections.sort(s.actors);
        for (Scene.ActorInScene actor : s.actors) {
            BufferedImage i = actor.getImage();
            if (i != null) {
                g.drawImage(i, actor.x, actor.y, null);
            }
            if (actor == selection && mode == MODE_EDIT) {
                g.setColor(Color.YELLOW);
                g.drawRect(actor.x, actor.y, i.getWidth(), i.getHeight());
            }
        }
    }
}
