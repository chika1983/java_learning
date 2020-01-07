package com.practice.threads.multithreading.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{
	private final ArrayBlockingQueue<Integer> buffer;
	
	public BlockingBuffer(){
		this.buffer = new ArrayBlockingQueue<Integer>(1);
	}
	
	public void set(int value) throws InterruptedException{
		buffer.put(value);
		System.out.printf("%s%2d\t%s%d\n","Producer Writes ", value, "Buffer Cells occupied: ", buffer.size());
	}
	
	public int get() throws InterruptedException{
		int readValue = buffer.take();
		System.out.printf("%s %2d\t%s%d\n", "Consumer reads ", readValue, "Buffer Cells Occupied: ", buffer.size());
		return readValue;
	}
}

