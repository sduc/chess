package core;

import java.util.ArrayList;
import java.util.Collection;

public class Pawn extends Piece {

	enum Direction {
		Up(1),
		Down(-1);
		
		private int val;
		
		Direction(int d) {
			val = d;
		}
		
		public int toInt() {
			return val;
		}
	}
	
	private int direction;
	boolean hasMoved = false;
	
	public Pawn(Player o, Position p, ChessBoard b, Direction direction) {
		super(o,p,b);
		this.direction = direction.toInt();
	}

	@Override
	public Collection<Position> possibleMoves() {
		Collection<Position> ret = new ArrayList<>();
		int x = super.position().xOrd();
		int y = super.position().yOrd();
		Board<Piece> board = super.getBoard();
		
		Position p = new Position(x, y + direction);
		if (board.contains(p) && board.get(p) == null)
			ret.add(new Position(x, y + direction));
		
		p = new Position(x + 1, y + direction);
		if (board.contains(p) &&
				board.get(p) != null &&
				!super.sameOwner(board.get(p))) {
			ret.add(p);
		}
		p = new Position(x - 1, y + direction);
		if (board.contains(p) &&
				board.get(p) != null &&
				!super.sameOwner(board.get(p))) {
			ret.add(p);
		}
		// TODO: add prise en passant, first move (2 positions forward
		
		if (!hasMoved) {
			
		}
		
		return ret;
	}
	
	@Override
	public Move move(Position p) throws IllegalMoveException {
		hasMoved = true;
		return super.move(p);
	}

}
