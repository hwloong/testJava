package com.annotationtest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.makedata.Makedata;

public class AnnotationTest {

	//@Test
	public void test(){
		try {
			Class c = Class.forName("com.annotationtest.Person");
			Field[] fields = c.getDeclaredFields();
			List<Object> fieldList = new ArrayList<Object>();
			for(Field f : fields){
				FieldAnnotation fa = f.getAnnotation(FieldAnnotation.class);
				System.out.println(fa.value() + fa.sort());
				fieldList.add(new Object[]{fa,f});
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		try {
			List<Person> list = Makedata.makeListdata(Person.class,10);
			for(Person lp : list){
				Field[] lpFields = lp.getClass().getDeclaredFields();
				for(Field f : lpFields){
					FieldAnnotation fa = f.getAnnotation(FieldAnnotation.class);
					if(fa.sort() > 0){
						lp.setUserName(lp.getUserName().toUpperCase());
					}
				}
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
