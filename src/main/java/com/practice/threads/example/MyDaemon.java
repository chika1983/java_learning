package com.practice.threads.example;
// Demonstrate a daemon thread.

// This class creates a daemon thread.
class MyDaemon implements Runnable {
  Thread thrd;
  MyDaemon() {

    // Create the thread.
    thrd = new Thread(this);

    // Set to daemon
   // thrd.setDaemon(true);

    // Start the thread.
    thrd.start();
  }

  // Entry point of thread.
  // It displays a period once a second.
  public void run() {

    try {
      for(;;) {
        System.out.print(".");
        Thread.sleep(1000);
      }
    }
    catch(InterruptedException exc) {
      System.out.println("MyDaemon interrupted.");
    }
  }
}
