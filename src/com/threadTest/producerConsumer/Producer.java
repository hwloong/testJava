package com.threadTest.producerConsumer;

public class Producer implements Runnable{

	private Warehouse w ;
	
	public Producer(Warehouse w) {
		super();
		this.w = w;
	}

	@Override
	public void run() {
		//for(int i = 0 ; i < 5 ; i ++){
		int i = 0;
		while(true){	
			Product p = new Product(i,"产品" + i++);
			w.push(p);
			System.out.println("生产产品："+p + ",剩余数量：" +w.getIndex());
		}
		
	}

	
}
