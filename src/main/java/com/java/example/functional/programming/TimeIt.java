package com.java.example.functional.programming;

/**
 * <p>
 * Class to measure the time taken to execute block of code.
 * </p>
 * 
 * @author Punith K
 */
public class TimeIt
{
    public static void code(Runnable block)
    {
        long start = System.nanoTime();

        try
        {
            block.run();
        }
        finally
        {
            long end = System.nanoTime();
            System.out.println("Time taken(seconds): " + (end - start) / 1.0e9);
        }
    }
}
