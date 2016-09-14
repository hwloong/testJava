package com.threadTest.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ThreadPoolTest {

	@Test
	public void testFixedThreadPool(){
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Runnable t = new Task("t");
		Runnable t1 = new Task("t1");
		Runnable t2 = new Task("t2");
		pool.execute(t);
		pool.execute(t1);
		pool.execute(t2);
		pool.shutdown();
	}
	
	@Test
	public void testSingleThreadExecutor(){
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Runnable t = new Task("t");
		Runnable t1 = new Task("t1");
		Runnable t2 = new Task("t2");
		pool.execute(t);
		pool.execute(t1);
		pool.execute(t2);
		pool.shutdown();
	}
	
	@Test
	public void testCachedThreadPool(){
		ExecutorService pool = Executors.newCachedThreadPool();
		Runnable t = new Task("t");
		Runnable t1 = new Task("t1");
		Runnable t2 = new Task("t2");
		Runnable t3 = new Task("t3");
		Runnable t4 = new Task("t4");
		Runnable t5 = new Task("t5");
		Runnable t6 = new Task("t6");
		pool.execute(t);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3); 
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.shutdown();
	}
}
