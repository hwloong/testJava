package com.threadTest;

public class RunableT2 implements Runnable{

	int b = 0;
	public void run() {
		add(Thread.currentThread().getName());
	}
	
	public synchronized void add(String name){
		b = 1000;
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("name = " + name +  "   b = " + b);
	}
	
	public synchronized void add1(String name){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b = 2000;
		System.out.println("name = " + name +  "   b = " + b);
		
	}
	
	public static void main(String[] args) {
		RunableT2 r = new RunableT2();
		Thread th1 = new Thread(r);
		th1.setName("th1");
		th1.start();
		r.add1("ttttt");
		System.out.println(r.b);
	}

}


