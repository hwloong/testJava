package com.designpatterns.factory.factory1;

import org.junit.Test;

public class FlyFactory {

	public AnythingFly produce(String str){
		if("bird".equals(str)){
			return new Bird();
		}else if("plane".equals(str)){
			return new Plane();
		}else{
			return null;
		}
	}
	
	public AnythingFly produceBird(){
		return new Bird();
	}
	
	public AnythingFly producePlane(){
		return new Plane();
	}
	
	public static AnythingFly produceBird1(){
		return new Bird();
	}
	
	public static AnythingFly producePlane1(){
		return new Plane();
	}
	
	
	//@Test
	//简单工厂模式
	public void test() {
		FlyFactory f = new FlyFactory();
		AnythingFly af = f.produce("bird");
		af.fly();
	}
	
	//@Test
	//工厂方法
	public void test1() {
		FlyFactory f = new FlyFactory();
		AnythingFly af = f.produceBird();
		af.fly();
	}
	
	@Test
	//静态工厂方法
	public void test2() {
		AnythingFly af = FlyFactory.produceBird1();
		af.fly();
	}
}
