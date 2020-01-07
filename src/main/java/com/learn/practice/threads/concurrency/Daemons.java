package com.learn.practice.threads.concurrency;

import java.util.concurrent.TimeUnit;

public class Daemons {
public static void main(String[] args) throws Exception {
Thread d = new Thread(new Daemon());
d.setDaemon(true);
d.start();
printnb("d.isDaemon() = " + d.isDaemon() + ", ");
// Allow the daemon threads to
// finish their startup processes:
TimeUnit.SECONDS.sleep(1);
}

public static String printnb(Thread t) {
	return Thread.currentThread().getName() + t.toString();
}
public static String printnb(String stt) {
	return stt;
}
}