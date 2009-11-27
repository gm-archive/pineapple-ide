/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec;

/**
 *
 * @author luis
 */
public final class CompilerError {
    private final boolean fatal;
    private final int line;
    private final int col;
    private final String message;

    public CompilerError(boolean isFatal, int line, int col, String message){
        this.fatal = isFatal;
        this.line = line;
        this.col = col;
        this.message = message;
    }

    public boolean isFatal(){
        return fatal;
    }

    public int getLine(){
        return line;
    }

    public int getCol(){
        return col;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder();
        builder.append(getLine());
        builder.append(':');
        builder.append(getCol());
        builder.append(":\t");
        builder.append(getMessage());
        return builder.toString();
    }
}
