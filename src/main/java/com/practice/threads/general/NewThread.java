package com.practice.threads.general;

public class NewThread implements Runnable
{
	String name;
	Thread t;
	
	NewThread(String threadname)
	{
		name=threadname;
		t = new Thread(this,name);
		System.out.println("Child Thread " + t);
		t.start();
	}
	
	public void run()
	{
		 try 
		 {
		      for (int i = 5; i > 0; i--) 
		      {
		        System.out.println(name + ": " + i);
		        Thread.sleep(1000);
		      }
		 }
		 catch (InterruptedException e) 
		 {
		      System.out.println(name + " interrupted.");
		 }
		    System.out.println(name + " exiting.");
	}
	
	public static void main(String args[])
	{
		NewThread ob1 = new NewThread("One");
		NewThread ob2 = new NewThread("Two");
		NewThread ob3 = new NewThread("Three");
		
		Thread[] ta = new Thread[Thread.activeCount()];
		int n = Thread.enumerate(ta);
		for(int i=0; i<n; i++)
		{
			System.out.println("Thread is : " + i + " is " + ta[i].getName());
		}
		
	}
}
