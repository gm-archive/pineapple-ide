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
package org.gcreator.pineapple.formats;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
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
import org.gcreator.pineapple.events.Event;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.util.ListeningVector;
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
 * Represents a Scene.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class Scene extends ClassResource {

    public static final double MIN_VERSION = 1.0D;
    public static final double MAX_VERSION = 2.0D;
    public static final double VERSION = 1.0D;
    public ListeningVector<ActorInScene> actors = new ListeningVector<ActorInScene>();
    public Vector<Background> backgrounds = new Vector<Background>();
    public Hashtable<String, Object> properties;
    protected static BufferedImage unknownImage;
    protected static HashMap<BasicFile, BufferedImage> imageCache;
    
    static {
        imageCache = new HashMap<BasicFile, BufferedImage>();
        try {
            unknownImage = ImageIO.read(Scene.class.getResource("/org/gcreator/pineapple/images/null.png"));
        } catch (IOException ex) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a new scene.
     */
    public Scene() {
        properties = new Hashtable<String, Object>();
        properties.put("width", new Integer(640));
        properties.put("height", new Integer(480));
        properties.put("draw-background-color", Boolean.TRUE);
        properties.put("background-color", Color.GRAY);
    }

    /**
     * Creates a new scene and loads data from a file.
     * 
     * @param file The file to read data from.
     */
    public Scene(BasicFile file) {
        this();
        try {
            new SceneImporter(this, new BufferedInputStream(file.getReader()));
        } catch (SAXException ex) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gets this scene's width.
     *
     * @return This scene's width.
     */
    public int getWidth() {
        return (Integer)properties.get("width");
    }

    /**
     * Sets this scene's width.
     *
     * @param width The new value for this scene's width.
     */
    public void setWidth(int width) {
        properties.put("width", new Integer(width));
    }

    /**
     * Gets this scene's height.
     *
     * @return This scene's height.
     */
    public int getHeight() {
        return (Integer)properties.get("height");
    }

    /**
     * Sets this scene's height.
     *
     * @param height The new value for this scene's height.
     */
    public void setHeight(int height) {
        properties.put("height", new Integer(height));
    }

    /**
     * Gets the background color for this scene.
     *
     * @return This scene's background color.
     */
    public Color getBackgroundColor() {
        return (Color)properties.get("background-color");
    }

    /**
     * Sets the background color.
     *
     * @param color The new background color for this scene.
     */
    public void setBackgroundColor(Color color) {
        properties.put("background-color", color);
    }

    /**
     * Gets whether the background color is drawn for this scene.
     *
     * @return Whether the background color is drawn or not.
     */
    public boolean isBackgroundColorDrawn() {
        return (Boolean)properties.get("draw-background-color");
    }

    protected static BufferedImage getImage(BasicFile f) {
        if (!imageCache.containsKey(f)) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(f.getReader());
            } catch (IOException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (img != null) {
                imageCache.put(f, img);
            }
        }
        return imageCache.get(f);
    }

    /**
     * Sets whether to draw the background color or not,
     *
     * @param draw Whether to draw the background color.
     */
    public void setDrawBackgroundColor(boolean draw) {
        properties.put("draw-background-color", draw);
    }

    //<editor-fold  defaultstate="collapsed" desc="ActorInScene ">
    /**
     * An actor inside a scene.
     */
    public static class ActorInScene implements Comparable<ActorInScene> {

        public BasicFile file;
        public int x;
        public int y;
        public Actor actor;

        public ActorInScene(BasicFile file) {
            this.file = file;
            try {
                this.actor = new Actor(file);
            } catch (SAXException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public int compareTo(ActorInScene other) {

            float z = 0;
            float oz = 0;

            try {
                z = actor.getZ();
            } catch (Exception e) {
            }

            try {
                oz = other.actor.getZ();
            } catch (Exception e) {
            }

            if (z == oz) {
                return 0;
            }

            return z < oz ? -1 : 1;
        }

        /**
         * Gets the image for this actor from the cache,
         * or loads it into the cache if it's not there.
         *
         * @return This actor's image.
         */
        public BufferedImage getImage() {
            BufferedImage img;
            if (actor != null && actor.getImage() != null) {
                img = Scene.getImage(actor.getImage());
                if (img == null) {
                    img = unknownImage;
                }
            } else {
                img = unknownImage;
            }
            return img;
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Scene Saving ">
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
            if (a.file != null) {
                Element actor = doc.createElement("actor");
                actor.setAttribute("x", String.valueOf(a.x));
                actor.setAttribute("y", String.valueOf(a.y));
                actor.setAttribute("file", String.valueOf(a.file.getPath()));
                actors.appendChild(actor);
            }
        }
        root.appendChild(actors);

        /* Backgrounds */
        Element backgrounds = doc.createElement("backgrounds");
        for (Background b : this.backgrounds) {
            Element background = doc.createElement("background");
            if (b.image != null) {
                background.setAttribute("image", b.image.getPath());
            }
            
            background.setAttribute("hspeed", Double.toString(b.hspeed));
            background.setAttribute("vspeed", Double.toString(b.vspeed));
            background.setAttribute("x", Integer.toString(b.x));
            background.setAttribute("y", Integer.toString(b.y));
            background.setAttribute("hrepeat", Boolean.toString(b.hrepeat));
            background.setAttribute("vrepeat", Boolean.toString(b.vrepeat));
            background.setAttribute("draw-image", Boolean.toString(b.drawImage));
            
            backgrounds.appendChild(background);
        }
        root.appendChild(backgrounds);

        /* Properties */
        Element properties = doc.createElement("properties");
        Enumeration<Object> values = this.properties.elements();
        for (String key : this.properties.keySet()) {
            Object value = values.nextElement();
            if (key.equals("background-color")) {
                value = String.valueOf(((Color)value).getRGB());
            }
            Element property = doc.createElement("property");
            property.setAttribute("name", key);
            property.setAttribute("value", String.valueOf(value));
            properties.appendChild(property);
        }
        root.appendChild(properties);

        doc.appendChild(root);
        // Prepare the DOM document for writing
        Source source = new DOMSource(doc);
        Result result = null;

        // Write the DOM document to the file
        Transformer xformer;
        BufferedOutputStream out = new BufferedOutputStream(file.getWriter());
        result = new StreamResult(out);
        xformer = TransformerFactory.newInstance().newTransformer();
        xformer.transform(source, result);
        out.close();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="SceneImporter">
    private static final class SceneImporter implements ContentHandler {

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
        private boolean parsingBackgrounds;
        private boolean parsingProperties;
        private Event curEvent;
        private Scene scene;

        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
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


            if (localName.equalsIgnoreCase("fields")) {
                parsingFields = true;
            } else if (localName.equalsIgnoreCase("events")) {
                parsingEvents = true;
            } else if (localName.equalsIgnoreCase("actors")) {
                parsingActors = true;
            } else if (localName.equalsIgnoreCase("backgrounds")) {
                parsingBackgrounds = true;
            } else if (localName.equalsIgnoreCase("properties")) {
                parsingProperties = true;
            }

            if (parsingProperties && localName.equalsIgnoreCase("property")) {
                String name, value;
                name = atts.getValue("name");
                value = atts.getValue("value");
                if (name != null && value != null) {
                    Object v;
                    if (name.equals("width") || name.equals("height")) {
                        v = Integer.parseInt(value);
                    } else if (name.equals("draw-background-color")) {
                        v = Boolean.parseBoolean(value);
                    } else if (name.equals("background-color")) {
                        v = Color.decode(value);
                    } else {
                        v = value;
                    }
                    scene.properties.put(name, v);
                } else if (name == null) {
                    System.err.println("Warning: null property name. Property ignored");
                } else {
                    System.err.println("Warning: null property value. Property ignored");
                }

            } else if (parsingFields && localName.equalsIgnoreCase("field")) {
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
                String type = atts.getValue("type");
                if (type == null) {
                    System.err.println("ERROR: No type for event.");
                    return;
                }
                curEvent = new Event(type);
                parsingEvent = true;
                curEvent.setPineDL("");
            } else if (parsingActors && localName.equalsIgnoreCase("actor")) {
                BasicFile file = null;
                String path = atts.getValue("file");
                try {
                    if (path != null) {
                        file = PineappleCore.getProject().getManager().getFile(path);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (file != null) {
                    ActorInScene unit = new ActorInScene(file);
                    unit.x = Integer.parseInt(atts.getValue("x"));
                    unit.y = Integer.parseInt(atts.getValue("y"));
                    scene.actors.add(unit);
                } else {
                    System.err.println("Warning: error creating file. Tag ignored.");
                }
                
            } else if (parsingBackgrounds && localName.equalsIgnoreCase("background")) {
                Background b = new Background();
                String s = atts.getValue("image");
                if (s != null) {
                    try {
                        b.image = PineappleCore.getProject().getManager().getFile(s);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, "Could not load image "+s, ex);
                    }
                }
                b.hspeed = Double.parseDouble(atts.getValue("hspeed"));
                b.vspeed = Double.parseDouble(atts.getValue("vspeed"));
                b.x = Integer.parseInt(atts.getValue("x"));
                b.y = Integer.parseInt(atts.getValue("y"));
                b.hrepeat = Boolean.parseBoolean(atts.getValue("hrepeat"));
                b.vrepeat = Boolean.parseBoolean(atts.getValue("vrepeat"));
                b.drawImage = Boolean.parseBoolean(atts.getValue("draw-image"));

                scene.backgrounds.add(b);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equalsIgnoreCase("actor") && !parsingEvents && !parsingEvent && 
                    !parsingFields && !parsingActors && !parsingProperties) {
                parsing = false;
                return;
            }
            if (!parsing) {
                return;
            }

            if (parsingProperties && localName.equalsIgnoreCase("properties")) {
                parsingProperties = false;
            } else if (parsingFields && localName.equalsIgnoreCase("fields")) {
                parsingFields = false;
            } else if (parsingActors && localName.equalsIgnoreCase("actors")) {
                parsingActors = false;
            } else if (parsingEvents && localName.equalsIgnoreCase("events")) {
                parsingEvents = false;
            } else if (parsingBackgrounds && localName.equalsIgnoreCase("backgrounds")) {
                parsingBackgrounds = false;
            } else if (parsingEvents && parsingEvent && localName.equalsIgnoreCase("event")) {
                parsingEvent = false;
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
                curEvent.setPineDL(curEvent.getPineDL() + s);
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

    /**
     * Stores background information.
     */
    public static class Background {

        public BasicFile image;
        public double hspeed, vspeed;
        public int x, y;
        public boolean hrepeat, vrepeat;
        public boolean drawImage;

        /**
         * Gets the image for this background from the cache,
         * loading it if it isn't already there.
         *
         * @return This background's image.
         */
        public BufferedImage getImage() {
            return Scene.getImage(image);
        }

    }
}
