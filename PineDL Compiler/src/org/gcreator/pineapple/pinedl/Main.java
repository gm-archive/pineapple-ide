/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl;

import java.io.InputStream;

/**
 *
 * @author luis
 */
public final class Main {

    public static final String file = "script_3.pdl";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Lexer l = null;
        l = runLexer();
        Parser p = new Parser(l.getTokens(), new Library());
        try{
            p.parse();
        }
        catch(ParserException e){
            e.printStackTrace();
        }
        System.out.println("Took " + (System.currentTimeMillis() - start));
        //System.out.println(p.getDocumentNode());
        /*List<Token> tokens = l.getTokens();
        for(int i = 0; i < tokens.size(); i++){
            System.out.println("["+i+"] " + tokens.get(i));
        }*/
    }
    
    public static Lexer runLexer(){
        try{
            InputStream is = Main.class.getResourceAsStream("/"+file);
            Lexer l = new Lexer(is);
            l.parse();
            //for(Token t : l.getTokens()){
            //    System.out.println(t.toString());
            //}
            return l;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
