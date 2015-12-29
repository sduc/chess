package core;

import java.util.Collection;

import controller.PieceType.PieceEnum;

public class Rook extends Piece {

	public Rook(Player o, Position p, ChessBoard b) {
		super(o,p,b, PieceEnum.ROOK);
	}

	@Override
	public Collection<Position> reachablePositions() {
		return super.reachableColRow();
	}

}
