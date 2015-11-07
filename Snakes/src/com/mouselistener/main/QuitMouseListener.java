package com.mouselistener.main;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 * 此类用于监听主界面退出游戏button的鼠标事件
 * @author 王雷
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
