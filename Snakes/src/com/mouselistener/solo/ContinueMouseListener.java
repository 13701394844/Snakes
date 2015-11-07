package com.mouselistener.solo;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;

import com.entity.Snake;
import com.thread.solo.SoloMoveThread;
import com.windows.SoloWindow;

public class ContinueMouseListener implements MouseListener {
	SoloWindow soloWindow;
	public ContinueMouseListener(SoloWindow soloWindow){
		this.soloWindow = soloWindow;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		soloWindow.setVisible(false);
		soloWindow.setVisible(true);
		soloWindow.returnButton.setVisible(false);
		soloWindow.continueButton.setVisible(false);
		soloWindow.end.setVisible(false);
		ImageIcon head = new ImageIcon("Images/蛇头2右.png");
		Random r = new Random();
		int a = r.nextInt(29)*20+210;
		int b = r.nextInt(23)*20+88;
		Snake snake = new Snake(a,b,20,20,null,20,200);
		soloWindow.score.setText("得分：0");
		soloWindow.speed.setText("速度：0.2s/步");
		snake.setIcon(head);
		soloWindow.add(snake);
		SoloMoveThread.list.add(0,snake);
		SoloMoveThread.stop(true);
		SoloMoveThread.ok = true;
		
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
