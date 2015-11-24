package controller;

import core.Player;
import core.Position;

public class WonControllerState implements ControllerState {

	@Override
	public Player player(Controller ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectSquare(Controller ctx, Position p) {
		// TODO: but should not do anything here as the game is finished
	}

}
