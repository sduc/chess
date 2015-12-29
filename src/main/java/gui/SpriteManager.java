package gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.PieceType;

import core.Color;

public class SpriteManager {
	
	static SpriteManager instance = new SpriteManager();
	
	private static final String SPRITE_PATH = "src/main/resources/Chess_Pieces_Sprite.svg.png";
	private BufferedImage image;
	
	public static final int SPRITE_X_WIDTH = 330;
	public static final int SPRITE_Y_WIDTH = 330;
	
	private static final int KING_X = 0;
	private static final int QUEEN_X = 1;
	private static final int BISHOP_X = 2;
	private static final int KNIGHT_X = 3;
	private static final int ROOK_X = 4;
	private static final int PAWN_X = 5;
	
	private SpriteManager() {
		try {
			image = ImageIO.read(new File(SPRITE_PATH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SpriteManager getInstance() {
		if (instance == null) {
			instance = new SpriteManager();
		}
		return instance;
	}
	
	public Image sprites() {
		return this.image;
	}
	
	/**
	 * Get the sprite x on row y. Technically the first row has all the white sprites and 
	 * row 2 has the black sprites.
	 * 
	 * @param x column number starting from 0
	 * @param y row number starting from 0
	 * @return an image containing the x-th sprint on row y
	 */
	private Image getSpriteAt(int x, int y) {
		return image.getSubimage(
				x*SPRITE_X_WIDTH,
				y*SPRITE_Y_WIDTH,
				SPRITE_X_WIDTH,
				SPRITE_Y_WIDTH);
	}
	
	private Image getSpriteAt(int x, Color c) {
		return getSpriteAt(x, (c == Color.BLACK) ? 1 : 0);
	}
	
	public Image kingSprite(Color c) {
		return getSpriteAt(KING_X, c);
	}
	
	public Image queenSprite(Color c) {
		return getSpriteAt(QUEEN_X, c);
	}
	
	public Image bishopSprite(Color c) {
		return getSpriteAt(BISHOP_X, c);
	}
	
	public Image knightSprite(Color c) {
		return getSpriteAt(KNIGHT_X, c);
	}
	
	public Image rookSprite(Color c) {
		return getSpriteAt(ROOK_X, c);
	}
	
	public Image pawnSprite(Color c) {
		return getSpriteAt(PAWN_X, c);
	}
	
	public Image sprite(PieceType ptype) {
		Color c = ptype.color;
		switch(ptype.enumerate) {
		case BISHOP:
			return bishopSprite(c);
		case KING:
			return kingSprite(c);
		case KNIGHT:
			return knightSprite(c);
		case PAWN:
			return pawnSprite(c);
		case QUEEN:
			return queenSprite(c);
		case ROOK:
			return rookSprite(c);
		default:
			assert(false);
			return null;
		}
	}

}
