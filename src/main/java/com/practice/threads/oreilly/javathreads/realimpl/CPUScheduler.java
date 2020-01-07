package com.practice.threads.oreilly.javathreads.realimpl;

public class CPUScheduler extends Thread
{
	private int timeslice;
	private CircularList threads;
	Thread current;
	private static boolean initialized = false;
	
	public volatile boolean shouldRun = false; // Exit when this is set
	
	public CPUScheduler(int t) 
	{
		if (isInitialized())
			throw new SecurityException("Already initialized");
		threads = new CircularList();
		timeslice = t;
	}
	
	public void addThread(Thread t) 
	{
		threads.insert(t);
		try
		{
			current.setPriority(2);
		}
		catch(Exception e)
		{
			removeThread(current);
		}
		
	}
	
	public void removeThread(Thread t) 
	{
		try
		{
			current.setPriority(5);
		}
		catch(Exception e)
		{
			
		}
		threads.delete(t);
		synchronized(this) 
		{
			if (current == t)
			current = null;
		}
	}
	
	private synchronized static boolean isInitialized()
	{
		if(initialized)
			return true;
		initialized = true;
		return false;
	}
	
	public void run() 
	{
		setPriority(6);
		
		while (shouldRun) 
		{
			current = (Thread) threads.getNext();
			if (current == null)
				return;
			try
			{
				current.setPriority(4);
			}
			catch(Exception e)
			{
				removeThread(current);
			}
			
			try 
			{
				Thread.sleep(timeslice);
			}
			catch (InterruptedException ie) {};
			
			synchronized(this)
			{
				if(current != null)
					current.setPriority(2);
			}
		}
	}
}

