/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

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
package org.gcreator.project.standard;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.gcreator.gui.CopyFileDialog;
import org.gcreator.gui.PineappleGUI;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectFolder;
import org.gcreator.project.io.BasicFile;
import org.gcreator.project.io.ProjectManager;
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
 * Defualt implementation of {@link ProjectManager}
 * for {@link DefaultProject} that uses the file system
 * for storing files.
 * 
 * @author Serge Humphrey
 */
public class DefaultProjectManager implements ProjectManager {

    protected DefaultProject project;
    public static final String[] PROJECT_TYPES = new String[]{
        /* Pineapple Project File */
        "pmf",
    };
    public static final float PROJECT_VERSION = 1.05F;

    /**
     * Creates a new manger, with a given project.
     * 
     * @param p The {@link Project} that manager belongs for.
     * This may not be <tt>null</tt>.
     * 
     * @throws NullPointerException If the given project is <tt>null</tt>.
     */
    public DefaultProjectManager(DefaultProject p) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException("Project may not be null.");
        }
        this.project = p;
    }

    /**
     * Creates a new manger, and loads the project from a file.
     * 
     * @param f The {@link java.io.File} to load.
     * @param folder The folder for the project.
     * @param type The project type for the project.
     * @param initial The {@link DefaultProject} to load the file to.
     * If this is <tt>null</tt>, a new {@link DefaultProject} will be created.
     * @throws NullPointerException If the given project is <tt>null</tt>.
     */
    public DefaultProjectManager(File f, File folder, DefaultProjectType type, DefaultProject initial) throws NullPointerException {
        if (f == null) {
            throw new NullPointerException("File may not be null.");
        }
        this.project = load(f, folder, type, initial);
    }

    /**
     * Not supported.
     */
    public void save(File f) {
        //Save the project anyway.
        saveToManifest();
    }

    /**
     * {@inheritDoc}
     */
    public BasicFile createFile(ProjectFolder folder, String name, String type) {
        File f = new File(
                ((folder == null) ? project.getProjectFolder() : ((FileFile) folder.getFile()).file),
                name + "." + type);
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileFile ff = new FileFile(f, project);
        if (folder == null) {
            try {
                project.add(project.createElement(ff));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            folder.reload();
        }
        return ff;
    }

    /**
     * {@inheritDoc}
     */
    public BasicFile createFolder(ProjectFolder folder, String name) {
        File f = new File(
                ((folder == null) ? project.getProjectFolder() : ((FileFile) folder.getFile()).file),
                name);
        f.mkdir();
        FileFile ff = new FileFile(f, project);
        if (folder == null) {
            try {
                project.add(project.createElement(ff));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            folder.reload();
        }
        return ff;
    }

    /**
     * Creates a new {@link Project} from a {@link java.io.File}.
     * 
     * @param f The {@link java.io.File} to be loaded.
     * @param folder The folder dor the project.
     * @param t The project type for te project.
     * @param initial The {@link DefaultProject} to load the file to.
     * If this is <tt>null</tt>, a new {@link DefaultProject} will be created.
     * @return A new {@link Project} created from the given {@link java.io.File}.
     * 
     * @see #getProjectFileTypes() 
     * @see #allowsProject(java.io.File) 
     */
    public DefaultProject load(File f, File folder, DefaultProjectType t, DefaultProject initial) {
        if (initial == null) {
            initial = new DefaultProject(null, folder, t, this, false);
        }
        String format;
        int i = f.getName().lastIndexOf('.');
        if (i == -1 || i == f.getName().length()) {
            format = null;
        } else {
            format = f.getName().substring(i + 1);
        }
        if (format == null) {
            System.err.println("Error: File " + f + " has null format");
            return null;
        }

        /* Pineapple Manifest File */
        if (format.equals("pmf")) {
            loadFromManifest(f, initial);
        }

        return initial;
    }

    public static String[] getProjectFileTypes() {
        return PROJECT_TYPES;
    }

    /**
     * {@inheritDoc}
     */
    public String[] getImportFileTypes() {
        return null; /* No Importing supported yet. */
    }

    /**
     * {@inheritDoc}
     */
    public String[] getExportFileTypes() {
        return null; /* No Exporting supported yet. */
    }

    /**
     * Saves the project to a manifest.
     * 
     */
    protected synchronized void saveToManifest() {
        if (project == null || project.getProjectFolder() == null || project.managing) {
            return;
        }
        try {
            project.managing = true;
            File f = new File(project.getProjectFolder().getPath() + File.separator + "project.pmf");
            if (!f.exists()) {
                f.createNewFile();
            }
            DocumentBuilder builder = createDocumentBuilder();
            if (builder == null) {
                System.err.println("Error: can't save projct XML to null builder.");
                return;
            }
            Document doc = builder.newDocument();
            doc.setXmlStandalone(true);
            doc.setXmlVersion("1.0");
            Element root = doc.createElement("pineapple-project");
            root.setAttribute("version", Float.toString(PROJECT_VERSION));
            root.setAttribute("name", project.getName());
            /* Files */
            Element files = doc.createElement("files");
            for (ProjectElement p : project.getFiles()) {
                Element elem = doc.createElement("file");
                elem.setAttribute("path", p.getFile().getPath());
                files.appendChild(elem);
            }
            root.appendChild(files);

            /* Settings */
            Element settings = doc.createElement("settings");
            for (String s : project.settings.keySet()) {
                Element setting = doc.createElement("setting");
                setting.setAttribute("key", s);
                setting.setAttribute("value", project.settings.get(s));
                settings.appendChild(setting);
            }
            root.appendChild(settings);

            doc.appendChild(root);
            // Prepare the DOM document for writing
            Source source = new DOMSource(doc);
            Result result = null;

            // Write the DOM document to the file
            Transformer xformer;
            result = new StreamResult(new FileOutputStream(f));
            xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch (IOException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            project.managing = false;
        }
    }

    protected static DocumentBuilder createDocumentBuilder() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Loads a project from a manifest.
     * 
     * @param f The manifest file to load.
     * @param project The project to apply the manifest to.
     */
    protected synchronized void loadFromManifest(File f, DefaultProject project) {
        if (project.managing) {
            return;
        }
        try {
            project.managing = true;
            synchronized (this) {
                new ProjectXMLHandler(f, project);
            }
            this.project = project;
        } catch (SAXException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            project.managing = false;
        }
    }

    public Project getProject() {
        return project;
    }

    /**
     * {@inheritDoc}
     */
    public void importFile(File f) {
    }

    /**
     * {@inheritDoc}
     */
    public void exportFile(File f) {
    }

    /**
     * {@inheritDoc}
     */
    public BasicFile moveFileToProject(File file, ProjectFolder folder, String newName) {
        File newFile = copyFile(file, newName,
                ((folder != null) 
                ? ((FileFile)folder.getFile()).file
                : project.getProjectFolder()));
        
        BasicFile f = new FileFile(newFile, project);
        if (folder != null) {
            folder.reload();
        } else {
            try {
                project.add(project.createElement(f));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return f;
    }

    private File copyFile(File file, String newName, File folder) {
        File newFile = null;
        if (!file.exists()) {
            System.out.println("File "+file+" does not exist");
            return null;
        }
        if (file.isFile()) {
            BufferedOutputStream out = null;
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(new FileInputStream(file));
                newFile = new File(folder, newName);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                out = new BufferedOutputStream(new FileOutputStream(newFile));
                int r;
                while ((r = in.read()) != -1) {
                    out.write(r);
                }
                PineappleGUI.tree.updateUI();
            } catch (IOException ex) {
                Logger.getLogger(CopyFileDialog.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(CopyFileDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (file.isDirectory()) {
            newFile = new File(folder, newName);
            if (!newFile.exists()) {
                newFile.mkdir();
            }
            for (File f : file.listFiles()) {
                copyFile(f, f.getName(), newFile);
            }
        }
        return newFile;
    }

    private final class ProjectXMLHandler implements ContentHandler {

        private Locator locator;
        private  boolean files, settings;
        private boolean loading;
        private DefaultProject project;

        public ProjectXMLHandler(File f, DefaultProject p) throws SAXException, FileNotFoundException, IOException {
            this.project = p;
            XMLReader r = XMLReaderFactory.createXMLReader();
            r.setContentHandler(this);
            InputStream in = new BufferedInputStream(new FileInputStream(f));
            r.parse(new InputSource(in));
        }

        /**
         * {@inheritDoc}
         */
        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        /**
         * {@inheritDoc}
         */
        public void startDocument() throws SAXException {
            // Nothing to do here.
        }

        /**
         * {@inheritDoc}
         */
        public void endDocument() throws SAXException {
            // Nothing to do here.
        }

        /**
         * {@inheritDoc}
         */
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("Nobody cares about Namespace '" + prefix + "', Namespace URI " + uri);
        }

        /**
         * {@inheritDoc}
         */
        public void endPrefixMapping(String prefix) throws SAXException {
            System.out.println("A request was made to end Namespace '" + prefix + "', but no one cares");
        }

        /**
         * {@inheritDoc}
         */
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            if (localName.equalsIgnoreCase("pineapple-project")) {

                String version = atts.getValue("version");
                if (version == null) {
                    System.err.println("FATAL ERROR: No project version.");
                    loading = false;
                } else if (version.equals(Float.toString(PROJECT_VERSION))) {
                    loading = true;
                } else {
                    System.err.println("FATAL ERROR: Wrong project version: " + version + " :: required: " + PROJECT_VERSION);
                    loading = false;
                }

                String name = atts.getValue("name");
                if (name == null) {
                    System.out.println("WARNING: No 'name' attribute to project. Using default.");
                    project.setName("Project");
                } else {
                    project.setName(name);
                }
                return;

            } else if (localName.equalsIgnoreCase("files")) {
                files = true;
                return;
            } else if (localName.equalsIgnoreCase("settings")) {
                settings = true;
                return;
            }

            if (!loading) {
                System.err.println("WARINING: invalid request to load element '" + qName +
                        "' when pineapple-project element has not yet been parsed.");
                return;
            }

            if (files) {
                String path = atts.getValue("path");
                if (path == null) {
                    System.err.println("ERROR: No path attribute for file.");
                } else {
                    File file = new File(project.getProjectFolder(), path.substring(1));
                    if (!file.exists()) {
                        System.err.println("ERROR: file " + file + " does not exist.");
                        return;
                    }
                    try {
                        project.add(project.createElement(new FileFile(file, project)));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(DefaultProjectManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (settings) {
                String key = atts.getValue("key");
                String value = atts.getValue("value");
                if (key == null) {
                    System.err.println("ERROR: no 'key' attribute for setting.");
                    return;
                } else if (value == null) {
                    System.err.println("ERROR: no 'value' attribute for setting.");
                    return;
                }
                project.settings.put(key, value);
            } else {
                System.err.println("WARNING: unrecegnized element '" + qName + "'");
            }
        }

        /**
         * {@inheritDoc}
         */
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!loading) {
                return;
            }
            if (localName.equalsIgnoreCase("pineapple-project")) {
                loading = false;
            } else if (localName.equalsIgnoreCase("files")) {
                files = false;
            } else if (localName.equalsIgnoreCase("settings")) {
                settings = false;
            }
        }

        /**
         * {@inheritDoc}
         */
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("NOTE: Charachters '" + Arrays.copyOfRange(ch, start, start + length) + "'");
        }

        /**
         * {@inheritDoc}
         */
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("NOTE: Ignorable Witespace '" + Arrays.copyOfRange(ch, start, start + length) + "'");
        }

        /**
         * {@inheritDoc}
         */
        public void processingInstruction(String target, String data) throws SAXException {
            System.out.println("NOTE: Processing '" + target + "', data '" + data + "'");
        }

        /**
         * {@inheritDoc}
         */
        public void skippedEntity(String name) throws SAXException {
            System.out.println("NOTE: Skipped Entity '" + name + "'");
        }
    }
}
