package org.gcreator.pineapple.pinec.compiler.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Stack;
import org.gcreator.pineapple.pinec.parser.tree.ClassConstant;
import org.gcreator.pineapple.pinec.parser.tree.Document;
import org.gcreator.pineapple.pinec.parser.tree.Function;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Luís Reis
 */
public class APIImporter {
    private static final String mainNamespace =
            "http://www.g-creator.org/pineapple-doc/xmlformat-1.0.html";

    private static final int MAINNS = 0;
    private static final int COMMONSNS = 1;
    private final Library library;

    public APIImporter(final Library library){
        this.library = library;
    }

    private class ImporterContentHandler extends DefaultHandler{
        private Stack<APIClass> classNesting = new Stack<APIClass>();

        @Override
        public void startElement(String uri, String localName, String __UNUSED__,
                Attributes attribs){

            int elementParserMode = 0;

            if(uri.equals(mainNamespace)){
                elementParserMode = MAINNS;
            }
            else{
                System.out.println("Unknown namespace");
                return;
            }

            if(elementParserMode==MAINNS){
                if(localName.equals("api")){
                    return; //Ignore
                }
                else if(localName.equals("class")){
                    APIClass cls = new APIClass();

                    final int attrSize = attribs.getLength();
                    for(int i = 0; i < attrSize; ++i){
                        final String name = attribs.getLocalName(i);
                        
                        if(name.equals("name")){
                            cls.name = attribs.getValue(i);
                        }
                        else if(name.equals("internal")){
                            cls.internal = attribs.getValue(i).equalsIgnoreCase("true");
                        }
                        else{
                            System.out.println("Unrecognized class attribute");
                        }

                    }

                    library.addClass(cls);
                    classNesting.addElement(cls);

                    return;

                }
                else if(localName.equals("function")){

                    final APIClass cls = classNesting.peek();
                    final APIField field = new APIField();
                    field.variable = false;
                    final int attrSize = attribs.getLength();
                    for(int i = 0; i < attrSize; ++i){
                        final String name = attribs.getLocalName(i);

                        if(name.equals("name")){
                            field.name= attribs.getValue(i);
                        }
                        else if(name.equals("static")){
                            field.isStatic = attribs.getValue(i).equalsIgnoreCase("true");
                        }
                    }
                    cls.fields.add(field);
                }
                else if(localName.equals("const")){
                    final APIClass cls = classNesting.peek();
                    final APIField field = new APIField();
                    field.variable = false;
                    final int attrSize = attribs.getLength();
                    for(int i = 0; i < attrSize; ++i){
                        final String name = attribs.getLocalName(i);

                        if(name.equals("name")){
                            field.name= attribs.getValue(i);
                        }
                        else if(name.equals("static")){
                            field.isStatic = attribs.getValue(i).equalsIgnoreCase("true");
                        }
                    }
                    cls.fields.add(field);
                }

            }

        }

        @Override
        public void endElement(String uri, String localName, String __UNUSED__){
            int elementParserMode = 0;

            if(uri.equals(mainNamespace)){
                elementParserMode = MAINNS;
            }
            else{
                System.out.println("Unknown namespace");
            }

            if(elementParserMode==MAINNS){
                if(localName.equals("class")){
                    classNesting.pop();
                }
            }
        }
    }

    public void importLibrary(final InputStream is)
    throws IOException{
        importLibrary(new InputStreamReader(is, Charset.forName("UTF-8")));
    }

    public void importLibrary(final Reader reader)
    throws IOException{
        try{
            importLibraryImpl(reader);
        }
        catch(final SAXException e){
            throw new RuntimeException(e);
        }
    }

    public void importFromDocument(final Document document){
        for(final ClassConstant cls : document.classes){
            final APIClass api = new APIClass();
            api.name = cls.name;
            api.base = cls.base;

            for(final Function f : cls.functions){
                final APIField field = new APIField();
                field.name = f.getName();
                api.fields.add(field);
            }

            library.addClass(api);
        }
    }

    private void importLibraryImpl(final Reader reader) throws SAXException, IOException{

        final XMLReader xreader = XMLReaderFactory.createXMLReader();
        final ImporterContentHandler handler = new ImporterContentHandler();
        xreader.setContentHandler(handler);
        xreader.setDTDHandler(handler);
        xreader.setErrorHandler(handler);
        xreader.setEntityResolver(handler);
        xreader.parse(new InputSource(reader));

    }
}
