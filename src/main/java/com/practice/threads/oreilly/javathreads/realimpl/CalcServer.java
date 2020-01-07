package com.practice.threads.oreilly.javathreads.realimpl;

import java.net.*;
import java.io.*;

public class CalcServer 
{
	public static void main(String args[])
	{
		CalcRequest cr = new CalcRequest();
		try
		{
			cr.startServer(3535);
		}
		catch(Exception e)
		{
			System.out.println("Unable to start server");
			e.printStackTrace();
		}
		
	}

}
