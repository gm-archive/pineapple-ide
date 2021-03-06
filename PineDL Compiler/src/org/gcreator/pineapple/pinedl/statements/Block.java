/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphre<bob@bobtheblueberry.com>

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

import java.util.Vector;
import org.gcreator.pineapple.pinedl.Leaf;

/**
 * Represents a group of statements
 * @author Luís Reis
 */
public class Block extends Leaf {

    public Vector<Leaf> content = new Vector<Leaf>();

    @Override
    public Leaf optimize(){
        if(content.isEmpty()){
            return null;
        }
        Vector v = (Vector) content.clone();
        content.clear();
        for(Object leaf : v){
            if(leaf==null){ continue; }
            Leaf l = ((Leaf) leaf).optimize();
            content.add(l);
        }
        return this;
    }
    
    @Override
    public String toString() {
        String s = "[";
        boolean first = true;
        for (Leaf leaf : content) {
            if (!first) {
                s += ", ";
            }
            s += leaf;
            first = false;
        }
        return s + "]";
    }
}
