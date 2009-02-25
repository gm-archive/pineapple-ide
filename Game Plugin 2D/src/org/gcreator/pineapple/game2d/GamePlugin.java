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
package org.gcreator.pineapple.game2d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.editors.ActorEditor;
import org.gcreator.pineapple.editors.SceneEditor;
import org.gcreator.pineapple.editors.TextEditor;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.gui.GameSettingsDialog;
import org.gcreator.pineapple.gui.PineappleGUI;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.managers.SettingsManager;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.plugins.DefaultEventTypes;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.EventPriority;
import org.gcreator.pineapple.plugins.Plugin;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.project.io.FormatSupporter;
import org.gcreator.pineapple.tree.ProjectTreeNode;
import org.noos.xing.mydoggy.ToolWindow;
import org.noos.xing.mydoggy.ToolWindowAnchor;

/**
 * The Game 2D Plugin.
 * Provides basic components for a 2-Dimensional game.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public class GamePlugin extends Plugin implements FormatSupporter {

    /**
     * Called when the palette is created
     */
    public static final String PALETTE_CREATED = "game-palette-created";
    public static ToolWindow palette = null;
    public static JPanel palettePanel = null;
    public static JMenuItem gameSettings;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Game Plugin 2D";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription(String format) {
        if (format == null) {
            return "";
        }

        if (format.equals("actor")) {
            return "Edits actors, that is, game entities with behavior.";
        }

        return "";
    }

    /**
     * {@inheritDoc}
     */
    public boolean accept(String format) {
        for (String f : formats) {
            if (format != null && format.equalsIgnoreCase(f)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public DocumentPane load(BasicFile f) {
        String n = f.getName();
        int index = n.indexOf(".");
        if (index == -1) {
            return new TextEditor(f);
        }

        if (index == n.length() - 1) {
            return new TextEditor(f);
        }

        String format = n.substring(index + 1);
        if (format.equals("actor")) {
            return new ActorEditor(f);
        }
        if (format.equals("scene")) {
            return new SceneEditor(f);
        }

        return new TextEditor(f);
    }
    /**
     * An array of the formats supported by the 2D Game Plug-in.
     */
    public static final String[] formats = new String[]{
        "actor",
        "scene"
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Adds 2D game support to Pineapple";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(Event e) {
        if (e.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)) {
            palettePanel = new JPanel();
            palette = PineappleGUI.manager.registerToolWindow("Palette", "Palette", null, palettePanel,
                    ToolWindowAnchor.RIGHT);
            palette.setAvailable(false);
            EventManager.fireEvent(this, PALETTE_CREATED, palette, palettePanel);
        } else if (e.getEventType().equals(PineappleGUI.FILE_CHANGED)) {
            DocumentPane p = PineappleGUI.dip.getSelectedDocument();
            if (p != null && p instanceof PaletteUser) {
                palette.setAvailable(((PaletteUser) p).doPalette(palette, palettePanel));
            } else {
                palette.setAvailable(false);
            }
        } else if (e.getEventType().equals(PineappleCore.REGISTER_PROJECT_TYPES)) {
            PineappleCore.addProjectType(new GameProjectType());
        } else if (e.getEventType().equals(PineappleCore.REGISTER_FORMATS)) {
            PineappleCore.addFormatSupporter(this);
            /* Set the default FormatSupporters for certain types. */
            String base = "files.formats.formatsupporter.remember.";
            String fs = this.getClass().getCanonicalName();
            for (String format : formats) {
                SettingsManager.set(base + format, fs);
            }
        } else if (e.getEventType().equals(PineappleGUI.TREE_MENU_INVOKED) && PineappleCore.getProject() != null) {
            JPopupMenu menu = (JPopupMenu) e.getArguments()[0];
            Object o = e.getArguments()[1];
            if (o instanceof ProjectTreeNode) {
                Project p = PineappleCore.getProject();
                if (p.getProjectType() instanceof GameProjectType) {
                    JMenuItem item = new JMenuItem("Game Settings");
                    item.setVisible(true);
                    item.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent evt) {
                            GameSettingsDialog dialog = new GameSettingsDialog(
                                    Core.getStaticContext().getMainFrame(), true,
                                    PineappleCore.getProject());
                            dialog.setVisible(true);
                        }
                    });
                    menu.add(item);
                }
            }
        } else if (e.getEventType().equals(PineappleGUI.PINEAPPLE_GUI_INITIALIZED)) {
            gameSettings = new JMenuItem("Game Settings");
            gameSettings.setVisible(true);
            gameSettings.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
                    GameSettingsDialog dialog = new GameSettingsDialog(
                            Core.getStaticContext().getMainFrame(), true,
                            PineappleCore.getProject());
                    dialog.setVisible(true);
                }
            });
            gameSettings.setEnabled(false);
            PineappleGUI.toolsMenu.add(gameSettings);
        } else if (e.getEventType().equals(PineappleCore.PROJECT_CHANGED)) {
            if (gameSettings != null) {
                gameSettings.setEnabled(PineappleCore.getProject() != null && 
                        PineappleCore.getProject().getProjectType() instanceof GameProjectType);
            }
        }
    }

    /**
     * Initializes the plugin and registers the event handlers.
     */
    @Override
    public void initialize() {
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.LOW);
        EventManager.addEventHandler(this, PineappleGUI.FILE_CHANGED);
        EventManager.addEventHandler(this, PineappleCore.REGISTER_PROJECT_TYPES);
        EventManager.addEventHandler(this, PineappleCore.REGISTER_FORMATS);
        EventManager.addEventHandler(this, PineappleGUI.TREE_MENU_INVOKED);
        EventManager.addEventHandler(this, PineappleGUI.PINEAPPLE_GUI_INITIALIZED);
        EventManager.addEventHandler(this, PineappleCore.PROJECT_CHANGED);
        PineappleCore.fileTypeNames.put("actor", "Game Actor");
        PineappleCore.fileTypeDescriptions.put("actor",
                "Game entities associated with a position and a behavior.");
        PineappleCore.fileTypeNames.put("scene", "Game Scene");
        PineappleCore.fileTypeDescriptions.put("scene",
                "Game space units. Containers of actors.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthor() {
        return "Luís Reis, Serge Humphrey";
    }
}
