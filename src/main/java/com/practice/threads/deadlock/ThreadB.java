package com.practice.threads.deadlock;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 18, 2010
 * Time: 1:29:05 PM
 * To change this template use File | Settings | File Templates.
 */
class ThreadB extends Thread
{
   ThreadB (String name)
   {
      setName (name);
   }

   public void run ()
   {
      while (true)
      {
         synchronized ("B")
         {
            System.out.println ("Thread B acquiring Lock B");
            synchronized ("A")
            {
               System.out.println ("Thread B acquiring Lock A");
               try
               {
                   Thread.sleep ((int) Math.random ()*100);
               }
               catch (InterruptedException e)
               {
               }
               System.out.println ("Thread B releasing Lock A");
            }
            System.out.println ("Thread B releasing Lock B");
         }
      }
   }
}
