package com.practice.threads.JavaConcurrency6.ReadWriteLock;

public class Item {
	public String name;
	private ReadWriteLock rwLock;
	private String status;
	
	public Item(String n){
		this.name = n;
		rwLock = new ReadWriteLock();
		status = "N";
	}
	
	public void checkOut(String member){
		rwLock.getWriteLock();
		status = "Y";
		System.out.println(member + " has been issued a write lock checkout");
		rwLock.done();
	}
	
	public String getStatus(String member){
		rwLock.getReadLock(); 
	    System.out.println(member + 
	                       " has been issued a read lock"); 
	    rwLock.done(); 
	    return status;
	}
	
	public void checkIn(String member){
		rwLock.getWriteLock(); 
	    status = "N"; 
	    System.out.println(member + 
	                       " has been issued a write lock-ChkIn"); 
	    rwLock.done(); 
	}
}
