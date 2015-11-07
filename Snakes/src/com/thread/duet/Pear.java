package com.thread.duet;

import java.util.Random;

import javax.swing.ImageIcon;

import com.entity.Snake;
import com.windows.DuetWindow;

public class Pear implements Runnable {
	public static boolean d15 = true;
	public static boolean pearStop = true;
	public static Snake pear;
	DuetWindow duetWindow;
	public Pear(DuetWindow duetWindow){
		this.duetWindow = duetWindow;
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		Random r = new Random();
		ImageIcon body = new ImageIcon("Images/Àæ.png");
		int a = r.nextInt(29)*20+210;
		int b = r.nextInt(23)*20+88;
		pear = new Snake(a,b,20,20,null,20,200);
		pear.setIcon(body);
		pear.setVisible(false);
		duetWindow.add(pear);
		while(true){
			while(pearStop){
				if(d15){
					try {
						Thread.sleep(11000);
						d15 = false;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				pear.setVisible(true);
				try {
					Thread.sleep(7000);
					pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
					pear.setVisible(false);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(11000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
