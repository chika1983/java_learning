package com.practice.threads.taming.asynch.reference;

public interface Semaphore 
{
	public final long FOREVER = Long.MAX_VALUE;
	
	public int id();
	
	public boolean acquire(long timeout) throws InterruptedException , Timed_out;
	
	public void release();
	
	public static final class Timed_out extends RuntimeException
	{
		public Timed_out()
		{
			super("Timed out while waiting to acquire semaphore");
		}
		
		public Timed_out(String s)
		{
			super(s);
		}
	}
	
	public static final class Ownership extends RuntimeException
	{
		public Ownership()
		{
			super("Calling thread doesn't own semaphore");
		}
	}

}
