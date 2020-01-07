package com.practice.threads.JavaConcurrency6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 24, 2010
 * Time: 6:54:20 PM
 * To change this template use File | Settings | File Templates.
 */
class SharedAtomicValue {
  static AtomicInteger ai = new AtomicInteger(0);
    /*static Integer ai = new Integer(0);

    static Integer setInteger(Integer i)
    {
        ai = i;
        return ai;
    }*/
}
