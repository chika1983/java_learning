package com.practice.threads.example;

public class JoinThread implements Runnable 
{
	int count;
	
	public JoinThread()
	{
		count = 0;
	}
	
	public void run()
	{
		System.out.println("MyThread starting.");

	    try {
	      do {
	        Thread.sleep(500);
	        System.out.println("In MyThread, count is " + count);
	        count++;
	      } while(count < 6);
	    }
	    catch(InterruptedException exc) {
	      System.out.println("MyThread interrupted.");
	    }

	    System.out.println("MyThread terminating.");

	}

}
