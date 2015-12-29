package core;

import java.util.ArrayList;
import java.util.Collection;

import controller.PieceType;
import controller.PieceType.PieceEnum;

public abstract class Piece {
	
	private Player owner;
	private Position position;
	private ChessBoard board;
	private PieceEnum enumerate;
	
	public Piece(Player owner, Position p, ChessBoard board, PieceEnum enumerate) {
		this.owner = owner;
		this.position = p;
		this.board = board;
		this.enumerate = enumerate;
	}

	private void moveOnBoard(Position dest) {
		assert(dest != null);

		board.set(this.position, null);
		board.set(dest, this);
	}
	
	public Move move(Position p) throws IllegalMoveException {
		if (!possibleMoves().contains(p)) {
			throw new IllegalMoveException();
		}
		
		Piece captured = this.captures(p);
		if (captured != null)
            captured.capture();
		
		Move ret = new Move(this.owner, this.position, p, this, captured);

		moveOnBoard(p);
		this.position = p;
		return ret;
	}

	/**
	 * This function returns all the reachable positions on the board. This does include places where
	 * the piece is attacked at the destination
	 *
	 * @return
     */
	public abstract Collection<Position> reachablePositions();

	/**
	 * This function returns all the possible moves a piece can do
	 *
	 * @return
     */
	public Collection<Position> possibleMoves() {
		return reachablePositions();
	}
	
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
	
	public boolean sameOwner(Piece other) {
		if (other == null)
			return false;
		return owner.equals(other.owner);
	}
	
	private Piece captures(Position p) {
		
		return board.unsafeGet(p);
	}
	
	private boolean isNonEmptyAndAddExceptIfSelfOwned(Collection<Position> c, Position p) {
		
		Piece occup = board.unsafeGet(p);
		
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
	
	public boolean canBeAt(Position p) {
		if (p == null)
			return false;
		return board.contains(p) && !this.sameOwner(this.captures(p));
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
	
	public void addInCollectionIfValid(Collection<Position> pos, Position p) {
		if (this.canBeAt(p)) {
			pos.add(p);
		}
	}
	
	public Player owner() {
		return this.owner;
	}
	
	public PieceType toPieceType() {
		PieceType ptype = new PieceType();
		ptype.color = this.owner.getColor();
		ptype.enumerate = this.enumerate;
		return ptype;
	}

	public boolean isAttacked() {
		return this.owner().isPositionAttacked(this.position);
	}

}
