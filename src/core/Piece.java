package core;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Piece {
	
	private Player owner;
	private Position position;
	private ChessBoard board;
	
	public Piece(Player owner, Position p, ChessBoard board) {
		this.owner = owner;
		this.position = p;
		this.board = board;
	}
	
	public Move move(Position p) throws IllegalMoveException {
		if (!possibleMoves().contains(p)) {
			throw new IllegalMoveException();
		}
		
		Piece captured = toCapture(p);
		captured.capture();
		
		Move ret = new Move(this.owner, this.position, p, this, captured);

		this.position = p;
		return ret;
	}
	
	private Piece toCapture(Position p) {
		return board.get(p);
	}

	public abstract Collection<Position> possibleMoves();
	
	public Position position() {
		return this.position;
	}
	
	public Board<Piece> getBoard() {
		return this.board;
	}
	
	public void removeFromBoard() {
		if (position != null)
			board.set(position, null);
		position = null;
	}
	public void capture() {
		if (position != null) {
			this.removeFromBoard();
			this.owner.movePieceToCemetry(this);
		}
	}
	
	public Collection<Position> reachableDiags() {
		Collection<Position> ret = new ArrayList<>();
		int thisX = position().xOrd();
		int thisY = position().yOrd();
		
		/* first diagonal */
		for (int x = thisX + 1, y = thisY + 1;
				x < ChessBoard.SIZE && y < ChessBoard.SIZE;
				x++, y++) {
			Position tmp = new Position(x,y);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		for (int x = thisX - 1, y = thisY - 1;
				x >= 0 && y >= 0;
				x--, y--) {
			Position tmp = new Position(x,y);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		/* second diagonal */
		for (int x = thisX - 1, y = thisY + 1;
				x >= 0 && y < ChessBoard.SIZE;
				x--, y++) {
			Position tmp = new Position(x,y);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		for (int x = thisX + 1, y = thisY - 1;
				x < ChessBoard.SIZE && y >= 0;
				x++, y--) {
			Position tmp = new Position(x,y);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		return ret;
	}
	
	public boolean sameOwner(Piece other) {
		if (other == null)
			return false;
		return owner.equals(other.owner);
	}
	
	private boolean isNonEmptyAndAddExceptIfSelfOwned(Collection<Position> c, Position p) {
		Piece occup = getBoard().get(p);
		if (occup != null) {
			/* if the piece occupying is not from the same player */
			if (!sameOwner(occup)) {
				c.add(p);
			}
			return true;
		}
		c.add(p);
		return false;
	}
	
	public Collection<Position> reachableColRow() {
		Collection<Position> ret = new ArrayList<>();
		int thisX = position().xOrd();
		int thisY = position().yOrd();
		
		/* first diagonal */
		for (int x = thisX + 1;
				x < ChessBoard.SIZE;
				x++) {
			Position tmp = new Position(x,thisY);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		for (int x = thisX - 1;
				x >= 0;
				x--) {
			Position tmp = new Position(x,thisY);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		/* second diagonal */
		for (int y = thisY + 1;
				y < ChessBoard.SIZE;
				y++) {
			Position tmp = new Position(thisX,y);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		for (int y = thisY - 1;
				y >= 0;
				y--) {
			Position tmp = new Position(thisX,y);
			if(isNonEmptyAndAddExceptIfSelfOwned(ret, tmp))
				break;
		}
		return ret;
	}

}