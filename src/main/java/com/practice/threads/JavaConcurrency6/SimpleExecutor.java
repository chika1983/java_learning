package com.practice.threads.JavaConcurrency6;

import java.util.concurrent.*;
   
class SimpleExecutor {
  public static void main(String args[]) {
    CountDownLatch cdl = new CountDownLatch(5);
    CountDownLatch cdl2 = new CountDownLatch(5);
    CountDownLatch cdl3 = new CountDownLatch(5);
    CountDownLatch cdl4 = new CountDownLatch(5);
    ExecutorService es = Executors.newFixedThreadPool(2);
   
    System.out.println("Starting");
   
    // Start the threads.
    es.execute(new ExecutorMyThread(cdl, "A"));
    es.execute(new ExecutorMyThread(cdl2, "B"));
    es.execute(new ExecutorMyThread(cdl3, "C"));
    es.execute(new ExecutorMyThread(cdl4, "D"));
   
    try {
      cdl.await();
      cdl2.await();
      cdl3.await();
      cdl4.await();
    } catch (InterruptedException exc) {
      System.out.println(exc);
    }
   
   // es.shutdown();
    System.out.println("Done");
  }
}
