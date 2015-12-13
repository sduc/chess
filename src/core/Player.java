package core;

import java.util.ArrayList;
import java.util.Collection;

public class Player {
	
	private String name;
	private Color color;
	private Collection<Piece> cemetry = new ArrayList<>();
	private Collection<Piece> pieces = new ArrayList<>();

	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
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

}
