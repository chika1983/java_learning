package com.practice.threads.general;

public class SyncMethodsExample extends Thread
{
	static class SynchronizedOutput
	{
		static void displayList(String name, String list[])
		{
			for(int i=0; i<list.length; i++)
			{
				SyncMethodsExample sme = (SyncMethodsExample) Thread.currentThread();
				
				sme.randomWait();
				System.out.println(name + list[i]);
			}
		}
	}
	
	static String[] msg = {"Beginner","Java", "Tutorial", ".","com","is","the","best"};
	
	public SyncMethodsExample(String name)
	{
		super(name);
	}
		
	
	public SyncMethodsExample()
	{
		
	}
	
	public static void main(String args[])
	{
		SyncMethodsExample sme1 = new SyncMethodsExample("thread1:");
		SyncMethodsExample sme2 = new SyncMethodsExample("thread2:");
		
		sme1.start();
		sme2.start();
		
		boolean t1IsAlive = true;
		boolean t2IsAlive = true;
		
		do
		{
			if(t1IsAlive && !sme1.isAlive())
			{
				t1IsAlive = false;
				System.out.println("t1 is dead");
			}
			
			if(t2IsAlive && !sme2.isAlive())
			{
				t2IsAlive = false;
				System.out.println("t2 is dead");
			}
			
		}while(t1IsAlive || t2IsAlive);
	}	
	
	public	void randomWait()
	{
		try
		{
				Thread.currentThread().sleep((long)(3000 * (Math.random())));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void run()
	{
		SynchronizedOutput.displayList(getName(), msg);
		
		
	}
	

}
