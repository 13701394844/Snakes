package com.windows;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 此类为程序启动时弹出的主界面
 * @author 王雷
 *
 */
public class Explain extends JFrame {
	/**
	 * 主窗体的无参构造函数
	 * 
	 * 用于主窗体的一些初始化工作
	 */
	public Explain(){
        String path = "Images/结束.jpg";        		//设置背景图片的路径
        ImageIcon background = new ImageIcon(path); 	//背景图片
        JLabel back = new JLabel(background);  		//把背景图片显示在一个标签里面
        // 把标签的大小位置设置为图片刚好填充整个面板  
        back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
        this.setSize(background.getIconWidth(),background.getIconHeight());
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	//设置窗体关闭时为应用程序结束
        setLocationRelativeTo(null);					//设置窗体出现时为屏幕中央
        this.setLayout(null);							//设置布局为绝对布局
        this.setTitle("弹吃蛇大战--作者：王雷");
        this.setResizable(false);						//设置窗体不可改变大小
        
        initialize();									//初始化主窗体组件
        
        this.setVisible(true);  						//设置为可见
	}
	/**
	 * 此函数用于初始化主窗体的button组件
	 */
	private void initialize(){
		JLabel jb = new JLabel();
		jb.setBounds(200, 0, 200, 30);
		jb.setForeground(Color.orange);
		jb.setFont(new java.awt.Font("华文行楷", 1, 24));
		jb.setText("玩法说明");
		this.add(jb);
		JLabel jb1 = new JLabel();
		jb1.setBounds(2, 30, 700, 30);
		jb1.setForeground(Color.white);
		jb1.setFont(new java.awt.Font("华文行楷", 1, 20));
		jb1.setText("单人模式为常规模式,按键盘的↑←↓→来控制方");
		this.add(jb1);
		JLabel jb2 = new JLabel();
		jb2.setBounds(2, 60, 700, 30);
		jb2.setForeground(Color.white);
		jb2.setFont(new java.awt.Font("华文行楷", 1, 20));
		jb2.setText("向,吃到道具速度会有所提升,碰到墙游戏结束。");
		this.add(jb2);
		JLabel jb3 = new JLabel();
		jb3.setBounds(2, 120, 700, 30);
		jb3.setForeground(Color.cyan);
		jb3.setFont(new java.awt.Font("华文行楷", 1, 20));
		jb3.setText("双人模式增加了许多传统模式没有的功能，具有更高的");
		this.add(jb3);
		JLabel jb4 = new JLabel();
		jb4.setBounds(2, 150, 700, 30);
		jb4.setForeground(Color.cyan);
		jb4.setFont(new java.awt.Font("华文行楷", 1, 20));
		jb4.setText("可玩性,P1用键盘↑←↓→来控制方向，P2则用WSAD来");
		this.add(jb4);
		JLabel jb5 = new JLabel();
		jb5.setBounds(2, 180, 700, 30);
		jb5.setForeground(Color.cyan);
		jb5.setFont(new java.awt.Font("华文行楷", 1, 20));
		jb5.setText("控制方向,在该模式下,哪一方先吃够10个道具,则谁获胜");
		this.add(jb5);
		JLabel jb6 = new JLabel();
		jb6.setBounds(2, 210, 700, 30);
		jb6.setForeground(Color.cyan);
		jb6.setFont(new java.awt.Font("华文行楷", 1, 20));
		jb6.setText("游戏期间每隔段时间会出现一个随机位置的道具,吃到");
		this.add(jb6);
		JLabel jb7 = new JLabel();
		jb7.setBounds(2, 240, 700, 30);
		jb7.setForeground(Color.cyan);
		jb7.setFont(new java.awt.Font("华文行楷", 1, 20));
		jb7.setText("道具会有三种随机的效果,具体玩法请自行摸索。");
		this.add(jb7);
	}
}