package com.practice.threads.deadlock;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 18, 2010
 * Time: 1:23:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadA extends Thread
{
    ThreadA(String name)
    {
        setName(name);
    }

    public void run()
    {
        while(true)
        {
            synchronized("A"){
              System.out.println("Thread A acquining Lock A");
              synchronized("B"){
                System.out.println("Thread A acquining Lock B");
                  try
                  {
                    Thread.sleep((int)Math.random() * 100);
                  }
                  catch(InterruptedException ie)
                  {
                    ie.printStackTrace();
                  }
                  System.out.println ("Thread A releasing Lock B");
                 }
                System.out.println ("Thread A releasing Lock A");

            }
        }
    }
}
