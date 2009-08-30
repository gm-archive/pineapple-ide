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
package org.gcreator.pineapple.managers;

import org.gcreator.pineapple.plugins.EventHandler;
import org.gcreator.pineapple.plugins.EventPriority;
import org.gcreator.pineapple.plugins.Event;
import java.util.Vector;

/**
 * This class manages all G-Creator events.
 * These are called when something happens (like thw main windows closes) in order
 * to inform plug-ins about what is happening.
 * 
 * All events have a priority, and a category.
 * 
 * @see EventPriority
 * 
 * @author Luís Reis
 */
public final class EventManager {

    private static Vector<EventObject> highPriority = new Vector<EventObject>();
    private static Vector<EventObject> mediumPriority = new Vector<EventObject>();
    private static Vector<EventObject> lowPriority = new Vector<EventObject>();

    /**
     * Adds an {@link EventHandler} to the event list with a priority of {@link EventPriority#MEDIUM}.
     * 
     * @param handler The {@link EventHandler} to add.
     * @param type The type of event this is.
     * 
     * @see #addEventHandler(EventHandler, String, EventPriority)
     */
    public static void addEventHandler(EventHandler handler, String type) {
        addEventHandler(handler, type, EventPriority.MEDIUM);
    }

    /**
     * Adds an {@link EventHandler} to the event list with a given priority.
     * 
     * @param handler The {@link EventHandler} to add.
     * @param type The type of event this is.
     * @param priority The priority of the event.
     * 
     * @see #addEventHandler(EventHandler, String)
     */
    public static void addEventHandler(EventHandler handler, String type, EventPriority priority) {
        if (type != null) {
            EventObject obj = new EventObject();
            obj.handler = handler;
            obj.type = type;
            if (priority == EventPriority.HIGH) {
                highPriority.add(obj);
            } else if (priority == EventPriority.MEDIUM) {
                mediumPriority.add(obj);
            } else if (priority == EventPriority.LOW) {
                lowPriority.add(obj);
            }
        }
    }

    /**
     * Removes a handler, regardless of the event(s) it points to
     * 
     * @param handler The {@link EventHandler} to remove.
     */
    public static void removeEventHandler(EventHandler handler) {
        EventObject o = new EventObject();
        o.handler = handler;
        o.deleter = true;
        while (highPriority.remove(o)) {
            continue;
        }
        while (mediumPriority.remove(o)) {
            continue;
        }
        while (lowPriority.remove(o)) {
            continue;
        }
    }

    /**
     * Fires a new event and notifies all listeners.
     * 
     * @param sender The event sender. Typically, just use the keyword 'this'
     * @param type The type of the event. Must not be null nor "all"
     * @param arguments The arguments of the event. May be of any type and in any number.
     */
    @SuppressWarnings("unchecked")
    public static void fireEvent(Object sender, String type, Object... arguments) {
        CannonBall ball = new CannonBall(sender, type, arguments);
        Thread cannon = new Thread(ball, "Cannon Firing event " + type);
        cannon.start();
    }

    /**
     * Fires a new event and notifies all listeners.
     *
     * @param sender The event sender. Typically, just use the keyword 'this'
     * @param type The type of the event. Must not be null nor "all"
     * @param waitfor Whether to hold the current thread until the event has
     * called all listeners.
     * @param arguments The arguments of the event. May be of any type and in any number.
     */
    @SuppressWarnings("unchecked")
    public static void fireEvent(Object sender, String type, boolean waitfor, Object... arguments) {
        CannonBall ball = new CannonBall(sender, type, arguments);
        if (waitfor) {
            /* Yeay! No threading required.*/
            ball.run();
        } else {
            /* Some threading to do here. */
            Thread cannon = new Thread(ball, "Cannon Firing event " + type);
            cannon.start();
        }
    }
    
    /**
     * Used to hold event handlers associated with specific types.
     */
    private static class EventObject {

        EventHandler handler;
        String type;
        /**
         * Deleter means don't worry about the type, this is only used
         * for removeEventHandler purposes.
         */
        boolean deleter = false;

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != getClass()) {
                return false;
            }
            if (((EventObject) o).handler == this.handler && (((EventObject) o).deleter || deleter || ((EventObject) o).type.equals(type))) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 83 * hash + (this.handler != null ? this.handler.hashCode() : 0);
            return hash;
        }
    }

    private EventManager() {
    }

    private static final class CannonBall implements Runnable {

        private Object sender;
        private String type;
        private Object[] arguments;

        public CannonBall(Object sender, String type, Object[] arguments) {
            this.sender = sender;
            this.type = type;
            this.arguments = arguments;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void run() {
            if (type != null && !type.equals("all")) { /* Event type 'all' can not be fired. */
                Event evt = new Event(sender, type, arguments);
                fireEvent((Vector<EventObject>) highPriority.clone(), type, evt);
                fireEvent((Vector<EventObject>) mediumPriority.clone(), type, evt);
                fireEvent((Vector<EventObject>) lowPriority.clone(), type, evt);
            }
        }

        private void fireEvent(Vector<EventObject> evts, String type, Event evt) {
            synchronized (evts) {
                for (EventObject o : evts) {
                    if (o.handler == null) {
                        continue;
                    }
                    if (o.type.equals(type) || o.type.equals("all")) {
                        o.handler.handleEvent(evt);
                    }
                    if (evt.isHandled()) {
                        return;
                    }
                }
            }
        }
    }
}
