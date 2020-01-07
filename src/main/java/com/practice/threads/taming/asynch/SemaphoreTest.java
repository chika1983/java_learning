package com.practice.threads.taming.asynch;

import java.util.Stack;

public class SemaphoreTest
    {   public static void main( String[] args ) throws Exception
        {
            final Stack stack    = new Stack();
            final SemaphoreSpinlock lock = new SemaphoreSpinlock();
           new Thread()
            {   public void run()
               {   try
                    {   lock.acquire( new SemaphoreSpinlock.Condition()
                                      {   public boolean satisfied()
                                          {   return !stack.isEmpty();
                                          }
                                     },
                                      4000
                                    );

                        System.out.println( stack.pop().toString() );
                    }
                    catch(Exception e){}
                }
            }.start();

            Thread.currentThread().sleep(500); // give the thread a
                                               // chance to get started.
           stack.push("hello world! Anand");
            lock.release();
        }
     }

