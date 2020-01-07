package com.practice.threads.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThrdRetValDemo 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(3);
		Future <Double> f1;
		Future <Long> f2;
		Future <Boolean> f3;
		
		RandomDifferent rd = new RandomDifferent();
				
		f1 = es.submit(new Avg(rd.b));
		f2 = es.submit(new Factorial(20));
		f3 = es.submit(new WriteFile("test.dat", "This is a test"));
		
		 // Wait for the results.
	    try 
	    {
	      System.out.println(f1.get());
	      System.out.println(f2.get());
	      System.out.println(f3.get());
	    }
	    catch (InterruptedException exc) 
	    {
	      System.out.println(exc);
	    }
	    catch (ExecutionException exc) 
	    {
	      System.out.println(exc);
	    }
	    
	    // Stop the executor service.
	    es.shutdown();
	}
	
	
}