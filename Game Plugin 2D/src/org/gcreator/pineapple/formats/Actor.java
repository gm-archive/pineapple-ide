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
package org.gcreator.pineapple.formats;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFolder;
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
 */
public class Actor extends BehaviorObject {

    public static final double MIN_VERSION = 1.003D;
    public static final double MAX_VERSION = 2.0D;
    /**
     * The actor version.
     */
    public static final double VERSION = 1.003D;
    /**
     * The actor's z coordinate
     */
    public float z = 0;
    
    /**
     * The sprite's image
     */
    public BasicFile image = null;

    /**
     * Whether to blit the sprite's image automatically during the game
     * (as opposed to manually, which the programmer must add a function to
     * the draw event to blit the sprite)
     */
    public boolean renderAutomatically = true;
    
    /**
     * The parent of this actor. May be <tt>null</tt>.
     */
    public BasicFile parent;
    
    /**
     * If an actor is <tt>barren</tt>, then it can have no children, just like
     * <tt>final</tt> classes in Java.
     */
    public boolean barren = false;
    
    /**
     * Creates a new actor
     */
    public Actor() {
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
        new ActorImporter(this, new BufferedInputStream(file.getReader()));
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
        root.setAttribute("z", Float.toString(this.z));
        root.setAttribute("barren", Boolean.toString(this.barren));
        root.setAttribute("render-automatically", Boolean.toString(this.renderAutomatically));

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

        /* Image */
        Element img = doc.createElement("image");
        if (this.image != null) {
            img.setTextContent(this.image.getPath());
        } else {
            img.setTextContent("");
        }
        root.appendChild(img);
        
        /* Parent */
        Element prnt = doc.createElement("parent");
        if (this.parent != null) {
            prnt.setTextContent(this.parent.getPath());
        } else {
            prnt.setTextContent("");
        }
        root.appendChild(prnt);

        /* Events */
        Element events = doc.createElement("events");
        for (Event e : this.events) {
            Element event = doc.createElement("event");
            event.setAttribute("type", e.getType());
            event.setTextContent(e.getPineDL());
            events.appendChild(event);
        }

        root.appendChild(events);

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
        private boolean parsingImage;
        private boolean parsingParent;
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
                actor.z = Float.valueOf(atts.getValue("z"));
                actor.renderAutomatically = Boolean.valueOf(atts.getValue("render-automatically"));
                actor.barren = Boolean.valueOf(atts.getValue("barren"));
                return;
            }

            if (!parsing) {
                return;
            }

            if (localName.equalsIgnoreCase("fields")) {
                parsingFields = true;
            } else if (localName.equalsIgnoreCase("events")) {
                parsingEvents = true;
            } else if (localName.equalsIgnoreCase("image")) {
                parsingImage = true;
            } else if (localName.equalsIgnoreCase("parent")) {
                parsingParent = true;
            }

            if (parsingImage) {
            } else if (parsingParent) {
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
            if (localName.equalsIgnoreCase("actor") && parsing && !parsingEvents && !parsingEvent && !parsingFields && !parsingImage && !parsingParent) {
                parsing = false;
                return;
            }
            

            if (parsingImage) {
                parsingImage = false;
            } else if (parsingParent) {
                parsingParent = false;
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
            if (parsingImage) {
                actor.image = getFile(s, PineappleCore.getProject());
            } else if (parsingParent) {
                actor.parent = getFile(s, PineappleCore.getProject());
            } else if (parsingEvent) {
                curEvent.setPineDL(curEvent.getPineDL()+s);
            }
        }

        private BasicFile getFile(String s, Project p) {
            for (ProjectElement e : p.getFiles()) {
                if (e instanceof ProjectFolder) {
                    return getFile(s, (ProjectFolder) e);
                } else if (e.getFile().getPath().equals(s)) {
                    return e.getFile();
                }
            }
            return null;
        }

        private BasicFile getFile(String s, ProjectFolder p) {
            for (ProjectElement e : p.getChildren()) {
                if (e instanceof ProjectFolder) {
                    return getFile(s, (ProjectFolder) e);
                } else if (e.getFile().getPath().equals(s)) {
                    return e.getFile();
                }
            }
            return null;
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
