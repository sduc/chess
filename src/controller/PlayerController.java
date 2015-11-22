package controller;

import core.Move;
import core.Player;

public interface PlayerController {
	
	public Player getPlayer();

	public Move getNextMove();

}
