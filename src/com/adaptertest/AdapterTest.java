package com.adaptertest;

import org.junit.Test;

public class AdapterTest {

	@Test
	public void test(){
		ITarget target = new Adepter();
		
		ITarget target1 = new ConcreteTarget();
		
		target.request();
		target1.request();
	}
}
