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

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.gcreator.actions.Action;
import org.gcreator.actions.ActionType;
import org.gcreator.events.Event;
import org.gcreator.project.io.BasicFile;
import org.gcreator.xml.Node;
import org.gcreator.xml.SAXImporter;
import org.xml.sax.SAXException;

/**
 * An utility class to load and save Actor data.
 * @author Luís Reis
 */
public class Actor {

    public class Variable{
        public String type = "int";
        public String name = "lives";
        public boolean isStatic = false;
    }
    
    public Vector<Event> events = new Vector<Event>();
    public Vector<Variable> vars = new Vector<Variable>();

    /**
     * Creates a new actor
     */
    public Actor(){
        
    }
    
    /**
     * Loads an actor stored in a file.
     * 
     * @param file The file to load.
     * @throws IOException If an IO error loading the actor occurs
     * @throws SAXException If the Actor fails to load due to a XML error.
     */
    public Actor(BasicFile file) throws IOException, SAXException {
        InputStream is = file.getInputStream();
        SAXImporter sax = new SAXImporter(is);
        Node root = sax.getDocumentRoot();
        if (!root.getName().equals("actor")) {
            throw new SAXException("XML file is not actor");
        }
        double d = root.getAttributeValueAsDouble("version");
        if (d == Double.NaN) {
            throw new SAXException("Error retrieving actor version");
        }
        if (d < 1.0 || d >= 2) {
            //Version is 1.0, but 1.x should be backwards-compatible
            throw new SAXException("Unrecognized actor version");
        }

        for (Node child : root.getChildren()) {
            if (child.getName().equals("vars")) {
                for (Node n : child.getChildren()) {
                    if(n.getName().equals("var")){
                        Variable v = new Variable();
                        v.name = n.getContent();
                        v.type = n.getAttributeValue("type");
                        if(v.type==null){
                            throw new SAXException("Variable type not specified");
                        }
                        String sta = n.getAttributeValue("static");
                        if(sta==null){
                            throw new SAXException("Did not specify whether variable is static or not");
                        }
                        if(sta.toLowerCase().equals("true")){
                            v.isStatic = true;
                        }
                    }
                }
            }
            if (child.getName().equals("event")) {
                String type = child.getAttributeValue("type");
                if(type==null||type.length()==0){
                    throw new SAXException("Event type is null");
                }
                Event e = new Event();
                e.type = type;
                e.actions = parseActions(child);
                events.add(e);
            }
            //Don't complain if different tag is found
            //in order to make forward-compatibility easier
        }
    }

    private Vector<Action> parseActions(Node root) throws SAXException{
        Vector<Action> actions = new Vector<Action>();
        for (Node action : root.getChildren()) {
            if (!action.getName().equals("action")) {
                throw new SAXException("Non-action tag inside action list");
            }
            String clsName = action.getAttributeValue("type");
            if(clsName==null){
                throw new SAXException("Undefined class name");
            }
            ActionType type = null;
            
            for(ActionType actionType : ActionType.actionTypes){
                if(actionType.getClass().getName().equals(clsName)){
                    type = actionType;
                    break;
                }
            }
            
            if(type==null){
                throw new SAXException("Unspecified or unrecognized type");
            }
            Action act = new Action(type);
            
            act.children = parseActions(action);
        }
        return actions;
    }
}
