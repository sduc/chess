package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.PieceType;

public class PieceComponent extends JPanel {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	
	private Image image;
	
	private PieceComponent(Image spriteImg) {
		this.image = spriteImg;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	public void highlight(boolean on) {
		this.repaint();
	}

	public static PieceComponent createPiece(PieceType piece) {
		return new PieceComponent(SpriteManager.getInstance().sprite(piece));
	}


}
