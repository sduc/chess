package main;

import gui.ChessBoardComponent;
import gui.MainWindow;
import controller.Controller;
import core.GameManager;
import core.GameModel;

public class Main {
	
	public static void main(String[] args) {
		GameModel model = new GameManager();
		ChessBoardComponent view = new ChessBoardComponent();
		Controller ctr = new Controller(model, view);
		view.setController(ctr);
		view.initGame();
		MainWindow mFrame = new MainWindow(view);
	}

}
