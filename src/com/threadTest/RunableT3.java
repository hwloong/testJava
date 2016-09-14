package com.threadTest;

public class RunableT3 implements Runnable{

	Test4 test4 = new Test4();
	@Override
	public void run() {
		test4.desploy(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		RunableT3 r = new RunableT3();
		
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		th1.setName("th1");
		th2.setName("th2");
		th1.start();
		th2.start();
	}

}

class Test4{
	Test2 test2 = new Test2();
	Test3 test3 = new Test3();
	public void desploy(String name){
		if("th1".equals(name)){
			synchronized (test2) {
				test2.add(name);
				System.out.println(name + " test2 synchronized");
			}
		}
		if("th2".equals(name)){
			synchronized (test3) {
				test3.add(name);
				System.out.println(name + " test3 synchronized");
			}
		}
	}
}

class Test2{
	
	public  void add(String name){
		System.out.println("Test2");
	}
}

class Test3{
	
	public  void add(String name){
		System.out.println("Test3");
	}
}