package com.karankotwal.game.gfxManager;

import java.awt.image.BufferedImage;

public class ImageManager {

	public BufferedImage ZeroStanding;
	
	public ImageManager(SpriteSheet ss) {
		ZeroStanding = ss.grabSprite(0, 109, 37, 44);
		
	}
}
