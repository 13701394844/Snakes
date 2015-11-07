package com.mouselistener.solo;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.entity.TopMusic;
import com.thread.solo.SoloMoveThread;
import com.windows.MainWindow;
import com.windows.SoloWindow;

public class ReturnMouseListener implements MouseListener {
	MainWindow mainWindow;
	SoloWindow soloWindow;
	JButton returnButton;
	JButton continueButton;
	JLabel end;
	public ReturnMouseListener(MainWindow mainWindow,SoloWindow soloWindow,JButton returnButton,JButton continueButton,JLabel end){
		this.mainWindow = mainWindow;
		this.soloWindow = soloWindow;
		this.returnButton = returnButton;
		this.continueButton = continueButton;
		this.end = end;
	}
	public void mouseClicked(MouseEvent e) {
		TopMusic.music = true;
		SoloMoveThread.ok = true;
		soloWindow.setVisible(false);
		returnButton.setVisible(false);
		continueButton.setVisible(false);
		end.setVisible(false);
		mainWindow.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		soloWindow.setCursor(Cursor.HAND_CURSOR);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		soloWindow.setCursor(null);
		
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
