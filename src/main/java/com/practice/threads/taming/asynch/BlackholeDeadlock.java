package com.practice.threads.taming.asynch;

public class BlackholeDeadlock implements Runnable
{
	BlackholeANotThreadSafe ba = new BlackholeANotThreadSafe();
	BlackholeBNotThreadSafe bb = new BlackholeBNotThreadSafe();
	
	BlackholeThreadSafeWrapper btswa = new BlackholeThreadSafeWrapper(ba);
	BlackholeThreadSafeWrapper btswb = new BlackholeThreadSafeWrapper(bb);
	
	BlackholeDeadlock()
	{
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this,"RacingThread");
		t.start();
		
		ba = (BlackholeANotThreadSafe) btswa.extract();
		ba.foo(bb);
		System.out.println("Back in main thread");
	}
	
	public void run()
	{
		bb = (BlackholeBNotThreadSafe)btswb.extract();
		bb.bar(ba);
		System.out.println("Back in other thread");
	}
	
	public static void main(String args[])
	{
		new BlackholeDeadlock();
		try
		{
			Thread.sleep(10000);
		}
		catch(InterruptedException ie)
		{
			System.out.println("Main Thread Interrupted");
		}
		System.out.println("Main thread exiting");
	}
}
