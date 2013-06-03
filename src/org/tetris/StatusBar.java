package org.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class StatusBar extends JPanel {
	
	public static final int HEIGHT=30;
	private String message="";
	
	public StatusBar(){
		super();
		this.setPreferredSize(new Dimension(GameBoardModel.BOARDWIDTH,HEIGHT));
		this.setBackground(Color.black);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.green);
		g.drawString(message, 10, 10);
	}
	
	public void showStatusMessage(String message){
		setMessage(message);
		repaint();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
