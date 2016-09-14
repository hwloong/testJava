package com.threadTest.producerConsumer;

public class Warehouse {

	private int index;
	
	private Product[] product = new Product[1000];
	
	public synchronized void push(Product p){
		if(index == 1000){
			System.exit(0);
		}
		while(index == product.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		product[index] = p;
		index ++ ;
	}
	
	public synchronized Product pop(){
		while(index == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index-- ;
		return product[index];
	}
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static void main(String[] args) {
		Warehouse w = new Warehouse();
		new Thread(new Producer(w)).start();
		new Thread(new Consumer(w)).start();
	}
}
