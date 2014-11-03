package com.karankotwal.gamestate;

import java.awt.Graphics;
import java.util.Stack;


public class GameStateManager {
	
	public Stack<GameState> states; //keep a stack of what state we are currently in
	public GameStateManager() {
		states = new Stack<GameState>(); // our stack of states initialized
		states.push(new MenuState(this));
	}
	
	public void tick() {
		states.peek().tick(); //look at the top of our stack
	}
	
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	
	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k){
		states.peek().keyReleased(k);
	}
}
