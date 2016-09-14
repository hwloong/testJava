package com.iterator;

public class Node {

	public Node(Object obj, Node nextNote) {
		super();
		this.obj = obj;
		this.nextNote = nextNote;
	}

	private Object obj;
	
	private Node nextNote;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Node getNextNote() {
		return nextNote;
	}

	public void setNextNote(Node nextNote) {
		this.nextNote = nextNote;
	}
}
