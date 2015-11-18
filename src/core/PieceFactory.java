package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceFactory {
	
	private Player owner;
	private ChessBoard board;

	private int mainInitY;

	private int pawnsInitY;

	private static final int LROOK_INIT_X = 0;
	private static final int RROOK_INIT_X = 7;
	
	private static final int LKNIGHT_INIT_X = 1;
	private static final int RKNIGHT_INIT_X = 6;
	
	private static final int LBISHOP_INIT_X = 2;
	private static final int RBISHOP_INIT_X = 5;
	
	private static final int QUEEN_INIT_X = 3;
	private static final int KING_INIT_X = 4;
	
	private static final int MAIN_WHITE_INIT_Y = 0;
	private static final int PAWNS_WHITE_INIT_Y = 1;
	
	private static final int MAIN_BLACK_INIT_Y = ChessBoard.SIZE - 1;
	private static final int PAWNS_BLACK_INIT_Y = ChessBoard.SIZE - 2;
	
	private static final int TOT_NUM_PIECES = ChessBoard.SIZE * 2;
	
	public PieceFactory(Player p, ChessBoard b) {
		this.owner = p;
		this.board = b;
		switch (p.getColor()) {
		case WHITE:
			this.mainInitY = PieceFactory.MAIN_WHITE_INIT_Y;
			this.pawnsInitY = PieceFactory.PAWNS_WHITE_INIT_Y;
			break;
		case BLACK:
			this.mainInitY = PieceFactory.MAIN_BLACK_INIT_Y;
			this.pawnsInitY = PieceFactory.PAWNS_BLACK_INIT_Y;
			break;
		default:
			assert(false);
		}
	}
	
	public Piece buildLeftBishop() {
		return new Bishop(
				this.owner,
				new Position(LBISHOP_INIT_X, this.mainInitY),
				board);
	}
	
	public Piece buildRightBishop() {
		return new Bishop(
				this.owner,
				new Position(RBISHOP_INIT_X, this.mainInitY),
				board);
	}
	
	public Piece buildKing() {
		return new King(
				this.owner,
				new Position(KING_INIT_X, this.mainInitY),
				board);
	}
	
	public Piece buildQueen() {
		return new Queen(
				this.owner,
				new Position(QUEEN_INIT_X, this.mainInitY),
				board);
	}
	
	public Piece buildLeftRook() {
		return new Rook(
				this.owner,
				new Position(LROOK_INIT_X, this.mainInitY),
				board);
	}
	
	public Piece buildRightRook() {
		return new Rook(
				this.owner,
				new Position(RROOK_INIT_X, this.mainInitY),
				board);
	}
	
	public Piece buildLeftKnight() {
		return new Knight(
				this.owner,
				new Position(LKNIGHT_INIT_X, this.mainInitY),
				board);
	}
	
	public Piece buildRightKnight() {
		return new Knight(
				this.owner,
				new Position(RKNIGHT_INIT_X, this.mainInitY),
				board);
	}
	
	public Collection<Piece> buildPawns() {
		List<Piece> pawns = new ArrayList<>(ChessBoard.SIZE);
		for(int x = 0; x < ChessBoard.SIZE; x++) {
			pawns.add(new Pawn(
					this.owner,
					new Position(x, this.pawnsInitY),
					board));
		}
		return pawns;
	}
	
	public Collection<Piece> buildAllPieces() {
		List<Piece> pieces = new ArrayList<>(TOT_NUM_PIECES);
		
		/* main pieces, or first row */
		pieces.add(buildLeftRook());
		pieces.add(buildRightRook());
		pieces.add(buildLeftKnight());
		pieces.add(buildRightKnight());
		pieces.add(buildLeftBishop());
		pieces.add(buildRightBishop());
		pieces.add(buildKing());
		pieces.add(buildQueen());
		
		/* pawns, or second row */
		pieces.addAll(buildPawns());
		
		return pieces;
	}

}
