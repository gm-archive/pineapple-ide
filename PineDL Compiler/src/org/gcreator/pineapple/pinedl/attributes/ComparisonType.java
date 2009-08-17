/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gcreator.pineapple.pinedl.attributes;

/**
 *
 * @author Luís Reis
 */
public class ComparisonType {
    private String chr;
    
    private ComparisonType(String chr){
        this.chr = chr;
    }
    
    @Override
    public String toString(){
        return chr;
    }
    
    public static ComparisonType EQUAL = new ComparisonType("==");
    public static ComparisonType NOT_EQUAL = new ComparisonType("!=");
    public static ComparisonType GREATER = new ComparisonType(">");
    public static ComparisonType LOWER = new ComparisonType("<");
    public static ComparisonType GREATER_EQUAL = new ComparisonType(">=");
    public static ComparisonType LOWER_EQUAL = new ComparisonType("<=");
}
