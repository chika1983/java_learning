package com.practice.threads.JavaConcurrency6;

import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 24, 2010
 * Time: 4:37:10 PM
 * To change this template use File | Settings | File Templates.
 */
class ExecutorMyThread implements Runnable {
  String name;
  CountDownLatch latch;

  ExecutorMyThread(CountDownLatch c, String n) {
    latch = c;
    name = n;

    new Thread(this);
  }

  public void run() {

    for(int i = 0; i < 5; i++) {
      System.out.println(name + ": " + i);
      latch.countDown();
    }
  }
}
