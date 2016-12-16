package com.designpatterns.factory.factory2;

public class PlaneFactory implements IProduceFactory {

	@Override
	public IAnythingFly produce() {
		
		return new Plane();
	}

}
