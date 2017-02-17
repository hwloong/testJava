package com.threadTest.threadandrunnable;

import org.junit.Test;

public class RunnableTest implements Runnable {

	private  int ticket = 100000;
	private  int saleTicket = 0;
	static RunnableTest t = new RunnableTest();
	public static void sale(){
		
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			if (ticket > 0) {
				saleTicket++;
				System.out.println(Thread.currentThread().getName() + "卖票：ticket" + ticket-- + " " + saleTicket);
			}
		}
	}
	
	@Test
	public void test(){
		//RunnableTest t = new RunnableTest();
		Thread t1 = new Thread(t,"t1");
		Thread t2 = new Thread(t,"t2");
		Thread t3 = new Thread(t,"t3");
		t1.start();
		
		t2.start();
		
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		System.out.println(t.ticket);
		System.out.println(t.saleTicket);
	}

}
