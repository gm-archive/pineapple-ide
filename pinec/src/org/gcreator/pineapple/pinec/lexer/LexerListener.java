/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.lexer;

import org.gcreator.pineapple.pinec.CompilerError;

/**
 *
 * @author Luís Reis
 */
public abstract class LexerListener {
    public abstract boolean handleToken(Token token);
    public abstract boolean handleError(CompilerError error);
    public abstract void handleEnd();
}
