package com.propertytest;

import org.junit.Test;

import com.util.PropertyUtil;

public class ProPertyTest {

	@Test
	public void test(){
		String url = PropertyUtil.getStrValue("redis.properties", "jdbc.url", "");
		System.out.println(url);
	}
}
