package com.factorytest.factory2;

import org.junit.Test;


public class BirdFactory implements IProduceFactory{

	@Override
	public Bird produce() {
		return new Bird();
	}
}
