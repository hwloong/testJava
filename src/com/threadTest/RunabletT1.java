package com.threadTest;

public class RunabletT1 implements Runnable{

	private String name;
	
	public RunabletT1(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 200 ; i++){
			System.out.println("RunabletT1");
		}
		
	}

	
}
