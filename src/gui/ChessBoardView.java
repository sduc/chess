package gui;

import core.Position;

public interface ChessBoardView {

	// TODO: Maybe we also want to use a state for holding the different views.
	// Or we need some way to change view. Between the main board view, the winning view
	// The menu view ,...
	public void highlightSquare(Position p, boolean on);
	public void moveSquareContent(Position src, Position dest);
	public void removeSquareContent(Position p);
	
}
