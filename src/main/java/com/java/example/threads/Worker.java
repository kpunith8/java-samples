package com.java.example.threads;

import java.util.Timer;
import java.util.TimerTask;

public class Worker extends Thread
{
    private Object lock = new Object();
    private volatile boolean quittingTime = false;

    @Override
    public void run()
    {
        while (!quittingTime)
        {
            working();
            System.out.println("Still working...");
        }

        System.out.println("Coffee is good!");
    }

    private static void working()
    {
        try
        {
            Thread.sleep(300);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    synchronized void quit() throws InterruptedException
    {
        synchronized (lock)
        {
            quittingTime = true;
            System.out.println("Calling join");
            join();
            System.out.println("Back from join");
        }
    }

    // This should not be called before quit() is called
    // To fix the issue, add synchronize(lock) block for quit() and keepWorking()
    synchronized void keepWorking()
    {
        synchronized (lock)
        {
            quittingTime = false;
            System.out.println("Keep working...");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        final Worker worker = new Worker();
        worker.start();

        Timer timer = new Timer(true); // daemon thread

        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                worker.keepWorking(); // It makes thread to go infinite loop, because of race-condition
            }
        }, 500);

        Thread.sleep(400);

        worker.quit();
    }
}
