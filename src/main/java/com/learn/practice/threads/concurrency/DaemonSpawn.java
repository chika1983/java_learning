package com.learn.practice.threads.concurrency;
class DaemonSpawn implements Runnable {
public void run() {
while(true)
Thread.yield();
}
}