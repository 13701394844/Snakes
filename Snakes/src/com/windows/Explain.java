package com.windows;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ����Ϊ��������ʱ������������
 * @author ����
 *
 */
public class Explain extends JFrame {
	/**
	 * ��������޲ι��캯��
	 * 
	 * �����������һЩ��ʼ������
	 */
	public Explain(){
        String path = "Images/����.jpg";        		//���ñ���ͼƬ��·��
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	//���ô���ر�ʱΪӦ�ó������
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
		JLabel jb = new JLabel();
		jb.setBounds(200, 0, 200, 30);
		jb.setForeground(Color.orange);
		jb.setFont(new java.awt.Font("�����п�", 1, 24));
		jb.setText("�淨˵��");
		this.add(jb);
		JLabel jb1 = new JLabel();
		jb1.setBounds(2, 30, 700, 30);
		jb1.setForeground(Color.white);
		jb1.setFont(new java.awt.Font("�����п�", 1, 20));
		jb1.setText("����ģʽΪ����ģʽ,�����̵ġ������������Ʒ�");
		this.add(jb1);
		JLabel jb2 = new JLabel();
		jb2.setBounds(2, 60, 700, 30);
		jb2.setForeground(Color.white);
		jb2.setFont(new java.awt.Font("�����п�", 1, 20));
		jb2.setText("��,�Ե������ٶȻ���������,����ǽ��Ϸ������");
		this.add(jb2);
		JLabel jb3 = new JLabel();
		jb3.setBounds(2, 120, 700, 30);
		jb3.setForeground(Color.cyan);
		jb3.setFont(new java.awt.Font("�����п�", 1, 20));
		jb3.setText("˫��ģʽ��������ഫͳģʽû�еĹ��ܣ����и��ߵ�");
		this.add(jb3);
		JLabel jb4 = new JLabel();
		jb4.setBounds(2, 150, 700, 30);
		jb4.setForeground(Color.cyan);
		jb4.setFont(new java.awt.Font("�����п�", 1, 20));
		jb4.setText("������,P1�ü��̡������������Ʒ���P2����WSAD��");
		this.add(jb4);
		JLabel jb5 = new JLabel();
		jb5.setBounds(2, 180, 700, 30);
		jb5.setForeground(Color.cyan);
		jb5.setFont(new java.awt.Font("�����п�", 1, 20));
		jb5.setText("���Ʒ���,�ڸ�ģʽ��,��һ���ȳԹ�10������,��˭��ʤ");
		this.add(jb5);
		JLabel jb6 = new JLabel();
		jb6.setBounds(2, 210, 700, 30);
		jb6.setForeground(Color.cyan);
		jb6.setFont(new java.awt.Font("�����п�", 1, 20));
		jb6.setText("��Ϸ�ڼ�ÿ����ʱ������һ�����λ�õĵ���,�Ե�");
		this.add(jb6);
		JLabel jb7 = new JLabel();
		jb7.setBounds(2, 240, 700, 30);
		jb7.setForeground(Color.cyan);
		jb7.setFont(new java.awt.Font("�����п�", 1, 20));
		jb7.setText("���߻������������Ч��,�����淨������������");
		this.add(jb7);
	}
}