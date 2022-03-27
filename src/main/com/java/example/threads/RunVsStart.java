package main.com.java.example.threads;

/**
 * Java Program to demonstrate the difference between run() vs start(), when you directly call the run(), code inside
 * the run() method will be executed in the calling thread, but when you call the start() method then a new thread will
 * be created to execute the code written inside run() method.
 * 
 * @author Punith K
 */
public class RunVsStart
{
    public static void main(String[] args)
    {
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                System.out.println(Thread.currentThread().getName() + " has executed the run() method");
            }
        };

        System.out.println(Thread.currentThread().getName() + " calling the start() method of Thread");

        thread.start();

        // let's wait until the thread completes execution
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " calling the run() method of Thread");

        // It never created a thread in thread pool just runs in the main thread
        thread.run();

        // run() can be called multiple times, but thread cannot be started multiple times but can be paused
        // starting the thread for the second time ends up in IllegalStateException
        thread.run();
    }
}
