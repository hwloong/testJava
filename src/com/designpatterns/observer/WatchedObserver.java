package com.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;



public class WatchedObserver implements IWatched{

	private List<IWatcher> list = new ArrayList();
	
	@Override
	public void addObserver(IWatcher w) {
		list.add(w);
	}

	@Override
	public void removeObserver(IWatcher w) {
		list.remove(w);
		
	}

	@Override
	public void notifyObserver(String str) {
		for(IWatcher w : list){
			w.update(str);
		}
		
	}

}
