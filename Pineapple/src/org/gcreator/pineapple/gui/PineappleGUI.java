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
package org.gcreator.pineapple.gui;

//<editor-fold defaultstate="collapsed" desc="Import Statements">
import org.gcreator.pineapple.gui.MainFrame;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.managers.SettingsManager;
import org.gcreator.pineapple.plugins.DefaultEventTypes;
import org.gcreator.pineapple.plugins.EventHandler;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.managers.PluginManager;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventPriority;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFile;
import org.gcreator.pineapple.project.ProjectFolder;
import org.gcreator.pineapple.project.ProjectType;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.project.io.FormatSupporter;
import org.gcreator.pineapple.project.standard.DefaultFile;
import org.gcreator.pineapple.tree.BaseTreeNode;
import org.gcreator.pineapple.tree.FileTreeNode;
import org.gcreator.pineapple.tree.FolderTreeNode;
import org.gcreator.pineapple.tree.ProjectTreeNode;
import org.noos.xing.mydoggy.PersistenceDelegate.MergePolicy;
import org.noos.xing.mydoggy.ToolWindow;
import org.noos.xing.mydoggy.ToolWindowAnchor;
import org.noos.xing.mydoggy.plaf.MyDoggyToolWindowManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//</editor-fold>
/**
 * This deals with the main GUI stuff.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class PineappleGUI implements EventHandler {
    //<editor-fold defaultstate="collapsed" desc="Fields                       ">
    /**
     * The project tree
     */
    public static JTree tree;
    /**
     * The menubar of the application
     */
    public static JMenuBar menubar;
    /**
     * The file menu
     */
    public static JMenu fileMenu;
    /**
     * The project menu
     */
    public static JMenu projectMenu;
    /**
     * The edit menu
     */
    public static JMenu editMenu;
    /**
     * The tools menu
     */
    public static JMenu toolsMenu;
    /**
     * The help menu
     */
    public static JMenu     helpMenu;
    public static JMenuItem fileNewProject;
    public static JMenuItem fileOpenFile;
    public static JMenuItem fileOpenProject;
    public static JMenuItem fileSaveProject;
    public static JMenuItem fileSave;
    public static JMenuItem fileExit;
    public static JMenuItem toolsPlugins;
    public static JMenuItem projectRemove;
    public static JMenu     projectNew;
    public static JMenuItem projectOpen;
    public static JMenuItem projectAdd;
    public static JMenuItem projectImport;
    public static JMenuItem projectExport;
    public static JMenuItem projectDelete;
    public static JMenuItem projectFind;
    public static JMenuItem projectClose;
    public static JMenuItem helpAbout;
    /**
     * Provides a way to deal with multiple documents.
     */
    public static DocumentInterfaceProvider dip;
    /**
     * Allows docking
     */
    public static MyDoggyToolWindowManager manager;
    private DefaultTreeModel treeModel;
    protected static final DataFlavor ELEMENT_FLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType, "Project Element");    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Events                       ">
    /**
     * Event when a file is deleted from the filesystem.
     */
    public static final String FILE_DELETED = "file-deleted";
    /**
     * Event when a file is removed from the PineappleCore.getProject().
     */
    public static final String FILE_REMOVED = "file-removed";
    /**
     * Event when a file is renamed.
     */
    public static final String FILE_RENAMED = "file-renamed";
    /**
     * When a file is opened.
     * This event should have the opened File as the first argument.
     * File can be null.
     * The second argument should be the File format, even if the File is null.
     */
    public static final String FILE_OPENED = "file-opened";
    /**
     * When a file changes.
     */
    public static final String FILE_CHANGED = "file-changed";
    /**
     * When a project is opened
     */
    public static final String PROJECT_OPENED = "project-opened";
    /**
     * When a project is saved
     */
    public static final String PROJECT_SAVED = "project-saved";
    /**
     * When a file is imported to the project
     */
    public static final String PROJECT_IMPORTED = "file-project-imported";
    /**
     * When a project is exported to a file
     */
    public static final String PROJECT_EXPORTED = "file-project-exported";
    /**
     * When a popup menu is created on the tree
     */
    public static final String TREE_MENU_INVOKED = "tree-menu-invoked";
    /**
     * When a {@link JFileChooser} is shown.
     * 
     * @param arg0: The {@link JFileChooser} that was created.
     * @param arg1: A {@link String} that tells what the the dialog
     * is for (e.g. "open-image").
     */
    public static final String FILE_CHOOSER_CREATED = "file-chooser-created";
    
    /**
     * Called when the Pineapple GUI has been initialized.
     */
    public static final String PINEAPPLE_GUI_INITIALIZED = "pineapple-gui-initialized";
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="PineappleGUI()               ">
    /**
     * Created and initilizes a new Pineapple GUI.
     */
    public PineappleGUI() {
        initialize();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="initialize()                 ">
    /**
     * Initilizes the Pineapple GUI.
     */
    protected void initialize() {
        /* Core Events */
        EventManager.addEventHandler(this, DefaultEventTypes.APPLICATION_INITIALIZED, EventPriority.HIGH);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_DISPOSED, EventPriority.MEDIUM);
        /* Custom Events */

        EventManager.addEventHandler(this, FILE_OPENED, EventPriority.LOW);
        EventManager.addEventHandler(this, FILE_CHANGED, EventPriority.LOW);
        EventManager.addEventHandler(this, FILE_DELETED, EventPriority.LOW);
        EventManager.addEventHandler(this, FILE_REMOVED, EventPriority.LOW);
        EventManager.addEventHandler(this, FILE_RENAMED, EventPriority.LOW);
        EventManager.addEventHandler(this, TREE_MENU_INVOKED, EventPriority.HIGH);
        EventManager.addEventHandler(this, PROJECT_OPENED, EventPriority.HIGH);
        EventManager.addEventHandler(this, PROJECT_SAVED, EventPriority.HIGH);

        /* Other Events */
        EventManager.addEventHandler(this, PineappleCore.PROJECT_CHANGED, EventPriority.HIGH);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="initializeWindow()           ">
    /**
     * Initilize's the Pineapple Window.
     */
    protected void initializeWindow() {
        MainFrame f = Core.getStaticContext().getMainFrame();
        SwingUtilities.updateComponentTreeUI(f);
        f.setTitle("Pineapple IDE");
        f.setIconImage(new ImageIcon(getClass().getResource(
                "/org/gcreator/pineapple/pineapple.png")).getImage());

        manager = new MyDoggyToolWindowManager(Locale.getDefault(), PluginManager.getClassLoader());
        f.getContentPane().add(manager);

        //<editor-fold defaultstate="collapsed" desc="Tree Initialization">
        treeModel = new DefaultTreeModel(null);
        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setVisible(true);
        tree.setCellRenderer(new ProjectTreeRenderer());
        tree.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                TreePath trp = tree.getPathForRow(tree.getClosestRowForLocation(e.getX(), e.getY()));
                if (trp == null) {
                    return;
                }
                Object o = trp.getLastPathComponent();
                if (o == null) {
                    return;
                }
                if (e.getClickCount() >= 2 && e.getButton() == MouseEvent.BUTTON1 && o instanceof BaseTreeNode) {
                    BaseTreeNode node = (BaseTreeNode) o;
                    TreePath tp = tree.getClosestPathForLocation(e.getX(), e.getY());
                    tree.setSelectionPath(tp);

                    if (node != null && node instanceof FileTreeNode) {
                        openFile(node.getElement().getFile());
                    }
                } else if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu menu = new JPopupMenu("Tree");
                    EventManager.fireEvent(this, TREE_MENU_INVOKED, menu, o);
                    menu.show(tree, e.getX(), e.getY());
                }
            }
        });
        tree.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {



                try {
                    if (e.getKeyChar() == 'p' && e.isControlDown()) {
                        DefaultMutableTreeNode n = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                        for (TreeNode node : n.getPath()) {
                            System.out.print(((JLabel) tree.getCellRenderer().getTreeCellRendererComponent(tree, node, false, false, false, 0, false)).getText() + "/");
                        }
                    }
                } catch (Exception exc) {
                }



                TreePath tp = tree.getSelectionPath();
                if (tp == null) {
                    return;
                }
                Object o = tp.getLastPathComponent();
                if (o == null || !(o instanceof FileTreeNode)) {
                    return;
                }
                FileTreeNode t = (FileTreeNode) o;
                ProjectElement el = t.getElement();

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    openFile(el.getFile());
                } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteFile(el);
                }
            }
        });
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object o = e.getPath().getLastPathComponent();
                if (o == null || !(o instanceof BaseTreeNode)) {
                    projectRemove.setEnabled(false);
                    projectOpen.setEnabled(false);
                    projectDelete.setEnabled(false);
                    return;
                }
                BaseTreeNode node = (BaseTreeNode) o;

                projectRemove.setEnabled((PineappleCore.getProject() != null) ? (PineappleCore.getProject().indexOf(node.getElement()) != -1) : false);
                projectOpen.setEnabled(node instanceof FileTreeNode);
                projectDelete.setEnabled(true);
            }
        });

        tree.setDragEnabled(true);
        tree.setDropMode(DropMode.ON);

        tree.setTransferHandler(new TreeTransferHandler());
        tree.setScrollsOnExpand(true);
        tree.setShowsRootHandles(true);
        tree.setToggleClickCount(3);
        ToolWindow treeWindow = manager.registerToolWindow("Project", "Project", null, new JScrollPane(tree),
                ToolWindowAnchor.LEFT);
        treeWindow.setVisible(true);
        //</editor-fold>

        /* Try to load the interface provider from a setting.
          This allows plug-ins to provide a different interface provider without hassle.
         */ 
        try {
            dip = (DocumentInterfaceProvider) Class.forName(SettingsManager.get("pineapple.gui.interfaceprovider")).newInstance();
        } catch (Throwable r) {
            /* I guess it didn't work.
               Revert to default. */
            dip = new TabbedInterfaceProvider();
            /* Let's set the registry setting back to the
               TabbedInterfaceProvider just to annoy plug-in developers.
             */
            SettingsManager.set("pineapple.gui.interfaceprovider", TabbedInterfaceProvider.class.getCanonicalName());
        }

        menubar = new JMenuBar();
        menubar.setVisible(true);
        f.setJMenuBar(menubar);

        //<editor-fold defaultstate="collapsed" desc="File menu">
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        fileMenu.setVisible(true);
        menubar.add(fileMenu);

        fileNewProject = new JMenuItem("New Project");
        fileNewProject.setMnemonic('w');
        fileNewProject.setVisible(true);
        fileNewProject.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                popupNewProjectDialog();
            }
        });
        fileMenu.add(fileNewProject);

        fileMenu.addSeparator();

        fileOpenProject = new JMenuItem("Open Project");
        fileOpenProject.setMnemonic('j');
        fileOpenProject.setVisible(true);
        fileOpenProject.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                openProject();
            }
        });
        fileMenu.add(fileOpenProject);

        fileSaveProject = new JMenuItem("Save Project") {

            private static final long serialVersionUID = 1;

            @Override
            public boolean isEnabled() {
                return PineappleCore.getProject() != null &&
                        PineappleCore.getProject().allowsSave() && super.isEnabled();
            }
        };
        fileSaveProject.setMnemonic('v');
        fileSaveProject.setVisible(true);
        fileSaveProject.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                saveProject();
            }
        });
        fileMenu.add(fileSaveProject);

        fileOpenFile = new JMenuItem("Open File");
        fileOpenFile.setMnemonic('O');
        fileOpenFile.setVisible(true);
        fileOpenFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                openFile(false, false);
            }
        });
        fileMenu.add(fileOpenFile);
        fileMenu.addSeparator();
                    
        fileSave = new JMenuItem("Save") {
            @Override
            public boolean isEnabled() {
                if (!super.isEnabled()) {
                    return super.isEnabled();
                }
                DocumentPane p = dip.getSelectedDocument();
                boolean b = false;
                if (p != null) {
                    b = p.isModified();
                }
                return b;
            }
        };
        fileSave.setMnemonic('S');
        fileSave.setVisible(true);
        fileSave.setEnabled(false);
        fileSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                saveFile();
            }
        });
        fileMenu.add(fileSave);

        fileMenu.addSeparator();

        fileExit = new JMenuItem("Exit");
        fileExit.setMnemonic('x');
        fileExit.setVisible(true);
        fileExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                EventManager.fireEvent(this, DefaultEventTypes.WINDOW_DISPOSED);
            }
        });
        fileMenu.add(fileExit);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Project menu">
        projectMenu = new JMenu("Project");

        /* New > submenu*/
        projectNew = createNewFileMenu(null);
        projectMenu.add(projectNew);
        
        projectAdd = new JMenuItem("Add Existing...") {

            private static final long serialVersionUID = 1;

            @Override
            public boolean isEnabled() {
                return PineappleCore.getProject() != null && super.isEnabled();
            }
        };
        projectAdd.setMnemonic('A');
        projectAdd.setVisible(true);
        projectAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                openFile(true, true);
            }
        });
        projectMenu.add(projectAdd);

        projectMenu.addSeparator();

        projectOpen = new JMenuItem("Open Selected...");
        projectOpen.setMnemonic('O');
        projectOpen.setVisible(true);
        projectOpen.setEnabled(false);
        projectOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                try {
                    BaseTreeNode node = (BaseTreeNode) tree.getSelectionPath().getLastPathComponent();
                    openFile(node.getElement().getFile());
                } catch (Exception e) {
                }
            }
        });
        projectMenu.add(projectOpen);

        projectRemove = new JMenuItem("Remove Selected from project");
        projectRemove.setMnemonic('R');
        projectRemove.setVisible(true);
        projectRemove.setEnabled(false);
        projectRemove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                ProjectElement el = ((BaseTreeNode) tree.getSelectionPath().getLastPathComponent()).getElement();
                PineappleCore.getProject().remove(el);
                EventManager.fireEvent(this, FILE_REMOVED, el);
            }
        });
        projectMenu.add(projectRemove);

        projectDelete = new JMenuItem("Delete Selected from Disk") {

            private static final long serialVersionUID = 1;

            @Override
            public boolean isEnabled() {
                if (!super.isEnabled() || tree == null || tree.getSelectionPath() == null ||
                        tree.getSelectionPath().getLastPathComponent() == null ||
                        !(tree.getSelectionPath().getLastPathComponent() instanceof BaseTreeNode)) {
                    return false;
                }
                ProjectElement el = ((BaseTreeNode) tree.getSelectionPath().getLastPathComponent()).getElement();
                return el != null && el.allowsDelete();
            }
        };
        projectDelete.setMnemonic('D');
        projectDelete.setVisible(true);
        projectDelete.setEnabled(false);
        projectDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                try {
                    ProjectElement el = ((BaseTreeNode) tree.getSelectionPath().getLastPathComponent()).getElement();
                    deleteFile(el);
                } catch (NullPointerException exc) {
                }
            }
        });
        projectMenu.add(projectDelete);

        projectMenu.addSeparator();

        projectImport = new JMenuItem("Import") {

            private static final long serialVersionUID = 1;

            @Override
            public boolean isEnabled() {
                if (PineappleCore.getProject() == null || !super.isEnabled()) {
                    return false;
                }
                String[] s = PineappleCore.getProject().getManager().getImportFileTypes();
                return (s != null && s.length > 0);
            }
        };
        projectImport.setMnemonic('I');
        projectImport.setVisible(true);
        projectImport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                importFile();
            }
        });
        projectMenu.add(projectImport);

        projectExport = new JMenuItem("Export") {

            private static final long serialVersionUID = 1;

            @Override
            public boolean isEnabled() {
                if (PineappleCore.getProject() == null || !super.isEnabled()) {
                    return false;
                }
                String[] s = PineappleCore.getProject().getManager().getExportFileTypes();
                return (s != null && s.length > 0);
            }
        };
        projectExport.setMnemonic('E');
        projectExport.setVisible(true);
        projectExport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                exportFile();
            }
        });
        projectMenu.add(projectExport);

        projectMenu.addSeparator();

        projectFind = new JMenuItem("Find...") {

            private static final long serialVersionUID = 1;

            @Override
            public boolean isEnabled() {
                return PineappleCore.getProject() != null && super.isEnabled();
            }
        };
        projectFind.setMnemonic('F');
        projectFind.setVisible(true);
        projectFind.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                JDialog d = new JDialog(Core.getStaticContext().getMainFrame());
                d.setTitle("Search Resources");
                d.setSize(320, 240);
                d.setMinimumSize(new Dimension(320, 240));
                d.setModalityType(ModalityType.MODELESS);
                d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                d.add(new FindResourcePanel());
                d.setVisible(true);
            }
        });
        projectMenu.add(projectFind);

        projectMenu.addSeparator();

        projectClose = new JMenuItem("Close Project") {

            private static final long serialVersionUID = 1;

            @Override
            public boolean isEnabled() {
                return PineappleCore.getProject() != null && super.isEnabled();
            }
        };
        projectClose.setMnemonic('C');
        projectClose.setVisible(true);
        projectClose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!((JMenuItem) evt.getSource()).isEnabled()) {
                    return;
                }
                closeProject();
            }
        });
        projectMenu.add(projectClose);

        menubar.add(projectMenu);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Edit menu">
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        editMenu.setEnabled(false);
        editMenu.setVisible(true);
        menubar.add(editMenu);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Tools menu">
        toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic('T');
        toolsMenu.setEnabled(true);
        toolsMenu.setVisible(true);

        toolsPlugins = new JMenuItem("Plugins");
        toolsPlugins.setMnemonic('g');
        toolsPlugins.setEnabled(true);
        toolsPlugins.setVisible(true);
        toolsPlugins.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                openPluginDialog();
            }
        });
        toolsMenu.add(toolsPlugins);

        menubar.add(toolsMenu);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Help menu">
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        helpMenu.setEnabled(true);
        helpMenu.setVisible(true);

        helpAbout = new JMenuItem("About");
        helpAbout.setMnemonic('A');
        helpAbout.setEnabled(true);
        helpAbout.setVisible(true);
        helpAbout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                openAboutDialog();
            }
        });
        helpMenu.add(helpAbout);
        menubar.add(helpMenu);

        //</editor-fold>

        for (ToolWindow window : manager.getToolWindows()) {
            window.setAvailable(true);
        }
        File dataFolder = Core.getStaticContext().getApplicationDataFolder();

        File lock = new File(Core.getStaticContext().getApplicationDataFolder(), ".workspace_loaded");
        if (!lock.exists()) {
            try {
                lock.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            /* Try to load the MyDoggy settings */
            try {
                File w = new File(dataFolder, "workspace.xml");
                if (w.exists()) {
                    final BufferedInputStream in = new BufferedInputStream(new FileInputStream(w));
                    manager.getPersistenceDelegate().merge(in, MergePolicy.RESET);
                    in.close();
                }
            } catch (Exception e) {
                System.err.println("Error while loading workspace: " + e);
            }
        }
        lock.delete();

        try {
            File pf = new File(dataFolder, "projects.xml");
            if (!pf.exists()) {
                pf.createNewFile();
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);
            factory.setIgnoringComments(true);
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(pf);
            Element root = doc.getDocumentElement();
            NodeList nl = root.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                File p = new File(n.getTextContent());
                if (!p.exists()) {
                    continue;
                } else {
                    //NOTE: this must be changed
                    // when Pineapple supports multiple projects
                    EventManager.fireEvent(this, PROJECT_OPENED, p);
                    tree.updateUI();
                    break; // Can't load any more projects anyways.
                }
            }
        } catch (Exception e) {
        }
        
        EventManager.fireEvent(this, PINEAPPLE_GUI_INITIALIZED);

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="openPluginDialog()           ">
    /**
     * Opens the plugin dialog
     */
    public void openPluginDialog() {
        PluginDialog d = new PluginDialog(Core.getStaticContext().getMainFrame());
        d.setVisible(true);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="openAboutDialog()            ">
    /**
     * Opens the about dialog
     */
    public void openAboutDialog() {
        AboutDialog d = new AboutDialog(Core.getStaticContext().getMainFrame());
        d.setVisible(true);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="handleEvent(Event)           ">
    /**
     * Handles any provided events
     * @param evt The sent event
     */
    @Override
    public void handleEvent(Event evt) {
        //<editor-fold defaultstate="collapsed" desc="APPLICATION_INITIALIZED">
        if (evt.getEventType().equals(DefaultEventTypes.APPLICATION_INITIALIZED)) {
            
            String key = "graphics.swing.look&feel";
            // Uncomment to set look&feel to Nimbus Look&Feel.
            // SettingsManager.set(key, "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            try {
                if (!SettingsManager.exists(key)) {
                    SettingsManager.set(key, UIManager.getSystemLookAndFeelClassName());
                }
                UIManager.setLookAndFeel(SettingsManager.get(key));
            } catch (Exception e) {
                System.out.println("Failed to install Look&Feel: " + e.getMessage());
                /* Set Look&Feel back to system Look&Feel
                 * just to annoy plug-in developers.
                 */
                SettingsManager.set(key, UIManager.getSystemLookAndFeelClassName());
                try {
                    UIManager.setLookAndFeel(SettingsManager.get(key));
                } catch (Exception exc) {
                    /* Don't bother.. */
                }
            }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="WINDOW_CREATED">
        } else if (evt.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)) {
            /* Initilize the main window in the AWT GUI thread */
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    initializeWindow();
                }
            });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="FILE_CHANGED">
        } else if (evt.getEventType().equals(FILE_CHANGED)) {

            DocumentPane pane = dip.getSelectedDocument();
            editMenu.removeAll();
            if (pane != null) {
                editMenu.setEnabled(pane.setupEditMenu(editMenu));
                fileSave.setEnabled(pane.canSave());
            } else {
                editMenu.setEnabled(false);
                fileSave.setEnabled(false);
            }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="FILE_OPENED">
        } else if (evt.getEventType().equals(FILE_OPENED) && evt.getArguments().length >= 1) {

            Object[] arguments = evt.getArguments();
            final BasicFile f = (BasicFile) arguments[0];
            final FormatSupporter fs = getFormatSupporter(f, false);
            if (fs == null) {
                return;
            }
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    DocumentPane p;
                    p = fs.load(f);
                    dip.add(p.getFile().getName(), p);
                    tree.updateUI();
                }
            });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="WINDOW_DISPOSE">
        } else if (evt.getEventType().equals(DefaultEventTypes.WINDOW_DISPOSED)) {

            /* Save the MyDoggy settings */
            try {
                File dataFolder = Core.getStaticContext().getApplicationDataFolder();
                File f = new File(dataFolder.getPath() + File.separator + "workspace.xml");
                if (!f.exists()) {
                    f.createNewFile();
                }
                BufferedOutputStream o = new BufferedOutputStream(new FileOutputStream(f));
                manager.getPersistenceDelegate().save(o);
                o.close();
            } catch (Exception e) {
            }

            for (DocumentPane doc : dip.getDocuments()) {
                if (doc != null) {
                    if (!doc.dispose()) {
                        evt.handleEvent();
                        return;
                    }
                }
            }
            try {
                File pf = new File(Core.getStaticContext().getApplicationDataFolder(), "projects.xml");
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();

                Element root = doc.createElement("projects");
                Element project = doc.createElement("project");
                project.setTextContent( (PineappleCore.getProject() != null)
                        ? PineappleCore.getProject().getProjectFile().getCanonicalPath()
                        : null );
                root.appendChild(project);
                doc.appendChild(root);


                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new FileOutputStream(pf));
                transformer.transform(source, result);
            } catch (Exception e) {
            }
        //</editor-fold>
        } else if (evt.getEventType().equals(PROJECT_OPENED)) {
            if (evt.getArguments().length == 0) {
                return;
            }
            File f = (File) evt.getArguments()[0];
            ProjectType t = getProjectType(f);
            PineappleCore.setProject(t.load(f, f.getParentFile()));

        } else if (evt.getEventType().equals(FILE_DELETED)) {
            if (evt.getArguments().length > 0 && evt.getArguments()[0] instanceof ProjectElement) {
                ProjectElement e = (ProjectElement) evt.getArguments()[0];
                if (e.getParent() != null && e.getParent() instanceof ProjectFolder) {
                    e.getParent().reload();
                }
                tree.updateUI();
            }
        } else if (evt.getEventType().equals(FILE_REMOVED)) {
            tree.updateUI();
        } else if (evt.getEventType().equals(FILE_RENAMED)) {
            tree.updateUI();
        } else if (evt.getEventType().equals(TREE_MENU_INVOKED)) {
            if (evt.getArguments().length < 2 || !(evt.getArguments()[0] instanceof JPopupMenu)) {
                return;
            }
            JPopupMenu menu = (JPopupMenu) evt.getArguments()[0];
            Object o = evt.getArguments()[1];

            popupTreeMenu(menu, o);
        } else if (evt.getEventType().equals(PROJECT_SAVED)) {
            if (evt.getArguments().length < 1) {
                return;
            }
            File f = (File) evt.getArguments()[0];
            PineappleCore.getProject().getManager().save(f);
        } else if (evt.getEventType().equals(PineappleCore.PROJECT_CHANGED)) {
            if (PineappleCore.getProject() == null) {
                treeModel.setRoot(null);
                projectNew.setEnabled(false);
            } else {
                treeModel.setRoot(PineappleCore.getProject().getTreeNode());
                projectNew.setEnabled(true);
            }
            tree.updateUI();
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="openFile(BasicFile)          ">
    /**
     * Opens a given file
     * @param f The file to open
     */
    public void openFile(final BasicFile f) {
        DocumentPane[] comps = dip.getDocuments();
        boolean canOpen = true;
        for (DocumentPane component : comps) {
            if (component != null && component.getFile() == f) {
                canOpen = false;
                dip.setSelectedIndex(dip.getDocumentIndex(component));
                break;
            }
        }
        if (canOpen) {
            Thread t = new Thread() {

                @Override
                public void run() {
                    String s = f.getName();
                    String format = "<none>";
                    try {
                        int index = s.lastIndexOf('.') + 1;
                        if (index > 0) {
                            format = s.substring(s.lastIndexOf('.') + 1);
                        }
                    } catch (Exception e) {
                    }
                    EventManager.fireEvent(this, FILE_OPENED, f, format);
                    dip.updateUI();
                }
            };
            t.start();
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="openProject()                ">
    /**
     * Opens a project
     */
    public void openProject() {

        File f = showFileChooserSingle(createFileChooser("Select the project to open", getSupportedProjectFormats(), "open-project"));
        if (f != null) {
            if (PineappleCore.getProject() != null) {
                closeProject();
            }
            EventManager.fireEvent(this, PROJECT_OPENED, f);
            tree.updateUI();
        }

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="importFile()                 ">
    /**
     * Imports a file to the PineappleCore.getProject().
     * 
     * TODO: RE-THINKING
     */
    public void importFile() {
        File f = showFileChooserSingle(createFileChooser("Select the file to import",
                PineappleCore.getProject().getManager().getImportFileTypes(), "import-file"));
        if (f != null && f.exists()) {
            EventManager.fireEvent(this, PROJECT_IMPORTED, f);
            tree.updateUI();
        }

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="exportFile()                 ">
    /**
     * Exports the porject to a file.
     */
    public void exportFile() {
        File f = showFileChooserSingle(createFileChooser("Export...", PineappleCore.getProject().getManager().getExportFileTypes(), "export-file"));
        if (f != null) {
            EventManager.fireEvent(this, PROJECT_EXPORTED, f);
            tree.updateUI();
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="saveProject()                ">
    /**
     * Saves the project
     */
    public void saveProject() {
        if (PineappleCore.getProject() == null) {
            return;
        }
        File f = showFileChooserSingle(createFileChooser("Save Project", PineappleCore.getProject().getProjectType().getProjectFileTypes(), "save-project"));
        if (f != null) {
            if (!f.getName().contains(".")) {
                System.err.println(f + " no good");
                return;
            }
            EventManager.fireEvent(this, PROJECT_SAVED, f);
            tree.updateUI();
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="closeProject()               ">
    /**
     * Closes the current project
     */
    public void closeProject() {
        PineappleCore.setProject(null);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="saveFile()                   ">
    /**
     * Saves the currently open file
     */
    public void saveFile() {
        DocumentPane p = dip.getSelectedDocument();
        if (p != null) {
            p.save();
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="popupNewProjectDialog()      ">
    /**
     * Pops a New FolderProject Dialog
     */
    public void popupNewProjectDialog() {
        NewProjectWizard dialog = new NewProjectWizard(Core.getStaticContext().getMainFrame());
        dialog.setVisible(true);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="popupNewFileDialog()         ">
    /**
     * Pops a New File Dialog
     */
    public void popupNewFileDialog() {
        if (PineappleCore.getProject() == null) {
            JOptionPane.showMessageDialog(
                    Core.getStaticContext().getMainFrame(),
                    "Can not create new file if no project is open");
            return;
        }
        NewFileWizard dialog = new NewFileWizard(Core.getStaticContext().getMainFrame(), PineappleCore.getProject());
        dialog.setVisible(true);
    }
    //</editor-fold>
    
    /* Private methods 
     */
    
    //<editor-fold defaultstate="collapsed" desc="popupTreeMenu(JPopupMenu, Object)                         ">
    private void popupTreeMenu(JPopupMenu menu, final Object o) {


        //<editor-fold defaultstate="collapsed" desc="Project">
        if (o instanceof ProjectTreeNode) {

            JMenu newFile = createNewFileMenu(null);
            newFile.setMnemonic('N');
            newFile.setVisible(true);
            menu.add(newFile);

            JMenuItem tprojectAdd = new JMenuItem("Add File/Folder...") {

                private static final long serialVersionUID = 1;

                @Override
                public boolean isEnabled() {
                    return PineappleCore.getProject() != null && super.isEnabled();
                }
            };
            tprojectAdd.setMnemonic('A');
            tprojectAdd.setVisible(true);
            tprojectAdd.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    openFile(true, true, null, false);
                }
            });
            menu.add(tprojectAdd);

            menu.addSeparator();

            JMenuItem tfileSaveProject = new JMenuItem("Save Project") {

                private static final long serialVersionUID = 1;

                @Override
                public boolean isEnabled() {
                    return PineappleCore.getProject() != null &&
                            PineappleCore.getProject().allowsSave() && super.isEnabled();
                }
            };
            menu.add(tfileSaveProject);

            menu.add("Rename").addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    String s = JOptionPane.showInputDialog(
                            Core.getStaticContext().getMainFrame(),
                            "New name:",
                            PineappleCore.getProject().getName());
                    if (s != null && !s.equals("")) {
                        PineappleCore.getProject().setName(s);
                    }
                }
            });

            JMenuItem tprojectRemove = new JMenuItem("Close");
            tprojectRemove.setMnemonic('C');
            tprojectRemove.setVisible(true);
            tprojectRemove.setEnabled(true);
            tprojectRemove.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    closeProject();
                    tree.updateUI();
                }
            });
            menu.add(tprojectRemove);

            menu.addSeparator();

            JMenuItem tprojectImport = new JMenuItem("Import") {

                private static final long serialVersionUID = 1;

                @Override
                public boolean isEnabled() {
                    if (PineappleCore.getProject() == null || !super.isEnabled()) {
                        return false;
                    }
                    String[] s = PineappleCore.getProject().getManager().getImportFileTypes();
                    return (s != null && s.length > 0);
                }
            };
            tprojectImport.setMnemonic('I');
            tprojectImport.setVisible(true);
            tprojectImport.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    importFile();
                }
            });
            menu.add(tprojectImport);

            JMenuItem tprojectExport = new JMenuItem("Export") {

                private static final long serialVersionUID = 1;

                @Override
                public boolean isEnabled() {
                    if (PineappleCore.getProject() == null || !super.isEnabled()) {
                        return false;
                    }
                    String[] s = PineappleCore.getProject().getManager().getExportFileTypes();
                    return (s != null && s.length > 0);
                }
            };
            tprojectExport.setMnemonic('E');
            tprojectExport.setVisible(true);
            tprojectExport.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    exportFile();
                }
            });
            menu.add(tprojectExport);

            menu.addSeparator();

            JMenuItem projectUpdate = new JMenuItem("Update");
            projectUpdate.setMnemonic('U');
            projectUpdate.setVisible(true);
            projectUpdate.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    tree.updateUI();
                }
            });
            menu.add(projectUpdate);

        }
        //</editor-fold>

        if (o instanceof FileTreeNode) {
            final FileTreeNode n = (FileTreeNode) o;
            menu.add("Open...").addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    openFile(n.getElement().getFile());
                }
            });

            JMenu openWith = new JMenu("Open With");
            for (final FormatSupporter s : getFormatSupporters(n.getElement().getName())) {
                if (s == null) {
                    continue;
                }
                JMenuItem m = new JMenuItem(s.getName());
                m.setEnabled(true);
                m.setVisible(true);
                m.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (!((JMenuItem) evt.getSource()).isEnabled()) {
                            return;
                        }
                        DocumentPane p = s.load(n.getElement().getFile());
                        dip.add(p.getFile().getName(), p);
                    }
                });
                openWith.add(m);
            }

            JMenuItem other = new JMenuItem("Other...");
            other.setMnemonic('O');
            other.setEnabled(true);
            other.setVisible(true);
            other.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    FormatSupporter s = getFormatSupporter(n.getElement().getFile(), true);
                    if (s == null) {
                        return;
                    }
                    DocumentPane p = s.load(n.getElement().getFile());
                    dip.add(p.getFile().getName(), p);
                }
            });
            openWith.add(other);

            menu.add(openWith);

            menu.addSeparator();
        }

        if (o instanceof FolderTreeNode) {
            final ProjectFolder f = (ProjectFolder) ((FolderTreeNode) o).getElement();
            JMenu newFile = createNewFileMenu(f);
            newFile.setMnemonic('N');
            newFile.setVisible(true);
            menu.add(newFile);

            JMenuItem addFile = new JMenuItem("Add File/Folder...") {

                private static final long serialVersionUID = 1;

                @Override
                public boolean isEnabled() {
                    return PineappleCore.getProject() != null && super.isEnabled();
                }
            };
            addFile.setMnemonic('A');
            addFile.setVisible(true);
            addFile.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    openFile(true, true, f, false);
                }
            });
            menu.add(addFile);

            menu.addSeparator();

            menu.add("Refresh").addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    f.reload();
                    tree.updateUI();
                }
            });
        }

        if (o instanceof BaseTreeNode &&
                PineappleCore.getProject().indexOf(((BaseTreeNode) o).getElement()) >= 0) {
            final BaseTreeNode t = (BaseTreeNode) o;
            menu.add("Remove from Project").addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    PineappleCore.getProject().remove(t.getElement());
                    EventManager.fireEvent(this, FILE_REMOVED, t.getElement());
                }
            });
        }

        if (o instanceof BaseTreeNode) {
            JMenuItem del = new JMenuItem("Delete from Disk") {

                private static final long serialVersionUID = 1;

                @Override
                public boolean isEnabled() {
                    if (!super.isEnabled() || tree == null || tree.getSelectionPath() == null ||
                            tree.getSelectionPath().getLastPathComponent() == null ||
                            !(tree.getSelectionPath().getLastPathComponent() instanceof BaseTreeNode)) {
                        return false;
                    }
                    ProjectElement el = ((BaseTreeNode) tree.getSelectionPath().getLastPathComponent()).getElement();
                    return el != null && el.allowsDelete();
                }
            };
            del.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    deleteFile(((BaseTreeNode) o).getElement());
                }
            });
            menu.add(del);

            menu.add("Move...").addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    new MoveFileDialog(Core.getStaticContext().getMainFrame(),
                            PineappleCore.getProject(), ((BaseTreeNode) o).getElement().getFile(), null, true);
                }
            });
        }

        if (o instanceof BaseTreeNode) {
            final BaseTreeNode t = (BaseTreeNode) o;

            menu.add("Rename").addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    String s = JOptionPane.showInputDialog(
                            Core.getStaticContext().getMainFrame(),
                            "New name:",
                            t.getElement().getName());
                    if (s != null) {
                        try {
                            PineappleCore.getProject().rename(t.getElement().getFile(), s);
                        } catch (Exception ex) {
                        }
                    }
                    EventManager.fireEvent(this, FILE_RENAMED, t.getElement(), s);
                }
            });
        }

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="openFile(boolean, boolean, ProjectFolder, boolean)        ">
    private void openFile(boolean addFile, boolean allowFolder, ProjectFolder defaultFolder, boolean allowBrowse) {
        JFileChooser fc = createFileChooser("Select files to open", null, "open-file");
        fc.setFileSelectionMode((allowFolder) ? JFileChooser.FILES_AND_DIRECTORIES : JFileChooser.FILES_ONLY);
        fc.addChoosableFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                String format;
                int i = f.getName().lastIndexOf('.');
                if (i < 0 || i >= f.getName().length()) {
                    format = null;
                } else {
                    format = f.getName().substring(i + 1);
                }
                for (FormatSupporter fs : PineappleCore.getFormatSupporters()) {
                    if (fs.accept(format)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "All accepted file formats";
            }
        });
        fc.setMultiSelectionEnabled(true);
        File files[] = showFileChooserMultiple(fc);
        if (files != null && files.length > 0) {
            fileLoop:
            for (File f : files) {
                if (!f.exists()) {
                    JOptionPane.showMessageDialog(Core.getStaticContext().getMainFrame(),
                            "File " + f + "Does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                BasicFile bf = null;
                boolean fileAdded = false;
                if (addFile) {
                    BaseTreeNode node = null;
                    for (ProjectElement e : PineappleCore.getProject().getFiles()) {
                        if ((node = hasFile(f, e)) != null) {
                            break;
                        }
                    }
                    try {
                        if (!f.getCanonicalPath().startsWith(PineappleCore.getProject().getProjectFolder().getCanonicalPath())) {

                            bf = new CopyFileDialog(Core.getStaticContext().getMainFrame(),
                                    PineappleCore.getProject(), f, "Copy File to Project", defaultFolder, allowBrowse).getCreatedFile();
                            if (bf == null) {
                                continue;
                            }
                            fileAdded = true;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (bf == null) {
                        bf = createBasicFile(f);
                    }

                    if (node == null && !fileAdded) {
                        try {
                            ProjectElement e = PineappleCore.getProject().createElement(bf);
                            node = e.getTreeNode();
                            PineappleCore.getProject().add(e);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    tree.updateUI();
                } else {
                    bf = createBasicFile(f);
                }
                if (!f.isDirectory()) {
                    openFile(bf);
                }
            }
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="openFile(boolean, boolean)                                ">
    /**
     * Opens a file
     * 
     * @param addFile Wheather to add the file to the PineappleCore.getProject().
     * @param allowFolder Wheather you want to allow the user to choose folders.
     */
    private void openFile(boolean addFile, boolean allowFolder) {
        openFile(addFile, allowFolder, null, true);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="hasFile(File, ProjectElement)                             ">
    private static BaseTreeNode hasFile(File f, ProjectElement e) {
        if (e instanceof ProjectFile) {
            if (f.equals(e.getFile())) {
                return e.getTreeNode();
            }
        } else if (e instanceof ProjectFolder) {
            for (ProjectElement b : ((ProjectFolder) e).getChildren()) {
                BaseTreeNode o = hasFile(f, b);
                if (o != null) {
                    return o;
                }
            }
        }
        return null;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="deleteFile(ProjectElement)                                ">
    /**
     * Deletes a file from the file system
     * @param e The ProjectElement to be deleted
     */
    private void deleteFile(ProjectElement e) {
        if (JOptionPane.showConfirmDialog(tree,
                "<html>Are you sure you want to delete this file from your file system?<br/>This will be permanent.</html>") == JOptionPane.YES_OPTION) {
            e.getFile().delete();
            PineappleCore.getProject().remove(e);
            EventManager.fireEvent(this, FILE_DELETED, e);
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getFormatSupporter(BasicFile f, boolean)                  ">
    private FormatSupporter getFormatSupporter(BasicFile f, boolean openWith) {
        final String format;
        int i = f.getName().lastIndexOf('.');
        if (i < 0 || i >= f.getName().length()) {
            format = null;
        } else {
            format = f.getName().substring(i + 1).toLowerCase();
        }

        String key = "files.formats.formatsupporter.remember." + format;

        if (!openWith && format != null && SettingsManager.exists(key)) {
            try {
                String cname = SettingsManager.get(key);
                for (FormatSupporter s : PineappleCore.getFormatSupporters()) {
                    if (s.getClass().getName().equals(cname)) {
                        return s;
                    }
                }
            } catch (Exception exc) {
            }
        }

        final FormatSupporter[] supporters;
        if (openWith) {
            supporters = getFormatSupporters(null);
        } else {
            supporters = getFormatSupporters(f.getName());
        }

        if (supporters.length == 0) {
            JOptionPane.showMessageDialog(manager, "<html>Error:<br/>File format '" + format + "' not supported.</html>");
            return null;
        }
        if (supporters.length == 1) {
            return supporters[0];
        }

        final JDialog d = new JDialog(Core.getStaticContext().getMainFrame(), "Open File", true);
        final JList list = new JList();
        list.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1;

            @Override
            public int getSize() {
                return supporters.length;
            }

            @Override
            public Object getElementAt(int index) {
                return supporters[index].getName();
            }
        });

        final JTextPane text = new JTextPane();
        text.setEditable(false);

        JSplitPane pane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT, new JScrollPane(list),
                new JScrollPane(text));
        d.add(pane);


        JCheckBox cbox = new JCheckBox("Remember this choice");
        if (format == null) {
            cbox.setEnabled(false);
        }
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        Box box = Box.createHorizontalBox();
        box.add(cbox);
        box.add(Box.createHorizontalGlue());
        south.add(box);

        final JButton ok,  cancel;
        ok = new JButton("OK");
        ok.setEnabled(false);
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int i = e.getFirstIndex();
                ok.setEnabled(i >= 0);
                if (i >= 0) {
                    text.setText(supporters[list.getSelectedIndex()].getDescription(format));
                }
            }
        });
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });
        Box bottom = Box.createHorizontalBox();
        bottom.add(Box.createHorizontalGlue());
        bottom.add(ok);
        bottom.add(Box.createHorizontalStrut(8));
        bottom.add(cancel);
        bottom.add(Box.createHorizontalStrut(32));
        south.add(bottom);

        d.add(south, "South");
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setSize(360, 280);
        d.setVisible(true);

        if (cbox.isSelected() && format != null) {
            SettingsManager.set(key, supporters[list.getSelectedIndex()].getClass().getName());
        }
        if (list.getSelectedIndex() < 0) {
            return null;
        }
        return supporters[list.getSelectedIndex()];
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getProjectType(File f)                                    ">
    private ProjectType getProjectType(File f) {
        String format;
        int i = f.getName().lastIndexOf('.');
        if (i < 0 || i >= f.getName().length()) {
            format = null;
        } else {
            format = f.getName().substring(i + 1).toLowerCase();
        }

        String key = "files.projects.projecttypes.remember." + format;
        if (format != null && SettingsManager.exists(key)) {
            try {
                String cname = SettingsManager.get(key);
                for (ProjectType t : PineappleCore.getProjectTypes()) {
                    if (t.getClass().getName().equals(cname)) {
                        return t;
                    }
                }
            } catch (Exception exc) {
            }
        }

        final Vector<ProjectType> types = new Vector<ProjectType>(2);

        String fname = f.getName().toLowerCase();
        for (ProjectType pt : PineappleCore.getProjectTypes()) {
            String[] s = pt.getProjectFileTypes();
            if (s == null) {
                continue;
            }
            for (String ff : s) {
                if (format == null || fname.matches(".+\\." + ff)) {
                    types.add(pt);
                }
            }
        }

        if (types.size() == 0) {
            JOptionPane.showMessageDialog(manager, "<html>Error:<br/>Project type '" + format + "' not supported.</html>");
            return null;
        }
        if (types.size() == 1) {
            return types.get(0);
        }
        final JDialog d = new JDialog(Core.getStaticContext().getMainFrame(), "Open Project", true);
        final JList list = new JList();
        list.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1;

            @Override
            public int getSize() {
                return types.size();
            }

            @Override
            public Object getElementAt(int index) {
                return types.get(index).getName();
            }
        });

        final JTextPane text = new JTextPane();
        text.setEditable(false);

        JSplitPane pane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT, new JScrollPane(list),
                new JScrollPane(text));
        d.add(pane);


        JCheckBox cbox = new JCheckBox("Remember this choice");
        if (format == null) {
            cbox.setEnabled(false);
        }
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        Box box = Box.createHorizontalBox();
        box.add(cbox);
        box.add(Box.createHorizontalGlue());
        south.add(box);
        final JButton ok,  cancel;
        ok = new JButton("OK");
        ok.setEnabled(false);
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int i = e.getFirstIndex();
                ok.setEnabled(i >= 0);
                if (i >= 0) {
                    text.setText(types.get(list.getSelectedIndex()).getDescription());
                }
            }
        });
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });
        Box bottom = Box.createHorizontalBox();
        bottom.add(Box.createHorizontalGlue());
        bottom.add(ok);
        bottom.add(Box.createHorizontalStrut(8));
        bottom.add(cancel);
        bottom.add(Box.createHorizontalStrut(32));
        south.add(bottom);

        d.add(south, "South");
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setSize(360, 280);
        d.setVisible(true);

        if (cbox.isSelected() && format != null) {
            SettingsManager.set(key, types.get(list.getSelectedIndex()).getClass().getName());
        }

        return types.get(list.getSelectedIndex());
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getSupportedProjectFormats()                              ">
    private String[] getSupportedProjectFormats() {
        Vector<String> formats = new Vector<String>(2);

        for (ProjectType pt : PineappleCore.getProjectTypes()) {
            String[] s = pt.getProjectFileTypes();
            if (s == null) {
                continue;
            }
            for (String ff : s) {
                formats.add(ff);
            }
        }
        return formats.toArray(new String[formats.size()]);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="createFileChooser(String, String[], String)               ">
    private JFileChooser createFileChooser(String title, final String[] formats, final String action) {
        String dir = SettingsManager.get("filechooser.remeber.path." + action);
        if (dir != null && !(new File(dir).exists())) {
            dir = null;
        }
        final JFileChooser chooser = new JFileChooser(dir);
        chooser.setAcceptAllFileFilterUsed(false);
        if (title != null) {
            chooser.setDialogTitle(title);
        }
        if (formats != null) {
            int length = Math.min(formats.length * 4, 50);
            StringBuilder b = new StringBuilder(length);
            for (String s : formats) {
                if (b.length() > length) {
                    b.append("...");
                    break;
                }
                b.append(s + " ");
            }
            final String desc = b.toString();

            chooser.addChoosableFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    }
                    for (String s : formats) {
                        if (f.getName().matches(".+\\." + s)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override
                public String getDescription() {
                    return desc;
                }
            });
        }
        chooser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsManager.set("filechooser.remeber.path." + action, chooser.getCurrentDirectory().getPath());
            }
        });
        EventManager.fireEvent(this, FILE_CHOOSER_CREATED, chooser, action);
        return chooser;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="showFileChooser(JFileChooser)                             ">
    private File showFileChooserSingle(JFileChooser chooser) {
        chooser.setMultiSelectionEnabled(false);
        int res = chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK");
        if (res != JFileChooser.CANCEL_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="showFileChooser(JFileChooser)                             ">
    private File[] showFileChooserMultiple(JFileChooser chooser) {
        chooser.setMultiSelectionEnabled(true);
        int res = chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK");
        if (res != JFileChooser.CANCEL_OPTION) {
            return chooser.getSelectedFiles();
        }

        return null;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="createBasicFile(File)                                     ">
    private BasicFile createBasicFile(File f) {
        BasicFile bf;
        if (PineappleCore.getProject() != null) {
            bf = PineappleCore.getProject().getProjectType().createBasicFile(f, PineappleCore.getProject());
        } else {
            /* Shouldn't use DefaultFile, but will anyways. */
            bf = new DefaultFile(f, null, null); /*
        NOTE:
         * Can't use getPath() method
         * with null project.
         */
        }
        return bf;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getFormatSupporters(String)                               ">
    public FormatSupporter[] getFormatSupporters(String fname) {
        if (fname != null) {
            fname = fname.toLowerCase();
        }
        String format;
        if (fname == null) {
            format = null;
        } else {
            int i = fname.lastIndexOf('.');
            if (i < 0 || i >= fname.length()) {
                format = null;
            } else {
                format = fname.substring(i + 1);
            }
        }
        Vector<FormatSupporter> supporters = new Vector<FormatSupporter>(2);

        for (FormatSupporter fs : PineappleCore.getFormatSupporters()) {
            if (format == null || fs.accept(format)) {
                supporters.add(fs);
            }
        }
        return supporters.toArray(new FormatSupporter[supporters.size()]);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="createNewFileMenu(ProjectFolder f)                        ">
   private JMenu createNewFileMenu(final ProjectFolder f) {
        JMenu menu = new JMenu("New");
        /* Folder */
        JMenuItem item = new JMenuItem("Folder");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BasicFile folder = PineappleCore.getProject().getManager().createFolder(f, getFileName("newFolder", f, PineappleCore.getProject()));
                try {
                    tree.startEditingAtPath(new TreePath(((DefaultMutableTreeNode)folder.getElement().getTreeNode()).getPath()));
                } catch (Exception exc) {} 
            }
        });
        menu.add(item);

        int i = 0;
        for (String s : PineappleCore.fileTypeNames.values()) {
            item = new JMenuItem(s);
            final int n = i;
            item.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String type = (String) PineappleCore.fileTypeNames.keySet().toArray()[n];
                    openFile( PineappleCore.getProject().getManager().createFile(
                      f,
                      getFileName("new" + type.toUpperCase() + "File", f, PineappleCore.getProject()),
                      type));
                    
                }
            });
            menu.add(item);
            i++;
        }
        menu.addSeparator();
        JMenuItem other = new JMenuItem("Other...");
        other.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        popupNewFileDialog();
                    }
                });
            }
        });
        menu.add(other);
        return menu;
    }
   //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getFileName(String, ProjectFolder, Project)               ">
    private String getFileName(String fname, ProjectFolder folder, Project project) {
        if (!exists(fname, folder,project)) {
            return fname;
        }
        
        int i = 1;
        while (exists(fname+i, folder, project)) {
            i++;
        }
        return fname+1;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="exists(String, ProjectFolder, Project)                    ">
    private boolean exists(String fname, ProjectFolder folder, Project project) {
        if (folder == null) {
            for (ProjectElement e : project.getFiles()) {
                if (e.getName().equals(fname)) {
                    return true;
                }
            }
        } else {
            for (ProjectElement e : folder.getChildren()) {
                if (e.getName().equals(fname)) {
                    return true;
                }
            }
        }
        return false;
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="TreeTransferHandler">
    private class TreeTransferHandler extends TransferHandler {

        private static final long serialVersionUID = 1;
        //<editor-fold desc="createTransferable(JComponent)" defaultstate="collapsed">
        @Override
        protected Transferable createTransferable(JComponent c) {
            Object o = tree.getLastSelectedPathComponent();

            if (o instanceof BaseTreeNode) {
                final BaseTreeNode n = (BaseTreeNode) o;
                return new Transferable() {

                    @Override
                    public DataFlavor[] getTransferDataFlavors() {
                        return new DataFlavor[]{
                                    ELEMENT_FLAVOR,
                                };
                    }

                    @Override
                    public boolean isDataFlavorSupported(DataFlavor flavor) {
                        return flavor.equals(ELEMENT_FLAVOR);
                    }

                    @Override
                    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                        return n.getElement();
                    }
                };
            }
            //NOTE:  No support for ProjectTreeNode

            return null;
        }
        //</editor-fold>
        @Override
        public int getSourceActions(JComponent c) {
            return COPY_OR_MOVE;
        }

        //<editor-fold desc="canImport(TransferHandler.TransferSupport)" defaultstate="collapsed">
        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            Object o = null;
            try {
                o = support.getTransferable().getTransferData(ELEMENT_FLAVOR);
            } catch (UnsupportedFlavorException ex) {
            } catch (IOException ex) {
            }
            if (o == null) {
                return false;
            }

            JTree.DropLocation drop = (JTree.DropLocation) support.getDropLocation();
            if (drop.getPath() == null) {
                return false;
            }
            Object last = drop.getPath().getLastPathComponent();

            if (!(last instanceof FolderTreeNode || last instanceof ProjectTreeNode)) {
                return false;
            }

            if (o instanceof ProjectElement) {
                ProjectElement e = (ProjectElement) o;
                /* Don't allow to drag into self. */
                if (last == e.getTreeNode()) {
                    return false;
                }
                /* Don't allow the object ot be dragged back into its own folder. */
                if ((e.getParent() == null && last instanceof ProjectTreeNode) || e.getParent() == last) {
                    return false;
                }
                return true;
            }
            return false;
        }
        //</editor-fold>
        //<editor-fold desc="importData(TransferHandler.TransferSupport)" defaultstate="collapsed">
        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }
            JTree.DropLocation drop = (JTree.DropLocation) support.getDropLocation();
            int dropIndex = drop.getChildIndex();
            ProjectElement e = null;
            try {
                e = (ProjectElement) support.getTransferable().getTransferData(ELEMENT_FLAVOR);
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (e == null) {
                return false;
            }
            Object last = drop.getPath().getLastPathComponent();
            if (last instanceof FolderTreeNode || last instanceof ProjectTreeNode) {
                Iterable<ProjectElement> children;
                ProjectFolder f = null;
                Project p = null;
                if (last instanceof ProjectTreeNode) {
                    p = ((ProjectTreeNode) last).getProject();
                    children = p.getFiles();
                } else { // FolderTreeNode
                    f = (ProjectFolder) ((FolderTreeNode) last).getElement();
                    children = f.getChildren();
                }
                String newName = e.getName();
                boolean done = false, changed;
                int i = 1;
                while (!done) {
                    changed = false;
                    for (ProjectElement el : children) {
                        if (el.getName().equals(newName)) {
                            String s, l;
                            int dot = e.getName().indexOf('.');
                            if (dot < 0) {
                                l = "";
                            } else {
                                l = e.getName().substring(dot);
                            }
                            s = e.getName().substring(0, dot);
                            newName = s + "_" + i++ + l;
                            changed = true;
                            break;
                        }
                    }
                    done = !changed;
                }
                BasicFile nf = e.getProject().getManager().copyFile(e.getFile(), f, newName);
                if (last instanceof ProjectTreeNode) {
                    tree.updateUI();
                }
            }

            /* Delete file if necessary */
            if (support.getDropAction() == TransferHandler.MOVE) {
                /* Assume that if the parent is null, then the element is
                at the project root. */
                e.getFile().delete();
                if (e.getParent() == null) {
                    e.getProject().remove(e);
                } else {
                    e.getParent().reload();
                }
                tree.updateUI();
            }
            return true;
        }
        //</editor-fold>
    }
    //</editor-fold>
}
