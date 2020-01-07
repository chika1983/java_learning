package com.learn.practice.threads.concurrency;

public class SayHello implements Runnable{
	
	private String greeting;
	
	public SayHello(String s) {
		this.greeting = s;
	}
	
	public void run() {
		for(int i = 1; i <= 50; i++) {
			System.out.print(greeting);
			Thread.yield();
		}
		System.out.println("End of run");
	}

}
