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

import java.util.Hashtable;
import javax.imageio.ImageIO;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
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

    public static Hashtable<String, Integer> styles = new Hashtable<String, Integer>();
    public static Hashtable<Integer, String> names = new Hashtable<Integer, String>();


    static {
        names.put(RSyntaxTextArea.NO_SYNTAX_STYLE, "No style");
        styles.put("asm", RSyntaxTextArea.ASSEMBLER_X86_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.ASSEMBLER_X86_SYNTAX_STYLE, "Assembly");
        styles.put("c", RSyntaxTextArea.C_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.C_SYNTAX_STYLE, "C");
        styles.put("cpp", RSyntaxTextArea.CPLUSPLUS_SYNTAX_STYLE);
        styles.put("h", RSyntaxTextArea.CPLUSPLUS_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.CPLUSPLUS_SYNTAX_STYLE, "C++");
        styles.put("cs", RSyntaxTextArea.CSHARP_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.CSHARP_SYNTAX_STYLE, "C#");
        styles.put("f", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("f77", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("for", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("f90", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        styles.put("pyf", RSyntaxTextArea.FORTRAN_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.FORTRAN_SYNTAX_STYLE, "Fortran");
        styles.put("groovy", RSyntaxTextArea.GROOVY_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.GROOVY_SYNTAX_STYLE, "Groovy");
        styles.put("htm", RSyntaxTextArea.HTML_SYNTAX_STYLE);
        styles.put("html", RSyntaxTextArea.HTML_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.HTML_SYNTAX_STYLE, "HTML");
        styles.put("java", RSyntaxTextArea.JAVA_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.JAVA_SYNTAX_STYLE, "Java");
        styles.put("js", RSyntaxTextArea.JAVASCRIPT_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.JAVASCRIPT_SYNTAX_STYLE, "JavaScript");
        styles.put("jsp", RSyntaxTextArea.JSP_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.JSP_SYNTAX_STYLE, "JSP");
        styles.put("lua", RSyntaxTextArea.LUA_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.LUA_SYNTAX_STYLE, "Lua");
        styles.put("pl", RSyntaxTextArea.PERL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.PERL_SYNTAX_STYLE, "Perl");
        styles.put("pdl", RSyntaxTextArea.PINEDL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.PINEDL_SYNTAX_STYLE, "PineDL");
        styles.put("rb", RSyntaxTextArea.RUBY_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.RUBY_SYNTAX_STYLE, "Ruby");
        styles.put("sas", RSyntaxTextArea.SAS_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.SAS_SYNTAX_STYLE, "SAS");
        styles.put("sql", RSyntaxTextArea.SQL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.SAS_SYNTAX_STYLE, "SQL");
        styles.put("tcl", RSyntaxTextArea.TCL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.TCL_SYNTAX_STYLE, "TCL");
        styles.put("sh", RSyntaxTextArea.UNIX_SHELL_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.UNIX_SHELL_SYNTAX_STYLE, "Bourne [UNIX] Shell Script");
        styles.put("bat", RSyntaxTextArea.WINDOWS_BATCH_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.WINDOWS_BATCH_SYNTAX_STYLE, "BAT (Windows Batch)");
        styles.put("xml", RSyntaxTextArea.XML_SYNTAX_STYLE);
        names.put(RSyntaxTextArea.XML_SYNTAX_STYLE, "XML");
    }

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
        return new PineDLPane(f);
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
