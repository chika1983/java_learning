package com.practice.threads.JavaConcurrency6.ReadWriteLock;
class ParkingLot { 
  //Assume 4 parking slots for simplicity 
  public static final int MAX_CAPACITY = 4; 
  private int totalParkedCars = 0; 
  public synchronized void park(String member) { 
    while (totalParkedCars >= MAX_CAPACITY) { 
     try { 
       System.out.println(" The parking lot is full " + 
                          member + " has to wait "); 
       wait(); 
     } catch (InterruptedException e) { 
       // 
     } 
    } 
    //precondition is true 
    System.out.println(member + " has parked"); 
    totalParkedCars = totalParkedCars + 1; 
  } 
  public synchronized void leave(String member) { 
    totalParkedCars = totalParkedCars - 1; 
    System.out.println(member + 
                       " has left, notify a waiting member"); 
    notify(); 
  } 
} 