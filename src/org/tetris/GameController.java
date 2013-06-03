package org.tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;


/**
 * @author jiachiliu
 *
 */
public class GameController implements Controller {

	private GameBoardModel gameBoardModel;
	private JFrame root;
	private int timeInterval=300;
	private Timer droppingTimer;
	
	public GameController(){
		gameBoardModel = new GameBoardModel();
		root = new MainFrame(this);
		droppingTimer=new Timer(timeInterval,new DroppingTimerAction());
		droppingTimer.start();
	}
	
	public static void main(String[] args) {
		new GameController();
	}

	@Override
	public int turn(boolean clockwise) {
		if (clockwise)
			return gameBoardModel.getPiece().clockwiseTurn();
		else
			return gameBoardModel.getPiece().counterClockwiseTurn();
	}
	
	@Override
	public int leftMove() {
		return gameBoardModel.getPiece().moveLeft();
	}
	
	@Override
	public int rightMove() {
		return gameBoardModel.getPiece().moveRight();
	}

	@Override
	public void update() {
		root.repaint();
	}

	@Override
	public GameBoardModel getBoardModel() {
		return this.gameBoardModel;
	}

	@Override
	public TilePiece getCurrentPiece() {
		return gameBoardModel.getPiece();
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	class DroppingTimerAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(gameBoardModel.getPiece().isAtBottom(GameBoardModel.GAMEPLAY_ROW_COUNT)){
				gameBoardModel.switchPiece();
			}else{
				gameBoardModel.getPiece().moveDown(GameBoardModel.GAMEPLAY_ROW_COUNT);
			}		
		}
		
	}

	@Override
	public ArrayList<TilePiece> listAllPieces() {
		return gameBoardModel.getPieces();
	}

	
	
}