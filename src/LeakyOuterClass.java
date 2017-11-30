/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coralieboucheron
 */
public class LeakyOuterClass {
    private static final byte[] memoryChunk = new byte[1000000];

    public LeakyOuterClass(){
        System.out.println(memoryChunk.length);
    }

    /**
     * Getter method for the {@link LeakyInnerClass}
     * @return instance of {@link LeakyInnerClass}
     */
    public static LeakyInnerClass getInnerLeakingClass(){
        return new LeakyInnerClass();
    }

    /**
     * static inner class holding the reference to its parent class
     */
    public static class LeakyInnerClass{
        public LeakyInnerClass(){}

        /**
         * Getter method that references the parent {@link LeakyOuterClass} class
         * @return {@link LeakyInnerClass} instance
         */
        public static LeakyInnerClass getLeakingInnerClass(){
            LeakyOuterClass parentClass = new LeakyOuterClass();
            return parentClass.getInnerLeakingClass();
        }
    }
    
}
