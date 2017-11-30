import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coralieboucheron
 */
public class Main {
    
    
    /**
     * Main method to introduce and benchmark various types of memory leaks.
     * Benchmarking done with JVM heap size of 145mb.
     * @param args command-line argument
     */
    public static void main(String[] args) {
        /*benchmark(1);
        benchmark(2);
        benchmark(3);
        benchmark(4);*/
        
        LeakyBufferedReader leakyBufferedReader = new LeakyBufferedReader();
        leakyBufferedReader.leak();

        Thread thread = Thread.currentThread();
        try{
            thread.sleep(1000000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    /**
     * Benchmarking method. Takes as argument a flag indicating
     * which leaky example to run.
     * @param code flag indicating which leaky class to instantiate
     */
    private static void benchmark(int code){
        switch (code){
            case 1:
                for(int i = 0; i < 100; i++){
                    LeakyObserver leakyObserver = new LeakyObserver();
                    leakyObserver.leak();
                }
                break;
            case 2:
                for(int i = 0; i < 10; i++){
                    LeakyString leakyString = new LeakyString();
                    leakyString.leakEvenMore();
                    System.out.println("Leaking strings ...");
                }
                break;
            case 3:
                LeakyBufferedReader leakyBufferedReader = new LeakyBufferedReader();
                leakyBufferedReader.leak();
                break;
            case 4:
                for (int i = 0; i < 10000; i++) {
                    LeakyOuterClass parentClass = new LeakyOuterClass();
                    LeakyOuterClass.LeakyInnerClass leakyInnerClass = LeakyOuterClass.LeakyInnerClass.getLeakingInnerClass();
                    System.out.println(leakyInnerClass.toString());
                }
                break;
        }
    }
    
}
