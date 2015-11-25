package core;

public interface GameModel {

	public Player playerTurn();
	public Player winner();
	public boolean isFinished();
	public Piece chessboardContent(Position p) throws PositionOutOfBoundsException;
	public boolean isOwnedByCurrentPlayer(Piece p);
	
	/**
	 * Move a piece to a position
	 * 
	 * @param piece Piece to move
	 * @param position Destination
	 * @return The capture piece if there was one, null otherwise.
	 * @throws IllegalMoveException When the move is illegal
	 */
	public Piece movePiece(Piece piece, Position position) throws IllegalMoveException;
	
}
