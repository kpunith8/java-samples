package com.java.example.threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {
	public static void main(String[] args) throws InterruptedException {
		Runner1 runner = new Runner1();

		Runnable r1 = () -> {
			try {
				runner.firstThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		Runnable r2 = () -> {
			try {
				runner.secondThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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

class Account {
	private int balance = 10000;

	public void deposit(int amount) {
		balance += amount;
	}

	public void withDraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

	public static void transfer(Account acc1, Account acc2, int amount) {
		acc1.withDraw(amount);
		acc2.deposit(amount);
	}
}

class Runner1 {
	Account acc1 = new Account();
	Account acc2 = new Account();

	// One must use the same order of locking mechanism to resolve the deadlock or
	// use tryLock() from ReentrantLock class
	private static void acquireLocks(Lock lock1, Lock lock2) throws InterruptedException {
		while (true) {
			// acquire locks
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;

			try {
				gotFirstLock = lock1.tryLock();
				gotSecondLock = lock2.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) {
					return;
				}
				if (gotFirstLock) {
					lock1.unlock();
				}

				if (gotSecondLock) {
					lock2.unlock();
				}
			}

			// Locks not acquired
			Thread.sleep(1);
		}
	}

	// Run the code without locks to see the results (They always vary)
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public void firstThread() throws InterruptedException {
		Random random = new Random();

		for (int i = 0; i < 10000; i++) {
			acquireLocks(lock1, lock2);

			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() throws InterruptedException {
		Random random = new Random();

		for (int i = 0; i < 10000; i++) {
			// Change the order of lock in this method to see the deadlock, since lock1 is
			// already held the lock in firstThread
			// trying to acquire the same lock in secondThread will cause the deadlock
			
			// lock1.lock();
			// lock2.lock();
			
			// This method allows acquiring the locks in any order
			acquireLocks(lock2, lock1);

			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Acc-1 Balance: " + acc1.getBalance());
		System.out.println("Acc-2 Balance: " + acc2.getBalance());
		System.out.println("Total Balance: " + (acc1.getBalance() + acc2.getBalance()));
	}
}