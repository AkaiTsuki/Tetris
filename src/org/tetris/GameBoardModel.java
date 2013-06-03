package org.tetris;

import java.util.ArrayList;

public class GameBoardModel {
	/**
	 *  The size of a single tile
	 */
	public static final int TILEPIXELS = 24;
	/**
	 *  Total number of rows that the piece can be placed in board
	 */
	public static final int GAMEPLAY_ROW_COUNT = 20;
	/**
	 * Total number of columns that the piece can be placed in board
	 */
	public static final int GAMEPLAY_COLUMN_COUNT = 10;
	
	/**
	 *  Total width in pixel that the board takes
	 */
	public static final int BOARDWIDTH = TILEPIXELS * GAMEPLAY_COLUMN_COUNT;
	/**
	 * Total height in pixel that the board takes
	 */
	public static final int BOARDHEIGHT = TILEPIXELS * GAMEPLAY_ROW_COUNT;
	
	/**
	 * Current piece that is dropping in the board
	 */
	private TilePiece piece;
	
	/**
	 * Next piece that will be dropped in board
	 */
	private TilePiece nextPiece;
	
	/**
	 * The rotation of current piece
	 */
	private int rotation;
	
	/**
	 *  The places that contains tiles
	 */
	private ArrayList<TilePiece> pieces;
	
	public GameBoardModel(){
		piece=getRandomPiece();
		nextPiece=getRandomPiece();
	}
	
	/**
	 * @return a piece randomly chosen from all types.
	 */
	private TilePiece getRandomPiece(){	
		Piece p=PieceFactory.getRandomPieceInstance();
		return new TilePiece(p,0,1,0,4);
	}
	
	/**
	 *  Set the board to empty
	 */
	public void clear(){
		pieces=new ArrayList<TilePiece>();
	}
	
	/**
	 *  Assign next piece to current and generate a new next piece randomly
	 */
	public void switchPiece(){
		piece=nextPiece;
		nextPiece=getRandomPiece();
	}

	public TilePiece getPiece() {
		return piece;
	}

	public void setPiece(TilePiece piece) {
		this.piece = piece;
	}

	public TilePiece getNextPiece() {
		return nextPiece;
	}

	public void setNextPiece(TilePiece nextPiece) {
		this.nextPiece = nextPiece;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public ArrayList<TilePiece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<TilePiece> pieces) {
		this.pieces = pieces;
	}

	
	
	
	
}
