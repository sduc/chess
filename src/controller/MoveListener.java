package controller;

import core.GameManager;
import core.Move;

public class MoveListener {
	
	private PlayerController whiteController;
	private PlayerController blackController;
	private GameManager gameManager;
	
	public MoveListener(GameManager game) {
		this.gameManager = game;
	}
	
	public void registerPlayerController(PlayerController subj) {
		switch(subj.getPlayer().getColor()) {
		case WHITE:
			whiteController = subj;
			break;
		case BLACK:
			blackController = subj;
			break;
		default:
			assert(false);
		}
	}
	
	public Move getNextMove() {
		Move move = null;
		switch(gameManager.playerTurn().getColor()){
		case WHITE:
			move = whiteController.getNextMove();
			break;
		case BLACK:
			move = blackController.getNextMove();
			break;
		default:
			assert(false);
		}
		return move;
	}

}
