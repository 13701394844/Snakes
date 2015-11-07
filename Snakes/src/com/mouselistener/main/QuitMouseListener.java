package com.mouselistener.main;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 * �������ڼ����������˳���Ϸbutton������¼�
 * @author ����
 *
 */
public class QuitMouseListener implements MouseListener {
	JFrame jframe;
	public QuitMouseListener(JFrame jframe){
		this.jframe = jframe;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		jframe.setCursor(Cursor.HAND_CURSOR);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		jframe.setCursor(null);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
