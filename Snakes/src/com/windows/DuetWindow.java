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
 * ����Ϊ��Ӧ������˫����Ϸbutton�����¼��������Ĵ���
 * @author ����
 *
 */
public class DuetWindow extends JFrame {
	/**
	 * ˫����Ϸ�����޲ι��캯��
	 */
	public DuetWindow(){
        String path = "Images/����01.jpg";        		//���ñ���ͼƬ��·��
        ImageIcon background = new ImageIcon(path); 	//����ͼƬ
        JLabel back = new JLabel(background);  		//�ѱ���ͼƬ��ʾ��һ����ǩ����
        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
        this.setSize(1024,770);
        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
        this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//���ô���ر�ʱΪӦ�ó������
        setLocationRelativeTo(null);					//���ô������ʱΪ��Ļ����
        this.setLayout(null);							//���ò���Ϊ���Բ���
        this.setTitle("�����ߴ�ս--˫��ģʽ--���ߣ�����");
        this.setResizable(false);						//���ô��岻�ɸı��С
        
        initialize();									//��ʼ�����������
        
        this.setVisible(true);  						//����Ϊ�ɼ�
	}
	/**
	 * �˺�������˫��ģʽ����ĳ�ʼ������
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
		ImageIcon xuetiao = new ImageIcon("Images/Ѫ��.png");
		xue1 = new JLabel();
		xue2 = new JLabel();
		xue1.setIcon(xuetiao);
		xue2.setIcon(xuetiao);
		xue1.setBounds(168, 658, 0, 22);
		xue2.setBounds(856, 658, 0, 22);
		this.add(xue1);
		this.add(xue2);
		ImageIcon xuetiaoBack = new ImageIcon("Images/Ѫ������.png");
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
		ok1.setFont(new java.awt.Font("�����п�", 1, 100));
		ok1.setForeground(Color.black);
		ok1.setContentAreaFilled(false);
		Go go = new Go(ok1,this);
		ok1.addMouseListener(go);
		ok1.setVisible(true);
		this.add(ok1);
		
		daoJiShi = new JLabel();
		daoJiShi.setFont(new java.awt.Font("�����п�", 1, 200));
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
		ImageIcon icon = new ImageIcon("Images/ƻ��.png");
		apple = new Snake();
		apple.setIcon(icon);
		apple.setSize(20,20);
		this.add(apple);
		
		ImageIcon imgP1 = new ImageIcon("Images/ͷ��.png");
		JLabel portrait= new JLabel();
		portrait.setIcon(imgP1);
		portrait.setBounds(10, 630, 998, 108);
		this.add(portrait);
		
		end = new JLabel();
		end.setFont(new java.awt.Font("�����п�", 0, 50));
		end.setForeground(Color.black);
		end.setBounds(410, 260, 300, 50);
		end.setVisible(false);
		this.add(end);
		
		again = new JButton();
		again = new JButton();
		  //���һ����������
		again.setFont(new java.awt.Font("�����п�", 1, 24));
		again.setForeground(Color.black);
		again.setMargin(new Insets(0,0,0,0));
		again.setContentAreaFilled(false);
		again.setText("����");
		again.setVisible(false);
		again.setBounds(410, 330, 100, 40);
		Again againListener = new Again(this);
		again.addMouseListener(againListener);
		this.add(again);
		
		
		returnMain = new JButton();
		returnMain = new JButton();
		  //���һ����������
		returnMain.setFont(new java.awt.Font("�����п�", 1, 24));
		returnMain.setForeground(Color.black);
		returnMain.setMargin(new Insets(0,0,0,0));
		returnMain.setContentAreaFilled(false);
		returnMain.setText("����");
		returnMain.setVisible(false);
		returnMain.setBounds(510, 330, 100, 40);
		ReturnMain returnMainListener = new ReturnMain(this);
		returnMain.addMouseListener(returnMainListener);
		this.add(returnMain);
		
		ImageIcon jiasu1 = new ImageIcon("Images/����.png");
		ImageIcon jiansu1 = new ImageIcon("Images/����.png");
		
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
