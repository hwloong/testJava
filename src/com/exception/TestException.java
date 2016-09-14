package com.exception;

public class TestException {
	public static void main(String[] args) {
		
		System.out.println(new TestException().test1());
		
	}
	
	private  int test1(){
		try {
			System.out.println("try");
			//int i = 1/0;
			return 1;
		} catch (Exception e) {
			
			System.out.println("catch");
			return 3;
		}finally{
			System.out.println("finally");
			//return 4;
		}
		//return 2;
	}
}
