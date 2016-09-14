package com.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;
public class TestRefect {

	@Test
	public void t1(){
		Persion p = new Persion();
		disploy(p.getClass().getName());
	}
	
	@Test
	public void t2() throws ClassNotFoundException{
		//获取Class 类
		//1
		Class c1 = Class.forName("com.reflect.Persion");
		//2
		Class c2 = Persion.class;
		//c3
		Class c3 = new Persion().getClass();
		disploy(c1.getName());
		disploy(c2.getName());
		disploy(c3.getName());
	}
	
	@Test
	public void t3() {
		//通过Class实例化其他类的对象
		try {
			Class c1 = Class.forName("com.reflect.Persion");
			//无参构造函数
			Persion p = (Persion) c1.newInstance();
			disployObject(p);
			//有参构造函数
			Constructor con = c1.getConstructor(String.class,int.class);
			Persion p1 = (Persion) con.newInstance("Tom",12);
			disployObject(p1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	public void disploy(String str){
		System.out.println(str);
	}
	
	public void disployObject(Object p){
		System.out.println(p);
	}
}
