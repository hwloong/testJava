package com.util;

import java.util.Date;

import org.junit.Test;

public class DataUtil {

	@Test
	public void test(){
		Long d1 = new Date().getTime();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long d2 = new Date().getTime();
		System.out.println(d2-d1);
	}
}
