package com.entity;

public class P2over implements Runnable{
	public static boolean stop = false;
	public P2over(){
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true){
			while(stop){
				new TestMusic("music/P2½áÊø.wav");
				stop = false;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
