package com.designpatterns.adaptertest;

public class Adepter extends Adaptee implements ITarget{

	@Override
	public void request() {
		super.specificRequest();
	}
}
