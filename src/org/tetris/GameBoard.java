package org.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	static final long serialVersionUID = -3778046223071484370L;
	private Controller control;

	public GameBoard(Controller c) {
		this.control = c;

		this.addMouseListener(new MouseAction());

		// set panel performance
		this.setPreferredSize(new Dimension(GameBoardModel.BOARDWIDTH,
				GameBoardModel.BOARDHEIGHT));
		this.setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoardTiles(g);
		drawPiece(g, control.getCurrentPiece().getColumn(),control.getCurrentPiece().getRow());
		drawGrid(g);
	}

	/**
	 * @param g
	 * @param col
	 *            : the left-most column in board that the piece will use.
	 * @param row
	 *            : the top-most row in board that the piece will use. Draw a
	 * 
	 *            piece in game board where the left-top tile of the piece at
	 *            the position of given row and column parameter.
	 */
	private void drawPiece(Graphics g, int col, int row) {
		int dimension = control.getCurrentPiece().getDimension();
		int[] layoutArray = control.getCurrentPiece().getPieceLayout();
		Color bgColor = control.getCurrentPiece().getPieceBackgroundColor();
		Color borderColor = control.getCurrentPiece().getPieceBorderColor();

		for (int c = 0; c < dimension; c++) {
			for (int r = 0; r < dimension; r++) {
				if (layoutArray[c + r * dimension] == 1) {
					drawTile(g, getXCoordinate(col + c),
							getYCoordinate(row + r), bgColor, borderColor);
				}
			}
		}
	}

	/**
	 * @param g
	 * @param p
	 *            the piece
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	private void drawTile(Graphics g, int x, int y,Color bgColor,Color borderColor) {
		g.setColor(bgColor);
		g.fillRect(x, y, GameBoardModel.TILEPIXELS, GameBoardModel.TILEPIXELS);
		g.setColor(borderColor);
		g.drawRect(x, y, GameBoardModel.TILEPIXELS, GameBoardModel.TILEPIXELS);
	}
	
	private void drawBoardTiles(Graphics g){
		Tile[][] tiles=control.getAllTiles();
		for(int r=0;r<tiles.length;r++){
			for(int c=0;c<tiles[0].length;c++){
				drawTile(g,getXCoordinate(c),getYCoordinate(r),tiles[r][c].getColor(),Color.black);
			}
		}
	}
	
/*
	private void drawBoardBorder(Graphics g) {
		// draw left and right wall
		for (int i = 0; i < GameBoard.BOARD_ROW_COUNT; i++) {
			g.setColor(Color.gray);
			g.fillRect(getXCoordinate(0), getYCoordinate(i), TILEPIXELS,
					TILEPIXELS);
			g.fillRect(getXCoordinate(BOARD_COLUMN_COUNT - 1),
					getYCoordinate(i), TILEPIXELS, TILEPIXELS);
			g.setColor(Color.BLACK);
			g.drawRect(getXCoordinate(0), getYCoordinate(i), TILEPIXELS,
					TILEPIXELS);
			g.drawRect(getXCoordinate(BOARD_COLUMN_COUNT - 1),
					getYCoordinate(i), TILEPIXELS, TILEPIXELS);
		}
		// draw bottom wall
		for (int i = 0; i < GameBoard.BOARD_COLUMN_COUNT; i++) {
			g.setColor(Color.gray);
			g.fillRect(getXCoordinate(i), getYCoordinate(BOARD_ROW_COUNT - 1),
					TILEPIXELS, TILEPIXELS);
			g.setColor(Color.BLACK);
			g.drawRect(getXCoordinate(i), getYCoordinate(BOARD_ROW_COUNT - 1),
					TILEPIXELS, TILEPIXELS);
		}
	}
*/
	/**
	 * @param g
	 *            draw a grid in the center game play field.
	 */
	private void drawGrid(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		float alpha = 0.2f;
		g2.setPaint(new Color(0, 1, 0, alpha));

		for (int row = 0; row < GameBoardModel.GAMEPLAY_ROW_COUNT; row++) {
			for (int col = 0; col < GameBoardModel.GAMEPLAY_COLUMN_COUNT; col++) {
				g2.drawRect(getXCoordinate(col), getYCoordinate(row),
						GameBoardModel.TILEPIXELS, GameBoardModel.TILEPIXELS);
			}
		}
	}

	/**
	 * @param row
	 *            : the row number in board grid.
	 * @return the actual y-coordinate of row.
	 */
	private int getYCoordinate(int row) {
		return row * GameBoardModel.TILEPIXELS;
	}

	/**
	 * @param col
	 *            : the column number in board grid.
	 * @return the actual x-coordinate of column.
	 */
	private int getXCoordinate(int col) {
		return col * GameBoardModel.TILEPIXELS;
	}

	public int getRowFromYCoordinate(int y) {
		return y / GameBoardModel.TILEPIXELS;
	}

	public int getColumnFromXCoordinate(int x) {
		return x / GameBoardModel.TILEPIXELS;
	}

	class MouseAction implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Point p = e.getPoint();
			int row = getRowFromYCoordinate(p.y);
			int col = getColumnFromXCoordinate(p.x);
			String msg = "(" + col + "," + row + ")";
			System.out.println(msg);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
