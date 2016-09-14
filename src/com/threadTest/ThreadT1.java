package com.threadTest;

public class ThreadT1 extends Thread{

	private String name;
	
	public ThreadT1(String name) {
		super();
		this.name = name;
	}
	public void run(){
		System.out.println("ThreadT1");
	}
}
