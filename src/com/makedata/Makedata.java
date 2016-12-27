package com.makedata;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Makedata {

	
	public static <E> List<E> makeListdata(Class<?> cla ,int listSize){
		List<E> list = new ArrayList<E>();
		try {
			Field[] fields = cla.getDeclaredFields();
			for(int i = 0 ; i < listSize ; i ++){
				E e = (E) cla.newInstance();
				for(Field f : fields){ 
					Method method = cla.getMethod("set"+StringUtils.capitalize(f.getName()),f.getType());
					method.invoke(e, i+"");
				}
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
