package com.karankotwal.game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.karankotwal.game.GamePanel;
import com.karankotwal.game.gfxManager.ImageManager;


public abstract class Player{
	//public static final long serialVersionUID = 1L;
	//movement booleans
	private boolean right = false;
	private boolean left = false;
	private boolean jumping = false;
	private boolean falling = false;
	//double and positioning of character/rectangle for testing purposes bounds
	private double x,y;
	private int height, width;
	//jump speed stuff
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	//fall speed
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;
	public BufferedImage sprite;
	public ImageManager im;
	//Zero zero = new Zero();
	
	public Player(int width, int height, ImageManager im) {
	x = GamePanel.WIDTH / 2;
	y = GamePanel.HEIGHT / 2;
	this.width = width;
	this.height = height;
	this.im = im;
	 
	}
	public void tick(){ //player.tick.... creating player object to do these things
		if (right == true) {
			x = x + 3;
		}
		if (left == true) {
			x = x - 3;
		}
		if (jumping == true){
			y -= currentJumpSpeed;
			currentJumpSpeed -= .1; //we're decreasing by .1
			if(currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed; //at 0, reached peak
				jumping = false;
				falling = true;
			}
		}
		
		if(falling == true){
			y+= currentFallSpeed;
			if(currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.1; //keep falling, and it maxes out at 5 yo!!
			}
			
		}
		if(!falling) {
			currentFallSpeed = 0.1;
		}
	}
	public void draw(Graphics g) {
		//g.setColor(Color.GREEN);
		//g.fillRect((int)x, (int)y, width, height);
		g.drawImage(im.ZeroStanding, (int)x, (int)y,width,height,null);
		

	}
	public void keyPressed(int k){
		if(k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D) {
			right = true;
		}
		if(k == KeyEvent.VK_LEFT || k == KeyEvent.VK_A) {
			left = true;
		}
		if(k == KeyEvent.VK_W || k == KeyEvent.VK_SPACE || k == KeyEvent.VK_UP) {
			jumping = true;
		}
	}
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D) {
			right = false;
		}
		if(k == KeyEvent.VK_LEFT || k == KeyEvent.VK_A) {
			left = false;
		}
	}
} 
