/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler;

import java.io.InputStream;

/**
 *
 * @author luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Lexer l = null;
        l = run();
        Parser p = new Parser(l.getTokens(), new Library());
        try{
            p.parse();
        }
        catch(ParserException e){
            e.printStackTrace();
        }
        System.out.println("Took: " + (System.currentTimeMillis() - start));
        for(Token t : l.getTokens()){
            //System.out.println(t);
        }
    }
    
    public static Lexer run(){
        try{
            InputStream is = Main.class.getResourceAsStream("/script.pdl");
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
