package main.com.java.example.parallel.async;

import java.util.concurrent.CompletableFuture;

public class CompleteableFutureSample
{
    public static CompletableFuture<Integer> create()
    {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private static int compute()
    {
        System.out.println("In compute() -- " + Thread.currentThread());

        sleep(1000);
        return 2;
    }

    public static void main(String[] args)
    {
        System.out.println("In main() -- " + Thread.currentThread());

        CompletableFuture<Integer> future = create().thenApply(data -> data * 10);

        sleep(100);

        // If the future is not resolved main thread is not blocked to execute, it
        // prints Here, before it waits on compute to finish (check there is a wait of 1s to complete)
        System.out.println(future.thenAccept(data -> printIt(data)));

        System.out.println("Here");

        // After the future resolved after a 1s of delay in compute method it prints the value
        sleep(1000);
    }

    private static void printIt(Integer data)
    {
        System.out.println("In printIt() -- " + Thread.currentThread());
        System.out.println(data);
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
