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
public class SceneEditorArea extends JPanel{
    private static final long serialVersionUID = -5905569070386863865L;
    
    public static final int MODE_ADD = 0;
    
    public int mode = MODE_ADD;
    public SceneEditor sceneEditor = null;
    
    public SceneEditorArea(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                if(mode==MODE_ADD){
                    BasicFile f = sceneEditor.actorChooser.getSelectedFile();
                    if(f!=null){
                        Scene s = sceneEditor.s;
                        Scene.ActorInScene a = new Scene.ActorInScene();
                        a.bf = f;
                        a.x = evt.getX();
                        a.y = evt.getY();
                        s.actors.add(a);
                        repaint();
                    }
                }
            }
        });
    }
    
    @Override
    public Dimension getPreferredSize(){
        if(sceneEditor==null){
            return new Dimension(1,1);
        }
        Scene scene = sceneEditor.s;
        return new Dimension(scene.width, scene.height);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(sceneEditor==null||sceneEditor.s==null){
            return;
        }
        Scene s = sceneEditor.s;
        g.setColor(s.bgColor);
        g.fillRect(0, 0, s.width, s.height);
        Collections.sort(s.actors);
        for(Scene.ActorInScene actor : s.actors){
            BufferedImage i = actor.getImage();
            if(i!=null){
                g.drawImage(i, actor.x, actor.y, null);
            }
        }
    }
    
}
