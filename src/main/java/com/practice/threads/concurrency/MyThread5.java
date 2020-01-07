package com.practice.threads.concurrency;

//Monitor a thread's status.

class MyThread5 implements Runnable {
  int count;
  boolean holding;
  boolean ready;

  MyThread5() {
    count = 0;
    holding = true;
    ready = false;
  }

  // Entry point of thread.
  public void run() {

    // Get the name of this thread.
    String thrdName = Thread.currentThread().getName();

    System.out.println(thrdName + " starting.");

    // Burn CPU time.
    System.out.println(thrdName + " using the CPU.");
    while(holding) ; // do nothing

    // Now, enter a wait state via a call to wait().
    System.out.println("waiting...");
    w(); // execute a call to wait() on this thread.

    // Next, enter a timed wait state via a call to sleep().
    try {
      System.out.println("Sleeping...");
      Thread.sleep(1000);
    } catch(InterruptedException exc) {
      System.out.println(thrdName + " interrupted.");
    }

    System.out.println(thrdName + " terminating.");
  }

  // Execute a call to wait().
  synchronized void w() {
    try {
      while(!ready) wait();
    } catch(InterruptedException exc) {
      System.out.println("wait() interrupted");
    }
  }

  // Execute a call to notify().
  synchronized void n() {
    ready = true;
    notify();
  }
}
