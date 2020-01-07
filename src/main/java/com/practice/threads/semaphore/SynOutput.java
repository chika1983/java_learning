package com.practice.threads.semaphore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class SynOutput implements Runnable 
{
	Semaphore sem;
	String msg;
	FileWriter fw;
	
	public SynOutput(Semaphore s, FileWriter fw, String msg)
	{
		this.sem = s;
		this.fw = fw;
		this.msg = msg;
	}
	
	public void run() 
	{
		// TODO Auto-generated method stub
		try
		{
			//sem.acquire();
			for(int i=0; i< msg.length(); i++)
			{
				fw.write(msg.charAt(i));
				Thread.sleep(10);
			}
			fw.write("\n");
		}
		catch(IOException exc) 
		{
		      System.out.println("Error Writing File");
		} 
		catch (InterruptedException exc) 
		{
		      System.out.println(exc);
		}
		sem.release();
	}

}
