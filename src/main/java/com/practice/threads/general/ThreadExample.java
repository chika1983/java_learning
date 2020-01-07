package com.practice.threads.general;

public class ThreadExample 
{
	public ThreadExample()
	{
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ThreadExample te = new ThreadExample();
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(te.new XThread(),"thread1");
		Thread thread2 = new Thread(te.new XThread(),"thread2");
		
		Thread thread3 = te.new XThread();
		Thread thread4 = te.new XThread();
		
		Thread thread5 = te.new XThread("thread5");
		
		//Start the threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try
		{
			//The Sleep invoked on the main Thread to cause one second delay
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread());
	}
	
	class XThread extends Thread
	{
		XThread()
		{
			
		}
		
		XThread(String threadname)
		{
			super(threadname);
			System.out.println(this);
			start();
		}
		
		public void run()
		{
			System.out.println("Anand" + Thread.currentThread().getName());
		}
		
		
	}

}
