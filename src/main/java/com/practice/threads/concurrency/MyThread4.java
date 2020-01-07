package com.practice.threads.concurrency;

//Interrupt a thread.

//This class handles an interrupt in two ways.
//First, if interrupted while sleeping(),
//it catches the InterruptedException that will
//be thrown.  Second, it calls interrupted()
//while active to check its interrupt status.
//If interrupted while active, the thread
//terminates.
class MyThread4 implements Runnable {

// Run the thread.
public void run() {
 String thrdName = Thread.currentThread().getName();

 System.out.println(thrdName + " starting.");

 try {

   // First, sleep for 3 seconds. If sleep() is
   // interrupted, then an InterruptedException
   // will be received.
   Thread.sleep(3000);

   // Next, keep the thread active by displaying
   // periods. Use a time-delay loop rather than
   // sleep() to slow down the thread. This means
   // that the thread remains active.  Interrupting
   // the thread at this point does not cause an
   // an InterruptedException. Rather, its interrupted
   // status is set.
   for(int i = 1; i < 1000; i++) {
     if(Thread.interrupted()) {
       System.out.println("Thread interrupted while active.");
       break;
     }

     // Display periods.
     System.out.print(".");

     // Don't sleep at this point. Instead, burn CPU
     // time to keep thread active.
     for(long x = 0; x < 10000000; x++) ;
   }
 } catch (InterruptedException exc) {
   System.out.println(thrdName + " interrupted.");
 }
 System.out.println(thrdName + " exiting.");
}
}
