package com.mouselistener.main;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;

import com.entity.Snake;
import com.entity.TopMusic;
import com.thread.solo.SoloMoveThread;
import com.windows.MainWindow;
import com.windows.SoloWindow;
/**
 * 此类用于监听主界面单人游戏button的鼠标事件
 * @author 王雷
 *
 */
public class SoloMouseListener implements MouseListener {
	MainWindow mainWindow;
	SoloWindow soloWindow;
	public SoloMouseListener(MainWindow mainWindow){
		this.mainWindow = mainWindow;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		TopMusic.music = false;
		mainWindow.setVisible(false);
		if(soloWindow == null){
			soloWindow = new SoloWindow();
		}else{
			soloWindow.setVisible(true);
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
		}
		 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mainWindow.setCursor(Cursor.HAND_CURSOR);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mainWindow.setCursor(null);
		
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
