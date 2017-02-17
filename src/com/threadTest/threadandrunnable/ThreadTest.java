package com.threadTest.threadandrunnable;

public class ThreadTest extends Thread {

	private int ticket = 10;

	public void run() {
		for (int i = 0; i < 20; i++) {
			if (this.ticket > 0) {
				System.out.println("卖票：ticket" + this.ticket--);
			}
		}
	}
	
	@org.junit.Test
	public void Test(){
		ThreadTest t = new ThreadTest();
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		t.start();
		t1.start();
		t2.start();
	}
}
