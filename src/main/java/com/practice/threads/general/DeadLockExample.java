package com.practice.threads.general;

public class DeadLockExample 
{
	String o1 = "Lock";
	String o2 = "Step";
	
	Thread t1 = new Thread("Printer 1")
	{
		public void run()
		{
			while(true)
			{
				synchronized(o1)
				{
					synchronized(o2)
					{
						System.out.println(o1+o2);
					}
				}
			} 
		}
	};
	
	Thread t2 = new Thread("Printer 2")
	{
		public void run()
		{
			while(true)
			{
				synchronized(o2)
				{
					synchronized(o1)
					{
						System.out.println(o2+o1);
					}
				}
			}
		}
	};
	
	public static void main(String args[])
	{
		DeadLockExample dLock = new DeadLockExample();
		dLock.t2.start();
		dLock.t1.start();
		
	}
}
