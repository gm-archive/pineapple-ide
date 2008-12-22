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
public class Actor {

    //<editor-fold defaultstate="collapsed" desc="class Field">
    /**
     * A simplex class that stores all of the data for a field.
     */
    public static class Field {

        protected String type;
        protected String name;
        protected String defaultValue;
        protected boolean isStatic;
        protected boolean isFinal;

        /**
         * Creates a new {@link Field} that is not static and has
         * no default value.
         * 
         * @param name The field's name.
         * @param type The field's type.
         */
        public Field(String name, String type) {
            this(name, type, false, null);
        }

        /**
         * Creates a new {@link Field} that has no default value.
         * 
         * @param name The field's name.
         * @param type The field's type.
         * @param isStatic Whether the field is static or not.
         */
        public Field(String name, String type, boolean isStatic) {
            this(name, type, isStatic, null);
        }

        /**
         * Creates a new {@link Field}.
         * 
         * @param name The field's name.
         * @param type The field's type.
         * @param isStatic Whether the field is static or not.
         * @param defaultValue The default value for the field.
         */
        public Field(String name, String type, boolean isStatic, String defaultValue) {
            this(name, type, isStatic, false, defaultValue);
        }

        /**
         * Creates a new {@link Field}.
         * 
         * @param name The field's name.
         * @param type The field's type.
         * @param isStatic Whether the field is static or not.
         * @param isFinal Whether the field is final or not.
         * @param defaultValue The default value for the field.
         */
        public Field(String name, String type, boolean isStatic, boolean isFinal, String defaultValue) {
            this.name = name;
            this.type = type;
            this.isStatic = isStatic;
            this.isFinal = isFinal;
            this.defaultValue = defaultValue;
        }
        
        protected Field() {
        }

        /**
         * Gets the type of this field, e.g. <tt>int</tt>.
         * 
         * @return The type of this field.
         */
        public String getType() {
            return type;
        }

        /**
         * Gets the name of this field, e.g. <tt>x</tt>.
         * 
         * @return The name of this variable.
         */
        public String getName() {
            return name;
        }

        /**
         * Gets whether the field is <tt>static</tt> or not.
         * 
         * @return <tt>true</tt> if this field is <tt>static</tt>, else <tt>false</tt>.
         */
        public boolean isStatic() {
            return isStatic;
        }

        /**
         * Gets the default value of this field.
         * 
         * @return This field's default value.
         */
        public String getDefaultValue() {
            return defaultValue;
        }

        /**
         * Gets whether this fields is <tt>final</tt> or not.
         * 
         * @return <tt>true</tt> if this field is <tt>final</tt>, else <tt>false</tt>.
         */
        public boolean isFinal() {
            return isFinal;
        }
        
        /**
         * Sets the type of the field.
         * 
         * @param type The new type for this field.
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * Sets the name of this field.
         * 
         * @param name The new name for the field.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets whether this field is </tt>static<tt> or not.
         * 
         * @param isStatic Whether this field should be static
         * or not.
         */
        public void setStatic(boolean isStatic) {
            this.isStatic = isStatic;
        }

        /**
         * Sets the default value for this field.
         * 
         * @param defaultValue The new default value for this
         * field.
         */
        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }
        
        /**
         * Sets whether this field is <tt>final</tt> or not.
         * 
         * @param isFinal Whether this field hsould be <tt>final</tt> or not.
         */
        public void setFinal(boolean isFinal) {
            this.isFinal = isFinal;
        }
        
    }
    //</editor-fold>
    
    /**
     * The actor version.
     */
    public static final double VERSION = 1.002D;
    /**
     * This actor's events.
     */
    public Vector<Event> events = new Vector<Event>();
    /**
     * This actor's fields.
     */
    public Vector<Field> fields = new Vector<Field>();

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
                action.setAttribute("type", a.getType().save(a));
                saveAction(a, action, doc);
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

    private void saveAction(Action a, Element e, Document doc) {
        for (Action child : a.getChildren()) {
            Element action = doc.createElement("action");
            action.setAttribute("type", child.getType().save(child));
            e.appendChild(action);
            saveAction(child, action, doc);
        }
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
        private Actor actor;
        private Action baseAction;
        private Action curAction;

        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

            if (localName.equalsIgnoreCase("actor")) {
                String version = atts.getValue("version");
                if (version == null) {
                    System.err.println("FATAL ERROR: No actor version.");
                    parsing = false;
                } else if (Double.valueOf(version) != Double.valueOf(VERSION)) {
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
                if (baseAction == null) {
                    baseAction = new Action(type);
                    curAction = baseAction;
                } else {
                    Action a = new Action(type);
                    a.parent = curAction;
                    curAction.addAction(a);
                    curAction = a;
                }
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
                if (curAction.parent == null || curAction.parent == baseAction) {
                    baseAction = null;
                    curAction = null;
                    parsingAction = false;
                }
                curAction = curAction.parent;
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
            /* No one cares. */
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
