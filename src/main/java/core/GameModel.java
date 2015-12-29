package core;

public interface GameModel {

	void init();
	Player playerTurn();
	Player winner();
	boolean isGameFinished();
	Piece chessboardContent(Position p) throws PositionOutOfBoundsException;
	boolean isOwnedByCurrentPlayer(Piece p);
	int chessBoardSize();
	void changePlayer();
	
	/**
	 * Move a piece to a position
	 * 
	 * @param piece Piece to move
	 * @param position Destination
	 * @return The capture piece if there was one, null otherwise.
	 * @throws IllegalMoveException When the move is illegal
	 */
	Piece movePiece(Piece piece, Position position) throws IllegalMoveException;
	
}
