package controller;

import gui.ChessView;
import core.GameModel;
import core.Position;


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
		// TODO Auto-generated constructor stub
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

}
