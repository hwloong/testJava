package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;





public class TestArray {

	public static void main(String[] args) {
		//HashSet<Person> set = new HashSet<Person>();
		List<Person> list = new ArrayList<Person>();
		Person p1 = new Person("张三",25);
		Person p2 = new Person("李四",19);
		Person p3 = new Person("王五",21);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list);
		System.out.println(list.size());
		System.out.println(list);
	}
}
