package core;

import java.util.Collection;

import controller.PieceType.PieceEnum;

public class Queen extends Piece {

	public Queen(Player o, Position p, ChessBoard b) {
		super(o,p,b, PieceEnum.QUEEN);
	}

	@Override
	public Collection<Position> possibleMoves() {
		Collection<Position> ret;
		
		ret = super.reachableColRow();
		ret.addAll(super.reachableDiags());
		
		return ret;
	}

}
