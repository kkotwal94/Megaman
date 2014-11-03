package com.karankotwal.game.gfxManager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class BufferedImageLoader {

private BufferedImage loadimage;

public BufferedImage loadImage(String path) throws IOException {
	URL	url = this.getClass().getResource(path);
	loadimage = ImageIO.read(url);
	return loadimage;
}
	
}

