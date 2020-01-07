package com.practice.threads.taming.asynch;

public class BossSideKick implements Runnable
{
	Thread t;
	String name;
	
	private BossOrig batman;
	
	
	BossSideKick(String threadname)
	{
		name = threadname;
		t = new Thread(this,name);
		System.out.println("Child Thread : " + t);
		t.start();
	} 
	
	public synchronized void setBoss(BossOrig bo)
	{
		batman = bo;
		
	}
	public synchronized void getInCar()
	{
		System.out.println("Sent to us by Batman Inside getInCar method");
	}
	
	public synchronized void sockBamPow()  // sent from outside
	{
		batman.holdOn();
	}
	
	public synchronized void holdOn()
	{
		System.out.println("Sent to us by Robin Inside holdOn method");
	}
	
	public void run()
	{
		try
		{
			for(int i=5; i>0; i--)
			{
				System.out.println(name + " : " + i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
