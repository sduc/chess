package controller;

import gui.ChessBoardView;
import core.GameModel;


public class Controller {
	
	private final static PlayerNoSelectionControllerState NO_SELECTION_STATE
		= new PlayerNoSelectionControllerState();
	private final static PlayerMovedControllerState MOVED_STATE
		= new PlayerMovedControllerState();
	
	private ControllerState state;
	
	private GameModel model;
	
	private ChessBoardView view;
	
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public GameModel model() {
		return this.model;
	}
	
	public ChessBoardView view() {
		return this.view;
	}
	
	public void setState(ControllerState nextState) {
		state = nextState;
	}

}
