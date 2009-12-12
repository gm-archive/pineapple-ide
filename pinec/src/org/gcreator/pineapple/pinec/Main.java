/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;
import org.gcreator.pineapple.pinec.compiler.api.APIClass;
import org.gcreator.pineapple.pinec.compiler.api.APIImporter;
import org.gcreator.pineapple.pinec.compiler.api.CommonLibrary;
import org.gcreator.pineapple.pinec.compiler.api.NameLibrary;
import org.gcreator.pineapple.pinec.compiler.generation.Archive;
import org.gcreator.pineapple.pinec.compiler.generation.ArchiveOutputter;
import org.gcreator.pineapple.pinec.compiler.generation.ArchiveSettingsTable;
import org.gcreator.pineapple.pinec.lexer.Lexer;
import org.gcreator.pineapple.pinec.lexer.LexerHandler;
import org.gcreator.pineapple.pinec.parser.Parser;
import org.gcreator.pineapple.pinec.parser.tree.ClassConstant;
import org.gcreator.pineapple.pinec.parser.tree.Document;

/**
 *
 * @author luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //final double d = testParser();
        //String s = Double.toString(d);
        //s = s.replaceAll("\\.", ",");
        //System.out.println(s);

        try{
            final CommonLibrary lib = new CommonLibrary();
            final APIImporter importer = new APIImporter(lib);
            importer.importLibrary(Main.class.getResourceAsStream("/testapi.xml"));

            final LexerHandler handler = new LexerHandler();
            final InputStream stream = Main.class.getResourceAsStream("/org/gcreator/pineapple/pinec/test.pdl");
            final Reader reader = new BufferedReader(new InputStreamReader(stream));

            final Lexer lexer = new Lexer(reader, handler);
            lexer.run();
            final Parser parser = new Parser(handler);
            final Document d = parser.run();
            importer.importFromDocument(d);
            final NameLibrary names = new NameLibrary(lib);
            final ArchiveSettingsTable table = new ArchiveSettingsTable();
            table.stringValues.put("X-Powered-By", "Official PineDL Compiler");
            table.stringValues.put("X-Version", "0.01");
            final Archive archive = new Archive();

            File f = new File("output.pba");
            OutputStream os = new BufferedOutputStream(new FileOutputStream(f));

            final ArchiveOutputter out = new ArchiveOutputter(os, table, names, archive);
            out.output();

            os.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static double testParser(){
        final LexerHandler handler = new LexerHandler();
        final InputStream stream = Main.class.getResourceAsStream("/org/gcreator/pineapple/pinec/test.pdl");
        final Reader reader = new BufferedReader(new InputStreamReader(stream));
        try{
            final long time = System.nanoTime();

            final Lexer lexer = new Lexer(reader, handler);
            lexer.run();
            final Parser parser = new Parser(handler);
            final Document d = parser.run();

            final long took = System.nanoTime()-time;

            final List<CompilerError> errors = handler.errors;
            if(!errors.isEmpty()){
                System.out.println("At test.pdl:");
            }
            for(final CompilerError error : errors){
                System.out.println("\t"+error.toString());
            }

            for(final ClassConstant cls : d.classes){
                if(cls.behaviorFlag){
                    System.out.print("magic ");
                }
                System.out.println(cls.toString() + "\n");
            }

            double tk = (double) took;
            tk /= 1000;
            tk /= 1000; //milli
            stream.close();
            return tk;
        }
        catch(final IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 9999; //Penalty
    }

}
