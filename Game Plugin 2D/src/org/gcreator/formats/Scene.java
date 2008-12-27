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

package org.gcreator.formats;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import org.gcreator.project.io.BasicFile;

/**
 * Core class for scene handling
 * @author Luís Reis
 */
public class Scene extends BehaviorObject{
    public int width = 640;
    public int height = 480;
    public Color bgColor = Color.BLACK;
    
    public Vector<ActorInScene> actors = new Vector<ActorInScene>();
    
    public static class ActorInScene implements Comparable<ActorInScene>{
        public BasicFile bf = null;
        public int x = 0;
        public int y = 0;
        
        public int compareTo(ActorInScene other){
            
            float z = 0;
            float oz = 0;
            
            try{
                Actor a = new Actor(bf);
                z = a.z;
            }
            catch(Exception e){}
            
            try{
                Actor a = new Actor(other.bf);
                oz = a.z;
            }
            catch(Exception e){}
            
            if(z==oz){
                return 0;
            }
            
            return z<oz?-1:1;
        }
        
        public BufferedImage getImage(){
            if(bf==null){
                return null;
            }
            try{
                Actor a = new Actor(bf);
                return ImageIO.read(a.image.getInputStream());
            }
            catch(Exception e){
                return null;
            }
        }
    }
}
