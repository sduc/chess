package core;

import java.util.ArrayList;
import java.util.Collection;

public class King extends Piece {

	public King(Player o, Position p, ChessBoard b) {
		super(o, p,b);
	}	

	@Override
	public Collection<Position> possibleMoves() {
		Collection<Position> moves = new ArrayList<>();
		int x = super.position().xOrd();
		int y = super.position().yOrd();
		
		addInCollectionIfValid(moves, new Position(x, y - 1));
		addInCollectionIfValid(moves, new Position(x - 1, y - 1));
		addInCollectionIfValid(moves, new Position(x - 1, y));
		addInCollectionIfValid(moves, new Position(x - 1, y + 1));
		addInCollectionIfValid(moves, new Position(x, y + 1));
		addInCollectionIfValid(moves, new Position(x + 1, y + 1));
		addInCollectionIfValid(moves, new Position(x + 1, y - 1));
		addInCollectionIfValid(moves, new Position(x - 1, y + 1));
		
		// check if we can do castling for the king this implies moving more pieces
		
		return moves;
	}

}
