package core;

import java.util.ArrayList;
import java.util.Collection;

public class Bishop extends Piece {

	public Bishop(Player o, Position p, ChessBoard b) {
		super(o,p,b);
	}

	@Override
	public Collection<Position> possibleMoves() {
		Collection<Position> ret = new ArrayList<>();
		int thisX = super.position().xOrd();
		int thisY = super.position().yOrd();
		
		/* first diagonal */
		for (int x = thisX + 1, y = thisY + 1;
				x < ChessBoard.SIZE && y < ChessBoard.SIZE;
				x++, y++) {
			Position tmp = new Position(x,y);
			ret.add(tmp);			
			if (super.getBoard().get(tmp) != null)
				break;
		}
		for (int x = thisX - 1, y = thisY - 1;
				x >= 0 && y >= 0;
				x--, y--) {
			Position tmp = new Position(x,y);
			ret.add(tmp);
			if (super.getBoard().get(tmp) != null)
				break;
		}
		/* second diagonal */
		for (int x = thisX - 1, y = thisY + 1;
				x >= 0 && y < ChessBoard.SIZE;
				x--, y++) {
			Position tmp = new Position(x,y);
			ret.add(tmp);			
			if (super.getBoard().get(tmp) != null)
				break;
		}
		for (int x = thisX + 1, y = thisY - 1;
				x < ChessBoard.SIZE && y >= 0;
				x++, y--) {
			Position tmp = new Position(x,y);
			ret.add(tmp);
			if (super.getBoard().get(tmp) != null)
				break;
		}
		return ret;
	}

}
