package com.learn.practice.threads.concurrency;

class Daemon implements Runnable {
private Thread[] t = new Thread[10];
public void run() {
for(int i = 0; i < t.length; i++) {
t[i] = new Thread(new DaemonSpawn());
t[i].start();
printnb("DaemonSpawn " + i + " started, ");
}
for(int i = 0; i < t.length; i++)
printnb("t[" + i + "].isDaemon() = " +
t[i].isDaemon() + ", ");
while(true)
Thread.yield();
}

public static String printnb(String stt) {
	return stt.toString();
}
}