package com.practice.threads.concurrency;

import java.util.concurrent.Semaphore;


public class SemaphoreTest 
{
	public static void main(String args[]) throws InterruptedException
	{
		Semaphore sem = new Semaphore(1,true);
		
		Thread thrdA = new Thread(new SyncOut(sem, "Message 1"));
	    Thread thrdB = new Thread(new SyncOut(sem, "Message 2!"));

	    thrdA.start();
	    thrdB.start();

	    thrdA.join();
	    thrdB.join();
	}

}
