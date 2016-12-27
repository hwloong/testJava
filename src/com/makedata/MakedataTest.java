package com.makedata;

import java.util.List;

import org.junit.Test;

import com.excle.Person;



public class MakedataTest {

	@Test
	public void test(){
		Makedata md = new Makedata();
		List list = md.makeListdata(Person.class,2);
	}
}
