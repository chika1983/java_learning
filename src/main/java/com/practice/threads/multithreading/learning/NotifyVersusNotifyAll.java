package com.practice.threads.multithreading.learning;
  public class NotifyVersusNotifyAll extends Thread {
      private static Object mutex = new Object();

      public static void main(String[] args) throws InterruptedException 
      {
          for (int i = 0; i < 5; i++) 
          {
              new NotifyVersusNotifyAll().start();
          }

         Thread.sleep(2000);
                   
          synchronized(mutex) 
          {
        	  System.out.println("Waiting for Notify :");
              mutex.notifyAll();
        	//mutex.notify();
          }
      }
      
      public void run() {
          try {
              synchronized (mutex) {
                  System.out.println(getName() + " waiting");
                  mutex.wait();
                  System.out.println(getName() + " woken up");
                  mutex.wait(2000);
                  System.out.println(getName() + " waking up another thread");
                  mutex.notify();
             }
          } catch (InterruptedException ie) {
              ie.printStackTrace();
          }
      }
  }
