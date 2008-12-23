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

package org.gcreator.dnd;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;
import org.gcreator.actions.Action;
import org.gcreator.actions.ActionType;
import org.gcreator.events.Event;
import org.gcreator.gui.ActionListModel;

/**
 * A class that deals with data transference from action drag&drop
 * @author Luís Reis
 * @see ActionTransferable
 */
public class ActionTransferHandler extends TransferHandler{
    private static final long serialVersionUID = 8941610639649161438L;
    public static DataFlavor actionFlavor = new DataFlavor(Action.class, "Action");

    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }
    
    @Override
    public Transferable createTransferable(JComponent c) {
        if(c instanceof PaletteAction){
            ActionType t = ((PaletteAction) c).type;
            Action a = new Action(t);
            return new ActionTransferable(a);
        }
        return null;
    }
    
    public void exportDone(JComponent c, Transferable t, int action) {
        if(action==MOVE&&c instanceof JList){
            try{
                
                JList list = (JList) c;
                Action a = (Action) t.getTransferData(actionFlavor);
                Action b = (Action) list.getSelectedValue();
                if(b!=null){
                    Event e = ((ActionListModel) list.getModel()).getEvent();
                    e.actions.remove(b);
                    e.actions.trimToSize();
                    list.updateUI();
                }
            }
            catch(Exception e){
                
            }
        }
    }
    
    @Override
    public boolean canImport(TransferHandler.TransferSupport ts){
        if(!(ts.getComponent() instanceof JList)){
            return false;
        }
        for(DataFlavor df : ts.getDataFlavors()){
            if(df.getRepresentationClass()==Action.class){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean importData(TransferHandler.TransferSupport ts){
        if(!(ts.getComponent() instanceof JList)){
            return false;
        }
        for(DataFlavor df : ts.getDataFlavors()){
            if(df.getRepresentationClass()==Action.class){
                try{
                    JList list = (JList) ts.getComponent();
                    ActionListModel alm = (ActionListModel) list.getModel();
                    int index = list.getDropLocation().getIndex();//ts.getDropLocation().getDropPoint());
                    Vector<Action> actions = alm.getEvent().actions;
                    if(actions.size()<=index||index==-1){
                        actions.add((Action) ts.getTransferable().getTransferData(actionFlavor));
                    }
                    else{
                        actions.ensureCapacity(index+1);
                        actions.insertElementAt(
                            (Action) ts.getTransferable().getTransferData(actionFlavor), index);
                    }
                    list.updateUI();
                    System.out.println("Lets return true");
                    return true;
                }
                catch(Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }
    
}
