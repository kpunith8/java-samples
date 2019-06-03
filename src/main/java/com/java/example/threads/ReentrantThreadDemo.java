package com.java.example.threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Runner runner = new Runner();

		Runnable r1 = () -> {
			try {
				runner.firstThread();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable r2 = () -> {
			try {
				runner.secondThread();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		runner.finished();
	}
}

class Runner {
	private int count;

	// run the code without the ReentrantLock to see the different result
	// can also be solved using the synchronized block of code using the same lock
	private Lock lock = new ReentrantLock();
	
	// wait and notify can be applied onto ReentrantLocks using the Condition
	private Condition conditon = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();

		System.out.println("Waiting...");
		conditon.await(); // Waits for other thread to signal this
		System.out.println("Woken up!!!");

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("resource")
	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();

		System.out.println("Enter the return key:");
		 new Scanner(System.in).nextLine();
		conditon.signal();

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}