package com.practice.threads.concurrency;
class RunnableDemo {
  public static void main(String args[]) {
    System.out.println("Main thread starting.");

    // First, construct a MyThread object.
    MyThread mt = new MyThread();

    // Next, construct a thread from that object.
    Thread newThrd = new Thread(mt);

    // Finally, start execution of the thread.
    newThrd.start();

    // Give the main thread something to do.
    do {
      System.out.println("In main thread. " + Thread.currentThread().getId());
      try {
        Thread.sleep(250);
      }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
    } while (mt.cnt != 5);

    System.out.println("Main thread ending.");
  }
}