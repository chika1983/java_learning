package com.learn.practice.threads.concurrency.blockingqueuedemo;

import java.util.concurrent.BlockingDeque;
public class Consumer implements Runnable {
     private String name;
     private BlockingDeque<Integer> deque;
     public Consumer (String name, BlockingDeque<Integer> deque) {
        this.name =name;
        this.deque =deque;
     }
     public void run () {
        for (int i =0; i < 10; i++) {
            try {
                int j= deque.takeLast () ;
                System.out.println (name + " takes " + j) ;
                System.out.println (name + " prints data: " + deque +
                       "\n");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                  e.printStackTrace () ;
            }
        }
     }
 }
