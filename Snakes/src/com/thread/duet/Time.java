package com.thread.duet;

import java.util.Random;

import com.windows.DuetWindow;

public class Time implements Runnable {
	public static boolean p1 = false;
	public static boolean p2 = false;
	Random random = new Random();
	public Time(){
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true){
			if(p1){
				switch(random.nextInt(3)){
				case 0:
					P1.snake.setSleep(100);
					DuetWindow.jiasup1.setVisible(true);
					try {
						Thread.sleep(7000);
						DuetWindow.jiasup1.setVisible(false);
						P1.snake.setSleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 1:
					P2.snake.setSleep(400);
					DuetWindow.jiansup2.setVisible(true);
					try {
						Thread.sleep(7000);
						DuetWindow.jiansup2.setVisible(false);
						P2.snake.setSleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					P1.snake.setSleep(400);
					DuetWindow.jiansup1.setVisible(true);
					try {
						Thread.sleep(7000);
						DuetWindow.jiansup1.setVisible(false);
						P1.snake.setSleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				p1 = false;
			}
			if(p2){
				switch(random.nextInt(3)){
				case 0:
					P2.snake.setSleep(100);
					DuetWindow.jiasup2.setVisible(true);
					try {
						Thread.sleep(7000);
						DuetWindow.jiasup2.setVisible(false);
						P2.snake.setSleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 1:
					P2.snake.setSleep(400);
					DuetWindow.jiansup2.setVisible(true);
					try {
						Thread.sleep(7000);
						DuetWindow.jiansup2.setVisible(false);
						P2.snake.setSleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case 2:
					P1.snake.setSleep(400);
					DuetWindow.jiansup1.setVisible(true);
					try {
						Thread.sleep(7000);
						DuetWindow.jiansup1.setVisible(false);
						P1.snake.setSleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				p2 = false;
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
