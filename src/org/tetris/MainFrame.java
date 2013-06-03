package org.tetris;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MainFrame extends JFrame {

	private JPanel gameBoard;
	private static final String TITLE="Tetris";
	private Controller control;
	private Timer timer;
	private static final int FPS=1000/60;
	
	public MainFrame(Controller control){
		super(TITLE);
		this.control=control;
		initComponents();
		timer=new Timer(FPS,new RenderTimerAction());
		timer.start();
	}
	
	private void initComponents(){
		gameBoard = new GameBoard(control);
		this.getContentPane().add(gameBoard,BorderLayout.CENTER);
		
		// set event
		this.addKeyListener(new KeyAction());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	class KeyAction implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_Z) {
				control.turn(false);
			}

			if (e.getKeyCode() == KeyEvent.VK_X) {
				control.turn(true);
			}
			
			if(e.getKeyCode()== KeyEvent.VK_LEFT){
				control.leftMove();
			}
			
			if(e.getKeyCode()== KeyEvent.VK_RIGHT){
				control.rightMove();
			}
			
			control.update();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
	
	class RenderTimerAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
		
	}
	

}
