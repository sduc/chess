package controller;

import java.util.Collection;

import core.IllegalMoveException;
import core.Piece;
import core.Player;
import core.Position;

public class PlayerSelectionControllerState implements ControllerState {

	private Piece selected;
	private Collection<Position> possibleMoves;
	
	public PlayerSelectionControllerState(Piece selected, Collection<Position> possibleMoves) {
		this.selected = selected;
		this.possibleMoves = possibleMoves;
	}
	
	@Override
	public Player player(Controller ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void unhighlightPositions(Controller ctx, Position src, Collection<Position> dests) {
		ctx.view().highlightSquare(src, false);
		for (Position position : dests) {
			ctx.view().highlightSquare(position, false);
		}
	}

	@Override
	public void selectSquare(Controller ctx, Position p) throws IllegalSelectionException {
		unhighlightPositions(ctx, selected.position(), possibleMoves);
		if (possibleMoves.contains(p)) {
			try {
				ctx.model().movePiece(selected, p);
			} catch (IllegalMoveException e) {
				throw new IllegalSelectionException();
			}
			ctx.view().moveSquareContent(selected.position(), p);
			ctx.setState(new PlayerMovedControllerState());
		} else {
			ctx.setState(new PlayerNoSelectionControllerState());
		}
	}

}
