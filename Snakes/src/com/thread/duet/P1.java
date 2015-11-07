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
 *此线程为控制SoloWindow窗体蛇移动的线程
 * @author 王雷
 *
 */
public class P1 implements Runnable {
	public static boolean go = false;
	public static int bing = 0;
	public Thread thread;
	public static boolean ok = true;
	JLabel defen;
	JLabel speed;
	JLabel height;
	public static boolean P1Stop = true;
	public static Snake snake; 
	public static List<Snake> list = new ArrayList<Snake>();
	public DuetWindow duetWindow;
    ImageIcon headRight = new ImageIcon("Images/蛇头2右.png");
    ImageIcon headLeft = new ImageIcon("Images/蛇头2左.png");
    ImageIcon headUp = new ImageIcon("Images/蛇头2上.png");
    ImageIcon headDown = new ImageIcon("Images/蛇头2下.png");
    ImageIcon body = new ImageIcon("Images/蛇身02.png");
    ImageIcon icon = new ImageIcon("Images/苹果.png");
    Random r;
    Snake random;
    public void random(){
    	int a = r.nextInt(29)*20+210;
		int b = r.nextInt(23)*20+88;
    	random.setLocation(a, b);	
    }
	public void run() {
		r = new Random();
		int x = r.nextInt(29)*20+210;
		int y = r.nextInt(23)*20+88;
		list.add(snake);
		snake.setLocation(x, y);
		snake.setIcon(headRight);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		new Bing();
		new Pear(duetWindow);
		new Time();
		new P2over();
		while(true){
			while(P1Stop){
				if(go){
					try {
						Thread.sleep(3000);
						go = false;
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				Direction direction = snake.getDirection();
				if(direction == Direction.up){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX(),list.get(0).getY()-snake.getStep());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p1 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue1.setSize(DuetWindow.xue1.getWidth()+29,DuetWindow.xue1.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX(), list.get(1).getY()-snake.getStep());
								random();
							}
							if(list.get(0).getY() < 88){
								bing =1;
								reboundUp();
							}
							for(int i = 0;i<P2.list.size();i++){
								if(list.get(0).getLocation().equals(P2.list.get(i).getLocation())){
									reboundUp();
								}
							}
						}
					}catch(Exception e){
						
					}
					
				}
				if(direction == Direction.down){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX(),list.get(0).getY()+snake.getStep());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p1 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue1.setSize(DuetWindow.xue1.getWidth()+29,DuetWindow.xue1.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX(), list.get(1).getY()+snake.getStep());
								random();
							}
							if(list.get(0).getY()>548){
								bing =1;
								reboundDown();
							}
							for(int i = 0;i<P2.list.size();i++){
								if(list.get(0).getLocation().equals(P2.list.get(i).getLocation())){
									reboundDown();
								}
							}
						}
					}catch(Exception e){}
					
					
				}
				if(direction == Direction.left){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX()-snake.getStep(),list.get(0).getY());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p1 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue1.setSize(DuetWindow.xue1.getWidth()+29,DuetWindow.xue1.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX()-snake.getStep(), list.get(1).getY());
								random();
							}
							if(list.get(0).getX() < 210){
								bing =1;
								reboundLeft();
							}
							for(int i = 0;i<P2.list.size();i++){
								if(list.get(0).getLocation().equals(P2.list.get(i).getLocation())){
									reboundLeft();
								}
							}
						}
					}catch(Exception e){}
					
					
				}
				if(direction == Direction.right){
					try{
						list.get(list.size()-1).setLocation(list.get(0).getX()+snake.getStep(),list.get(0).getY());
						cut();
						if(ok){
							if(list.get(0).getLocation().equals(Pear.pear.getLocation())){
								Time.p1 = true;
								Pear.pear.setLocation(r.nextInt(29)*20+210, r.nextInt(23)*20+88);
								Pear.pear.setVisible(false);
							}
							if(list.get(0).getLocation().equals(random.getLocation())){
								DuetWindow.xue1.setSize(DuetWindow.xue1.getWidth()+29,DuetWindow.xue1.getHeight());
								Snake s = new Snake();
								s.setSize(20,20);
								s.setIcon(body);
								list.add(s);
								duetWindow.add(s);
								s.setLocation(list.get(1).getX()+snake.getStep(), list.get(1).getY());
								random();
							}
							
							if(list.get(0).getX() > 790){
								bing =1;
								reboundRight();
							}
							for(int i = 0;i<P2.list.size();i++){
								if(list.get(0).getLocation().equals(P2.list.get(i).getLocation())){
									reboundRight();
								}
							}
						}
					}catch(Exception e){}
				}
				try {
					Thread.sleep((long) snake.getSleep());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(list.size()>10){
					P2over.stop = true;
					while(P2.list.size()>0){
						P2.list.get(0).setIcon(null);
						P2.list.remove(0);
					}
					DuetWindow.end.setText("小灰获胜");
					DuetWindow.end.setVisible(true);
					DuetWindow.returnMain.setVisible(true);
					DuetWindow.again.setVisible(true);
					P1Stop = false;
					P2.P2Stop = false;
					Apple.AppleStop = false;
					Bing.BingStop = false;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 通过对Snake对象的切换来实现贪吃蛇的移动
	 */
	public void cut(){
		Snake s1 = new Snake();  
		s1.setSize(20,20);
		 
		if(snake.getDirection() == Direction.up){
			s1.setIcon(headUp);
		}else if(snake.getDirection() == Direction.down){
			s1.setIcon(headDown);
		}else if(snake.getDirection() == Direction.left){
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
	 * 结束方法
	 */
	public void finish(){
		while(list.size() != 0){
			list.get(0).setIcon(null);
			list.remove(0);
		}
		snake.setDirection(null);
		snake.setSleep(200);
		P1Stop = false;
	}                 
	/**
	 * SoloMoveThread线程有参构造函数
	 * @param snake
	 * @param soloWindow
	 */
	public P1(Snake snake1,DuetWindow duetWindow,Snake random){
		snake = snake1;
		this.random = random;
		this.duetWindow = duetWindow;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * 此方法实现判断是否碰触到下墙，并回弹功能
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
	 * 此方法实现判断是否碰触到上墙，并回弹功能
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
	 * 此方法实现判断是否碰触到左墙，并回弹功能
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
				e.printStackTrace();
			}
		}
	}
	/**
	 * 此方法实现判断是否碰触到右墙，并回弹功能
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
				e.printStackTrace();
			}
		}
	}
	
	
}
