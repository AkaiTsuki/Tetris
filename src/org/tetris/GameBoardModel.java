package org.tetris;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoardModel {
	/**
	 * The size of a single tile
	 */
	public static final int TILEPIXELS = 24;
	/**
	 * Total number of rows that the piece can be placed in board
	 */
	public static final int GAMEPLAY_ROW_COUNT = 20;
	/**
	 * Total number of columns that the piece can be placed in board
	 */
	public static final int GAMEPLAY_COLUMN_COUNT = 10;

	/**
	 * Total width in pixel that the board takes
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
	 * The places that contains tiles
	 */
	private Tile[][] tiles;

	public GameBoardModel() {
		piece = getRandomPiece();
		nextPiece = getRandomPiece();
		initTiles();
	}

	private void initTiles() {
		tiles = new Tile[GAMEPLAY_ROW_COUNT][GAMEPLAY_COLUMN_COUNT];

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j] = new Tile(true, Tile.BLACK);
			}
		}
	}

	/**
	 * @return a piece randomly chosen from all types.
	 */
	private TilePiece getRandomPiece() {
		Piece p = PieceFactory.getRandomPieceInstance();
		return new TilePiece(p, 0, 1, 0, 4);
	}

	/**
	 * Set the board to empty
	 */
	public void clear() {
		initTiles();
	}
	
	public ArrayList<Integer> clearRows(){
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int r=0;r<GAMEPLAY_ROW_COUNT;r++){
			boolean isFull=true;
			for(int c=0;c<GAMEPLAY_COLUMN_COUNT;c++){
				isFull=!tiles[r][c].isEmpty & isFull;
			}
			if(isFull){
				clearRow(r);
				list.add(r);
			}
		}
		Collections.sort(list);
		return list;
	}
	
	private void clearRow(int row){
		for(int c=0;c<GAMEPLAY_COLUMN_COUNT;c++){
			tiles[row][c].isEmpty=true;
			tiles[row][c].setColor(Tile.BLACK);
		}
	}
	
	private void shiftRows(List<Integer> rowList){
		for(int r: rowList){
			dropRows(r);
		}
	}
	
	private void dropRows(int row){
		for(int r=row-1;r>=0;r--){
			for(int c=0;c<GAMEPLAY_COLUMN_COUNT;c++){
				tiles[r+1][c]=tiles[r][c];
			}
		}
	}

	/**
	 * Move the current piece down by 1 step
	 */
	public int movePieceDown() {
		if (this.isValidAndEmpty(piece.getPiece(),piece.getRow() + piece.getStep(),
				piece.getColumn(),piece.getRotation())) {
			return piece.moveDown();
		} else {
			fill();
			shiftRows(clearRows());
			switchPiece();
			return piece.getRow();
		}
	}
	
	public void drop(){
		while(this.isValidAndEmpty(piece.getPiece(),piece.getRow() + piece.getStep(),
				piece.getColumn(),piece.getRotation())){
			piece.moveDown();
		}
		shiftRows(clearRows());
	}
	
	/**
	 * @return the column that the piece after move left
	 */
	public int movePieceLeft(){
		if(this.isValidAndEmpty(piece.getPiece(),piece.getRow(), piece.getColumn()-piece.getStep(),piece.getRotation()))
			return piece.moveLeft();
		return piece.getColumn();
	}
	
	/**
	 * @return the column that the piece after move right
	 */
	public int movePieceRight(){
		if(this.isValidAndEmpty(piece.getPiece(),piece.getRow(), piece.getColumn()+piece.getStep(),piece.getRotation()))
			return piece.moveRight();
		return piece.getColumn();
	}
	
	public int clockWiseTurn(int rotation){
		return (rotation == 3) ? 0 : rotation + 1;
	}
	
	public int counterClockwiseTurn(int rotation) {
		return (rotation == 0) ? 3 : rotation - 1;
	}
	
	public int turn(boolean clockWise){
		int r;
		if(clockWise)
			r=this.clockWiseTurn(piece.getRotation());
		else
			r=this.counterClockwiseTurn(piece.getRotation());
		if(this.isValidAndEmpty(piece.getPiece(), piece.getRow(), piece.getColumn(), r))
			return piece.clockwiseTurn();
		return piece.getRotation();
	}
	
	/**
	 *  Fill the board with current piece
	 */
	public void fill() {
		int dimension = piece.getDimension();
		int[] layoutArray = piece.getPieceLayout();
		Color bgColor = piece.getPieceBackgroundColor();
		for (int c = 0; c < dimension; c++) {
			for (int r = 0; r < dimension; r++) {
				if (layoutArray[c + r * dimension] == 1) {
					tiles[r + piece.getRow()][c + piece.getColumn()]
							.setColor(bgColor);
					tiles[r + piece.getRow()][c + piece.getColumn()].isEmpty = false;
				}
			}
		}
	}

	/**
	 * @param row
	 * @param col
	 * @return whether the given coordinate is valid to put current piece.
	 */
	public boolean isValidAndEmpty(Piece p,int row, int col,int rotation) {

		if (row + p.getBottomRow(rotation) >= GAMEPLAY_ROW_COUNT
				|| col + p.getRightColumn(rotation) >= GAMEPLAY_COLUMN_COUNT
				|| col + p.getLeftColumn(rotation) < 0)
			return false;

		int dimension = piece.getDimension();
		int[] layoutArray = p.getLayout()[rotation];
		for (int c = 0; c < dimension; c++) {
			for (int r = 0; r < dimension; r++) {
				if (layoutArray[c + r * dimension] == 1
						&& !tiles[r + row][c + col].isEmpty) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Assign next piece to current and generate a new next piece randomly
	 */
	public void switchPiece() {
		piece = nextPiece;
		nextPiece = getRandomPiece();
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

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

}
