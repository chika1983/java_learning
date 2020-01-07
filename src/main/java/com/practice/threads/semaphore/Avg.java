package com.practice.threads.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

 class Avg implements Callable<Double>
 {
	 ArrayList ld;
    	public Avg(ArrayList l)
    	{
    		this.ld = l;
    	}
    	
    	public Double call()
    	{
    		double sum = 0;
    		
    		 for (int y=0; y<ld.size(); y++) 
    	      { 
    			 sum = sum + (Long)ld.get(y);
    	         //System.out.println(ld.get(y));
    	      }
    		 
    		 return sum / ld.size();
    	}
    }