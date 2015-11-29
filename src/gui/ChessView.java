package gui;

import controller.Controller;
import controller.PieceType;
import core.Position;

public interface ChessView {

	// TODO: Maybe we also want to use a state for holding the different views.
	// Or we need some way to change view. Between the main board view, the winning view
	// The menu view ,...
	public void highlightSquare(Position p, boolean on);
	public void moveSquareContent(Position src, Position dest);
	public void removeSquareContent(Position p);
	public void setController(Controller c);
	public void setSquareContent(Position p, PieceType ptype);
	
	/**
	 * This function will populate the chess view with the pieces according to the model.
	 * It will query the controller the populate the board
	 */
	public void populateBoard();
	
}
