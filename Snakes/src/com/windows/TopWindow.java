package com.windows;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.entity.TopMusic;

import com.mouselistener.top.TopMouseListener;
/**
 * ����Ϊ��������ʱ������������
 * @author ����
 *
 */
public class TopWindow extends JFrame {
	/**
	 * ��������޲ι��캯��
	 * 
	 * �����������һЩ��ʼ������
	 */
	private TopWindow(){
        String path = "Images/TOP.jpg";        		//���ñ���ͼƬ��·��
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
	 * ��������main����
	 * @param args
	 */
	public static void main(String[] args) {
		new TopWindow();
	}
}