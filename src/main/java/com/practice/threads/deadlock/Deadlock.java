package com.practice.threads.deadlock;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 18, 2010
 * Time: 1:23:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deadlock
{
    public static void main(String args[])
    {
        ThreadA ta = new ThreadA("A");
        ta.start();

        ThreadB tb = new ThreadB("B");
        tb.start();
    }
}
