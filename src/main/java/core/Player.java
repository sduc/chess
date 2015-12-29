package core;

import java.util.ArrayList;
import java.util.Collection;

public class Player {
	
	private String name;
	private Color color;
	private Collection<Piece> cemetry = new ArrayList<>();
	private Collection<Piece> pieces = new ArrayList<>();
	private Piece kingPointer;
	private Player adv = null;

	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
		this.adv = null;
	}

	public void setAdversary(Player adv) {
		this.adv = adv;
	}
	
	public String name() {
		return name;
	}
	
	public void initPieces(ChessBoard b) {
		PieceFactory factory = new PieceFactory(this, b);
		pieces = factory.buildAllPieces();
		for (Piece p : this.pieces) {
			b.putPiece(p);
		}
		kingPointer = factory.getKingPointer();
	}
	
	public Collection<Piece> getAlivePieces() {
		return this.pieces;
	}
	
	public Collection<Piece> getDeadPieces() {
		return this.cemetry;
	}

	public Color getColor() {
		return this.color;
	}
	
	private boolean isPlayerMoveValid(Piece p, Position pos, ChessBoard b) {
		if (p == null || pos == null || b == null)
			return false;
		return p.possibleMoves().contains(pos);
	}
	
	public void movePieceToCemetry(Piece dead) {
		if (dead != null && cemetry != null && pieces != null) {
			if (pieces.contains(dead)) {
				pieces.remove(dead);
				cemetry.add(dead);
			}
		}
	}

	public boolean isCheck() {
		return false;
	}

	public boolean isCheckMate() {
		return isCheck() && hasPossibleMove();
	}

	private boolean hasPossibleMove() {
		//TODO:
		return true;
	}

	public Player getAdversary() {
		return this.adv;
	}

	public boolean isPositionAttacked(Position pos) {
		//forall piece in adversary. if piece.possiblemove.contains this.position
		for (Piece p : getAdversary().getAlivePieces()) {
			if (p.reachablePositions().contains(pos)) {
				return true;
			}
		}
		return false;
	}

}
