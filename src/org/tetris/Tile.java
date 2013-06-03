package org.tetris;

import java.awt.Color;

public class Tile {
	public boolean isEmpty;
	private Color color;
	public static final Color BLACK=Color.black;
	
	public Tile(boolean isEmpty, Color color) {
		super();
		this.isEmpty=isEmpty;
		this.color = color;
	}
	
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
