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
package org.gcreator.pineapple.pinedl;

import java.util.Vector;
import org.gcreator.pineapple.pinedl.statements.Expression;

/**
 * Represents a constructor
 * @author Luís Reis
 */
public class Constructor extends FunctionConstructorBase {

    public Vector<Expression> superArguments = null;

    @Override
    public String toString() {
        String s = access.toString();

        s += " this(";

        boolean first = true;
        for (Argument a : arguments) {
            if (!first) {
                s += ", ";
            }
            s += a.toString();
            first = false;
        }

        s += ")";

        if (superArguments != null) {
            s += ": super(";
            first = true;
            for (Expression e : superArguments) {
                if (!first) {
                    s += ", ";
                }
                s += e.toString();
                first = false;
            }
            s += ")";
        }

        s += content.toString();

        return s;
    }

    public Constructor optimize() {
        content.optimize();
        return this;
    }

    public String getName() {
        return "&lt;constructor&gt;";
    }
}
