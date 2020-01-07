package com.practice.threads.semaphore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class SemDemo 
{
	public SemDemo()
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Semaphore sem = new Semaphore(1,true);
		FileWriter fw;
		
		try 
		{
			fw = new FileWriter("Log.dat");
		}
		catch (IOException e) 
		{
			System.out.println("Error Opening Log File");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		
		Thread thrdA = new Thread(new SynOutput
				(sem,fw,"Transfer Complete"));
		
		Thread thrdB = new Thread(new SynOutput
				(sem,fw,"Connection Lost!"));
		
		thrdA.start();
		thrdB.start();
		
		// Wait for the threads to end.
	    try 
	    {
	      thrdA.join();
	      thrdB.join();

	      fw.close();
	    }
	    catch(InterruptedException exc) 
	    {
	      System.out.println("Interrupted");
	    }
	    catch(IOException exc) 
	    {
	      System.out.println("Error Closing File");
	    }

	}

}
