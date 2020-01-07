package com.practice.threads.JavaConcurrency6;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Anand Ram
 * Date: Mar 18, 2010
 * Time: 8:21:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashMapDemo
{
    private static Map<String,String> hm = new HashMap<String,String>();

    static
    {
        hm.put("1", "One");
        hm.put("2", "Two");
        hm.put("3", "Three");
    }

    public static void main(String args[])
    {
        Set<Map.Entry<String,String>> vs = hm.entrySet();
        Iterator it = vs.iterator();

        for(Map.Entry<String,String> me : vs)
        {
            System.out.print(me.getKey() + " : ");
            System.out.println(me.getValue());

        }
    }



}
