package com.practice.threads.concurrency;

public class MyThread implements Runnable 
{
	int cnt;
	
	MyThread()
	{
		cnt =0;
	}

	public void run() 
	{
		// TODO Auto-generated method stub
		System.out.println("My Thread Starting ...");
		
		try
		{
			do
			{
				Thread.sleep(500);
				System.out.println("In MyThread, count is " + cnt);
		        cnt++;
			}while(cnt < 5);
		}
		catch(InterruptedException ie)
		{
			System.err.println("Exception Occurred");
			ie.printStackTrace();
		}
		System.out.println("MyThread terminating.");

	}

}
