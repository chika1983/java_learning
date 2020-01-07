package com.practice.threads.taming.asynch;

public class BlackholeANotThreadSafe implements BlackholeInterface
{
	BlackholeANotThreadSafe()
	{
		
	}
	
	final synchronized void foo(BlackholeBNotThreadSafe B)
	{
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered A.foo");
		
		try
		{
			Thread.sleep(1000);
			System.out.println(name + " trying to call B.last()");
		
			notify();
			
		}
		
		catch(Exception e)
		{
			System.out.println(" A Interrupted");
		}
		
		B.last();
	}
	
	synchronized void last()
	{
		System.out.println(" Inside A.last");
	}
	
	public Object message()
	{
		return this;
	}
	
}
