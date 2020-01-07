package com.practice.threads.deadlock;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 17, 2010
 * Time: 3:45:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DemonstrateDeadlock
{
   private static final int NUM_THREADS=20;
   private static final int NUM_ACCOUNTS=10;
   private static final int NUM_ITERATIONS=1000000;
    
   public static void main(String args[])
   {
       final Random rnd = new Random();
       final Account[] accounts = new Account[NUM_ACCOUNTS];
       
   }
}
