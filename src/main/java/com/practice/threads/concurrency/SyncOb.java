package com.practice.threads.concurrency;

public class SyncOb 
{
	boolean ready = false;
	
	synchronized void waitFor()
	{
		String threadName = Thread.currentThread().getName();
		
		System.out.println(threadName + " is entering waitFor().");

	    System.out.println(threadName +
	                       " calling wait() to wait for" +
	                       " notification to proceed.\n");
	    
	    try
	    {
	    	while(!ready)
	    		wait();
	    }
	    catch(InterruptedException ie)
	    {
	    	System.out.println("Interrupt Occurred");
	    	ie.printStackTrace();
	    }
		
	}
	
	synchronized void goAhead()
	{
		String threadName = Thread.currentThread().getName();
		System.out.println("\n" + threadName +
                " thread calling notify() inside goAhead().\n" +
                "This will let MyThread resume execution.\n");
		// Set ready and notify.
		
		ready = true;
	    notify();
	    
		
	}

}
