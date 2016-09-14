package com.proxy;

import java.util.Random;

public class Tank implements Moveable {

	@Override
	public void move() {
		System.out.println("move.....");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
