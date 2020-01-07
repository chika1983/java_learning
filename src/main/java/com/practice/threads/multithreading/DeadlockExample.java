package com.practice.threads.multithreading;

  public class DeadlockExample {
      
	  static Object lock1;
	  static Object lock2;
	  
	  /**
       * Entry point to the application. Creates 2 threads that will deadlock.
       */
      public static void main(String args[]) 
      {
          DeadlockExample dle = new DeadlockExample();

          lock1 = "Lock 1";
          lock2 = "Lock 2";

         Runner thread1 = new Runner(lock1, lock2);
         Runner thread2 = new Runner(lock2, lock1);
         thread1.start();
         thread2.start();
      }

      /**
       * Lock two objects in the order they were specified in the constructor.
       */
      static class Runner extends Thread 
      {
          private Object lockA;
          private Object lockB;

          public Runner(Object firstLockToGet, Object secondLockToGet) 
          {
              this.lockA = firstLockToGet;
              this.lockB = secondLockToGet;
          }

          public void run() 
          {
              String name = Thread.currentThread().getName();
              synchronized (lock1) {
                  System.out.println(name + ": locked " + lockA);
                 delay(name);
                  System.out.println(name + ": trying to get " + lockB);
                  synchronized (lock2) {
                     System.out.println(name + ": locked " + lockB);
                  }
             }
          }
      }

      /**
       * build in a delay to allow the other thread time to lock the object
       * the delaying thread would like to get.
       */
      private static void delay(String name) {
          try {
              System.out.println(name + ": delaying 1 second");
              Thread.sleep(1000L);
         } catch (InterruptedException ie) {
              ie.printStackTrace();
          }
      }
  }
