package gui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import controller.Controller;
import controller.IllegalSelectionException;
import controller.PieceType;
import core.ChessBoard;
import core.Color;
import core.Position;

public class ChessBoardComponent extends JComponent implements ChessView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -605242891926388361L;
	private static final int GAP = 1;
	private static final int SMALL_SZ = 400;
	private static final int MEDIUM_SZ = 800;
	private static final int LARGE_SZ = 1000;
	
	private SquareComponent [][] board;
	private Controller controller = null;
	
	public ChessBoardComponent(Controller c) {
		this.controller = c;
		init();
	}
	
	public ChessBoardComponent() {
		init();
	}
	
	private void init() {
		initSize();
		initBoard();
		initLayout();
		initListener();
	}
	
	private void initSize() {
		this.setSize(MEDIUM_SZ, MEDIUM_SZ);
	}
	
	private void initBoard() {
		//use the controller to get the init config of the board
		board = new SquareComponent[ChessBoard.SIZE][ChessBoard.SIZE];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new SquareComponent(
									new Position(i,j),
									((i+j) % 2 == 0) ? Color.BLACK : Color.WHITE);
			}
		}

	}
	
	private void initLayout() {
		//the dim and the pieces positions
		GridLayout boardLayout = new GridLayout(ChessBoard.SIZE, ChessBoard.SIZE);
		boardLayout.setHgap(ChessBoardComponent.GAP);
		boardLayout.setVgap(ChessBoardComponent.GAP);
		this.setLayout(boardLayout);
		for (int i = 0; i < ChessBoard.SIZE; i++) {
			for (int j = 0; j < ChessBoard.SIZE; j++) {
				this.add(this.getSquare(new Position(i,j)));
			}
		}
	}
	
	public void populateBoard() {
		controller.queryBoardPopulate();
	}
	
	private void initListener() {
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				JComponent comp = (JComponent) getComponentAt(e.getPoint());
				if (comp == null || comp == ChessBoardComponent.this) {
					return;
				}
				try {
					controller.selectSquare(((SquareComponent)comp).getPosition());
				} catch (IllegalSelectionException e1) {
					//Do nothing
				}
			}
		});
	}
	
	private SquareComponent getSquare(Position p) {
		return board[p.xOrd()][p.yOrd()];
	}

	@Override
	public void highlightSquare(Position p, boolean on) {
		getSquare(p).highlight(on);
	}

	@Override
	public void moveSquareContent(Position src, Position dest) {
		getSquare(dest).setPiece(getSquare(src).getPiece());
		removeSquareContent(src);
	}

	@Override
	public void removeSquareContent(Position p) {
		getSquare(p).setPiece(null);
	}

	@Override
	public void setController(Controller c) {
		this.controller = c;
	}

	@Override
	public void setSquareContent(Position p, PieceType piece) {
		getSquare(p).setPiece(PieceComponent.createPiece(piece));
	}

}
