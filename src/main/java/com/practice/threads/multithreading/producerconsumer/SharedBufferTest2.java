package com.practice.threads.multithreading.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest2 {
	public static void main(String args[]){
		ExecutorService application = Executors.newCachedThreadPool();
		Buffer sharedLocation = new BlockingBuffer();
		
		System.out.println("Action\t\t" + "--" + " Value\t" + "--" + "Sum of Produced\t" + "--"+ "Sum of Consumed");
		System.out.println("----------\t---------\t-------------------\t----------------------\n");
		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));
		
		application.shutdown();
	}
}
