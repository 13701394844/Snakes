package com.entity;

import javax.swing.JLabel;
/**
 * �ߵĽڶ�
 * @author ����
 *
 */
public class Snake extends JLabel {
	private int step;				//����
	private double sleep;			//�ƶ�ʱ����
	private Direction direction;	//����
	
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
