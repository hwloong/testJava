package com.designpatterns.singleton;

public class Singleton1 {

	
	 private Singleton1() {  
	    }  
	  
	    /* 此处使用一个内部类来维护单例 */  
	    private static class SingletonFactory {  
	        private static Singleton1 instance = new Singleton1();  
	    }  
	  
	    /* 获取实例 */  
	    public static Singleton1 getInstance() {  
	        return SingletonFactory.instance;  
	    }  
	    
	    public static void main(String[] args) {
	    	System.out.println(Singleton1.getInstance());
	    	System.out.println(Singleton1.getInstance());
	    	System.out.println(Singleton1.getInstance());
		}
}
