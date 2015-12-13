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

	private java.awt.Color color;
	
	public SquareComponent(Position p, Color c) {
		piece = null;
		position = p;

		init(c);
	}
	
	private void init(Color c) {
		switch (c) {
		case BLACK:
			this.color = java.awt.Color.GRAY;
			break;

		case WHITE:
			this.color = java.awt.Color.WHITE;
			break;
			
		default:
			assert(false);
		}
		this.setBackground(this.color);
	}
	
	public void setPiece(PieceComponent pc) {
		System.out.println("set piece" + pc);
		piece = pc;
		if (pc != null) {
			this.add(pc);
		} else {
			this.removeAll();
		}
		this.revalidate();
		
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

	private void updateColor(boolean on) {
		if (on) {
			this.setBackground(java.awt.Color.CYAN);
		} else {
			this.setBackground(this.color);
		}
	}

	public void highlight(boolean on) {
		if (piece != null)
			piece.highlight(on);
        updateColor(on);
		this.repaint();
	}

	public Position getPosition() {
		return position;
	}
	
}
