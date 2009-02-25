/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

This file is part of Syntax Highlighter.

Syntax Highlighter is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Syntax Highlighter is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU General Public License
along with Syntax Highlighter.  If not, see <http://www.gnu.org/licenses/>.

 */
package org.gcreator.pineapple.syntax;

import javax.imageio.ImageIO;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.managers.EventManager;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.plugins.Event;
import org.gcreator.pineapple.plugins.Plugin;
import org.gcreator.pineapple.project.io.BasicFile;
import org.gcreator.pineapple.project.io.FormatSupporter;

/**
 * The Syntax Highlighter core
 * 
 * @author Luís Reis
 */
public class PineDLPlugin extends Plugin implements FormatSupporter {

    private final String[] FORMATS = {
        "pdl",
        "asm",
        "c",
        "cpp",
        "h",
        "cs",
        "f", "f77", "for", "f90",
        "pyf",
        "groovy",
        "htm", "html",
        "java",
        "js",
        "jsp",
        "lua",
        "?.*",
        "pl",
        "pdl",
        "rb",
        "sas",
        "sql",
        "tcl",
        "sh",
        "bat",
        "xml",
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Syntax Highlighter";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Syntax Highlighter adds several PineDL edition tools to " +
                "Pineapple, including syntax highlighting in " +
                "Assembler (X86), C, C++, CSS, C#, Fortran, Groovy, HTML, " +
                "Java, JavaScript, JSP, Lua, Make, Perl, PineDL, Ruby, SAS, " +
                "SQL, Tcl, UNIX shell scripts, Windows batch, and XML files";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription(String type) {
        return "Text editor with syntax highlighting";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(Event e) {
        if (e.getEventType().equals(PineappleCore.REGISTER_FORMATS)) {
            PineappleCore.addFormatSupporter(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() {
        PineappleCore.fileTypeNames.put("pdl", "PineDL Script");
        PineappleCore.fileTypeDescriptions.put("pdl",
                "Code written in the PineDL programming language.");
        
        EventManager.addEventHandler(this, PineappleCore.REGISTER_FORMATS);
    }

    /**
     * {@inheritDoc}
     */
    public DocumentPane load(BasicFile f) {
        return new PineDLEditor(f);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthor() {
        return "Luís Reis, Serge Humphrey";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(boolean b) {
        boolean old = enabled;
        super.setEnabled(b);
        if (b && !old) {
            PineappleCore.addFormatSupporter(this);
        } else if (!b && old) {
            PineappleCore.removeFormatSupporter(this);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean accept(String format) {
        /* Don't load images */
        for (String s : ImageIO.getReaderFileSuffixes()) {
            if (s.equalsIgnoreCase(format)) {
                return false;
            }
        }
        return true;
    }
}
