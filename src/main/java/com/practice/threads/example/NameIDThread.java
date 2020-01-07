package com.practice.threads.example;

public class NameIDThread implements Runnable 
{
	int count;
	Thread thrd;
	
	public NameIDThread(String thrdName)
	{
		count = 0;
		thrd = new Thread(this,thrdName);
		thrd.start();
	}
	
	public void run()
	{
		System.out.println(thrd.getName() + " starting. ");
		try
		{
			do
			{
				Thread.sleep(500);
				 // Display the thread's name, ID, and count.
		        System.out.println("In " + thrd.getName() +
		                           " (ID: " + thrd.getId( ) + ")" +
		                           ", count is " + count);
		        count++;

		        // Change a thread's name.
		        if(count == 3) thrd.setName(thrd.getName().toUpperCase());

			} while(count < 5);
			
		}
		catch(InterruptedException exc) 
		{
		      System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " terminating.");
	}

}
