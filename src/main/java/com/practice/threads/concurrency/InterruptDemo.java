package com.practice.threads.concurrency;
// Demonstrate thread interrupts.
class InterruptDemo {

  public static void main(String args[]) {
    MyThread4 mt = new MyThread4();
    MyThread4 mt2 = new MyThread4();
    Thread thrd = new Thread(mt, "MyThread #1");
    Thread thrd2 = new Thread(mt2, "MyThread #2");
    try {
      // Start the thread.
      thrd.start();

      // Give thrd time to begin executing.
      Thread.sleep(1000);

      // Now, interrupt thrd when it is sleeping.
      thrd.interrupt();

      // Next, start second thread.
      thrd2.start();

      System.out.println();

      // This time, wait until thrd2 begins
      // showing periods.
      Thread.sleep(4000);

      // Now, interrupt thrd2 when it is active.
      thrd2.interrupt();

    } catch (InterruptedException e) {
      System.out.println("Main thread Interrupted");
    }
  }
}