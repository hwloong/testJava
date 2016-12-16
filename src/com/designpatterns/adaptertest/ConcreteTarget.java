package com.designpatterns.adaptertest;

public class ConcreteTarget implements ITarget {

	public void request() {
		System.out.println("普通类 具有 普通功能...");
	}

}
