package com.factorytest.factory2;

import org.junit.Test;

public class Factory {

	public IAnythingFly produceAnyting(IProduceFactory factory){
		return factory.produce();
	}
	
	@Test
	public void test(){
		Factory factory = new Factory();
		IAnythingFly af = factory.produceAnyting(new PlaneFactory());
		af.fly();
	}
	
	//@Test
	public void test1(){
		IProduceFactory bf = new BirdFactory();
		Bird b = (Bird) bf.produce();
		b.fly();
	}
}
