package core;

public class GameManager implements GameModel {
	
	private Player white;
	private Player black;
	private Player winner = null;
	
	private boolean whiteTurn = true;
	
	private ChessBoard board;
	
	public GameManager() {
		initManager();
	}
	
	private void initManager() {
		board = new ChessBoard();
		white = new Player("White Player", Color.WHITE);
		black = new Player("Black Player", Color.BLACK);
	}
	
	public void init() {
		initManager();
		white.initPieces(board);
		black.initPieces(board);
	}
	
	public Player playerTurn() {
		return (whiteTurn) ? white : black;
	}
	
	public Piece movePiece(Piece piece, Position pos) throws IllegalMoveException {
		Player player = playerTurn();
		
		player.applyMove(piece, pos, board);
		
		if (isCheckMate()) {
			// the player that is finished is always the winner by definition
			// TODO: make sure that this is true
			// TODO: pat, draw,... make sure to handle these using the log history
			winner = playerTurn();
		}
		
		whiteTurn = !whiteTurn;
		
		return null;
	}
	
	private boolean isCheckMate() {
		// TODO Auto-generated method stub
		return false;
	}

	public Player winner() {
		return winner;
	}
	
	public boolean isFinished() {
		return winner != null;
	}

	@Override
	public Piece chessboardContent(Position p) throws PositionOutOfBoundsException {
		return board.get(p);
	}

	@Override
	public boolean isOwnedByCurrentPlayer(Piece p) {
		if (p == null) {
			assert(false);
			return false;
		}
		return p.owner().equals(this.playerTurn());
	}
	
	public int chessBoardSize() {
		return ChessBoard.SIZE;
	}

}
