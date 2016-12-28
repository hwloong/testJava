package com.redistest;

import org.junit.Test;

public class RedisTest1 {

	@Test
	public void test(){
		System.out.println(RedisUtil.getJedis());
	}
}
