package com.karankotwal.gamestate;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.karankotwal.game.entities.Player;
import com.karankotwal.game.entities.Zero;
import com.karankotwal.game.gfxManager.BufferedImageLoader;
import com.karankotwal.game.gfxManager.ImageManager;
import com.karankotwal.game.gfxManager.SpriteSheet;
public class Level1State extends GameState{
private Player player; 
private Zero zero;
private BufferedImage standingsprite;
private ImageManager im;
	public Level1State(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	
	public void init() {
		
	
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("/zero3.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		im = new ImageManager(ss);
		zero = new Zero(100,100,im);
	}

	
	public void tick() {
		zero.tick();
		
	}

	
	public void draw(Graphics g) {
		zero.draw(g);
		//g.drawImage(sprite, 300, 300, null);
		//
	}

	
	public void keyPressed(int k) {
		zero.keyPressed(k);
		
	}

	
	public void keyReleased(int k) {
		zero.keyReleased(k);
		
	}

}
