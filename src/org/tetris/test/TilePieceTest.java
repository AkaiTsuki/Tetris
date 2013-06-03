package org.tetris.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.tetris.Piece;
import org.tetris.TilePiece;

public class TilePieceTest {
	
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testMoveDown() {
		/*
		TilePiece piece=new TilePiece(Piece.PieceI,0,1,18,5);
		int r=piece.moveDown(20);
		assertEquals(19,r);
		r=piece.moveDown(20);
		assertEquals(19,r);
		
		piece=new TilePiece(Piece.PieceI);
		r=piece.moveDown(20);
		assertEquals(1,r);
		*/
	}
	
	@Test
	public void testGetLeftMostColumn(){
		TilePiece piece=new TilePiece(Piece.PieceI);
		int c=piece.getAbstractLeftMostColumn();
		assertEquals(0,c);
		
		piece=new TilePiece(Piece.PieceI,1);
		c=piece.getAbstractLeftMostColumn();
		assertEquals(1,c);
		
		piece=new TilePiece(Piece.PieceL,1,1,0,5);
		c=piece.getAbstractLeftMostColumn();
		assertEquals(6,c);
		
	}
	
	@Test
	public void testGetRightMostColumn(){
		TilePiece piece=new TilePiece(Piece.PieceI);
		int c=piece.getAbstractRightMostColumn();
		assertEquals(3,c);
		
		piece=new TilePiece(Piece.PieceI,1);
		c=piece.getAbstractRightMostColumn();
		assertEquals(1,c);
		
		piece=new TilePiece(Piece.PieceL,1,1,0,5);
		c=piece.getAbstractRightMostColumn();
		assertEquals(7,c);
	}
	
	@Test
	public void testGetTopMostRow(){
		TilePiece piece=new TilePiece(Piece.PieceI);
		int c=piece.getAbstractTopMostRow();
		assertEquals(1,c);
		
		piece=new TilePiece(Piece.PieceI,1);
		c=piece.getAbstractTopMostRow();
		assertEquals(0,c);
		
		piece=new TilePiece(Piece.PieceL,2,1,10,5);
		c=piece.getAbstractTopMostRow();
		assertEquals(10,c);
	}
	
	@Test
	public void testGetBottomMostRow(){
		TilePiece piece=new TilePiece(Piece.PieceI);
		int c=piece.getAbstractBottomMostRow();
		assertEquals(1,c);
		
		piece=new TilePiece(Piece.PieceI,1);
		c=piece.getAbstractBottomMostRow();
		assertEquals(3,c);
		
		piece=new TilePiece(Piece.PieceL,2,1,10,5);
		c=piece.getAbstractBottomMostRow();
		assertEquals(11,c);
	}

	@Test
	public void testClockwiseTurn() {
		TilePiece piece=new TilePiece(Piece.PieceI);
		int r=piece.clockwiseTurn();
		assertEquals(1,r);
		
		piece=new TilePiece(Piece.PieceI,3);
		r=piece.clockwiseTurn();
		assertEquals(0,r);
	}
	
	

	@Test
	public void testCounterClockwiseTurn() {
		TilePiece piece=new TilePiece(Piece.PieceI);
		int r=piece.counterClockwiseTurn();
		assertEquals(3,r);
		
		piece=new TilePiece(Piece.PieceI,2);
		r=piece.counterClockwiseTurn();
		assertEquals(1,r);
	}
	/*
	@Test
	public void testGetLayoutInTwoDimension(){
		TilePiece piece=new TilePiece(Piece.PieceI);
		int[][] layout=piece.getLayoutInTwoDimension();
		int[][] expect={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}};
		
		for(int i=0;i<expect.length;i++){
			for(int j=0;j<expect[0].length;j++)
				assertEquals(expect[i][j],layout[i][j]);
		}	
	}
	*/
}
