package com.practice.threads.JavaConcurrency6;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 24, 2010
 * Time: 6:51:03 PM
 * To change this template use File | Settings | File Templates.
 */

class AtomicDemo {

  public static void main(String args[]) {
    new AtomThread("A");
    new AtomThread("B");
    new AtomThread("C");
  }
}



// A thread of execution that increments count.
class AtomThread implements Runnable {
  String name;

  AtomThread(String n) {
    name = n;
    new Thread(this).start();
  }

  public void run() {

    System.out.println("Starting " + name);

    for(int i=1; i <= 30000; i++)
     /* System.out.println(name + " got: " +
             SharedAtomicValue.setInteger(i));*/
      System.out.println(name + " got: " + SharedAtomicValue.ai.getAndSet(i));
  }
}
