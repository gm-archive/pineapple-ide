/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>

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

import org.gcreator.pineapple.pinedl.Leaf;
import org.gcreator.pineapple.pinedl.context.PineDLContext;

/**
 * Indicates an error while parsing something;
 * @author Luís Reis
 */
public class TranslationError {

    public boolean isFatal;
    public Leaf leaf;
    public PineDLContext context;
    /**
     * Should be ONLY the method, not the "in function NAME: etc."
     */
    public String errorMessage;

    public TranslationError(boolean isFatal, Leaf leaf, PineDLContext context,
            String errorMessage) {
        this.isFatal = isFatal;
        this.leaf = leaf;
        this.context = context;
        this.errorMessage = errorMessage;
    }

    public String generateFullErrorMessage() {
        return "In " + context.contentClass.clsName + "." + context.getFunctionName() + ":" + errorMessage;
    }
}
