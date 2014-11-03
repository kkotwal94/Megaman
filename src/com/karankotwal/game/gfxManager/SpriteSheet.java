package com.karankotwal.game.gfxManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	public BufferedImage spriteSheet;
	public SpriteSheet(BufferedImage ss){
		this.spriteSheet = ss;
	}
	
	public BufferedImage grabSprite(int x, int y, int width, int height ){
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}
		 
}
