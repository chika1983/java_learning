package com.practice.threads.JavaConcurrency6;

import java.util.concurrent.*;
   
class BarDemo {
  public static void main(String args[]) {
    CyclicBarrier cb = new CyclicBarrier(3, new BarAction() );
   
    System.out.println("Starting");
   
    new CyclicBarrierMyThread(cb, "A");
    new CyclicBarrierMyThread(cb, "B");
    new CyclicBarrierMyThread(cb, "C");

    new CyclicBarrierMyThread(cb, "X");
    new CyclicBarrierMyThread(cb, "Y");
    new CyclicBarrierMyThread(cb, "Z");

   
  }
}

// A thread of execution that uses a CyclicBarrier.
class CyclicBarrierMyThread implements Runnable {
  CyclicBarrier cbar;
  String name;

  CyclicBarrierMyThread(CyclicBarrier c, String n) {
    cbar = c;
    name = n;
    new Thread(this).start();
  }

    public void run() {

    System.out.println(name);

    try {
      cbar.await();
    } catch (BrokenBarrierException exc) {
      System.out.println(exc);
    } catch (InterruptedException exc) {
      System.out.println(exc);
    }
  }
}


