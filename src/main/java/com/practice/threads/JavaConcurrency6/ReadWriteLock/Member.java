package com.practice.threads.JavaConcurrency6.ReadWriteLock;
class Member extends Thread { 
  private ParkingLot parking; 
  private String name; 
  Member(String n, ParkingLot p) { 
    name = n; 
    parking = p; 
    start(); 
  } 
  public void run() { 
    System.out.println(name + " is ready to park"); 
    parking.park(name); 
    try { 
     sleep(500); 
    } catch (InterruptedException e) { 
     // 
    } 
    //leave after 500ms 
    parking.leave(name); 
  } 
} 