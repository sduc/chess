package gui;

import javax.swing.JComponent;

import controller.Controller;
import core.Position;

public class ChessBoardComponent extends JComponent implements ChessView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -605242891926388361L;
	
	//gridlayout to lay the square components out
	private SquareComponent [][] board;
	private Controller controller;
	
	public ChessBoardComponent(Controller c) {
		//need a way to init the board
		this.controller = c;
		initBoard();
	}
	
	private void initBoard() {
		//use the controller to get the init config of the board
		//the dim and the pieces positions
	}

	@Override
	public void highlightSquare(Position p, boolean on) {
		board[p.xOrd()][p.yOrd()].highlight(on);
	}

	@Override
	public void moveSquareContent(Position src, Position dest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSquareContent(Position p) {
		// TODO Auto-generated method stub
		
	}

}
