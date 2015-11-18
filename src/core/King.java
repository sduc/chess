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
		
		Position.addInCollectionIfOnBoard(
				moves, new Position(x, y - 1), super.getBoard());
		Position.addInCollectionIfOnBoard(
				moves, new Position(x - 1, y - 1), super.getBoard());
		Position.addInCollectionIfOnBoard(
				moves, new Position(x - 1, y), super.getBoard());
		Position.addInCollectionIfOnBoard(
				moves, new Position(x - 1, y + 1), super.getBoard());
		Position.addInCollectionIfOnBoard(
				moves, new Position(x, y + 1), super.getBoard());
		Position.addInCollectionIfOnBoard(
				moves, new Position(x + 1, y + 1), super.getBoard());
		Position.addInCollectionIfOnBoard(
				moves, new Position(x + 1, y - 1), super.getBoard());
		Position.addInCollectionIfOnBoard(
				moves, new Position(x - 1, y + 1), super.getBoard());
		
		// check if we can do castling for the king this implies moving more pieces
		
		return moves;
	}

}
