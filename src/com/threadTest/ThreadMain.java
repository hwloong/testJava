package com.threadTest;

public class ThreadMain {

	public static void main(String[] args) {
		ThreadT1 t = new ThreadT1("t1");
		//Thread t = new Thread(new RunabletT1("t1"));
		t.start();
		for(int i = 0 ; i < 200 ; i++){
			System.out.println("main");
		}
	}
}
