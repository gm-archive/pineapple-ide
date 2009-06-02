/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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
 * An utility class to load and save Actor data.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class Actor extends ClassResource {

    public static final double MIN_VERSION = 1.003D;
    public static final double MAX_VERSION = 2.0D;
    /**
     * The actor version.
     */
    public static final double VERSION = 1.20D;

    /**
     * Where the actor's properties are stored.
     */
    protected Hashtable<String, Object> properties;

    /**
     * Creates a new actor
     */
    public Actor() {
        properties = new Hashtable<String, Object>();
        properties.put("render-automatically", true);
        properties.put("z", 0.0F);
    }

    /**
     * Loads an actor from a file.
     * 
     * @param file The file to load.
     * 
     * @throws SAXException In there is an error while parsing the <tt>XML</tt>.
     * @throws IOException If an IO error loading the actor occurs
     */
    public Actor(BasicFile file) throws SAXException, IOException {
        this();
        int i = file.getName().indexOf('.');
        if (i > 0) {
            this.setName(file.getName().substring(0, i));
        }
        new ActorImporter(this, new BufferedInputStream(file.getReader()));
    }

    /**
     * Gets the name of this actor.
     * 
     * @return This Actor's name.
     */
    public String getName() {
        return properties.get("name").toString();
    }

    /**
     * Sets this actor's name.
     *
     * @param name The new name for this actor.
     */
    public void setName(String name) {
        properties.put("name", name);
    }
    /**
     * Gets the parent of this actor, <tt>null</tt> if it has
     * not been set.
     *
     * @return This actor's parent.
     * @see #getParent()
     */
    public BasicFile getParent() {
        return (BasicFile)properties.get("parent");
    }

    /**
     * Sets this actor's parent.
     *
     * @param parent The new parent for this actor.
     */
    public void setParent(BasicFile parent) {
        properties.put("parent", parent);
    }

    /**
     * Get's this actor's image, or <tt>null</tt> if it
     * has not been set.
     *
     * @return This actor's image.
     */
    public BasicFile getImage() {
        try {
            return (BasicFile)properties.get("image");
        } catch (ClassCastException exc) {
            return null;
        }
    }

    /**
     * Sets this actor's image.
     *
     * @param image The new image for this actor.
     */
    public void setImage(BasicFile image) {
        if (image == null) {
            properties.remove("image");
        } else {
            properties.put("image", image);
        }
    }

    /**
     * Gets whether or not this actor's image is blitted
     * automatically during the game.
     *
     * @return Wheter or not this actor's image should be
     * drawn automatically during the game.
     */
    public boolean isAutoDrawn() {
        return (Boolean)properties.get("render-automatically");
    }

    /**
     * Sets whether to render this actor's image during the game.
     *
     * @param auto Whether or not to render this actor's image.
     */
    public void setAutoDraw(boolean auto) {
        properties.put("render-automatically", auto);
    }

    /**
     * Get's this actor's depth (z).
     *
     * @return This actor's z co-ordiante.
     */
    public float getZ() {
        return (Float)properties.get("z");
    }

    /**
     * Sets this actor's z co-ordinate.
     *
     * @param z The new depth value for this actor.
     */
    public void setZ(float z) {
        properties.put("z", z);
    }


    //<editor-fold defaultstate="collapsed" desc="Actor Saving">
    /**
     * Saves the actor to a {@link BasicFile}.
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
        Element root = doc.createElement("actor");
        root.setAttribute("version", Double.toString(VERSION));

        /* Fields */
        Element fields = doc.createElement("fields");
        for (Field f : this.fields) {
            Element field = doc.createElement("field");
            field.setAttribute("access", f.access.name());
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

        /* Properties */
        Element properties = doc.createElement("properties");
        Enumeration<Object> values = this.properties.elements();
        for (String key : this.properties.keySet()) {
            Object value = values.nextElement();
            Element property = doc.createElement("property");
            property.setAttribute("name", key);
            property.setAttribute("value", propertyString(value));
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
        xformer.setOutputProperty(OutputKeys.INDENT, "yes");
        xformer.transform(source, result);
        out.close();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ActorImporter">
    private static final class ActorImporter implements ContentHandler {

        public ActorImporter(Actor a, InputStream in) throws SAXException, IOException {
            this.actor = a;
            XMLReader r = XMLReaderFactory.createXMLReader();
            r.setContentHandler(this);
            r.parse(new InputSource(in));
            in.close();

        }
        private Locator locator;
        private boolean parsing;
        private boolean parsingFields;
        private boolean parsingEvents;
        private boolean parsingEvent;
        private boolean parsingProperties;
        private Event curEvent;
        private Actor actor;

        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            if (localName.equalsIgnoreCase("actor")) {
                String version = atts.getValue("version");
                double v = Double.valueOf(version);
                if (version == null) {
                    System.err.println("FATAL ERROR: No actor version.");
                    parsing = false;
                } else if (v < MIN_VERSION || v >= MAX_VERSION) {
                    System.err.println("FATAL ERROR: Invalid actor version: " + version + ", current: " + VERSION);
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
            } else if (localName.equalsIgnoreCase("properties")) {
                parsingProperties = true;
            }

            if (parsingProperties && localName.equalsIgnoreCase("property")) {
                String name, value;
                name = atts.getValue("name");
                value = atts.getValue("value");
                if (name != null && value != null) {
                    actor.properties.put(name, propertyValue(name, value));
                } else if (name == null) {
                    System.err.println("Warning: null property name. Property ignored");
                } else {
                    System.err.println("Warning: null property value. Property ignored");
                }
                
            } else if (parsingFields && localName.equalsIgnoreCase("field")) {
                String name, type, defaultValue, isStatic, isFinal, access;
                access = atts.getValue("access");
                name = atts.getValue("name");
                type = atts.getValue("type");
                defaultValue = atts.getValue("default-value");
                isStatic = atts.getValue("static");
                isFinal = atts.getValue("final");

                Field f = new Field();
                if (access != null) {
                    f.access = Field.Access.valueOf(access);
                } else {
                    f.access = Field.Access.PUBLIC;
                }
                f.name = name;
                f.type = type;
                f.defaultValue = defaultValue;
                f.isStatic = Boolean.parseBoolean(isStatic);
                f.isFinal = Boolean.parseBoolean(isFinal);

                this.actor.fields.add(f);
            } else if (parsingEvents && localName.equalsIgnoreCase("event")) {
                String type = atts.getValue("type");
                if (type == null) {
                    System.err.println("ERROR: No type for event.");
                    return;
                }
                curEvent = new Event(type);
                curEvent.setPineDL("");
                parsingEvent = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!parsing) {
                return;
            }
            if (localName.equalsIgnoreCase("actor") && parsing &&
                    !parsingEvents && !parsingEvent && !parsingFields && !parsingProperties) {
                parsing = false;
                return;
            }
            

            if (parsingProperties && localName.equalsIgnoreCase("properties")) {
                parsingProperties = false;
            } else if (parsingFields && localName.equalsIgnoreCase("fields")) {
                parsingFields = false;
            } else if (parsingEvents && localName.equalsIgnoreCase("events")) {
                parsingEvents = false;
            } else if (parsingEvents && parsingEvent && localName.equalsIgnoreCase("event")) {
                parsingEvent = false;
                actor.events.add(curEvent);
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
                curEvent.setPineDL(curEvent.getPineDL()+s);
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

    private static String propertyString(Object value) {
        if (value instanceof BasicFile) {
            return ((BasicFile)value).getPath();
        } else {
            return value.toString();
        }
    }

    private static Object propertyValue(String name, String value) {
        if (name.equals("image") || name.equals("parent")) {
            try {
                return PineappleCore.getProject().getManager().getFile(value);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (name.equals("z")) {
            return Float.valueOf(value);
        } else if (name.equals("render-automatically")) {
            return Boolean.valueOf(value);
        }
        return value;
    }
}
