package core;

import java.util.Collection;

public class Rook extends Piece {

	public Rook(Player o, Position p, ChessBoard b) {
		super(o,p,b);
	}

	@Override
	public Collection<Position> possibleMoves() {
		return super.reachableColRow();
	}

}
