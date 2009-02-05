/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pinedl;

import java.io.FileOutputStream;
import java.io.IOException;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

/**
 * Used only for testing purposes
 * 
 * @author Luís Reis
 */
public class Test {

    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Test.");
            PineDLLexer lexer = new PineDLLexer(new ANTLRInputStream(
                    Test.class.getResourceAsStream("/org/gcreator/pinedl/test.pdl")));
            CommonTokenStream ts = new CommonTokenStream(lexer);
            PineDLParser parser = new PineDLParser(ts);
            parser.setSignalReceiver(new InterfaceSignalReceiver(new FileOutputStream("dummy")));
            parser.doc();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } catch (RecognitionException e) {
            System.out.println("RecognitionException: " + e);
        }
    }

    private Test() {
    }
}
