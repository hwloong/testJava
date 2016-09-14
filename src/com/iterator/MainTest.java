package com.iterator;

public class MainTest {
	public static void main(String[] args) {
		/*ArrayList al = new ArrayList();
		for(int i = 0 ; i < 20 ; i++){
			Cat c = new Cat();
			c.setId(i);
			al.add(c);
		}
		System.out.println(al.getIndex());*/
		
		LinkedList al = new LinkedList();
		for(int i = 0 ; i < 10 ; i++){
			Cat c = new Cat();
			c.setId(i);
			al.add(c);
		}
		System.out.println(al.getIndex());
	}
}
