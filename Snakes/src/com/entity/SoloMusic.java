package com.entity;

import com.thread.solo.SoloMoveThread;

public class SoloMusic implements Runnable{
	public SoloMusic(){
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true){
			while(SoloMoveThread.music){
				new TestMusic("music/µ•»ÀΩ· ¯.wav");
				SoloMoveThread.music = false;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
