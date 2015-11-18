package core;

public class GameManager {
	
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
	
	public boolean processTurn(Piece piece, Position pos) throws IllegalMoveException {
		Player player = playerTurn();
		
		player.applyMove(piece, pos, board);
		
		if (isFinished()) {
			// the player that is finished is always the winner by definition
			// TODO: make sure that this is true
			winner = playerTurn();
			return true;
		}
		
		whiteTurn = !whiteTurn;
		
		return false;
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public boolean isFinished() {
		//TODO: check if there is Check mate on the board 
		//      and also need to find a way to get who won
		return false;
	}

}
