package main.com.java.example.threads;

public class RaceCondition
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable runnable = () -> System.out.println("Running in: " + Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        // Thread thread1 = new Thread(runnable);

        thread.setName("My thread");

        // start() makes a thread to run on new thread
        thread.start();
        // thread1.start();

        // calling run() on a thread, makes thread to run in the main thread
        // don't call run() on a thread if you want to run on different thread
        // thread.run();

        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable longWrapperRunnable = () -> {
            for (int i = 0; i < 1_000; i++)
            {
                longWrapper.incrementByOne();
            }
        };

        LongWrapperNoRaceCondition noRaceConditionLongWrapper = new LongWrapperNoRaceCondition(0L);

        Runnable noRaceConditionRunnable = () -> {
            for (int i = 0; i < 1_000; i++)
            {
                noRaceConditionLongWrapper.incrementByOne();
            }
        };

        // normal execution
        /*
         * Thread longWrapperThread = new Thread(longWrapperRunnable); longWrapperThread.start();
         * 
         * // join() is used to wait for the thread to complete and run the code below after the thread is done
         * executing longWrapperThread.join();
         * 
         * System.out.println("Final value = " + longWrapper.getValue());
         */

        // Create thousand threads and try incrementing in each thread, ends up in race-condition
        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(noRaceConditionRunnable); // replace with longWrapperRunnable for a deadlock
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++)
        {
            threads[i].join();
        }

        // It should produce 1 Million as its output because thousand threads executing thousand times incrementing
        // yields 1M
        // But it produces different value every time code runs, because of race condition
        System.out.println("Value after running the 1000 threads: " + longWrapper.getValue());

        // Race condition can be fixed using class LongWrapperNoRaceCondition
        System.out.println(
                "Value after running the 1000 threads with no race condition: "
                        + noRaceConditionLongWrapper.getValue());
    }
}

class LongWrapper
{
    private long value;

    public LongWrapper(long value)
    {
        this.value = value;
    }

    public long getValue()
    {
        return value;
    }

    public void incrementByOne()
    {
        value += 1;
    }
}

class LongWrapperNoRaceCondition
{
    private long value;
    private final Object key = new Object();

    public LongWrapperNoRaceCondition(long value)
    {
        this.value = value;
    }

    public long getValue()
    {
        return value; // getValue() should be put in a synchronized block to guarantee the read.
    }

    public void incrementByOne()
    {
        synchronized (key)
        {
            value += 1;
        }
    }
}
