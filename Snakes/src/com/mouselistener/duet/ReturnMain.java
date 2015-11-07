package com.mouselistener.duet;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.entity.TopMusic;
import com.mouselistener.top.TopMouseListener;
import com.thread.duet.P1;
import com.thread.duet.P2;
import com.windows.DuetWindow;

public class ReturnMain implements MouseListener {
	DuetWindow duetWindow;
	public ReturnMain(DuetWindow duetWindow){
		this.duetWindow = duetWindow;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		TopMusic.music = true;
		while(P1.list.size()>0){
			P1.list.get(0).setIcon(null);
			P1.list.remove(0);
		}
		while(P2.list.size()>0){
			P2.list.get(0).setIcon(null);
			P2.list.remove(0);
		}
		duetWindow.xue1.setBounds(168, 658, 0, 22);
		duetWindow.xue2.setBounds(856, 658, 0, 22);
		duetWindow.setVisible(false);
		duetWindow.end.setVisible(false);
		duetWindow.again.setVisible(false);
		duetWindow.returnMain.setVisible(false);
		
		TopMouseListener.mainWindow.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		duetWindow.setCursor(Cursor.HAND_CURSOR);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		duetWindow.setCursor(null);
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
