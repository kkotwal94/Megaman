package com.karankotwal.gamestate;

import java.awt.Graphics;


public abstract class GameState { //abstract class of gamestate, of which we're in, can build other states to extend of this class blahahahahah
protected GameStateManager gsm;

public GameState(GameStateManager gsm) {
	this.gsm = gsm;
	init();
}
public abstract void init(); //abstract functions for subclasses
public abstract void tick();
public abstract void draw(Graphics g);
public abstract void keyPressed(int k);
public abstract void keyReleased(int k);

}
