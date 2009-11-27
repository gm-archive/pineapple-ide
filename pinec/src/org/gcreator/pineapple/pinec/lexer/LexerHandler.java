/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.lexer;

import org.gcreator.pineapple.pinec.CompilerError;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luís Reis
 */
public class LexerHandler extends LexerListener{
    public List<Token> tokens;
    public List<CompilerError> errors;

    public LexerHandler(){
        tokens = new Vector<Token>();
        errors = new Vector<CompilerError>();
    }

    public void handleEnd(){

    }

    public boolean handleToken(Token token){
        tokens.add(token);
        return false;
    }
    
    public boolean handleError(CompilerError error){
        errors.add(error);
        return error.isFatal();
    }
}
