package com.practice.threads.general.ThreadLocal;

public class ThreadID extends ThreadLocal 
{
	private int nextID;
	
	public ThreadID()
	{
		nextID=10001;
	}
	
	private synchronized Integer getNewId()
	{
		Integer id = new Integer(nextID);
		nextID++;
		return nextID;
	}
	
	protected Object initalValue()
	{
		System.out.println("In Initial Value");
		return getNewId();
	}
	
	public int getThreadID()
	{
		Integer id = (Integer)get();
		return id.intValue();
	}
	
	private static void print(String msg)
	{
		String name = Thread.currentThread().getName();
		System.out.println("Name : " + name + " : "  + msg);
	}
}