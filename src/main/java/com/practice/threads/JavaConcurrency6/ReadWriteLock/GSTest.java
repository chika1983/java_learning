package com.practice.threads.JavaConcurrency6.ReadWriteLock;
public class GSTest { 
  public static void main(String[] args)  { 
    ParkingLot parking = new ParkingLot(); 
    new Member("Member1", parking); 
    new Member("Member2", parking); 
    new Member("Member3", parking); 
    new Member("Member4", parking); 
    new Member("Member5", parking); 
    new Member("Member6", parking); 
  } 
} 