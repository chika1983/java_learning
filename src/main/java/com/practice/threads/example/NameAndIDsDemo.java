package com.practice.threads.example;

public class NameAndIDsDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Main thread starting.");

	    // Construct and start a thread.
	    NameIDThread mt = new NameIDThread("First Thread");

	    // Construct and start a second thread.
	    NameIDThread mt2 = new NameIDThread("Second Thread");
	    
	    // Give the main thread something to do.
	    do {
	      System.out.println("In main thread.");

	      try {
	        Thread.sleep(250);
	      }
	      catch(InterruptedException exc) {
	        System.out.println("Main thread interrupted.");
	      }

	    // Wait until both threads end.
	    } while (mt.count != 5 && mt2.count != 5);

	    System.out.println("Main thread ending.");



	}

}
