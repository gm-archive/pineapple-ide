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
package org.gcreator.pineapple.pinedl.statements;

/**
 * Represents x++, ++x, x-- and --x operators
 * @author Luís Reis
 */
public class PrePostFixOperator extends Operation {

    /**
     * true for --x, false for x--
     */
    public boolean pre = false;
    /**
     * true for x++, false for x--
     */
    public boolean sum = false;
    public Expression content = null;

    public PrePostFixOperator(boolean pre, boolean sum, Expression content) {
        this.pre = pre;
        this.sum = sum;
        this.content = content;
    }

    @Override
    public String toString() {
        if (pre) {
            return (sum ? "++" : "--") + content.toString();
        }
        return content.toString() + (sum ? "++" : "--");
    }
}
