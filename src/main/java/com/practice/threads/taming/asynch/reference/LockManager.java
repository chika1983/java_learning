package com.practice.threads.taming.asynch.reference;

import java.util.Arrays;
import java.util.Comparator;

import com.practice.threads.taming.asynch.reference.Semaphore;
import com.practice.threads.taming.asynch.reference.Semaphore.Timed_out;

public class LockManager 
{
	private static Object idLock = new int[]{0};
	
	private static int idPool = 0;
		
	private LockManager()
	{
		
		
	}
	
	public static int newId()
	{
		synchronized(idLock)
		{
			return idPool++;
		}
	}
	
	private static final Comparator compareStrategy = new Comparator()
	{
			public int compare(Object a, Object b)
			{
				return ((Semaphore)a).id() - ((Semaphore)b).id();

			}
			
			public boolean equals(Object obj)
			{
				return obj == this;
			}
	};
	
	public static void acquire_multiple(Semaphore[] locks, long timeout) 
	throws InterruptedException, Timed_out
	{
		acquire(locks,timeout);
	}
	
	private static void acquire(Object[] locks, long timeout) throws
	InterruptedException, Timed_out
	{
		int currLock =0;
		
		try
		{
			long expiration = (timeout == Semaphore.FOREVER) ? Semaphore.FOREVER 
					: System.currentTimeMillis() + timeout;
			
			Arrays.sort(locks, compareStrategy);
			
			for(;currLock < locks.length; ++currLock)
			{
                long timeRemaining = expiration - System.currentTimeMillis();
                
                if( timeRemaining <= 0 ) 
                	throw new Semaphore.Timed_out("Timed out waiting to acquire multiple locks");
                
                ((Semaphore)locks[currLock]).acquire(timeRemaining);

			}
		}
		catch(InterruptedException ie)
		{
			while( --currLock >= 0 )
				                ((Semaphore)locks[currLock]).release();
				            throw ie;

		}
		
		catch(Semaphore.Timed_out se)
		{
			 while( --currLock >= 0 )
				                 ((Semaphore)locks[currLock]).release();
				              throw se;

		}
	}
}

