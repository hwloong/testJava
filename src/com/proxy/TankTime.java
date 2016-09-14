package com.proxy;

public class TankTime implements Moveable{

	public Moveable tank;
	
	
	
	public TankTime(Moveable tank) {
		super();
		this.tank = tank;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		tank.move();
		long end = System.currentTimeMillis();
		System.out.println("time : " + (end - start));
	}
}
