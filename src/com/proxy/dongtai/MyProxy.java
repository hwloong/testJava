package com.proxy.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {

	public Object target;
	
	
	
	public MyProxy(Object target) {
		super();
		this.target = target;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before");
		method.invoke(target, args);
		System.out.println("after");
		return null;
	}

}
