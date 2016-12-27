package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
	
	@Test
	public void test4(){
		Class c = null;
		try {
			c = Class.forName("com.reflect.Persion");
			Object obj = (Persion) c.newInstance();
			  //获取所有的属性?  
            Field[] fs = c.getDeclaredFields(); 
            for(Field f : fs){
            	System.out.println(Modifier.toString(f.getModifiers())+" "+f.getType().getSimpleName() + " " + f.getName());//修饰符
            }
            //获取所以的方法
            Method methodAll[] = c.getDeclaredMethods();
            for(Method m : methodAll){
            	System.out.print(m.getReturnType().getSimpleName()+" "+m.getName() +" (");
            	Class param[] = m.getParameterTypes();
            	for(Class p : param){
            		System.out.print(p.getSimpleName() + " arg");
            	}
            	System.out.println(")");
            }
            //调用某个类的方法
            Method method = c.getMethod("setUserName",String.class);
            method.invoke(obj, "Test");
            System.out.println(obj.toString());
            //对属性赋值
            Field field = c.getDeclaredField("userName");
            field.setAccessible(true);
            field.set(obj, "TOM");
            System.out.println(obj.toString());
            //使用动态代理
            
            
            
            
            //调用某个类的方法
            Method method1 = c.getMethod("getUserName",String.class);
            method.invoke(obj,"");
            System.out.println(obj.toString());
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
