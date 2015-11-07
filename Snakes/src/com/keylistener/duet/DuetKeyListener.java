package com.keylistener.duet;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.entity.Direction;
import com.entity.Snake;
/**
 * Solo窗体的键盘监听器
 * @author 王雷
 *
 */
public class DuetKeyListener implements KeyListener {
	private Snake p1;
	private Snake p2;
	public DuetKeyListener(Snake p1,Snake p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		//左
		case 65:
			if(p2.getDirection() == Direction.right1){
				
			}else{
				p2.setDirection(Direction.left1);
			}
			break;
		//上
		case 87:
			if(p2.getDirection() == Direction.down1){
				
			}else{
				p2.setDirection(Direction.up1);
			}
			break;
		//右
		case 68:
			if(p2.getDirection() == Direction.left1){
				
			}else{
				p2.setDirection(Direction.right1);
			}
			break;
		//下
		case 83:
			if(p2.getDirection() == Direction.up1){
				
			}else{
				p2.setDirection(Direction.down1);
			}
			break;
			
			
			
		/**
		 * P1
		 */
		//左
		case 37:
			if(p1.getDirection() == Direction.right){
				
			}else{
				p1.setDirection(Direction.left);
			}
			break;
		//上
		case 38:
			if(p1.getDirection() == Direction.down){
				
			}else{
				p1.setDirection(Direction.up);
			}
			break;
		//右
		case 39:
			if(p1.getDirection() == Direction.left){
				
			}else{
				p1.setDirection(Direction.right);
			}
			break;
		//下
		case 40:
			if(p1.getDirection() == Direction.up){
				
			}else{
				p1.setDirection(Direction.down);
			}
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
