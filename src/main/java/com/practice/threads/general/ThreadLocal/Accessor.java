package com.practice.threads.general.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Accessor implements Runnable{
	private final int id;
	
	public Accessor(int idn) {
		this.id = idn;
	}
	
	public void run(){
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	
	public String toString() {
		return "#" + id + ": " +  ThreadLocalVariableHolder.get();
	}
	
	public static void main(String args[]) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++){
			exec.execute(new Accessor(i));
			TimeUnit.SECONDS.sleep(10);
			exec.shutdownNow();
		}
	}
}
