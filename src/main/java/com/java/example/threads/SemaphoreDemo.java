package com.java.example.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		
		semaphore.release(); // adds one semaphore
		semaphore.acquire(); // acquires one semaphore and reduces by one
		
		System.out.println("Available permits: " + semaphore.availablePermits());
	}
}
