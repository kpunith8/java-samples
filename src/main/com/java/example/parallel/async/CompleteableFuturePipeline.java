package main.com.java.example.parallel.async;

import java.util.concurrent.CompletableFuture;

public class CompleteableFuturePipeline
{
    public static void main(String[] args)
    {
        CompletableFuture<Integer> future = new CompletableFuture<Integer>();

        future.thenApply(data -> data * 2).thenApply(data -> data + 1).thenAccept(System.out::println);

        System.out.println("Pipeline built");
        
        System.out.println("Prepared to print");

        sleep(1000);

        // until the value passed through complete pipeline won't execute
        future.complete(2);
    }

    public static boolean sleep(int ms)
    {
        try
        {
            Thread.sleep(ms);

            return true;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
