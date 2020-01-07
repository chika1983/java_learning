package com.practice.threads.taming.asynch;

import java.util.Random;

public class ComplicatedThreadSafe implements Runnable
{
	String name;
	Thread t;
	
	private static long a, b;
	private static long x, y;
	
	private Object ab_lock = new Object();
	private Object xy_lock = new Object();
	
	ComplicatedThreadSafe(String tname)
	{
		name = tname;
		t = new Thread(this,name);
		t.start();
	}
	
	public void run()
	{
		use_a();
		use_b();
		use_x();
		use_y();
		use_a_and_b();
		use_x_and_y();
		use_everything();
		use_everything_else();
	}
	
	public static void main(String args[])
	{
		ComplicatedThreadSafe cts = new ComplicatedThreadSafe("Complicated Thread");
		Random randomGen = new Random();
		
		a = randomGen.nextLong();
		b = randomGen.nextLong();
		
		x = randomGen.nextLong();
		y = randomGen.nextLong();
		
		try
		{
			Thread.currentThread().sleep(1000);
		}
		catch(InterruptedException ie)
		{
			System.out.println("Main Thread Interrupted");
		}
		System.out.println("Main thread exiting");
	}
	
	public void use_a()
	{
		synchronized(ab_lock)
		{
			System.out.println("Value of a is : " + a);
		}
	}
	
	public void use_b()
	{
		synchronized(ab_lock)
		{
			System.out.println("Value of b is : " + b);
		}
	}
	
	public void use_a_and_b()
	{
		synchronized(ab_lock)
		{
			System.out.println("Value of a + b is : " + (a + b));
		}
	}
	
	public void use_x()
	{
		synchronized(xy_lock)
		{
			System.out.println("Value of x is : " + x);
		}
	}
	
	public void use_y()
	{
		synchronized(xy_lock)
		{
			System.out.println("Value of y is : " + y);
		}
	}
	
	public void use_x_and_y()
	{
		synchronized(xy_lock)
		{
			System.out.println("Value of x + y is : " + (x + y));
		}
	}
	
	public void use_everything()
	{
		synchronized(ab_lock)
		{
			synchronized(xy_lock)
			{
				System.out.println("Value of a + x is : " + (a + x));
			}
		}
	}
	
	public void use_everything_else()
	{
		synchronized(ab_lock)
		{
			synchronized(xy_lock)
			{
				System.out.println("Value of b + y is : " + (b + y));
			}
		}
		
	}
}
