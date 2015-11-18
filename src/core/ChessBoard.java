package core;

public class ChessBoard implements Board<Piece> {
	
	public static final int SIZE = 8;
	
	private Piece[][] board = new Piece[SIZE][SIZE];
	
	public ChessBoard() {
		init();
	}
	
	private void init() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				board[i][j] = null;
			}
		}
	}
	
	public Piece get(Position p) {
		return board[p.xOrd()][p.yOrd()];
	}

	@Override
	public boolean contains(Position p) {
		return p.xOrd() >= 0 && p.xOrd() < SIZE && 
				p.yOrd() >= 0 && p.yOrd() < SIZE;
	}
	
	public void putPiece(Piece p) {
		Piece boardPiece = get(p.position());
		if (boardPiece != null && boardPiece != p) {
			/*
			 * TODO: either throw an exception or return something else
			 * this means that there is already a piece here therefore we either take it.
			 * Need to find a neat way to implement this.
			 */
		}
		
		set(p.position(), p);
	}

	@Override
	public void set(Position p, Piece piece) {
		if (p != null) {
			this.board[p.xOrd()][p.yOrd()] = piece;
		}
	}
	
	public boolean isMoveLegal(Move m) {
		if (m == null)
			return false;
		if (!this.contains(m.end) || !this.contains(m.start))
			return false;
		
		// TODO: check efficiency here
		return m.movedPiece.possibleMoves().contains(m.end);
	}
}
