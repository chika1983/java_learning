package com.practice.threads.concurrency;
// Demonstrate synchronized methods.

// A very simple teleprompter that sleeps one or more seconds
// between words.
class Prompter {
  int delay; // number of seconds to delay between words

  Prompter(int d) {
    if(d <= 0) d = 1;
    delay = d;
  }

  // Because display() is synchronized, only one
  // thread at a time can use it.  This prevents
  // different messages from getting mixed up.
  synchronized void display(String msg) {

    for(int i=0; i < msg.length(); i++) {
      System.out.print(msg.charAt(i));

      if(Character.isWhitespace(msg.charAt(i))) {
        try {
          Thread.sleep(delay*1000);
        } catch(InterruptedException exc) {
          return;
        }
      }
    }
    System.out.println();
  }
}

// A thread that uses a Prompter.
class UsePrompter implements Runnable {
  Prompter prompter; // the Prompter to use
  String message; // the message to display

  UsePrompter(Prompter p, String msg) {
    prompter  = p;
    message = msg;

    // Create and start running thread.
    new Thread(this).start();
  }

  // Use prompter to show the message.
  public void run() {
    prompter.display(message);
  }
  
  /*
  public void run() {
	  // Use a synchronized block to manage access to prompter.
	  synchronized(prompter) {
	    prompter.display(message);
	  }
	}
  */
}

