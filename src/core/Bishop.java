package core;

import java.util.Collection;

import controller.PieceType.PieceEnum;

public class Bishop extends Piece {

	public Bishop(Player o, Position p, ChessBoard b) {
		super(o,p,b, PieceEnum.BISHOP);
	}

	@Override
	public Collection<Position> possibleMoves() {
		return super.reachableDiags();
	}

}
