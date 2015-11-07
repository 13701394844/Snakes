package com.thread.solo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.entity.Direction;
import com.entity.Snake;
import com.entity.SoloMusic;
import com.windows.SoloWindow;
/**
 *���߳�Ϊ����SoloWindow�������ƶ����߳�
 * @author ����
 *
 */
public class SoloMoveThread implements Runnable {
	SoloMusic musicBack;
	public static boolean  music = false;
	public Thread thread;
	public static boolean ok = true;
	int score = 0;
	JLabel defen;
	JLabel speed;
	JLabel height;
	private static boolean stop = true;
	private Snake snake; 
	public static List<Snake> list = new ArrayList<Snake>();
	public SoloWindow soloWindow;
    ImageIcon headRight = new ImageIcon("Images/��ͷ2��.png");
    ImageIcon headLeft = new ImageIcon("Images/��ͷ2��.png");
    ImageIcon headUp = new ImageIcon("Images/��ͷ2��.png");
    ImageIcon headDown = new ImageIcon("Images/��ͷ2��.png");
    ImageIcon body = new ImageIcon("Images/����02.png");
    ImageIcon icon = new ImageIcon("Images/ƻ��.png");
    Random r;
    Snake random = new Snake();
    public void random(){
    	int a = r.nextInt(29)*20+210;
		int b = r.nextInt(23)*20+88;
    	random.setLocation(a, b);	
    }
	public void run() {
		r = new Random();
		int a = r.nextInt(29)*20+210;
		int b = r.nextInt(23)*20+88;
		int x = r.nextInt(29)*20+210;
		int y = r.nextInt(23)*20+88;
		random.setBounds(a, b, 20, 20);
		random.setIcon(icon);
		soloWindow.add(random);
		list.add(snake);
		snake.setLocation(x, y);
		snake.setIcon(headRight);
		while(true){
			while(stop){
				Direction direction = snake.getDirection();
				if(direction == Direction.up){
					list.get(list.size()-1).setLocation(list.get(0).getX(),list.get(0).getY()-snake.getStep());
					cut();
					if(ok){
						if(list.get(0).getLocation().equals(random.getLocation())){
							defen.setText("�÷֣�" + ++score);
							snake.setSleep(snake.getSleep()-5);
							speed.setText("�ٶȣ�" + snake.getSleep()/1000+"s/��");
							Snake s = new Snake();
							s.setSize(20,20);
							s.setIcon(body);
							list.add(s);
							soloWindow.add(s);
							s.setLocation(list.get(1).getX(), list.get(1).getY()-snake.getStep());
							random();
						}
						if(list.get(0).getY() < 88){
							finish();
						}
					}
				}
				if(direction == Direction.down){
					list.get(list.size()-1).setLocation(list.get(0).getX(),list.get(0).getY()+snake.getStep());
					cut();
					if(ok){
						if(list.get(0).getLocation().equals(random.getLocation())){
							defen.setText("�÷֣�" + ++score);
							snake.setSleep(snake.getSleep()-5);
							speed.setText("�ٶȣ�" + snake.getSleep()/1000+"s/��");
							Snake s = new Snake();
							s.setSize(20,20);
							s.setIcon(body);
							list.add(s);
							soloWindow.add(s);
							s.setLocation(list.get(1).getX(), list.get(1).getY()+snake.getStep());
							random();
						}
						if(list.get(0).getY()>548){
							finish();
//							reboundDown();
						}
					}
					
				}
				if(direction == Direction.left){
					list.get(list.size()-1).setLocation(list.get(0).getX()-snake.getStep(),list.get(0).getY());
					cut();
					if(ok){
						if(list.get(0).getLocation().equals(random.getLocation())){
							defen.setText("�÷֣�" + ++score);
							snake.setSleep(snake.getSleep()-5);
							speed.setText("�ٶȣ�" + snake.getSleep()/1000+"s/��");
							Snake s = new Snake();
							s.setSize(20,20);
							s.setIcon(body);
							list.add(s);
							soloWindow.add(s);
							s.setLocation(list.get(1).getX()-snake.getStep(), list.get(1).getY());
							random();
						}
						if(list.get(0).getX() < 210){
							finish();
						}
					}
					
				}
				if(direction == Direction.right){
					list.get(list.size()-1).setLocation(list.get(0).getX()+snake.getStep(),list.get(0).getY());
					cut();
					if(ok){
						if(list.get(0).getLocation().equals(random.getLocation())){
							defen.setText("�÷֣�" + ++score);
							snake.setSleep(snake.getSleep()-5);
							double i = snake.getSleep()/1000;
							speed.setText("�ٶȣ�" + i+"s/��");
							Snake s = new Snake();
							s.setSize(20,20);
							s.setIcon(body);
							list.add(s);
							soloWindow.add(s);
							s.setLocation(list.get(1).getX()+snake.getStep(), list.get(1).getY());
							random();
						}
						
						if(list.get(0).getX() > 790){
							finish();
						}
					}
					
				}		
				try {
					Thread.sleep((long) snake.getSleep());
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
	/**
	 * �ѳɼ��ж��Ƿ������߷�
	 * Ȼ����IO����д�ɼ�
	 */
	public void io(){
		File file = new File("Txt/score.txt");
		try {
			InputStream in = new FileInputStream(file);
			int i = in.read();
			int b = i-48;
			
			if(b<score){
				File newFile = new File("Txt/score.txt");
				OutputStream os = new FileOutputStream(newFile);
				char a = (char) ((char) score+48);
				os.write(a);
				height.setText("��߷֣�"+ score);
				score = 0;
				os.flush();
				os.close();
			}else{
				score = 0;
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * ͨ����Snake������л���ʵ��̰���ߵ��ƶ�
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
		soloWindow.add(s1);
		list.add(0,s1);
		for(int i = 1;i<list.size();i++){
			list.get(i).setIcon(body);
		}
		if(list.size()>2){
			list.get(list.size()-1).setIcon(icon);
		}
		list.get(list.size()-1).setIcon(null);
		list.remove(list.get(list.size()-1));
		
		for(int i = 1;i<list.size();i++){
			if(list.get(0).getLocation().equals(list.get(i).getLocation())){
				while(list.size() > 0){
					list.get(0).setIcon(null);
					list.remove(0);
				}
				snake.setDirection(null);
				snake.setSleep(150);
				io();
				soloWindow.end.setVisible(true);
				soloWindow.returnButton.setVisible(true);
				soloWindow.continueButton.setVisible(true);
				stop = false;
				ok = false;
			}
			if(stop == false){
				if(musicBack == null){
					musicBack =  new SoloMusic();
					music = true;
				}else{
					music = true;
				}
				break;
			}
		}
	}
	/**
	 * ��������
	 */
	public void finish(){
		if(musicBack == null){
			musicBack = new SoloMusic();
			music = true;
		}else{
			music = true;
		}
		
		while(list.size() != 0){
			list.get(0).setIcon(null);
			list.remove(0);
		}
		snake.setDirection(null);
		snake.setSleep(200);
		io();
		soloWindow.end.setVisible(true);
		soloWindow.returnButton.setVisible(true);
		soloWindow.continueButton.setVisible(true);
		stop = false;
	}                 
	/**
	 * SoloMoveThread�߳��вι��캯��
	 * @param snake
	 * @param soloWindow
	 */
	public SoloMoveThread(Snake snake,SoloWindow soloWindow,JLabel defen,JLabel speed,JLabel height){
		this.speed = speed;
		this.defen = defen;
		this.snake = snake;
		this.height = height;
		this.soloWindow = soloWindow;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * ����SoloMoveThread�߳��Ƿ����
	 */
	public static void stop(boolean stop1){
		stop = stop1;
	}
	/**
	 * �˷���ʵ���ж��Ƿ���������ǽ�����ص�����
	 * 
	 * �ûص�����û������ ����˫��ģʽ����
	 */
	public void reboundDown(){
		for(int i = 0;i<7;i++){
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
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
