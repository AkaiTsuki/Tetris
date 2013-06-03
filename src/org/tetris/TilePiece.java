package org.tetris;

import java.awt.Color;

/**
 * @author jiachiliu
 * 
 */
public class TilePiece {

	/**
	 * Stores the basic information of piece,such as color, layout, dimension,
	 * etc.
	 */
	private Piece piece;

	/**
	 * Rotation of the piece
	 */
	private int rotation;

	/**
	 * The number of unit that a piece move in one step
	 */
	private int step;

	/**
	 * The current row that the piece's left-top corner position in
	 */
	private int row;

	/**
	 * The current column that the piece's left-top corner position in
	 */
	private int column;

	public static final int DEFAULT_ROW = 0;
	public static final int DEFAULT_COLUMN = 0;
	public static final int DEFAULT_ROTATION = 0;
	public static final int DEFAULT_STEP = 1;

	public TilePiece(Piece piece, int rotation, int step, int row, int column) {
		super();
		this.piece = piece;
		this.rotation = rotation;
		this.step = step;
		this.row = row;
		this.column = column;
	}

	public TilePiece(Piece piece, int rotation, int step) {
		this(piece, rotation, step, DEFAULT_ROW, DEFAULT_COLUMN);
	}

	public TilePiece(Piece piece, int rotation) {
		this(piece, rotation, DEFAULT_STEP);
	}

	public TilePiece(Piece piece) {
		this(piece, DEFAULT_ROTATION);
	}

	/**
	 * 
	 * @return the new row of the piece after drop
	 */
	public int moveDown() {
		row=row+step;
		return row;
	}
	
	
	
	/**
	 * Move the piece to the left by 1 step
	 * @return the new column of the piece after move
	 */
	public int moveLeft(){
		column-=step;
		return column;
	}
	
	/**
	 * Move the piece to the right by 1 step
	 * @return the new column of the piece after move
	 */
	public int moveRight(){
		column+=step;
		return column;
	}
	
	/**
	 * @return the relative column that at left most of the piece
	 */
	public int getRelativeLeftMostColumn(){
		return piece.getLeftColumn(rotation);
	}
	
	/**
	 * @return the actual column that the left most tile of the piece position in board
	 */
	public int getAbstractLeftMostColumn(){
		return piece.getLeftColumn(rotation)+column;
	}
	
	/**
	 * @return the relative column that at right most of the piece
	 */
	public int getRelativeRightMostColumn(){
		return piece.getRightColumn(rotation);
	}
	
	/**
	 * @return the actual column that the right most tile of the piece position in board
	 */
	public int getAbstractRightMostColumn(){
		return piece.getRightColumn(rotation)+column;
	}
	
	/**
	 * @return the relative row that at top most of the piece
	 */
	public int getRelativeTopMostRow(){
		return piece.getTopRow(rotation);
	}
	
	/**
	 * @return the actual row that the top most tile of the piece position in board
	 */
	public int getAbstractTopMostRow(){
		return piece.getTopRow(rotation)+row;
	}
	
	/**
	 * @return the relative row that at bottom most of the piece
	 */
	public int getRelativeBottomMostRow(){
		return piece.getBottomRow(rotation);
	}
	
	/**
	 * @return the actual row that the bottom most tile of the piece position in board
	 */
	public int getAbstractBottomMostRow(){
		return piece.getBottomRow(rotation)+row;
	}

	/**
	 * Turn the piece in clockwise
	 * 
	 * @return the new rotation
	 */
	public int clockwiseTurn() {
		rotation = (rotation == 3) ? 0 : rotation + 1;
		return rotation;
	}

	/**
	 * Turn the piece in counter-clockwise
	 * 
	 * @return the new rotation
	 */
	public int counterClockwiseTurn() {
		rotation = (rotation == 0) ? 3 : rotation - 1;
		return rotation;
	}

	/**
	 * @param rotation
	 * @return The piece layout from the given rotation
	 */
	public int[] getPieceLayout(int rotation) {
		return piece.getLayout()[rotation];
	}

	/**
	 * @return The piece layout of current rotation
	 */
	public int[] getPieceLayout() {
		return getPieceLayout(rotation);
	}

	/**
	 * @return The background color of the piece
	 */
	public Color getPieceBackgroundColor() {
		return piece.getBack();
	}

	/**
	 * @return The border color of each tile in this piece
	 */
	public Color getPieceBorderColor() {
		return piece.getBorder();
	}

	/**
	 * @return the dimension of the piece
	 */
	public int getDimension() {
		return piece.getDimension();
	}

	/**
	 * @return the default number of rows that the piece takes in rotation=0
	 */
	public int getDefaultRowCount() {
		return piece.getRows();
	}

	/**
	 * @return the default number of columns that the piece takes in rotation=0
	 */
	public int getDefaultColumnCount() {
		return piece.getCols();
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
