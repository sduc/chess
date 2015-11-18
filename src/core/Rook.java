package core;

import java.util.ArrayList;
import java.util.Collection;

public class Rook extends Piece {

	public Rook(Player o, Position p, ChessBoard b) {
		super(o,p,b);
	}

	@Override
	public Collection<Position> possibleMoves() {
		Collection<Position> ret = new ArrayList<>();
		int thisX = super.position().xOrd();
		int thisY = super.position().yOrd();
		
		/* first diagonal */
		for (int x = thisX + 1;
				x < ChessBoard.SIZE;
				x++) {
			Position tmp = new Position(x,thisY);
			ret.add(tmp);			
			if (super.getBoard().get(tmp) != null)
				break;
		}
		for (int x = thisX - 1;
				x >= 0;
				x--) {
			Position tmp = new Position(x,thisY);
			ret.add(tmp);
			if (super.getBoard().get(tmp) != null)
				break;
		}
		/* second diagonal */
		for (int y = thisY + 1;
				y < ChessBoard.SIZE;
				y++) {
			Position tmp = new Position(thisX,y);
			ret.add(tmp);			
			if (super.getBoard().get(tmp) != null)
				break;
		}
		for (int y = thisY - 1;
				y >= 0;
				y--) {
			Position tmp = new Position(thisX,y);
			ret.add(tmp);
			if (super.getBoard().get(tmp) != null)
				break;
		}
		return ret;
	}

}
