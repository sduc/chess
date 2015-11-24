package core;

public class GameManager implements GameModel {
	
	private Player white;
	private Player black;
	private Player winner = null;
	
	private boolean whiteTurn = true;
	
	private ChessBoard board;
	
	public GameManager() {
		init();
	}
	
	private void init() {
		board = new ChessBoard();
	}
	
	public Player playerTurn() {
		return (whiteTurn) ? white : black;
	}
	
	public boolean movePiece(Piece piece, Position pos) throws IllegalMoveException {
		Player player = playerTurn();
		
		player.applyMove(piece, pos, board);
		
		if (isFinished()) {
			// the player that is finished is always the winner by definition
			// TODO: make sure that this is true
			// TODO: pat, draw,... make sure to handle these using the log history
			winner = playerTurn();
			return true;
		}
		
		whiteTurn = !whiteTurn;
		
		return false;
	}
	
	public Player winner() {
		return winner;
	}
	
	public boolean isFinished() {
		//TODO: check if there is Check mate on the board 
		//      and also need to find a way to get who wan
		return false;
	}

	@Override
	public Piece chessboardContent(Position p) throws PositionOutOfBoundsException {
		return board.get(p);
	}

	@Override
	public boolean isOwnedByCurrentPlayer(Piece p) {
		return p.owner().equals(this.playerTurn());
	}

}
