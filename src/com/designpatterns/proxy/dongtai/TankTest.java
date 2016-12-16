package com.designpatterns.proxy.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TankTest {

	public static void main(String[] args) {
		Moveable m = new Tank();
		InvocationHandler myInvocationHandler = new MyProxy(m);
		Moveable moveableProxy = (Moveable) Proxy.newProxyInstance(m.getClass().getClassLoader(), m.getClass().getInterfaces(), myInvocationHandler);
		moveableProxy.move();
	}
}
