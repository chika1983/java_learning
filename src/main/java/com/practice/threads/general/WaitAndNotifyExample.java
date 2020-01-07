package com.practice.threads.general;

public class WaitAndNotifyExample 
{
	class StackPusher extends StackUser 
	{ // Stack Pusher

		StackPusher(String threadName, StackClass stack) 
		{
			super(threadName, stack);
		}
		public void run() 
		{
			while (true) {
				stack.push(new Integer(1));
			}
		}
	}
	
	class StackPopper extends StackUser 
	{ // Stack Popper

		StackPopper(String threadName, StackClass stack) 
		{
			super(threadName, stack);
		}
		public void run() 
		{
			while (true) {
				stack.pop();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		WaitAndNotifyExample wne = new WaitAndNotifyExample();
		
		// TODO Auto-generated method stub
		StackClass stack = new StackClass(5);
		wne.new StackPusher("One", stack);
		wne.new StackPusher("Two", stack);
		wne.new StackPopper("Three", stack);
		
		System.out.println("Main Thread sleeping.");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exit from Main Thread.");

	}

}
