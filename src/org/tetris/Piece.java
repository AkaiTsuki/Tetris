package org.tetris;

import java.awt.Color;

/**
 * @author jiachiliu Stores all possible pieces for Tetris game.
 */
public enum Piece {

	PieceI(4, 4, 1, Color.RED, Color.BLACK, new int[][] {
			{ 	
				0, 0, 0, 0, 
				1, 1, 1, 1, 
				0, 0, 0, 0, 
				0, 0, 0, 0 
			},
			{ 	
				0, 1, 0, 0,
				0, 1, 0, 0, 
				0, 1, 0, 0,
				0, 1, 0, 0 
			},
			{ 
				0, 0, 0, 0, 
				1, 1, 1, 1,
				0, 0, 0, 0,
				0, 0, 0, 0 
			},
			{ 
				0, 1, 0, 0, 
				0, 1, 0, 0, 
				0, 1, 0, 0, 
				0, 1, 0, 0 
			} }),

	PieceL(3, 3, 2, Color.GREEN, Color.BLACK, new int[][] {
			{ 
				1, 0, 0, 
				1, 1, 1,
				0, 0, 0
			}, 
			{ 
				0, 1, 1,
				0, 1, 0,
				0, 1, 0 
			},
			{ 
				1, 1, 1,
				0, 0, 1,
				0, 0, 0 
			}, 
			{ 
				0, 1, 0,
				0, 1, 0,
				1, 1, 0 
			}}),

	PieceJ(3, 3, 2, Color.BLUE, Color.BLACK, new int[][] {
			{ 0, 0, 1, 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1, 0, 0, 1, 0 } }),

	PieceT(3, 3, 2, Color.CYAN, Color.BLACK, new int[][] {
			{ 1, 1, 1, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0, 1, 0 },
			{ 0, 1, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 1, 0 } }),

	PieceO(2, 2, 2, Color.YELLOW, Color.BLACK, new int[][] { { 1, 1, 1, 1 },
			{ 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }),

	PieceS(3, 3, 2, Color.ORANGE, Color.BLACK, new int[][] {
			{ 0, 1, 1, 1, 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1 },
			{ 0, 1, 1, 1, 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1 } }),

	PieceZ(3, 3, 2, Color.MAGENTA, Color.BLACK, new int[][] {
			{ 1, 1, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 1, 1, 0, 1, 0 },
			{ 1, 1, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 1, 1, 0, 1, 0 } });

	public static final int PIECE_I = 0;
	public static final int PIECE_L = 1;
	public static final int PIECE_J = 2;
	public static final int PIECE_S = 3;
	public static final int PIECE_Z = 4;
	public static final int PIECE_O = 5;
	public static final int PIECE_T = 6;
	public static final int TOTAL_TYPE = 7;
	public static final int ROTAION = 4;
	/**
	 * The dimension of piece, which is consisted by dimension*dimension tiles.
	 */
	private int dimension;

	/**
	 * Number of columns that the piece takes(rotation=0).
	 */
	private int cols;
	/**
	 * Number of rows that the piece takes(rotation=0).
	 */
	private int rows;
	/**
	 * The background color of the piece
	 */
	private Color bgColor;
	/**
	 * The border color of each tile
	 */
	private Color borderColor;
	/**
	 * Stores the layout of a piece. In two dimension array:
	 * layout[rotation][tiles]
	 */
	private int[][] layout;

	private Piece(int dimension, int cols, int rows, Color back, Color border,
			int[][] layout) {
		this.dimension = dimension;
		this.cols = cols;
		this.rows = rows;
		this.bgColor = back;
		this.borderColor = border;
		this.layout = layout;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Color getBack() {
		return bgColor;
	}

	public void setBack(Color back) {
		this.bgColor = back;
	}

	public Color getBorder() {
		return borderColor;
	}

	public void setBorder(Color border) {
		this.borderColor = border;
	}

	public int[][] getLayout() {
		return layout;
	}

	public void setLayout(int[][] layout) {
		this.layout = layout;
	}

	/**
	 * @param rotation
	 *            the rotation of the piece
	 * @return the left most column that the tile position
	 */
	public int getLeftColumn(int rotation) {
		for (int c = 0; c < dimension; c++) {
			for (int r = 0; r < dimension; r++) {		
				if (isTile(rotation,r,c)) {
					return c;
				}
			}
		}
		return -1;
	}

	/**
	 * @param rotation
	 *            the rotation of the piece
	 * @return the right most column that the tile position
	 */
	public int getRightColumn(int rotation) {
		for (int c = dimension - 1; c >= 0; c--) {
			for (int r = 0; r < dimension; r++) {
				if (isTile(rotation,r,c)) {
					return c;
				}
			}
		}
		return -1;
	}
	
	/**
	 * @param rotation the rotation of the piece
	 * @return the top most row that the tile position
	 */
	public int getTopRow(int rotation){
		for(int r=0;r<dimension;r++){
			for(int c=0;c<dimension;c++){
				if (isTile(rotation,r,c)) {
					return r;
				}
			}
		}
		return -1;
	}
	
	/**
	 * @param rotation the rotation of the piece
	 * @return the bottom most row that the tile position
	 */
	public int getBottomRow(int rotation){
		for(int r=dimension-1;r>=0;r--){
			for(int c=0;c<dimension;c++){
				if (isTile(rotation,r,c)) {
					return r;
				}
			}
		}
		return -1;
	}
	
	/**
	 * @param rotation
	 * @param r row number
	 * @param c column number
	 * @return whether the given position in piece is a tile or empty
	 */
	public boolean isTile(int rotation,int r,int c){
		int index = r * dimension + c;
		if(this.layout[rotation][index] == 1)
			return true;
		return false;
	}

}
