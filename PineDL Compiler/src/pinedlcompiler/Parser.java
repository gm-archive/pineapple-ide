/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler;

import java.util.List;
import pinedlcompiler.tree.DocumentNode;

/**
 *
 * @author Luís Reis
 */
public class Parser {
    private Library library;
    private List<Token> tokens;
    private DocumentNode document;

    public Parser(List<Token> tokens, Library library){
        this.library = library;
        this.tokens = tokens;
        document = null;
    }
    
    public void parse() throws ParserException{
        document = new DocumentNode();
        if(tokens.isEmpty()){
            return;
        }
        int i = 0;
        int tokensLength = tokens.size();
        while(i < tokensLength){
            Token currentToken = tokens.get(i);
            Token.Type currentTokenType = currentToken.type;

            if(currentTokenType==Token.Type.CLASS){
                i = parseClass(i);
            }
            else if(currentTokenType==Token.Type.FUNCTION){
                i = parseFunction(i);
            }
            else{
                throw buildException(currentToken, "Unexpected token '" + currentToken.text + "'");
            }

            i++;
        }
    }

    public int parseClass(int i) throws ParserException{
        return i;
    }

    public int parseFunction(int i) throws ParserException{
        return i;
    }

    public ParserException buildException(Token token, String message){
        return new ParserException("In line " + token.line + ":\n\t"
                + message);
    }

    public DocumentNode getDocumentNode(){
        return document;
    }
}
