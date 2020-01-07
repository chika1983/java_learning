package com.practice.threads.JavaConcurrency6;

import java.util.concurrent.locks.*;
   
class LockDemo {
   
  public static void main(String args[]) {
    ReentrantLock lock = new ReentrantLock();
   
    new LockThread(lock, "A");
    new LockThread(lock, "B");
   
  }
}

// A shared resource.
class Shared {
  static int count = 0;
}
