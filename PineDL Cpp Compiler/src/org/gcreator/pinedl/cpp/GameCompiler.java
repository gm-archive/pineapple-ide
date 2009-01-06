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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    File resFolder;
    CompilerFrame compFrame;
    Vector<File> pineScripts = new Vector<File>();
    Vector<File> imageFiles = new Vector<File>();
    Vector<File> compFiles = new Vector<File>();
    Vector<String> context = new Vector<String>();
    String gamePackage = "Game";
    boolean worked = true;

    public GameCompiler(Project p) {
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
                    else if (format.equals("scene")) {
                        createSceneScript(e);
                    }
                    else if (format.equals("pdl")) {
                        copyScript(e);
                    }
                    else if (format.equals("png")) {
                        copyImage(e);
                    }
                }
                buildContext();
                compFrame.writeLine("Generating C++ and header files");
                for(File script : pineScripts){
                    if(!worked){
                        return;
                    }
                    generateHeader(script);
                    generateCppFile(script);
                }
                compFrame.writeLine("Compiling the game");
                copyLib();
                compile();
            } catch (Exception e) {
                compFrame.writeLine("<font color='red'>COMPILE EXCEPTION: " + e.getMessage() + "</font>");
                worked = false;
            }
        }
    }
    
    private void copyLib() throws IOException{
        File f = new File(outputFolder, "libPineapple.a");
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = getClass().getResourceAsStream("/org/gcreator/pinedl/cpp/res/linux/libPineapple.a");
        int c = 0;
        while((c=is.read())!=-1){
            fos.write(c);
        }
        fos.close();
        f = new File(outputFolder, "pineapple.h.gch");
        fos = new FileOutputStream(f);
        is = getClass().getResourceAsStream("/org/gcreator/pinedl/cpp/res/linux/pineapple.h.gch");
        while((c=is.read())!=-1){
            fos.write(c);
        }
    }
    
    private void compile() throws IOException{
        //TODO: MAKE THIS WINDOWS-COMPATIBLE
        //TODO: TEST THIS AGAINST LARGE PROJECTS
        File outputFile = new File(outputFolder, "game");
        String command = "g++ -o \"";
        command += outputFile.getAbsolutePath();
        command += "\" \"";
        File pine1 = new File(outputFolder, "libPineapple.a");
        command += pine1.getAbsolutePath();
        command += "\" \"";
        File pine2 = new File(outputFolder, "pineapple.h.gch");
        command += pine2.getAbsolutePath();
        command += "\"";
        for(File script : pineScripts){
            command += " \"";
            command += script.getAbsolutePath();
            command += "\"";
        }
        command += "`sdl-config --cflags --libs` -lSDL_image -lGL -lGLU";
        Process proc = Runtime.getRuntime().exec(command);
        compFrame.writeLine("Calling GCC C++ for executable generation");
        int c;
        String res = "";
        InputStream is = proc.getInputStream();
        while((c=is.read())!=-1){
            if(c!='\n'){
                res += (char) c;
            }
            else{
                compFrame.writeLine(res);
                res = "";
            }
        }
    }
    
    private void buildContext(){
        for(File script : pineScripts){
            String fname = script.getName();
            fname = fname.substring(0, fname.lastIndexOf('.'));
            context.add(fname);
        }
    }
    
    private void generateHeader(File script) throws IOException{
        InputStream is = new FileInputStream(script);
        String fname = script.getName();
        System.out.println("fname="+fname);
        fname = fname.substring(0, fname.lastIndexOf('.'));
        System.out.println("new fname="+fname);
        File output = new File(outputFolder, fname + ".h");
        FileOutputStream fos = new FileOutputStream(output);
        HGenerator gen = new HGenerator(is, fos, this, fname, context);
        if(!gen.wasSuccessful()){
            worked = false;
        }
        fos.close();
    }
    
    private void generateCppFile(File script) throws IOException{
        InputStream is = new FileInputStream(script);
        String fname = script.getName();
        fname = fname.substring(0, fname.lastIndexOf('.'));
        File output = new File(outputFolder, fname + ".h");
        FileOutputStream fos = new FileOutputStream(output);
        CppGenerator gen = new CppGenerator(is, fos, this, fname, context);
        if(!gen.wasSuccessful()){
            worked = false;
        }
        fos.close();
    }

    private void copyImage(ProjectElement e) throws Exception {
        File f = new File(resFolder, e.getName());
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = e.getFile().getInputStream();
        int c = 0;
        while((c=is.read())!=-1){
            fos.write(c);
        }
        imageFiles.add(f);
        fos.close();
    }
    
    private void copyScript(ProjectElement e) throws Exception {
        compFrame.writeLine("Copying PineDL script " + e.getName());
        File f = new File(outputFolder, e.getName());
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = e.getFile().getInputStream();
        int c = 0;
        while((c=is.read())!=-1){
            fos.write(c);
        }
        pineScripts.add(f);
        fos.close();
    }
    
    private void createActorScript(ProjectElement e) throws Exception {
        Actor a = new Actor(e.getFile());
        String fname = e.getName();
        fname = fname.substring(0, fname.lastIndexOf('.'));
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
        pineScripts.add(f);
        fos.close();
    }

    private void createSceneScript(ProjectElement e) throws Exception {
        Scene scene = new Scene(e.getFile());
        String fname = e.getName();
        fname = fname.substring(0, fname.lastIndexOf('.'));
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
        pineScripts.add(f);
        fos.close();
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
        binFolder = new File(outputFolder, "bin/"); // OUTPUT/bin
        if (binFolder.exists()) {
            binFolder.delete();
        }
        binFolder.mkdir();
        resFolder = new File(binFolder, "res/"); // OUTPUT/bin/res
        if (resFolder.exists()) {
            resFolder.delete();
        }
        resFolder.mkdir();
    }
}
