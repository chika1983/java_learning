package com.practice.threads.multithreading.producerconsumer;

import java.util.Random;

public class Producer implements Runnable {
	private final static Random generator = new Random();
	private final Buffer sharedLocation;
	
	public Producer(Buffer shared){
		this.sharedLocation = shared;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int count=1; count<=10; count++){
			try{
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sharedLocation.set(count);
				sum+=count;
				System.out.printf("\t%2d\n", sum);
			} catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		System.out.println("Producer done production..., Terminating Producer");
	}

}
