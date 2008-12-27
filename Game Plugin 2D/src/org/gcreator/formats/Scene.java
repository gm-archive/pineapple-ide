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
import java.io.OutputStream;
import java.util.Vector;
import javax.imageio.ImageIO;
import org.gcreator.actions.Action;
import org.gcreator.actions.ActionType;
import org.gcreator.events.Event;
import org.gcreator.pineapple.PineappleCore;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFolder;
import org.gcreator.project.io.BasicFile;
import org.gcreator.xml.Node;
import org.gcreator.xml.SAXImporter;
import org.xml.sax.SAXException;

/**
 * Core class for scene handling
 * @author Luís Reis
 */
public class Scene extends BehaviorObject {

    public int width = 640;
    public int height = 480;
    public Color bgColor = Color.BLACK;
    public static final double MIN_VERSION = 1.0D;
    public static final double MAX_VERSION = 2.0D;
    public static final double FORMAT_VERSION = 1.0D;
    public Vector<ActorInScene> actors = new Vector<ActorInScene>();

    public Scene(BasicFile f) {
        try {
            SAXImporter sax = new SAXImporter(f.getInputStream());
            Node root = sax.getDocumentRoot();
            if (!root.getName().equals("scene")) {
                throw new SAXException("Not a scene file");
            }
            double d = root.getAttributeValueAsDouble("version");
            if (d < MIN_VERSION || d >= MAX_VERSION) {
                throw new SAXException("Unrecognized format version");
            }
            for (Node child : root.getChildren()) {
                if (child.getName().equals("size")) {
                    width = child.getAttributeValueAsInteger("width");
                    height = child.getAttributeValueAsInteger("height");
                } else if (child.getName().equals("bgcolor")) {
                    int r = child.getAttributeValueAsInteger("red");
                    int g = child.getAttributeValueAsInteger("green");
                    int b = child.getAttributeValueAsInteger("blue");
                    bgColor = new Color(r, g, b);
                } else if (child.getName().equals("fields")) {
                    for (Node field : child.getChildren()) {
                        if (field.getName().equals("field")) {
                            Field fi = new Field();
                            fi.setName(field.getAttributeValue("name"));
                            fi.setType(field.getAttributeValue("type"));
                            fi.setDefaultValue(field.getAttributeValue("default-value"));
                            fi.setStatic(field.getAttributeValueAsBoolean("static"));
                            fi.setFinal(field.getAttributeValueAsBoolean("final"));
                            fields.add(fi);
                        }
                    }
                } else if (child.getName().equals("events")) {
                    eventparse:
                    for (Node event : child.getChildren()) {
                        if (event.getName().equals("event")) {
                            Event evt = new Event();
                            String type = event.getAttributeValue("type");
                            if (type == null) {
                                continue;
                            }
                            evt.type = type;
                            for (Node action : event.getChildren()) {
                                if (action.getName().equals("actor")) {
                                    String className = action.getAttributeValue("type");
                                    if (className == null) {
                                        continue eventparse;
                                    }
                                    ActionType atype = null;
                                    for (ActionType actionType : ActionType.actionTypes) {
                                        if (actionType.getClass().getName().equals(className)) {
                                            atype = actionType;
                                            break;
                                        }
                                    }
                                    Action act = new Action(atype);
                                    atype.load(act, action.getContent());
                                    evt.actions.add(act);
                                }
                            }
                        }
                    }
                } else if (child.getName().equals("actors")) {
                    for (Node actor : child.getChildren()) {
                        if (actor.getName().equals("actor")) {
                            ActorInScene unit = new ActorInScene();
                            unit.x = actor.getAttributeValueAsInteger("x");
                            unit.y = actor.getAttributeValueAsInteger("y");
                            String path = actor.getAttributeValue("path");
                            setActor(unit, path, PineappleCore.getProject());
                            actors.add(unit);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void setActor(ActorInScene unit, String path, Project p) {
        for (ProjectElement e : p.getFiles()) {
            if (e instanceof ProjectFolder) {
                setActor(unit, path, (ProjectFolder) e);
            } else if (e.getFile().getPath().equals(path)) {
                unit.bf = e.getFile();
                break;
            }
        }
    }

    public void setActor(ActorInScene unit, String path, ProjectFolder p) {
        for (ProjectElement e : p.getChildren()) {
            if (e instanceof ProjectFolder) {
                setActor(unit, path, (ProjectFolder) e);
            } else if (e.getFile().getPath().equals(path)) {
                unit.bf = e.getFile();
                break;
            }
        }
    }

    public void save(BasicFile f) {
        String s = save();
        try {
            OutputStream stream = f.getOutputStream();
            stream.write(s.getBytes());
            stream.close();
        } catch (IOException e) {
        }
    }

    public String save() {
        String res = "";

        res += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        res += "<scene version=\"" + FORMAT_VERSION + "\">\n";
        res += "\t<size width=\"" + width + "\" height=\"" + height + "\" />\n";
        res += "\t<bgcolor red=\"" + bgColor.getRed() +
                "\" green=\"" + bgColor.getGreen() + "\" blue=\"" + bgColor.getBlue() + "\" />\n";
        res += "\t<fields>\n";
        for (Field f : fields) {
            res += "\t\t<field name=\"" + f.getName() + "\" type=\"" + f.getType() + "\" ";
            res += "default-value=\"" + f.getDefaultValue() + "\" static=\"" + f.isStatic() + "\" ";
            res += "final=\"" + f.isFinal() + "\" />\n";
        }
        res += "\t</fields>\n";
        res += "\t<events>\n";
        for (Event e : events) {
            res += "\t\t<event type=\"" + e.type + "\">\n";
            for(Action a : e.actions){
                res += "\t\t\t<action type=\"" + a.getType().getClass().getName();
                res += "\">" + a.getType().save(a) + "</action>\n";
            }
            res += "\t\t</event>\n";
        }
        res += "\t</events>\n";
        res += "\t<actors>\n";
        for(ActorInScene ais : actors){
            res += "\t\t<actor x=\"" + ais.x + "\" y=\"" + ais.y + "\" path=\"";
            res += ais.bf.getPath() + "\" />\n";
        }
        res += "\t</actors>\n";
        res += "</scene>";

        return res;
    }

    public static class ActorInScene implements Comparable<ActorInScene> {

        public BasicFile bf = null;
        public int x = 0;
        public int y = 0;

        public int compareTo(ActorInScene other) {

            float z = 0;
            float oz = 0;

            try {
                Actor a = new Actor(bf);
                z = a.z;
            } catch (Exception e) {
            }

            try {
                Actor a = new Actor(other.bf);
                oz = a.z;
            } catch (Exception e) {
            }

            if (z == oz) {
                return 0;
            }

            return z < oz ? -1 : 1;
        }

        public BufferedImage getImage() {
            if (bf == null) {
                return null;
            }
            try {
                Actor a = new Actor(bf);
                return ImageIO.read(a.image.getInputStream());
            } catch (Exception e) {
                return null;
            }
        }
    }
}
