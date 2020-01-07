package com.practice.threads.concurrency;

public class MyThread1 implements Runnable 
{
	SyncOb sob;
	
	public MyThread1(String name, SyncOb so)
	{
		sob = so;
		new Thread(this,name).start();
		
	}

	public void run() 
	{
		// TODO Auto-generated method stub
		sob.waitFor();

	}

}
