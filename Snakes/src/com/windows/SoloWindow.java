package com.windows;

import java.awt.Color;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.entity.Snake;
import com.keylistener.solo.SoloKeyListener;
import com.mouselistener.solo.ContinueMouseListener;
import com.mouselistener.solo.ReturnMouseListener;
import com.mouselistener.top.TopMouseListener;
import com.thread.solo.SoloMoveThread;
/**
 * 此类为响应主界面单人游戏button单击事件所弹出的窗体
 * @author 王雷
 *
 */
public class SoloWindow extends JFrame {
	/**
	 * 单人游戏窗体无参构造函数
	 */
	public JLabel score;
	public JLabel speed;
	public JLabel end;
	public JButton continueButton;
	public JButton returnButton;
	public SoloWindow(){
        String path = "Images/背景01.jpg";        		//设置背景图片的路径
        ImageIcon background = new ImageIcon(path); 	//背景图片
        JLabel back = new JLabel(background);  		//把背景图片显示在一个标签里面
        // 把标签的大小位置设置为图片刚好填充整个面板  
        back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
        this.setSize(1024,740);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//设置窗体关闭时为应用程序结束
        setLocationRelativeTo(null);					//设置窗体出现时为屏幕中央
        this.setLayout(null);							//设置布局为绝对布局
        this.setTitle("弹吃蛇大战--单人模式--作者：王雷");
        this.setResizable(false);						//设置窗体不可改变大小
        
        initialize();									//初始化主窗体组件
        
        this.setVisible(true);  						//设置为可见
	}
	/**
	 * 此函数用于单人模式窗体的初始化工作
	 */
	
	private void initialize(){
		Snake snake = new Snake(20,20,20,20,null,20,200);
		this.add(snake);
		SoloKeyListener soloKeyListener = new SoloKeyListener(snake);
		this.addKeyListener(soloKeyListener);
		/*
		 * 返回MainWindow界面按钮，当游戏结束时弹出
		 */
		score = new JLabel();
		score.setText("得分：0");
		score.setFont(new java.awt.Font("华文行楷", 1, 28));
		score.setForeground(Color.orange);
		score.setBounds(210, 620, 200, 50);
		this.add(score);
		
		
		speed = new JLabel();
		speed.setText("速度：0.2s/步");
		speed.setFont(new java.awt.Font("SansSerif", 1, 18));
		speed.setForeground(Color.pink);
		speed.setBounds(700, 610, 200, 50);
		this.add(speed);
		
		JLabel height = new JLabel();
		height.setFont(new java.awt.Font("华文行楷", 1, 28));
		height.setForeground(Color.magenta);
		height.setBounds(430, 0, 200, 50);
		this.add(height);
		
		
		File file = new File("Txt/score.txt");
		InputStream in;
		try {
			in = new FileInputStream(file);
			int i = in.read();
			int b = i-48;
			height.setText("最高分：" + b);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		end = new JLabel();
		end.setFont(new java.awt.Font("华文行楷", 0, 50));
		end.setForeground(Color.black);
		end.setBounds(410, 300, 300, 50);
		end.setText("游戏结束");
		end.setVisible(false);
		this.add(end);
		
		
		continueButton = new JButton();
		  //添加一个鼠标监听器
		continueButton.setFont(new java.awt.Font("华文行楷", 1, 24));
		continueButton.setForeground(Color.black);
		continueButton.setMargin(new Insets(0,0,0,0));
		continueButton.setContentAreaFilled(false);
		continueButton.setText("重来");
		ContinueMouseListener continueMouseListener = new ContinueMouseListener(this);
		continueButton.addMouseListener(continueMouseListener);
		continueButton.setVisible(false);
		continueButton.setBounds(410, 370, 100, 40);
		this.add(continueButton);
		
		
		returnButton = new JButton();
		  //添加一个鼠标监听器
		returnButton.setFont(new java.awt.Font("华文行楷", 1, 24));
		returnButton.setForeground(Color.black);
		returnButton.setMargin(new Insets(0,0,0,0));
		returnButton.setContentAreaFilled(false);
		returnButton.setText("返回");
		ReturnMouseListener retrunMouseListener = new ReturnMouseListener(TopMouseListener.mainWindow,this,returnButton,continueButton,end);
		returnButton.addMouseListener(retrunMouseListener);
		returnButton.setVisible(false);
		returnButton.setBounds(510, 370, 100, 40);
		this.add(returnButton);
		new SoloMoveThread(snake,this,score,speed,height);
	}
}
