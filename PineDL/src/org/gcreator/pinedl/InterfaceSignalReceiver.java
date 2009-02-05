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

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/**
 * This signal receiver outputs a PDI interface.
 * @author Luís Reis
 */
public class InterfaceSignalReceiver extends SignalReceiver {

    private OutputStream stream;
    private String pkg = "";
    private Vector<String> imports = new Vector<String>();

    public InterfaceSignalReceiver(OutputStream stream) throws IOException {
        stream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
        this.stream = stream;
    }

    public OutputStream getStream() {
        return stream;
    }

    @Override
    public void sendPackageSignal(String pkg) {
        this.pkg = pkg;
    }

    @Override
    public void sendImportSignal(String cls) {
        imports.add(cls);
    }

    @Override
    public void sendClassDeclaration(String cls, String bcls) {
        try {
            stream.write(("<pdi version=\"1.0\" name=\"" + cls + "\" extends=\"" + (bcls == null ? "" : bcls) + "\">\n").getBytes());
            stream.write(("<package>" + pkg + "</package>\n").getBytes());
            for (String imp : imports) {
                stream.write(("<import>" + imp + "</import>\n").getBytes());
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void sendConstructorSignal(String privacy, Vector<Argument> args) {
        try {
            stream.write(("<constructor privacy=\"" + privacy + "\">\n").getBytes());

            for (Argument arg : args) {
                stream.write(("<argument type=\"" + arg.type + "\" name=\"" + arg.name + "\"/>\n").getBytes());
            }

            stream.write(("</constructor>\n").getBytes());
        } catch (Exception e) {
        }
    }

    @Override
    public void sendFieldSignal(String privacy, boolean isStatic, boolean isConst,
            String type, String name) {

        try {
            stream.write(("<field privacy=\"" + privacy + "\" static=\"" + isStatic + "\" const=\"" + isConst + "\" type=\"" + type + "\" name=\"name\"/>\n").getBytes());
        } catch (Exception e) {
        }
    }

    @Override
    public void sendMethodSignal(String privacy, boolean isStatic, String type,
            String name, Vector<Argument> args) {

        try {
            stream.write(("<method privacy=\"" + privacy +
                    "\" static=\"" + isStatic + "\" return=\"" + type + "\" name=\"" + name + "\">\n").getBytes());

            for (Argument arg : args) {
                stream.write(("<argument type=\"" + arg.type + "\" name=\"" + arg.name + "\"/>\n").getBytes());
            }

            stream.write("</method>\n".getBytes());
        } catch (Exception e) {
        }
    }

    @Override
    public void endClass() {
        try {
            stream.write(("</pdi>\n").getBytes());
        } catch (Exception e) {
        }
    }
}
