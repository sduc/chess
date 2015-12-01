package controller;

import gui.ChessView;
import core.GameModel;
import core.Piece;
import core.Position;
import core.PositionOutOfBoundsException;


public class Controller {
	
	/**
	private final static PlayerNoSelectionControllerState NO_SELECTION_STATE
		= new PlayerNoSelectionControllerState();
	private final static PlayerMovedControllerState MOVED_STATE
		= new PlayerMovedControllerState();
	**/
	
	private ControllerState state;
	
	private GameModel model;
	
	private ChessView view;
	
	public Controller() {
		model = null;
		view = null;
		state = initState();
	}
	
	private ControllerState initState() {
		return new PlayerNoSelectionControllerState();
	}

	public Controller(GameModel model, ChessView view) {
		this.model = model;
		this.view = view;
		this.state = initState();
	}
	
	public void setModel(GameModel model) {
		this.model = model;
	}
	
	public void setView(ChessView view) {
		this.view = view;
	}
	
	public GameModel model() {
		return this.model;
	}
	
	public ChessView view() {
		return this.view;
	}
	
	public void setState(ControllerState nextState) {
		state = nextState;
	}
	
	public void selectSquare(Position p) throws IllegalSelectionException {
		state.selectSquare(this, p);
	}
	
	public void initGame() {
		model.init();
		boardPopulate();
	}
	
	public void boardPopulate() {
		for (int i = 0; i < model.chessBoardSize(); i++) {
			for (int j = 0; j < model.chessBoardSize(); j++) {
				Piece p = null;
				try {
					p = model.chessboardContent(new Position(i,j));
				} catch (PositionOutOfBoundsException e) {
					assert(false);
				}
				if (p != null) {
					view.setSquareContent(p.position(), p.toPieceType());
				}
			}
			
		}
	}

}
