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

package org.gcreator.pinedl.cpp.plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import org.gcreator.gui.PineappleGUI;
import org.gcreator.managers.EventManager;
import org.gcreator.pineapple.PineappleCore;
import org.gcreator.pinedl.cpp.GameCompiler;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.Event;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.Plugin;

/**
 * Provides integration with Pineapple
 * @author Luís Reis
 */
public class CppCompilerPlugin extends Plugin{
    public JMenuItem compile = null;
    
    public String getDescription(){
        return "Compiles games to C++/OpenGL";
    }
    public String getAuthor(){
        return "Luís Reis";
    }
    public String getName(){
        return "Pineapple C++ Compiler";
    }
    
    @Override
    public void initialize(){
        System.out.println("Loaded CppCompilerPlugin");
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.LOW);
    }
    
    @Override
    public void handleEvent(Event evt){
        System.out.println("Event called " + evt.getEventType());
        if(evt.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)){
            compile = new JMenuItem("Compile");
            compile.setVisible(true);
            compile.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    new GameCompiler(PineappleCore.getProject());
                }
            });
            PineappleGUI.toolsMenu.add(compile);
        }
    }
}
