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
	
	private void captureInView(Controller ctx, Piece toCapture, Position toCaptPos) {
		if (toCapture != null) {
			ctx.view().removeSquareContent(toCaptPos);
		}
	}

	@Override
	public void selectSquare(Controller ctx, Position p) throws IllegalSelectionException {
		unhighlightPositions(ctx, selected.position(), possibleMoves);
		if (possibleMoves.contains(p)) {
			Piece captured = null;
			try {
				captured = ctx.model().movePiece(selected, p);
			} catch (IllegalMoveException e) {
				throw new IllegalSelectionException();
			}
			
			//TODO: see if we do the capture in the move square content
			captureInView(ctx,captured, p);
			ctx.view().moveSquareContent(selected.position(), p);
			
			if (ctx.model().isFinished()) {
				ctx.setState(new PlayerWonControllerState());
			} else {
				ctx.setState(new PlayerMovedControllerState());
			}
		} else {
			ctx.setState(new PlayerNoSelectionControllerState());
		}
	}

}
