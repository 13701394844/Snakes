package com.windows;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.entity.Direction;
import com.entity.Snake;
import com.keylistener.duet.DuetKeyListener;
import com.mouselistener.duet.Again;
import com.mouselistener.duet.Go;
import com.mouselistener.duet.ReturnMain;
/**
 * 此类为响应主界面双人游戏button单击事件所弹出的窗体
 * @author 王雷
 *
 */
public class DuetWindow extends JFrame {
	/**
	 * 双人游戏窗体无参构造函数
	 */
	public DuetWindow(){
        String path = "Images/背景01.jpg";        		//设置背景图片的路径
        ImageIcon background = new ImageIcon(path); 	//背景图片
        JLabel back = new JLabel(background);  		//把背景图片显示在一个标签里面
        // 把标签的大小位置设置为图片刚好填充整个面板  
        back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
        this.setSize(1024,770);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//设置窗体关闭时为应用程序结束
        setLocationRelativeTo(null);					//设置窗体出现时为屏幕中央
        this.setLayout(null);							//设置布局为绝对布局
        this.setTitle("弹吃蛇大战--双人模式--作者：王雷");
        this.setResizable(false);						//设置窗体不可改变大小
        
        initialize();									//初始化主窗体组件
        
        this.setVisible(true);  						//设置为可见
	}
	/**
	 * 此函数用于双人模式窗体的初始化工作
	 */
	public JLabel daoJiShi;
	public Snake p1;
	public Snake p2;
	public Snake apple;
	public static JLabel xue1;
	public static JLabel xue2;
	public static JLabel end;
	public static JButton again;
	public static JButton returnMain;
	public static JButton ok1;
	public static JLabel jiasup1;
	public static JLabel jiansup1;
	public static JLabel jiasup2;
	public static JLabel jiansup2;
	private void initialize(){
		ImageIcon xuetiao = new ImageIcon("Images/血条.png");
		xue1 = new JLabel();
		xue2 = new JLabel();
		xue1.setIcon(xuetiao);
		xue2.setIcon(xuetiao);
		xue1.setBounds(168, 658, 0, 22);
		xue2.setBounds(856, 658, 0, 22);
		this.add(xue1);
		this.add(xue2);
		ImageIcon xuetiaoBack = new ImageIcon("Images/血条背景.png");
		JLabel tiao1 = new JLabel();
		JLabel tiao2 = new JLabel();
		tiao1.setIcon(xuetiaoBack);
		tiao2.setIcon(xuetiaoBack);
		tiao1.setBounds(168, 658, 290, 22);
		tiao2.setBounds(566, 658, 290, 22);
		this.add(tiao1);
		this.add(tiao2);
		
		ok1 = new JButton();
		ok1.setBounds(410, 220, 200, 200);
		ok1.setText("GO");
		ok1.setBorderPainted(false);
		ok1.setFont(new java.awt.Font("华文行楷", 1, 100));
		ok1.setForeground(Color.black);
		ok1.setContentAreaFilled(false);
		Go go = new Go(ok1,this);
		ok1.addMouseListener(go);
		ok1.setVisible(true);
		this.add(ok1);
		
		daoJiShi = new JLabel();
		daoJiShi.setFont(new java.awt.Font("华文行楷", 1, 200));
		daoJiShi.setForeground(Color.black);
		daoJiShi.setBounds(450, 200, 250, 250);
		daoJiShi.setText("");
		daoJiShi.setVisible(true);
		this.add(daoJiShi);
		
		p1 = new Snake(20,20,20,20,Direction.right,20,200);
		p2 = new Snake(20,20,20,20,Direction.right1,20,200);
		this.add(p2);
		this.add(p1);
		DuetKeyListener duetKeyListener = new DuetKeyListener(p1,p2);
		this.addKeyListener(duetKeyListener);
		ImageIcon icon = new ImageIcon("Images/苹果.png");
		apple = new Snake();
		apple.setIcon(icon);
		apple.setSize(20,20);
		this.add(apple);
		
		ImageIcon imgP1 = new ImageIcon("Images/头像.png");
		JLabel portrait= new JLabel();
		portrait.setIcon(imgP1);
		portrait.setBounds(10, 630, 998, 108);
		this.add(portrait);
		
		end = new JLabel();
		end.setFont(new java.awt.Font("华文行楷", 0, 50));
		end.setForeground(Color.black);
		end.setBounds(410, 260, 300, 50);
		end.setVisible(false);
		this.add(end);
		
		again = new JButton();
		again = new JButton();
		  //添加一个鼠标监听器
		again.setFont(new java.awt.Font("华文行楷", 1, 24));
		again.setForeground(Color.black);
		again.setMargin(new Insets(0,0,0,0));
		again.setContentAreaFilled(false);
		again.setText("重来");
		again.setVisible(false);
		again.setBounds(410, 330, 100, 40);
		Again againListener = new Again(this);
		again.addMouseListener(againListener);
		this.add(again);
		
		
		returnMain = new JButton();
		returnMain = new JButton();
		  //添加一个鼠标监听器
		returnMain.setFont(new java.awt.Font("华文行楷", 1, 24));
		returnMain.setForeground(Color.black);
		returnMain.setMargin(new Insets(0,0,0,0));
		returnMain.setContentAreaFilled(false);
		returnMain.setText("返回");
		returnMain.setVisible(false);
		returnMain.setBounds(510, 330, 100, 40);
		ReturnMain returnMainListener = new ReturnMain(this);
		returnMain.addMouseListener(returnMainListener);
		this.add(returnMain);
		
		ImageIcon jiasu1 = new ImageIcon("Images/加速.png");
		ImageIcon jiansu1 = new ImageIcon("Images/减速.png");
		
		jiasup1 = new JLabel();
		jiasup1.setBounds(40, 580, 42, 47);
		jiasup1.setIcon(jiasu1);
		jiasup1.setVisible(false);
		this.add(jiasup1);
		
		jiansup1 = new JLabel();
		jiansup1.setBounds(40, 580, 42, 47);
		jiansup1.setIcon(jiansu1);
		jiansup1.setVisible(false);
		this.add(jiansup1);
		
		jiasup2 = new JLabel();
		jiasup2.setBounds(930, 580, 42, 47);
		jiasup2.setIcon(jiasu1);
		jiasup2.setVisible(false);
		this.add(jiasup2);
		
		jiansup2 = new JLabel();
		jiansup2.setBounds(930, 580, 42, 47);
		jiansup2.setIcon(jiansu1);
		jiansup2.setVisible(false);
		this.add(jiansup2);

		
	}
}
