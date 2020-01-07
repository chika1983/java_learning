package com.practice.threads.taming.asynch;

public class BlackholeBNotThreadSafe implements BlackholeInterface
{
	BlackholeBNotThreadSafe()
	{
		
	}
	
	final synchronized void bar(BlackholeANotThreadSafe A)
	{
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered B.bar");
		
		try
		{
			Thread.sleep(1000);
			System.out.println(name + " trying to call A.last()");
		
			wait();
			
		}
		catch(Exception e)
		{
			System.out.println(" B Interrupted");
		}
		A.last();
	}
	
	synchronized void last()
	{
		System.out.println("Inside B.last");
	}
	
	public Object message()
	{
		return  this;
	}
}
