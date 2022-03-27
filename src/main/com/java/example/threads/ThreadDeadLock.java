package main.com.java.example.threads;

public class ThreadDeadLock
{
    public static void main(String[] args) throws InterruptedException
    {
        DeadLockExample deadLockExample = new DeadLockExample();

        Runnable r1 = () -> deadLockExample.methodA();
        Runnable r2 = () -> deadLockExample.methodB();

        // It creates a deadlock because of the key2 is held by methodB to execute methodA's methodB inside it,
        // same with the methodB
        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();
    }
}

class DeadLockExample
{
    private final Object key1 = new Object();
    private final Object key2 = new Object();

    public void methodA()
    {
        synchronized (key1)
        {
            System.out.println(Thread.currentThread().getName() + " in method A");
            methodB();
        }
    }

    public void methodB()
    {
        synchronized (key2)
        {
            System.out.println(Thread.currentThread().getName() + " in method B");
            methodC();
        }
    }

    public void methodC()
    {
        synchronized (key1)
        {
            System.out.println(Thread.currentThread().getName() + " in method C");
            methodC();
        }
    }
}
