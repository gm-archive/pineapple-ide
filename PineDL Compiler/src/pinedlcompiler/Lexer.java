/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Luís Reis
 */
public final class Lexer {
    private final InputStream is;
    private List<Token> list = null;
    private String file = null;
    private int currentLine = 1;
    
    private static final Hashtable<String, Token.Type> keywords
            = new Hashtable<String, Token.Type>();
    
    private static final Hashtable<String, Token.Type> threeCharTokens
            = new Hashtable<String, Token.Type>();
    
    private static final Hashtable<String, Token.Type> twoCharTokens
            = new Hashtable<String, Token.Type>();
    
    private static final Hashtable<Character, Token.Type> singleTokens
            = new Hashtable<Character, Token.Type>();
    
    static{
        keywords.put("if", Token.Type.IF);
        keywords.put("else", Token.Type.ELSE);
        keywords.put("while", Token.Type.WHILE);
        keywords.put("for", Token.Type.FOR);
        keywords.put("class", Token.Type.CLASS);
        keywords.put("function", Token.Type.FUNCTION);
        keywords.put("var", Token.Type.VAR);
        keywords.put("const", Token.Type.CONST);
        keywords.put("public", Token.Type.PUBLIC);
        keywords.put("protected", Token.Type.PROTECTED);
        keywords.put("private", Token.Type.PRIVATE);
        keywords.put("number", Token.Type.NUMBER);
        keywords.put("char", Token.Type.CHAR);
        keywords.put("bool", Token.Type.BOOL);
        keywords.put("string", Token.Type.STRING);
        keywords.put("range", Token.Type.RANGE);
        keywords.put("type", Token.Type.TYPE);
        keywords.put("void", Token.Type.VOID);
        keywords.put("try", Token.Type.TRY);
        keywords.put("catch", Token.Type.CATCH);
        keywords.put("throw", Token.Type.THROW);
        keywords.put("return", Token.Type.RETURN);
        keywords.put("break", Token.Type.BREAK);
        keywords.put("continue", Token.Type.CONTINUE);
        keywords.put("true", Token.Type.TRUE);
        keywords.put("false", Token.Type.FALSE);
        keywords.put("null", Token.Type.NULL);
        keywords.put("extends", Token.Type.EXTENDS);
        keywords.put("is", Token.Type.IS);
        keywords.put("new", Token.Type.NEW);
        keywords.put("this", Token.Type.THIS);
        keywords.put("super", Token.Type.SUPER);
        
        threeCharTokens.put("&&=", Token.Type.LOGICAL_ANDEQUAL);
        threeCharTokens.put("...", Token.Type.VARARGS);
        twoCharTokens.put("++", Token.Type.INCREMENT);
        twoCharTokens.put("+=", Token.Type.PLUSEQUAL);
        twoCharTokens.put("--", Token.Type.DECREMENT);
        twoCharTokens.put("-=", Token.Type.MINUSEQUAL);
        twoCharTokens.put("*=", Token.Type.MULTEQUAL);
        twoCharTokens.put("/=", Token.Type.DIVEQUAL);
        twoCharTokens.put("%=", Token.Type.MODEQUAL);
        
        twoCharTokens.put(">=", Token.Type.GREATEREQUAL);
        twoCharTokens.put("=>", Token.Type.KEYASSIGN);
        singleTokens.put('=', Token.Type.EQUAL);
        singleTokens.put('+', Token.Type.PLUS);
        singleTokens.put('-', Token.Type.MINUS);
        singleTokens.put('*', Token.Type.MULT);
        singleTokens.put('/', Token.Type.DIV);
        singleTokens.put('%', Token.Type.MOD);
        
        singleTokens.put(':', Token.Type.COLON);
        singleTokens.put(',', Token.Type.COMMA);
        singleTokens.put('.', Token.Type.DOT);
        singleTokens.put(';', Token.Type.SEMICOLON);
        
        singleTokens.put('!', Token.Type.LOGICAL_NOT);
        
        singleTokens.put('(', Token.Type.LPAREN);
        singleTokens.put(')', Token.Type.RPAREN);
        singleTokens.put('[', Token.Type.LARRAY);
        singleTokens.put(']', Token.Type.RARRAY);
        singleTokens.put('{', Token.Type.BLKBEG);
        singleTokens.put('}', Token.Type.BLKEND);
    }
    
    public Lexer(InputStream is){
        this.is = is;
    }
    
    public List<Token> getTokens(){
        return list;
    }
    
    public boolean isParsed(){
        return list!=null;
    }
    
    public void parse() throws IOException, LexerException{
        parse(-1);
    }
    
    public void parse(int max) throws IOException, LexerException{
        if(list!=null){
            return; //Already parsed
        }
        
        list = new ArrayList<Token>();
        
        int size = max;
        if(max<0){
            size = is.available();
        }
        final byte[] stream = new byte[size];
        int rSize = is.read(stream, 0, size);
        
        file = new String(stream);
        
        int curPos = 0;
        while(curPos<rSize){
            int out;
            final String content = file.substring(curPos);
            final char cChar = file.charAt(curPos);
            if((out = parseWordsAndKeywords(file, content, curPos, rSize)) != -1){
                curPos += out;
                continue;
            }
            if(isWhiteSpace(cChar)){
                curPos++;
                continue;
            }
            if(isLineBreak(cChar)){
                curPos++;
                currentLine++;
                if(curPos<rSize-1){
                    if(isLineBreak(file.charAt(curPos+1))){
                        //Watch for \r\n
                        curPos++;
                    }
                }
                continue;
            }
            if(cChar=='/'){
                if((out = parseComments(file, content, curPos, rSize)) != -1){
                    curPos += out;
                    continue;
                }
            }
            if((out = parseTokens(file, content, cChar, curPos, rSize)) != -1){
                curPos += out;
                continue;
            }
            if(cChar=='\''){
                if((out = parseCharConstant(file, content, curPos, rSize)) != -1){
                    curPos += out;
                    continue;
                }
            }
            if((out = parseIntegerConstant(file, content, cChar, curPos, rSize)) != -1){
                curPos += out;
                continue;
            }
            //TODO: Float numbers
            if((out = parseStringConstant(file, content, curPos, rSize)) != -1){
                curPos += out;
                continue;
            }
            for(Token t : getTokens()){
                System.out.println(t.toString());
            }
            throw new LexerException("Could not match for input " + content);
        }
    }
    
    private int parseIntegerConstant(String file, String subset, char cChar, int curPos, int size)
    throws LexerException{
        if(!isDigit(cChar)){
            return -1;
        }
        //TODO: Negative constants
        final Token t = new Token(currentLine);
        t.type = Token.Type.INTCONST;
        
        if(cChar=='0'){
            //Handle octal, hexadecimal and simple '0'
            if(curPos==size-1){ //Is last character
                t.text = "0";
                list.add(t);
                return 1;
            }
            char nChar = subset.charAt(1);
            if(nChar=='x'||nChar=='X'){
                //Hexadecimal
                if(size-curPos==1){
                    throw new LexerException("Unexpected end of file");
                }
                t.text = "0x";
                int i = 2;
                nChar = subset.charAt(2);
                if(!isHexDigit(nChar)){
                    throw new LexerException("Expected hexadecimal digit, but obtained " + nChar);
                }
                for(; i < size-curPos; i++){
                    nChar = subset.charAt(i);
                    if(!isHexDigit(nChar)){
                        list.add(t);
                        return i;
                    }
                    t.text += nChar;
                }
                list.add(t);
                return i;
            }
            else if(!isDigit(nChar)){
                t.text = "0";
                list.add(t);
                return 1;
            }
            else if(isOctalDigit(nChar)){
                t.text = "0" + nChar;
                int i = 2;
                while(i < size-curPos){
                    nChar = subset.charAt(i);
                    if(isOctalDigit(nChar)){
                        t.text += nChar;
                    }
                    else{
                        break;
                    }
                    i++;
                }
                list.add(t);
                return i;
            }
            else if(nChar=='.'){
                if(curPos==size-2){
                    nChar = subset.charAt(2);
                    if(nChar=='.'){ //range
                        t.text = "0";
                        list.add(t);
                        return 1;
                    }
                    else if(isDigit(nChar)){
                        //float
                        return -1;
                    }
                    else{
                        //int function
                        t.text = "0";
                        list.add(t);
                        return 1;
                    }
                }
                else{
                    throw new LexerException("Unexpected end of file."); //Not expecting this
                    //should have at least one char after '.'
                }
            }
            else{
                throw new LexerException("Invalid octal constant");
            }
        }
        else if(isNonZeroDigit(cChar)){
            t.text = "" + cChar;
            for(int i = 1; i < size-curPos; i++){
                cChar = subset.charAt(i);
                if(cChar=='.'){
                    if(i==size-curPos-1){
                        throw new LexerException("Unexpected end of file.");
                    }
                    cChar = subset.charAt(i+1);
                    if(isDigit(cChar)){
                        //floating number
                        return -1; //Not handled here
                    }
                     //range or function
                    list.add(t);
                    return i;
                }
                if(!isDigit(cChar)){
                    list.add(t);
                    return i;
                }
            }
            list.add(t);
            return size-curPos;
        }
        
        return -1;
    }
    
    private int parseCharConstant(String file, String subset, int curPos, int size)
    throws LexerException{
        char cChar = subset.charAt(0);
        if(cChar!='\'') return -1;
        Token t = new Token(currentLine);
        t.type = Token.Type.CHARCONST;
        t.text = "";
        for(int i = 1; curPos+i<size; i++){
            char chrAt = subset.charAt(i);
            if(isLineBreak(chrAt)){
                throw new LexerException("Invalid char constant");
            }
            if(chrAt=='\''){
                list.add(t);
                return i+1;
            }
            if(!t.text.isEmpty()){ //'ab' is invalid
                throw new LexerException("Invalid char constant");
            }
            if(chrAt!='\\'){
                t.text += chrAt;
                continue;
            }
            //handling \?
            i++;
            chrAt = subset.charAt(i);
            if(chrAt=='n'){
                t.text += '\n';
                continue;
            }
            if(chrAt=='r'){
                t.text += '\r';
                continue;
            }
            if(chrAt=='t'){
                t.text += '\t';
                continue;
            }
            if(chrAt=='f'){
                t.text += '\f';
                continue;
            }
            if(chrAt=='\\'){
                t.text += '\\';
                continue;
            }
            if(!isDigit(chrAt)||chrAt>='8'){ //Not digit or not octal
                throw new LexerException("Invalid escape sequence");
            }
            //TODO: Handle \032
            throw new LexerException("Invalid char constant");
        }
        throw new LexerException("Invalid char constant");
    }
    
    private int parseStringConstant(String file, String subset, int curPos, int size)
    throws LexerException{
        char cChar = subset.charAt(0);
        if(cChar=='"'){
            return parseCommonStringConstant(file, subset, curPos, size);
        }
        if(cChar=='@'&&curPos+1<size&&subset.charAt(1)=='"'){
            return parseCSharpStringConstant(file, subset, curPos, size);
        }
        return -1;
    }
    
    private int parseCSharpStringConstant(String file, String subset, int curPos, int size)
    throws LexerException{
        Token t = new Token(currentLine);
        t.type = Token.Type.STRINGCONST;
        t.text = "";
        
        for(int i = 2; curPos+i<size; i++){
            char chrAt = subset.charAt(i);
            if(chrAt=='"'){
                if(curPos+i==size-1){
                    list.add(t);
                    return i+1;
                }
                chrAt = subset.charAt(++i);
                if(chrAt=='"'){
                    t.text += '"';
                    continue;
                }
                else{
                    list.add(t);
                    return i; //Not +1 because we already incremented i before
                }
            }
            t.text += chrAt;
        }
        
        throw new LexerException("Invalid string constant");
    }
    
    private int parseCommonStringConstant(String file, String subset, int curPos, int size)
    throws LexerException{
        Token t = new Token(currentLine);
        t.type = Token.Type.STRINGCONST;
        t.text = "";
        for(int i = 1; curPos+i<size; i++){
            char chrAt = subset.charAt(i);
            if(isLineBreak(chrAt)){
                throw new LexerException("Invalid string constant");
            }
            if(chrAt=='"'){
                list.add(t);
                return i+1;
            }
            if(chrAt!='\\'){
                t.text += chrAt;
                continue;
            }
            //handling \?
            i++;
            chrAt = subset.charAt(i);
            if(chrAt=='n'){
                t.text += '\n';
                continue;
            }
            if(chrAt=='r'){
                t.text += '\r';
                continue;
            }
            if(chrAt=='t'){
                t.text += '\t';
                continue;
            }
            if(chrAt=='f'){
                t.text += '\f';
                continue;
            }
            if(chrAt=='\\'){
                t.text += '\\';
                continue;
            }
            if(!isDigit(chrAt)||chrAt>='8'){
                throw new LexerException("Invalid escape sequence");
            }
            //TODO: Match stuff like '\130' and '\300' (octal up to 300)
            throw new LexerException("Invalid string constant");
        }
        throw new LexerException("Invalid string constant");
    }
    
    private int parseWordsAndKeywords(String file, String subset, int curPos, int size){
        int i = 0;
        char c = subset.charAt(i++);
        if(!isAlpha(c)){
            return -1;
        }
        String word = "" + c;
        while(i++<size-curPos&&isAlphanumeric(c = subset.charAt(i-1))){
            word += c;
        }
        Token t = new Token(currentLine);
        t.text = word;
        if(keywords.containsKey(word)){
            t.type = keywords.get(word);
        }
        else{
            t.type = Token.Type.WORD;
        }
        list.add(t);
        return i-1;
    }
    
    private int parseComments(String file, String subset, int curPos, int size)
    throws LexerException{
        final char sChar = subset.charAt(1);
        if(sChar=='/'){
            int i;
            //i=2 because 0 and 1 are both '/'
            for(i = 2; i < size - curPos; i++){
                if(isLineBreak(subset.charAt(i))){
                    break;
                }
            }
            return i; //To end or to line break
        }
        if(sChar=='*'){
            int i;
            //i=2 because 0 and 1 are "/*"
            for(i = 2; i < size - curPos - 1; i++){
                if(subset.charAt(i)=='*'&&subset.charAt(i+1)=='/'){
                    break;
                }
                if(subset.charAt(i)=='\n'&&subset.charAt(i-1)!='\r'){
                    currentLine++;
                }
                if(subset.charAt(i)=='\r'){
                    currentLine++;
                }
            }
            if(i==size - curPos - 1){
                throw new LexerException("Unclosed block comment");
            }
            return i+2; //To end or to line break
        }
        //TODO: Nested comments
        return -1;
    }
    
    private int parseTokens(String file, String subset, char chr, int curPos, int size){
        if(curPos+2<size){
            String slice = subset.substring(0, 3);
            if(threeCharTokens.containsKey(slice)){
                Token t = new Token(currentLine);
                t.text = slice;
                t.type = threeCharTokens.get(slice);
                list.add(t);
                return 3;
            }
        }
        if(curPos+1<size){
            String slice = subset.substring(0, 2);
            if(twoCharTokens.containsKey(slice)){
                Token t = new Token(currentLine);
                t.text = slice;
                t.type = twoCharTokens.get(slice);
                list.add(t);
                return 2;
            }
        }
        if(singleTokens.containsKey(chr)){
            Token t = new Token(currentLine);
            t.text = "" + chr;
            t.type = singleTokens.get(chr);
            list.add(t);
            return 1;
        }
        return -1;
    }
    
    public static boolean isWhiteSpace(char chr){
        return chr==' '||chr=='\t'||chr=='\f';
    }
    
    public static boolean isLineBreak(char chr){
        return chr=='\n'||chr=='\r';
    }
    
    public static boolean isAlphanumeric(char chr){
        return isAlpha(chr)||isDigit(chr);
    }
    
    public static boolean isAlpha(char chr){
        return chr=='_'||(chr>='a'&&chr<='z')||(chr>='A'&&chr<='Z');
    }
    
    public static boolean isDigit(char chr){
        return chr=='0'||isNonZeroDigit(chr);
    }
    
    public static boolean isNonZeroDigit(char chr){
        return chr>='1'&&chr<='9';
    }
    
    public static boolean isHexDigit(char chr){
        return isDigit(chr)||(chr>='a'&&chr<='f')||(chr>='A'&&chr<='F');
    }
    
    public static boolean isOctalDigit(char chr){
        return isDigit(chr)&&chr<='7';
    }
}
