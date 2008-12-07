/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

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
package org.gcreator.gui;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.gcreator.core.Core;
import org.gcreator.pineapple.PineapplePlugin;
import org.gcreator.plugins.Plugin;

/**
 * Renders the tree in the {@link PluginDialog}.
 * 
 * @author Serge Humphrey
 */
public final class PluginTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private static final int columns = 2;

    /**
     * {@inheritDoc}
     */
    public int getRowCount() {
        return Core.getStaticContext().getPlugins().size();
    }

    /**
     * {@inheritDoc}
     */
    public int getColumnCount() {
        return columns;
    }

    /**
     * {@inheritDoc}
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Core.getStaticContext().getPlugins().get(rowIndex).getName();

            case 1:
                return Core.getStaticContext().getPlugins().get(rowIndex).isEnabled();

            default:
                return rowIndex + ", " + columnIndex;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {

            case 0:
                return "Name";

            case 1:
                return "Enabled";

            default:
                return Integer.toString(columnIndex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.getValueAt(0, columnIndex).getClass();
    }
    /**
     * Prevents the warning dialog from being permanently shown
     */
    private static boolean askedBefore = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex != 1) {
            return false;
        }
        Plugin p = Core.getStaticContext().getPlugins().get(rowIndex);
        if (!p.isEnabled()) {
            return true;
        }
        if (getValueAt(
                rowIndex, 0).equals("Pineapple Default Plug-In")) {
            return false;
        }
        
        
        int o = JOptionPane.OK_OPTION;
        if (!askedBefore) {
            o = JOptionPane.showConfirmDialog(Core.getStaticContext().getMainFrame(),
                    "<html>Are you sure you want to disable plugin " + p.getName() + "?<br/>" +
                    "Disabling some plugins may result in losing important " +
                    "features." +
                    "<br/><br/>" +
                    "To revert these changes, you must manually delete the settings" +
                    "<br/>file under {USER HOME}/.sabre/settings.xml.</html>");
            if (o == JOptionPane.OK_OPTION) {
                askedBefore = true;
            }
        }

        return (o == JOptionPane.OK_OPTION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue instanceof Boolean && columnIndex == 1) {
            Core.getStaticContext().getPlugins().get(rowIndex).setEnabled((Boolean) aValue);
        }
    }
}
