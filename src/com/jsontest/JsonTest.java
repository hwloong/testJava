package com.jsontest;

import org.junit.Test;

import com.excle.Person;
import com.google.gson.Gson;

public class JsonTest {

	@Test
	public void testJson(){
		Gson gson = new Gson();
		Person p = new Person();
		p.setName("TOM");
		p.setAge("20");
		p.setMobile("18688888888");
		String str = gson.toJson(p);
		System.out.println(str);
		Person p1 = gson.fromJson(str, Person.class);
		System.out.println(p1.toString());
	}
}
