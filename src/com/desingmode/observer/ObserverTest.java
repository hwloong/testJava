package com.desingmode.observer;

import org.junit.Test;

public class ObserverTest {

	@Test
	public void testObserver(){
		WatchedObserver gril = new WatchedObserver();
		WatcherGril g1 = new WatcherGril();
		WatcherGril g2 = new WatcherGril();
		WatcherGril g3 = new WatcherGril();
		gril.addObserver(g1);
		gril.addObserver(g2);
		gril.addObserver(g3);
		gril.notifyObserver("笑");
	}
}
