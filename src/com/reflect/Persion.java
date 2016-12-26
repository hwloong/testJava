package com.reflect;

public class Persion implements IPsrsion{

	public Persion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persion(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}

	private String userName;
	
	private int age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Persion [userName=" + userName + ", age=" + age + "]";
	}

	@Override
	public void say() {
		toString();
	}
	
	
}
