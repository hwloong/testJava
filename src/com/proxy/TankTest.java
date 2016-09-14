package com.proxy;

public class TankTest {
	public static void main(String[] args) {
		Tank t = new Tank();
		TankLog l = new TankLog(t);
		TankTime tt = new TankTime(l);
		tt.move();
	}
}
