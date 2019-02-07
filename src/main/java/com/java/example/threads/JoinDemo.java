package com.java.example.threads;

/**
 * <p>
 * Simple Java Program to show how to execute threads in a particular order. You can enforce ordering or execution
 * sequence using Thread.join() method in Java.
 * </p>
 * 
 * @author Punith K
 */
public class JoinDemo
{
    private static class ParallelTask implements Runnable
    {
        private Thread predecessor;

        @Override
        public void run()
        {
            System.out.println(Thread.currentThread().getName() + " started");

            if (predecessor != null)
            {
                try
                {
                    predecessor.join();
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " finished");
        }

        public void setPredecessor(Thread thread)
        {
            this.predecessor = thread;
        }
    }

    public static void main(String[] args)
    {
        // we have three threads and we need to run in the
        // order T1, T2 and T3 i.e. T1 should start first
        // and T3 should start last.
        // You can enforce this ordering using join() method
        // but join method must be called from run() method
        // because the thread which will execute run() method
        // will wait for thread on which join is called.

        ParallelTask task1 = new ParallelTask();
        ParallelTask task2 = new ParallelTask();
        ParallelTask task3 = new ParallelTask();

        Thread t1 = new Thread(task1, "T1");
        Thread t2 = new Thread(task2, "T2");
        Thread t3 = new Thread(task3, "T3");

        task2.setPredecessor(t1);
        // task3.setPredecessor(t1); // set task3's predecessor as t1 to wait for t1 to complete
        task3.setPredecessor(t2);

        // start all the threads
        t1.start();
        t2.start();
        t3.start();
    }
}
