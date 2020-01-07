package com.practice.threads.concurrency;
class DaemonDemo {
  public static void main(String args[]) {

    // Construct and start running a MyDaemon thread.
    MyDaemon dt = new MyDaemon();

    if(dt.thrd.isDaemon())
      System.out.println("dt is a daemon thread.");

    // Keep the main thread alive for 10 seconds.
    System.out.println("Sleeping in main thread.");
    try {
        Thread.sleep(10000);
    }
    catch(InterruptedException exc) {
      System.out.println("Main thread interrupted.");
    }

    System.out.println("\nMain thread ending.");

    // At this point, the daemon thread will
    // automatically terminate.
  }
}