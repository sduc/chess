package core;

public class Move {

	Player player;
	Position start;
	Position end;
	Piece movedPiece;
	Piece capturedPiece;
	
	public Move(
			Player 		player,
			Position 	start,
			Position 	end,
			Piece 		piece,
			Piece 		captured) {
		this.player = player;
		this.start = start;
		this.end = end;
		this.movedPiece = piece;
		this.capturedPiece = captured;
	}
	
}
