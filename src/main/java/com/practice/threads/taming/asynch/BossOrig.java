package com.practice.threads.taming.asynch;

public class BossOrig implements Runnable
{
	Thread t;
	String name;
	
	private BossSideKick robin;
	
	BossOrig(String threadname)
	{
		name = threadname;
		t = new Thread(this,name);
		System.out.println("Child Thread : " + t);
		t.start();
	} 
	
	public synchronized void setSideKick(BossSideKick stk)
	{
		robin = stk;
	}
	
	public synchronized void okay()
	{
		System.out.println("Sent to us by Robin Inside okay method");
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
