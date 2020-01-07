package com.practice.threads.oreilly.javathreads.realimpl;

import java.net.Socket;

public class CalcRequest extends TCPServer 
{
	CPUScheduler scheduler;

	public CalcRequest() 
	{
		scheduler = new CPUScheduler(100);
		scheduler.start();
	}
	
	void doCalc(Socket s)
	{
		
	}
	
	public void run(Socket s) 
	{
		scheduler.addThread(Thread.currentThread());
		doCalc(s);
	}
	
}
