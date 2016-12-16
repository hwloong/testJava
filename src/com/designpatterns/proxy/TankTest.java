package com.designpatterns.proxy;

public class TankTest {
	public static void main(String[] args) {
		Tank t = new Tank();
		TankTime tt = new TankTime(t);
		TankLog l = new TankLog(tt);
		
		l.move();
	}
}
