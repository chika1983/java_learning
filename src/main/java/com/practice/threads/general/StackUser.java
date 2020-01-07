package com.practice.threads.general;

abstract class StackUser extends Thread
{
	protected StackClass stack;
	
	StackUser(String threadName, StackClass stack) 
	{
		super(threadName);
		
		this.stack = stack;
		System.out.println("Thread Name is :" + this);
		
		setDaemon(true);
		start();
	}
}
