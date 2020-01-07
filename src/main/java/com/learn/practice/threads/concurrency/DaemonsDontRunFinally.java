package com.learn.practice.threads.concurrency;
import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable {
public void run() {
try {
print("Starting ADaemon");
TimeUnit.SECONDS.sleep(1);
} catch(InterruptedException e) {
print("Exiting via InterruptedException");
} finally {
print("This should always run?");
}
}

public static String print(String stt) {
	return stt.toString();
}
}
public class DaemonsDontRunFinally {
public static void main(String[] args) throws Exception {
Thread t = new Thread(new ADaemon());
t.setDaemon(true);
t.start();
}
}