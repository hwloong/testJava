package com.threadTest.producerConsumer;

public class Consumer implements Runnable{

	private Warehouse w ;

	public Consumer(Warehouse w) {
		super();
		this.w = w;
	}

	@Override
	public void run() {
		//for(int i = 0 ; i < 5 ; i ++){
		while(true){
			Product p = w.pop();
			System.out.println("消费产品" + p + ",剩余数量：" +w.getIndex());
		}
		
	}
	
}
