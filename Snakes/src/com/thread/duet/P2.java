package com.thread.duet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.entity.Direction;
import com.entity.P2over;
import com.entity.Snake;
import com.windows.DuetWindow;
/**
 *���߳�Ϊ����SoloWindow�������ƶ����߳�
 * @author ����
 *
 */
public class P2 implements Runnable {
	public static boolean go = false;
	public Thread thread;
	public static boolean ok = true;
	JLabel defen;
	JLabel speed;
	JLabel height;
	public static boolean P2Stop = true;
	public static Snake snake; 
	public static List<Snake> list = new ArrayList<Snake>();
	public DuetWindow duetWindow;
    ImageIcon headRight = new ImageIcon("Images/��ͷ1��.png");
    ImageIcon headLeft = new ImageIcon("Images/��ͷ1��.png");
    ImageIcon headUp = new ImageIcon("Images/��ͷ1��.png");
    ImageIcon headDown = new ImageIcon("Images/��ͷ1��.png");
    ImageIcon body = new ImageIcon("Images/����01.png");
    Random r = new Random();
    Snake random;
    public void random(){
    	int a = r.nextInt(29)*20+210;
		int b = r.nextInt(23)*20+88;
		random.setLocation(a, b);	
    }
	public void run() {
		int x = r.nextInt(29)*20+210;
		int y = r.nextInt(23)*20+88;
		list.add(snake);
		snake.setLocation(x, y);
		snake.setIcon(headRight);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
			while(P2Stop){
				if(go){
					try {
						Thread.sleep(3000);
						go = false;
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				Direction direction = snake.getDirection();
				if(direction == Direction.up1){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX(),list.get(0).getY()-snake.getStep());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p2 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue2.setBounds(DuetWindow.xue2.getX()-29, DuetWindow.xue2.getY(), DuetWindow.xue2.getWidth()+29, DuetWindow.xue2.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX(), list.get(1).getY()-snake.getStep());
								random();
							}
							if(list.get(0).getY() < 88){
								P1.bing =1;
								reboundUp();
							}
							for(int i = 0;i<P1.list.size();i++){
								if(list.get(0).getLocation().equals(P1.list.get(i).getLocation())){
									reboundUp();
								}
							}
						}
					}catch(Exception e){}
					
				}
				if(direction == Direction.down1){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX(),list.get(0).getY()+snake.getStep());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p2 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue2.setBounds(DuetWindow.xue2.getX()-29, DuetWindow.xue2.getY(), DuetWindow.xue2.getWidth()+29, DuetWindow.xue2.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX(), list.get(1).getY()+snake.getStep());
								random();
							}
							if(list.get(0).getY()>548){
								P1.bing =1;
								reboundDown();
							}
							for(int i = 0;i<P1.list.size();i++){
								if(list.get(0).getLocation().equals(P1.list.get(i).getLocation())){
									reboundDown();
								}
							}
						}
					}catch(Exception e){}
				}
				if(direction == Direction.left1){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX()-snake.getStep(),list.get(0).getY());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p2 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue2.setBounds(DuetWindow.xue2.getX()-29, DuetWindow.xue2.getY(), DuetWindow.xue2.getWidth()+29, DuetWindow.xue2.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX()-snake.getStep(), list.get(1).getY());
								random();
							}
							if(list.get(0).getX() < 210){
								P1.bing =1;
								reboundLeft();
							}
							for(int i = 0;i<P1.list.size();i++){
								if(list.get(0).getLocation().equals(P1.list.get(i).getLocation())){
									reboundLeft();
								}
							}
						}
					}catch(Exception e){}
				}
				if(direction == Direction.right1){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX()+snake.getStep(),list.get(0).getY());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p2 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue2.setBounds(DuetWindow.xue2.getX()-29, DuetWindow.xue2.getY(), DuetWindow.xue2.getWidth()+29, DuetWindow.xue2.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX()+snake.getStep(), list.get(1).getY());
								random();
							}
							
							if(list.get(0).getX() > 790){
								P1.bing =1;
								reboundRight();
							}
							for(int i = 0;i<P1.list.size();i++){
								if(list.get(0).getLocation().equals(P1.list.get(i).getLocation())){
									reboundRight();
								}
							}
						}
					}catch(Exception e){}	
				}	
				try {
					Thread.sleep((long) snake.getSleep());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(list.size()>10){
					P2over.stop = true;
					while(P1.list.size()>0){
						P1.list.get(0).setIcon(null);
						P1.list.remove(0);
					}
					DuetWindow.end.setText("С����ʤ");
					DuetWindow.end.setVisible(true);
					DuetWindow.returnMain.setVisible(true);
					DuetWindow.again.setVisible(true);
					P1.P1Stop = false;
					P2Stop = false;
					Apple.AppleStop = false;
					Bing.BingStop = false;
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
	/**
	 * ͨ����Snake������л���ʵ��̰���ߵ��ƶ�
	 */
	public void cut(){
		Snake s1 = new Snake();  
		s1.setSize(20,20);
		 
		if(snake.getDirection() == Direction.up1){
			s1.setIcon(headUp);
		}else if(snake.getDirection() == Direction.down1){
			s1.setIcon(headDown);
		}else if(snake.getDirection() == Direction.left1){
			s1.setIcon(headLeft);
		}else{
			s1.setIcon(headRight);
		}
		s1.setLocation(list.get(list.size()-1).getLocation());
		duetWindow.add(s1);
		list.add(0,s1);
		for(int i = 1;i<list.size();i++){
			list.get(i).setIcon(body);
		}
		list.get(list.size()-1).setIcon(null);
		list.remove(list.get(list.size()-1));
		if(list.size()>1){
			for(int i = 1;i<list.size();i++){
				if(list.get(i).getLocation().equals(random.getLocation())){
					random();
				}
			}
		}
	}
	/**
	 * ��������
	 */
	public void finish(){
		while(list.size() != 0){
			list.get(0).setIcon(null);
			list.remove(0);
		}
		snake.setDirection(null);
		snake.setSleep(200);
		P2Stop = false;
	}                 
	/**
	 * SoloMoveThread�߳��вι��캯��
	 * @param snake
	 * @param soloWindow
	 */
	public P2(Snake snake1,DuetWindow duetWindow,Snake random){
		snake = snake1;
		this.random = random;
		this.duetWindow = duetWindow;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * �˷���ʵ���ж��Ƿ���������ǽ�����ص�����
	 */
	public void reboundDown(){
		for(int i = 0;i<5;i++){
			for(int j = 0;j<list.size();j++){
				if(list.size() == 1){
					list.get(0).setLocation(list.get(0).getX(),list.get(0).getY()-snake.getStep());
				}else{
					if(j == list.size()-1){
						list.get(list.size()-1).setLocation(list.get(list.size()-2).getX(),list.get(list.size()-2).getY()-snake.getStep());
					}else{
						list.get(j).setLocation(list.get(j+1).getLocation());
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �˷���ʵ���ж��Ƿ���������ǽ�����ص�����
	 */
	public void reboundUp(){
		for(int i = 0;i<5;i++){
			for(int j = 0;j<list.size();j++){
				if(list.size() == 1){
					list.get(0).setLocation(list.get(0).getX(),list.get(0).getY()+snake.getStep());
				}else{
					if(j == list.size()-1){
						list.get(list.size()-1).setLocation(list.get(list.size()-2).getX(),list.get(list.size()-2).getY()+snake.getStep());
					}else{
						list.get(j).setLocation(list.get(j+1).getLocation());
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �˷���ʵ���ж��Ƿ���������ǽ�����ص�����
	 */
	public void reboundLeft(){
		for(int i = 0;i<5;i++){
			for(int j = 0;j<list.size();j++){
				if(list.size() == 1){
					list.get(0).setLocation(list.get(0).getX()+snake.getStep(),list.get(0).getY());
				}else{
					if(j == list.size()-1){
						list.get(list.size()-1).setLocation(list.get(list.size()-2).getX()+snake.getStep(),list.get(list.size()-2).getY());
					}else{
						list.get(j).setLocation(list.get(j+1).getLocation());
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * �˷���ʵ���ж��Ƿ���������ǽ�����ص�����
	 */
	public void reboundRight(){
		for(int i = 0;i<5;i++){
			for(int j = 0;j<list.size();j++){
				if(list.size() == 1){
					list.get(0).setLocation(list.get(0).getX()-snake.getStep(),list.get(0).getY());
				}else{
					if(j == list.size()-1){
						list.get(list.size()-1).setLocation(list.get(list.size()-2).getX()-snake.getStep(),list.get(list.size()-2).getY());
					}else{
						list.get(j).setLocation(list.get(j+1).getLocation());
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}