package com.desingmode.observer;
/**
 * 抽象主题角色，watched：被观察
 * @author Think
 *
 */
public interface Watched {

	public void addObserver(Watcher w);
	
	public void removeObserver(Watcher w);
	
	public void notifyObserver(String str);
}
