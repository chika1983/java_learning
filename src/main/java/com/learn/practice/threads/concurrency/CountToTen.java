package com.learn.practice.threads.concurrency;

public class CountToTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SayHello hello = new SayHello("Hi");
        Thread t = new Thread(hello);
        t.start();
        
        for(int k = 1; k <= 50; k++) {
            System.out.print(k);
            Thread.yield();
        }
        System.out.println("End of main");
    }
}
