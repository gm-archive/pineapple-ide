/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinec.compiler.generation;

/**
 *
 * @author Luís Reis
 */
public class DefaultBytecodeInstruction implements BytecodeInstruction{
    public int opcode;
    public int arg1;
    public int arg2;
    public int arg3;

    public void storeToBytes(byte[] b, int pos){
        b[pos] = (byte) (opcode<<1);

        //Mask 10000000000 (pick eleventh bit)
        b[pos] = (byte) (b[pos] | (arg1 & 0x400));

        //Mask 01111111100 (pick 8 next bits)
        b[pos+1] = (byte) (arg1 & 0x3FC);

        //Mask 00000000011 (pick last 2 bits)
        b[pos+2] = (byte) ((arg1 & 0x3) << 6);

        //Mask 11111100000 (pick first 6 bits)
        b[pos+2] = (byte) (b[pos+2] | (arg2 & 0x7E0));

        //Mask 00000011111 (pick last 5 bits)
        b[pos+3] = (byte) ((arg2 & 0x1F) << 3);

        //Mask 11100000000 (pick first 5 bits)
        b[pos+3] = (byte) (arg2 | (arg3 & 0x700));

        //Mask 00011111111 (pick last 8 bits)
        b[pos+4] = (byte) (arg3 & 0xFF);
    }
}
