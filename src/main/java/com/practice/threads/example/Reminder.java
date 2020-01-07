package com.practice.threads.example;
// A simple reminder class that runs as a daemon thread.
//
// To use Reminder, pass in the message to display
// and then specify either a delay from the current
// time, or the future time that you want to have
// the reminder message displayed.
//
// If the application that creates a Reminder
// ends before the target time, then the
// Reminder thread is automatically terminated.

import java.util.*;

// A simple implementation of a "reminder" class.
// An object of this class starts a daemon thread
// that waits until the specified time. It then
// displays a message.
class Reminder implements Runnable {

  // Time and date to display reminder message.
  Calendar reminderTime;

  // Message to display.
  String message; // message to display

  // Use this constructor to display a message after
  // a specified number of seconds have elapsed.
  // This value is then added to the current time
  // to compute the desired reminder time.
  //
  // In practice, you might want to change the
  // delay to minutes rather than seconds, but
  // seconds make testing easier.
  Reminder(String msg, int delay) {

    message = msg;

    // Get the current time and date.
    reminderTime = Calendar.getInstance();

    // Add the delay to the time and date.
    reminderTime.add(Calendar.SECOND, delay);

    System.out.printf("Reminder set for %tD %1$tr\n", reminderTime);

    // Create the reminder thread.
    Thread dThrd = new Thread(this);

    // Set to daemon.
    dThrd.setDaemon(true);

    // Start execution.
    dThrd.start();
  }

  // Notify at the specified time and date.
  Reminder(String msg, Calendar cal) {

    message = msg;

    // Use the specified time and date as the
    // reminder time.
    reminderTime = cal;

    System.out.printf("Reminder set for %tD %1$tr\n", reminderTime);

    // Create the reminder.
    Thread dThrd = new Thread(this);

    // Set to daemon.
    dThrd.setDaemon(true);

    // Start execution.
    dThrd.start();
  }

  // Run the reminder.
  public void run() {

    try {

      for(;;) {
        // Get the current time and date.
        Calendar curTime = Calendar.getInstance();

        // See if it's time for the reminder.
        if(curTime.compareTo(reminderTime) >= 0) {
          System.out.println("\n" + message + "\n");
          break; // let the thread end
        }

        Thread.sleep(1000);
      }
    }
    catch(InterruptedException exc) {
      System.out.println("Reminder interrupted.");
    }
  }
}

