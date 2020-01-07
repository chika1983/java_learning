package com.practice.threads.taming;

public class Unreliable implements Runnable
{
	String name;
	Thread t;
	
	Unreliable(String threadname)
	{
		name=threadname;
		t = new Thread(this, name);
		
		System.out.println("Child Thread : " + t);
		t.start(); // Start the thread
		
	}
	
	public void run()
	{
		try
		{
			for(int i=5; i >  0; i--)
			{
				System.out.println(name + " : ");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(name + " Interrupted");
		}
		
		System.out.println(name + " exiting");
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String tname) 
	{
		this.name = tname;
	}
	
	
	
	public static void main(String args[])
	{
		new Unreliable("One");
		new Unreliable("Two");
		new Unreliable("Three");
		
		try
		{
			Thread.sleep(10000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Main thread Interrupted");
		}
		
		System.out.println("Main thread exiting");
	}

}
