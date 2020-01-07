package com.practice.threads.general;

class RunnableThreadDemo 
{
	class RunnableThread implements Runnable
	{
		Thread runner;
	
		public RunnableThread()
		{
			
		}
		
		public RunnableThread(String name)
		{
			runner = new Thread(this,name);
			System.out.println("Name of the thread is :" + runner.getName());
			
			runner.start();
		}
		
		public void run()
		{
			System.out.println(Thread.currentThread());
		}
	}
	
	public static void main(String args[])
	{
		RunnableThreadDemo rtd = new RunnableThreadDemo();
		
		Thread t1 = new Thread(rtd.new RunnableThread(),"thread1");
		
		Thread t2 = new Thread(rtd.new RunnableThread(),"thread2");

		RunnableThread t3 = rtd.new RunnableThread("thread3");
		
		t1.start();
		t2.start();
		
		try
		{
			Thread.sleep(1000);
		}
		
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread());
	}
	
}
