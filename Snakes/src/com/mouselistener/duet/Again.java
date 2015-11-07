package com.mouselistener.duet;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;

import com.entity.GoMusic;
import com.entity.Snake;
import com.thread.duet.Apple;
import com.thread.duet.Bing;
import com.thread.duet.P1;
import com.thread.duet.P2;
import com.windows.DuetWindow;

public class Again implements MouseListener {
	DuetWindow duetWindow;
	public Again(DuetWindow duetWindow){
		this.duetWindow = duetWindow;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		GoMusic.stop = true;
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
		duetWindow.daoJiShi.setVisible(true);
		Apple.AppleStop = true;
		Apple.daoJiShi = true;
		duetWindow.setVisible(false);
		duetWindow.setVisible(true);
		duetWindow.end.setVisible(false);
		duetWindow.again.setVisible(false);
		duetWindow.returnMain.setVisible(false);
		
		ImageIcon p1 = new ImageIcon("Images/…ﬂÕ∑2”“.png");
		ImageIcon p2 = new ImageIcon("Images/…ﬂÕ∑1”“.png");
		Random r = new Random();
		int a = r.nextInt(29)*20+210;
		int b = r.nextInt(23)*20+88;
		int x = r.nextInt(29)*20+210;
		int y = r.nextInt(23)*20+88;
		Snake pp1 = new Snake(a,b,20,20,null,20,200);
		pp1.setIcon(p1);
		Snake pp2 = new Snake(x,y,20,20,null,20,200);
		pp2.setIcon(p2);
		P1.list.add(0,pp1);
		P2.list.add(0,pp2);
		duetWindow.add(pp1);
		duetWindow.add(pp2);
		P1.go = true;
		P2.go = true;
		Bing.BingStop = true;
		P1.P1Stop =true;
		P2.P2Stop =true;
		
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
