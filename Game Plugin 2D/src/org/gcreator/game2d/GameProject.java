///*
//Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
//Copyright (C) 2008 BobSerge<serge_1994@hotmail.com>
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.
// */
//package org.gcreator.game2d;
//
//import java.io.File;
//import org.gcreator.project.ProjectType;
//import org.gcreator.project.standard.DefaultProject;
//import org.gcreator.project.standard.DefaultProjectManager;
//
///**
// * Provides a GameProject.
// * @author Luís Reis
// */
//public class GameProject extends DefaultProject {
//    
//    /**
//     * Creates a new {@link GameProject}.
//     * 
//     * @param name The name of the project. May be <tt>null</tt>.
//     * @param folder The folder to use as the project folder. May be <strong>not</strong> <tt>null</tt>.
//     * @param type The project type class. May be <tt>null</tt>.
//     * @param manager The manager for this project. May be <tt>null</tt>.
//     * @param save Whether to save the project manifest first.
//     */
//    protected GameProject(String name, File folder, ProjectType type, DefaultProjectManager manager, boolean save) {
//        super(name, folder, type, manager, save);
//        this.type = new GameProjectType();
//    }
//    /**
//     * Creates a new {@link GameProject}.
//     * 
//     * @param name The name of the project. May be <tt>null</tt>.
//     * @param folder The folder to use as the project folder. May be <strong>not</strong> <tt>null</tt>.
//     * @param type The project type class. May be <tt>null</tt>.
//     * @param manager The manager for this project. May be <tt>null</tt>.
//     */
//    protected GameProject(String name, File folder, ProjectType type, DefaultProjectManager manager) {
//        super(name, folder, type, manager, true);
//        this.type = new GameProjectType();
//    }
//}
