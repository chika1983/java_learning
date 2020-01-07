package com.practice.threads.general;

public class StackClass 
{
	private Object[] stackArray;
	private volatile int topOfStack;
	
	public StackClass(int capacity) 
	{
		// TODO Auto-generated constructor stub
		stackArray = new Object[capacity];
		topOfStack = -1;
	}
	
	public boolean isEmpty()
	{
		return(topOfStack < 0);
	}
	
	public boolean isFull()
	{
		return (topOfStack >= stackArray.length -1);
	}
	
	public synchronized Object pop()
	{
		System.out.println(Thread.currentThread() +": popping");
		
		while(isEmpty())
		{
			try 
			{
				System.out.println(Thread.currentThread() + ": waiting to pop");
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		Object obj = stackArray[topOfStack];
		
		stackArray[topOfStack--] = null;
		System.out.println(Thread.currentThread() + ": notifying after pop");
				
		notify();
		return obj;
	}
	
	public synchronized void push(Object element)
	{
		System.out.println(Thread.currentThread() +": pushing");
		
		while(isFull())
		{
			try {
				System.out.println(Thread.currentThread() + ": waiting to push");
						
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		stackArray[++topOfStack] = element;
		System.out.println(Thread.currentThread() + ": notifying after push");
		
		notify();
	}
	
}
