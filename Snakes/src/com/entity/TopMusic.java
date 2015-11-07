package com.entity;


public class TopMusic implements Runnable {
	public static boolean music = true;
	public TopMusic(){
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(music){
				new TestMusic("music/Ö÷½çÃæ.wav");
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
