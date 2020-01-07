package com.practice.threads.taming.asynch;

public class BlackholeThreadSafeWrapper implements BlackholeInterface
{
	BlackholeInterface AnotThreadSafe ;
	
	public BlackholeThreadSafeWrapper(BlackholeInterface ba)
	{
		this.AnotThreadSafe = ba;
		
	}
	
	public BlackholeInterface extract()
	{
		return AnotThreadSafe;
		
	}
	
	public synchronized Object message()
	{
		return AnotThreadSafe.message();
		
	}
}
