package main.com.java.example.threads;

import java.util.concurrent.TimeUnit;

/**
 * Java Program to demonstrate how to stop a thread in Java. There is a stop() method in Thread class but its deprecated
 * because of deadlock and other issue, but its easy to write your own stop() method to stop a thread in Java.
 * 
 * @author Punith K
 */
public class ThreadStopDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        Server myServer = new Server();

        Thread thread = new Thread(myServer, "T1");
        thread.start();

        // Now, let's stop our Server thread
        System.out.println(Thread.currentThread().getName() + " is stopping Server thread");
        myServer.stop();

        // Let's wait to see server thread stopped
        TimeUnit.MILLISECONDS.sleep(200);

        System.out.println(Thread.currentThread().getName() + " is finished now");
    }
}

class Server implements Runnable
{
    // in the absence of any synchronization instruction e.g. volatile modifier here,
    // the compiler is free to cache the value of boolean variable exit,
    // which means even if the main thread makes it true, Server will always see it false, thus running infinitely.
    private volatile boolean exit = false;

    @Override
    public void run()
    {
        while (!exit)
        {
            try
            {
                // TimeUnit.MILLISECONDS.sleep(1000);
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

            System.out.println("Server is running...");
        }

        System.out.println("Server is stopped...");
    }

    public void stop()
    {
        exit = true;
    }
}