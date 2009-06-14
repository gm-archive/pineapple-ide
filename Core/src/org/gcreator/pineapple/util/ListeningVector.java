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
package org.gcreator.pineapple.util;

import java.util.Collection;
import java.util.Vector;

/**
 * A {@link Vector} that you to listen for changes on.
 *
 * @param <E> The type.
 * @author Serge Humphrey
 */
public class ListeningVector<E> extends Vector<E> {

    private static final long serialVersionUID = 14904352L;
    protected Vector<VectorChangeListener> listeners = new Vector<VectorChangeListener>();

    /**
     * Adds the given {@link VectorChangeListener} to the list of listeners.
     *
     * @param l The listener to add.
     */
    public void addListener(VectorChangeListener l) {
        listeners.add(l);
    }

    /**
     * Removes the given {@link VectorChangeListener} from the list of listeners.
     *
     * @param l The listener to remove.
     */
    public void removeListener(VectorChangeListener l) {
        listeners.remove(l);
    }

    protected void fireUpdate() {
        for (VectorChangeListener l : listeners) {
            l.vectorChanged(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        boolean b = super.add(e);
        fireUpdate();
        return b;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        boolean b = super.remove(o);
        fireUpdate();
        return b;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean b = super.addAll(c);
        fireUpdate();
        return b;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean b = super.addAll(index, c);
        fireUpdate();
        return b;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean b = super.removeAll(c);
        fireUpdate();
        return b;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean b = super.removeAll(c);
        fireUpdate();
        return b;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        fireUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        E x = super.set(index, element);
        fireUpdate();
        return x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, E element) {
        super.add(index, element);
        fireUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        E x = super.remove(index);
        fireUpdate();
        return x;
    }
}
