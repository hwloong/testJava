package com.desingmode.observer;

import java.util.ArrayList;
import java.util.List;



public class WatchedObserver implements Watched{

	private List<Watcher> list = new ArrayList();
	
	@Override
	public void addObserver(Watcher w) {
		list.add(w);
	}

	@Override
	public void removeObserver(Watcher w) {
		list.remove(w);
		
	}

	@Override
	public void notifyObserver(String str) {
		for(Watcher w : list){
			w.update(str);
		}
		
	}

}
