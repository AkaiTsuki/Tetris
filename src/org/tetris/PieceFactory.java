package org.tetris;

import java.util.Random;

public class PieceFactory {
	/**
	 * @param type: the type of piece.
	 * @return The piece that type specified.
	 * @throws PieceIllegalPieceTypeException
	 */
	public static Piece getPieceInstance(int type) throws PieceIllegalPieceTypeException{
		switch(type){
			case Piece.PIECE_I: return Piece.PieceI;
			case Piece.PIECE_J: return Piece.PieceJ;
			case Piece.PIECE_L: return Piece.PieceL;
			case Piece.PIECE_S: return Piece.PieceS;
			case Piece.PIECE_Z: return Piece.PieceZ;
			case Piece.PIECE_O: return Piece.PieceO;
			case Piece.PIECE_T: return Piece.PieceT;
			default: throw new PieceIllegalPieceTypeException("The input type is not existed!");
		}
	}
	
	/**
	 * @return a Piece that randomly picked from all possible types.
	 */
	public static Piece getRandomPieceInstance(){
		Random r=new Random(System.nanoTime());
		int type=r.nextInt(Piece.TOTAL_TYPE);
		Piece p;
		try {
			p = getPieceInstance(type);
			return p;
		} catch (PieceIllegalPieceTypeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static class PieceIllegalPieceTypeException extends Exception{
		public PieceIllegalPieceTypeException(String msg){
			super(msg);
		}
	}
}
