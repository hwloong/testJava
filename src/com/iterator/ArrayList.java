package com.iterator;

import sun.org.mozilla.javascript.internal.ObjArray;

public class ArrayList {

	private int index = 0;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	private Object[] obj = new Object[10];
	public void add(Object o){
		if(index == obj.length ){
			Object[] newObj = new Object[index * 2];
			System.arraycopy(obj, 0, newObj, 0, obj.length);
			obj = newObj;
		}
		obj[index] = o;
		++index;
	}
}
