package com.designpatterns.observer;

import org.junit.Test;

public class ObserverTest {

	@Test
	public void testObserver(){
		WatchedObserver gril = new WatchedObserver();
		WatcherGril g1 = new WatcherGril("g1");
		WatcherGril g2 = new WatcherGril("g2");
		WatcherGril g3 = new WatcherGril("g3");
		gril.addObserver(g1);
		gril.addObserver(g2);
		gril.addObserver(g3);
		gril.notifyObserver("笑");
	}
}
