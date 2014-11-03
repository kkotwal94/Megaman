package com.karankotwal.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

//main class where we start everything

public class Game {
public static void main(String[] args){
	JFrame frame = new JFrame("MegamanAndroid"); //creates new frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit on close
	frame.setResizable(false); //is it resizable? Hell yea
	frame.setLayout(new BorderLayout());//we will use borderlayout(look up)
	frame.add(new GamePanel(),BorderLayout.CENTER); //add our gamepanel to our borderlayout
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true); //show window
	
}
	
}
