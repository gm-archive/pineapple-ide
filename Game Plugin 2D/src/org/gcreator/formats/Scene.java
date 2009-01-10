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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.gcreator.events.Event;
import org.gcreator.pineapple.PineappleCore;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFolder;
import org.gcreator.project.io.BasicFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Core class for scene handling.
 * 
 * @author Luís Reis
 */
public class Scene extends BehaviorObject {

    public int width = 640;
    public int height = 480;
    public Color bgColor = Color.BLACK;
    public static final double MIN_VERSION = 1.0D;
    public static final double MAX_VERSION = 2.0D;
    public static final double VERSION = 1.0D;
    public Vector<ActorInScene> actors = new Vector<ActorInScene>();

    public Scene() {
    }
    
    public Scene(BasicFile file) {
        try {
            new SceneImporter(this, new BufferedInputStream(file.getInputStream()));
        } catch (SAXException ex) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
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
    //<editor-fold defaultstate="collapsed" desc="Scene Saving">
    /**
     * Saves the scene to a {@lin BasicFile}.
     * 
     * @param file The {@link BasicFile} to save to.
     * 
     * @throws java.io.IOException
     * @throws javax.xml.transform.TransformerConfigurationException
     * @throws javax.xml.transform.TransformerException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public void save(BasicFile file) throws IOException, TransformerConfigurationException, TransformerException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(true);
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.newDocument();
        doc.setXmlStandalone(true);
        doc.setXmlVersion("1.0");
        Element root = doc.createElement("scene");
        root.setAttribute("version", Double.toString(VERSION));

        Element size = doc.createElement("size");
        size.setAttribute("width", String.valueOf(Scene.this.width));
        size.setAttribute("height", String.valueOf(Scene.this.height));
        root.appendChild(size);

        Element bgcolor = doc.createElement("bgcolor");
        bgcolor.setAttribute("rgb", String.valueOf(Scene.this.bgColor.getRGB()));
        root.appendChild(bgcolor);

        /* Fields */
        Element fields = doc.createElement("fields");
        for (Field f : this.fields) {
            Element field = doc.createElement("field");
            field.setAttribute("name", f.name);
            field.setAttribute("type", f.type);
            field.setAttribute("default-value", f.defaultValue);
            field.setAttribute("static", Boolean.toString(f.isStatic));
            field.setAttribute("final", Boolean.toString(f.isFinal));

            fields.appendChild(field);
        }
        root.appendChild(fields);

        /* Events */
        Element events = doc.createElement("events");
        for (Event e : this.events) {
            Element event = doc.createElement("event");
            event.setAttribute("type", e.getType());
            event.setTextContent(e.getPineDL());
            events.appendChild(event);
        }
        root.appendChild(events);

        /* Actors */
        Element actors = doc.createElement("actors");
        for (ActorInScene a : this.actors) {
            Element actor = doc.createElement("actor");
            actor.setAttribute("x", String.valueOf(a.x));
            actor.setAttribute("y", String.valueOf(a.y));
            actor.setAttribute("file", String.valueOf(a.bf.getPath()));
            actors.appendChild(actor);
        }
        root.appendChild(actors);

        doc.appendChild(root);
        // Prepare the DOM document for writing
        Source source = new DOMSource(doc);
        Result result = null;

        // Write the DOM document to the file
        Transformer xformer;
        BufferedOutputStream out = new BufferedOutputStream(file.getOutputStream());
        result = new StreamResult(out);
        xformer = TransformerFactory.newInstance().newTransformer();
        xformer.transform(source, result);
        out.close();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="SceneImporter">
    private final class SceneImporter implements ContentHandler {

        public SceneImporter(Scene s, InputStream in) throws SAXException, IOException {
            this.scene = s;
            XMLReader r = XMLReaderFactory.createXMLReader();
            r.setContentHandler(this);
            r.parse(new InputSource(in));
            in.close();

        }
        private Locator locator;
        private boolean parsing;
        private boolean parsingActors;
        private boolean parsingEvents;
        private boolean parsingFields;
        private boolean parsingEvent;
        private Event curEvent;
        private Scene scene;

        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            System.out.println("parsing " + localName);
            if (localName.equalsIgnoreCase("scene")) {
                String version = atts.getValue("version");
                double v = Double.valueOf(version);
                if (version == null) {
                    System.err.println("FATAL ERROR: No scene version.");
                    parsing = false;
                } else if (v < MIN_VERSION || v >= MAX_VERSION) {
                    System.err.println("FATAL ERROR: Invalid scene version: " + version + ", current: " + VERSION);
                    parsing = false;
                } else {
                    parsing = true;
                }
                return;
            }

            if (!parsing) {
                return;
            }

            if (localName.equalsIgnoreCase("size")) {
                String width = atts.getValue("width");
                String height = atts.getValue("height");
                if (width != null) {
                    scene.width = Integer.parseInt(width);
                }
                if (height != null) {
                    scene.height = Integer.parseInt(height);
                }
            }

            if (localName.equalsIgnoreCase("bgcolor")) {
                String color = atts.getValue("rgb");
                if (color != null) {
                    scene.bgColor = new Color(Integer.parseInt(color));
                }
            }


            if (localName.equalsIgnoreCase("fields")) {
                parsingFields = true;
            } else if (localName.equalsIgnoreCase("events")) {
                parsingEvents = true;
            } else if (localName.equalsIgnoreCase("actors")) {
                parsingActors = true;
            }

            if (parsingFields && localName.equalsIgnoreCase("field")) {
                String name, type, defaultValue, isStatic, isFinal;
                name = atts.getValue("name");
                type = atts.getValue("type");
                defaultValue = atts.getValue("default-value");
                isStatic = atts.getValue("static");
                isFinal = atts.getValue("final");

                Field f = new Field();
                f.name = name;
                f.type = type;
                f.defaultValue = defaultValue;
                f.isStatic = Boolean.parseBoolean(isStatic);
                f.isFinal = Boolean.parseBoolean(isFinal);

                this.scene.fields.add(f);
            } else if (parsingEvents && localName.equalsIgnoreCase("event")) {
                System.out.println("Starting");
                String type = atts.getValue("type");
                System.out.println("Type is " + type);
                if (type == null) {
                    System.err.println("ERROR: No type for event.");
                    return;
                }
                curEvent = new Event(type);
                System.out.println("Starting event" + curEvent.getType());
                parsingEvent = true;
            } else if (parsingActors && localName.equalsIgnoreCase("actor")) {
                ActorInScene unit = new ActorInScene();
                unit.x = Integer.parseInt(atts.getValue("x"));
                unit.y = Integer.parseInt(atts.getValue("y"));
                String path = atts.getValue("path");
                setActor(unit, path, PineappleCore.getProject());
                actors.add(unit);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equalsIgnoreCase("actor") && !parsingEvents && !parsingEvent && !parsingFields && !parsingActors) {
                parsing = false;
                return;
            }
            if (!parsing) {
                return;
            }

            if (parsingFields && localName.equalsIgnoreCase("fields")) {
                parsingFields = false;
            } else if (parsingActors && localName.equalsIgnoreCase("actorss")) {
                parsingActors = false;
            } else if (parsingEvents && localName.equalsIgnoreCase("events")) {
                parsingEvents = false;
            } else if (parsingEvents && parsingEvent && localName.equalsIgnoreCase("event")) {
                parsingEvent = false;
                System.out.println("Add event");
                scene.events.add(curEvent);
                curEvent = null;
            }
        }

        public void startDocument() throws SAXException {
            /* No one cares. */
        }

        public void endDocument() throws SAXException {
            /* No one cares. */
        }

        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            /* No one cares. */
        }

        public void endPrefixMapping(String prefix) throws SAXException {
            /* No one cares. */
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            String s = new String(ch, start, length);
            if (parsingEvent) {
                curEvent.setPineDL(s);
            }
        }

        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            /* No one cares. */
        }

        public void processingInstruction(String target, String data) throws SAXException {
            /* No one cares. */
        }

        public void skippedEntity(String name) throws SAXException {
            /* No one cares. */
        }
    }
    //</editor-fold>
}
