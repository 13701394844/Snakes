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
 * ����Ϊ��������ʱ������������
 * @author ����
 *
 */
public class MainWindow extends JFrame {
	/**
	 * ��������޲ι��캯��
	 * 
	 * �����������һЩ��ʼ������
	 */
	public MainWindow(){
        String path = "Images/Main.jpg";        		//���ñ���ͼƬ��·��
        ImageIcon background = new ImageIcon(path); 	//����ͼƬ
        JLabel back = new JLabel(background);  		//�ѱ���ͼƬ��ʾ��һ����ǩ����
        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
        this.setSize(background.getIconWidth(),background.getIconHeight());
        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
        this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//���ô���ر�ʱΪӦ�ó������
        setLocationRelativeTo(null);					//���ô������ʱΪ��Ļ����
        this.setLayout(null);							//���ò���Ϊ���Բ���
        this.setTitle("�����ߴ�ս--���ߣ�����");
        this.setResizable(false);						//���ô��岻�ɸı��С
        
        initialize();									//��ʼ�����������
        
        this.setVisible(true);  						//����Ϊ�ɼ�
	}
	/**
	 * �˺������ڳ�ʼ���������button���
	 */
	private void initialize(){
		/*
		 * ������Ϸbutton��ʼ������
		 */
		JButton solo = new JButton();
		solo.setBounds(340, 80, 330, 120);
		solo.setContentAreaFilled(false);
		solo.setBorderPainted(false);
		SoloMouseListener soloMouseListener = new SoloMouseListener(this);
		solo.addMouseListener(soloMouseListener);
		this.add(solo);
		
		/*
		 * ˫����Ϸbutton��ʼ������
		 */
		JButton duet = new JButton();
		duet.setBounds(340, 225, 330, 115);
		duet.setContentAreaFilled(false);
		duet.setBorderPainted(false);
		DuetMouseListener duetMouseListener = new DuetMouseListener(this);
		duet.addMouseListener(duetMouseListener);
		this.add(duet);
		
		/*
		 * ��Ϸ˵��button��ʼ������
		 */
		JButton explain = new JButton();
		explain.setBounds(350, 370, 330, 115);
		explain.setContentAreaFilled(false);
		explain.setBorderPainted(false);
		ExplainMouseListener explainMouseListener = new ExplainMouseListener(this);
		explain.addMouseListener(explainMouseListener);
		this.add(explain);
		
		/*
		 * �˳���Ϸbutton��ʼ������
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
