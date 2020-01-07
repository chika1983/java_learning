package com.practice.threads.taming.asynch;

public class FlintstoneTestDeadlock extends Thread
{
	int field_1;
	int field_2;
	
	private Object lock_1 = new Object();
	private Object lock_2 = new Object();
	
	String threadname;
	Thread t;
	
	FlintstoneTestDeadlock(String name)
	{
		lock_1="Lock1";
		lock_2="Lock2";
		
		threadname = name;
		t = new Thread(this, threadname);
		t.start();
	}
	
	public void run()
	{
		fred(1);
		barney(1);
	}
	
	public void fred(int value)
	{
		String name = Thread.currentThread().getName();
		synchronized(lock_1)
		{
			System.out.println(name + ": locked " + lock_1.toString());
			
			synchronized(lock_2)
			{
				System.out.println(name + ": trying to get " + lock_2.toString());
				field_1=0;
				field_2=0;
			}
		}
	}
	
	public void barney(int value)
	{
		String name = Thread.currentThread().getName();
		synchronized(lock_2)
		{
			System.out.println(name + ": locked " + lock_2.toString());
			synchronized(lock_1)
			{
				System.out.println(name + ": trying to get " + lock_1.toString());
				field_1=0;
				field_2=0;
			}
		}
	}
	
	public static void main(String args[])
	{
		FlintstoneTestDeadlock f1 = new FlintstoneTestDeadlock("Fred Thread");
		
		FlintstoneTestDeadlock f2 = new FlintstoneTestDeadlock("Barney Thread");
			
	}

}
