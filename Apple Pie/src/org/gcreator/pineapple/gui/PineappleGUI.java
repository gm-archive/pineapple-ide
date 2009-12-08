/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<serge@bobtheblueberry.com>

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
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
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
import org.gcreator.pineapple.gui.base.GUIBase;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventPriority;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFile;
import org.gcreator.pineapple.project.ProjectFolder;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.gui.formats.FormatSupporter;
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
import sun.swing.SwingUtilities2;
//</editor-fold>

/**
 * This deals with the main GUI stuff.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class PineappleGUI implements EventHandler {
    //<>editor-fold defaultstate="collapsed" desc="Fields                       ">

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
    public static JMenu helpMenu;
    public static JMenuItem fileNewProject;
    public static JMenuItem fileOpenFile;
    public static JMenuItem fileOpenProject;
    public static JMenuItem fileSaveProject;
    public static JMenuItem fileSave;
    public static JMenuItem fileExit;
    public static JMenuItem toolsPlugins;
    public static JMenuItem toolsOptions;
    public static JMenu projectNew;
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
    protected DataFlavor ELEMENT_FLAVOR;
    /**
     * The setting key for Look&Feel class name.
     */
    public static final String LOOK_AND_FEEL_KEY = "graphics.swing.look&feel";
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="Events                       ">
    /**
     * When a file is opened.
     * This event should have the opened File as the first argument.
     * File can be null.
     * The second argument should be the File format, even if the File is null.
     */
    public static final String FILE_OPENED = "file-opened";
    /**
     * Called when the selected document changes.
     */
    public static final String DOCUMENT_CHANGED = "document-changed";
    /**
     * When the user requests that a file be opened as a project.
     * 
     * @param arg0 The {@link File} needs to be opened.
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
    //<>editor-fold defaultstate="collapsed" desc="PineappleGUI()               ">
    /**
     * Created and initilizes a new Pineapple GUI.
     */
    public PineappleGUI() {
        try {
            ELEMENT_FLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" + ProjectElement.class.getName() + "\"", "Project Element", PluginManager.getClassLoader());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        initialize();
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="initialize()                 ">

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
        EventManager.addEventHandler(this, DOCUMENT_CHANGED, EventPriority.LOW);
        EventManager.addEventHandler(this, PineappleCore.FILE_DELETED, EventPriority.LOW);
        EventManager.addEventHandler(this, PineappleCore.FILE_REMOVED, EventPriority.LOW);
        EventManager.addEventHandler(this, PineappleCore.FILE_RENAMED, EventPriority.LOW);
        EventManager.addEventHandler(this, TREE_MENU_INVOKED, EventPriority.HIGH);
        EventManager.addEventHandler(this, PROJECT_OPENED, EventPriority.HIGH);
        EventManager.addEventHandler(this, PROJECT_SAVED, EventPriority.HIGH);
        EventManager.addEventHandler(this, FILE_CHOOSER_CREATED, EventPriority.HIGH);

        /* Other Events */
        EventManager.addEventHandler(this, PineappleCore.PROJECT_CHANGED, EventPriority.HIGH);
        EventManager.addEventHandler(this, PineappleCore.TREE_CHANGED, EventPriority.LOW);
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="initializeWindow()           ">

    /**
     * Initilize's the Pineapple Window.
     */
    protected void initializeWindow() {
        MainFrame f = Core.getStaticContext().getMainFrame();
        SwingUtilities.updateComponentTreeUI(f);
        f.setTitle("Pineapple IDE");
        f.setIconImage(new ImageIcon(getClass().getResource(
                "/org/gcreator/pineapple/core/pineapple.png")).getImage());

        manager = new MyDoggyToolWindowManager(Locale.getDefault(), PluginManager.getClassLoader());
        f.getContentPane().add(manager);

        //<>editor-fold defaultstate="collapsed" desc="Tree Initialization">
        treeModel = new DefaultTreeModel(null);
        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setVisible(true);
        ProjectTreeRenderer ren = new ProjectTreeRenderer();
        tree.setCellRenderer(ren);
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
                    tree.setSelectionPath(trp);
                    JPopupMenu menu = new JPopupMenu("Tree");
                    EventManager.fireEvent(this, TREE_MENU_INVOKED, true, menu, o);
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

                if (o == null) {
                    return;
                }

                if (!(o instanceof BaseTreeNode)) {
                    return;
                }

                BaseTreeNode n = (BaseTreeNode) o;
                ProjectElement el = n.getElement();
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteFile(el);
                } else if (e.getKeyCode() == KeyEvent.VK_F2) {
                    tree.startEditingAtPath(tp);
                }

                if (!(n instanceof FileTreeNode)) {
                    return;
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    openFile(el.getFile());
                }
            }
        });
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object o = e.getPath().getLastPathComponent();
                if (o == null || !(o instanceof BaseTreeNode)) {
                    projectOpen.setEnabled(false);
                    projectDelete.setEnabled(false);
                    return;
                }
                BaseTreeNode node = (BaseTreeNode) o;

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
        tree.setEditable(true);
        ProjectCellEditor pce = new ProjectCellEditor(ren, null);
        DefaultTreeCellEditor editor = new DefaultTreeCellEditor(tree, ren, pce);
        tree.setCellEditor(editor);
        pce.editor = editor;
        editor.addCellEditorListener(new CellEditorListener() {

            @Override
            public void editingStopped(ChangeEvent e) {
                TreePath tp = tree.getSelectionPath();
                if (tp == null) {
                    return;
                }
                Object o = tp.getLastPathComponent();
                if (o == null) {
                    return;
                }
                if (o instanceof ProjectTreeNode) {
                    ((ProjectTreeNode) o).getProject().setName(tree.getCellEditor().getCellEditorValue().toString());
                    return;
                } else if (o instanceof BaseTreeNode) {
                    try {
                        ((BaseTreeNode) o).getElement().getFile().rename(tree.getCellEditor().getCellEditorValue().toString());
                    } catch (IOException ex) {
                        String msg = ex.getLocalizedMessage();
                        if (msg == null) {
                            msg = "<Unknown reason>";
                        }
                        JOptionPane.showMessageDialog(Core.getStaticContext().getMainFrame(),
                                "Error renaming file: " + msg, "File Renaming Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    return;
                }
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        });

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

        //<>editor-fold defaultstate="collapsed" desc="File menu">
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
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
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

        //<>editor-fold defaultstate="collapsed" desc="Project menu">
        projectMenu = new JMenu("Project");
        projectMenu.setMnemonic('P');

        /* New > submenu*/
        projectNew = createNewFileMenu(null);
        projectMenu.add(projectNew);

        projectAdd = new JMenuItem("Import File") {

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

        projectDelete = new JMenuItem("Delete") {

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

        //<>editor-fold defaultstate="collapsed" desc="Edit menu">
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        editMenu.setEnabled(false);
        editMenu.setVisible(true);
        menubar.add(editMenu);
        //</editor-fold>

        //<>editor-fold defaultstate="collapsed" desc="Tools menu">
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

        toolsOptions = new JMenuItem("IDE Settings");
        toolsOptions.setMnemonic('I');
        toolsOptions.setEnabled(true);
        toolsOptions.setVisible(true);
        toolsOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new OptionsDialog();
            }
        });
        toolsMenu.add(toolsOptions);
        toolsMenu.addSeparator();

        menubar.add(toolsMenu);
        //</editor-fold>

        //<>editor-fold defaultstate="collapsed" desc="Help menu">
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
                    updateTreeUI();
                    break; // Can't load any more projects anyways.
                }
            }
        } catch (Exception e) {
        }

        EventManager.fireEvent(this, PINEAPPLE_GUI_INITIALIZED);

    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="openPluginDialog()           ">

    /**
     * Opens the plugin dialog
     */
    public void openPluginDialog() {
        PluginDialog d = new PluginDialog(Core.getStaticContext().getMainFrame());
        d.setVisible(true);
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="openAboutDialog()            ">

    /**
     * Opens the about dialog
     */
    public void openAboutDialog() {
        AboutDialog d = new AboutDialog(Core.getStaticContext().getMainFrame());
        d.setVisible(true);
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="handleEvent(Event)           ">

    /**
     * Handles any provided events
     * @param evt The sent event
     */
    @Override
    public void handleEvent(final Event evt) {
        //<>editor-fold defaultstate="collapsed" desc="APPLICATION_INITIALIZED">
        if (evt.getEventType().equals(DefaultEventTypes.APPLICATION_INITIALIZED)) {

            // Uncomment to set look&feel to Nimbus Look&Feel.
            // SettingsManager.set(key, "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            try {
                if (!SettingsManager.exists(LOOK_AND_FEEL_KEY)) {
                    SettingsManager.set(LOOK_AND_FEEL_KEY, UIManager.getSystemLookAndFeelClassName());
                }
                UIManager.setLookAndFeel(SettingsManager.get(LOOK_AND_FEEL_KEY));
            } catch (Exception e) {
                System.err.println("Failed to install Look&Feel: " + e.getMessage());
                /* Set Look&Feel back to system Look&Feel
                 * just to annoy plug-in developers.
                 */
                SettingsManager.set(LOOK_AND_FEEL_KEY, UIManager.getSystemLookAndFeelClassName());
                try {
                    UIManager.setLookAndFeel(SettingsManager.get(LOOK_AND_FEEL_KEY));
                } catch (Exception exc) {
                    /* Don't bother.. */
                }
            }
            //</editor-fold>
            //<>editor-fold defaultstate="collapsed" desc="WINDOW_CREATED">
        } else if (evt.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)) {
            /* Initilize the main window in the AWT GUI thread */
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    initializeWindow();
                }
            });
            //</editor-fold>
            //<>editor-fold defaultstate="collapsed" desc="DOCUMENT_CHANGED">
        } else if (evt.getEventType().equals(DOCUMENT_CHANGED)) {

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
            //<>editor-fold defaultstate="collapsed" desc="FILE_OPENED">
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
                    updateTreeUI();
                }
            });
            //</editor-fold>
            //<>editor-fold defaultstate="collapsed" desc="WINDOW_DISPOSE">
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

            // Close tabs
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
                project.setTextContent((PineappleCore.getProject() != null)
                        ? PineappleCore.getProject().getProjectFile().getCanonicalPath()
                        : null);
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
            final File f = (File) evt.getArguments()[0];
            Runnable r = new Runnable() {

                @Override
                public void run() {
                    openProject(f);
                }
            };
            SwingUtilities.invokeLater(r);


        } else if (evt.getEventType().equals(PineappleCore.FILE_DELETED)) {
            if (evt.getArguments().length > 0 && evt.getArguments()[0] instanceof ProjectElement) {
                ProjectElement e = (ProjectElement) evt.getArguments()[0];
                if (e.getParent() != null && e.getParent() instanceof ProjectFolder) {
                    e.getParent().reload();
                }
                updateTreeUI();
            }
        } else if (evt.getEventType().equals(PineappleCore.FILE_REMOVED)) {
            updateTreeUI();
        } else if (evt.getEventType().equals(PineappleCore.FILE_RENAMED)) {
            updateTreeUI();
        } else if (evt.getEventType().equals(TREE_MENU_INVOKED)) {
            if (evt.getArguments().length < 2 || !(evt.getArguments()[0] instanceof JPopupMenu)) {
                return;
            }
            final JPopupMenu menu = (JPopupMenu) evt.getArguments()[0];
            final Object o = evt.getArguments()[1];
            popupTreeMenu(menu, o);
        } else if (evt.getEventType().equals(PROJECT_SAVED)) {
            if (evt.getArguments().length < 1) {
                return;
            }
            File f = (File) evt.getArguments()[0];
            PineappleCore.getProject().getManager().save(f);
        } else if (evt.getEventType().equals(PineappleCore.PROJECT_CHANGED)) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    if (PineappleCore.getProject() == null) {
                        treeModel.setRoot(null);
                        /* Close tabs */
                        for (DocumentPane p : dip.getDocuments()) {
                            if (p.getProject() == evt.getArguments()[0]) {
                                p.dispose();
                            }
                        }
                    } else {
                        treeModel.setRoot(PineappleCore.getProject().getTreeNode());
                    }
                    boolean b = (PineappleCore.getProject() != null);
                    projectNew.setEnabled(b);
                    projectMenu.setEnabled(b);
                    updateTreeUI();
                }
            });
        } else if (evt.getEventType().equals(PineappleCore.TREE_CHANGED)) {
            updateTreeUI();
        } else if (evt.getEventType().equals(FILE_CHOOSER_CREATED)) {
            String action = (String) evt.getArguments()[1];
            if (!(action == null || action.equals("") || action.equals("open-file") || action.equals("open-image"))) {
                return;
            }
            final JFileChooser c = (JFileChooser) evt.getArguments()[0];
            JPanel p = new JPanel(new BorderLayout(5, 5));
            final JLabel l = new JLabel();
            l.setPreferredSize(new Dimension(120, 20));
            final Image[] image = new Image[1];
            image[0] = null;
            final JButton x = new JButton("X");
            x.setEnabled(false);
            x.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (image[0] == null) {
                        return;
                    }
                    final JDialog d = new JDialog((Window) c.getTopLevelAncestor());
                    d.setUndecorated(true);
                    d.setLayout(new BorderLayout());
                    JLabel l;
                    JScrollPane p = new JScrollPane(l = new JLabel(new ImageIcon(image[0])));
                    d.add(p);
                    d.addFocusListener(new FocusListener() {

                        @Override
                        public void focusGained(FocusEvent e) {
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            d.dispose();
                        }
                    });
                    l.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mousePressed(MouseEvent e) {
                            if (e.getClickCount() >= 2) {
                                d.dispose();
                            }
                        }
                    });
                    Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
                    d.setSize(Math.min(ss.width * 2 / 3, image[0].getWidth(null) + 14),
                            Math.min(ss.height * 2 / 3, image[0].getWidth(null) + 14));
                    d.setLocationRelativeTo(c.getRootPane());
                    d.setVisible(true);
                }
            });
            Box box = Box.createHorizontalBox();
            box.add(l);
            box.add(Box.createHorizontalStrut(5));
            box.add(Box.createHorizontalGlue());
            box.add(x);
            p.add(box, BorderLayout.NORTH);
            final JLabel img = new JLabel();
            Box ibox = Box.createHorizontalBox();
            ibox.add(Box.createHorizontalGlue());
            ibox.add(img);
            ibox.add(Box.createHorizontalGlue());
            p.add(ibox, BorderLayout.CENTER);
            c.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
                        File f = (File) evt.getNewValue();
                        l.setText((f == null) ? null : f.getName());
                        if (f != null && f.getName().contains(".")) {
                            String s = f.getName();
                            String ext = s.substring(s.lastIndexOf('.') + 1);
                            Image[] imgs = getImageFromFile(f, new Dimension(170, 134), Image.SCALE_FAST);
                            if (imgs[0] != null) {
                                img.setIcon(new ImageIcon(imgs[1]));
                                image[0] = imgs[0];
                                x.setEnabled(true);
                            } else {
                                img.setIcon(null);
                                image[0] = null;
                                x.setEnabled(false);
                            }
                        }
                    } else if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
                        l.setText(null);
                        image[0] = null;
                        x.setEnabled(false);
                    }
                }
            });
            c.setAccessory(p);

        }
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="openFile(BasicFile)          ">

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
                }
            };
            t.start();
        }
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="openProject()                ">

    /**
     * Opens a project
     */
    public void openProject() {

        File f = showFileChooserSingle(createFileChooser("Select the project to open", new String[]{"gpt"}, "open-project", false));
        if (f != null) {
            if (PineappleCore.getProject() != null) {
                closeProject();
            }
            EventManager.fireEvent(this, PROJECT_OPENED, f);
            updateTreeUI();
        }

    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="saveProject()                ">

    /**
     * Saves the project
     */
    public void saveProject() {
        if (PineappleCore.getProject() == null) {
            return;
        }
        File f = showFileChooserSingle(createFileChooser("Save Project", PineappleCore.getProject().getProjectType().getProjectFileTypes(), "save-project", false));
        if (f != null) {
            if (!f.getName().contains(".")) {
                System.err.println(f + " no good");
                return;
            }
            EventManager.fireEvent(this, PROJECT_SAVED, f);
            updateTreeUI();
        }
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="closeProject()               ">

    /**
     * Closes the current project
     */
    public void closeProject() {
        PineappleCore.setProject(null);
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="saveFile()                   ">

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
    //<>editor-fold defaultstate="collapsed" desc="popupNewProjectDialog()      ">

    /**
     * Pops a New FolderProject Dialog
     */
    public void popupNewProjectDialog() {
        NewProjectWizard dialog = new NewProjectWizard(Core.getStaticContext().getMainFrame());
        dialog.setVisible(true);
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="popupNewFileDialog()         ">

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
    //<>editor-fold defaultstate="collapsed" desc="popupTreeMenu(JPopupMenu, Object)                         ">
    private void popupTreeMenu(JPopupMenu menu, final Object o) {


        //<>editor-fold defaultstate="collapsed" desc="Project">
        if (o instanceof ProjectTreeNode) {

            JMenu newFile = createNewFileMenu(null);
            newFile.setMnemonic('N');
            newFile.setVisible(true);
            menu.add(newFile);
            
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
                    TreePath tp = tree.getSelectionPath();
                    if (tp == null) {
                        return;
                    }
                    tree.startEditingAtPath(tp);
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
                    updateTreeUI();
                }
            });
            menu.add(tprojectRemove);

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
                    updateTreeUI();
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
                        //TODO: What if the file is opened in another editor?
                        dip.add(p.getFile().getName() + Math.random() * 200000, p);
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
                    updateTreeUI();
                }
            });
        }

        /* Copy, Cut, and Paste */
        JMenuItem copy = new JMenuItem("Copy");
        copy.setEnabled(!(o instanceof ProjectTreeNode));
        copy.setMnemonic('C');
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        copy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tree.getTransferHandler().exportToClipboard(tree, getClipboard(tree), TransferHandler.COPY);
            }
        });
        menu.add(copy);

        JMenuItem cut = new JMenuItem("Cut");
        cut.setEnabled(!(o instanceof ProjectTreeNode));
        cut.setMnemonic('u');
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        cut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tree.getTransferHandler().exportToClipboard(tree, getClipboard(tree), TransferHandler.MOVE);
            }
        });
        menu.add(cut);

        final JMenuItem paste = new JMenuItem("Paste");
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                paste.setEnabled(tree.getTransferHandler().canImport(new TransferHandler.TransferSupport(tree, getClipboard(tree).getContents(this))));
            }
        });
        paste.setMnemonic('P');
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        paste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tree.getTransferHandler().importData(new TransferSupport(tree, getClipboard(tree).getContents(this)));
            }
        });
        menu.add(paste);


        if (o instanceof BaseTreeNode) {
            JMenuItem del = new JMenuItem("Delete") {

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

            menu.add("Rename").addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (!((JMenuItem) evt.getSource()).isEnabled()) {
                        return;
                    }
                    TreePath tp = tree.getSelectionPath();
                    if (tp == null) {
                        return;
                    }
                    tree.startEditingAtPath(tp);
                }
            });
        }
        menu.updateUI();
    }
    //<>/editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="openFile(boolean, boolean, ProjectFolder, boolean)        ">

    private void openFile(boolean addFile, boolean allowFolder, ProjectFolder defaultFolder, boolean allowBrowse) {
        JFileChooser fc = createFileChooser("Select files to open", null, "open-file", false);
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
                for (FormatSupporter fs : GUIBase.getFormatSupporters()) {
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
                    for (ProjectElement e : PineappleCore.getProject().getFiles().getChildren()) {
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
                        ProjectElement e = PineappleCore.getProject().createElement(bf);
                        node = e.getTreeNode();
                        PineappleCore.getProject().getFiles().reload();
                    }
                    String fn = bf.getName();
                    int n = fn.lastIndexOf('.');
                    if (n > 0) {
                        String ext = fn.substring(n + 1);
                        for (String s : ImageIO.getReaderFileSuffixes()) {
                            if (ext.equalsIgnoreCase(ext)) {
                            }
                        }
                    }
                    updateTreeUI();
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
    //<>editor-fold defaultstate="collapsed" desc="openFile(boolean, boolean)                                ">

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
    //<>editor-fold defaultstate="collapsed" desc="hasFile(File, ProjectElement)                             ">

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
    //<>editor-fold defaultstate="collapsed" desc="deleteFile(ProjectElement)                                ">

    /**
     * Deletes a file from the file system
     * @param e The ProjectElement to be deleted
     */
    private void deleteFile(ProjectElement e) {
        if (JOptionPane.showConfirmDialog(tree,
                "<html>Are you sure you want to delete this file?<br/>This will be FOREVER.</html>") == JOptionPane.YES_OPTION) {
            e.getFile().delete();
            PineappleCore.getProject().getFiles().reload();
            /* Remove any open documents for this file.*/
            for (DocumentPane d : dip.getDocuments()) {
                if (d.getFile() == e.getFile()) {
                    dip.remove(d);
                }
            }
            EventManager.fireEvent(this, PineappleCore.FILE_DELETED, e);
        }
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="getFormatSupporter(BasicFile f, boolean)                  ">

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
                for (FormatSupporter s : GUIBase.getFormatSupporters()) {
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

        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.add(new JLabel("You have chosen to open " + f.getName()));
        top.add(new JScrollPane(list));
        JSplitPane pane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT, top,
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

        final JButton ok, cancel;
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
        pane.setContinuousLayout(true);
        pane.setDividerLocation(60);
        d.setVisible(true);
        d.setLocationRelativeTo(null);

        if (cbox.isSelected() && format != null) {
            SettingsManager.set(key, supporters[list.getSelectedIndex()].getClass().getName());
        }
        if (list.getSelectedIndex() < 0) {
            return null;
        }
        return supporters[list.getSelectedIndex()];
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="createFileChooser(String, String[], String, boolean)      ">

    private JFileChooser createFileChooser(String title, final String[] formats, final String action, final boolean allowDirs) {
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

            chooser.setFileSelectionMode((allowDirs) ? JFileChooser.FILES_AND_DIRECTORIES : JFileChooser.FILES_ONLY);
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
    //<>editor-fold defaultstate="collapsed" desc="showFileChooser(JFileChooser)                             ">

    private File showFileChooserSingle(JFileChooser chooser) {
        chooser.setMultiSelectionEnabled(false);
        int res = chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK");
        if (res != JFileChooser.CANCEL_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="showFileChooser(JFileChooser)                             ">

    private File[] showFileChooserMultiple(JFileChooser chooser) {
        chooser.setMultiSelectionEnabled(true);
        int res = chooser.showDialog(Core.getStaticContext().getMainFrame(), "OK");
        if (res != JFileChooser.CANCEL_OPTION) {
            return chooser.getSelectedFiles();
        }

        return null;
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="createBasicFile(File)                                     ">

    private BasicFile createBasicFile(File f) {
        BasicFile bf;
        if (PineappleCore.getProject() != null) {
            bf = PineappleCore.getProject().getProjectType().createFile(f, PineappleCore.getProject());
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
    //<>editor-fold defaultstate="collapsed" desc="getFormatSupporters(String)                               ">

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

        for (FormatSupporter fs : GUIBase.getFormatSupporters()) {
            if (format == null || fs.accept(format)) {
                supporters.add(fs);
            }
        }
        return supporters.toArray(new FormatSupporter[supporters.size()]);
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="createNewFileMenu(ProjectFolder f)                        ">

    private JMenu createNewFileMenu(final ProjectFolder f) {
        JMenu menu = new JMenu("New");
        /* Folder */
        JMenuItem item = new JMenuItem("Folder");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BasicFile folder = PineappleCore.getProject().getManager().createFolder(f, getFileName("newFolder", "", f, PineappleCore.getProject()));
                try {
                    tree.startEditingAtPath(new TreePath(((DefaultMutableTreeNode) folder.getElement().getTreeNode()).getPath()));
                } catch (Exception exc) {
                }
            }
        });
        menu.add(item);

        int i = 0;
        for (String s : GUIBase.fileTypeNames.values()) {
            item = new JMenuItem(s);
            final int n = i;
            item.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String type = (String) GUIBase.fileTypeNames.keySet().toArray()[n];
                    openFile(PineappleCore.getProject().getManager().createFile(
                            f,
                            getFileName("new" + type.toUpperCase() + "File", "."+type, f, PineappleCore.getProject()),
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
    //<>editor-fold defaultstate="collapsed" desc="getFileName(String, ProjectFolder, Project)               ">

    private String getFileName(String fname, String ext, ProjectFolder folder, Project project) {
        if (!exists(fname+ext, folder, project)) {
            return fname;
        }

        int i = 1;
        while (exists(fname +ext+ i, folder, project)) {
            i++;
        }
        return fname + i;
    }
    //</editor-fold>
    //<>editor-fold defaultstate="collapsed" desc="exists(String, ProjectFolder, Project)                    ">

    private boolean exists(String fname, ProjectFolder folder, Project project) {
        if (folder == null) {
            for (ProjectElement e : project.getFiles().getChildren()) {
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

    public static void updateTreeUI() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tree.updateUI();
            }
        });
    }

    private void openProject(final File f) {
        final JDialog d = new JDialog(Core.getStaticContext().getMainFrame());
        d.setLayout(new GridLayout(0, 1));
        d.add(new JLabel("Project Loading..."));
        d.setSize(120, 20);
        d.setResizable(false);
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setUndecorated(true);
        d.setLocationRelativeTo(Core.getStaticContext().getMainFrame());
        d.setVisible(true);

        /* IsmAvatar says we gots to let this thread finish it's work
        and paint the dialog. */
        Runnable r = new Runnable() {

            @Override
            public void run() {
                doOpenProject(f, d);
            }
        };
        new Thread(r, "Open Project").start();
    }

    private void doOpenProject(File f, final JDialog d) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread.yield();

        Project p = PineappleCore.projectType.load(f, f.getParentFile());
        PineappleCore.setProject(p);
        d.dispose();
    }
    private static Object SandboxClipboardKey = new Object();

    private Clipboard getClipboard(JComponent c) {
        if (SwingUtilities2.canAccessSystemClipboard()) {
            return c.getToolkit().getSystemClipboard();
        }
        Clipboard clipboard = (Clipboard) sun.awt.AppContext.getAppContext().get(SandboxClipboardKey);
        if (clipboard == null) {
            clipboard = new Clipboard("Sandboxed Component Clipboard");
            sun.awt.AppContext.getAppContext().put(SandboxClipboardKey,
                    clipboard);
        }
        return clipboard;
    }
    //<>editor-fold defaultstate="collapsed" desc="TreeTransferHandler">

    private class TreeTransferHandler extends TransferHandler {

        private static final long serialVersionUID = 1;
        private ProjectElement cutFile = null;

        //<>editor-fold desc="createTransferable(JComponent)" defaultstate="collapsed">
        @Override
        protected Transferable createTransferable(JComponent c) {
            Object o = tree.getLastSelectedPathComponent();

            if (o instanceof BaseTreeNode) {
                final BaseTreeNode n = (BaseTreeNode) o;
                return new Transferable() {

                    @Override
                    public DataFlavor[] getTransferDataFlavors() {
                        return new DataFlavor[]{
                                    ELEMENT_FLAVOR,};
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

        //<>editor-fold desc="canImport(TransferHandler.TransferSupport)" defaultstate="collapsed">
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
            Object last;
            if (support.isDrop()) {
                JTree.DropLocation drop = (JTree.DropLocation) support.getDropLocation();
                if (drop.getPath() == null) {
                    return false;
                }
                last = drop.getPath().getLastPathComponent();
            } else {
                TreePath path = tree.getSelectionPath();
                if (path == null) {
                    return false;
                }
                last = path.getLastPathComponent();
            }
            if (!(last instanceof FolderTreeNode ||
                    last instanceof ProjectTreeNode ||
                    last instanceof FileTreeNode)) {
                return false;
            }

            if (o instanceof ProjectElement) {
                ProjectElement e = (ProjectElement) o;
                /* Don't allow to drag into self. */
                if (last == e.getTreeNode()) {
                    return false;
                }
                return true;
            }

            return false;
        }
        //</editor-fold>
        //<>editor-fold desc="importData(TransferHandler.TransferSupport)" defaultstate="collapsed">

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }
            ProjectElement e = null;
            try {
                e = (ProjectElement) support.getTransferable().getTransferData(ELEMENT_FLAVOR);
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, "not supported", ex);
            } catch (IOException ex) {
                Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, "I/O error", ex);
            }
            if (e == null) {
                return false;
            }
            Object last;
            if (support.isDrop()) {
                JTree.DropLocation drop = (JTree.DropLocation) support.getDropLocation();
                last = drop.getPath().getLastPathComponent();
            } else {
                last = tree.getSelectionPath().getLastPathComponent();
            }
            if (last instanceof FileTreeNode) {
                FileTreeNode f = (FileTreeNode) last;
                last = (f.getElement().getParent() != null)
                        ? f.getElement().getParent().getTreeNode()
                        : null;
                if (last == null) { // project root
                    last = f.getElement().getProject().getTreeNode();
                }
            }
            Iterable<ProjectElement> children = null;
            ProjectFolder f = null;
            Project p = null;
            if (last instanceof ProjectTreeNode) {
                p = ((ProjectTreeNode) last).getProject();
                children = p.getFiles().getChildren();
            } else if (last instanceof FolderTreeNode) {
                f = ((FolderTreeNode) last).getElement();
                children = f.getChildren();
            }
            if (children == null) {
                System.err.println("What?? How did we get " + last.getClass().getName() + "???");
                return false;
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
                        if (s.matches(".*_\\d+")) {
                            newName = s.replaceAll("(.*)_\\d+", "$1_") +
                                    (Integer.parseInt(s.replaceAll(".*_(\\d+)", "$1")) + i++) + l;
                        } else {
                            newName = s + "_" + i++ + l;
                        }
                        changed = true;
                        break;
                    }
                }
                done = !changed;
            }
            BasicFile nf = e.getProject().getManager().copyFile(e.getFile(), f, newName);

            if (cutFile != null) {
                delete(e);
                cutFile = null;
                getClipboard(tree).setContents(new Transferable() {

                    @Override
                    public DataFlavor[] getTransferDataFlavors() {
                        return new DataFlavor[0];
                    }

                    @Override
                    public boolean isDataFlavorSupported(DataFlavor flavor) {
                        return false;
                    }

                    @Override
                    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
                        throw new UnsupportedFlavorException(flavor);
                    }
                }, null);

            }

            return true;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action != MOVE) {
                cutFile = null;
                return;
            }
            try {
                cutFile = (ProjectElement) data.getTransferData(ELEMENT_FLAVOR);
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PineappleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }

        private void delete(ProjectElement e) {
            e.getFile().delete();
            e.getParent().reload();
            updateTreeUI();
        }
        //</editor-fold>
    }

    private Image[] getImageFromFile(File f, Dimension size, int scaling) {
        String s = f.getName();
        String ext = s.substring(s.lastIndexOf('.') + 1);
        Image a = null, b = null;
        for (String e : ImageIO.getReaderFileSuffixes()) {
            if (ext.equalsIgnoreCase(e)) {
                try {
                    a = ImageIO.read(f);
                    b = a.getScaledInstance((a.getWidth(null) >= a.getHeight(null)) ? size.width : -1,
                            (a.getWidth(null) < a.getHeight(null)) ? size.height : -1,
                            scaling);
                } catch (Exception ex) {
                }
                break;
            }
        }
        return new Image[]{a, b};
    }
    //</editor-fold>
}
