package com.practice.threads.concurrency;

public class MyDaemon implements Runnable 
{
	Thread thrd;
	
	MyDaemon()
	{
		thrd = new Thread(this);
		thrd.setDaemon(true);
		
		thrd.start();
	}
	
	public void run() 
	{
	    try 
	    {
		   for(;;) 
		   {
		        System.out.print(".");
		        Thread.sleep(1000);
		   }
		}
		catch(InterruptedException exc) 
		{
		      System.out.println("MyDaemon interrupted.");
		}
	}
	


}
