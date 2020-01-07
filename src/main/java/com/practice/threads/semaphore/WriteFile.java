package com.practice.threads.semaphore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;

public class WriteFile implements Callable<Boolean> 
{
	String fname;
	String msg;
	
	public WriteFile(String n, String info)
	{
		fname = n;
		msg = info;
	}
	
	public Boolean call()
	{
		FileWriter fw = null;
		boolean result = true;
		
		try
		{
			fw = new FileWriter(fname);
			fw.write(msg);
		}
		catch(IOException ie)
		{
			// Return false if the file cannot be
		    // opened or written.
		      result = false;
		}
		
		try 
		{
		      if(fw != null) fw.close();
		}
		catch(IOException exc) 
		{
		      // Return false if the file can't be closed.
		      result = false;
		}

		return result;

	}
	

}
