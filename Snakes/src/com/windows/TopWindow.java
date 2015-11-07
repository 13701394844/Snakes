package com.windows;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.entity.TopMusic;

import com.mouselistener.top.TopMouseListener;
/**
 * 此类为程序启动时弹出的主界面
 * @author 王雷
 *
 */
public class TopWindow extends JFrame {
	/**
	 * 主窗体的无参构造函数
	 * 
	 * 用于主窗体的一些初始化工作
	 */
	private TopWindow(){
        String path = "Images/TOP.jpg";        		//设置背景图片的路径
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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//设置窗体关闭时为应用程序结束
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
		JButton jb = new JButton();
		jb.setBounds(325, 490, 370, 220);
		jb.setContentAreaFilled(false);
		jb.setBorderPainted(false);
		TopMouseListener top = new TopMouseListener(this);
		jb.addMouseListener(top);
		this.add(jb);
		new TopMusic();
	}
	/**
	 * 程序启动main函数
	 * @param args
	 */
	public static void main(String[] args) {
		new TopWindow();
	}
}