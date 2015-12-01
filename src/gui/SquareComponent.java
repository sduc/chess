package gui;

import javax.swing.JPanel;

import core.Color;
import core.Position;

public class SquareComponent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091470636175805765L;
	
	private PieceComponent piece;
	
	private Position position;
	
	public SquareComponent(Position p, Color c) {
		piece = null;
		position = p;
		
		init(c);
	}
	
	private void init(Color c) {
		switch (c) {
		case BLACK:
			this.setBackground(java.awt.Color.GRAY);
			break;

		case WHITE:
			this.setBackground(java.awt.Color.WHITE);
			break;
			
		default:
			assert(false);
		}
	}
	
	public void setPiece(PieceComponent pc) {
		
		if (pc != null) {
			this.add(pc);
		} else {
			this.removeAll();
		}
		
		piece = pc;
		this.repaint();
	}
	
	public PieceComponent getPiece() {
		return piece;
	}
	
	@Override
	public void repaint() {
		super.repaint();
		if (piece != null)
			piece.repaint();
	}

	public void highlight(boolean on) {
		if (piece != null)
			piece.highlight(on);
		//might want to repaint maybe TODO
	}

	public Position getPosition() {
		return position;
	}
	
}
