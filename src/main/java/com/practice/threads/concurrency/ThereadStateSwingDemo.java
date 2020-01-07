package com.practice.threads.concurrency;

import javax.swing.SwingUtilities;

//This version of ThreadStateDemo uses a ThreadMonitor
//to report a thread's name, state, and priority in real time.
class ThreadStateSwingDemo {

public static void main(String args[]) {

 try { 
   // Construct a MyThread object.
   MyThread5 mt = new MyThread5();
   final Thread thrd = new Thread(mt, "MyThread #1");

   // Create the thread monitor. Because ThreadMonitor creates
   // a Swing GUI, ThreadMonitor must be instantiated on
   // the event dispatching thread.
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
       new ThreadMonitor(thrd);
     }
   });

   // Use sleep() here and elsewhere to slow down
   // execution in order to allow the various
   // thread states to be seen.
   Thread.sleep(3000);

   // Start the thread.
   thrd.start();

   Thread.sleep(3000);

   // Show state of a thread waiting on wait().
   mt.holding = false; // let MyThread #1 enter call wait()

   Thread.sleep(3000);

   // Change the thread's priority.
   System.out.println("Changing the thread's priority.");
   thrd.setPriority(Thread.NORM_PRIORITY-2);

   Thread.sleep(3000);

   // Change the thread's name to MyThread ALPHA.
   System.out.println("Changing name to MyThread ALPHA.");
   thrd.setName("MyThread ALPHA");
   Thread.sleep(3000);

   // Let the thread move on by calling notify().
   // This lets MyThread #1 go to sleep.
   mt.n();

   Thread.sleep(3000);

   System.out.println("Main thread ending.");
 }
 catch(InterruptedException exc) {
   System.out.println("Main thread interrupted.");
 }
}
}