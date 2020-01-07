package com.practice.threads.taming.asynch;

public class ExceptionTest implements Runnable
{

	String name;
	Thread t;
	private boolean some_condition = false;
	
	public ExceptionTest(String threadname)
	{
		name = threadname;
		t = new Thread(this,name);
		t.start();
	}
	
	public void run()
	{	
		if(some_condition)
		{
			//throw new RuntimeException("Hello World!");
			System.out.println("Hello World!");
		}
		
		synchronized(ExceptionTest.this)
		{
			ExceptionTest.this.notify();
		}
			
		
	}
	
	public static void main(String[] args) 
	{
		ExceptionTest test = new ExceptionTest("Exception Thread");
				
		try
		{
			test.test();
			Thread.currentThread().sleep(500);
		}
		catch(InterruptedException ie)
		{
			System.out.println("Main Thread Interrupted");
		}
		System.out.println("Main thread exiting");
		
	}
	
	public synchronized void test() throws InterruptedException
	{
		System.out.println("above");
		some_condition = true;
		wait();
		
		System.out.println("below");
	}

}
