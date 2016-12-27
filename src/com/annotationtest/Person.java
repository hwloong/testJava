package com.annotationtest;

public class Person {

	@FieldAnnotation(title="姓名",sort = 1)
	private String userName;
	
	@FieldAnnotation(title="年龄",sort = 2)
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
		return "Person [userName=" + userName + ", age=" + age + "]";
	} 
	
	
}
