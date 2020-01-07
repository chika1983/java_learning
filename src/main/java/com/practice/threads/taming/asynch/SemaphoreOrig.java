package com.practice.threads.taming.asynch;

public interface SemaphoreOrig 
{
	public static final long FOREVER = Long.MAX_VALUE;
	
	
	int id();
	
	void acquire(long timeout) throws InterruptedException, Timed_out;
	void release();
	
	public static class Timed_out extends java.lang.RuntimeException
	{
		Timed_out()
		{
			super("Timed out while waiting to acquire semaphore");
			System.out.println("Timed Out while waiting to acquire semaphore");
		}

		public Timed_out(String string) 
		{
			super(string);
			System.out.println(string);
		}
	}
	
	public static class Ownership extends RuntimeException
	{
		public Ownership()
		{
			super("Calling Thread doesn't own a semaphore");
		}
	}
	

}
