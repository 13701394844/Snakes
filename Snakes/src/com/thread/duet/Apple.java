package com.thread.duet;

import java.util.Random;

import com.entity.Snake;
import com.windows.DuetWindow;

public class Apple implements Runnable{
	private Snake random;
	public static boolean daoJiShi = true;
	public static boolean AppleStop = true;
	DuetWindow duetWindow;
	Integer ni = 3;
	public Apple(Snake random,DuetWindow duetWindow){
		this.random = random;
		this.duetWindow = duetWindow;
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		Random r = new Random();
		int x = r.nextInt(29)*20+210;
		int y = r.nextInt(23)*20+88;
		int i = r.nextInt(4);
		random.setLocation(x, y);
		int timer = 0;
		while(true){
			
			while(AppleStop){
				if(daoJiShi){
					for(int j = 0;j<3;j++){
						duetWindow.daoJiShi.setText(ni.toString());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						--ni;
					}
					ni = 3;
					duetWindow.daoJiShi.setText(ni.toString());
					duetWindow.daoJiShi.setVisible(false);
					daoJiShi = false;
				}
				if(timer >7){
					i = r.nextInt(4);
					timer = 0;
				}
				switch(i){
				//ио
				case 0:
					random.setLocation(random.getX(), random.getY()-20);
					if(random.getY() < 108){
						i=1;
					}
					break;
					//об
				case 1:
					random.setLocation(random.getX(), random.getY()+20);
					if(random.getY() > 528){
						i=0;
					}
					break;
					//вС
				case 2:
					random.setLocation(random.getX()-20, random.getY());
					if(random.getX() < 230){
						i=3;
					}
					break;
					//ср
				case 3:
					random.setLocation(random.getX()+20, random.getY());
					if(random.getX() > 770){
						i=2;
					}
					break;
				}
				timer++;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
