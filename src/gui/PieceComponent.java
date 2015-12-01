package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import controller.PieceType;

public class PieceComponent extends JPanel {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int PIECE_SMALL_SZ = 40;
	private static final int PIECE_MEDIUM_SZ = 60;
	private static final int PIECE_LARGE_SZ = 80;

	
	private Image image;
	
	private PieceComponent(Image spriteImg) {
		this.image = spriteImg;
		this.setOpaque(false);
		initSize();
	}
	
	private void initSize() {
		this.setPreferredSize(new Dimension(PIECE_MEDIUM_SZ, PIECE_MEDIUM_SZ));
		this.setMinimumSize(new Dimension(PIECE_SMALL_SZ, PIECE_SMALL_SZ));
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
