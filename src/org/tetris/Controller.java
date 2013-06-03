package org.tetris;

import java.util.ArrayList;

public interface Controller {
	/**
	 * @param clockwise
	 * The turn action response for user's input
	 * @return the new rotation of the piece
	 */
	public int turn(boolean clockwise);
	
	/**
	 * @return the gameBoard data model
	 */
	public GameBoardModel getBoardModel();
	/**
	 *  Force to render the ui
	 */
	public void update();
	/**
	 * @return the current dropping piece
	 */
	public TilePiece getCurrentPiece();
	/**
	 * @return the interval time of dropping
	 */
	public int getTimeInterval();
	/**
	 * @return the new column of the piece after a left move
	 */
	public int leftMove();
	public int rightMove();
	public ArrayList<TilePiece> listAllPieces();
	
}
