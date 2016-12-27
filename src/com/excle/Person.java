package com.excle;

import com.excle.useannotatoin.ExcelAnnotation;

public class Person {

	@ExcelAnnotation(title = "姓名")
	private String name;
	
	@ExcelAnnotation(title = "年龄")
	private String age;
	
	@ExcelAnnotation(title = "手机号")
	private String mobile;
	
	@ExcelAnnotation(title = "地址")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", mobile=" + mobile + ", address=" + address + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
