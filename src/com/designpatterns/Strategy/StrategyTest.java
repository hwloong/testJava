package com.designpatterns.Strategy;

import org.junit.Test;

public class StrategyTest {

	@Test
	public void test(){
		BusinessContext bc = new BusinessContext(new BusinessA());
		bc.doAnything();
	}
}
