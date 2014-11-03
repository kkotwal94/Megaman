package com.karankotwal.game.entities;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

import com.karankotwal.game.gfxManager.BufferedImageLoader;
import com.karankotwal.game.gfxManager.ImageManager;
import com.karankotwal.game.gfxManager.SpriteSheet;


public class Zero extends Player {
	
	
	private int x;
    private int y;
    private Image image;
    ImageManager im;
    public static BufferedImage sprite;
  
    public Zero(int x, int y, ImageManager im) {
    	super(x,y,im);
    	}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
   /* public void draw(Graphics g){
    	super.draw(g);
    	
    }*/

   
}


