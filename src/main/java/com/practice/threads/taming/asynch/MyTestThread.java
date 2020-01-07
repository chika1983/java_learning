package com.practice.threads.taming.asynch;

public class MyTestThread extends Thread
{
	private int field_1=0;
	private int field_2=0;
	
	String name;
	Thread t;
	
	MyTestThread()
	{
				
	}
	
	synchronized public void modify(int val)
	{
		
	}
	
	public void run()
	{
		//this.setDaemon(true);
		
		while(true)
		{
			int copy_1;
			int copy_2;
			
			synchronized(this)
			{
				copy_1=field_1;
				copy_2=field_2;
			}
			System.out.println("field_1 =" + field_1
					+"field_2 =" + field_2);
			try
			{
				sleep(100);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		MyTestThread test = new MyTestThread();
		test.start();
		test.modify(1);
	}
}
