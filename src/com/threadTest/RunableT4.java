package com.threadTest;

public class RunableT4 implements Runnable{

	private int i = 0;
	
	public int getI() {
		return local.get();
	}

	public void setI(int i) {
		local.set(i);
		this.i = local.get();
	}

	public ThreadLocal<Integer> local = new ThreadLocal<Integer>();
	
	

	@Override
	public void run() {
		System.out.println(i);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		RunableT4 r = new RunableT4();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
			t1.start();
			r.setI(9);
			t2.start();
	}
}
