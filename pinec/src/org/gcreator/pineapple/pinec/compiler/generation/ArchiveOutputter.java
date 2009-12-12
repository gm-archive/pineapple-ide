/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.generation;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Vector;
import org.gcreator.pineapple.pinec.compiler.api.NameLibrary;

/**
 *
 * @author Luís Reis
 */
public class ArchiveOutputter {
    public static final String stringEncoding = "UTF-8";
    public static final byte[] magicNumber = new byte[]{'P','B','A', 0, 0};

    private final OutputStream ostream;
    private final ArchiveSettingsTable table;
    private final NameLibrary names;
    private final Archive archive;

    public ArchiveOutputter(final OutputStream ostream, final ArchiveSettingsTable table,
            final NameLibrary names, final Archive archive){
        this.ostream = ostream;
        this.table = table;
        this.names = names;
        this.archive = archive;
    }

    public void output() throws IOException{
        ostream.write(magicNumber);

        writeTable();
        writeNameTable();
        writeArchive();
    }

    private void writeArchive() throws IOException{
        writeUnsignedInt16(archive.classes.size());
        for(BytecodeClass cls : archive.classes){
            writeClass(cls);
        }

        writeUnsignedInt16(archive.functions.size());
        for(BytecodeFunction function : archive.functions){
            writeFunction(function);
        }
    }

    private void writeNameTable() throws IOException{
        final List<String> nameList = new Vector<String>(names.getInternalNames());

        if(table.outputUserNames){
            nameList.addAll(names.getUserNames());
        }

        writeUnsignedInt32(nameList.size());
        for(final String name : nameList){
            writeUnicodeString(name);
        }
    }

    private void writeTable() throws IOException{
        int length = table.intValues.size();
        writeUnsignedInt32(length);
        for(String key : table.intValues.keySet()){
            writeUnicodeString(key);

            writeSignedInt32(table.intValues.get(key));
        }

        length = table.stringValues.size();
        writeUnsignedInt32(length);

        for(String key : table.stringValues.keySet()){
            writeUnicodeString(key);

            writeUnicodeString(table.stringValues.get(key));
        }

        length = table.listedValues.size();
        writeUnsignedInt32(length);
        for(String key : table.listedValues.keySet()){
            writeUnicodeString(key);

            List<String> values = table.listedValues.get(key);
            writeUnsignedInt32(values.size());
            for(String value : values){
                writeUnicodeString(value);
            }
        }
    }

    private void writeFunction(BytecodeFunction function) throws IOException{
        //Write constant table
        writeUnsignedInt32(function.charConstants.size());
        for(Character c : function.charConstants){
            writeUnicodeChar(c);
        }

        writeUnsignedInt32(function.floatConstants.size());
        for(Float f : function.floatConstants){
            writeFloat(f);
        }

        writeUnsignedInt32(function.stringConstants.size());
        for(String s : function.stringConstants){
            writeUnicodeString(s);
        }

        writeUnsignedInt16(function.varNumber);

        List<BytecodeInstruction> instructions = function.instructions;
        int iCount = instructions.size();
        if(iCount>0xFFFF){
            throw new IOException("Too many instructions in function");
        }

        writeUnsignedInt32(iCount);
        byte[] b = new byte[iCount*5];
        int pos = 0;
        for(BytecodeInstruction instr : function.instructions){
            instr.storeToBytes(b, pos);
            pos += 5;
        }

        ostream.write(b);
    }

    private void writeClass(BytecodeClass cls) throws IOException{
        writeUnsignedInt16(cls.base.size());

        for(Integer i : cls.base){
            writeUnsignedInt16(i);
        }

        writeUnsignedInt16(cls.creatorFunction);
        writeUnsignedInt16(cls.constructorFunction);
        writeUnsignedInt16(cls.fields.size());

        for(Integer i : cls.fields){
            writeUnsignedInt16(i);
        }
    }

    private void writeFloat(Float value) throws IOException{
        writeSignedInt32(Float.floatToRawIntBits(value));
    }

    private void writeUnsignedInt16(int value) throws IOException{
        final byte[] bArray = new byte[]{
            (byte) (value >> 8),
            (byte) value
        };

        ostream.write(bArray);
    }

    private void writeUnsignedInt32(int value) throws IOException{
        final byte[] bArray = new byte[]{
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        };

        ostream.write(bArray);
    }

    private void writeSignedInt32(int value) throws IOException{
        byte[] bArray;
        if(value<0){
            bArray = new byte[]{
                (byte) (value >> 24),
                (byte) (value >> 16),
                (byte) (value >> 8),
                (byte) value
            };
        }
        else{
            int abs = -value;
            bArray = new byte[]{
                (byte) ~(abs >> 24),
                (byte) ~(abs >> 16),
                (byte) ~(abs >> 8),
                (byte) ~abs
            };
        }

        ostream.write(bArray);
    }

    private void writeUnicodeChar(Character value) throws IOException{
        final byte[] bArray = value.toString().getBytes(stringEncoding);

        writeUnsignedInt32(bArray.length);
        ostream.write(bArray);
    }

    private void writeUnicodeString(String value) throws IOException{
        final byte[] bArray = value.getBytes(stringEncoding);

        writeUnsignedInt32(bArray.length); //Byte count, NOT char count
                                //assuming otherwise will corrupt archive.
        ostream.write(bArray);
    }
}
