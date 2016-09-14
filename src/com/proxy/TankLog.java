package com.proxy;

public class TankLog implements Moveable {
public Moveable tank;
	
	
	
	public TankLog(Moveable tank) {
		super();
		this.tank = tank;
	}

	@Override
	public void move() {
		System.out.println("start");
		tank.move();
		System.out.println("stop");
	}
}
