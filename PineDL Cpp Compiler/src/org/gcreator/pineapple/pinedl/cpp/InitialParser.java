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
package org.gcreator.pineapple.pinedl.cpp;

import java.io.InputStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.gcreator.pineapple.pinedl.PineDLLexer;
import org.gcreator.pineapple.pinedl.PineDLParser;

/**
 *
 * @author Luís Reis
 */
public class InitialParser extends BaseGenerator {

    public GlobalLibrary.ClassDefinition parentDefinition = null;
    
    private InputStream in;
    
    public InitialParser(InputStream in) {
        try {
            this.in = in;
            parse();
        } catch (Exception e) {
            e.printStackTrace();
            throwError(e.getMessage());
        }
    }

    private void parse() throws Exception {
        PineDLLexer lexer = new PineDLLexer(new ANTLRInputStream(in));
        CommonTokenStream ts = new CommonTokenStream(lexer);
        PineDLParser parser = new PineDLParser(ts);
        cls = parser.doc();
    }
}
