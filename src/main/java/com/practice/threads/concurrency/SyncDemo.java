package com.practice.threads.concurrency;
// Demonstrate that a synchronized method prevents
// multiple threads from accessing a shared object
// at the same time.
class SyncDemo {
  public static void main(String args[]) {

    // Construct one Prompter object.
    Prompter p = new Prompter(3);

    // Construct two threads that use p. Thus, both threads
    // will attempt to use p at the same time. However, because
    // display() is synchronized, only one at a time can use p.
    UsePrompter promptA = new UsePrompter(p, "One Two Three Four");
    UsePrompter promptB = new UsePrompter(p, "Left Right Up Down");
  }
}