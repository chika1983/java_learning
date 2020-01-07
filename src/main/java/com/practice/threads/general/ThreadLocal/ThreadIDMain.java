package com.practice.threads.general.ThreadLocal;

public class ThreadIDMain extends Object implements Runnable
{
	private ThreadID var;
	
	public ThreadIDMain(ThreadID var)
	{
		this.var = var; 
	}

	public void run()
	{
		try
		{
			System.out.println(" Var . getThreadID()= " + var.getThreadID());
			Thread.sleep(2000);
			System.out.println(" Var . getThreadID()= " + var.getThreadID());
					
		}
		catch(InterruptedException ie)
		{
			
		}
	}
	
	private static void print(String msg) 
	{
		String name = Thread.currentThread().getName();
		System.out.println("Name : " + name + " : "  + msg);
	}
	
	public static void main(String args[])
	{
		ThreadID tid = new ThreadID();
		ThreadIDMain shared = new ThreadIDMain(tid);
		
		try {
			 	Thread threadA = new Thread(shared, "threadA");
			 	threadA.start();
			
			 	Thread.sleep(500);
			
			 	Thread threadB = new Thread(shared, "threadB");
			 	threadB.start();
			
			 	Thread.sleep(500);
			
			 	Thread threadC = new Thread(shared, "threadC");
			 	threadC.start();
			}
			catch ( InterruptedException x ) 
			{
				
			}
			
	}
}
