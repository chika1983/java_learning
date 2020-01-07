package com.practice.threads.example;
class JoinDemo {
  public static void main(String args[]) {

    System.out.println("Main thread starting.");

    // Construct a thread based on MyThread.
    Thread thrd = new Thread(new JoinThread());

    // Start execution of thrd.
    thrd.start();

    // Wait until thrd ends.
    try {
      thrd.join();
    }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
    }

    System.out.println("Main thread ending.");
  }
}