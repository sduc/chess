package controller;

import java.util.Collection;

import core.Piece;
import core.Player;
import core.Position;
import core.PositionOutOfBoundsException;

public class PlayerNoSelectionControllerState implements ControllerState {

	@Override
	public Player player(Controller ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void highlightPositions(
			Controller ctx,
			Position src,
			Collection<Position> dests) {
		ctx.view().highlightSquare(src, true);
		for (Position position : dests) {
			ctx.view().highlightSquare(position, true);
		}
	}

	@Override
	public void selectSquare(Controller ctx, Position p) throws IllegalSelectionException {
		Piece piece = null;
		
		try {
			piece = ctx.model().chessboardContent(p);
		} catch (PositionOutOfBoundsException e) {
			throw new IllegalSelectionException();
		}
		
		if (ctx.model().isOwnedByCurrentPlayer(piece)) {
			Collection<Position> pos = piece.possibleMoves();
			highlightPositions(ctx, p, pos);
			ctx.setState(new PlayerSelectionControllerState(piece, pos));
		}
		// otherwise we don't do anything
	}

}
