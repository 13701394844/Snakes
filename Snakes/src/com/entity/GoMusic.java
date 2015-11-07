package com.entity;

public class GoMusic implements Runnable{
	public static boolean stop = false;
	public GoMusic(){
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true){
			while(stop){
				new TestMusic("music/321.wav");
				stop = false;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
