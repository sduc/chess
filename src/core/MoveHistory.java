package core;

import java.util.ArrayList;
import java.util.List;

public class MoveHistory {

	List<Move> hist = new ArrayList<>();
	
	public void logMove(Move m) {
		hist.add(m);
	}
	
	/**
	 * FIXME: this allows someone to modify the history without using the API.
	 * Might want to change this
	 * 
	 * @return
	 */
	public List<Move> getFullHistory() {
		return this.hist;
	}
	
}
