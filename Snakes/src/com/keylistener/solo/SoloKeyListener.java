package com.keylistener.solo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.entity.Direction;
import com.entity.Snake;
/**
 * Solo´°ÌåµÄ¼üÅÌ¼àÌıÆ÷
 * @author ÍõÀ×
 *
 */
public class SoloKeyListener implements KeyListener {
	private Snake snake;
	public SoloKeyListener(Snake snake){
		this.snake = snake;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			//×ó
		case 37:
			if(snake.getDirection() == Direction.right){
				
			}else{
				snake.setDirection(Direction.left);
			}
			break;
			//ÉÏ
		case 38:
			if(snake.getDirection() == Direction.down){
				
			}else{
				snake.setDirection(Direction.up);
			}
			break;
			//ÓÒ
		case 39:
			if(snake.getDirection() == Direction.left){
				
			}else{
				snake.setDirection(Direction.right);
			}
			break;
			//ÏÂ
		case 40:
			if(snake.getDirection() == Direction.up){
				
			}else{
				snake.setDirection(Direction.down);
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
