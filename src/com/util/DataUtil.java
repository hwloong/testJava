package com.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DataUtil {

	@Test
	public void test(){
		/*Long d1 = new Date().getTime();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long d2 = new Date().getTime();
		System.out.println(d2-d1);*/
		Calendar asd = Calendar.getInstance();
		asd.setTime(new Date());
		System.out.println(asd.get(Calendar.MONTH));;
		asd.add(Calendar.MONTH, 1);
		System.out.println(DateUtils.date2Str(asd.getTime(), "yyyy-MM-dd"));
		
	}
}
