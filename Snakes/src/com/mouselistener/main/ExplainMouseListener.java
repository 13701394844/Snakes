package com.mouselistener.main;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.windows.Explain;

/**
 * �������ڼ�����������Ϸ˵��button������¼�
 * @author ����
 *
 */
public class ExplainMouseListener implements MouseListener {
	JFrame jframe;
	public ExplainMouseListener(JFrame jframe){
		this.jframe = jframe;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		new Explain();
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
