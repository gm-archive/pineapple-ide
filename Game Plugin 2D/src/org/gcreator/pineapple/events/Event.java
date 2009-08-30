/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge@bobtheblueberry.com>

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
package org.gcreator.pineapple.events;

import java.util.Vector;

/**
 * Holds things like the <tt>PineDL</tt> code for the event.
 * 
 * @author Luís Reis
 */
public class Event {

    /**
     * The Create event.
     * Called when the instance is created.
     */
    public static final String TYPE_CREATE = "Create Event";
    /**
     * The Update event.
     * Called when the instance is updated.
     */
    public static final String TYPE_UPDATE = "Update Event";
    /**
     * The Draw event.
     * Called when the instance is drawed.
     */
    public static final String TYPE_DRAW = "Draw Event";
    /**
     * The Destroy event.
     * Called when the instance is destroyed.
     */
    public static final String TYPE_DESTROY = "Destroy Event";
    /**
     * The KeyPress event.
     * Called when a key is pressed.
     */
    public static final String TYPE_KEYPRESS = "Key Press Event";
    /**
     * The KeyRelease event.
     * Called when a key is released.
     */
    public static final String TYPE_KEYRELEASE = "Key Release Event";

    /**
     * The KeyPressed event.
     * Called when a key is down.
     */
    public static final String TYPE_KEYPRESSED = "Key Pressed Event";

    /**
     * Actors only
     * Called when a collision is found
     */
    public static final String TYPE_COLLISION = "Collision Event";
    
    /**
     * Creates a new {@link Event}.
     * 
     * @param type The type of the event.
     */
    public Event(String type) {
        this.type = type;
        this.listeners = new Vector<EventChangeListener>();
    }

    /**
     * Gets the event's type.
     * 
     * @return The type of this event.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the <tt>PineDL</tt> code for this event.
     * 
     * @return The <tt>PineDL</tt> code for this event.
     */
    public String getPineDL() {
        return pineDL;
    }

    /**
     * Sets the <tt>PineDL</tt> code for this event.
     * 
     * @param newPineDL The new <tt>PineDL</tt> code.
     */
    public void setPineDL(String newPineDL) {
        this.pineDL = newPineDL;
        fireChange();
    }
    
    /**
     * Registers the given {@link EventChangeListener} to listen for
     * changes to this event.
     * 
     * @param l The {@link EventChangeListener} to register.
     */
    public void addChangeListener(EventChangeListener l) {
        listeners.add(l);
    }
    
    /**
     * Unregisters the given {@link EventChangeListener} so that it
     * no longer listens for changes to this event.
     * 
     * @param l The {@link EventChangeListener} to de-register.
     * 
     * @return Whether the given listener was indeed registered
     * and sucessfully ungegistered.
     */
    public boolean removeChangeListener(EventChangeListener l) {
        return listeners.remove(l);
    }
    
    private void fireChange() {
        for (EventChangeListener e : listeners) {
         e.eventChanged(this);   
        }
    }
    
    private volatile Vector<EventChangeListener> listeners;
    
    protected String type;
    protected String pineDL;
    
    /**
     * Listens for changes to events.
     */
    public interface EventChangeListener {
        
        /**
         * Called when the event is changed.
         * 
         * @param e The event that was changed.
         */
        public void eventChanged(Event e);
    }
}
