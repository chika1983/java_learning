package com.practice.threads.concurrency;
class ThreadControlDemo {

  public static void main(String args[]) {
    MyThread2 mt = new MyThread2("MyThread");

    try {
      // Let mt start executing.
      Thread.sleep(3000);

      // Suspend mt.
      System.out.println("\nSuspending MyThread.");
      mt.mySuspend();
      Thread.sleep(3000);

      // Now, resume mt.
      System.out.println("\nResuming MyThread.");
      mt.myResume();
      Thread.sleep(3000);

      // Suspend and resume a second time.
      System.out.println("\nSuspending MyThread again.");
      mt.mySuspend();
      Thread.sleep(3000);

      System.out.println("\nResuming MyThread again.");
      mt.myResume();
      Thread.sleep(3000);

      // Now Stop the thread.
      System.out.println("\nStopping thread.");
      mt.myStop();
    } catch (InterruptedException e) {
      System.out.println("Main thread Interrupted");
    }
    
    /*
    if(suspended || stopped)
    	  synchronized(this) {

    	    // If suspended is true, then wait until
    	    // notified. Then, recheck suspended.
    	    // The suspended variable is set to true
    	    // by a call to mySuspend(). It is set to
    	    // false by a call to myResume().
    	    while(suspended) wait();

    	    // If thread is stopped, exit the loop and
    	    // let the thread end. The stopped variable is
    	    // set to true by a call to myStop().
    	    if(stopped) break;
    	}
    */
    
  }
}