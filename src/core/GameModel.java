package core;

public interface GameModel {

	public Player playerTurn();
	public Player winner();
	public boolean isFinished();
	public Piece chessboardContent(Position p) throws PositionOutOfBoundsException;
	public boolean isOwnedByCurrentPlayer(Piece p);
	public boolean movePiece(Piece piece, Position position) throws IllegalMoveException;
	
}
