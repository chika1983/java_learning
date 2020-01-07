package com.practice.threads.multithreading.producerconsumer;

import java.util.Random;

public class Consumer implements Runnable {
	private final Buffer sharedLocation;
	private final static Random generator = new Random();
	
	public Consumer(Buffer buffer){
		this.sharedLocation = buffer;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int count=1; count<=10; count++){
			try{
				Thread.sleep(generator.nextInt(3000));
				sum +=sharedLocation.get();
				System.out.printf("\t\t\t%2d\n", sum);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		System.out.printf("\n%s %d\n%s\n","Consumer read values totaling", sum, "Terminating Consumer");
	}

}
