package com.karankotwal.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.karankotwal.gamestate.GameStateManager;

public class GamePanel extends JPanel implements Runnable,KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private Thread thread; //our thread the game will run on
	private boolean isRunning = false; //is our state still running?
	private int FPS = 60; //our frames per second cap;
	private long targetTime = 1000/FPS;
	private GameStateManager gsm; //Creating object of our gamestatemanager
	
	
	public GamePanel(){	
		setPreferredSize(new Dimension(WIDTH,HEIGHT)); //set size of our game panel where stuff happens
		addKeyListener(this);
		setFocusable(true);
		start(); //our start state/case
	}
	
	private void start(){
	isRunning = true;
	thread = new Thread(this); // refers to our variable thread;
	thread.start();
	}
	
	public void run() {
		long start, elapsed, wait;
		gsm = new GameStateManager();
		while(isRunning) { //while thread is going is true
			start = System.nanoTime(); // start in nano
			tick(); //let game tick
			repaint(); //paint graphics again for that state
			elapsed = System.nanoTime() - start; //self explanatory
			wait = targetTime - elapsed / 1000000; //we want milliseconds, if it does everything under the time we want, 60fps, we're gonna wait and sleep the thread a bit, so it doesnt move fastor on one comp
			
			if (wait <= 0) {
				wait = 5;
			}
			try {
			Thread.sleep(wait);	//lets sleep for 5 if games running > 60fps
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void tick() { //updating all the game logic?
		gsm.tick();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, WIDTH, HEIGHT); //clear the whole screen before drawing the next
		gsm.draw(g);
	}
	

	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}

	
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
	
}
