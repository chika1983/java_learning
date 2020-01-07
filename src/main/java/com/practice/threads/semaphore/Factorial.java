package com.practice.threads.semaphore;

import java.util.concurrent.Callable;

// Compute the factorial of a number and return
// the result.
class Factorial implements Callable<Long> {
  long num;

  Factorial(long v) { num = v; }

  public Long call() {
    long fact = 1;

    for(int i = 2; i <= num; i++) {
      fact *= i;
    }

    return fact;
  }
}