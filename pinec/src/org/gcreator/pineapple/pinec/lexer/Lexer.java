/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gcreator.pineapple.pinec.lexer;

import org.gcreator.pineapple.pinec.CompilerError;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luis
 */
public class Lexer {

    //<editor-fold defaultstate="collapsed" desc="Fields">
    private static final Map<Character, Operator> operators1;
    private static final Map<String, Operator> operators2, operators3;
    private final Reader reader;
    private final LexerListener listener;
    private int currentLine = 1;
    private int currentCol = 0;
    private int previousChar = 0; //Unreliable immediatly after a rewind()
    private int currentChar = 0;
    private int nextChar = 0;
    private boolean hasRewinded = false;
    private int furtherChar = 0; //Unreliable
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Operator initialization">
    static {
        operators1 = new HashMap<Character, Operator>();
        operators2 = new HashMap<String, Operator>();
        operators3 = new HashMap<String, Operator>();

        for (Operator operator : Operator.values()) {
            String opStr = operator.getStringRepresentation();
            int length = opStr.length();
            if (length == 1) {
                operators1.put(opStr.charAt(0), operator);
            } else if (length == 2) {
                operators2.put(opStr, operator);
            } else if (length == 3) {
                operators3.put(opStr, operator);
            }
        }
    }
    //</editor-fold>

    public Lexer(final Reader reader, final LexerListener listener) throws IOException {
        this.reader = reader;
        this.listener = listener;

        forward();
    }

    //<editor-fold defaultstate="collapsed" desc="isXXX">
    private boolean isLineBreak(int ch) {
        return ch == '\n' || ch == '\r';
    }

    private boolean isDigit(int ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isWhitespace(int ch){
        return ch == ' '
                || ch == '\t'
                || isLineBreak(ch);
    }

    private boolean isHexadecimalDigit(int ch){
        return isDigit(ch)
                || (ch >= 'a' && ch <= 'f')
                || (ch >= 'A' && ch <= 'F');
    }

    private boolean isAlpha(int ch){
        return ch=='_'
                || ch == '$'
                || (ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z');
    }

    private boolean isAlphanumeric(int ch){
        return isAlpha(ch)||isDigit(ch);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="parseString">
    private void parseString() throws LexerException, IOException {
        String content = "";
        int startLine = currentLine;
        int startCol = currentCol;

        strloop:
        while (true) {
            if (!good()) {
                fastError(true, "Unexpected end of file (unclosed string literal)");
                return;
            }
            forward();
            if (isLineBreak(currentChar)) {
                fastError(true, "Unexpected line break (unclosed string literal)");
                return;
            }
            if (currentChar == '\\') {
                if (!good()) {
                    fastError(true, "Unexpected end of file (unclosed string literal)");
                    return;
                }
                content += parseEscapeSequence();
                continue;
            }
            if(currentChar=='"'){
                fastToken(new Token(TokenType.STRING, startLine, startCol, content));
                break strloop;
            }
            content += (char) currentChar;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="parseCharacter">
    private void parseCharacter() throws LexerException, IOException {
        int startLine = currentLine;
        int startCol = currentCol;

        if(!good()){
            fastError(true, "Unexpected end of file (unclosed character literal)");
            return;
        }

        if(currentChar=='\''){
            fastError(true, "Empty character literal");
            return;
        }

        if(isLineBreak(currentChar)){
            fastError(true, "Unexpected line break (unclosed character literal)");
            return;
        }

        String content = "";

        if(currentChar=='\\'){
            content += parseEscapeSequence();
        }
        else{
            content += currentChar;

            if(!good()){
                fastError(true, "Unexpected end of file (unclosed character literal)");
            }
            forward();
            if(currentChar!='\''){
                fastError(true, "Character literal must contain only a single character");
                return;
            }

        }

        fastToken(new Token(TokenType.CHAR, startLine, startCol, content));
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="parseEscapeSequence">
    private char parseEscapeSequence() throws IOException, LexerException {
        forward();
        switch (currentChar) {
            case 'r':
                return '\r';
            case 'n':
                return '\n';
            case 't':
                return '\t';
            case '"': //no break
            case '\\': //no break
            case '\'':
                return (char) currentChar;
        }
        if (isDigit(currentChar)) {
            if (currentChar == '8' || currentChar == '9') {
                fastError(true, "ASCII escape sequence not in valid octal");
                return '\0';
            }
            char ch = (char) (currentChar - '0');
            if (ch <= '3') {
                if (!good()) {
                    fastError(true, "Unexpected end of file after ASCII escape sequence");
                    return ch;
                }
                forward();
                if (!isDigit(currentChar) || currentChar == '8' || currentChar == '9') {
                    backward();
                }
                else{
                    ch *= 8;
                    ch += (char) (currentChar-'0');
                    if(!good()){
                        fastError(true, "Unexpected end of file after ASCII escape sequence");
                        return ch;
                    }
                    forward();
                    if(!isDigit(currentChar)){
                        backward();
                    }
                    else{
                        ch *= 8;
                        ch += (char) (currentChar-'0');
                    }
                }
                return ch;
            } else {
                if(!good()){
                    fastError(true, "Unexpected end of file after ASCII escape sequence");
                    return ch;
                }
                forward();
                if(!isDigit(currentChar)){
                    backward();
                }
                else{
                    ch *= 8;
                    ch += (char) (currentChar-'0');
                }
                return ch;
            }
        }

        //TODO: Hexadecimal sequences(ASCII and UNICODE)

        return '\0';
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="parseNumber">
    private boolean parseNumber() throws IOException, LexerException{
        if(!isDigit(currentChar)){
            if(currentChar!='.'||!isDigit(currentChar)){
                return false;
            }
        }
        
        int startCol = currentCol;
        final StringBuilder content = new StringBuilder();

        if(currentChar=='0'){
            forward();

            if(currentChar=='x'||currentChar=='X'){
                boolean hasNumber = false;
                int number = 0;
                while(good()){
                    forward();
                    if(isHexadecimalDigit(currentChar)){
                        hasNumber = true;
                        int n = currentChar;
                        if(isDigit(currentChar)){
                            n -= '0';
                        }
                        else if(currentChar>='a'&&currentChar<='f'){
                            n -= 'a';
                            n += 10;
                        }
                        else{
                            n -= 'A';
                            n += 10;
                        }
                        number <<= 4;
                        number += n;
                    }
                    else{
                        if(currentChar=='.'&&isDigit(nextChar)){
                            fastError(true, "Non-integer numbers not supported in hexadecimal");
                        }
                        break;
                    }
                }
                if(!hasNumber){
                    fastError(true, "Expected hexadecimaal number after '0x'");
                    return true;
                }

                backward();
                content.append(number);
                fastToken(new Token(TokenType.NUMBER, currentLine, startCol, content.toString()));
                return true;
            }
            else if(currentChar=='.'){
                return parseFractionalPart(0, startCol);
            }
            else if(isDigit(currentChar)){
                //Octal
                int number = 0;
                backward();
                while(good()){
                    forward();
                    if(currentChar=='.'){
                        if(isDigit(nextChar)){
                            fastError(true, "Fractional numbers not supported in octal");
                        }
                        backward();
                        break;
                    }
                    if(isDigit(currentChar)){
                        if(currentChar=='8'||currentChar=='9'){
                            fastError(true, "Invalid octal sequence (Found " + currentChar + ')');
                            break;
                        }
                        number <<= 3;
                        number += currentChar - '0';
                    }
                    else{
                        if(isAlpha(currentChar)){
                            fastError(true, "Unexpected character after numeric sequence");
                        }
                        backward();
                        break;
                    }
                }

                content.append(number);
                fastToken(new Token(TokenType.NUMBER, currentLine, startCol, content.toString()));
                return true;
            }
            else if(isAlpha(currentChar)){
                backward();
                fastError(true, "Unexpected character after numeric sequence");
                return true;
            }
            else{
                backward();
                //0
                fastToken(new Token(TokenType.NUMBER, currentLine, startCol, content.toString()));
                return true;
            }
        }
        else if(isDigit(currentChar)){
            //Parse 12345.67890 sequences
            int number = 0;
            backward();
            while(good()){
                forward();
                if(currentChar=='.'){
                    if(isDigit(nextChar)){
                        return parseFractionalPart(number, startCol);
                    }
                    backward();
                    break;
                }
                if(isDigit(currentChar)){
                    number *= 10;
                    number += currentChar - '0';
                }
                else if(isAlpha(currentChar)){
                    fastError(true, "Unexpected character after numeric sequence");
                    break;
                }
                else{
                    backward();
                    break;
                }
            }
            content.append(number);
            fastToken(new Token(TokenType.NUMBER, currentLine, startCol, content.toString()));
            return true;
        }
        else if(currentChar=='.'){
            if(!isDigit(nextChar)){
                return false;
            }
            return parseFractionalPart(0, startCol);
        }

        return true;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="parseFractionalPart">
    private boolean parseFractionalPart(int integerPart,
            int startCol) throws IOException, LexerException{

        String content = "";
        content += integerPart;
        content += '.';

        while(good()){
            forward();
            if(currentChar=='.'){
                if(good()&&isDigit(nextChar)){
                    fastError(true, "Invalid numeric sequence");
                    return true;
                }
                else{
                    backward();
                }
                break;
            }
            if(!isDigit(currentChar)){
                if(isAlpha(currentChar)){
                    fastError(true, "Unexpected character after numeric sequence");
                }
                backward();
                break;
            }
            content += (char) currentChar;
        }

        if(content.endsWith(".")){
            fastError(true, "Empty number fractional part");
            return true;
        }

        fastToken(new Token(TokenType.NUMBER, currentLine, startCol, content));

        return true;
    }
    //</editor-fold>

    public void run() throws IOException {
        try {
            bigloop:
            while (good()) {
                forward();

                if (currentChar == '"') {
                    parseString();
                    continue;
                }
                if (currentChar == '\''){
                    parseCharacter();
                    continue;
                }
                if (currentChar == '/' && nextChar == '/'){
                    while(good()&&!isLineBreak(currentChar)){
                        forward();
                    }
                    continue;
                }
                if (currentChar == '/' && nextChar == '*'){
                    forward();
                    while(true){
                        if(!good()){
                            fastError(true, "Unexpected end of file (Unclosed block comment)");
                            continue bigloop;
                        }
                        forward();
                        if(currentChar=='*'&&nextChar=='/'){
                            forward();
                            continue bigloop;
                        }
                    }
                }

                if(isWhitespace(currentChar)){
                    continue;
                }

                if(parseNumber()){
                    continue;
                }

                if(operators1.containsKey((char) currentChar)){
                    forward();
                    StringBuilder content = new StringBuilder();
                    content.append((char) previousChar);
                    content.append((char) currentChar);
                    content.append((char) nextChar);
                    if(operators3.containsKey(content.toString())){
                        forward();
                        fastToken(new Token(operators3.get(content.toString()), currentLine, currentCol-2, content.toString()));
                        continue;
                    }
                    content.delete(2, 3);
                    if(operators2.containsKey(content.toString())){
                        fastToken(new Token(operators2.get(content.toString()), currentLine, currentCol-1, content.toString()));
                        continue;
                    }
                    backward();
                    content.delete(1, 2);
                    fastToken(new Token(operators1.get((char) currentChar), currentLine, currentCol, content.toString()));
                    continue;
                }

                if(isAlpha(currentChar)){
                    int startCol = currentCol;
                    final StringBuilder content = new StringBuilder();
                    content.append((char) currentChar);
                    while(good()&&isAlphanumeric(nextChar)){
                        forward();
                        content.append((char) currentChar);
                    }

                    final String val = content.toString();
                    Keyword k = Keyword.findKeyword(val);

                    if(k==null){
                        fastToken(new Token(TokenType.WORD, currentLine, startCol, val));
                        continue;
                    }
                    fastToken(new Token(k, currentLine, startCol, val));
                    continue;
                }

                fastError(true, "Unexpected " + currentChar);
                continue;

            }
        } catch (LexerException e) {
            return;
        } finally{
            listener.handleEnd();
        }
    }

    private void fastError(boolean isFatal, String message) throws LexerException {
        if (listener.handleError(new CompilerError(isFatal, currentLine, currentCol, message))) {
            throw new LexerException();
        }
    }

    private void fastToken(Token token) throws LexerException{
        if(listener.handleToken(token)){
            throw new LexerException();
        }
    }

    private boolean good() throws IOException {
        return nextChar != -1 && (reader.ready() || hasRewinded);
    }

    private void forward() throws IOException {
        previousChar = currentChar;
        currentChar = nextChar;
        if (hasRewinded) {
            nextChar = furtherChar;
        } else {
            nextChar = reader.read();
        }
        if(!hasRewinded){
            currentCol++;
        }
        final boolean isR = (currentChar == '\r');
        if (isR || currentChar == '\n') {
            if (isR && nextChar == '\n') {
                currentChar = '\n';
                nextChar = reader.read();
            }
            if(!hasRewinded){
                currentLine++;
                currentCol = 1;
            }
        }

        hasRewinded = false;
    }

    private void backward() {
        furtherChar = nextChar;
        nextChar = currentChar;
        currentChar = previousChar;
        hasRewinded = true;
    }
}
