/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coralieboucheron
 */
public class LeakyString {
    private final String referenceString;
    private final String substring;
    static String interned;

    /**
     * LeakyString constructor.
     * Creates a string from 0 to 999 and also a substring of it
     * consisting of one letter. The class operates only on the
     * {@link #substring} which holds the reference to the {@link #referenceString}
     */
    public LeakyString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            builder.append(String.valueOf(i));
        }
        this.referenceString = builder.toString();
        this.substring = referenceString.substring(0, 1);
    }

    /**
     * Creates an even worse leak by interning the substring holding
     * the reference to the {@link #referenceString}
     */
    public void leakEvenMore(){
        interned = substring.intern();
    }
    
}
