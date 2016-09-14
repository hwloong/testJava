package com.extendscalss;

public class Dog extends Animal{
	
	public void run(){
		System.out.println("run");
	}
	
	public void eat(){
		System.out.println("dog eat");
	}
	
	public static void main(String[] args) {
		Animal a = new Dog();
		a.eat();
		
		Dog d = (Dog)a;
		d.eat();
	}

}
