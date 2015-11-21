package core;

import java.util.ArrayList;
import java.util.Collection;

public class Knight extends Piece {

	public Knight(Player o, Position p, ChessBoard b) {
		super(o,p,b);
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public Collection<Position> possibleMoves() {
		Collection<Position> ret = new ArrayList<>();
		int x = super.position().xOrd();
		int y = super.position().yOrd();
		
		addInCollectionIfValid(ret, new Position(x + 1, y + 2));
		addInCollectionIfValid(ret, new Position(x - 1, y + 2));
		addInCollectionIfValid(ret, new Position(x + 1, y - 2));
		addInCollectionIfValid(ret, new Position(x - 1, y - 2));
		
		addInCollectionIfValid(ret, new Position(x + 2, y + 1));
		addInCollectionIfValid(ret, new Position(x + 2, y - 1));
		addInCollectionIfValid(ret, new Position(x - 2, y + 1));
		addInCollectionIfValid(ret, new Position(x - 2, y - 1));
		return ret;
	}

}
