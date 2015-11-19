package core;

import java.util.Collection;

public class Bishop extends Piece {

	public Bishop(Player o, Position p, ChessBoard b) {
		super(o,p,b);
	}

	@Override
	public Collection<Position> possibleMoves() {
		return super.reachableDiags();
	}

}
