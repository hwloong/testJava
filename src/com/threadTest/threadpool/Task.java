package com.threadTest.threadpool;

public class Task implements Runnable {

	private String threadName;

	public Task(String threadName) {
		super();
		this.threadName = threadName;
	}

	@Override
	public void run() {
		System.out.println(threadName +" :" +Thread.currentThread().getName());
		try {
			//Thread.sleep(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
