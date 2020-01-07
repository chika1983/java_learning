package com.practice.threads.concurrency;

import java.util.GregorianCalendar;

class ReminderDemo {
  public static void main(String args[]) {
    // Get a reminder 2 seconds from now.
    Reminder mt = new Reminder("Call Harry", 2); 

    // Get a reminder on April 5, 2007 at 2:30 pm.
    Reminder mt2 = new Reminder("Meet with Bill",
                     new GregorianCalendar(2009, 5, 20, 22, 04)); 

    // Keep the main thread alive for 20 seconds.
    for(int i=0; i < 50; i++) {
      try {
        Thread.sleep(1000);
      }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
      System.out.print(".");
    }

    System.out.println("\nMain thread ending.");
  }
}