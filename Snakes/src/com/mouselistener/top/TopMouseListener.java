package com.mouselistener.top;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.windows.MainWindow;
import com.windows.TopWindow;

public class TopMouseListener implements MouseListener {
	TopWindow topWindow;
	public static MainWindow mainWindow;
	public  TopMouseListener(TopWindow topWindow){
		this.topWindow = topWindow;
	}
	
	public void mouseClicked(MouseEvent e) {
		mainWindow = new MainWindow();
		topWindow.setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		topWindow.setCursor(Cursor.HAND_CURSOR);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		topWindow.setCursor(null);
		
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
