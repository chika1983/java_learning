package com.practice.threads.taming.asynch;

public class BossGothamCity {

	public static void main(String[] args) 
	{
		BossOrig b1 = new BossOrig("Boss One");
		BossSideKick sk1 = new BossSideKick("SideKick One");
		b1.setSideKick(sk1);
		sk1.setBoss(b1);
		
		BossOrig b2 = new BossOrig("Boss Two");
		BossSideKick sk2 = new BossSideKick("SideKick Two");
		b2.setSideKick(sk2);
		sk2.setBoss(b2);
		
		try
		{
			//wait for other threads to end
			Thread.sleep(10000);
		}
		catch(InterruptedException ie)
		{
			System.out.println("Main thread Interrupted");
		}
		
		System.out.println("Main thread exiting");
	}

}
