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
package org.gcreator.pinedl.cpp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Vector;
import org.gcreator.actions.Action;
import org.gcreator.events.Event;
import org.gcreator.formats.Actor;
import org.gcreator.formats.Scene;
import org.gcreator.game2d.GameProjectType;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;

/**
 * Compiles the game
 * @author Luís Reis
 */
public class GameCompiler {

    Project p;
    File outputFolder;
    File binFolder;
    CompilerFrame compFrame;
    Vector<File> pineScripts = new Vector<File>();
    String gamePackage = "Game";

    private GameCompiler(Project p) {
        this.p = p;
        if (p.getProjectType() instanceof GameProjectType) {
            try {
                prepare();
                //Let's compile it!
                for (ProjectElement e : p.getFiles()) {
                    String name = e.getFile().getName();
                    String format = name.substring(name.lastIndexOf('.') + 1);
                    if (format.equals("actor")) {
                        createActorScript(e);
                    }
                    if (format.equals("scene")) {
                        createSceneScript(e);
                    }
                }
            } catch (Exception e) {
                compFrame.writeLine("<font color='red'>COMPILE EXCEPTION: " + e.getMessage() + "</font>");
            }
        }
    }

    private void createActorScript(ProjectElement e) throws Exception {
        Actor a = new Actor(e.getFile());
        String fname = e.getName();
        fname = fname.substring(0, fname.lastIndexOf('.') - 1);
        fname = fname.replaceAll("\\s", "_");
        compFrame.writeLine("Creating PineDL Script for actor " + fname);
        File f = new File(outputFolder, fname + ".pdl");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write("package ".getBytes());
        fos.write(gamePackage.getBytes());
        fos.write(';');
        fos.write('\n');
        fos.write('\n');
        fos.write("class ".getBytes());
        fos.write(fname.getBytes());
        fos.write(" extends Actor{\n".getBytes());

        for (Event evt : a.events) {
            if (evt.type.equals(Event.TYPE_CREATE)) {
                fos.write("\tpublic this(float x, float y){\n".getBytes());

                fos.write("\t\tsetX(x);\n\t\tsetY(y);\n".getBytes());
                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.type.equals(Event.TYPE_UPDATE)) {
                fos.write("\tpublic void update(){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.type.equals(Event.TYPE_DRAW)) {
                fos.write("\tpublic void draw(){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.type.equals(Event.TYPE_KEYPRESS)) {
                fos.write("\tpublic void onKeyUp(Key key){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.type.equals(Event.TYPE_KEYRELEASE)) {
                fos.write("\tpublic void onKeyDown(Key key){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }
        }

        fos.write('}');
        fos.write('\n');
    }

    private void createSceneScript(ProjectElement e) throws Exception {
        Scene scene = new Scene(e.getFile());
        String fname = e.getName();
        fname = fname.substring(0, fname.lastIndexOf('.') - 1);
        fname = fname.replaceAll("\\s", "_");
        compFrame.writeLine("Creating PineDL Script for scene " + fname);
        File f = new File(outputFolder, fname + ".pdl");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write("package ".getBytes());
        fos.write(gamePackage.getBytes());
        fos.write(';');
        fos.write('\n');
        fos.write('\n');
        fos.write("class ".getBytes());
        fos.write(fname.getBytes());
        fos.write(" extends Scene{\n".getBytes());
        
        fos.write("public this() : super".getBytes());
        
        fos.write(("(" + scene.width + ", " + scene.height + ")").getBytes());
        
        fos.write("){\n".getBytes());
        
        for(Scene.ActorInScene a : scene.actors){
            String aname = a.bf.getName();
            aname = aname.substring(0, aname.lastIndexOf('.')-1);
            fos.write(("addActor(new "+aname+"("+a.x+", "+a.y+"));").getBytes());
        }
        
        fos.write("}\n".getBytes());
        
        fos.write('}');
        fos.write('\n');
    }
    
    private String outputEvent(Actor a, Event evt) {
        String s = "";
        for (Action act : evt.actions) {
            s += act.getType().toPineDL(act) + "\n";
        }
        return s;
    }

    private void prepare() throws Exception {
        compFrame = new CompilerFrame();
        compFrame.writeLine("<b>Preparing game compilation</b>");
        outputFolder = new File(p.getProjectFolder(), "output/cpp-opengl/");
        if (outputFolder.exists()) {
            outputFolder.delete();
        }
        outputFolder.mkdirs();
        binFolder = new File(outputFolder, "bin/");
        if (binFolder.exists()) {
            binFolder.delete();
        }
        binFolder.mkdirs();
    }
}
