package com.windows;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.mouselistener.main.DuetMouseListener;
import com.mouselistener.main.ExplainMouseListener;
import com.mouselistener.main.QuitMouseListener;
import com.mouselistener.main.SoloMouseListener;
/**
 * 此类为程序启动时弹出的主界面
 * @author 王雷
 *
 */
public class MainWindow extends JFrame {
	/**
	 * 主窗体的无参构造函数
	 * 
	 * 用于主窗体的一些初始化工作
	 */
	public MainWindow(){
        String path = "Images/Main.jpg";        		//设置背景图片的路径
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
		/*
		 * 单人游戏button初始化工作
		 */
		JButton solo = new JButton();
		solo.setBounds(340, 80, 330, 120);
		solo.setContentAreaFilled(false);
		solo.setBorderPainted(false);
		SoloMouseListener soloMouseListener = new SoloMouseListener(this);
		solo.addMouseListener(soloMouseListener);
		this.add(solo);
		
		/*
		 * 双人游戏button初始化工作
		 */
		JButton duet = new JButton();
		duet.setBounds(340, 225, 330, 115);
		duet.setContentAreaFilled(false);
		duet.setBorderPainted(false);
		DuetMouseListener duetMouseListener = new DuetMouseListener(this);
		duet.addMouseListener(duetMouseListener);
		this.add(duet);
		
		/*
		 * 游戏说明button初始化工作
		 */
		JButton explain = new JButton();
		explain.setBounds(350, 370, 330, 115);
		explain.setContentAreaFilled(false);
		explain.setBorderPainted(false);
		ExplainMouseListener explainMouseListener = new ExplainMouseListener(this);
		explain.addMouseListener(explainMouseListener);
		this.add(explain);
		
		/*
		 * 退出游戏button初始化工作
		 */
		JButton quit = new JButton();
		quit.setBounds(420, 515, 260, 105);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		QuitMouseListener quitMouseListener = new QuitMouseListener(this);
		quit.addMouseListener(quitMouseListener);
		this.add(quit);
		
//		new Music();
	}
}
