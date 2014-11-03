package com.karankotwal.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.karankotwal.game.GamePanel;

public class MenuState extends GameState {

	private String[] options = {"Start","Help","Quit"};
	private int currentSelection = 0;
	
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	
	public void init() {
		
		
	}

	
	public void tick() {
		
		
	}

	
	public void draw(Graphics g) {
		g.setColor(new Color(50,100,200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection){
				g.setColor(Color.GREEN);
			}
			else{
				g.setColor(Color.WHITE);
			}
			//g.drawLine(GamePanel.WIDTH, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
			g.setFont(new Font("Arial",Font.PLAIN,72));
			g.drawString(options[i], GamePanel.WIDTH /2 - 75, 150 + i * 150);
		}
		
	}

	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){
			currentSelection++;
			if(currentSelection >= options.length) {
				currentSelection = 0;
			}
		}
		else if (k == KeyEvent.VK_UP){
			currentSelection--;
			if (currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		}
		
		if (k == KeyEvent.VK_ENTER){
			if (currentSelection == 0) {
				gsm.states.push(new Level1State(gsm)); //pushes our next state on stack
			}
			else if(currentSelection == 1){
				//help
			}
			else if(currentSelection == 2){
				System.exit(0);
			}
		}
		
	}


	public void keyReleased(int k) {
		
		
	}

}
