package com.practice.threads.oreilly.javathreads.realimpl;

public class BusyFlag 
{
	protected Thread busyflag = null;
	protected int busycount = 0;
	
	public synchronized void getBusyFlag() 
	{
		while (tryGetBusyFlag() == false) 
		{
			try 
			{
				wait();
			}
			catch (Exception e) 
			{}
		}
	}
	
	public boolean tryGetBusyFlag() 
	{
		synchronized(this)
		{
			if (busyflag == null) 
			{
				busyflag = Thread.currentThread();
				busycount = 1;
				return true;
			}
			if (busyflag == Thread.currentThread()) 
			{
				busycount++;
				return true;
			}
			
			return false;
		}
	}
	
	public synchronized void freeBusyFlag() 
	{
		if (getBusyFlagOwner() == Thread.currentThread()) 
		{
			busycount--;
			if(busycount == 0)
			{
				busyflag = null;
				notify();
			}
		}
	}
	
	public synchronized Thread getBusyFlagOwner() 
	{
		return busyflag;
	}
	
	
}
