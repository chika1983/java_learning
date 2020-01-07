package com.practice.threads.semaphore;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
 
public class RandomDifferent 
{
   final static ArrayList<Long> b 
   						= new ArrayList<Long>();
   
   
   public RandomDifferent()
   {
	   Random randomNumber = new Random();
	   long random;
	   
	   for(int i=0; i<1000000; i++)
	   {
		   random = randomNumber.nextLong();
		   b.add(i,random);
	   }
	   
	   Avg av = new Avg(b);
   }
      
}
