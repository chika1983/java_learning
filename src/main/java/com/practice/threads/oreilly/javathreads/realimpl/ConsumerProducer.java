package com.practice.threads.oreilly.javathreads.realimpl;

public class ConsumerProducer 
{
	private int count;
	
	public synchronized void consume()
	{
		while(count == 0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ie)
			{
				
			}
		}
		count --;
	}
	
	private synchronized void produce()
	{
		count++;
		notify();
	}

}
