/*
Copyright (C) 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2009 Serge Humphrey<bob@bobtheblueberry.com>

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


package org.gcreator.pineapple.project.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A simple interface to support simple
 * read/writing of data.
 * 
 * @author Serge Humphrey
 */
public interface Register {

    /**
     * Gets a new read stream for this Register.
     *
     * @return A newly created {@link InputStream}
     * for reading data from this register.
     *
     * @throws IOException If an I/O error occurs.
     */
    public InputStream getReader() throws IOException;
    /**
     * Gets a newly created write stream for this Register.
     * 
     * @return A newly created {@link OutputStream}
     * for writing data to this register.
     * 
     * @throws IOException If an I/O error occurs.
     */
    public OutputStream getWriter() throws IOException;
}