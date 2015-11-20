package core;

import java.util.Collection;

public class Position {
	
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int xOrd() {
		return this.x;
	}
	
	public int yOrd() {
		return this.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		
		Position other = (Position) obj;
		return this.x == other.x && this.y == other.y;
	}
	
	@Override
	public int hashCode() {
		return x + y*ChessBoard.SIZE;
	}
	
	public <T> boolean isOnBoard(Board<T> b) {
		if (b == null)
			return false;
		return b.contains(this);
	}
	
	public static <T> void addInCollectionIfOnBoard(
			Collection<Position> c,
			Position p,
			Board<T> b) {
		if (c == null || p == null || b == null)
			return;
		if (b.contains(p)) {
			c.add(p);
		}
	}

}
