package com.learn.practice.threads.concurrency;
class InnerThread2 {
private int countDown = 5;
private Thread t;

public String print(Thread t) {
	return Thread.currentThread().getName() + t.toString();
}
public String print(String stt) {
	return stt;
}

public InnerThread2(String name) {
t = new Thread(name) {
public void run() {
try {
while(true) {
print(this);
if(--countDown == 0) return;
sleep(10);
}
} catch(InterruptedException e) {
	
	print("sleep() interrupted");
}
}
public String toString() {
return getName() + ": " + countDown;
}
};
t.start();
}
}