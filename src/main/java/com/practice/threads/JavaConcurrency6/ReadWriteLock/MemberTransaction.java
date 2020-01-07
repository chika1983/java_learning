package com.practice.threads.JavaConcurrency6.ReadWriteLock;

public class MemberTransaction extends Thread{
	private String name;
	private Item item;
	private String operation;
	
	public MemberTransaction(String n, Item i, String p){
		this.name = n;
		this.item = i;
		this.operation = p;
		start();
	}
	
	public void run(){
		item.getStatus(name);
		if(operation.equals("CheckOut")){
			System.out.println("\n" + name + "is ready to checkout the item");
			item.checkOut(name);
		}
		try{
			sleep(1);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
		item.checkIn(name);
	}

}
