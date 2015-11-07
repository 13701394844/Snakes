package com.entity;

import javax.swing.JLabel;
/**
 * 蛇的节段
 * @author 王雷
 *
 */
public class Snake extends JLabel {
	private int step;				//步长
	private double sleep;			//移动时间间隔
	private Direction direction;	//方向
	
	public Snake(){
		super();
	}
	public Snake(int x,int y,int width,int height,Direction direction,int step,int sleep){
		this.direction = direction;
		this.step = step;
		this.sleep = sleep;
		this.setBounds(x, y, width, height);
	}
	
	public int getStep(){
		return step;
	}
	public void setStep(int step){
		this.step = step;
	}
	public double getSleep(){
		return sleep;
	}
	public void setSleep(double sleep){
		this.sleep = sleep;
	}
	public Direction getDirection(){
		return direction;
	}
	public void setDirection(Direction direction){
		this.direction = direction;
	}
}
