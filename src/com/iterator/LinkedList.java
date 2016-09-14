package com.iterator;

public class LinkedList {

	private int index = 0;
	
	private Node head = null;
	
	private Node tail = null;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void add(Object o){
		Node n = new Node(o,null);
		if(head == null){
			head = n;
			tail = n;
		}
		tail.setNextNote(n);
		tail = n;
		index ++;
		
	}
	
}
