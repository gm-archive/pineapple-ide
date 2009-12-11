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

    public ArchiveOutputter(final OutputStream ostream, final ArchiveSettingsTable table,
            final NameLibrary names){
        this.ostream = ostream;
        this.table = table;
        this.names = names;
    }

    public void output() throws IOException{
        ostream.write(magicNumber);

        writeTable();
        writeNameTable();
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

    private void writeUnsignedInt16(short value) throws IOException{
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

    private void writeUnicodeString(String value) throws IOException{
        final byte[] bArray = value.getBytes("UTF-8");

        writeUnsignedInt32(bArray.length); //Byte count, NOT char count
                                //assuming otherwise will corrupt archive.
        ostream.write(bArray);
    }
}
