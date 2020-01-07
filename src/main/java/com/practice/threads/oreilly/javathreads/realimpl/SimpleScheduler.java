package com.practice.threads.oreilly.javathreads.realimpl;

public class SimpleScheduler extends Thread
{
	int timeslice;
	
	public SimpleScheduler(int t)
	{
		this.timeslice = t;
		setPriority(Thread.MAX_PRIORITY);
		setDaemon(true);
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				sleep(timeslice);
			}
			catch(InterruptedException ie)
			{
				
			}
		}
	}
	

}
