package com.practice.threads.concurrency;
class ThreadStateDemo {
  public static void main(String args[]) {

    try {

      // Construct a MyThread object.
      MyThread5 mt = new MyThread5();
      Thread thrd = new Thread(mt, "MyThread #1");

      // Show state of newly created thread.
      System.out.println("MyThread #1 created but not yet started.");
      showThreadStatus(thrd);

      // Show state of thread that is running.
      System.out.println("Calling start() on MyThread #1.");
      thrd.start();
      Thread.sleep(50); // let MyThread #1 thread run
      showThreadStatus(thrd);

      // Show state of a thread waiting on wait().
      mt.holding = false; // let MyThread #1 call wait()
      Thread.sleep(50); // let MyThread #1 thread run
      showThreadStatus(thrd);

      // Let MyThread #1 move on by calling notify().
      // This lets MyThread #1 go to sleep.
      mt.n();
      Thread.sleep(50); // let MyThread #1 thread run

      // Now, show state of a thread sleeping.
      showThreadStatus(thrd);

      // Wait for thread to finish.
      while(thrd.isAlive()) ;

      // Show final status.
      showThreadStatus(thrd);
    }
    catch(InterruptedException exc) {
      System.out.println("Main thread interrupted.");
    }
  }

  // Show a thread's status.
  static void showThreadStatus(Thread thrd) {
    System.out.println("Status of " + thrd.getName() + ":");

    if(thrd.isAlive())
      System.out.println("  Alive");
    else
      System.out.println("  Not alive");

    System.out.println("  State is " + thrd.getState());

    System.out.println();
  }
}