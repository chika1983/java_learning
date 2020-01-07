package com.practice.threads.oreilly.javathreads.realimpl;

public class TestThread extends Thread
{
	String id;
	
	public TestThread(String s)
	{
		id = s;
	}
	
	public void doCalc(int i)
	{
		//System.out.println("Value of i is : " + i);
	}
	
	public void run()
	{
		int i;
		for(int k=0; k<10; k++)
		{
			doCalc(k);
			System.out.println("ID is : " + id);
		}
	}

}
