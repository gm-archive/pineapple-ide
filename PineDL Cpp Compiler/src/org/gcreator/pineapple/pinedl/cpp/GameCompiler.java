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
package org.gcreator.pineapple.pinedl.cpp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import org.gcreator.pineapple.events.Event;
import org.gcreator.pineapple.formats.Actor;
import org.gcreator.pineapple.formats.Scene;
import org.gcreator.pineapple.game2d.GameProjectType;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.game2d.GamePlugin;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.validators.Glob;
import org.gcreator.pineapple.validators.UniversalValidator;

/**
 * This class is used to compile the game.
 * 
 * @author Luís Reis
 */
public class GameCompiler {

    Project p;
    File outputFolder;
    File binFolder;
    File resFolder;
    File objresFolder;
    File compConf;
    CompilerFrame compFrame;
    Vector<File> pineScripts = new Vector<File>();
    Vector<File> imageFiles = new Vector<File>();
    Vector<File> compFiles = new Vector<File>();
    Vector<String> context = new Vector<String>();
    String gamePackage = "Game";
    boolean worked = true;
    OutputStream headerH = null;
    File outputFile = null;
    CompilationProfile profile = null;
    int resIndex = 0;
    HashMap<File, String> imageNames = new HashMap<File, String>();
    HashMap<String, String> config = new HashMap<String, String>();
    static boolean copiedLib = false;

    public GameCompiler(final Project p) {
        this(p, getDefaultProfile());
    }

    public static CompilationProfile getDefaultProfile() {
        // TODO: Non-GCC compiler support.
        String os = System.getProperty("os.name");
        if (os.startsWith("Windows")) {
            return CompilationProfile.MINGW_WINDOWS;
        } else {
            return CompilationProfile.UNIX_GCC;
        }
    }

    public GameCompiler(final Project p, final CompilationProfile profile) {
        this.p = p;
        this.profile = profile;
        compFrame = new CompilerFrame(this);
        compFrame.setSize(330, 460);
        compFrame.setVisible(true);
        if (p.getProjectType() instanceof GameProjectType) {
            try {
                compFrame.write("Checking resource names... ");
                if (GamePlugin.checkResourceNames()) {
                    compFrame.writeLine("ok");
                } else {
                    compFrame.writeLine("<span style='color: red;'>bad!</span>");
                    compFrame.writeLine("<span style='color: red;'>Cannot continue with bad resource names." +
                            "<br/>Please correct them and re-compile the game.</span>");
                    JButton fix = new JButton("Fix Resource Names");
                    fix.setSize(164, 36);
                    fix.setLocation(4, compFrame.output.getPreferredSize().height);
                    fix.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            GamePlugin.showCheckResourcesDialog();
                        }
                    });
                    compFrame.output.add(fix);
                    return;
                }
                prepare();
                //Let's compile it!
                Thread t = new Thread() {

                    @Override
                    public void run() {
                        try {
                            for (BasicFile f : Glob.glob(new UniversalValidator(), true)) {
                                ProjectElement e = f.getElement();
                                if (e.getFile() == null) {
                                    continue;
                                }
                                String name = e.getFile().getName();
                                String format = name.substring(name.lastIndexOf('.') + 1);
                                format = format.toLowerCase();
                                if (format.equals("actor")) {
                                    createActorScript(e);
                                } else if (format.equals("scene")) {
                                    createSceneScript(e);
                                } else if (format.equals("pdl")) {
                                    copyScript(e);
                                } else {
                                    for (String s : ImageIO.getReaderFileSuffixes()) {
                                        if (s.equalsIgnoreCase(format)) {
                                            copyImage(e, format);
                                            break;
                                        }
                                    }
                                }
                            }
                            buildContext();
                            compFrame.writeLine("Generating C++ and header files");
                            context.add("TextureList");
                            for (File script : pineScripts) {
                                if (!worked) {
                                    return;
                                }
                                generateHeader(script);
                                generateCppFile(script);
                            }
                            /* Only copy lib once every time
                                 Pineapple is run. */
                            if (!copiedLib) {
                                copyLib();
                                copiedLib = true;
                            }
                            compFrame.writeLine("Compiling C++ code");
                            generateTextureList();
                            generateMain();
                            compile();
                        } catch (Exception ex) {
                            compFrame.writeLine("<font color='red'>COMPILE EXCEPTION: " + ex.getMessage() + "</font>");
                            ex.printStackTrace();
                            worked = false;
                        }
                    }
                };

                t.start();
            } catch (Exception e) {
                compFrame.writeLine("<font color='red'>Compile Exception: " + e.getMessage() + "</font>");
                worked = false;
            }
        }
    }

    public void generateTextureList() throws IOException {
        File header = new File(outputFolder, "TextureList.h");
        FileOutputStream fos = new FileOutputStream(header);
        fos.write("#ifndef __PINEDL_TEXTURELIST_H__\n".getBytes());
        fos.write("#define __PINEDL_TEXTURELIST_H__\n\n".getBytes());
        fos.write("#include \"header.h\"\n".getBytes());

        fos.write(("namespace " + gamePackage + "{\n").getBytes());
        fos.write("\tclass TextureList{\n".getBytes());

        for (File image : imageFiles) {
            String fname = imageNames.get(image);
            int index = fname.lastIndexOf('.');
            fname = fname.substring(0, index) + "_" + fname.substring(index + 1);
            fos.write(("\t\tpublic: static ::Pineapple::Texture* " + fname + ";\n").getBytes());
        }
        fos.write("\t\tpublic: static void init();".getBytes());

        fos.write(("\n};\n}\n").getBytes());

        fos.write("\n#endif\n".getBytes());
        fos.close();

        File cpp = new File(outputFolder, "TextureList.cpp");
        fos = new FileOutputStream(cpp);

        fos.write("#include \"header.h\"\n\n".getBytes());
        fos.write("using namespace Game;\n\n".getBytes());
        for (File image : imageFiles) {
            String fname = image.getName();
            int index = fname.lastIndexOf('.');
            fname = fname.substring(0, index);
            String varname = fname.replaceAll("\\W", "_");
            fname = imageNames.get(image);
            index = fname.lastIndexOf('.');
            fname = fname.substring(0, index) + "_" + fname.substring(index + 1);
            fos.write(("extern int _binary_" + varname + "_start;\n").getBytes());
            fos.write(("extern int _binary_" + varname + "_size;\n").getBytes());
            fos.write("::Pineapple::Texture* ".getBytes());
            fos.write((gamePackage + "::TextureList::" + fname + ";\n").getBytes());
        }
        fos.write("void TextureList::init() {\n".getBytes());
        for (File image : imageFiles) {
            String fname = image.getName();
            int index = fname.lastIndexOf('.');
            fname = fname.substring(0, index);
            String varname = fname.replaceAll("\\W", "_");
            fname = imageNames.get(image);
            index = fname.lastIndexOf('.');
            fname = fname.substring(0, index) + "_" + fname.substring(index + 1);
            fos.write(("\t" + gamePackage + "::TextureList::" + fname +
                    " = new ::Pineapple::Texture((char*)&_binary_" + varname + "_start, (int)&_binary_" + varname + "_size").getBytes());
            fos.write(");\n".getBytes());
        }
        fos.write("}\n".getBytes());
        fos.close();
    }

    public static void copyFile(String resFolder, File outFolder, String fname) throws IOException {
        File f = new File(outFolder, fname);
        if (f.exists() && !f.canWrite()) {
            return;
        }
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = GameCompiler.class.getResourceAsStream(resFolder + fname);
        int c;
        while ((c = is.read()) != -1) {
            fos.write(c);
        }
        fos.close();
        is.close();
    }

    private void generateMain() throws IOException {
        File f = new File(outputFolder, "main.cpp");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write("#include \"header.h\"\n\n".getBytes());
        fos.write("int main(int argc, char** argv){\n".getBytes());
        fos.write("\tPineapple::Application::init();\n".getBytes());
        fos.write("\tPineapple::Window::setSize(640, 480);\n".getBytes());
        fos.write("\tPineapple::Window::setCaption(\"Pineapple Game\");\n".getBytes());
        fos.write("\tGame::TextureList::init();\n".getBytes());
        Hashtable<String, String> hs = PineappleCore.getProject().getSettings();
        if (hs.containsKey(("scene-order"))) {
            String scene = hs.get("scene-order").split(";")[0];
            scene = scene.substring(scene.lastIndexOf('/') + 1);
            scene = scene.substring(0, scene.indexOf('.'));
            fos.write(("\tPineapple::Application::setScene(new Game::" + scene + "());\n").getBytes());
        }
        fos.write("\tPineapple::Window::run();\n".getBytes());
        fos.write("}\n".getBytes());
        fos.close();
    }

    private void copyLib() throws IOException {
        compFrame.writeLine("Copying static library");
        if (profile == CompilationProfile.UNIX_GCC) {
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/linux/", outputFolder, "libPineapple.a");
        } else if (profile == CompilationProfile.MINGW_WINDOWS) {
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/windows/", binFolder, "SDL.dll");
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/windows/", binFolder, "SDL_image.dll");
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/windows/", binFolder, "jpeg.dll");
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/windows/", binFolder, "libpng12-0.dll");
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/windows/", binFolder, "libtiff-3.dll");
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/windows/", binFolder, "zlib1.dll");
            copyFile("/org/gcreator/pineapple/pinedl/cpp/res/windows/", outputFolder, "libPineapple.a");
        }
        compFrame.writeLine("Copying header files");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "actor.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "application.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "color.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "exceptions.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "io.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "keyboard.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "keycodes.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "pamath.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "scene.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "texture.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "timer.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "vector.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "view.h");
        copyFile("/org/gcreator/pineapple/pinedl/cpp/res/headers/", outputFolder, "window.h");
    }

    private void compile() throws Exception {
        headerH.write("#endif\n".getBytes());
        headerH.close();
        outputFile = new File(binFolder, "game");
        Vector<String> command = new Vector<String>();
        command.add("g++");
        command.add("-o");
        command.add(outputFile.getAbsolutePath());
        for (File script : pineScripts) {
            String path = script.getAbsolutePath();
            command.add(path.substring(0, path.lastIndexOf('.')) + ".cpp");
        }
        command.add((new File(outputFolder, "TextureList.cpp")).getAbsolutePath());
        command.add((new File(outputFolder, "main.cpp")).getAbsolutePath());
        command.add((new File(outputFolder, "libPineapple.a")).getAbsolutePath());

        for (File f : imageFiles) {
            command.add(f.getAbsolutePath());
        }

        int c;
        if (profile == CompilationProfile.UNIX_GCC) {
            Process sdlconfig = Runtime.getRuntime().exec("sdl-config --cflags --libs");
            InputStream sdlis = new BufferedInputStream(sdlconfig.getInputStream());
            String sdlout = "";
            while ((c = sdlis.read()) != -1) {
                sdlout += (char) c;
            }
            sdlconfig.waitFor();
            String[] sdloutSplit = sdlout.split("\\s");
            for (String cmd : sdloutSplit) {
                command.add(cmd);
            }
            command.add("-lSDL_image");
            // Doesn't compile with this option
            // command.add("-lGL");
            command.add("-lGLU");
        } else if (profile == CompilationProfile.MINGW_WINDOWS) {
            command.add("-lmingw32");
            command.add("-lSDLmain");
            command.add("-lSDL");
            command.add("-mwindows");
            command.add("-lSDL_image");
            command.add("-lglu32");
            command.add("-lopengl32");
        }


        String[] args = command.toArray(new String[command.size()]);
        compFrame.writeLine("Calling GCC C++ for executable generation");
        StringBuffer cmd = new StringBuffer("<font color='green'><em>");
        for (String s : args) {
            s = s.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
            if (s.contains(" ")) {
                s = "\"" + s + "\"";
            }
            cmd.append(" ").append(s);
        }
        cmd.append("</em></font>");
        compFrame.writeLine(cmd.toString());
        Process proc = Runtime.getRuntime().exec(args);
        String res = "";
        InputStream is = new BufferedInputStream(proc.getErrorStream());
        while ((c = is.read()) != -1) {
            if (c != '\n') {
                res += (char) c;
            } else {
                compFrame.writeLine(res);
                res = "";
            }
        }
        int x = proc.waitFor();
        if (x != 0) {
            compFrame.writeLine("<font color='red'>There seems to have been some errors with the compiler<br/> " +
                    "Please report them to the G-Creator team</font>");
        } else {
            compFrame.writeLine("Finished!");
            compFrame.runGameButton.setEnabled(true);
        }
        saveConfig();
    }

    private void buildContext() {
        for (File script : pineScripts) {
            String fname = script.getName();
            fname = fname.substring(0, fname.indexOf('.'));
            context.add(fname);
        }
    }

    private void generateHeader(File script) throws IOException {
        InputStream is = new FileInputStream(script);
        String fname = script.getName();
        System.out.println("fname=" + fname);
        fname = fname.substring(0, fname.lastIndexOf('.'));
        System.out.println("new fname=" + fname);
        File output = new File(outputFolder, fname + ".h");
        headerH.write("#include \"".getBytes());
        headerH.write(fname.getBytes());
        headerH.write(".h\"\n".getBytes());
        FileOutputStream fos = new FileOutputStream(output);
        HGenerator gen = new HGenerator(is, fos, this, fname, context);
        if (!gen.wasSuccessful()) {
            worked = false;
        }
        fos.close();
    }

    private void generateCppFile(File script) throws IOException {
        InputStream is = new FileInputStream(script);
        String fname = script.getName();
        fname = fname.substring(0, fname.lastIndexOf('.'));
        File output = new File(outputFolder, fname + ".cpp");
        FileOutputStream fos = new FileOutputStream(output);
        if (is.available() == 0) {
            System.out.println("Blank file: " + fname + "; skipping");
            return;
        }
        CppGenerator gen = new CppGenerator(is, fos, this, fname, context);
        if (!gen.wasSuccessful()) {
            worked = false;
        }
        fos.close();
    }

    private void copyImage(ProjectElement e, String ext) throws Exception {
        String fn = ext + resIndex++ + ".png";
        File f = new File(resFolder, fn);
        File obj = new File(objresFolder.getAbsolutePath(), fn + ".o");
        /* Convert to PNG if needed */
        boolean copy = true;
        if (f.exists() && config.containsKey(f.getName())) {
            long modified = Long.parseLong(config.get(f.getName()));
            if (modified >= f.lastModified()) {
                copy = false;
            }
        }
        if (copy) {
            convertImage(e.getFile(), f);
            config.put(f.getName(), String.valueOf(f.lastModified()));
            compFrame.writeLine("Making object file of " + e.getName());
            /* Works with GCC and MinGW
            Doesn't link in MinGW! Needs to be fixed.
             */
            if (profile == CompilationProfile.UNIX_GCC || profile == CompilationProfile.MINGW_WINDOWS) {
                String arch;
                if (profile == CompilationProfile.UNIX_GCC) {
                    arch = "elf32-i386";
                } else {
                    arch = "pe-i386";
                }
                ProcessBuilder pb = new ProcessBuilder(new String[]{
                            "objcopy",
                            "-I", "binary",
                            "-O", arch,
                            "--binary-architecture", "i386",
                            f.getName(), obj.getAbsolutePath()});
                pb.directory(f.getParentFile());
                StringBuffer cmd = new StringBuffer("<font color='blue'><em>");
                for (String s : pb.command()) {
                    s = s.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
                    if (s.contains(" ")) {
                        s = "\"" + s + "\"";
                    }
                    cmd.append(" ").append(s);
                }
                cmd.append("</em></font>");
                compFrame.writeLine(cmd.toString());
                Process pr = pb.start();
                pr.waitFor();
            } else {
                System.out.println("ERROR! Don't know how to use linker!");
                return;
            }
        }
        imageFiles.add(obj);
        imageNames.put(obj, e.getName());
    }

    private void copyScript(ProjectElement e) throws Exception {
        compFrame.writeLine("Copying PineDL script " + e.getName());
        File f = new File(outputFolder, e.getName());
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = e.getFile().getReader();
        int c = 0;
        while ((c = is.read()) != -1) {
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

        boolean hasCreate = false;

        for (Event evt : a.events) {
            if (evt.getType().equals(Event.TYPE_CREATE)) {
                hasCreate = true;
                writeCreate(fos, a, evt);
            }

            if (evt.getType().equals(Event.TYPE_UPDATE)) {
                fos.write("\tpublic void update(){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.getType().equals(Event.TYPE_DRAW)) {
                fos.write("\tpublic void draw(){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.getType().equals(Event.TYPE_KEYPRESS)) {
                fos.write("\tpublic void onKeyUp(Key key){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.getType().equals(Event.TYPE_KEYRELEASE)) {
                fos.write("\tpublic void onKeyDown(Key key){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }
        }

        if (!hasCreate) {
            writeCreate(fos, a, null);
        }

        fos.write('}');
        fos.write('\n');
        pineScripts.add(f);
        fos.close();
    }

    private void writeCreate(FileOutputStream fos, Actor a, Event evt) throws IOException {
        fos.write("\tpublic this(float x, float y, float depth) : super(x, y, depth) {\n".getBytes());

        fos.write("\t\tsetX(x);\n\t\tsetY(y);\n\t\tsetDepth(depth);\n".getBytes());
        if (a.getImage() != null) {
            fos.write(("\t\ttexture = " + gamePackage + ".TextureList.").getBytes());
            String iname = a.getImage().getName();
            int index = iname.indexOf('.');
            iname = iname.substring(0, index) + "_" + iname.substring(index + 1);
            fos.write(iname.getBytes());
            fos.write(";\n".getBytes());
        }
        if (evt != null) {
            fos.write(outputEvent(a, evt).getBytes());
        }

        fos.write("\t}\n".getBytes());
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

        fos.write("\tpublic this() : super".getBytes());

        fos.write(("(" + scene.getWidth() + ", " + scene.getHeight()).getBytes());

        fos.write("){\n".getBytes());


        Color c = scene.getBackgroundColor();
        String cs = ((Integer) c.getRed()).toString();
        cs += ", ";
        cs += c.getGreen();
        cs += ", ";
        cs += c.getBlue();
        fos.write(("\t\tsetBackground(new Color(" + cs + "));\n").getBytes());

        for (Scene.ActorInScene a : scene.actors) {
            String aname = a.file.getName();
            aname = aname.substring(0, aname.lastIndexOf('.'));
            fos.write(("\t\taddActor(new " + aname + "(" + a.x + ", " + a.y + ", " + a.actor.getZ() +"));\n").getBytes());
        }

        fos.write("\t}\n".getBytes());

        fos.write('}');
        fos.write('\n');
        pineScripts.add(f);
        fos.close();
    }

    private String outputEvent(Actor a, Event evt) {
        return evt.getPineDL();
    }

    private void prepare() throws Exception {
        compFrame.writeLine("<b>Preparing game compilation</b>");
        outputFolder = new File(p.getProjectFolder(), "output/cpp-opengl/");
        outputFolder.mkdirs();
        binFolder = new File(outputFolder, "bin"); // OUTPUT/bin
        binFolder.mkdir();
        resFolder = new File(outputFolder, "res"); // OUTPUT/res
        resFolder.mkdir();
        objresFolder = new File(outputFolder, "res_obj"); // OUTPUT/res_obj
        objresFolder.mkdir();
        compConf = new File(outputFolder, "compile.conf");

        compFrame.writeLine("Loading config...");
        loadConfig();

        compFrame.writeLine("Generating header...");
        headerH = new FileOutputStream(new File(outputFolder, "header.h"));
        headerH.write("#ifndef _PINEAPPLE_HEADER_H_\n".getBytes());
        headerH.write("#define _PINEAPPLE_HEADER_H_\n".getBytes());
        headerH.write("#include \"actor.h\"\n".getBytes());
        headerH.write("#include \"application.h\"\n".getBytes());
        headerH.write("#include \"color.h\"\n".getBytes());
        headerH.write("#include \"exceptions.h\"\n".getBytes());
        headerH.write("#include \"io.h\"\n".getBytes());
        headerH.write("#include \"keyboard.h\"\n".getBytes());
        headerH.write("#include \"keycodes.h\"\n".getBytes());
        headerH.write("#include \"pamath.h\"\n".getBytes());
        headerH.write("#include \"scene.h\"\n".getBytes());
        headerH.write("#include \"texture.h\"\n".getBytes());
        headerH.write("#include \"timer.h\"\n".getBytes());
        headerH.write("#include \"vector.h\"\n".getBytes());
        headerH.write("#include \"view.h\"\n".getBytes());
        headerH.write("#include \"window.h\"\n".getBytes());
        headerH.write("#include \"TextureList.h\"\n".getBytes());
    }

    private void loadConfig() {
        if (!compConf.exists()) {
            return;
        }
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(compConf));
            String l;
            while ((l = r.readLine()) != null) {
                if (l.matches("\\W*#.*")) {
                    continue;
                }
                String[] line = l.split("=");
                if (line.length < 2) {
                    System.out.println("Error: invalid line: " + l);
                    continue;
                }
                String var = line[0];
                String value = line[1];
                for (int i = 2; i < line.length; i++) {
                    value += line[i];
                }
                config.put(var, value);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (r != null) {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(GameCompiler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void saveConfig() {
        BufferedWriter w = null;
        try {
            w = new BufferedWriter(new FileWriter(compConf));
            for (String s : config.keySet()) {
                w.write(s);
                w.write("=");
                w.write(config.get(s));
                w.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(GameCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (w != null) {
                try {
                    w.close();
                } catch (IOException ex) {
                    Logger.getLogger(GameCompiler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void convertImage(BasicFile src, File dest) throws IOException {
        compFrame.writeLine("Converting image to PNG " + src.getName());
        BufferedImage img = ImageIO.read(src.getReader());
        BufferedImage copy = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        copy.getGraphics().drawImage(img, 0, 0, null);
        ImageIO.write(copy, "PNG", dest);
    }
}
