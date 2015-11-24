package gui;

import core.Position;

public interface ChessBoardView {

	public void highlightSquare(Position p, boolean on);
	public void moveSquareContent(Position src, Position dest);
	public void removeSquareContent(Position p);
	
}
