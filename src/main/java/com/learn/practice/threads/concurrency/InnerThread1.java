package com.learn.practice.threads.concurrency;

// Using a named inner class:
class InnerThread1 {
private int countDown = 5;
private Inner inner;
private class Inner extends Thread {
Inner(String name) {
super(name);
start();
}
public void run() {
try {
while(true) {
print(this);
if(--countDown == 0) return;
sleep(10);
}
} catch(InterruptedException e) {
print("interrupted");
}
}
public String toString() {
return getName() + ": " + countDown;
}

public String print(Thread t) {
	return Thread.currentThread().getName() + t.toString();
}
public String print(String stt) {
	return stt;
}
}
public InnerThread1(String name) {
inner = new Inner(name);
}

}