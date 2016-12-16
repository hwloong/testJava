package com.designpatterns.observer;
/**
 * 抽象主题角色，watched：被观察
 * @author Think
 *
 */
public interface IWatched {

	public void addObserver(IWatcher w);
	
	public void removeObserver(IWatcher w);
	
	public void notifyObserver(String str);
}
