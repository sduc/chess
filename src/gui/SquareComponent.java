package gui;

import javax.swing.JPanel;

public class SquareComponent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091470636175805765L;
	
	private PieceComponent piece;
	
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
	
}
