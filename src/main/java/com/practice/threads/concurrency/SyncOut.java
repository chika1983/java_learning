package com.practice.threads.concurrency;

import java.util.concurrent.Semaphore;

public class SyncOut implements Runnable 
{
	Semaphore sem;
	String msg;

	public SyncOut(Semaphore sem, String m)
	{
		this.sem = sem;
		this.msg = m;
	}
	
	public void run() 
	{
		try
		{
			sem.acquire();
			System.out.println(msg);
			Thread.sleep(10);
			
		}
		catch(InterruptedException ie)
		{
			System.out.println("Error writing o/p");
			ie.printStackTrace();
		}
	}

}
