import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coralieboucheron
 */
public class LeakyBufferedReader {
    private String longString;

    /**
     * The constructor.
     * Creates the instance of {@link LeakyBufferedReader}
     * and a new {@link #longString}
     */
    public LeakyBufferedReader(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            builder.append(String.valueOf(i));
        }
        this.longString = builder.toString();
    }

    /**
     * Creates the leak by opening the {@link BufferedReader},
     * but forgetting to close it after the job is done.
     */
    void leak(){
        try{
            BufferedReader reader = new BufferedReader(new StringReader(longString));
            int line = 0;
            for (String x = reader.readLine(); x != null; x = reader.readLine())
            {
                if(line % 2 == 0) System.out.println("The string is: ".concat(x));
                line++;
            }
        }catch(IOException io){
            io.printStackTrace();
        }
    }
    
}
