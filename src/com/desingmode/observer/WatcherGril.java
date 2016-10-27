package com.desingmode.observer;

public class WatcherGril implements Watcher {

	private String name;
	
	
	public WatcherGril(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void update(String str) {
		System.out.println("name:" + name +"观察到" + str);
	}

}
