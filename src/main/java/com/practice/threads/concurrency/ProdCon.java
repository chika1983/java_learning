package com.practice.threads.concurrency;
public class ProdCon {
  public static void main(String args[]) {
    Queue q = new Queue();
    new Consumer(q);
    new Producer(q);
  }
}