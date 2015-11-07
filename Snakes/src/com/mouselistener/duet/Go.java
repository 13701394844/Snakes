package com.mouselistener.duet;


import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;


import com.entity.GoMusic;
import com.entity.Snake;

import com.thread.duet.Apple;
import com.thread.duet.Bing;
import com.thread.duet.P1;
import com.thread.duet.P2;
import com.windows.DuetWindow;

public class Go implements MouseListener {
	JButton jb;
	boolean dong = true;
	boolean dong2 = false;
	DuetWindow duetWindow;
	public Go(JButton jb,DuetWindow duetWindow){
		this.duetWindow = duetWindow;
		this.jb = jb;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		jb.setVisible(false);
		duetWindow.setVisible(false);
		duetWindow.setVisible(true);
		duetWindow.daoJiShi.setVisible(true);
		Apple.AppleStop = true;
		Apple.daoJiShi = true;
		if(dong2){
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
			GoMusic.stop = true;
		}
		
		
		if(dong){
			new P1(duetWindow.p1,duetWindow,duetWindow.apple);
			new P2(duetWindow.p2,duetWindow,duetWindow.apple);
			new Apple(duetWindow.apple,duetWindow);
			new GoMusic();
			GoMusic.stop = true;
			dong = false;
			dong2 = true;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		duetWindow.setCursor(Cursor.HAND_CURSOR);	
	}

	@Override
	public void mouseExited(MouseEvent e) {
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
