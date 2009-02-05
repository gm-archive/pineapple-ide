/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008-2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pinedl;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * A PineDL interface reader.
 * 
 * @author Luís Reis
 */
public class PDI {

    public String pkg;
    public String clsname;
    public String bclass;
    public Vector<String> imports = new Vector<String>();
    public Vector<Method> methods = new Vector<Method>();
    public Vector<Field> fields = new Vector<Field>();
    public Vector<Constructor> constructors = new Vector<Constructor>();

    public PDI() {
    }

    public PDI(File f) throws IOException, SAXException {
        try {
            /* NOTE: Some (or all) of the XML parsing may not work.
                     The attribute thing is really stupid for W3C Nodes. */
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);

            Element root = doc.getDocumentElement();
            if (!root.getLocalName().equals("pdi")) {
                throw new SAXException("Invalid PDI file");
            }

            double d = Double.parseDouble(root.getAttribute("version"));
            if (d == Double.NaN) {
                throw new SAXException("Unrecognized PDI version");
            }
            clsname = root.getAttribute("name");
            if (clsname == null) {
                throw new SAXException("Invalid format");
            }
            bclass = root.getAttribute("extends");
            boolean hasPkg = false;
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getLocalName().equals("package")) {
                    if (hasPkg) {
                        throw new SAXException("Invalid format: Duplicated package statements.");
                    }
                    pkg = node.getTextContent();
                } else if (node.getLocalName().equals("import")) {
                    imports.add(node.getTextContent());
                } else if (node.getLocalName().equals("method")) {
                    Method m = new Method();
                    m.privacy = node.getAttributes().getNamedItem("privacy").getTextContent();
                    if (m.privacy == null) {
                        throw new SAXException("No method privacy specified");
                    }
                    m.isStatic = Boolean.parseBoolean(node.getAttributes().getNamedItem("static").getTextContent());
                    m.returnType = node.getAttributes().getNamedItem("return").getTextContent();
                    if (m.returnType == null) {
                        throw new SAXException("No return type specified");
                    }
                    m.name = node.getAttributes().getNamedItem("name").getTextContent();
                    if (m.name == null) {
                        throw new SAXException("No method name given");
                    }
                    for (int j = 0; j < node.getChildNodes().getLength(); j++) {
                        Node arg = node.getChildNodes().item(j);
                        if (!arg.getLocalName().equals("argument")) {
                            throw new SAXException("Invalid child node of method");
                        }
                        Argument a = new Argument(arg.getAttributes().getNamedItem("type").getTextContent(), arg.getAttributes().getNamedItem("name").getTextContent());
                        m.arguments.add(a);
                    }
                    methods.add(m);
                } else if (node.getLocalName().equals("constructor")) {
                    Constructor c = new Constructor();
                    c.privacy = node.getAttributes().getNamedItem("privacy").getTextContent();
                    if (c.privacy == null) {
                        throw new SAXException("No method privacy specified");
                    }
                    for (int j = 0; j < node.getChildNodes().getLength(); j++) {
                        Node arg = node.getChildNodes().item(j);
                        if (!arg.getLocalName().equals("argument")) {
                            throw new SAXException("Invalid child node of method");
                        }
                        Argument a = new Argument(arg.getAttributes().getNamedItem("type").getTextContent(), arg.getAttributes().getNamedItem("name").getTextContent());
                        c.arguments.add(a);
                    }
                    constructors.add(c);
                } else if (node.getLocalName().equals("field")) {
                    Field v = new Field();
                    v.privacy = node.getAttributes().getNamedItem("privacy").getTextContent();
                    if (v.privacy == null) {
                        throw new SAXException("No field privacy specified");
                    }
                    v.isStatic = Boolean.parseBoolean(node.getAttributes().getNamedItem("static").getTextContent());
                    v.type = node.getAttributes().getNamedItem("type").getTextContent();
                    if (v.type == null) {
                        throw new SAXException("No field type specified");
                    }
                    v.name = node.getAttributes().getNamedItem("name").getTextContent();
                    if (v.name == null) {
                        throw new SAXException("No field name given");
                    }
                    fields.add(v);
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(PDI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Generates the full class name
     */
    public String getFullClassName() {
        return pkg.equals("") ? bclass : pkg + "." + bclass;
    }
}
