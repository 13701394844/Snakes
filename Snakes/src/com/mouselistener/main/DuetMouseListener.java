package com.mouselistener.main;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.entity.TopMusic;
import com.windows.DuetWindow;

/**
 * 此类用于监听主界面双人游戏button的鼠标事件
 * @author 王雷
 *
 */
public class DuetMouseListener implements MouseListener {
	JFrame jframe;
	DuetWindow duetWindow;
	public DuetMouseListener(JFrame jframe){
		this.jframe = jframe;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		TopMusic.music = false;
		jframe.setVisible(false);
		if(duetWindow == null){
			duetWindow = new DuetWindow();
		}else{
			duetWindow.setVisible(true);
			DuetWindow.ok1.setVisible(true);
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
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
