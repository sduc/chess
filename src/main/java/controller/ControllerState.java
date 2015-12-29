package controller;

import core.Player;
import core.Position;

public interface ControllerState {
	
	Player player(Controller ctx);

	/**
	 * This depends on the state of the game.
	 * - If nothing selected we must update the view to highlight the possible moves
	 * - If a piece is selected we either move to p if possible, unselect if clicked 
	 *   on an empty unaccessible area
	 * - If another piece owned is at p, highlight for that new piece
	 * 
	 * @param p Position of the square selected
	 */
	void selectSquare(Controller ctx, Position p) throws IllegalSelectionException;

}
