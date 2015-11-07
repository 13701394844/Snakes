package com.thread.duet;

import com.entity.TestMusic;

public class Bing implements Runnable {
	public static boolean BingStop = true;
	public Bing(){
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(BingStop){
				if(P1.bing == 1){
					new TestMusic("music/µ¯×²ÒôÐ§.wav");
					P1.bing = 0;
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
}
