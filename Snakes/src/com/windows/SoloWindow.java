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
 * ����Ϊ��Ӧ�����浥����Ϸbutton�����¼��������Ĵ���
 * @author ����
 *
 */
public class SoloWindow extends JFrame {
	/**
	 * ������Ϸ�����޲ι��캯��
	 */
	public JLabel score;
	public JLabel speed;
	public JLabel end;
	public JButton continueButton;
	public JButton returnButton;
	public SoloWindow(){
        String path = "Images/����01.jpg";        		//���ñ���ͼƬ��·��
        ImageIcon background = new ImageIcon(path); 	//����ͼƬ
        JLabel back = new JLabel(background);  		//�ѱ���ͼƬ��ʾ��һ����ǩ����
        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
        this.setSize(1024,740);
        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
        this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//���ô���ر�ʱΪӦ�ó������
        setLocationRelativeTo(null);					//���ô������ʱΪ��Ļ����
        this.setLayout(null);							//���ò���Ϊ���Բ���
        this.setTitle("�����ߴ�ս--����ģʽ--���ߣ�����");
        this.setResizable(false);						//���ô��岻�ɸı��С
        
        initialize();									//��ʼ�����������
        
        this.setVisible(true);  						//����Ϊ�ɼ�
	}
	/**
	 * �˺������ڵ���ģʽ����ĳ�ʼ������
	 */
	
	private void initialize(){
		Snake snake = new Snake(20,20,20,20,null,20,200);
		this.add(snake);
		SoloKeyListener soloKeyListener = new SoloKeyListener(snake);
		this.addKeyListener(soloKeyListener);
		/*
		 * ����MainWindow���水ť������Ϸ����ʱ����
		 */
		score = new JLabel();
		score.setText("�÷֣�0");
		score.setFont(new java.awt.Font("�����п�", 1, 28));
		score.setForeground(Color.orange);
		score.setBounds(210, 620, 200, 50);
		this.add(score);
		
		
		speed = new JLabel();
		speed.setText("�ٶȣ�0.2s/��");
		speed.setFont(new java.awt.Font("SansSerif", 1, 18));
		speed.setForeground(Color.pink);
		speed.setBounds(700, 610, 200, 50);
		this.add(speed);
		
		JLabel height = new JLabel();
		height.setFont(new java.awt.Font("�����п�", 1, 28));
		height.setForeground(Color.magenta);
		height.setBounds(430, 0, 200, 50);
		this.add(height);
		
		
		File file = new File("Txt/score.txt");
		InputStream in;
		try {
			in = new FileInputStream(file);
			int i = in.read();
			int b = i-48;
			height.setText("��߷֣�" + b);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		end = new JLabel();
		end.setFont(new java.awt.Font("�����п�", 0, 50));
		end.setForeground(Color.black);
		end.setBounds(410, 300, 300, 50);
		end.setText("��Ϸ����");
		end.setVisible(false);
		this.add(end);
		
		
		continueButton = new JButton();
		  //���һ����������
		continueButton.setFont(new java.awt.Font("�����п�", 1, 24));
		continueButton.setForeground(Color.black);
		continueButton.setMargin(new Insets(0,0,0,0));
		continueButton.setContentAreaFilled(false);
		continueButton.setText("����");
		ContinueMouseListener continueMouseListener = new ContinueMouseListener(this);
		continueButton.addMouseListener(continueMouseListener);
		continueButton.setVisible(false);
		continueButton.setBounds(410, 370, 100, 40);
		this.add(continueButton);
		
		
		returnButton = new JButton();
		  //���һ����������
		returnButton.setFont(new java.awt.Font("�����п�", 1, 24));
		returnButton.setForeground(Color.black);
		returnButton.setMargin(new Insets(0,0,0,0));
		returnButton.setContentAreaFilled(false);
		returnButton.setText("����");
		ReturnMouseListener retrunMouseListener = new ReturnMouseListener(TopMouseListener.mainWindow,this,returnButton,continueButton,end);
		returnButton.addMouseListener(retrunMouseListener);
		returnButton.setVisible(false);
		returnButton.setBounds(510, 370, 100, 40);
		this.add(returnButton);
		new SoloMoveThread(snake,this,score,speed,height);
	}
}
