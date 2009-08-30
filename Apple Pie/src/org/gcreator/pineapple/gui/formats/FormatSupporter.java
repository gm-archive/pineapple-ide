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


package org.gcreator.pineapple.gui.formats;

import org.gcreator.pineapple.project.io.*;
import org.gcreator.pineapple.gui.DocumentPane;

/**
 * This interface provides a system for adding support
 * for for different file formats in projects. 
 * 
 * @author Serge Humphrey
 */
public interface FormatSupporter {
    
    /**
     * Gets whether this format supporter will accept
     * a given file format (extension).
     * 
     * @param format The format (extension) of the file.
     * @return <tt>true</tt> if this supporter can load
     * the given format, or <tt>false</tt> if it can't.
     */
    public boolean accept(String format);
    
    /**
     * Creates a new {@link DocumentPaner} for the given file,
     * depending on its type. 
     * This should return <tt>null</tt>
     * if the format isn't supported (athough this should never happen).
     * 
     * @param f The file to load
     * @return A {@link DocumentPane} for the given file, depending
     * on its type. 
     */
    public DocumentPane load(BasicFile f);
    
    /**
     * @return A human-readable name of this format supporter.
     */
    public String getName();
    
    /**
     * @param type The file format
     * @return A human-redable description of this format supporter.
     */
    public String getDescription(String type);
}
