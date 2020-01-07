package com.practice.threads.example;

  public class ClassLockNotObjectLock 
  {
      public static void main(String args[]) 
      {
          lockTest();
      }

      public static synchronized void lockTest() 
      {
          ClassLockNotObjectLock clnoc = new ClassLockNotObjectLock();
          
          System.out.println("Is the class object locked? " +
                             Thread. holdsLock(clnoc.getClass()));
          System.out.println("Is the object instance locked? " +
                             Thread. holdsLock(clnoc));
      }
  }
