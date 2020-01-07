package com.practice.threads.taming.asynch;

import com.practice.threads.taming.asynch.SemaphoreOrig;

public final class SemaphoreSpinlock
{
     public interface Condition
     {   
    	 boolean satisfied();
     }
     

     public synchronized void acquire( Condition condition, long timeout )
                                                 throws SemaphoreOrig.Timed_out,
                                                        InterruptedException
    {
         long expiration = System.currentTimeMillis() + timeout;
         
         while( !condition.satisfied() )
         {
        	 timeout = expiration - System.currentTimeMillis();
              if( timeout <= 0 )
                  throw new SemaphoreOrig.Timed_out("Spin lock timed out.");
              wait( timeout );
         }
    }

    public synchronized void release()
    {
    	notify();
    }
 }

