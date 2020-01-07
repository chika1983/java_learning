package com.practice.threads.example;

public class SynchExample 
{
      private Resource resourceOne = new Resource();
      private Resource resourceTwo = new Resource();
      private Resource resourceThree= new Resource();
 
      public synchronized void synchThisObjectExample() 
      {
           resourceOne.value = -3;
           resourceTwo.value = -2;
          resourceThree.value = -1;
      }

      public void synchAllLocksExample() 
      {
          synchronized (resourceOne) 
          {
             resourceOne.value = -3;
          }

          synchronized (resourceTwo) 
          {
              resourceTwo.value = -2;
          }

          synchronized (resourceThree) 
          {
              resourceThree.value = -1;
          }
      }

      private static class Resource 
      {
          int value;
      }
  }
