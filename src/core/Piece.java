package core;

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
	
	

}
