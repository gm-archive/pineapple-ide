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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
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
import org.gcreator.actions.Action;
import org.gcreator.actions.ActionType;
import org.gcreator.events.Event;
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
 * An utility class to load and save Actor data.
 * 
 * @author Luís Reis
 */
public class Actor extends BehaviorObject{


    
    /**
     * The actor version.
     */
    public static final double VERSION = 1.002D;

    /**
     * The actor's z coordinate
     */
    public float z = 0;
    
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
        new ActorImporter(this, new BufferedInputStream(file.getInputStream()));
    }

    //<editor-fold defaultstate="collapsed" desc="Actor Saving">
    /**
     * Saves the actor to a {@lin BasicFile}.
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
        root.setAttribute("z", Float.toString(z));

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
            event.setAttribute("type", e.type);
            for (Action a : e.actions) {
                Element action = doc.createElement("action");
                action.setAttribute("type", a.getType().getClass().getName());
                action.setTextContent(a.getType().save(a));
                event.appendChild(action);
            }
            events.appendChild(event);
        }

        root.appendChild(events);

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
    
    //<editor-fold defaultstate="collapsed" desc="ActorImporter">
    private final class ActorImporter implements ContentHandler {

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
        private boolean parsingAction;
        private Event curEvent;
        private Action curAction;
        private Actor actor;
        
        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        
        
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

            if (localName.equalsIgnoreCase("actor")) {
                String version = atts.getValue("version");
                if (version == null) {
                    System.err.println("FATAL ERROR: No actor version.");
                    parsing = false;
                } else if (!Double.valueOf(version).equals(Double.valueOf(VERSION))) {
                    System.err.println("FATAL ERROR: Invalid actor version: " + version + ", current: " + VERSION);
                    parsing = false;
                } else {
                    parsing = true;
                }
                z = Float.valueOf(atts.getValue("z"));
                return;
            }

            if (!parsing) {
                return;
            }

            if (localName.equalsIgnoreCase("fields")) {
                parsingFields = true;
            } else if (localName.equalsIgnoreCase("events")) {
                parsingEvents = true;
            } else if (localName.equalsIgnoreCase("event")) {
                parsingEvent = true;
            } else if (localName.equalsIgnoreCase("action")) {
                parsingAction = true;
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

                this.actor.fields.add(f);
            } else if (parsingEvents && localName.equalsIgnoreCase("event")) {
                String type = atts.getValue("type");
                if (type == null) {
                    System.err.println("ERROR: No type for event.");
                    return;
                }
                curEvent = new Event();
                parsingEvent = true;
            } else if (parsingEvent && parsingAction && localName.equalsIgnoreCase("action")) {
                String className = atts.getValue("type");
                if (className == null) {
                    System.err.println("ERROR: No class name for actor.");
                    return;
                }
                ActionType type = null;

                for (ActionType actionType : ActionType.actionTypes) {
                    if (actionType.getClass().getName().equals(className)) {
                        type = actionType;
                        break;
                    }
                }

                if (type == null) {
                    System.err.println("ERROR: Unknown action for class " + className + ".");
                    return;
                }
                
                curAction = new Action(type);
                curEvent.actions.add(curAction);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equalsIgnoreCase("actor") && !parsingEvents && !parsingEvent && !parsingFields && !parsingAction) {
                parsing = false;
                return;
            }
            if (!parsing) {
                return;
            }

            if (parsingFields && localName.equalsIgnoreCase("fields")) {
                parsingFields = false;
            } else if (parsingEvents && localName.equalsIgnoreCase("events")) {
                parsingEvents = false;
            } else if (parsingEvents && parsingEvent && localName.equalsIgnoreCase("event")) {
                parsingEvent = false;
                actor.events.add(curEvent);
                curEvent = null;
            } else if (parsingAction && localName.equalsIgnoreCase("action")) {
                //if (curAction.parent == null || curAction.parent == baseAction) {
                    parsingAction = false;
                //}
                //curAction = curAction.parent;
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
            if(parsingAction){
                String s = "";
                for(int i = 0; i < length; i++){
                    s += ch[i+start];
                }
                curAction.getType().load(curAction, s);
            }
            /**else=No one cares*/
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
